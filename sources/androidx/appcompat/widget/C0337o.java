package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.o */
/* compiled from: TintResources */
class C0337o extends C0333l {

    /* renamed from: b */
    private final WeakReference<Context> f1713b;

    public C0337o(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f1713b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1713b.get();
        if (!(drawable == null || context == null)) {
            ResourceManagerInternal.get().mo2584s(context, i, drawable);
        }
        return drawable;
    }
}
