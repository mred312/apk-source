package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: androidx.core.graphics.drawable.d */
/* compiled from: WrappedDrawableState */
final class C0465d extends Drawable.ConstantState {

    /* renamed from: a */
    int f2366a;

    /* renamed from: b */
    Drawable.ConstantState f2367b;

    /* renamed from: c */
    ColorStateList f2368c = null;

    /* renamed from: d */
    PorterDuff.Mode f2369d = C0463b.f2358g;

    C0465d(@Nullable C0465d dVar) {
        if (dVar != null) {
            this.f2366a = dVar.f2366a;
            this.f2367b = dVar.f2367b;
            this.f2368c = dVar.f2368c;
            this.f2369d = dVar.f2369d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4274a() {
        return this.f2367b != null;
    }

    public int getChangingConfigurations() {
        int i = this.f2366a;
        Drawable.ConstantState constantState = this.f2367b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @NonNull
    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C0464c(this, resources);
        }
        return new C0463b(this, resources);
    }
}
