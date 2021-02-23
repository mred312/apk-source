package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f640a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<C0192a>> f641b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f642c = new Object();

    /* renamed from: androidx.appcompat.content.res.AppCompatResources$a */
    private static class C0192a {

        /* renamed from: a */
        final ColorStateList f643a;

        /* renamed from: b */
        final Configuration f644b;

        C0192a(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            this.f643a = colorStateList;
            this.f644b = configuration;
        }
    }

    private AppCompatResources() {
    }

    /* renamed from: a */
    private static void m537a(@NonNull Context context, @ColorRes int i, @NonNull ColorStateList colorStateList) {
        synchronized (f642c) {
            WeakHashMap<Context, SparseArray<C0192a>> weakHashMap = f641b;
            SparseArray sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i, new C0192a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m538b(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.ColorRes int r5) {
        /*
            java.lang.Object r0 = f642c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.content.res.AppCompatResources$a>> r1 = f641b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            androidx.appcompat.content.res.AppCompatResources$a r2 = (androidx.appcompat.content.res.AppCompatResources.C0192a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f644b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f643a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.content.res.AppCompatResources.m538b(android.content.Context, int):android.content.res.ColorStateList");
    }

    @NonNull
    /* renamed from: c */
    private static TypedValue m539c() {
        ThreadLocal<TypedValue> threadLocal = f640a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    /* renamed from: d */
    private static ColorStateList m540d(Context context, int i) {
        if (m541e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* renamed from: e */
    private static boolean m541e(@NonNull Context context, @ColorRes int i) {
        Resources resources = context.getResources();
        TypedValue c = m539c();
        resources.getValue(i, c, true);
        int i2 = c.type;
        if (i2 < 28 || i2 > 31) {
            return false;
        }
        return true;
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList b = m538b(context, i);
        if (b != null) {
            return b;
        }
        ColorStateList d = m540d(context, i);
        if (d == null) {
            return ContextCompat.getColorStateList(context, i);
        }
        m537a(context, i, d);
        return d;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }
}
