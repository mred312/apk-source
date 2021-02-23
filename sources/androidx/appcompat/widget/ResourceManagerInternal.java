package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.C0206R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal {

    /* renamed from: h */
    private static final PorterDuff.Mode f1356h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i */
    private static ResourceManagerInternal f1357i;

    /* renamed from: j */
    private static final C0283c f1358j = new C0283c(6);

    /* renamed from: a */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f1359a;

    /* renamed from: b */
    private SimpleArrayMap<String, C0285e> f1360b;

    /* renamed from: c */
    private SparseArrayCompat<String> f1361c;

    /* renamed from: d */
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f1362d = new WeakHashMap<>(0);

    /* renamed from: e */
    private TypedValue f1363e;

    /* renamed from: f */
    private boolean f1364f;

    /* renamed from: g */
    private C0286f f1365g;

    /* renamed from: androidx.appcompat.widget.ResourceManagerInternal$a */
    static class C0281a implements C0285e {
        C0281a() {
        }

        /* renamed from: a */
        public Drawable mo2586a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ResourceManagerInternal$b */
    private static class C0282b implements C0285e {
        C0282b() {
        }

        /* renamed from: a */
        public Drawable mo2586a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ResourceManagerInternal$c */
    private static class C0283c extends LruCache<Integer, PorterDuffColorFilter> {
        public C0283c(int i) {
            super(i);
        }

        /* renamed from: b */
        private static int m907b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public PorterDuffColorFilter mo2587c(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m907b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public PorterDuffColorFilter mo2588d(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m907b(i, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: androidx.appcompat.widget.ResourceManagerInternal$d */
    static class C0284d implements C0285e {
        C0284d() {
        }

        /* renamed from: a */
        public Drawable mo2586a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) C0284d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                }
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ResourceManagerInternal$e */
    private interface C0285e {
        /* renamed from: a */
        Drawable mo2586a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: androidx.appcompat.widget.ResourceManagerInternal$f */
    interface C0286f {
        /* renamed from: a */
        boolean mo2207a(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable);

        /* renamed from: b */
        PorterDuff.Mode mo2208b(int i);

        /* renamed from: c */
        Drawable mo2209c(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i);

        /* renamed from: d */
        ColorStateList mo2210d(@NonNull Context context, @DrawableRes int i);

        /* renamed from: e */
        boolean mo2211e(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable);
    }

    /* renamed from: androidx.appcompat.widget.ResourceManagerInternal$g */
    private static class C0287g implements C0285e {
        C0287g() {
        }

        /* renamed from: a */
        public Drawable mo2586a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: a */
    private void m886a(@NonNull String str, @NonNull C0285e eVar) {
        if (this.f1360b == null) {
            this.f1360b = new SimpleArrayMap<>();
        }
        this.f1360b.put(str, eVar);
    }

    /* renamed from: b */
    private synchronized boolean m887b(@NonNull Context context, long j, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray longSparseArray = this.f1362d.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray();
            this.f1362d.put(context, longSparseArray);
        }
        longSparseArray.put(j, new WeakReference(constantState));
        return true;
    }

    /* renamed from: c */
    private void m888c(@NonNull Context context, @DrawableRes int i, @NonNull ColorStateList colorStateList) {
        if (this.f1359a == null) {
            this.f1359a = new WeakHashMap<>();
        }
        SparseArrayCompat sparseArrayCompat = this.f1359a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.f1359a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i, colorStateList);
    }

    /* renamed from: d */
    private void m889d(@NonNull Context context) {
        if (!this.f1364f) {
            this.f1364f = true;
            Drawable drawable = getDrawable(context, C0206R.C0207drawable.abc_vector_test);
            if (drawable == null || !m896n(drawable)) {
                this.f1364f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: e */
    private static long m890e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* renamed from: f */
    private Drawable m891f(@NonNull Context context, @DrawableRes int i) {
        Drawable drawable;
        if (this.f1363e == null) {
            this.f1363e = new TypedValue();
        }
        TypedValue typedValue = this.f1363e;
        context.getResources().getValue(i, typedValue, true);
        long e = m890e(typedValue);
        Drawable h = m893h(context, e);
        if (h != null) {
            return h;
        }
        C0286f fVar = this.f1365g;
        if (fVar == null) {
            drawable = null;
        } else {
            drawable = fVar.mo2209c(this, context, i);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            m887b(context, e, drawable);
        }
        return drawable;
    }

    /* renamed from: g */
    private static PorterDuffColorFilter m892g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (f1357i == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                f1357i = resourceManagerInternal2;
                m895m(resourceManagerInternal2);
            }
            resourceManagerInternal = f1357i;
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter c;
        synchronized (ResourceManagerInternal.class) {
            C0283c cVar = f1358j;
            c = cVar.mo2587c(i, mode);
            if (c == null) {
                c = new PorterDuffColorFilter(i, mode);
                cVar.mo2588d(i, mode, c);
            }
        }
        return c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable m893h(@androidx.annotation.NonNull android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1362d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.get(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.remove(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.m893h(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    /* renamed from: k */
    private ColorStateList m894k(@NonNull Context context, @DrawableRes int i) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f1359a;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.get(i);
    }

    /* renamed from: m */
    private static void m895m(@NonNull ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.m886a("vector", new C0287g());
            resourceManagerInternal.m886a("animated-vector", new C0282b());
            resourceManagerInternal.m886a("animated-selector", new C0281a());
            resourceManagerInternal.m886a("drawable", new C0284d());
        }
    }

    /* renamed from: n */
    private static boolean m896n(@NonNull Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m897o(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.DrawableRes int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r0 = r10.f1360b
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.f1361c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r3 = r10.f1360b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.f1361c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f1363e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f1363e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f1363e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = m890e(r0)
            android.graphics.drawable.Drawable r6 = r10.m893h(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.f1361c     // Catch:{ Exception -> 0x00a2 }
            r8.append(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r8 = r10.f1360b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.ResourceManagerInternal$e r3 = (androidx.appcompat.widget.ResourceManagerInternal.C0285e) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.mo2586a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.m887b(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.f1361c
            r11.append(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.m897o(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* renamed from: q */
    private Drawable m898q(@NonNull Context context, @DrawableRes int i, boolean z, @NonNull Drawable drawable) {
        ColorStateList j = mo2580j(context, i);
        if (j != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, j);
            PorterDuff.Mode l = mo2581l(i);
            if (l == null) {
                return wrap;
            }
            DrawableCompat.setTintMode(wrap, l);
            return wrap;
        }
        C0286f fVar = this.f1365g;
        if ((fVar == null || !fVar.mo2211e(context, i, drawable)) && !mo2584s(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* renamed from: r */
    static void m899r(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (!DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            boolean z = tintInfo.mHasTintList;
            if (z || tintInfo.mHasTintMode) {
                drawable.setColorFilter(m892g(z ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : f1356h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return mo2579i(context, i, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized Drawable mo2579i(@NonNull Context context, @DrawableRes int i, boolean z) {
        Drawable o;
        m889d(context);
        o = m897o(context, i);
        if (o == null) {
            o = m891f(context, i);
        }
        if (o == null) {
            o = ContextCompat.getDrawable(context, i);
        }
        if (o != null) {
            o = m898q(context, i, z, o);
        }
        if (o != null) {
            DrawableUtils.m852a(o);
        }
        return o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public synchronized ColorStateList mo2580j(@NonNull Context context, @DrawableRes int i) {
        ColorStateList k;
        k = m894k(context, i);
        if (k == null) {
            C0286f fVar = this.f1365g;
            k = fVar == null ? null : fVar.mo2210d(context, i);
            if (k != null) {
                m888c(context, i, k);
            }
        }
        return k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public PorterDuff.Mode mo2581l(int i) {
        C0286f fVar = this.f1365g;
        if (fVar == null) {
            return null;
        }
        return fVar.mo2208b(i);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        LongSparseArray longSparseArray = this.f1362d.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public synchronized Drawable mo2583p(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i) {
        Drawable o = m897o(context, i);
        if (o == null) {
            o = vectorEnabledTintResources.mo2922a(i);
        }
        if (o == null) {
            return null;
        }
        return m898q(context, i, false, o);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo2584s(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        C0286f fVar = this.f1365g;
        return fVar != null && fVar.mo2207a(context, i, drawable);
    }

    public synchronized void setHooks(C0286f fVar) {
        this.f1365g = fVar;
    }
}
