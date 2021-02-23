package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.C0131R;
import androidx.core.view.ViewCompat;

/* renamed from: androidx.appcompat.widget.b */
/* compiled from: AppCompatBackgroundHelper */
class C0317b {
    @NonNull

    /* renamed from: a */
    private final View f1613a;

    /* renamed from: b */
    private final AppCompatDrawableManager f1614b;

    /* renamed from: c */
    private int f1615c = -1;

    /* renamed from: d */
    private TintInfo f1616d;

    /* renamed from: e */
    private TintInfo f1617e;

    /* renamed from: f */
    private TintInfo f1618f;

    C0317b(@NonNull View view) {
        this.f1613a = view;
        this.f1614b = AppCompatDrawableManager.get();
    }

    /* renamed from: a */
    private boolean m1026a(@NonNull Drawable drawable) {
        if (this.f1618f == null) {
            this.f1618f = new TintInfo();
        }
        TintInfo tintInfo = this.f1618f;
        tintInfo.mo2786a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f1613a);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f1613a);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.m805d(drawable, tintInfo, this.f1613a.getDrawableState());
        return true;
    }

    /* renamed from: k */
    private boolean m1027k() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1616d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2943b() {
        Drawable background = this.f1613a.getBackground();
        if (background == null) {
            return;
        }
        if (!m1027k() || !m1026a(background)) {
            TintInfo tintInfo = this.f1617e;
            if (tintInfo != null) {
                AppCompatDrawableManager.m805d(background, tintInfo, this.f1613a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1616d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.m805d(background, tintInfo2, this.f1613a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ColorStateList mo2944c() {
        TintInfo tintInfo = this.f1617e;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public PorterDuff.Mode mo2945d() {
        TintInfo tintInfo = this.f1617e;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo2946e(@Nullable AttributeSet attributeSet, int i) {
        Context context = this.f1613a.getContext();
        int[] iArr = C0131R.styleable.ViewBackgroundHelper;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        View view = this.f1613a;
        ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            int i2 = C0131R.styleable.ViewBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f1615c = obtainStyledAttributes.getResourceId(i2, -1);
                ColorStateList c = this.f1614b.mo2204c(this.f1613a.getContext(), this.f1615c);
                if (c != null) {
                    mo2949h(c);
                }
            }
            int i3 = C0131R.styleable.ViewBackgroundHelper_backgroundTint;
            if (obtainStyledAttributes.hasValue(i3)) {
                ViewCompat.setBackgroundTintList(this.f1613a, obtainStyledAttributes.getColorStateList(i3));
            }
            int i4 = C0131R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (obtainStyledAttributes.hasValue(i4)) {
                ViewCompat.setBackgroundTintMode(this.f1613a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i4, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo2947f(Drawable drawable) {
        this.f1615c = -1;
        mo2949h((ColorStateList) null);
        mo2943b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo2948g(int i) {
        this.f1615c = i;
        AppCompatDrawableManager appCompatDrawableManager = this.f1614b;
        mo2949h(appCompatDrawableManager != null ? appCompatDrawableManager.mo2204c(this.f1613a.getContext(), i) : null);
        mo2943b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo2949h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1616d == null) {
                this.f1616d = new TintInfo();
            }
            TintInfo tintInfo = this.f1616d;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.f1616d = null;
        }
        mo2943b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo2950i(ColorStateList colorStateList) {
        if (this.f1617e == null) {
            this.f1617e = new TintInfo();
        }
        TintInfo tintInfo = this.f1617e;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        mo2943b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo2951j(PorterDuff.Mode mode) {
        if (this.f1617e == null) {
            this.f1617e = new TintInfo();
        }
        TintInfo tintInfo = this.f1617e;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        mo2943b();
    }
}
