package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.C0129Px;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: w */
    private static final Interpolator f2860w = new C0594a();

    /* renamed from: a */
    private int f2861a;

    /* renamed from: b */
    private int f2862b;

    /* renamed from: c */
    private int f2863c = -1;

    /* renamed from: d */
    private float[] f2864d;

    /* renamed from: e */
    private float[] f2865e;

    /* renamed from: f */
    private float[] f2866f;

    /* renamed from: g */
    private float[] f2867g;

    /* renamed from: h */
    private int[] f2868h;

    /* renamed from: i */
    private int[] f2869i;

    /* renamed from: j */
    private int[] f2870j;

    /* renamed from: k */
    private int f2871k;

    /* renamed from: l */
    private VelocityTracker f2872l;

    /* renamed from: m */
    private float f2873m;

    /* renamed from: n */
    private float f2874n;

    /* renamed from: o */
    private int f2875o;

    /* renamed from: p */
    private int f2876p;

    /* renamed from: q */
    private OverScroller f2877q;

    /* renamed from: r */
    private final Callback f2878r;

    /* renamed from: s */
    private View f2879s;

    /* renamed from: t */
    private boolean f2880t;

    /* renamed from: u */
    private final ViewGroup f2881u;

    /* renamed from: v */
    private final Runnable f2882v = new C0595b();

    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(@NonNull View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(@NonNull View view, int i, int i2, @C0129Px int i3, @C0129Px int i4) {
        }

        public void onViewReleased(@NonNull View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i);
    }

    /* renamed from: androidx.customview.widget.ViewDragHelper$a */
    static class C0594a implements Interpolator {
        C0594a() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.customview.widget.ViewDragHelper$b */
    class C0595b implements Runnable {
        C0595b() {
        }

        public void run() {
            ViewDragHelper.this.mo5262t(0);
        }
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.f2881u = viewGroup;
            this.f2878r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f2875o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f2862b = viewConfiguration.getScaledTouchSlop();
            this.f2873m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f2874n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f2877q = new OverScroller(context, f2860w);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: a */
    private boolean m2023a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f2868h[i] & i2) != i2 || (this.f2876p & i2) == 0 || (this.f2870j[i] & i2) == i2 || (this.f2869i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f2862b;
        if (abs <= ((float) i3) && abs2 <= ((float) i3)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f2878r.onEdgeLock(i2)) {
            int[] iArr = this.f2870j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f2869i[i] & i2) != 0 || abs <= ((float) this.f2862b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    private boolean m2024b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f2878r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f2878r.getViewVerticalDragRange(view) > 0;
        if (z && z2) {
            int i = this.f2862b;
            if ((f * f) + (f2 * f2) > ((float) (i * i))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f2862b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f2862b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: c */
    private float m2025c(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    /* renamed from: d */
    private int m2026d(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    /* renamed from: e */
    private void m2027e() {
        float[] fArr = this.f2864d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f2865e, 0.0f);
            Arrays.fill(this.f2866f, 0.0f);
            Arrays.fill(this.f2867g, 0.0f);
            Arrays.fill(this.f2868h, 0);
            Arrays.fill(this.f2869i, 0);
            Arrays.fill(this.f2870j, 0);
            this.f2871k = 0;
        }
    }

    /* renamed from: f */
    private void m2028f(int i) {
        if (this.f2864d != null && isPointerDown(i)) {
            this.f2864d[i] = 0.0f;
            this.f2865e[i] = 0.0f;
            this.f2866f[i] = 0.0f;
            this.f2867g[i] = 0.0f;
            this.f2868h[i] = 0;
            this.f2869i[i] = 0;
            this.f2870j[i] = 0;
            this.f2871k = ((1 << i) ^ -1) & this.f2871k;
        }
    }

    /* renamed from: g */
    private int m2029g(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.f2881u.getWidth();
        float f = (float) (width / 2);
        float j = f + (m2032j(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(j / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(i4, 600);
    }

    /* renamed from: h */
    private int m2030h(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int d = m2026d(i3, (int) this.f2874n, (int) this.f2873m);
        int d2 = m2026d(i4, (int) this.f2874n, (int) this.f2873m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(d);
        int abs4 = Math.abs(d2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (d != 0) {
            f2 = (float) abs3;
            f = (float) i5;
        } else {
            f2 = (float) abs;
            f = (float) i6;
        }
        float f5 = f2 / f;
        if (d2 != 0) {
            f4 = (float) abs4;
            f3 = (float) i5;
        } else {
            f4 = (float) abs2;
            f3 = (float) i6;
        }
        float f6 = f4 / f3;
        return (int) ((((float) m2029g(i, d, this.f2878r.getViewHorizontalDragRange(view))) * f5) + (((float) m2029g(i2, d2, this.f2878r.getViewVerticalDragRange(view))) * f6));
    }

    /* renamed from: i */
    private void m2031i(float f, float f2) {
        this.f2880t = true;
        this.f2878r.onViewReleased(this.f2879s, f, f2);
        this.f2880t = false;
        if (this.f2861a == 1) {
            mo5262t(0);
        }
    }

    /* renamed from: j */
    private float m2032j(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* renamed from: k */
    private void m2033k(int i, int i2, int i3, int i4) {
        int left = this.f2879s.getLeft();
        int top = this.f2879s.getTop();
        if (i3 != 0) {
            i = this.f2878r.clampViewPositionHorizontal(this.f2879s, i, i3);
            ViewCompat.offsetLeftAndRight(this.f2879s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f2878r.clampViewPositionVertical(this.f2879s, i2, i4);
            ViewCompat.offsetTopAndBottom(this.f2879s, i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f2878r.onViewPositionChanged(this.f2879s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: l */
    private void m2034l(int i) {
        float[] fArr = this.f2864d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f2865e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f2866f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f2867g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f2868h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2869i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2870j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2864d = fArr2;
            this.f2865e = fArr3;
            this.f2866f = fArr4;
            this.f2867g = fArr5;
            this.f2868h = iArr;
            this.f2869i = iArr2;
            this.f2870j = iArr3;
        }
    }

    /* renamed from: m */
    private boolean m2035m(int i, int i2, int i3, int i4) {
        int left = this.f2879s.getLeft();
        int top = this.f2879s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f2877q.abortAnimation();
            mo5262t(0);
            return false;
        }
        this.f2877q.startScroll(left, top, i5, i6, m2030h(this.f2879s, i5, i6, i3, i4));
        mo5262t(2);
        return true;
    }

    /* renamed from: n */
    private int m2036n(int i, int i2) {
        int i3 = i < this.f2881u.getLeft() + this.f2875o ? 1 : 0;
        if (i2 < this.f2881u.getTop() + this.f2875o) {
            i3 |= 4;
        }
        if (i > this.f2881u.getRight() - this.f2875o) {
            i3 |= 2;
        }
        return i2 > this.f2881u.getBottom() - this.f2875o ? i3 | 8 : i3;
    }

    /* renamed from: o */
    private boolean m2037o(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: p */
    private void m2038p() {
        this.f2872l.computeCurrentVelocity(1000, this.f2873m);
        m2031i(m2025c(this.f2872l.getXVelocity(this.f2863c), this.f2874n, this.f2873m), m2025c(this.f2872l.getYVelocity(this.f2863c), this.f2874n, this.f2873m));
    }

    /* renamed from: q */
    private void m2039q(float f, float f2, int i) {
        int i2 = 1;
        if (!m2023a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2023a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2023a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2023a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f2869i;
            iArr[i] = iArr[i] | i2;
            this.f2878r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: r */
    private void m2040r(float f, float f2, int i) {
        m2034l(i);
        float[] fArr = this.f2864d;
        this.f2866f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f2865e;
        this.f2867g[i] = f2;
        fArr2[i] = f2;
        this.f2868h[i] = m2036n((int) f, (int) f2);
        this.f2871k |= 1 << i;
    }

    /* renamed from: s */
    private void m2041s(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m2037o(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f2866f[pointerId] = x;
                this.f2867g[pointerId] = y;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.f2861a == 2) {
            int currX = this.f2877q.getCurrX();
            int currY = this.f2877q.getCurrY();
            this.f2877q.abortAnimation();
            int currX2 = this.f2877q.getCurrX();
            int currY2 = this.f2877q.getCurrY();
            this.f2878r.onViewPositionChanged(this.f2879s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        mo5262t(0);
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(@NonNull View view, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || (!view.canScrollHorizontally(-i) && !view.canScrollVertically(-i2))) {
            return false;
        }
        return true;
    }

    public void cancel() {
        this.f2863c = -1;
        m2027e();
        VelocityTracker velocityTracker = this.f2872l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2872l = null;
        }
    }

    public void captureChildView(@NonNull View view, int i) {
        if (view.getParent() == this.f2881u) {
            this.f2879s = view;
            this.f2863c = i;
            this.f2878r.onViewCaptured(view, i);
            mo5262t(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2881u + ")");
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f2864d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        if (this.f2861a == 2) {
            boolean computeScrollOffset = this.f2877q.computeScrollOffset();
            int currX = this.f2877q.getCurrX();
            int currY = this.f2877q.getCurrY();
            int left = currX - this.f2879s.getLeft();
            int top = currY - this.f2879s.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.f2879s, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.f2879s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f2878r.onViewPositionChanged(this.f2879s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f2877q.getFinalX() && currY == this.f2877q.getFinalY()) {
                this.f2877q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f2881u.post(this.f2882v);
                } else {
                    mo5262t(0);
                }
            }
        }
        if (this.f2861a == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.f2881u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f2881u.getChildAt(this.f2878r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.f2880t) {
            this.f2877q.fling(this.f2879s.getLeft(), this.f2879s.getTop(), (int) this.f2872l.getXVelocity(this.f2863c), (int) this.f2872l.getYVelocity(this.f2863c), i, i3, i2, i4);
            mo5262t(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.f2863c;
    }

    @Nullable
    public View getCapturedView() {
        return this.f2879s;
    }

    @C0129Px
    public int getEdgeSize() {
        return this.f2875o;
    }

    public float getMinVelocity() {
        return this.f2874n;
    }

    @C0129Px
    public int getTouchSlop() {
        return this.f2862b;
    }

    public int getViewDragState() {
        return this.f2861a;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.f2879s, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.f2868h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.f2871k) != 0;
    }

    public boolean isViewUnder(@Nullable View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f2872l == null) {
            this.f2872l = VelocityTracker.obtain();
        }
        this.f2872l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            m2040r(x, y, pointerId);
            mo5263u(findTopChildUnder, pointerId);
            int i3 = this.f2868h[pointerId];
            int i4 = this.f2876p;
            if ((i3 & i4) != 0) {
                this.f2878r.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f2861a == 1) {
                m2038p();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f2861a == 1) {
                    m2031i(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                m2040r(x2, y2, pointerId2);
                if (this.f2861a == 0) {
                    mo5263u(findTopChildUnder((int) x2, (int) y2), pointerId2);
                    int i5 = this.f2868h[pointerId2];
                    int i6 = this.f2876p;
                    if ((i5 & i6) != 0) {
                        this.f2878r.onEdgeTouched(i5 & i6, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x2, (int) y2)) {
                    mo5263u(this.f2879s, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f2861a == 1 && pointerId3 == this.f2863c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i2);
                        if (pointerId4 != this.f2863c) {
                            View findTopChildUnder2 = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view = this.f2879s;
                            if (findTopChildUnder2 == view && mo5263u(view, pointerId4)) {
                                i = this.f2863c;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        m2038p();
                    }
                }
                m2028f(pointerId3);
            }
        } else if (this.f2861a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i2 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i2);
                if (m2037o(pointerId5)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.f2864d[pointerId5];
                    float f2 = y3 - this.f2865e[pointerId5];
                    m2039q(f, f2, pointerId5);
                    if (this.f2861a != 1) {
                        View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
                        if (m2024b(findTopChildUnder3, f, f2) && mo5263u(findTopChildUnder3, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            m2041s(motionEvent);
        } else if (m2037o(this.f2863c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f2863c);
            float x4 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f2866f;
            int i7 = this.f2863c;
            int i8 = (int) (x4 - fArr[i7]);
            int i9 = (int) (y4 - this.f2867g[i7]);
            m2033k(this.f2879s.getLeft() + i8, this.f2879s.getTop() + i9, i8, i9);
            m2041s(motionEvent);
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.f2876p = i;
    }

    public void setMinVelocity(float f) {
        this.f2874n = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.f2880t) {
            return m2035m(i, i2, (int) this.f2872l.getXVelocity(this.f2863c), (int) this.f2872l.getYVelocity(this.f2863c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.cancel()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f2872l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f2872l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f2872l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.m2028f(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.m2040r(r7, r1, r2)
            int r3 = r0.f2861a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f2868h
            r1 = r1[r2]
            int r3 = r0.f2876p
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.f2878r
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.findTopChildUnder(r3, r1)
            android.view.View r3 = r0.f2879s
            if (r1 != r3) goto L_0x0031
            r0.mo5263u(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f2864d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f2865e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.m2037o(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f2864d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f2865e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.findTopChildUnder(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.m2024b(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = 1
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.f2878r
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.f2878r
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.f2878r
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.f2878r
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.m2039q(r9, r10, r4)
            int r5 = r0.f2861a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.mo5263u(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.m2041s(r17)
            goto L_0x0031
        L_0x00ff:
            r16.cancel()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.m2040r(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.findTopChildUnder(r2, r3)
            android.view.View r3 = r0.f2879s
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f2861a
            if (r3 != r4) goto L_0x0125
            r0.mo5263u(r2, r1)
        L_0x0125:
            int[] r2 = r0.f2868h
            r2 = r2[r1]
            int r3 = r0.f2876p
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.f2878r
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0135:
            int r1 = r0.f2861a
            if (r1 != r6) goto L_0x013a
            r5 = 1
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i, int i2) {
        this.f2879s = view;
        this.f2863c = -1;
        boolean m = m2035m(i, i2, 0, 0);
        if (!m && this.f2861a == 0 && this.f2879s != null) {
            this.f2879s = null;
        }
        return m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo5262t(int i) {
        this.f2881u.removeCallbacks(this.f2882v);
        if (this.f2861a != i) {
            this.f2861a = i;
            this.f2878r.onViewDragStateChanged(i);
            if (this.f2861a == 0) {
                this.f2879s = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean mo5263u(View view, int i) {
        if (view == this.f2879s && this.f2863c == i) {
            return true;
        }
        if (view == null || !this.f2878r.tryCaptureView(view, i)) {
            return false;
        }
        this.f2863c = i;
        captureChildView(view, i);
        return true;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f2862b = (int) (((float) create.f2862b) * (1.0f / f));
        return create;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f2866f[i2] - this.f2864d[i2];
        float f2 = this.f2867g[i2] - this.f2865e[i2];
        if (z && z2) {
            int i3 = this.f2862b;
            if ((f * f) + (f2 * f2) > ((float) (i3 * i3))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f2862b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f2862b)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.f2868h[i2]) != 0;
    }
}
