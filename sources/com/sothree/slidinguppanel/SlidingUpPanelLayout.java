package com.sothree.slidinguppanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.sothree.slidinguppanel.ViewDragHelper;
import java.util.List;

public class SlidingUpPanelLayout extends ViewGroup {

    /* renamed from: I */
    private static final String f20976I = SlidingUpPanelLayout.class.getSimpleName();

    /* renamed from: J */
    private static PanelState f20977J = PanelState.COLLAPSED;

    /* renamed from: K */
    private static final int[] f20978K = {16842927};
    public static final String SLIDING_STATE = "sliding_state";

    /* renamed from: A */
    private float f20979A;

    /* renamed from: B */
    private float f20980B;

    /* renamed from: C */
    private boolean f20981C;

    /* renamed from: D */
    private final List<PanelSlideListener> f20982D;

    /* renamed from: E */
    private View.OnClickListener f20983E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public final ViewDragHelper f20984F;

    /* renamed from: G */
    private boolean f20985G;

    /* renamed from: H */
    private final Rect f20986H;

    /* renamed from: a */
    private int f20987a;

    /* renamed from: b */
    private int f20988b;

    /* renamed from: c */
    private final Paint f20989c;

    /* renamed from: d */
    private final Drawable f20990d;

    /* renamed from: e */
    private int f20991e;

    /* renamed from: f */
    private int f20992f;

    /* renamed from: g */
    private int f20993g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f20994h;

    /* renamed from: i */
    private boolean f20995i;

    /* renamed from: j */
    private boolean f20996j;

    /* renamed from: k */
    private View f20997k;

    /* renamed from: l */
    private int f20998l;

    /* renamed from: m */
    private View f20999m;

    /* renamed from: n */
    private int f21000n;

    /* renamed from: o */
    private ScrollableViewHelper f21001o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f21002p;

    /* renamed from: q */
    private View f21003q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public PanelState f21004r;

    /* renamed from: s */
    private PanelState f21005s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f21006t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f21007u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f21008v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f21009w;

    /* renamed from: x */
    private boolean f21010x;

    /* renamed from: y */
    private float f21011y;

    /* renamed from: z */
    private float f21012z;

    public interface PanelSlideListener {
        void onPanelSlide(View view, float f);

        void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2);
    }

    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelSlide(View view, float f) {
        }

        public void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    /* renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$a */
    class C3800a implements View.OnClickListener {
        C3800a() {
        }

        public void onClick(View view) {
            PanelState panelState;
            if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.isTouchEnabled()) {
                PanelState a = SlidingUpPanelLayout.this.f21004r;
                PanelState panelState2 = PanelState.EXPANDED;
                if (a == panelState2 || SlidingUpPanelLayout.this.f21004r == (panelState = PanelState.ANCHORED)) {
                    SlidingUpPanelLayout.this.setPanelState(PanelState.COLLAPSED);
                } else if (SlidingUpPanelLayout.this.f21008v < 1.0f) {
                    SlidingUpPanelLayout.this.setPanelState(panelState);
                } else {
                    SlidingUpPanelLayout.this.setPanelState(panelState2);
                }
            }
        }
    }

    /* renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$b */
    static /* synthetic */ class C3801b {

        /* renamed from: a */
        static final /* synthetic */ int[] f21016a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState[] r0 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21016a = r0
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r1 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.EXPANDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21016a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r1 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.ANCHORED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21016a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r1 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21016a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r1 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.C3801b.<clinit>():void");
        }
    }

    /* renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$c */
    private class C3802c extends ViewDragHelper.Callback {
        private C3802c() {
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int d = SlidingUpPanelLayout.this.m14096p(0.0f);
            int d2 = SlidingUpPanelLayout.this.m14096p(1.0f);
            if (SlidingUpPanelLayout.this.f20994h) {
                return Math.min(Math.max(i, d2), d);
            }
            return Math.min(Math.max(i, d), d2);
        }

        public int getViewVerticalDragRange(View view) {
            return SlidingUpPanelLayout.this.f21007u;
        }

        public void onViewCaptured(View view, int i) {
            SlidingUpPanelLayout.this.mo24195w();
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingUpPanelLayout.this.f20984F != null && SlidingUpPanelLayout.this.f20984F.getViewDragState() == 0) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                float unused = slidingUpPanelLayout.f21006t = slidingUpPanelLayout.m14097q(slidingUpPanelLayout.f21002p.getTop());
                SlidingUpPanelLayout.this.m14095o();
                if (SlidingUpPanelLayout.this.f21006t == 1.0f) {
                    SlidingUpPanelLayout.this.mo24197y();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.EXPANDED);
                } else if (SlidingUpPanelLayout.this.f21006t == 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.COLLAPSED);
                } else if (SlidingUpPanelLayout.this.f21006t < 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.HIDDEN);
                    SlidingUpPanelLayout.this.f21002p.setVisibility(4);
                } else {
                    SlidingUpPanelLayout.this.mo24197y();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.ANCHORED);
                }
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.m14100v(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            if (SlidingUpPanelLayout.this.f20994h) {
                f2 = -f2;
            }
            if (f2 > 0.0f && SlidingUpPanelLayout.this.f21006t <= SlidingUpPanelLayout.this.f21008v) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                i = slidingUpPanelLayout.m14096p(slidingUpPanelLayout.f21008v);
            } else if (f2 > 0.0f && SlidingUpPanelLayout.this.f21006t > SlidingUpPanelLayout.this.f21008v) {
                i = SlidingUpPanelLayout.this.m14096p(1.0f);
            } else if (f2 < 0.0f && SlidingUpPanelLayout.this.f21006t >= SlidingUpPanelLayout.this.f21008v) {
                SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                i = slidingUpPanelLayout2.m14096p(slidingUpPanelLayout2.f21008v);
            } else if (f2 < 0.0f && SlidingUpPanelLayout.this.f21006t < SlidingUpPanelLayout.this.f21008v) {
                i = SlidingUpPanelLayout.this.m14096p(0.0f);
            } else if (SlidingUpPanelLayout.this.f21006t >= (SlidingUpPanelLayout.this.f21008v + 1.0f) / 2.0f) {
                i = SlidingUpPanelLayout.this.m14096p(1.0f);
            } else if (SlidingUpPanelLayout.this.f21006t >= SlidingUpPanelLayout.this.f21008v / 2.0f) {
                SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                i = slidingUpPanelLayout3.m14096p(slidingUpPanelLayout3.f21008v);
            } else {
                i = SlidingUpPanelLayout.this.m14096p(0.0f);
            }
            if (SlidingUpPanelLayout.this.f20984F != null) {
                SlidingUpPanelLayout.this.f20984F.settleCapturedViewAt(view.getLeft(), i);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            return !SlidingUpPanelLayout.this.f21009w && view == SlidingUpPanelLayout.this.f21002p;
        }

        /* synthetic */ C3802c(SlidingUpPanelLayout slidingUpPanelLayout, C3800a aVar) {
            this();
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: o */
    public void m14095o() {
        if (this.f20993g > 0) {
            ViewCompat.setTranslationY(this.f21003q, (float) getCurrentParallaxOffset());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public int m14096p(float f) {
        View view = this.f21002p;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i = (int) (f * ((float) this.f21007u));
        if (this.f20994h) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.f20991e) - i;
        }
        return (getPaddingTop() - measuredHeight) + this.f20991e + i;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public float m14097q(int i) {
        int p = m14096p(0.0f);
        return (this.f20994h ? (float) (p - i) : (float) (i - p)) / ((float) this.f21007u);
    }

    /* access modifiers changed from: private */
    public void setPanelStateInternal(PanelState panelState) {
        PanelState panelState2 = this.f21004r;
        if (panelState2 != panelState) {
            this.f21004r = panelState;
            mo24177s(this, panelState2, panelState);
        }
    }

    /* renamed from: t */
    private static boolean m14098t(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* renamed from: u */
    private boolean m14099u(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        if (i3 < iArr[0] || i3 >= iArr[0] + view.getWidth() || i4 < iArr[1] || i4 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m14100v(int i) {
        PanelState panelState = this.f21004r;
        PanelState panelState2 = PanelState.DRAGGING;
        if (panelState != panelState2) {
            this.f21005s = panelState;
        }
        setPanelStateInternal(panelState2);
        this.f21006t = m14097q(i);
        m14095o();
        mo24175r(this.f21002p);
        LayoutParams layoutParams = (LayoutParams) this.f21003q.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.f20991e;
        if (this.f21006t <= 0.0f && !this.f20995i) {
            int paddingBottom = this.f20994h ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.f21002p.getMeasuredHeight()) - i;
            layoutParams.height = paddingBottom;
            if (paddingBottom == height) {
                layoutParams.height = -1;
            }
            this.f21003q.requestLayout();
        } else if (layoutParams.height != -1 && !this.f20995i) {
            layoutParams.height = -1;
            this.f21003q.requestLayout();
        }
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.f20982D) {
            this.f20982D.add(panelSlideListener);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !ViewCompat.canScrollHorizontally(view, -i)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.f20984F;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            if (!isEnabled()) {
                this.f20984F.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!isEnabled() || !isTouchEnabled() || (this.f21009w && actionMasked != 0)) {
            this.f20984F.abort();
            return super.dispatchTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.f20981C = false;
            this.f21011y = x;
            this.f21012z = y;
        } else if (actionMasked == 2) {
            float f = y - this.f21012z;
            this.f21011y = x;
            this.f21012z = y;
            if (Math.abs(x - this.f21011y) > Math.abs(f)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!m14099u(this.f20999m, (int) this.f20979A, (int) this.f20980B)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            boolean z = this.f20994h;
            int i = -1;
            if (((float) (z ? 1 : -1)) * f <= 0.0f) {
                if (z) {
                    i = 1;
                }
                if (f * ((float) i) < 0.0f) {
                    if (this.f21006t < 1.0f) {
                        this.f20981C = false;
                        return onTouchEvent(motionEvent);
                    }
                    if (!this.f20981C && this.f20984F.isDragging()) {
                        this.f20984F.cancel();
                        motionEvent.setAction(0);
                    }
                    this.f20981C = true;
                    return super.dispatchTouchEvent(motionEvent);
                }
            } else if (this.f21001o.getScrollableViewScrollPosition(this.f20999m, z) > 0) {
                this.f20981C = true;
                return super.dispatchTouchEvent(motionEvent);
            } else {
                if (this.f20981C) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    motionEvent.setAction(0);
                }
                this.f20981C = false;
                return onTouchEvent(motionEvent);
            }
        } else if (actionMasked == 1 && this.f20981C) {
            this.f20984F.mo24228s(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void draw(Canvas canvas) {
        View view;
        int i;
        int i2;
        super.draw(canvas);
        if (this.f20990d != null && (view = this.f21002p) != null) {
            int right = view.getRight();
            if (this.f20994h) {
                i2 = this.f21002p.getTop() - this.f20992f;
                i = this.f21002p.getTop();
            } else {
                i2 = this.f21002p.getBottom();
                i = this.f21002p.getBottom() + this.f20992f;
            }
            this.f20990d.setBounds(this.f21002p.getLeft(), i2, right, i);
            this.f20990d.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        int save = canvas.save(2);
        View view2 = this.f21002p;
        if (view2 == null || view2 == view) {
            z = super.drawChild(canvas, view, j);
        } else {
            canvas.getClipBounds(this.f20986H);
            if (!this.f20995i) {
                if (this.f20994h) {
                    Rect rect = this.f20986H;
                    rect.bottom = Math.min(rect.bottom, this.f21002p.getTop());
                } else {
                    Rect rect2 = this.f20986H;
                    rect2.top = Math.max(rect2.top, this.f21002p.getBottom());
                }
            }
            if (this.f20996j) {
                canvas.clipRect(this.f20986H);
            }
            z = super.drawChild(canvas, view, j);
            int i = this.f20988b;
            if (i != 0) {
                float f = this.f21006t;
                if (f > 0.0f) {
                    this.f20989c.setColor((i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24));
                    canvas.drawRect(this.f20986H, this.f20989c);
                }
            }
        }
        canvas.restoreToCount(save);
        return z;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getAnchorPoint() {
        return this.f21008v;
    }

    public int getCoveredFadeColor() {
        return this.f20988b;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (((float) this.f20993g) * Math.max(this.f21006t, 0.0f));
        return this.f20994h ? -max : max;
    }

    public int getMinFlingVelocity() {
        return this.f20987a;
    }

    public int getPanelHeight() {
        return this.f20991e;
    }

    public PanelState getPanelState() {
        return this.f21004r;
    }

    public int getShadowHeight() {
        return this.f20992f;
    }

    public boolean isClipPanel() {
        return this.f20996j;
    }

    public boolean isOverlayed() {
        return this.f20995i;
    }

    public boolean isTouchEnabled() {
        return (!this.f21010x || this.f21002p == null || this.f21004r == PanelState.HIDDEN) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f20985G = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20985G = true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f20998l;
        if (i != -1) {
            setDragView(findViewById(i));
        }
        int i2 = this.f21000n;
        if (i2 != -1) {
            setScrollableView(findViewById(i2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r0 != 3) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.f20981C
            r1 = 0
            if (r0 != 0) goto L_0x00a4
            boolean r0 = r8.isTouchEnabled()
            if (r0 != 0) goto L_0x000d
            goto L_0x00a4
        L_0x000d:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r9)
            float r2 = r9.getX()
            float r3 = r9.getY()
            float r4 = r8.f20979A
            float r4 = r2 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r8.f20980B
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            com.sothree.slidinguppanel.ViewDragHelper r6 = r8.f20984F
            int r6 = r6.getTouchSlop()
            r7 = 1
            if (r0 == 0) goto L_0x0085
            if (r0 == r7) goto L_0x004c
            r2 = 2
            if (r0 == r2) goto L_0x003b
            r2 = 3
            if (r0 == r2) goto L_0x004c
            goto L_0x009d
        L_0x003b:
            float r0 = (float) r6
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            com.sothree.slidinguppanel.ViewDragHelper r9 = r8.f20984F
            r9.cancel()
            r8.f21009w = r7
            return r1
        L_0x004c:
            com.sothree.slidinguppanel.ViewDragHelper r0 = r8.f20984F
            boolean r0 = r0.isDragging()
            if (r0 == 0) goto L_0x005a
            com.sothree.slidinguppanel.ViewDragHelper r0 = r8.f20984F
            r0.processTouchEvent(r9)
            return r7
        L_0x005a:
            float r0 = (float) r6
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x009d
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x009d
            float r0 = r8.f21006t
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            android.view.View r0 = r8.f21002p
            float r2 = r8.f20979A
            int r2 = (int) r2
            float r3 = r8.f20980B
            int r3 = (int) r3
            boolean r0 = r8.m14099u(r0, r2, r3)
            if (r0 != 0) goto L_0x009d
            android.view.View$OnClickListener r0 = r8.f20983E
            if (r0 == 0) goto L_0x009d
            r8.playSoundEffect(r1)
            android.view.View$OnClickListener r9 = r8.f20983E
            r9.onClick(r8)
            return r7
        L_0x0085:
            r8.f21009w = r1
            r8.f20979A = r2
            r8.f20980B = r3
            android.view.View r0 = r8.f20997k
            int r2 = (int) r2
            int r3 = (int) r3
            boolean r0 = r8.m14099u(r0, r2, r3)
            if (r0 != 0) goto L_0x009d
            com.sothree.slidinguppanel.ViewDragHelper r9 = r8.f20984F
            r9.cancel()
            r8.f21009w = r7
            return r1
        L_0x009d:
            com.sothree.slidinguppanel.ViewDragHelper r0 = r8.f20984F
            boolean r9 = r0.shouldInterceptTouchEvent(r9)
            return r9
        L_0x00a4:
            com.sothree.slidinguppanel.ViewDragHelper r9 = r8.f20984F
            r9.abort()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f20985G) {
            int i5 = C3801b.f21016a[this.f21004r.ordinal()];
            if (i5 == 1) {
                this.f21006t = 1.0f;
            } else if (i5 == 2) {
                this.f21006t = this.f21008v;
            } else if (i5 != 3) {
                this.f21006t = 0.0f;
            } else {
                this.f21006t = m14097q(m14096p(0.0f) + (this.f20994h ? this.f20991e : -this.f20991e));
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.f20985G)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int p = childAt == this.f21002p ? m14096p(this.f21006t) : paddingTop;
                if (!this.f20994h && childAt == this.f21003q && !this.f20995i) {
                    p = m14096p(this.f21006t) + this.f21002p.getMeasuredHeight();
                }
                int i7 = layoutParams.leftMargin + paddingLeft;
                childAt.layout(i7, p, childAt.getMeasuredWidth() + i7, measuredHeight + p);
            }
        }
        if (this.f20985G) {
            mo24197y();
        }
        m14095o();
        this.f20985G = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            int childCount = getChildCount();
            if (childCount == 2) {
                this.f21003q = getChildAt(0);
                View childAt = getChildAt(1);
                this.f21002p = childAt;
                if (this.f20997k == null) {
                    setDragView(childAt);
                }
                if (this.f21002p.getVisibility() != 0) {
                    this.f21004r = PanelState.HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt2 = getChildAt(i7);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8 || i7 != 0) {
                        if (childAt2 == this.f21003q) {
                            i4 = (this.f20995i || this.f21004r == PanelState.HIDDEN) ? paddingTop : paddingTop - this.f20991e;
                            i3 = paddingLeft - (layoutParams.leftMargin + layoutParams.rightMargin);
                        } else {
                            i4 = childAt2 == this.f21002p ? paddingTop - layoutParams.topMargin : paddingTop;
                            i3 = paddingLeft;
                        }
                        int i8 = layoutParams.width;
                        if (i8 == -2) {
                            i5 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                        } else if (i8 == -1) {
                            i5 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                        } else {
                            i5 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                        }
                        int i9 = layoutParams.height;
                        if (i9 == -2) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                        } else {
                            float f = layoutParams.weight;
                            if (f > 0.0f && f < 1.0f) {
                                i4 = (int) (((float) i4) * f);
                            } else if (i9 != -1) {
                                i4 = i9;
                            }
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                        }
                        childAt2.measure(i5, i6);
                        View view = this.f21002p;
                        if (childAt2 == view) {
                            this.f21007u = view.getMeasuredHeight() - this.f20991e;
                        }
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            PanelState panelState = (PanelState) bundle.getSerializable(SLIDING_STATE);
            this.f21004r = panelState;
            if (panelState == null) {
                panelState = f20977J;
            }
            this.f21004r = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        PanelState panelState = this.f21004r;
        if (panelState == PanelState.DRAGGING) {
            panelState = this.f21005s;
        }
        bundle.putSerializable(SLIDING_STATE, panelState);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.f20985G = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isTouchEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.f20984F.processTouchEvent(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo24175r(View view) {
        synchronized (this.f20982D) {
            for (PanelSlideListener onPanelSlide : this.f20982D) {
                onPanelSlide.onPanelSlide(view, this.f21006t);
            }
        }
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.f20982D) {
            this.f20982D.remove(panelSlideListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo24177s(View view, PanelState panelState, PanelState panelState2) {
        synchronized (this.f20982D) {
            for (PanelSlideListener onPanelStateChanged : this.f20982D) {
                onPanelStateChanged.onPanelStateChanged(view, panelState, panelState2);
            }
        }
        sendAccessibilityEvent(32);
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f <= 1.0f) {
            this.f21008v = f;
            this.f20985G = true;
            requestLayout();
        }
    }

    public void setClipPanel(boolean z) {
        this.f20996j = z;
    }

    public void setCoveredFadeColor(int i) {
        this.f20988b = i;
        requestLayout();
    }

    public void setDragView(View view) {
        View view2 = this.f20997k;
        if (view2 != null) {
            view2.setOnClickListener((View.OnClickListener) null);
        }
        this.f20997k = view;
        if (view != null) {
            view.setClickable(true);
            this.f20997k.setFocusable(false);
            this.f20997k.setFocusableInTouchMode(false);
            this.f20997k.setOnClickListener(new C3800a());
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.f20983E = onClickListener;
    }

    public void setGravity(int i) {
        if (i == 48 || i == 80) {
            this.f20994h = i == 80;
            if (!this.f20985G) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setMinFlingVelocity(int i) {
        this.f20987a = i;
    }

    public void setOverlayed(boolean z) {
        this.f20995i = z;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() != i) {
            this.f20991e = i;
            if (!this.f20985G) {
                requestLayout();
            }
            if (getPanelState() == PanelState.COLLAPSED) {
                smoothToBottom();
                invalidate();
            }
        }
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        PanelState panelState3;
        if (this.f20984F.getViewDragState() == 2) {
            Log.d(f20976I, "View is settling. Aborting animation.");
            this.f20984F.abort();
        }
        if (panelState == null || panelState == (panelState2 = PanelState.DRAGGING)) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (isEnabled()) {
            boolean z = this.f20985G;
            if ((z || this.f21002p != null) && panelState != (panelState3 = this.f21004r) && panelState3 != panelState2) {
                if (z) {
                    setPanelStateInternal(panelState);
                    return;
                }
                if (panelState3 == PanelState.HIDDEN) {
                    this.f21002p.setVisibility(0);
                    requestLayout();
                }
                int i = C3801b.f21016a[panelState.ordinal()];
                if (i == 1) {
                    mo24196x(1.0f, 0);
                } else if (i == 2) {
                    mo24196x(this.f21008v, 0);
                } else if (i == 3) {
                    mo24196x(m14097q(m14096p(0.0f) + (this.f20994h ? this.f20991e : -this.f20991e)), 0);
                } else if (i == 4) {
                    mo24196x(0.0f, 0);
                }
            }
        }
    }

    public void setParallaxOffset(int i) {
        this.f20993g = i;
        if (!this.f20985G) {
            requestLayout();
        }
    }

    public void setScrollableView(View view) {
        this.f20999m = view;
    }

    public void setScrollableViewHelper(ScrollableViewHelper scrollableViewHelper) {
        this.f21001o = scrollableViewHelper;
    }

    public void setShadowHeight(int i) {
        this.f20992f = i;
        if (!this.f20985G) {
            invalidate();
        }
    }

    public void setTouchEnabled(boolean z) {
        this.f21010x = z;
    }

    /* access modifiers changed from: protected */
    public void smoothToBottom() {
        mo24196x(0.0f, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo24195w() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public boolean mo24196x(float f, int i) {
        if (isEnabled() && this.f21002p != null) {
            int p = m14096p(f);
            ViewDragHelper viewDragHelper = this.f20984F;
            View view = this.f21002p;
            if (viewDragHelper.smoothSlideViewTo(view, view.getLeft(), p)) {
                mo24195w();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo24197y() {
        int i;
        int i2;
        int i3;
        int i4;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.f21002p;
            int i5 = 0;
            if (view == null || !m14098t(view)) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i4 = this.f21002p.getLeft();
                i3 = this.f21002p.getRight();
                i2 = this.f21002p.getTop();
                i = this.f21002p.getBottom();
            }
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max >= i4 && max2 >= i2 && min <= i3 && min2 <= i) {
                i5 = 4;
            }
            childAt.setVisibility(i5);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        private static final int[] f21013a = {16843137};
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f21013a);
            if (obtainStyledAttributes != null) {
                this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlidingUpPanelLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            r11 = 400(0x190, float:5.6E-43)
            r8.f20987a = r11
            r0 = -1728053248(0xffffffff99000000, float:-6.617445E-24)
            r8.f20988b = r0
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r8.f20989c = r1
            r1 = -1
            r8.f20991e = r1
            r8.f20992f = r1
            r8.f20993g = r1
            r2 = 0
            r8.f20995i = r2
            r3 = 1
            r8.f20996j = r3
            r8.f20998l = r1
            com.sothree.slidinguppanel.ScrollableViewHelper r4 = new com.sothree.slidinguppanel.ScrollableViewHelper
            r4.<init>()
            r8.f21001o = r4
            com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r4 = f20977J
            r8.f21004r = r4
            r8.f21005s = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r8.f21008v = r4
            r8.f20981C = r2
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList
            r5.<init>()
            r8.f20982D = r5
            r8.f20985G = r3
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            r8.f20986H = r5
            boolean r5 = r8.isInEditMode()
            r6 = 0
            if (r5 == 0) goto L_0x0050
            r8.f20990d = r6
            r8.f20984F = r6
            return
        L_0x0050:
            if (r10 == 0) goto L_0x00e2
            int[] r5 = f20978K
            android.content.res.TypedArray r5 = r9.obtainStyledAttributes(r10, r5)
            if (r5 == 0) goto L_0x0064
            int r7 = r5.getInt(r2, r2)
            r8.setGravity(r7)
            r5.recycle()
        L_0x0064:
            int[] r5 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout
            android.content.res.TypedArray r10 = r9.obtainStyledAttributes(r10, r5)
            if (r10 == 0) goto L_0x00e2
            int r5 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoPanelHeight
            int r5 = r10.getDimensionPixelSize(r5, r1)
            r8.f20991e = r5
            int r5 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoShadowHeight
            int r5 = r10.getDimensionPixelSize(r5, r1)
            r8.f20992f = r5
            int r5 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoParallaxOffset
            int r5 = r10.getDimensionPixelSize(r5, r1)
            r8.f20993g = r5
            int r5 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoFlingVelocity
            int r11 = r10.getInt(r5, r11)
            r8.f20987a = r11
            int r11 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoFadeColor
            int r11 = r10.getColor(r11, r0)
            r8.f20988b = r11
            int r11 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoDragView
            int r11 = r10.getResourceId(r11, r1)
            r8.f20998l = r11
            int r11 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoScrollableView
            int r11 = r10.getResourceId(r11, r1)
            r8.f21000n = r11
            int r11 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoOverlay
            boolean r11 = r10.getBoolean(r11, r2)
            r8.f20995i = r11
            int r11 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoClipPanel
            boolean r11 = r10.getBoolean(r11, r3)
            r8.f20996j = r11
            int r11 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoAnchorPoint
            float r11 = r10.getFloat(r11, r4)
            r8.f21008v = r11
            com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState[] r11 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.values()
            int r0 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoInitialState
            com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r4 = f20977J
            int r4 = r4.ordinal()
            int r0 = r10.getInt(r0, r4)
            r11 = r11[r0]
            r8.f21004r = r11
            int r11 = com.sothree.slidinguppanel.library.C3805R.styleable.SlidingUpPanelLayout_umanoScrollInterpolator
            int r11 = r10.getResourceId(r11, r1)
            if (r11 == r1) goto L_0x00dd
            android.view.animation.Interpolator r11 = android.view.animation.AnimationUtils.loadInterpolator(r9, r11)
            goto L_0x00de
        L_0x00dd:
            r11 = r6
        L_0x00de:
            r10.recycle()
            goto L_0x00e3
        L_0x00e2:
            r11 = r6
        L_0x00e3:
            android.content.res.Resources r9 = r9.getResources()
            android.util.DisplayMetrics r9 = r9.getDisplayMetrics()
            float r9 = r9.density
            int r10 = r8.f20991e
            r0 = 1056964608(0x3f000000, float:0.5)
            if (r10 != r1) goto L_0x00fb
            r10 = 1116209152(0x42880000, float:68.0)
            float r10 = r10 * r9
            float r10 = r10 + r0
            int r10 = (int) r10
            r8.f20991e = r10
        L_0x00fb:
            int r10 = r8.f20992f
            if (r10 != r1) goto L_0x0107
            r10 = 1082130432(0x40800000, float:4.0)
            float r10 = r10 * r9
            float r10 = r10 + r0
            int r10 = (int) r10
            r8.f20992f = r10
        L_0x0107:
            int r10 = r8.f20993g
            if (r10 != r1) goto L_0x0111
            r10 = 0
            float r10 = r10 * r9
            int r10 = (int) r10
            r8.f20993g = r10
        L_0x0111:
            int r10 = r8.f20992f
            if (r10 <= 0) goto L_0x0133
            boolean r10 = r8.f20994h
            if (r10 == 0) goto L_0x0126
            android.content.res.Resources r10 = r8.getResources()
            int r1 = com.sothree.slidinguppanel.library.C3805R.C3806drawable.above_shadow
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r1)
            r8.f20990d = r10
            goto L_0x0135
        L_0x0126:
            android.content.res.Resources r10 = r8.getResources()
            int r1 = com.sothree.slidinguppanel.library.C3805R.C3806drawable.below_shadow
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r1)
            r8.f20990d = r10
            goto L_0x0135
        L_0x0133:
            r8.f20990d = r6
        L_0x0135:
            r8.setWillNotDraw(r2)
            com.sothree.slidinguppanel.SlidingUpPanelLayout$c r10 = new com.sothree.slidinguppanel.SlidingUpPanelLayout$c
            r10.<init>(r8, r6)
            com.sothree.slidinguppanel.ViewDragHelper r10 = com.sothree.slidinguppanel.ViewDragHelper.create(r8, r0, r11, r10)
            r8.f20984F = r10
            int r11 = r8.f20987a
            float r11 = (float) r11
            float r11 = r11 * r9
            r10.setMinVelocity(r11)
            r8.f21010x = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setDragView(int i) {
        this.f20998l = i;
        setDragView(findViewById(i));
    }
}
