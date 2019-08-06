package tech.thdev.imageloadsample

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Build
import android.support.annotation.DrawableRes
import android.support.annotation.RequiresApi
import android.support.v4.util.LruCache
import android.widget.ImageView
import android.widget.TextView
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

    fun loadImage(@DrawableRes loadingImageRes: Int, imageView: ImageView, url: String?, textView: TextView, randNumber: Int): Boolean {
        imageView.setImageResource(loadingImageRes)
        url?.let { imageUrl ->
            cache.get(imageUrl)?.get()?.let {
                imageView.setImageBitmap(it)
                return true
            } ?: let {
                // 이미지 뷰 동기화를 위해서 tag 추가
                ImageAsync(imageUrl, WeakReference(imageView), WeakReference(textView), randNumber).execute(url)
            }
        }
        return false
    }

    private class ImageAsync(val tag: String, val imageView: WeakReference<ImageView>?, val textView: WeakReference<TextView>?, val randNumber: Int) : AsyncTask<String, String, String>() {

        private var bufferedInputStream: BufferedInputStream? = null

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

        @RequiresApi(Build.VERSION_CODES.CUPCAKE)
        @SuppressLint("SetTextI18n")
        override fun onPostExecute(url: String) {
            super.onPostExecute(url)
            if (isCancelled) {
                return
            }
            if (tag == url) {
                cache.get(url)?.get()?.let {
                    imageView?.get()?.setImageBitmap(it)
                    textView?.get()?.text = "ACTION_ASYNC cacheLoad : false - $randNumber"
                }
            }
        }
    }
}