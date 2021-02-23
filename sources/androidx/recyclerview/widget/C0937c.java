package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;

@VisibleForTesting
/* renamed from: androidx.recyclerview.widget.c */
/* compiled from: FastScroller */
class C0937c extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {

    /* renamed from: D */
    private static final int[] f4388D = {16842919};

    /* renamed from: E */
    private static final int[] f4389E = new int[0];

    /* renamed from: A */
    int f4390A;

    /* renamed from: B */
    private final Runnable f4391B;

    /* renamed from: C */
    private final RecyclerView.OnScrollListener f4392C;

    /* renamed from: a */
    private final int f4393a;

    /* renamed from: b */
    private final int f4394b;

    /* renamed from: c */
    final StateListDrawable f4395c;

    /* renamed from: d */
    final Drawable f4396d;

    /* renamed from: e */
    private final int f4397e;

    /* renamed from: f */
    private final int f4398f;

    /* renamed from: g */
    private final StateListDrawable f4399g;

    /* renamed from: h */
    private final Drawable f4400h;

    /* renamed from: i */
    private final int f4401i;

    /* renamed from: j */
    private final int f4402j;
    @VisibleForTesting

    /* renamed from: k */
    int f4403k;
    @VisibleForTesting

    /* renamed from: l */
    int f4404l;
    @VisibleForTesting

    /* renamed from: m */
    float f4405m;
    @VisibleForTesting

    /* renamed from: n */
    int f4406n;
    @VisibleForTesting

    /* renamed from: o */
    int f4407o;
    @VisibleForTesting

    /* renamed from: p */
    float f4408p;

    /* renamed from: q */
    private int f4409q = 0;

    /* renamed from: r */
    private int f4410r = 0;

    /* renamed from: s */
    private RecyclerView f4411s;

    /* renamed from: t */
    private boolean f4412t = false;

    /* renamed from: u */
    private boolean f4413u = false;

    /* renamed from: v */
    private int f4414v = 0;

    /* renamed from: w */
    private int f4415w = 0;

    /* renamed from: x */
    private final int[] f4416x = new int[2];

    /* renamed from: y */
    private final int[] f4417y = new int[2];

    /* renamed from: z */
    final ValueAnimator f4418z;

    /* renamed from: androidx.recyclerview.widget.c$a */
    /* compiled from: FastScroller */
    class C0938a implements Runnable {
        C0938a() {
        }

        public void run() {
            C0937c.this.mo7669g(500);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$b */
    /* compiled from: FastScroller */
    class C0939b extends RecyclerView.OnScrollListener {
        C0939b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            C0937c.this.mo7675r(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c */
    /* compiled from: FastScroller */
    private class C0940c extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f4421a = false;

        C0940c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f4421a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f4421a) {
                this.f4421a = false;
            } else if (((Float) C0937c.this.f4418z.getAnimatedValue()).floatValue() == 0.0f) {
                C0937c cVar = C0937c.this;
                cVar.f4390A = 0;
                cVar.mo7673o(0);
            } else {
                C0937c cVar2 = C0937c.this;
                cVar2.f4390A = 2;
                cVar2.mo7672l();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$d */
    /* compiled from: FastScroller */
    private class C0941d implements ValueAnimator.AnimatorUpdateListener {
        C0941d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C0937c.this.f4395c.setAlpha(floatValue);
            C0937c.this.f4396d.setAlpha(floatValue);
            C0937c.this.mo7672l();
        }
    }

    C0937c(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f4418z = ofFloat;
        this.f4390A = 0;
        this.f4391B = new C0938a();
        this.f4392C = new C0939b();
        this.f4395c = stateListDrawable;
        this.f4396d = drawable;
        this.f4399g = stateListDrawable2;
        this.f4400h = drawable2;
        this.f4397e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f4398f = Math.max(i, drawable.getIntrinsicWidth());
        this.f4401i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f4402j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f4393a = i2;
        this.f4394b = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new C0940c());
        ofFloat.addUpdateListener(new C0941d());
        attachToRecyclerView(recyclerView);
    }

    /* renamed from: a */
    private void m3489a() {
        this.f4411s.removeCallbacks(this.f4391B);
    }

    /* renamed from: b */
    private void m3490b() {
        this.f4411s.removeItemDecoration(this);
        this.f4411s.removeOnItemTouchListener(this);
        this.f4411s.removeOnScrollListener(this.f4392C);
        m3489a();
    }

    /* renamed from: c */
    private void m3491c(Canvas canvas) {
        int i = this.f4410r;
        int i2 = this.f4401i;
        int i3 = i - i2;
        int i4 = this.f4407o;
        int i5 = this.f4406n;
        int i6 = i4 - (i5 / 2);
        this.f4399g.setBounds(0, 0, i5, i2);
        this.f4400h.setBounds(0, 0, this.f4409q, this.f4402j);
        canvas.translate(0.0f, (float) i3);
        this.f4400h.draw(canvas);
        canvas.translate((float) i6, 0.0f);
        this.f4399g.draw(canvas);
        canvas.translate((float) (-i6), (float) (-i3));
    }

    /* renamed from: d */
    private void m3492d(Canvas canvas) {
        int i = this.f4409q;
        int i2 = this.f4397e;
        int i3 = i - i2;
        int i4 = this.f4404l;
        int i5 = this.f4403k;
        int i6 = i4 - (i5 / 2);
        this.f4395c.setBounds(0, 0, i2, i5);
        this.f4396d.setBounds(0, 0, this.f4398f, this.f4410r);
        if (m3496i()) {
            this.f4396d.draw(canvas);
            canvas.translate((float) this.f4397e, (float) i6);
            canvas.scale(-1.0f, 1.0f);
            this.f4395c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f4397e), (float) (-i6));
            return;
        }
        canvas.translate((float) i3, 0.0f);
        this.f4396d.draw(canvas);
        canvas.translate(0.0f, (float) i6);
        this.f4395c.draw(canvas);
        canvas.translate((float) (-i3), (float) (-i6));
    }

    /* renamed from: e */
    private int[] m3493e() {
        int[] iArr = this.f4417y;
        int i = this.f4394b;
        iArr[0] = i;
        iArr[1] = this.f4409q - i;
        return iArr;
    }

    /* renamed from: f */
    private int[] m3494f() {
        int[] iArr = this.f4416x;
        int i = this.f4394b;
        iArr[0] = i;
        iArr[1] = this.f4410r - i;
        return iArr;
    }

    /* renamed from: h */
    private void m3495h(float f) {
        int[] e = m3493e();
        float max = Math.max((float) e[0], Math.min((float) e[1], f));
        if (Math.abs(((float) this.f4407o) - max) >= 2.0f) {
            int n = m3498n(this.f4408p, max, e, this.f4411s.computeHorizontalScrollRange(), this.f4411s.computeHorizontalScrollOffset(), this.f4409q);
            if (n != 0) {
                this.f4411s.scrollBy(n, 0);
            }
            this.f4408p = max;
        }
    }

    /* renamed from: i */
    private boolean m3496i() {
        return ViewCompat.getLayoutDirection(this.f4411s) == 1;
    }

    /* renamed from: m */
    private void m3497m(int i) {
        m3489a();
        this.f4411s.postDelayed(this.f4391B, (long) i);
    }

    /* renamed from: n */
    private int m3498n(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* renamed from: p */
    private void m3499p() {
        this.f4411s.addItemDecoration(this);
        this.f4411s.addOnItemTouchListener(this);
        this.f4411s.addOnScrollListener(this.f4392C);
    }

    /* renamed from: s */
    private void m3500s(float f) {
        int[] f2 = m3494f();
        float max = Math.max((float) f2[0], Math.min((float) f2[1], f));
        if (Math.abs(((float) this.f4404l) - max) >= 2.0f) {
            int n = m3498n(this.f4405m, max, f2, this.f4411s.computeVerticalScrollRange(), this.f4411s.computeVerticalScrollOffset(), this.f4410r);
            if (n != 0) {
                this.f4411s.scrollBy(0, n);
            }
            this.f4405m = max;
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4411s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                m3490b();
            }
            this.f4411s = recyclerView;
            if (recyclerView != null) {
                m3499p();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: g */
    public void mo7669g(int i) {
        int i2 = this.f4390A;
        if (i2 == 1) {
            this.f4418z.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.f4390A = 3;
        ValueAnimator valueAnimator = this.f4418z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f4418z.setDuration((long) i);
        this.f4418z.start();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: j */
    public boolean mo7670j(float f, float f2) {
        if (f2 >= ((float) (this.f4410r - this.f4401i))) {
            int i = this.f4407o;
            int i2 = this.f4406n;
            return f >= ((float) (i - (i2 / 2))) && f <= ((float) (i + (i2 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: k */
    public boolean mo7671k(float f, float f2) {
        if (!m3496i() ? f >= ((float) (this.f4409q - this.f4397e)) : f <= ((float) (this.f4397e / 2))) {
            int i = this.f4404l;
            int i2 = this.f4403k;
            return f2 >= ((float) (i - (i2 / 2))) && f2 <= ((float) (i + (i2 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo7672l() {
        this.f4411s.invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo7673o(int i) {
        if (i == 2 && this.f4414v != 2) {
            this.f4395c.setState(f4388D);
            m3489a();
        }
        if (i == 0) {
            mo7672l();
        } else {
            mo7674q();
        }
        if (this.f4414v == 2 && i != 2) {
            this.f4395c.setState(f4389E);
            m3497m(1200);
        } else if (i == 1) {
            m3497m(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f4414v = i;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f4409q != this.f4411s.getWidth() || this.f4410r != this.f4411s.getHeight()) {
            this.f4409q = this.f4411s.getWidth();
            this.f4410r = this.f4411s.getHeight();
            mo7673o(0);
        } else if (this.f4390A != 0) {
            if (this.f4412t) {
                m3492d(canvas);
            }
            if (this.f4413u) {
                m3491c(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i = this.f4414v;
        if (i == 1) {
            boolean k = mo7671k(motionEvent.getX(), motionEvent.getY());
            boolean j = mo7670j(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!k && !j) {
                return false;
            }
            if (j) {
                this.f4415w = 1;
                this.f4408p = (float) ((int) motionEvent.getX());
            } else if (k) {
                this.f4415w = 2;
                this.f4405m = (float) ((int) motionEvent.getY());
            }
            mo7673o(2);
        } else if (i == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.f4414v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean k = mo7671k(motionEvent.getX(), motionEvent.getY());
                boolean j = mo7670j(motionEvent.getX(), motionEvent.getY());
                if (k || j) {
                    if (j) {
                        this.f4415w = 1;
                        this.f4408p = (float) ((int) motionEvent.getX());
                    } else if (k) {
                        this.f4415w = 2;
                        this.f4405m = (float) ((int) motionEvent.getY());
                    }
                    mo7673o(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f4414v == 2) {
                this.f4405m = 0.0f;
                this.f4408p = 0.0f;
                mo7673o(1);
                this.f4415w = 0;
            } else if (motionEvent.getAction() == 2 && this.f4414v == 2) {
                mo7674q();
                if (this.f4415w == 1) {
                    m3495h(motionEvent.getX());
                }
                if (this.f4415w == 2) {
                    m3500s(motionEvent.getY());
                }
            }
        }
    }

    /* renamed from: q */
    public void mo7674q() {
        int i = this.f4390A;
        if (i != 0) {
            if (i == 3) {
                this.f4418z.cancel();
            } else {
                return;
            }
        }
        this.f4390A = 1;
        ValueAnimator valueAnimator = this.f4418z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f4418z.setDuration(500);
        this.f4418z.setStartDelay(0);
        this.f4418z.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo7675r(int i, int i2) {
        int computeVerticalScrollRange = this.f4411s.computeVerticalScrollRange();
        int i3 = this.f4410r;
        this.f4412t = computeVerticalScrollRange - i3 > 0 && i3 >= this.f4393a;
        int computeHorizontalScrollRange = this.f4411s.computeHorizontalScrollRange();
        int i4 = this.f4409q;
        boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= this.f4393a;
        this.f4413u = z;
        boolean z2 = this.f4412t;
        if (z2 || z) {
            if (z2) {
                float f = (float) i3;
                this.f4404l = (int) ((f * (((float) i2) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f4403k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (this.f4413u) {
                float f2 = (float) i4;
                this.f4407o = (int) ((f2 * (((float) i) + (f2 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f4406n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            int i5 = this.f4414v;
            if (i5 == 0 || i5 == 1) {
                mo7673o(1);
            }
        } else if (this.f4414v != 0) {
            mo7673o(0);
        }
    }
}
