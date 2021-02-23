package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
/* renamed from: androidx.core.graphics.drawable.c */
/* compiled from: WrappedDrawableApi21 */
class C0464c extends C0463b {

    /* renamed from: h */
    private static Method f2365h;

    C0464c(Drawable drawable) {
        super(drawable);
        m1592e();
    }

    /* renamed from: e */
    private void m1592e() {
        if (f2365h == null) {
            try {
                f2365h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4239a() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f2364f;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    @NonNull
    public Rect getDirtyBounds() {
        return this.f2364f.getDirtyBounds();
    }

    public void getOutline(@NonNull Outline outline) {
        this.f2364f.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f2364f;
        if (!(drawable == null || (method = f2365h) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    public void setHotspot(float f, float f2) {
        this.f2364f.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f2364f.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(@NonNull int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (mo4239a()) {
            super.setTint(i);
        } else {
            this.f2364f.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo4239a()) {
            super.setTintList(colorStateList);
        } else {
            this.f2364f.setTintList(colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (mo4239a()) {
            super.setTintMode(mode);
        } else {
            this.f2364f.setTintMode(mode);
        }
    }

    C0464c(C0465d dVar, Resources resources) {
        super(dVar, resources);
        m1592e();
    }
}
