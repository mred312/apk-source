package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable extends Drawable {

    /* renamed from: a */
    private final Matrix f6426a;

    /* renamed from: b */
    private final RectF f6427b;

    /* renamed from: c */
    private final RectF f6428c;

    /* renamed from: d */
    private Drawable f6429d;

    /* renamed from: e */
    private C1345a f6430e;

    /* renamed from: f */
    private boolean f6431f;

    /* renamed from: com.bumptech.glide.request.target.FixedSizeDrawable$a */
    static final class C1345a extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f6432a;

        /* renamed from: b */
        final int f6433b;

        /* renamed from: c */
        final int f6434c;

        C1345a(C1345a aVar) {
            this(aVar.f6432a, aVar.f6433b, aVar.f6434c);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.f6432a.newDrawable());
        }

        C1345a(Drawable.ConstantState constantState, int i, int i2) {
            this.f6432a = constantState;
            this.f6433b = i;
            this.f6434c = i2;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.f6432a.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(Drawable drawable, int i, int i2) {
        this(new C1345a(drawable.getConstantState(), i, i2), drawable);
    }

    /* renamed from: a */
    private void m4728a() {
        this.f6426a.setRectToRect(this.f6427b, this.f6428c, Matrix.ScaleToFit.CENTER);
    }

    public void clearColorFilter() {
        this.f6429d.clearColorFilter();
    }

    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f6426a);
        this.f6429d.draw(canvas);
        canvas.restore();
    }

    @RequiresApi(19)
    public int getAlpha() {
        return this.f6429d.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.f6429d.getCallback();
    }

    public int getChangingConfigurations() {
        return this.f6429d.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f6430e;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.f6429d.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f6430e.f6434c;
    }

    public int getIntrinsicWidth() {
        return this.f6430e.f6433b;
    }

    public int getMinimumHeight() {
        return this.f6429d.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f6429d.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f6429d.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.f6429d.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.f6429d.invalidateSelf();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.f6431f && super.mutate() == this) {
            this.f6429d = this.f6429d.mutate();
            this.f6430e = new C1345a(this.f6430e);
            this.f6431f = true;
        }
        return this;
    }

    public void scheduleSelf(@NonNull Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f6429d.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f6429d.setAlpha(i);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f6428c.set((float) i, (float) i2, (float) i3, (float) i4);
        m4728a();
    }

    public void setChangingConfigurations(int i) {
        this.f6429d.setChangingConfigurations(i);
    }

    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.f6429d.setColorFilter(i, mode);
    }

    @Deprecated
    public void setDither(boolean z) {
        this.f6429d.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f6429d.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f6429d.setVisible(z, z2);
    }

    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f6429d.unscheduleSelf(runnable);
    }

    FixedSizeDrawable(C1345a aVar, Drawable drawable) {
        this.f6430e = (C1345a) Preconditions.checkNotNull(aVar);
        this.f6429d = (Drawable) Preconditions.checkNotNull(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f6426a = new Matrix();
        this.f6427b = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        this.f6428c = new RectF();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6429d.setColorFilter(colorFilter);
    }

    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.f6428c.set(rect);
        m4728a();
    }
}
