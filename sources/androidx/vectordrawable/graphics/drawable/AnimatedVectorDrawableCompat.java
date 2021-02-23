package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class AnimatedVectorDrawableCompat extends C1049b implements Animatable2Compat {

    /* renamed from: b */
    private C1036c f4772b;

    /* renamed from: c */
    private Context f4773c;

    /* renamed from: d */
    private ArgbEvaluator f4774d;

    /* renamed from: e */
    private Animator.AnimatorListener f4775e;

    /* renamed from: f */
    ArrayList<Animatable2Compat.AnimationCallback> f4776f;

    /* renamed from: g */
    final Drawable.Callback f4777g;

    /* renamed from: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$a */
    class C1034a implements Drawable.Callback {
        C1034a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            AnimatedVectorDrawableCompat.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$b */
    class C1035b extends AnimatorListenerAdapter {
        C1035b() {
        }

        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f4776f);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationEnd(AnimatedVectorDrawableCompat.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f4776f);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationStart(AnimatedVectorDrawableCompat.this);
            }
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$c */
    private static class C1036c extends Drawable.ConstantState {

        /* renamed from: a */
        int f4780a;

        /* renamed from: b */
        VectorDrawableCompat f4781b;

        /* renamed from: c */
        AnimatorSet f4782c;

        /* renamed from: d */
        ArrayList<Animator> f4783d;

        /* renamed from: e */
        ArrayMap<Animator, String> f4784e;

        public C1036c(Context context, C1036c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f4780a = cVar.f4780a;
                VectorDrawableCompat vectorDrawableCompat = cVar.f4781b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f4781b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f4781b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f4781b.mutate();
                    this.f4781b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f4781b.setBounds(cVar.f4781b.getBounds());
                    this.f4781b.mo8278f(false);
                }
                ArrayList<Animator> arrayList = cVar.f4783d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f4783d = new ArrayList<>(size);
                    this.f4784e = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = cVar.f4783d.get(i);
                        Animator clone = animator.clone();
                        String str = cVar.f4784e.get(animator);
                        clone.setTarget(this.f4781b.mo8275b(str));
                        this.f4783d.add(clone);
                        this.f4784e.put(clone, str);
                    }
                    mo8262a();
                }
            }
        }

        /* renamed from: a */
        public void mo8262a() {
            if (this.f4782c == null) {
                this.f4782c = new AnimatorSet();
            }
            this.f4782c.playTogether(this.f4783d);
        }

        public int getChangingConfigurations() {
            return this.f4780a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    AnimatedVectorDrawableCompat() {
        this((Context) null, (C1036c) null, (Resources) null);
    }

    @RequiresApi(23)
    /* renamed from: a */
    private static void m3733a(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.mo8213a());
    }

    /* renamed from: b */
    private void m3734b() {
        Animator.AnimatorListener animatorListener = this.f4775e;
        if (animatorListener != null) {
            this.f4772b.f4782c.removeListener(animatorListener);
            this.f4775e = null;
        }
    }

    /* renamed from: c */
    private void m3735c(String str, Animator animator) {
        animator.setTarget(this.f4772b.f4781b.mo8275b(str));
        if (Build.VERSION.SDK_INT < 21) {
            m3736d(animator);
        }
        C1036c cVar = this.f4772b;
        if (cVar.f4783d == null) {
            cVar.f4783d = new ArrayList<>();
            this.f4772b.f4784e = new ArrayMap<>();
        }
        this.f4772b.f4783d.add(animator);
        this.f4772b.f4784e.put(animator, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047 A[Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054 A[Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat create(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "AnimatedVDCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x002e
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
            r0.<init>(r6)
            android.content.res.Resources r1 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.getTheme()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r1, r7, r6)
            r0.f4870a = r6
            android.graphics.drawable.Drawable$Callback r7 = r0.f4777g
            r6.setCallback(r7)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$d r6 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$d
            android.graphics.drawable.Drawable r7 = r0.f4870a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            return r0
        L_0x002e:
            android.content.res.Resources r2 = r6.getResources()
            android.content.res.XmlResourceParser r7 = r2.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
        L_0x003a:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
            r4 = 2
            if (r3 == r4) goto L_0x0045
            r5 = 1
            if (r3 == r5) goto L_0x0045
            goto L_0x003a
        L_0x0045:
            if (r3 != r4) goto L_0x0054
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
            android.content.res.Resources$Theme r4 = r6.getTheme()     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r6 = createFromXmlInner(r6, r3, r7, r2, r4)     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
            return r6
        L_0x0054:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
            throw r6     // Catch:{ XmlPullParserException -> 0x0061, IOException -> 0x005c }
        L_0x005c:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x0065
        L_0x0061:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x0065:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create(android.content.Context, int):androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat");
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    /* renamed from: d */
    private void m3736d(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                m3736d(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f4774d == null) {
                    this.f4774d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f4774d);
            }
        }
    }

    @RequiresApi(23)
    /* renamed from: e */
    private static boolean m3737e(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.mo8213a());
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.applyTheme(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return DrawableCompat.canApplyTheme(drawable);
        }
        return false;
    }

    public void clearAnimationCallbacks() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        m3734b();
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.f4776f;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f4772b.f4781b.draw(canvas);
        if (this.f4772b.f4782c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.f4772b.f4781b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4772b.f4780a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.f4772b.f4781b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f4870a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C1037d(this.f4870a.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f4772b.f4781b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f4772b.f4781b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f4772b.f4781b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C1048a.f4862e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, theme);
                        create.mo8278f(false);
                        create.setCallback(this.f4777g);
                        VectorDrawableCompat vectorDrawableCompat = this.f4772b.f4781b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback((Drawable.Callback) null);
                        }
                        this.f4772b.f4781b = create;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, C1048a.f4863f);
                    String string = obtainAttributes2.getString(0);
                    int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4773c;
                        if (context != null) {
                            m3735c(string, AnimatorInflaterCompat.loadAnimator(context, resourceId2));
                        } else {
                            obtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f4772b.mo8262a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.f4772b.f4781b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f4772b.f4782c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f4772b.f4781b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4772b.f4781b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f4772b.f4781b.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f4772b.f4781b.setState(iArr);
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            m3733a((AnimatedVectorDrawable) drawable, animationCallback);
        } else if (animationCallback != null) {
            if (this.f4776f == null) {
                this.f4776f = new ArrayList<>();
            }
            if (!this.f4776f.contains(animationCallback)) {
                this.f4776f.add(animationCallback);
                if (this.f4775e == null) {
                    this.f4775e = new C1035b();
                }
                this.f4772b.f4782c.addListener(this.f4775e);
            }
        }
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f4772b.f4781b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f4772b.f4781b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
        } else {
            this.f4772b.f4781b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        } else {
            this.f4772b.f4781b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        } else {
            this.f4772b.f4781b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f4772b.f4781b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f4772b.f4782c.isStarted()) {
            this.f4772b.f4782c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4772b.f4782c.end();
        }
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            m3737e((AnimatedVectorDrawable) drawable, animationCallback);
        }
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.f4776f;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean remove = arrayList.remove(animationCallback);
        if (this.f4776f.size() == 0) {
            m3734b();
        }
        return remove;
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context) {
        this(context, (C1036c) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4772b.f4781b.setColorFilter(colorFilter);
        }
    }

    @RequiresApi(24)
    /* renamed from: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$d */
    private static class C1037d extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f4785a;

        public C1037d(Drawable.ConstantState constantState) {
            this.f4785a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f4785a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f4785a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f4785a.newDrawable();
            animatedVectorDrawableCompat.f4870a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f4777g);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f4785a.newDrawable(resources);
            animatedVectorDrawableCompat.f4870a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f4777g);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f4785a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f4870a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f4777g);
            return animatedVectorDrawableCompat;
        }
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context, @Nullable C1036c cVar, @Nullable Resources resources) {
        this.f4774d = null;
        this.f4775e = null;
        this.f4776f = null;
        C1034a aVar = new C1034a();
        this.f4777g = aVar;
        this.f4773c = context;
        if (cVar != null) {
            this.f4772b = cVar;
        } else {
            this.f4772b = new C1036c(context, cVar, aVar, resources);
        }
    }

    public static void clearAnimationCallbacks(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((AnimatedVectorDrawableCompat) drawable).clearAnimationCallbacks();
            }
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return m3737e((AnimatedVectorDrawable) drawable, animationCallback);
        }
        return ((AnimatedVectorDrawableCompat) drawable).unregisterAnimationCallback(animationCallback);
    }

    public static void registerAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable != null && animationCallback != null && (drawable instanceof Animatable)) {
            if (Build.VERSION.SDK_INT >= 24) {
                m3733a((AnimatedVectorDrawable) drawable, animationCallback);
            } else {
                ((AnimatedVectorDrawableCompat) drawable).registerAnimationCallback(animationCallback);
            }
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
