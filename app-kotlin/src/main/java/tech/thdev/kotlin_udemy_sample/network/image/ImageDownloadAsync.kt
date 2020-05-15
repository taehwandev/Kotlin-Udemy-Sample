package tech.thdev.kotlin_udemy_sample.network.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
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
 * Created by tae-hwan on 10/25/16.
 */

object ImageDownloadAsync {

    /**
     * LruCache를 사용하여 Image를 캐쉬처리
     */
    private val cache = LruCache<String, WeakReference<Bitmap>>(5 * 1024 * 1024) // 5MiB

    fun loadImage(@DrawableRes loadImage: Int, imageView: ImageView, url: String?) {
        url?.let {
            val weakReference = cache.get(url)
            if (weakReference == null || weakReference.get() == null) {
                // 이미지 뷰 동기화를 위해서 tag 추가
                imageView.tag = url

                imageView.setImageResource(loadImage)
                ImageAsync(imageView).execute(url)

            } else {
                imageView.setImageBitmap(weakReference.get())
            }
        }
    }

    private class ImageAsync(imageView: ImageView) : AsyncTask<String, String, String>() {

        private val weakReferenceImageView: WeakReference<ImageView>

        internal var connection: URLConnection? = null
        internal var inputStream: InputStream? = null
        internal var bufferedInputStream: BufferedInputStream? = null

        init {
            this.weakReferenceImageView = WeakReference(imageView)
        }

        override fun doInBackground(vararg strings: String): String? {
            try {
                val urlString = strings[0]

                val url = URL(urlString)
                connection = url.openConnection()
                connection?.connect()

                inputStream = connection?.inputStream
                bufferedInputStream = BufferedInputStream(inputStream)

                cache.put(urlString, WeakReference(BitmapFactory.decodeStream(bufferedInputStream)))
                return urlString

            } catch (e: IOException) {
                closeStream()

            } finally {
                closeStream()
            }
            return null
        }

        private fun closeStream() {
            try {
                if (inputStream != null) {
                    inputStream!!.close()
                    inputStream = null
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream!!.close()
                    bufferedInputStream = null
                }
            } catch (e1: IOException) {
                e1.printStackTrace()
            }

        }

        override fun onPostExecute(url: String) {
            super.onPostExecute(url)
            if (isCancelled) {
                return
            }
            val imageView = weakReferenceImageView.get()
            if (!TextUtils.isEmpty(url) &&
                    imageView != null &&
                    imageView.tag != null &&
                    imageView.tag == url &&
                    cache.get(url) != null &&
                    cache.get(url).get() != null) {
                imageView.setImageBitmap(cache.get(url).get())
            }
        }
    }
}
