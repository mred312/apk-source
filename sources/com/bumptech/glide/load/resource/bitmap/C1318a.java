package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

/* renamed from: com.bumptech.glide.load.resource.bitmap.a */
/* compiled from: DrawableToBitmapConverter */
final class C1318a {

    /* renamed from: a */
    private static final BitmapPool f6187a = new C1319a();

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$a */
    /* compiled from: DrawableToBitmapConverter */
    class C1319a extends BitmapPoolAdapter {
        C1319a() {
        }

        public void put(Bitmap bitmap) {
        }
    }

    @Nullable
    /* renamed from: a */
    static Resource<Bitmap> m4571a(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = m4572b(bitmapPool, current, i, i2);
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            bitmapPool = f6187a;
        }
        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    @Nullable
    /* renamed from: b */
    private static Bitmap m4572b(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i2 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
            bitmapDrawableLock.lock();
            Bitmap bitmap = bitmapPool.get(i, i2, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap((Bitmap) null);
                return bitmap;
            } finally {
                bitmapDrawableLock.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
    }
}
