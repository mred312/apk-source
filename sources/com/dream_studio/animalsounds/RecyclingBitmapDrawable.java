package com.dream_studio.animalsounds;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class RecyclingBitmapDrawable extends BitmapDrawable {

    /* renamed from: a */
    private int f6808a = 0;

    /* renamed from: b */
    private int f6809b = 0;

    /* renamed from: c */
    private boolean f6810c;

    public RecyclingBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    /* renamed from: a */
    private synchronized void m4911a() {
        if (this.f6808a <= 0 && this.f6809b <= 0 && this.f6810c && m4912b()) {
            getBitmap().recycle();
        }
    }

    /* renamed from: b */
    private synchronized boolean m4912b() {
        Bitmap bitmap;
        bitmap = getBitmap();
        return bitmap != null && !bitmap.isRecycled();
    }

    public void setIsCached(boolean z) {
        synchronized (this) {
            if (z) {
                this.f6808a++;
            } else {
                this.f6808a--;
            }
        }
        m4911a();
    }

    public void setIsDisplayed(boolean z) {
        synchronized (this) {
            if (z) {
                this.f6809b++;
                this.f6810c = true;
            } else {
                this.f6809b--;
            }
        }
        m4911a();
    }
}
