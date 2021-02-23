package com.dream_studio.animalsounds;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomImageView extends ImageView {
    public CustomImageView(Context context) {
        super(context);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    private static void m4802a(Drawable drawable, boolean z) {
        if (drawable instanceof RecyclingBitmapDrawable) {
            ((RecyclingBitmapDrawable) drawable).setIsDisplayed(z);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                m4802a(layerDrawable.getDrawable(i), z);
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
        float f = (float) (i3 - i);
        float f2 = (float) (i4 - i2);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            float max = Math.max(f / intrinsicWidth, f2 / intrinsicHeight);
            Matrix imageMatrix = getImageMatrix();
            imageMatrix.setScale(max, max, 0.0f, 0.0f);
            imageMatrix.postTranslate((f - (intrinsicWidth * max)) / 2.0f, f2 - (intrinsicHeight * max));
            setImageMatrix(imageMatrix);
        }
        return super.setFrame(i, i2, i3, i4);
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        m4802a(drawable, true);
        m4802a(drawable2, false);
    }

    public CustomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public CustomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
