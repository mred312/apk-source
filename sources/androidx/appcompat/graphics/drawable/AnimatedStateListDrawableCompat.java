package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.C0200a;
import androidx.appcompat.graphics.drawable.C0204b;
import androidx.appcompat.resources.C0206R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
public class AnimatedStateListDrawableCompat extends C0204b implements TintAwareDrawable {

    /* renamed from: t */
    private static final String f645t = AnimatedStateListDrawableCompat.class.getSimpleName();

    /* renamed from: o */
    private C0195c f646o;

    /* renamed from: p */
    private C0199g f647p;

    /* renamed from: q */
    private int f648q;

    /* renamed from: r */
    private int f649r;

    /* renamed from: s */
    private boolean f650s;

    /* renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$b */
    private static class C0194b extends C0199g {

        /* renamed from: a */
        private final Animatable f651a;

        C0194b(Animatable animatable) {
            super();
            this.f651a = animatable;
        }

        /* renamed from: c */
        public void mo1280c() {
            this.f651a.start();
        }

        /* renamed from: d */
        public void mo1281d() {
            this.f651a.stop();
        }
    }

    /* renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$c */
    static class C0195c extends C0204b.C0205a {

        /* renamed from: K */
        LongSparseArray<Long> f652K;

        /* renamed from: L */
        SparseArrayCompat<Integer> f653L;

        C0195c(@Nullable C0195c cVar, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, @Nullable Resources resources) {
            super(cVar, animatedStateListDrawableCompat, resources);
            if (cVar != null) {
                this.f652K = cVar.f652K;
                this.f653L = cVar.f653L;
                return;
            }
            this.f652K = new LongSparseArray<>();
            this.f653L = new SparseArrayCompat<>();
        }

        /* renamed from: D */
        private static long m554D(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public int mo1282B(@NonNull int[] iArr, @NonNull Drawable drawable, int i) {
            int z = super.mo1396z(iArr, drawable);
            this.f653L.put(z, Integer.valueOf(i));
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: C */
        public int mo1283C(int i, int i2, @NonNull Drawable drawable, boolean z) {
            int a = super.mo1370a(drawable);
            long D = m554D(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a;
            this.f652K.append(D, Long.valueOf(j2 | j));
            if (z) {
                this.f652K.append(m554D(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: E */
        public int mo1284E(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f653L.get(i, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: F */
        public int mo1285F(@NonNull int[] iArr) {
            int A = super.mo1395A(iArr);
            if (A >= 0) {
                return A;
            }
            return super.mo1395A(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: G */
        public int mo1286G(int i, int i2) {
            return (int) this.f652K.get(m554D(i, i2), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: H */
        public boolean mo1287H(int i, int i2) {
            return (this.f652K.get(m554D(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: I */
        public boolean mo1288I(int i, int i2) {
            return (this.f652K.get(m554D(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public void mo1291r() {
            this.f652K = this.f652K.clone();
            this.f653L = this.f653L.clone();
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    /* renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$d */
    private static class C0196d extends C0199g {

        /* renamed from: a */
        private final AnimatedVectorDrawableCompat f654a;

        C0196d(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f654a = animatedVectorDrawableCompat;
        }

        /* renamed from: c */
        public void mo1280c() {
            this.f654a.start();
        }

        /* renamed from: d */
        public void mo1281d() {
            this.f654a.stop();
        }
    }

    /* renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$e */
    private static class C0197e extends C0199g {

        /* renamed from: a */
        private final ObjectAnimator f655a;

        /* renamed from: b */
        private final boolean f656b;

        C0197e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            C0198f fVar = new C0198f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) fVar.mo1294a());
            ofInt.setInterpolator(fVar);
            this.f656b = z2;
            this.f655a = ofInt;
        }

        /* renamed from: a */
        public boolean mo1292a() {
            return this.f656b;
        }

        /* renamed from: b */
        public void mo1293b() {
            this.f655a.reverse();
        }

        /* renamed from: c */
        public void mo1280c() {
            this.f655a.start();
        }

        /* renamed from: d */
        public void mo1281d() {
            this.f655a.cancel();
        }
    }

    /* renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$f */
    private static class C0198f implements TimeInterpolator {

        /* renamed from: a */
        private int[] f657a;

        /* renamed from: b */
        private int f658b;

        /* renamed from: c */
        private int f659c;

        C0198f(AnimationDrawable animationDrawable, boolean z) {
            mo1295b(animationDrawable, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1294a() {
            return this.f659c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo1295b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f658b = numberOfFrames;
            int[] iArr = this.f657a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f657a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f657a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f659c = i;
            return i;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.f659c)) + 0.5f);
            int i2 = this.f658b;
            int[] iArr = this.f657a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.f659c) : 0.0f);
        }
    }

    /* renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$g */
    private static abstract class C0199g {
        private C0199g() {
        }

        /* renamed from: a */
        public boolean mo1292a() {
            return false;
        }

        /* renamed from: b */
        public void mo1293b() {
        }

        /* renamed from: c */
        public abstract void mo1280c();

        /* renamed from: d */
        public abstract void mo1281d();
    }

    public AnimatedStateListDrawableCompat() {
        this((C0195c) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat create(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            android.content.res.Resources r1 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            android.content.res.XmlResourceParser r7 = r1.getXml(r7)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
        L_0x000e:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0020
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat r6 = createFromXmlInner(r6, r1, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            return r6
        L_0x0020:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            throw r6     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
        L_0x0028:
            r6 = move-exception
            java.lang.String r7 = f645t
            android.util.Log.e(r7, r0, r6)
            goto L_0x0035
        L_0x002f:
            r6 = move-exception
            java.lang.String r7 = f645t
            android.util.Log.e(r7, r0, r6)
        L_0x0035:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.create(android.content.Context, int, android.content.res.Resources$Theme):androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    /* renamed from: l */
    private void m542l(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        m545p(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        m546q(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: m */
    private void m543m(TypedArray typedArray) {
        C0195c cVar = this.f646o;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f700d |= typedArray.getChangingConfigurations();
        }
        cVar.mo1392x(typedArray.getBoolean(C0206R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f705i));
        cVar.mo1388t(typedArray.getBoolean(C0206R.styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f708l));
        cVar.mo1389u(typedArray.getInt(C0206R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.f688A));
        cVar.mo1390v(typedArray.getInt(C0206R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.f689B));
        setDither(typedArray.getBoolean(C0206R.styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f720x));
    }

    /* renamed from: o */
    private void m544o() {
        onStateChange(getState());
    }

    /* renamed from: p */
    private int m545p(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0206R.styleable.AnimatedStateListDrawableItem);
        int resourceId = obtainAttributes.getResourceId(C0206R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = obtainAttributes.getResourceId(C0206R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawable = resourceId2 > 0 ? ResourceManagerInternal.get().getDrawable(context, resourceId2) : null;
        obtainAttributes.recycle();
        int[] k = mo1394k(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                drawable = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawable != null) {
            return this.f646o.mo1282B(k, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    /* renamed from: q */
    private int m546q(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0206R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = obtainAttributes.getResourceId(C0206R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = obtainAttributes.getResourceId(C0206R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = obtainAttributes.getResourceId(C0206R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawable = resourceId3 > 0 ? ResourceManagerInternal.get().getDrawable(context, resourceId3) : null;
        boolean z = obtainAttributes.getBoolean(C0206R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        obtainAttributes.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f646o.mo1283C(resourceId, resourceId2, drawable, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    /* renamed from: r */
    private boolean m547r(int i) {
        int i2;
        int G;
        C0199g gVar;
        C0199g gVar2 = this.f647p;
        if (gVar2 == null) {
            i2 = mo1358c();
        } else if (i == this.f648q) {
            return true;
        } else {
            if (i != this.f649r || !gVar2.mo1292a()) {
                i2 = this.f648q;
                gVar2.mo1281d();
            } else {
                gVar2.mo1293b();
                this.f648q = this.f649r;
                this.f649r = i;
                return true;
            }
        }
        this.f647p = null;
        this.f649r = -1;
        this.f648q = -1;
        C0195c cVar = this.f646o;
        int E = cVar.mo1284E(i2);
        int E2 = cVar.mo1284E(i);
        if (E2 == 0 || E == 0 || (G = cVar.mo1286G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.mo1288I(E, E2);
        mo1359g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new C0197e((AnimationDrawable) current, cVar.mo1287H(E, E2), I);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            gVar = new C0196d((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new C0194b((Animatable) current);
            }
            return false;
        }
        gVar.mo1280c();
        this.f647p = gVar;
        this.f649r = i2;
        this.f648q = i;
        return true;
    }

    public /* bridge */ /* synthetic */ void addState(int[] iArr, Drawable drawable) {
        super.addState(iArr, drawable);
    }

    public <T extends Drawable & Animatable> void addTransition(int i, int i2, @NonNull T t, boolean z) {
        if (t != null) {
            this.f646o.mo1283C(i, i2, t, z);
            return;
        }
        throw new IllegalArgumentException("Transition drawable must not be null");
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @NonNull
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(@NonNull Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void getOutline(@NonNull Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(@NonNull Rect rect) {
        return super.getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1256h(@NonNull C0200a.C0203c cVar) {
        super.mo1256h(cVar);
        if (cVar instanceof C0195c) {
            this.f646o = (C0195c) cVar;
        }
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0206R.styleable.AnimatedStateListDrawableCompat);
        setVisible(obtainAttributes.getBoolean(C0206R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        m543m(obtainAttributes);
        mo1361i(resources);
        obtainAttributes.recycle();
        m542l(context, resources, xmlPullParser, attributeSet, theme);
        m544o();
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(@NonNull Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        C0199g gVar = this.f647p;
        if (gVar != null) {
            gVar.mo1281d();
            this.f647p = null;
            mo1359g(this.f648q);
            this.f648q = -1;
            this.f649r = -1;
        }
    }

    public Drawable mutate() {
        if (!this.f650s && super.mutate() == this) {
            this.f646o.mo1291r();
            this.f650s = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public C0195c mo1261j() {
        return new C0195c(this.f646o, this, (Resources) null);
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int F = this.f646o.mo1285F(iArr);
        boolean z = F != mo1358c() && (m547r(F) || mo1359g(F));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setEnterFadeDuration(int i) {
        super.setEnterFadeDuration(i);
    }

    public /* bridge */ /* synthetic */ void setExitFadeDuration(int i) {
        super.setExitFadeDuration(i);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(@NonNull PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        C0199g gVar = this.f647p;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.mo1280c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    AnimatedStateListDrawableCompat(@Nullable C0195c cVar, @Nullable Resources resources) {
        super((C0204b.C0205a) null);
        this.f648q = -1;
        this.f649r = -1;
        mo1256h(new C0195c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public void addState(@NonNull int[] iArr, @NonNull Drawable drawable, int i) {
        if (drawable != null) {
            this.f646o.mo1282B(iArr, drawable, i);
            onStateChange(getState());
            return;
        }
        throw new IllegalArgumentException("Drawable must not be null");
    }
}
