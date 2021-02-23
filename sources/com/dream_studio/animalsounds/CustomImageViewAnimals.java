package com.dream_studio.animalsounds;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomImageViewAnimals extends ImageView {
    public CustomImageViewAnimals(Context context) {
        super(context);
    }

    /* renamed from: a */
    private static void m4803a(Drawable drawable, boolean z) {
        if (drawable instanceof RecyclingBitmapDrawable) {
            ((RecyclingBitmapDrawable) drawable).setIsDisplayed(z);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                m4803a(layerDrawable.getDrawable(i), z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setImageDrawable((Drawable) null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        try {
            Matrix imageMatrix = getImageMatrix();
            Drawable drawable = getDrawable();
            if (!(imageMatrix == null || drawable == null)) {
                float width = ((float) getWidth()) / ((float) drawable.getIntrinsicWidth());
                imageMatrix.setScale(width, width, 0.0f, 0.0f);
                setImageMatrix(imageMatrix);
            }
        } catch (Exception unused) {
        }
        return super.setFrame(i, i2, i3, i4);
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        m4803a(drawable, true);
        m4803a(drawable2, false);
    }

    public CustomImageViewAnimals(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomImageViewAnimals(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
