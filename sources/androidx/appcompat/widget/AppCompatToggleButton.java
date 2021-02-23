package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.TintableBackgroundView;

public class AppCompatToggleButton extends ToggleButton implements TintableBackgroundView {

    /* renamed from: a */
    private final C0317b f1253a;

    /* renamed from: b */
    private final C0324i f1254b;

    public AppCompatToggleButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0317b bVar = this.f1253a;
        if (bVar != null) {
            bVar.mo2943b();
        }
        C0324i iVar = this.f1254b;
        if (iVar != null) {
            iVar.mo2971b();
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C0317b bVar = this.f1253a;
        if (bVar != null) {
            return bVar.mo2944c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0317b bVar = this.f1253a;
        if (bVar != null) {
            return bVar.mo2945d();
        }
        return null;
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0317b bVar = this.f1253a;
        if (bVar != null) {
            bVar.mo2947f(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C0317b bVar = this.f1253a;
        if (bVar != null) {
            bVar.mo2948g(i);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0317b bVar = this.f1253a;
        if (bVar != null) {
            bVar.mo2950i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0317b bVar = this.f1253a;
        if (bVar != null) {
            bVar.mo2951j(mode);
        }
    }

    public AppCompatToggleButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C0317b bVar = new C0317b(this);
        this.f1253a = bVar;
        bVar.mo2946e(attributeSet, i);
        C0324i iVar = new C0324i(this);
        this.f1254b = iVar;
        iVar.mo2981m(attributeSet, i);
    }
}
