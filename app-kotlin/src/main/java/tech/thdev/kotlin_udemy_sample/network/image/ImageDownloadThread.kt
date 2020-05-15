package tech.thdev.kotlin_udemy_sample.network.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.LruCache
import android.widget.ImageView
import androidx.annotation.DrawableRes

import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.URL
import java.net.URLConnection

/**
 * Created by Tae-hwan on 26/10/2016.
 */

object ImageDownloadThread {

    /**
     * LruCache를 사용하여 Image를 캐쉬처리
     */
    private val cache = LruCache<String, WeakReference<Bitmap>>(5 * 1024 * 1024) // 5MiB

    fun loadImage(@DrawableRes loadImage: Int, imageView: ImageView, url: String?) {
        imageView.setImageResource(loadImage)

        url?.let {
            if (cache.get(it) == null || cache.get(it).get() == null) {
                imageView.tag = it
                Thread(DownloadThread(imageView, it)).start()

            } else {
                imageView.setImageBitmap(cache.get(it).get())
            }
        }
    }

    private class DownloadThread(imageView: ImageView, private val resourceUrl: String) : Runnable {

        private val weakReferenceImageView: WeakReference<ImageView>

        private var connection: URLConnection? = null
        private var inputStream: InputStream? = null
        private var bufferedInputStream: BufferedInputStream? = null

        init {
            this.weakReferenceImageView = WeakReference(imageView)
        }

        override fun run() {
            try {
                val url = URL(resourceUrl)
                connection = url.openConnection()
                connection?.connect()

                inputStream = connection?.inputStream
                bufferedInputStream = BufferedInputStream(inputStream)

                cache.put(resourceUrl, WeakReference(BitmapFactory.decodeStream(bufferedInputStream)))
                draw(resourceUrl)

            } catch (e: IOException) {
                closeStream()

            } finally {
                closeStream()
            }
        }

        private fun closeStream() {
            try {
                if (inputStream != null) {
                    inputStream?.close()
                    inputStream = null
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream?.close()
                    bufferedInputStream = null
                }
            } catch (e1: IOException) {
                e1.printStackTrace()
            }

        }

        private fun draw(resourceUrl: String) {
            Handler(Looper.getMainLooper()).post {
                val imageView = weakReferenceImageView.get()
                if (!TextUtils.isEmpty(resourceUrl) &&
                        imageView?.tag != null &&
                        imageView.tag == resourceUrl &&
                        cache.get(resourceUrl) != null &&
                        cache.get(resourceUrl).get() != null) {
                    imageView.setImageBitmap(cache.get(resourceUrl).get())
                }
            }
        }
    }
}
