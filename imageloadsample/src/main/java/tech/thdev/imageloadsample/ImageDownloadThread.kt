package tech.thdev.imageloadsample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.support.annotation.DrawableRes
import android.support.v4.util.LruCache
import android.widget.ImageView
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.URL
import java.net.URLConnection

/**
 * Created by taehwankwon on 05/11/2017.
 */
object ImageDownloadThread {
    /**
     * LruCache를 사용하여 Image를 캐쉬처리
     */
    private val cache = LruCache<String, WeakReference<Bitmap>>(5 * 1024 * 1024) // 5MiB

    fun loadImage(@DrawableRes loadingImageRes: Int, imageView: ImageView, url: String?): Boolean {
        imageView.setImageResource(loadingImageRes)

        url?.let { imageUrl ->
            cache.get(imageUrl)?.get()?.let {
                imageView.setImageBitmap(it)
                return true
            } ?: let {
                imageView.tag = url
                Thread(DownloadThread(imageView, imageUrl)).start()
            }
        }
        return false
    }

    private class DownloadThread(imageView: ImageView, private val resourceUrl: String) : Runnable {

        private val weakReferenceImageView: WeakReference<ImageView> = WeakReference(imageView)

        private var bufferedInputStream: BufferedInputStream? = null

        override fun run() {
            try {
                URL(resourceUrl).run { openConnection() }.run {
                    connect()
                    this@DownloadThread.bufferedInputStream = BufferedInputStream(this.getInputStream())
                }
                val options = BitmapFactory.Options().apply { inSampleSize = 2 }
                cache.put(resourceUrl, WeakReference(BitmapFactory.decodeStream(bufferedInputStream, null, options)))
                draw(resourceUrl)

            } catch (e: IOException) {
                closeStream()

            } finally {
                closeStream()
            }
        }

        private fun closeStream() {
            try {
                bufferedInputStream?.close()
            } catch (e1: IOException) {
                e1.printStackTrace()
            }

        }

        private fun draw(resourceUrl: String) {
            Handler(Looper.getMainLooper()).post {
                weakReferenceImageView.get()?.takeIf { it.tag == resourceUrl }?.let { imageView ->
                    cache.get(resourceUrl)?.get()?.let {
                        imageView.setImageBitmap(it)
                    }
                }
            }
        }
    }
}