package com.medio.myutilities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.collection.LruCache;
import java.lang.ref.WeakReference;

public class BitmapLoader {

    public static class AsyncDrawable extends BitmapDrawable {

        /* renamed from: a */
        private final WeakReference<BitmapWorkerTask> f20941a;

        public AsyncDrawable(Resources resources, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask) {
            super(resources, bitmap);
            this.f20941a = new WeakReference<>(bitmapWorkerTask);
        }

        public BitmapWorkerTask getBitmapWorkerTask() {
            return (BitmapWorkerTask) this.f20941a.get();
        }
    }

    public static class BitmapWorkerTask extends AsyncTask<Void, Void, Bitmap> {
        protected final WeakReference<Context> contextReference;
        protected final WeakReference<ImageView> imageViewReference;
        protected LruCache<String, Bitmap> mMemCache;
        protected Bitmap.Config mPreffConfig;
        protected int mReqHeight;
        protected int mReqWidth;
        protected String taskData;

        public BitmapWorkerTask(Context context, ImageView imageView, String str, int i, int i2, Bitmap.Config config, LruCache<String, Bitmap> lruCache) {
            this.contextReference = new WeakReference<>(context);
            this.taskData = str;
            this.mReqWidth = i;
            this.mReqHeight = i2;
            this.mPreffConfig = config;
            this.mMemCache = lruCache;
            this.imageViewReference = new WeakReference<>(imageView);
        }

        public void addBitmapToMemoryCache(String str, Bitmap bitmap) {
            if (this.mMemCache != null && getBitmapFromMemCache(str) == null && bitmap != null) {
                this.mMemCache.put(str, bitmap);
            }
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            return null;
        }

        public Bitmap getBitmapFromMemCache(String str) {
            LruCache<String, Bitmap> lruCache = this.mMemCache;
            if (lruCache != null) {
                return lruCache.get(str);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            ImageView imageView = (ImageView) this.imageViewReference.get();
            if (this == BitmapLoader.getBitmapWorkerTask(imageView) && imageView != null) {
                if (bitmap != null) {
                    imageView.setBackgroundColor(0);
                    imageView.setImageBitmap(bitmap);
                }
                ProgressBar progressBar = ((ImageHolder) imageView.getTag()).progress;
                if (progressBar != null) {
                    progressBar.setVisibility(4);
                }
            }
        }
    }

    public static boolean cancelPotentialWork(String str, ImageView imageView) {
        String str2;
        BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);
        if (!(bitmapWorkerTask == null || (str2 = bitmapWorkerTask.taskData) == null || str2.isEmpty())) {
            if (str2.contentEquals(str)) {
                return false;
            }
            bitmapWorkerTask.cancel(true);
        }
        return true;
    }

    public static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView == null) {
            return null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AsyncDrawable) {
            return ((AsyncDrawable) drawable).getBitmapWorkerTask();
        }
        return null;
    }
}
