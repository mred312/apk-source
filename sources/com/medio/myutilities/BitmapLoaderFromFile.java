package com.medio.myutilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.medio.myutilities.BitmapLoader;

public class BitmapLoaderFromFile {

    /* renamed from: com.medio.myutilities.BitmapLoaderFromFile$a */
    static class C3789a extends BitmapLoader.BitmapWorkerTask {
        public C3789a(Context context, ImageView imageView, String str, int i, int i2, Bitmap.Config config, LruCache<String, Bitmap> lruCache) {
            super(context, imageView, str, i, i2, config, lruCache);
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(this.taskData);
            Context context = (Context) this.contextReference.get();
            if (bitmapFromMemCache == null && context != null && !isCancelled()) {
                bitmapFromMemCache = BitmapLoaderFromFile.decodeSampledBitmapFromPath(context, this.taskData, this.mReqWidth, this.mReqHeight, this.mPreffConfig);
                addBitmapToMemoryCache(this.taskData, bitmapFromMemCache);
            }
            if (isCancelled()) {
                return null;
            }
            return bitmapFromMemCache;
        }
    }

    public static Bitmap decodeSampledBitmapFromPath(Context context, String str, int i, int i2, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = Utilities.calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = config;
        return BitmapFactory.decodeFile(str, options);
    }

    public static void loadBitmap(Context context, String str, ImageView imageView, int i, int i2, Bitmap.Config config, LruCache<String, Bitmap> lruCache) {
        if (BitmapLoader.cancelPotentialWork(str, imageView)) {
            C3789a aVar = new C3789a(context, imageView, str, i, i2, config, lruCache);
            imageView.setImageDrawable(new BitmapLoader.AsyncDrawable(context.getResources(), (Bitmap) null, aVar));
            aVar.execute(new Void[0]);
        }
    }
}
