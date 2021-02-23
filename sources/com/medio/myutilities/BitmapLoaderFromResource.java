package com.medio.myutilities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.medio.catchexception.CatchException;
import com.medio.myutilities.BitmapLoader;
import java.io.InputStream;

public class BitmapLoaderFromResource {

    /* renamed from: com.medio.myutilities.BitmapLoaderFromResource$a */
    static class C3790a extends BitmapLoader.BitmapWorkerTask {
        public C3790a(Context context, ImageView imageView, String str, int i, int i2, Bitmap.Config config, LruCache<String, Bitmap> lruCache) {
            super(context, imageView, str, i, i2, config, lruCache);
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(this.taskData);
            Context context = (Context) this.contextReference.get();
            if (bitmapFromMemCache == null && context != null && !isCancelled()) {
                try {
                    bitmapFromMemCache = BitmapLoaderFromResource.decodeSampledBitmapFromResourceMemOpt(context, context.getResources(), Integer.valueOf(this.taskData).intValue(), this.mReqWidth, this.mReqHeight, this.mPreffConfig);
                    addBitmapToMemoryCache(this.taskData, bitmapFromMemCache);
                } catch (Exception e) {
                    CatchException.logException(e);
                }
            }
            if (isCancelled()) {
                return null;
            }
            return bitmapFromMemCache;
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Context context, Resources resources, int i, int i2, int i3, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = Utilities.calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = config;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap decodeSampledBitmapFromResourceMemOpt(Context context, Resources resources, int i, int i2, int i3, Bitmap.Config config) {
        byte[] bArr = new byte[0];
        byte[] bArr2 = new byte[1024];
        try {
            InputStream openRawResource = resources.openRawResource(i);
            int i4 = 0;
            while (true) {
                int read = openRawResource.read(bArr2);
                if (read <= -1) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, 0, i4, options);
                    options.inSampleSize = Utilities.calculateInSampleSize(options, i2, i3);
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = config;
                    return BitmapFactory.decodeByteArray(bArr, 0, i4, options);
                } else if (read != 0) {
                    int i5 = i4 + read;
                    if (i5 > bArr.length) {
                        byte[] bArr3 = new byte[(i5 * 2)];
                        System.arraycopy(bArr, 0, bArr3, 0, i4);
                        bArr = bArr3;
                    }
                    System.arraycopy(bArr2, 0, bArr, i4, read);
                    i4 = i5;
                }
            }
        } catch (Exception e) {
            CatchException.logException(e);
            return null;
        }
    }

    public static void loadBitmap(Context context, int i, ImageView imageView, int i2, int i3, Bitmap.Config config, LruCache<String, Bitmap> lruCache) {
        String valueOf = String.valueOf(i);
        if (BitmapLoader.cancelPotentialWork(valueOf, imageView)) {
            C3790a aVar = new C3790a(context, imageView, valueOf, i2, i3, config, lruCache);
            imageView.setImageDrawable(new BitmapLoader.AsyncDrawable(context.getResources(), (Bitmap) null, aVar));
            aVar.execute(new Void[0]);
        }
    }
}
