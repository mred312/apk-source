package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* renamed from: androidx.core.graphics.drawable.b */
/* compiled from: WrappedDrawableApi14 */
class C0463b extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* renamed from: g */
    static final PorterDuff.Mode f2358g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    private int f2359a;

    /* renamed from: b */
    private PorterDuff.Mode f2360b;

    /* renamed from: c */
    private boolean f2361c;

    /* renamed from: d */
    C0465d f2362d;

    /* renamed from: e */
    private boolean f2363e;

    /* renamed from: f */
    Drawable f2364f;

    C0463b(@NonNull C0465d dVar, @Nullable Resources resources) {
        this.f2362d = dVar;
        m1589c(resources);
    }

    @NonNull
    /* renamed from: b */
    private C0465d m1588b() {
        return new C0465d(this.f2362d);
    }

    /* renamed from: c */
    private void m1589c(@Nullable Resources resources) {
        Drawable.ConstantState constantState;
        C0465d dVar = this.f2362d;
        if (dVar != null && (constantState = dVar.f2367b) != null) {
            setWrappedDrawable(constantState.newDrawable(resources));
        }
    }

    /* renamed from: d */
    private boolean m1590d(int[] iArr) {
        if (!mo4239a()) {
            return false;
        }
        C0465d dVar = this.f2362d;
        ColorStateList colorStateList = dVar.f2368c;
        PorterDuff.Mode mode = dVar.f2369d;
        if (colorStateList == null || mode == null) {
            this.f2361c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f2361c && colorForState == this.f2359a && mode == this.f2360b)) {
                setColorFilter(colorForState, mode);
                this.f2359a = colorForState;
                this.f2360b = mode;
                this.f2361c = true;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4239a() {
        return true;
    }

    public void draw(@NonNull Canvas canvas) {
        this.f2364f.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C0465d dVar = this.f2362d;
        return changingConfigurations | (dVar != null ? dVar.getChangingConfigurations() : 0) | this.f2364f.getChangingConfigurations();
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        C0465d dVar = this.f2362d;
        if (dVar == null || !dVar.mo4274a()) {
            return null;
        }
        this.f2362d.f2366a = getChangingConfigurations();
        return this.f2362d;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.f2364f.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2364f.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2364f.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f2364f.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2364f.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2364f.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.f2364f.getPadding(rect);
    }

    @NonNull
    public int[] getState() {
        return this.f2364f.getState();
    }

    public Region getTransparentRegion() {
        return this.f2364f.getTransparentRegion();
    }

    public final Drawable getWrappedDrawable() {
        return this.f2364f;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @RequiresApi(19)
    public boolean isAutoMirrored() {
        return this.f2364f.isAutoMirrored();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f2362d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.mo4239a()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.d r0 = r1.f2362d
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f2368c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f2364f
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.C0463b.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.f2364f.jumpToCurrentState();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.f2363e && super.mutate() == this) {
            this.f2362d = m1588b();
            Drawable drawable = this.f2364f;
            if (drawable != null) {
                drawable.mutate();
            }
            C0465d dVar = this.f2362d;
            if (dVar != null) {
                Drawable drawable2 = this.f2364f;
                dVar.f2367b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2363e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2364f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f2364f.setLevel(i);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f2364f.setAlpha(i);
    }

    @RequiresApi(19)
    public void setAutoMirrored(boolean z) {
        this.f2364f.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.f2364f.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2364f.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f2364f.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f2364f.setFilterBitmap(z);
    }

    public boolean setState(@NonNull int[] iArr) {
        return m1590d(iArr) || this.f2364f.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2362d.f2368c = colorStateList;
        m1590d(getState());
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f2362d.f2369d = mode;
        m1590d(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2364f.setVisible(z, z2);
    }

    public final void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2364f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f2364f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            C0465d dVar = this.f2362d;
            if (dVar != null) {
                dVar.f2367b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    C0463b(@Nullable Drawable drawable) {
        this.f2362d = m1588b();
        setWrappedDrawable(drawable);
    }
}
