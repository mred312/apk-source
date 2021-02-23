package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class VectorEnabledTintResources extends Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;

    /* renamed from: b */
    private static boolean f1604b = false;

    /* renamed from: a */
    private final WeakReference<Context> f1605a;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1605a = new WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return f1604b;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        f1604b = z;
    }

    public static boolean shouldBeUsed() {
        return isCompatVectorFromResourcesEnabled() && Build.VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Drawable mo2922a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f1605a.get();
        if (context != null) {
            return ResourceManagerInternal.get().mo2583p(context, this, i);
        }
        return super.getDrawable(i);
    }
}
