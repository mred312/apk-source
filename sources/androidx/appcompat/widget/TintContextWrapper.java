package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: c */
    private static final Object f1524c = new Object();

    /* renamed from: d */
    private static ArrayList<WeakReference<TintContextWrapper>> f1525d;

    /* renamed from: a */
    private final Resources f1526a;

    /* renamed from: b */
    private final Resources.Theme f1527b;

    private TintContextWrapper(@NonNull Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.f1526a = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.f1527b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1526a = new C0337o(this, context.getResources());
        this.f1527b = null;
    }

    /* renamed from: a */
    private static boolean m989a(@NonNull Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof C0337o) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.shouldBeUsed()) {
            return true;
        }
        return false;
    }

    public static Context wrap(@NonNull Context context) {
        if (!m989a(context)) {
            return context;
        }
        synchronized (f1524c) {
            ArrayList<WeakReference<TintContextWrapper>> arrayList = f1525d;
            if (arrayList == null) {
                f1525d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1525d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1525d.remove(size);
                    }
                }
                for (int size2 = f1525d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1525d.get(size2);
                    TintContextWrapper tintContextWrapper = weakReference2 != null ? (TintContextWrapper) weakReference2.get() : null;
                    if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                        return tintContextWrapper;
                    }
                }
            }
            TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
            f1525d.add(new WeakReference(tintContextWrapper2));
            return tintContextWrapper2;
        }
    }

    public AssetManager getAssets() {
        return this.f1526a.getAssets();
    }

    public Resources getResources() {
        return this.f1526a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1527b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.f1527b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
