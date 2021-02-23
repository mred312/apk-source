package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.annotation.C0129Px;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final int LARGE = 0;

    /* renamed from: M */
    private static final String f4715M = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: N */
    private static final int[] f4716N = {16842766};

    /* renamed from: A */
    private Animation f4717A;

    /* renamed from: B */
    private Animation f4718B;

    /* renamed from: C */
    private Animation f4719C;

    /* renamed from: D */
    private Animation f4720D;

    /* renamed from: E */
    private Animation f4721E;

    /* renamed from: F */
    boolean f4722F;

    /* renamed from: G */
    private int f4723G;

    /* renamed from: H */
    boolean f4724H;

    /* renamed from: I */
    private OnChildScrollUpCallback f4725I;

    /* renamed from: J */
    private Animation.AnimationListener f4726J;

    /* renamed from: K */
    private final Animation f4727K;

    /* renamed from: L */
    private final Animation f4728L;

    /* renamed from: a */
    private View f4729a;

    /* renamed from: b */
    OnRefreshListener f4730b;

    /* renamed from: c */
    boolean f4731c;

    /* renamed from: d */
    private int f4732d;

    /* renamed from: e */
    private float f4733e;

    /* renamed from: f */
    private float f4734f;

    /* renamed from: g */
    private final NestedScrollingParentHelper f4735g;

    /* renamed from: h */
    private final NestedScrollingChildHelper f4736h;

    /* renamed from: i */
    private final int[] f4737i;

    /* renamed from: j */
    private final int[] f4738j;

    /* renamed from: k */
    private boolean f4739k;

    /* renamed from: l */
    private int f4740l;

    /* renamed from: m */
    int f4741m;
    protected int mFrom;
    protected int mOriginalOffsetTop;

    /* renamed from: n */
    private float f4742n;

    /* renamed from: o */
    private float f4743o;

    /* renamed from: p */
    private boolean f4744p;

    /* renamed from: q */
    private int f4745q;

    /* renamed from: r */
    boolean f4746r;

    /* renamed from: s */
    private boolean f4747s;

    /* renamed from: t */
    private final DecelerateInterpolator f4748t;

    /* renamed from: u */
    C1025a f4749u;

    /* renamed from: v */
    private int f4750v;

    /* renamed from: w */
    float f4751w;

    /* renamed from: x */
    int f4752x;

    /* renamed from: y */
    int f4753y;

    /* renamed from: z */
    CircularProgressDrawable f4754z;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$a */
    class C1017a implements Animation.AnimationListener {
        C1017a() {
        }

        public void onAnimationEnd(Animation animation) {
            OnRefreshListener onRefreshListener;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f4731c) {
                swipeRefreshLayout.f4754z.setAlpha(255);
                SwipeRefreshLayout.this.f4754z.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.f4722F && (onRefreshListener = swipeRefreshLayout2.f4730b) != null) {
                    onRefreshListener.onRefresh();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f4741m = swipeRefreshLayout3.f4749u.getTop();
                return;
            }
            swipeRefreshLayout.mo8164j();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$b */
    class C1018b extends Animation {
        C1018b() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$c */
    class C1019c extends Animation {
        C1019c() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$d */
    class C1020d extends Animation {

        /* renamed from: a */
        final /* synthetic */ int f4758a;

        /* renamed from: b */
        final /* synthetic */ int f4759b;

        C1020d(int i, int i2) {
            this.f4758a = i;
            this.f4759b = i2;
        }

        public void applyTransformation(float f, Transformation transformation) {
            CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.f4754z;
            int i = this.f4758a;
            circularProgressDrawable.setAlpha((int) (((float) i) + (((float) (this.f4759b - i)) * f)));
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$e */
    class C1021e implements Animation.AnimationListener {
        C1021e() {
        }

        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f4746r) {
                swipeRefreshLayout.mo8170p((Animation.AnimationListener) null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$f */
    class C1022f extends Animation {
        C1022f() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            int i;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f4724H) {
                i = swipeRefreshLayout.f4752x - Math.abs(swipeRefreshLayout.mOriginalOffsetTop);
            } else {
                i = swipeRefreshLayout.f4752x;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i2 = swipeRefreshLayout2.mFrom;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (i - i2)) * f))) - swipeRefreshLayout2.f4749u.getTop());
            SwipeRefreshLayout.this.f4754z.setArrowScale(1.0f - f);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$g */
    class C1023g extends Animation {
        C1023g() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.mo8162h(f);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$h */
    class C1024h extends Animation {
        C1024h() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f2 = swipeRefreshLayout.f4751w;
            swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
            SwipeRefreshLayout.this.mo8162h(f);
        }
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m3711a(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.f4727K.reset();
        this.f4727K.setDuration(200);
        this.f4727K.setInterpolator(this.f4748t);
        if (animationListener != null) {
            this.f4749u.mo8203b(animationListener);
        }
        this.f4749u.clearAnimation();
        this.f4749u.startAnimation(this.f4727K);
    }

    /* renamed from: b */
    private void m3712b(int i, Animation.AnimationListener animationListener) {
        if (this.f4746r) {
            m3724q(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.f4728L.reset();
        this.f4728L.setDuration(200);
        this.f4728L.setInterpolator(this.f4748t);
        if (animationListener != null) {
            this.f4749u.mo8203b(animationListener);
        }
        this.f4749u.clearAnimation();
        this.f4749u.startAnimation(this.f4728L);
    }

    /* renamed from: c */
    private void m3713c() {
        this.f4749u = new C1025a(getContext(), -328966);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.f4754z = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        this.f4749u.setImageDrawable(this.f4754z);
        this.f4749u.setVisibility(8);
        addView(this.f4749u);
    }

    /* renamed from: d */
    private void m3714d() {
        if (this.f4729a == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f4749u)) {
                    this.f4729a = childAt;
                    return;
                }
            }
        }
    }

    /* renamed from: e */
    private void m3715e(float f) {
        if (f > this.f4733e) {
            m3719k(true, true);
            return;
        }
        this.f4731c = false;
        this.f4754z.setStartEndTrim(0.0f, 0.0f);
        C1021e eVar = null;
        if (!this.f4746r) {
            eVar = new C1021e();
        }
        m3712b(this.f4741m, eVar);
        this.f4754z.setArrowEnabled(false);
    }

    /* renamed from: f */
    private boolean m3716f(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /* renamed from: g */
    private void m3717g(float f) {
        this.f4754z.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f / this.f4733e));
        double d = (double) min;
        Double.isNaN(d);
        float max = (((float) Math.max(d - 0.4d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f4733e;
        int i = this.f4753y;
        if (i <= 0) {
            i = this.f4724H ? this.f4752x - this.mOriginalOffsetTop : this.f4752x;
        }
        float f2 = (float) i;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f);
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f3 = ((float) (max2 - pow)) * 2.0f;
        int i2 = this.mOriginalOffsetTop + ((int) ((f2 * min) + (f2 * f3 * 2.0f)));
        if (this.f4749u.getVisibility() != 0) {
            this.f4749u.setVisibility(0);
        }
        if (!this.f4746r) {
            this.f4749u.setScaleX(1.0f);
            this.f4749u.setScaleY(1.0f);
        }
        if (this.f4746r) {
            setAnimationProgress(Math.min(1.0f, f / this.f4733e));
        }
        if (f < this.f4733e) {
            if (this.f4754z.getAlpha() > 76 && !m3716f(this.f4719C)) {
                m3723o();
            }
        } else if (this.f4754z.getAlpha() < 255 && !m3716f(this.f4720D)) {
            m3722n();
        }
        this.f4754z.setStartEndTrim(0.0f, Math.min(0.8f, max * 0.8f));
        this.f4754z.setArrowScale(Math.min(1.0f, max));
        this.f4754z.setProgressRotation((((max * 0.4f) - 16.0f) + (f3 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i2 - this.f4741m);
    }

    /* renamed from: i */
    private void m3718i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4745q) {
            this.f4745q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    /* renamed from: k */
    private void m3719k(boolean z, boolean z2) {
        if (this.f4731c != z) {
            this.f4722F = z2;
            m3714d();
            this.f4731c = z;
            if (z) {
                m3711a(this.f4741m, this.f4726J);
            } else {
                mo8170p(this.f4726J);
            }
        }
    }

    /* renamed from: l */
    private Animation m3720l(int i, int i2) {
        C1020d dVar = new C1020d(i, i2);
        dVar.setDuration(300);
        this.f4749u.mo8203b((Animation.AnimationListener) null);
        this.f4749u.clearAnimation();
        this.f4749u.startAnimation(dVar);
        return dVar;
    }

    /* renamed from: m */
    private void m3721m(float f) {
        float f2 = this.f4743o;
        int i = this.f4732d;
        if (f - f2 > ((float) i) && !this.f4744p) {
            this.f4742n = f2 + ((float) i);
            this.f4744p = true;
            this.f4754z.setAlpha(76);
        }
    }

    /* renamed from: n */
    private void m3722n() {
        this.f4720D = m3720l(this.f4754z.getAlpha(), 255);
    }

    /* renamed from: o */
    private void m3723o() {
        this.f4719C = m3720l(this.f4754z.getAlpha(), 76);
    }

    /* renamed from: q */
    private void m3724q(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.f4751w = this.f4749u.getScaleX();
        C1024h hVar = new C1024h();
        this.f4721E = hVar;
        hVar.setDuration(150);
        if (animationListener != null) {
            this.f4749u.mo8203b(animationListener);
        }
        this.f4749u.clearAnimation();
        this.f4749u.startAnimation(this.f4721E);
    }

    /* renamed from: r */
    private void m3725r(Animation.AnimationListener animationListener) {
        this.f4749u.setVisibility(0);
        this.f4754z.setAlpha(255);
        C1018b bVar = new C1018b();
        this.f4717A = bVar;
        bVar.setDuration((long) this.f4740l);
        if (animationListener != null) {
            this.f4749u.mo8203b(animationListener);
        }
        this.f4749u.clearAnimation();
        this.f4749u.startAnimation(this.f4717A);
    }

    private void setColorViewAlpha(int i) {
        this.f4749u.getBackground().setAlpha(i);
        this.f4754z.setAlpha(i);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.f4725I;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.f4729a);
        }
        View view = this.f4729a;
        if (view instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f4736h.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f4736h.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f4736h.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f4736h.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.f4750v;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return i3;
        }
        return i2 >= i3 ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.f4735g.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.f4723G;
    }

    public int getProgressViewEndOffset() {
        return this.f4752x;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo8162h(float f) {
        int i = this.mFrom;
        setTargetOffsetTopAndBottom((i + ((int) (((float) (this.mOriginalOffsetTop - i)) * f))) - this.f4749u.getTop());
    }

    public boolean hasNestedScrollingParent() {
        return this.f4736h.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f4736h.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.f4731c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo8164j() {
        this.f4749u.clearAnimation();
        this.f4754z.stop();
        this.f4749u.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f4746r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.f4741m);
        }
        this.f4741m = this.f4749u.getTop();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo8164j();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m3714d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f4747s && actionMasked == 0) {
            this.f4747s = false;
        }
        if (!isEnabled() || this.f4747s || canChildScrollUp() || this.f4731c || this.f4739k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.f4745q;
                    if (i == -1) {
                        Log.e(f4715M, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    m3721m(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        m3718i(motionEvent);
                    }
                }
            }
            this.f4744p = false;
            this.f4745q = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.f4749u.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f4745q = pointerId;
            this.f4744p = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f4743o = motionEvent.getY(findPointerIndex2);
        }
        return this.f4744p;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f4729a == null) {
                m3714d();
            }
            View view = this.f4729a;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f4749u.getMeasuredWidth();
                int measuredHeight2 = this.f4749u.getMeasuredHeight();
                int i5 = measuredWidth / 2;
                int i6 = measuredWidth2 / 2;
                int i7 = this.f4741m;
                this.f4749u.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f4729a == null) {
            m3714d();
        }
        View view = this.f4729a;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f4749u.measure(View.MeasureSpec.makeMeasureSpec(this.f4723G, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f4723G, 1073741824));
            this.f4750v = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f4749u) {
                    this.f4750v = i3;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.f4734f;
            if (f > 0.0f) {
                float f2 = (float) i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.f4734f = 0.0f;
                } else {
                    this.f4734f = f - f2;
                    iArr[1] = i2;
                }
                m3717g(this.f4734f);
            }
        }
        if (this.f4724H && i2 > 0 && this.f4734f == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f4749u.setVisibility(8);
        }
        int[] iArr2 = this.f4737i;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f4738j);
        int i5 = i4 + this.f4738j[1];
        if (i5 < 0 && !canChildScrollUp()) {
            float abs = this.f4734f + ((float) Math.abs(i5));
            this.f4734f = abs;
            m3717g(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f4735g.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.f4734f = 0.0f;
        this.f4739k = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return isEnabled() && !this.f4747s && !this.f4731c && (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f4735g.onStopNestedScroll(view);
        this.f4739k = false;
        float f = this.f4734f;
        if (f > 0.0f) {
            m3715e(f);
            this.f4734f = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f4747s && actionMasked == 0) {
            this.f4747s = false;
        }
        if (!isEnabled() || this.f4747s || canChildScrollUp() || this.f4731c || this.f4739k) {
            return false;
        }
        if (actionMasked == 0) {
            this.f4745q = motionEvent.getPointerId(0);
            this.f4744p = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f4745q);
            if (findPointerIndex < 0) {
                Log.e(f4715M, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.f4744p) {
                this.f4744p = false;
                m3715e((motionEvent.getY(findPointerIndex) - this.f4742n) * 0.5f);
            }
            this.f4745q = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f4745q);
            if (findPointerIndex2 < 0) {
                Log.e(f4715M, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            m3721m(y);
            if (this.f4744p) {
                float f = (y - this.f4742n) * 0.5f;
                if (f <= 0.0f) {
                    return false;
                }
                m3717g(f);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f4715M, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f4745q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m3718i(motionEvent);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo8170p(Animation.AnimationListener animationListener) {
        C1019c cVar = new C1019c();
        this.f4718B = cVar;
        cVar.setDuration(150);
        this.f4749u.mo8203b(animationListener);
        this.f4749u.clearAnimation();
        this.f4749u.startAnimation(this.f4718B);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f4729a instanceof AbsListView)) {
            View view = this.f4729a;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f) {
        this.f4749u.setScaleX(f);
        this.f4749u.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        m3714d();
        this.f4754z.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f4733e = (float) i;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            mo8164j();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f4736h.setNestedScrollingEnabled(z);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.f4725I = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.f4730b = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i) {
        this.f4749u.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.f4752x = i;
        this.f4746r = z;
        this.f4749u.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.f4746r = z;
        this.mOriginalOffsetTop = i;
        this.f4752x = i2;
        this.f4724H = true;
        mo8164j();
        this.f4731c = false;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (!z || this.f4731c == z) {
            m3719k(z, false);
            return;
        }
        this.f4731c = z;
        if (!this.f4724H) {
            i = this.f4752x + this.mOriginalOffsetTop;
        } else {
            i = this.f4752x;
        }
        setTargetOffsetTopAndBottom(i - this.f4741m);
        this.f4722F = false;
        m3725r(this.f4726J);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f4723G = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f4723G = (int) (displayMetrics.density * 40.0f);
            }
            this.f4749u.setImageDrawable((Drawable) null);
            this.f4754z.setStyle(i);
            this.f4749u.setImageDrawable(this.f4754z);
        }
    }

    public void setSlingshotDistance(@C0129Px int i) {
        this.f4753y = i;
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i) {
        this.f4749u.bringToFront();
        ViewCompat.offsetTopAndBottom(this.f4749u, i);
        this.f4741m = this.f4749u.getTop();
    }

    public boolean startNestedScroll(int i) {
        return this.f4736h.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f4736h.stopNestedScroll();
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4731c = false;
        this.f4733e = -1.0f;
        this.f4737i = new int[2];
        this.f4738j = new int[2];
        this.f4745q = -1;
        this.f4750v = -1;
        this.f4726J = new C1017a();
        this.f4727K = new C1022f();
        this.f4728L = new C1023g();
        this.f4732d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4740l = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f4748t = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f4723G = (int) (displayMetrics.density * 40.0f);
        m3713c();
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.f4752x = i;
        this.f4733e = (float) i;
        this.f4735g = new NestedScrollingParentHelper(this);
        this.f4736h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.f4723G;
        this.f4741m = i2;
        this.mOriginalOffsetTop = i2;
        mo8162h(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4716N);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
