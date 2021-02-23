package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;

    /* renamed from: r */
    private static final int f2736r = ViewConfiguration.getTapTimeout();

    /* renamed from: a */
    final C0572a f2737a = new C0572a();

    /* renamed from: b */
    private final Interpolator f2738b = new AccelerateInterpolator();

    /* renamed from: c */
    final View f2739c;

    /* renamed from: d */
    private Runnable f2740d;

    /* renamed from: e */
    private float[] f2741e = {0.0f, 0.0f};

    /* renamed from: f */
    private float[] f2742f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g */
    private int f2743g;

    /* renamed from: h */
    private int f2744h;

    /* renamed from: i */
    private float[] f2745i = {0.0f, 0.0f};

    /* renamed from: j */
    private float[] f2746j = {0.0f, 0.0f};

    /* renamed from: k */
    private float[] f2747k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l */
    private boolean f2748l;

    /* renamed from: m */
    boolean f2749m;

    /* renamed from: n */
    boolean f2750n;

    /* renamed from: o */
    boolean f2751o;

    /* renamed from: p */
    private boolean f2752p;

    /* renamed from: q */
    private boolean f2753q;

    /* renamed from: androidx.core.widget.AutoScrollHelper$a */
    private static class C0572a {

        /* renamed from: a */
        private int f2754a;

        /* renamed from: b */
        private int f2755b;

        /* renamed from: c */
        private float f2756c;

        /* renamed from: d */
        private float f2757d;

        /* renamed from: e */
        private long f2758e = Long.MIN_VALUE;

        /* renamed from: f */
        private long f2759f = 0;

        /* renamed from: g */
        private int f2760g = 0;

        /* renamed from: h */
        private int f2761h = 0;

        /* renamed from: i */
        private long f2762i = -1;

        /* renamed from: j */
        private float f2763j;

        /* renamed from: k */
        private int f2764k;

        C0572a() {
        }

        /* renamed from: e */
        private float m1930e(long j) {
            long j2 = this.f2758e;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.f2762i;
            if (j3 < 0 || j < j3) {
                return AutoScrollHelper.m1922c(((float) (j - j2)) / ((float) this.f2754a), 0.0f, 1.0f) * 0.5f;
            }
            float f = this.f2763j;
            return (1.0f - f) + (f * AutoScrollHelper.m1922c(((float) (j - j3)) / ((float) this.f2764k), 0.0f, 1.0f));
        }

        /* renamed from: g */
        private float m1931g(float f) {
            return (-4.0f * f * f) + (f * 4.0f);
        }

        /* renamed from: a */
        public void mo5060a() {
            if (this.f2759f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g = m1931g(m1930e(currentAnimationTimeMillis));
                this.f2759f = currentAnimationTimeMillis;
                float f = ((float) (currentAnimationTimeMillis - this.f2759f)) * g;
                this.f2760g = (int) (this.f2756c * f);
                this.f2761h = (int) (f * this.f2757d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        /* renamed from: b */
        public int mo5061b() {
            return this.f2760g;
        }

        /* renamed from: c */
        public int mo5062c() {
            return this.f2761h;
        }

        /* renamed from: d */
        public int mo5063d() {
            float f = this.f2756c;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: f */
        public int mo5064f() {
            float f = this.f2757d;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: h */
        public boolean mo5065h() {
            return this.f2762i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2762i + ((long) this.f2764k);
        }

        /* renamed from: i */
        public void mo5066i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2764k = AutoScrollHelper.m1923d((int) (currentAnimationTimeMillis - this.f2758e), 0, this.f2755b);
            this.f2763j = m1930e(currentAnimationTimeMillis);
            this.f2762i = currentAnimationTimeMillis;
        }

        /* renamed from: j */
        public void mo5067j(int i) {
            this.f2755b = i;
        }

        /* renamed from: k */
        public void mo5068k(int i) {
            this.f2754a = i;
        }

        /* renamed from: l */
        public void mo5069l(float f, float f2) {
            this.f2756c = f;
            this.f2757d = f2;
        }

        /* renamed from: m */
        public void mo5070m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2758e = currentAnimationTimeMillis;
            this.f2762i = -1;
            this.f2759f = currentAnimationTimeMillis;
            this.f2763j = 0.5f;
            this.f2760g = 0;
            this.f2761h = 0;
        }
    }

    /* renamed from: androidx.core.widget.AutoScrollHelper$b */
    private class C0573b implements Runnable {
        C0573b() {
        }

        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.f2751o) {
                if (autoScrollHelper.f2749m) {
                    autoScrollHelper.f2749m = false;
                    autoScrollHelper.f2737a.mo5070m();
                }
                C0572a aVar = AutoScrollHelper.this.f2737a;
                if (aVar.mo5065h() || !AutoScrollHelper.this.mo5044h()) {
                    AutoScrollHelper.this.f2751o = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.f2750n) {
                    autoScrollHelper2.f2750n = false;
                    autoScrollHelper2.mo5041a();
                }
                aVar.mo5060a();
                AutoScrollHelper.this.scrollTargetBy(aVar.mo5061b(), aVar.mo5062c());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.f2739c, this);
            }
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.f2739c = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (float) ((int) ((1575.0f * f) + 0.5f));
        setMaximumVelocity(f2, f2);
        float f3 = (float) ((int) ((f * 315.0f) + 0.5f));
        setMinimumVelocity(f3, f3);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(f2736r);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    /* renamed from: b */
    private float m1921b(int i, float f, float f2, float f3) {
        float f4 = m1925f(this.f2741e[i], f2, this.f2742f[i], f);
        if (f4 == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f2745i[i];
        float f6 = this.f2746j[i];
        float f7 = this.f2747k[i];
        float f8 = f5 * f3;
        if (f4 > 0.0f) {
            return m1922c(f4 * f8, f6, f7);
        }
        return -m1922c((-f4) * f8, f6, f7);
    }

    /* renamed from: c */
    static float m1922c(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: d */
    static int m1923d(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: e */
    private float m1924e(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f2743g;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                return (!this.f2751o || i != 1) ? 0.0f : 1.0f;
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
    }

    /* renamed from: f */
    private float m1925f(float f, float f2, float f3, float f4) {
        float f5;
        float c = m1922c(f * f2, 0.0f, f3);
        float e = m1924e(f2 - f4, c) - m1924e(f4, c);
        if (e < 0.0f) {
            f5 = -this.f2738b.getInterpolation(-e);
        } else if (e <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f2738b.getInterpolation(e);
        }
        return m1922c(f5, -1.0f, 1.0f);
    }

    /* renamed from: g */
    private void m1926g() {
        if (this.f2749m) {
            this.f2751o = false;
        } else {
            this.f2737a.mo5066i();
        }
    }

    /* renamed from: i */
    private void m1927i() {
        int i;
        if (this.f2740d == null) {
            this.f2740d = new C0573b();
        }
        this.f2751o = true;
        this.f2749m = true;
        if (this.f2748l || (i = this.f2744h) <= 0) {
            this.f2740d.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.f2739c, this.f2740d, (long) i);
        }
        this.f2748l = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5041a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2739c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo5044h() {
        C0572a aVar = this.f2737a;
        int f = aVar.mo5064f();
        int d = aVar.mo5063d();
        return (f != 0 && canTargetScrollVertically(f)) || (d != 0 && canTargetScrollHorizontally(d));
    }

    public boolean isEnabled() {
        return this.f2752p;
    }

    public boolean isExclusive() {
        return this.f2753q;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2752p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.m1926g()
            goto L_0x0058
        L_0x001a:
            r5.f2750n = r2
            r5.f2748l = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2739c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.m1921b(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2739c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.m1921b(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$a r7 = r5.f2737a
            r7.mo5069l(r0, r6)
            boolean r6 = r5.f2751o
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.mo5044h()
            if (r6 == 0) goto L_0x0058
            r5.m1927i()
        L_0x0058:
            boolean r6 = r5.f2753q
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f2751o
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i, int i2);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i) {
        this.f2744h = i;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i) {
        this.f2743g = i;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.f2752p && !z) {
            m1926g();
        }
        this.f2752p = z;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.f2753q = z;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        float[] fArr = this.f2742f;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        float[] fArr = this.f2747k;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        float[] fArr = this.f2746j;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i) {
        this.f2737a.mo5067j(i);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i) {
        this.f2737a.mo5068k(i);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        float[] fArr = this.f2741e;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        float[] fArr = this.f2745i;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }
}
