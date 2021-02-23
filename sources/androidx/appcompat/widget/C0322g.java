package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.C0131R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* renamed from: androidx.appcompat.widget.g */
/* compiled from: AppCompatSeekBarHelper */
class C0322g extends C0321f {

    /* renamed from: d */
    private final SeekBar f1630d;

    /* renamed from: e */
    private Drawable f1631e;

    /* renamed from: f */
    private ColorStateList f1632f = null;

    /* renamed from: g */
    private PorterDuff.Mode f1633g = null;

    /* renamed from: h */
    private boolean f1634h = false;

    /* renamed from: i */
    private boolean f1635i = false;

    C0322g(SeekBar seekBar) {
        super(seekBar);
        this.f1630d = seekBar;
    }

    /* renamed from: f */
    private void m1053f() {
        Drawable drawable = this.f1631e;
        if (drawable == null) {
            return;
        }
        if (this.f1634h || this.f1635i) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.f1631e = wrap;
            if (this.f1634h) {
                DrawableCompat.setTintList(wrap, this.f1632f);
            }
            if (this.f1635i) {
                DrawableCompat.setTintMode(this.f1631e, this.f1633g);
            }
            if (this.f1631e.isStateful()) {
                this.f1631e.setState(this.f1630d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2964c(AttributeSet attributeSet, int i) {
        super.mo2964c(attributeSet, i);
        Context context = this.f1630d.getContext();
        int[] iArr = C0131R.styleable.AppCompatSeekBar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        SeekBar seekBar = this.f1630d;
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(C0131R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.f1630d.setThumb(drawableIfKnown);
        }
        mo2968j(obtainStyledAttributes.getDrawable(C0131R.styleable.AppCompatSeekBar_tickMark));
        int i2 = C0131R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f1633g = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i2, -1), this.f1633g);
            this.f1635i = true;
        }
        int i3 = C0131R.styleable.AppCompatSeekBar_tickMarkTint;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f1632f = obtainStyledAttributes.getColorStateList(i3);
            this.f1634h = true;
        }
        obtainStyledAttributes.recycle();
        m1053f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo2965g(Canvas canvas) {
        if (this.f1631e != null) {
            int max = this.f1630d.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1631e.getIntrinsicWidth();
                int intrinsicHeight = this.f1631e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f1631e.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.f1630d.getWidth() - this.f1630d.getPaddingLeft()) - this.f1630d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1630d.getPaddingLeft(), (float) (this.f1630d.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1631e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo2966h() {
        Drawable drawable = this.f1631e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1630d.getDrawableState())) {
            this.f1630d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo2967i() {
        Drawable drawable = this.f1631e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo2968j(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f1631e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1631e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1630d);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.f1630d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1630d.getDrawableState());
            }
            m1053f();
        }
        this.f1630d.invalidate();
    }
}
