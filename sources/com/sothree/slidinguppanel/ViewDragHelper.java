package com.sothree.slidinguppanel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
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
    private static final Interpolator f21018w = new C3803a();

    /* renamed from: a */
    private int f21019a;

    /* renamed from: b */
    private int f21020b;

    /* renamed from: c */
    private int f21021c = -1;

    /* renamed from: d */
    private float[] f21022d;

    /* renamed from: e */
    private float[] f21023e;

    /* renamed from: f */
    private float[] f21024f;

    /* renamed from: g */
    private float[] f21025g;

    /* renamed from: h */
    private int[] f21026h;

    /* renamed from: i */
    private int[] f21027i;

    /* renamed from: j */
    private int[] f21028j;

    /* renamed from: k */
    private int f21029k;

    /* renamed from: l */
    private VelocityTracker f21030l;

    /* renamed from: m */
    private float f21031m;

    /* renamed from: n */
    private float f21032n;

    /* renamed from: o */
    private int f21033o;

    /* renamed from: p */
    private int f21034p;

    /* renamed from: q */
    private ScrollerCompat f21035q;

    /* renamed from: r */
    private final Callback f21036r;

    /* renamed from: s */
    private View f21037s;

    /* renamed from: t */
    private boolean f21038t;

    /* renamed from: u */
    private final ViewGroup f21039u;

    /* renamed from: v */
    private final Runnable f21040v = new C3804b();

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    /* renamed from: com.sothree.slidinguppanel.ViewDragHelper$a */
    static class C3803a implements Interpolator {
        C3803a() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: com.sothree.slidinguppanel.ViewDragHelper$b */
    class C3804b implements Runnable {
        C3804b() {
        }

        public void run() {
            ViewDragHelper.this.mo24228s(0);
        }
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Interpolator interpolator, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.f21039u = viewGroup;
            this.f21036r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f21033o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f21020b = viewConfiguration.getScaledTouchSlop();
            this.f21031m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f21032n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f21035q = ScrollerCompat.create(context, interpolator == null ? f21018w : interpolator);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: a */
    private boolean m14106a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f21026h[i] & i2) != i2 || (this.f21034p & i2) == 0 || (this.f21028j[i] & i2) == i2 || (this.f21027i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f21020b;
        if (abs <= ((float) i3) && abs2 <= ((float) i3)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f21036r.onEdgeLock(i2)) {
            int[] iArr = this.f21028j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f21027i[i] & i2) != 0 || abs <= ((float) this.f21020b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    private boolean m14107b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f21036r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f21036r.getViewVerticalDragRange(view) > 0;
        if (z && z2) {
            int i = this.f21020b;
            if ((f * f) + (f2 * f2) > ((float) (i * i))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f21020b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f21020b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: c */
    private float m14108c(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, (Interpolator) null, callback);
    }

    /* renamed from: d */
    private int m14109d(int i, int i2, int i3) {
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
    private void m14110e() {
        float[] fArr = this.f21022d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f21023e, 0.0f);
            Arrays.fill(this.f21024f, 0.0f);
            Arrays.fill(this.f21025g, 0.0f);
            Arrays.fill(this.f21026h, 0);
            Arrays.fill(this.f21027i, 0);
            Arrays.fill(this.f21028j, 0);
            this.f21029k = 0;
        }
    }

    /* renamed from: f */
    private void m14111f(int i) {
        float[] fArr = this.f21022d;
        if (fArr != null && fArr.length > i) {
            fArr[i] = 0.0f;
            this.f21023e[i] = 0.0f;
            this.f21024f[i] = 0.0f;
            this.f21025g[i] = 0.0f;
            this.f21026h[i] = 0;
            this.f21027i[i] = 0;
            this.f21028j[i] = 0;
            this.f21029k = ((1 << i) ^ -1) & this.f21029k;
        }
    }

    /* renamed from: g */
    private int m14112g(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.f21039u.getWidth();
        float f = (float) (width / 2);
        float j = f + (m14115j(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(j / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(i4, 600);
    }

    /* renamed from: h */
    private int m14113h(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int d = m14109d(i3, (int) this.f21032n, (int) this.f21031m);
        int d2 = m14109d(i4, (int) this.f21032n, (int) this.f21031m);
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
        return (int) ((((float) m14112g(i, d, this.f21036r.getViewHorizontalDragRange(view))) * f5) + (((float) m14112g(i2, d2, this.f21036r.getViewVerticalDragRange(view))) * f6));
    }

    /* renamed from: i */
    private void m14114i(float f, float f2) {
        this.f21038t = true;
        this.f21036r.onViewReleased(this.f21037s, f, f2);
        this.f21038t = false;
        if (this.f21019a == 1) {
            mo24228s(0);
        }
    }

    /* renamed from: j */
    private float m14115j(float f) {
        double d = (double) (f - 0.5f);
        Double.isNaN(d);
        return (float) Math.sin((double) ((float) (d * 0.4712389167638204d)));
    }

    /* renamed from: k */
    private void m14116k(int i, int i2, int i3, int i4) {
        int left = this.f21037s.getLeft();
        int top = this.f21037s.getTop();
        if (i3 != 0) {
            i = this.f21036r.clampViewPositionHorizontal(this.f21037s, i, i3);
            this.f21037s.offsetLeftAndRight(i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f21036r.clampViewPositionVertical(this.f21037s, i2, i4);
            this.f21037s.offsetTopAndBottom(i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f21036r.onViewPositionChanged(this.f21037s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: l */
    private void m14117l(int i) {
        float[] fArr = this.f21022d;
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
                float[] fArr6 = this.f21023e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f21024f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f21025g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f21026h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f21027i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f21028j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f21022d = fArr2;
            this.f21023e = fArr3;
            this.f21024f = fArr4;
            this.f21025g = fArr5;
            this.f21026h = iArr;
            this.f21027i = iArr2;
            this.f21028j = iArr3;
        }
    }

    /* renamed from: m */
    private boolean m14118m(int i, int i2, int i3, int i4) {
        int left = this.f21037s.getLeft();
        int top = this.f21037s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f21035q.abortAnimation();
            mo24228s(0);
            return false;
        }
        this.f21035q.startScroll(left, top, i5, i6, m14113h(this.f21037s, i5, i6, i3, i4));
        mo24228s(2);
        return true;
    }

    /* renamed from: n */
    private int m14119n(int i, int i2) {
        int i3 = i < this.f21039u.getLeft() + this.f21033o ? 1 : 0;
        if (i2 < this.f21039u.getTop() + this.f21033o) {
            i3 |= 4;
        }
        if (i > this.f21039u.getRight() - this.f21033o) {
            i3 |= 2;
        }
        return i2 > this.f21039u.getBottom() - this.f21033o ? i3 | 8 : i3;
    }

    /* renamed from: o */
    private void m14120o() {
        this.f21030l.computeCurrentVelocity(1000, this.f21031m);
        m14114i(m14108c(VelocityTrackerCompat.getXVelocity(this.f21030l, this.f21021c), this.f21032n, this.f21031m), m14108c(VelocityTrackerCompat.getYVelocity(this.f21030l, this.f21021c), this.f21032n, this.f21031m));
    }

    /* renamed from: p */
    private void m14121p(float f, float f2, int i) {
        int i2 = 1;
        if (!m14106a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m14106a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m14106a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m14106a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f21027i;
            iArr[i] = iArr[i] | i2;
            this.f21036r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: q */
    private void m14122q(float f, float f2, int i) {
        m14117l(i);
        float[] fArr = this.f21022d;
        this.f21024f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f21023e;
        this.f21025g[i] = f2;
        fArr2[i] = f2;
        this.f21026h[i] = m14119n((int) f, (int) f2);
        this.f21029k |= 1 << i;
    }

    /* renamed from: r */
    private void m14123r(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            float[] fArr2 = this.f21024f;
            if (fArr2 != null && (fArr = this.f21025g) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x;
                fArr[pointerId] = y;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.f21019a == 2) {
            int currX = this.f21035q.getCurrX();
            int currY = this.f21035q.getCurrY();
            this.f21035q.abortAnimation();
            int currX2 = this.f21035q.getCurrX();
            int currY2 = this.f21035q.getCurrY();
            this.f21036r.onViewPositionChanged(this.f21037s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        mo24228s(0);
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
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
        if (!z || (!ViewCompat.canScrollHorizontally(view, -i) && !ViewCompat.canScrollVertically(view, -i2))) {
            return false;
        }
        return true;
    }

    public void cancel() {
        this.f21021c = -1;
        m14110e();
        VelocityTracker velocityTracker = this.f21030l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f21030l = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() == this.f21039u) {
            this.f21037s = view;
            this.f21021c = i;
            this.f21036r.onViewCaptured(view, i);
            mo24228s(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f21039u + ")");
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f21022d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        if (this.f21037s == null) {
            return false;
        }
        if (this.f21019a == 2) {
            boolean computeScrollOffset = this.f21035q.computeScrollOffset();
            int currX = this.f21035q.getCurrX();
            int currY = this.f21035q.getCurrY();
            int left = currX - this.f21037s.getLeft();
            int top = currY - this.f21037s.getTop();
            if (computeScrollOffset || top == 0) {
                if (left != 0) {
                    this.f21037s.offsetLeftAndRight(left);
                }
                if (top != 0) {
                    this.f21037s.offsetTopAndBottom(top);
                }
                if (!(left == 0 && top == 0)) {
                    this.f21036r.onViewPositionChanged(this.f21037s, currX, currY, left, top);
                }
                if (computeScrollOffset && currX == this.f21035q.getFinalX() && currY == this.f21035q.getFinalY()) {
                    this.f21035q.abortAnimation();
                    computeScrollOffset = this.f21035q.isFinished();
                }
                if (!computeScrollOffset) {
                    if (z) {
                        this.f21039u.post(this.f21040v);
                    } else {
                        mo24228s(0);
                    }
                }
            } else {
                this.f21037s.setTop(0);
                return true;
            }
        }
        if (this.f21019a == 2) {
            return true;
        }
        return false;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.f21039u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f21039u.getChildAt(this.f21036r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.f21038t) {
            this.f21035q.fling(this.f21037s.getLeft(), this.f21037s.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.f21030l, this.f21021c), (int) VelocityTrackerCompat.getYVelocity(this.f21030l, this.f21021c), i, i3, i2, i4);
            mo24228s(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.f21021c;
    }

    public View getCapturedView() {
        return this.f21037s;
    }

    public int getEdgeSize() {
        return this.f21033o;
    }

    public float getMinVelocity() {
        return this.f21032n;
    }

    public int getTouchSlop() {
        return this.f21020b;
    }

    public int getViewDragState() {
        return this.f21019a;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.f21037s, i, i2);
    }

    public boolean isDragging() {
        return this.f21019a == 1;
    }

    public boolean isEdgeTouched(int i) {
        int length = this.f21026h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.f21029k) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f21030l == null) {
            this.f21030l = VelocityTracker.obtain();
        }
        this.f21030l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            m14122q(x, y, pointerId);
            mo24234t(findTopChildUnder, pointerId);
            int i3 = this.f21026h[pointerId];
            int i4 = this.f21034p;
            if ((i3 & i4) != 0) {
                this.f21036r.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f21019a == 1) {
                m14120o();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f21019a == 1) {
                    m14114i(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                m14122q(x2, y2, pointerId2);
                if (this.f21019a == 0) {
                    mo24234t(findTopChildUnder((int) x2, (int) y2), pointerId2);
                    int i5 = this.f21026h[pointerId2];
                    int i6 = this.f21034p;
                    if ((i5 & i6) != 0) {
                        this.f21036r.onEdgeTouched(i5 & i6, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x2, (int) y2)) {
                    mo24234t(this.f21037s, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.f21019a == 1 && pointerId3 == this.f21021c) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, i2);
                        if (pointerId4 != this.f21021c) {
                            View findTopChildUnder2 = findTopChildUnder((int) MotionEventCompat.getX(motionEvent, i2), (int) MotionEventCompat.getY(motionEvent, i2));
                            View view = this.f21037s;
                            if (findTopChildUnder2 == view && mo24234t(view, pointerId4)) {
                                i = this.f21021c;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        m14120o();
                    }
                }
                m14111f(pointerId3);
            }
        } else if (this.f21019a == 1) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f21021c);
            float x3 = MotionEventCompat.getX(motionEvent, findPointerIndex);
            float y3 = MotionEventCompat.getY(motionEvent, findPointerIndex);
            float[] fArr = this.f21024f;
            int i7 = this.f21021c;
            int i8 = (int) (x3 - fArr[i7]);
            int i9 = (int) (y3 - this.f21025g[i7]);
            m14116k(this.f21037s.getLeft() + i8, this.f21037s.getTop() + i9, i8, i9);
            m14123r(motionEvent);
        } else {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (i2 < pointerCount2) {
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                float x4 = MotionEventCompat.getX(motionEvent, i2);
                float y4 = MotionEventCompat.getY(motionEvent, i2);
                float f = x4 - this.f21022d[pointerId5];
                float f2 = y4 - this.f21023e[pointerId5];
                m14121p(f, f2, pointerId5);
                if (this.f21019a != 1) {
                    View findTopChildUnder3 = findTopChildUnder((int) this.f21022d[pointerId5], (int) this.f21023e[pointerId5]);
                    if (m14107b(findTopChildUnder3, f, f2) && mo24234t(findTopChildUnder3, pointerId5)) {
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            m14123r(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo24228s(int i) {
        if (this.f21019a != i) {
            this.f21019a = i;
            this.f21036r.onViewDragStateChanged(i);
            if (this.f21019a == 0) {
                this.f21037s = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.f21034p = i;
    }

    public void setMinVelocity(float f) {
        this.f21032n = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.f21038t) {
            return m14118m(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.f21030l, this.f21021c), (int) VelocityTrackerCompat.getYVelocity(this.f21030l, this.f21021c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        View findTopChildUnder;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f21030l == null) {
            this.f21030l = VelocityTracker.obtain();
        }
        this.f21030l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    for (int i = 0; i < pointerCount && this.f21022d != null && this.f21023e != null; i++) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
                        if (pointerId < this.f21022d.length && pointerId < this.f21023e.length) {
                            float x = MotionEventCompat.getX(motionEvent, i);
                            float y = MotionEventCompat.getY(motionEvent, i);
                            float f = x - this.f21022d[pointerId];
                            float f2 = y - this.f21023e[pointerId];
                            m14121p(f, f2, pointerId);
                            if (this.f21019a == 1) {
                                break;
                            }
                            View findTopChildUnder2 = findTopChildUnder((int) this.f21022d[pointerId], (int) this.f21023e[pointerId]);
                            if (findTopChildUnder2 != null && m14107b(findTopChildUnder2, f, f2) && mo24234t(findTopChildUnder2, pointerId)) {
                                break;
                            }
                        }
                    }
                    m14123r(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                        float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                        m14122q(x2, y2, pointerId2);
                        int i2 = this.f21019a;
                        if (i2 == 0) {
                            int i3 = this.f21026h[pointerId2];
                            int i4 = this.f21034p;
                            if ((i3 & i4) != 0) {
                                this.f21036r.onEdgeTouched(i3 & i4, pointerId2);
                            }
                        } else if (i2 == 2 && (findTopChildUnder = findTopChildUnder((int) x2, (int) y2)) == this.f21037s) {
                            mo24234t(findTopChildUnder, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        m14111f(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                    }
                }
            }
            cancel();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
            m14122q(x3, y3, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.f21037s && this.f21019a == 2) {
                mo24234t(findTopChildUnder3, pointerId3);
            }
            int i5 = this.f21026h[pointerId3];
            int i6 = this.f21034p;
            if ((i5 & i6) != 0) {
                this.f21036r.onEdgeTouched(i5 & i6, pointerId3);
            }
        }
        if (this.f21019a == 1) {
            return true;
        }
        return false;
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.f21037s = view;
        this.f21021c = -1;
        return m14118m(i, i2, 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public boolean mo24234t(View view, int i) {
        if (view == this.f21037s && this.f21021c == i) {
            return true;
        }
        if (view == null || !this.f21036r.tryCaptureView(view, i)) {
            return false;
        }
        this.f21021c = i;
        captureChildView(view, i);
        return true;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Interpolator interpolator, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, interpolator, callback);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f21020b = (int) (((float) create.f21020b) * (1.0f / f));
        return create;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f21024f[i2] - this.f21022d[i2];
        float f2 = this.f21025g[i2] - this.f21023e[i2];
        if (z && z2) {
            int i3 = this.f21020b;
            if ((f * f) + (f2 * f2) > ((float) (i3 * i3))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f21020b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f21020b)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.f21026h[i2]) != 0;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Interpolator interpolator, Callback callback) {
        ViewDragHelper create = create(viewGroup, interpolator, callback);
        create.f21020b = (int) (((float) create.f21020b) * (1.0f / f));
        return create;
    }
}
