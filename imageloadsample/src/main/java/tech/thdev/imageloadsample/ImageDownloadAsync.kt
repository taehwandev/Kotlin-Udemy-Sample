package tech.thdev.imageloadsample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.annotation.DrawableRes
import android.support.v4.util.LruCache
import android.widget.ImageView
import java.io.BufferedInputStream
import java.io.IOException
import java.lang.ref.WeakReference
import java.net.URL

/**
 * Created by taehwankwon on 05/11/2017.
 */
object ImageDownloadAsync {

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
                // 이미지 뷰 동기화를 위해서 tag 추가
                imageView.tag = url
                ImageAsync(imageView).execute(url)
            }
        }
        return false
    }

    private class ImageAsync(imageView: ImageView) : AsyncTask<String, String, String>() {

        private val weakReferenceImageView: WeakReference<ImageView> = WeakReference(imageView)

        internal var bufferedInputStream: BufferedInputStream? = null

        override fun doInBackground(vararg resourceUrl: String): String? {
            try {
                val url = resourceUrl[0]
                URL(url).run { openConnection() }.run {
                    connect()
                    this@ImageAsync.bufferedInputStream = BufferedInputStream(this.getInputStream())
                }
                val options = BitmapFactory.Options().apply { inSampleSize = 2 }
                cache.put(url, WeakReference(BitmapFactory.decodeStream(bufferedInputStream, null, options)))
                return url

            } catch (e: IOException) {
                closeStream()

            } finally {
                closeStream()
            }
            return null
        }

        private fun closeStream() {
            try {
                bufferedInputStream?.close()
            } catch (e1: IOException) {
                e1.printStackTrace()
            }

        }

        override fun onPostExecute(url: String) {
            super.onPostExecute(url)
            if (isCancelled) {
                return
            }
            weakReferenceImageView.get()?.takeIf { it.tag == url }?.let { imageView ->
                cache.get(url)?.get()?.let {
                    imageView.setImageBitmap(it)
                }
            }
        }
    }
}