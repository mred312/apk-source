package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper {
    @NonNull

    /* renamed from: a */
    private final ImageView f1206a;

    /* renamed from: b */
    private TintInfo f1207b;

    /* renamed from: c */
    private TintInfo f1208c;

    /* renamed from: d */
    private TintInfo f1209d;

    public AppCompatImageHelper(@NonNull ImageView imageView) {
        this.f1206a = imageView;
    }

    /* renamed from: a */
    private boolean m821a(@NonNull Drawable drawable) {
        if (this.f1209d == null) {
            this.f1209d = new TintInfo();
        }
        TintInfo tintInfo = this.f1209d;
        tintInfo.mo2786a();
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.f1206a);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.f1206a);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.m805d(drawable, tintInfo, this.f1206a.getDrawableState());
        return true;
    }

    /* renamed from: h */
    private boolean m822h() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1207b != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2236b() {
        Drawable drawable = this.f1206a.getDrawable();
        if (drawable != null) {
            DrawableUtils.m852a(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!m822h() || !m821a(drawable)) {
            TintInfo tintInfo = this.f1208c;
            if (tintInfo != null) {
                AppCompatDrawableManager.m805d(drawable, tintInfo, this.f1206a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1207b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.m805d(drawable, tintInfo2, this.f1206a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ColorStateList mo2237c() {
        TintInfo tintInfo = this.f1208c;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public PorterDuff.Mode mo2238d() {
        TintInfo tintInfo = this.f1208c;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo2239e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1206a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo2240f(ColorStateList colorStateList) {
        if (this.f1208c == null) {
            this.f1208c = new TintInfo();
        }
        TintInfo tintInfo = this.f1208c;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        mo2236b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo2241g(PorterDuff.Mode mode) {
        if (this.f1208c == null) {
            this.f1208c = new TintInfo();
        }
        TintInfo tintInfo = this.f1208c;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        mo2236b();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        Context context = this.f1206a.getContext();
        int[] iArr = C0131R.styleable.AppCompatImageView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ImageView imageView = this.f1206a;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            Drawable drawable = this.f1206a.getDrawable();
            if (!(drawable != null || (resourceId = obtainStyledAttributes.getResourceId(C0131R.styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = AppCompatResources.getDrawable(this.f1206a.getContext(), resourceId)) == null)) {
                this.f1206a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.m852a(drawable);
            }
            int i2 = C0131R.styleable.AppCompatImageView_tint;
            if (obtainStyledAttributes.hasValue(i2)) {
                ImageViewCompat.setImageTintList(this.f1206a, obtainStyledAttributes.getColorStateList(i2));
            }
            int i3 = C0131R.styleable.AppCompatImageView_tintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
                ImageViewCompat.setImageTintMode(this.f1206a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.f1206a.getContext(), i);
            if (drawable != null) {
                DrawableUtils.m852a(drawable);
            }
            this.f1206a.setImageDrawable(drawable);
        } else {
            this.f1206a.setImageDrawable((Drawable) null);
        }
        mo2236b();
    }
}
