package com.dream_studio.animalsounds;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RecyclingImageView extends ImageView {
    public RecyclingImageView(Context context) {
        super(context);
    }

    /* renamed from: a */
    private static void m4913a(Drawable drawable, boolean z) {
        if (drawable instanceof RecyclingBitmapDrawable) {
            ((RecyclingBitmapDrawable) drawable).setIsDisplayed(z);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                m4913a(layerDrawable.getDrawable(i), z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setImageDrawable((Drawable) null);
        super.onDetachedFromWindow();
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        m4913a(drawable, true);
        m4913a(drawable2, false);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
