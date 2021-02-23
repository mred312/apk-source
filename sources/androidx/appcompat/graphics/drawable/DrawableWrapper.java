package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableWrapper extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private Drawable f660a;

    public DrawableWrapper(Drawable drawable) {
        setWrappedDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.f660a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f660a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f660a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f660a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f660a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f660a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f660a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f660a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f660a.getPadding(rect);
    }

    public int[] getState() {
        return this.f660a.getState();
    }

    public Region getTransparentRegion() {
        return this.f660a.getTransparentRegion();
    }

    public Drawable getWrappedDrawable() {
        return this.f660a;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.f660a);
    }

    public boolean isStateful() {
        return this.f660a.isStateful();
    }

    public void jumpToCurrentState() {
        this.f660a.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f660a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f660a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f660a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.setAutoMirrored(this.f660a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f660a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f660a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f660a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f660a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.setHotspot(this.f660a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        DrawableCompat.setHotspotBounds(this.f660a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f660a.setState(iArr);
    }

    public void setTint(int i) {
        DrawableCompat.setTint(this.f660a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f660a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode(this.f660a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f660a.setVisible(z, z2);
    }

    public void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.f660a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f660a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
