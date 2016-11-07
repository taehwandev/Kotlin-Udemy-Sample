package tech.thdev.java_udemy_sample.async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Tae-hwan on 26/10/2016.
 */

public class ImageDownloadThread {

    /**
     * LruCache를 사용하여 Image를 캐쉬처리
     */
    private LruCache<String, WeakReference<Bitmap>> cache = new LruCache<>(5 * 1024 * 1024); // 5MiB


    private static ImageDownloadThread imageDownloadThread;

    private ImageDownloadThread() {

    }

    public static ImageDownloadThread getInstance() {
        if (imageDownloadThread == null) {
            synchronized (ImageDownloadThread.class) {
                if (imageDownloadThread == null) {
                    imageDownloadThread = new ImageDownloadThread();
                }
            }
        }
        return imageDownloadThread;
    }

    public void loadImage(@DrawableRes int loadImage, ImageView imageView, String url) {
        imageView.setImageResource(loadImage);
        if (cache.get(url) == null || cache.get(url).get() == null) {
            imageView.setTag(url);
            new Thread(new DownloadThread(imageView, url)).start();
        } else {
            imageView.setImageBitmap(cache.get(url).get());
        }
    }

    private class DownloadThread implements Runnable {

        private WeakReference<ImageView> weakReferenceImageView;

        private String resourceUrl;

        private URLConnection connection;
        private InputStream inputStream;
        private BufferedInputStream bufferedInputStream;

        public DownloadThread(ImageView imageView, String resourceUrl) {
            this.weakReferenceImageView = new WeakReference<>(imageView);
            this.resourceUrl = resourceUrl;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(resourceUrl);
                connection = url.openConnection();
                connection.connect();

                inputStream = connection.getInputStream();
                bufferedInputStream = new BufferedInputStream(inputStream);

                cache.put(resourceUrl, new WeakReference<>(BitmapFactory.decodeStream(bufferedInputStream)));
                draw(resourceUrl);

            } catch (IOException e) {
                closeStream();

            } finally {
                closeStream();
            }
        }

        private void closeStream() {
            try {
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                    bufferedInputStream = null;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        private void draw(final String resourceUrl) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    ImageView imageView = weakReferenceImageView.get();
                    if (!TextUtils.isEmpty(resourceUrl) &&
                            imageView.getTag() != null &&
                            imageView.getTag().equals(resourceUrl) &&
                            cache.get(resourceUrl) != null &&
                            cache.get(resourceUrl).get() != null) {
                        imageView.setImageBitmap(cache.get(resourceUrl).get());
                    }
                }
            });
        }
    }
}
