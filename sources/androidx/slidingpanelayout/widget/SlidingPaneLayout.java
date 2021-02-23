package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.C0129Px;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a */
    private int f4620a;

    /* renamed from: b */
    private int f4621b;

    /* renamed from: c */
    private Drawable f4622c;

    /* renamed from: d */
    private Drawable f4623d;

    /* renamed from: e */
    private final int f4624e;

    /* renamed from: f */
    private boolean f4625f;

    /* renamed from: g */
    View f4626g;

    /* renamed from: h */
    float f4627h;

    /* renamed from: i */
    private float f4628i;

    /* renamed from: j */
    int f4629j;

    /* renamed from: k */
    boolean f4630k;

    /* renamed from: l */
    private int f4631l;

    /* renamed from: m */
    private float f4632m;

    /* renamed from: n */
    private float f4633n;

    /* renamed from: o */
    private PanelSlideListener f4634o;

    /* renamed from: p */
    final ViewDragHelper f4635p;

    /* renamed from: q */
    boolean f4636q;

    /* renamed from: r */
    private boolean f4637r;

    /* renamed from: s */
    private final Rect f4638s;

    /* renamed from: t */
    final ArrayList<C0999b> f4639t;

    /* renamed from: u */
    private Method f4640u;

    /* renamed from: v */
    private Field f4641v;

    /* renamed from: w */
    private boolean f4642w;

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0997a();

        /* renamed from: b */
        boolean f4647b;

        /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState$a */
        static class C0997a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0997a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4647b ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4647b = parcel.readInt() != 0;
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelClosed(View view) {
        }

        public void onPanelOpened(View view) {
        }

        public void onPanelSlide(View view, float f) {
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$a */
    class C0998a extends AccessibilityDelegateCompat {

        /* renamed from: d */
        private final Rect f4648d = new Rect();

        C0998a() {
        }

        /* renamed from: e */
        private void m3652e(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f4648d;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        /* renamed from: f */
        public boolean mo8002f(View view) {
            return SlidingPaneLayout.this.mo7956g(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            m3652e(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!mo8002f(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!mo8002f(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$b */
    private class C0999b implements Runnable {

        /* renamed from: a */
        final View f4650a;

        C0999b(View view) {
            this.f4650a = view;
        }

        public void run() {
            if (this.f4650a.getParent() == SlidingPaneLayout.this) {
                this.f4650a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.mo7955f(this.f4650a);
            }
            SlidingPaneLayout.this.f4639t.remove(this);
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$c */
    private class C1000c extends ViewDragHelper.Callback {
        C1000c() {
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f4626g.getLayoutParams();
            if (SlidingPaneLayout.this.mo7963h()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f4626g.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.f4629j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.f4629j + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f4629j;
        }

        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f4635p.captureChildView(slidingPaneLayout.f4626g, i2);
        }

        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.mo7967l();
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.f4635p.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f4627h == 0.0f) {
                    slidingPaneLayout.mo7969n(slidingPaneLayout.f4626g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.mo7945c(slidingPaneLayout2.f4626g);
                    SlidingPaneLayout.this.f4636q = false;
                    return;
                }
                slidingPaneLayout.mo7951d(slidingPaneLayout.f4626g);
                SlidingPaneLayout.this.f4636q = true;
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.mo7964i(i);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.mo7963h()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.f4627h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f4629j;
                }
                i = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f4626g.getWidth();
            } else {
                i = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.f4627h > 0.5f)) {
                    i += SlidingPaneLayout.this.f4629j;
                }
            }
            SlidingPaneLayout.this.f4635p.settleCapturedViewAt(i, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.f4630k) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f4644a;
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private boolean m3634a(View view, int i) {
        if (!this.f4637r && !mo7968m(0.0f, i)) {
            return false;
        }
        this.f4636q = false;
        return true;
    }

    /* renamed from: b */
    private void m3635b(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
            if (layoutParams.f4646c == null) {
                layoutParams.f4646c = new Paint();
            }
            layoutParams.f4646c.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f4646c);
            }
            mo7955f(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.f4646c;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            C0999b bVar = new C0999b(view);
            this.f4639t.add(bVar);
            ViewCompat.postOnAnimation(this, bVar);
        }
    }

    /* renamed from: j */
    private boolean m3636j(View view, int i) {
        if (!this.f4637r && !mo7968m(1.0f, i)) {
            return false;
        }
        this.f4636q = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3637k(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.mo7963h()
            android.view.View r1 = r9.f4626g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.f4645b
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0059
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f4626g
            if (r4 != r5) goto L_0x002c
            goto L_0x0056
        L_0x002c:
            float r5 = r9.f4628i
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f4631l
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.f4628i = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0056
            float r5 = r9.f4628i
            if (r0 == 0) goto L_0x004f
            float r5 = r5 - r6
            goto L_0x0051
        L_0x004f:
            float r5 = r6 - r5
        L_0x0051:
            int r6 = r9.f4621b
            r9.m3635b(r4, r5, r6)
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.m3637k(float):void");
    }

    /* renamed from: o */
    private static boolean m3638o(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7945c(View view) {
        PanelSlideListener panelSlideListener = this.f4634o;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
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
        if (z) {
            if (view.canScrollHorizontally(mo7963h() ? i : -i)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.f4625f;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return m3634a(this.f4626g, 0);
    }

    public void computeScroll() {
        if (!this.f4635p.continueSettling(true)) {
            return;
        }
        if (!this.f4625f) {
            this.f4635p.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo7951d(View view) {
        PanelSlideListener panelSlideListener = this.f4634o;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        super.draw(canvas);
        if (mo7963h()) {
            drawable = this.f4623d;
        } else {
            drawable = this.f4622c;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (mo7963h()) {
                i2 = childAt.getRight();
                i = intrinsicWidth + i2;
            } else {
                int left = childAt.getLeft();
                int i3 = left - intrinsicWidth;
                i = left;
                i2 = i3;
            }
            drawable.setBounds(i2, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f4625f && !layoutParams.f4644a && this.f4626g != null) {
            canvas.getClipBounds(this.f4638s);
            if (mo7963h()) {
                Rect rect = this.f4638s;
                rect.left = Math.max(rect.left, this.f4626g.getRight());
            } else {
                Rect rect2 = this.f4638s;
                rect2.right = Math.min(rect2.right, this.f4626g.getLeft());
            }
            canvas.clipRect(this.f4638s);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo7954e(View view) {
        PanelSlideListener panelSlideListener = this.f4634o;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.f4627h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo7955f(View view) {
        Field field;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).f4646c);
            return;
        }
        if (i >= 16) {
            if (!this.f4642w) {
                try {
                    this.f4640u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
                }
                try {
                    Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                    this.f4641v = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.f4642w = true;
            }
            if (this.f4640u == null || (field = this.f4641v) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.f4640u.invoke(view, (Object[]) null);
            } catch (Exception e3) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo7956g(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.f4625f || !layoutParams.f4645b || this.f4627h <= 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.f4621b;
    }

    @C0129Px
    public int getParallaxDistance() {
        return this.f4631l;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.f4620a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo7963h() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo7964i(int i) {
        if (this.f4626g == null) {
            this.f4627h = 0.0f;
            return;
        }
        boolean h = mo7963h();
        LayoutParams layoutParams = (LayoutParams) this.f4626g.getLayoutParams();
        int width = this.f4626g.getWidth();
        if (h) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = ((float) (i - ((h ? getPaddingRight() : getPaddingLeft()) + (h ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.f4629j);
        this.f4627h = paddingRight;
        if (this.f4631l != 0) {
            m3637k(paddingRight);
        }
        if (layoutParams.f4645b) {
            m3635b(this.f4626g, this.f4627h, this.f4620a);
        }
        mo7954e(this.f4626g);
    }

    public boolean isOpen() {
        return !this.f4625f || this.f4627h == 1.0f;
    }

    public boolean isSlideable() {
        return this.f4625f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo7967l() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo7968m(float f, int i) {
        int i2;
        if (!this.f4625f) {
            return false;
        }
        boolean h = mo7963h();
        LayoutParams layoutParams = (LayoutParams) this.f4626g.getLayoutParams();
        if (h) {
            i2 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f * ((float) this.f4629j))) + ((float) this.f4626g.getWidth())));
        } else {
            i2 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f * ((float) this.f4629j)));
        }
        ViewDragHelper viewDragHelper = this.f4635p;
        View view = this.f4626g;
        if (!viewDragHelper.smoothSlideViewTo(view, i2, view.getTop())) {
            return false;
        }
        mo7967l();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo7969n(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        boolean z;
        View view2 = view;
        boolean h = mo7963h();
        int width = h ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = h ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !m3638o(view)) {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 < childCount && (childAt = getChildAt(i5)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z = h;
                } else {
                    z = h;
                    childAt.setVisibility((Math.max(h ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(h ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4);
                }
                i5++;
                view2 = view;
                h = z;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4637r = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4637r = true;
        int size = this.f4639t.size();
        for (int i = 0; i < size; i++) {
            this.f4639t.get(i).run();
        }
        this.f4639t.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f4625f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f4636q = !this.f4635p.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f4625f || (this.f4630k && actionMasked != 0)) {
            this.f4635p.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f4635p.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f4630k = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f4632m = x;
                this.f4633n = y;
                if (this.f4635p.isViewUnder(this.f4626g, (int) x, (int) y) && mo7956g(this.f4626g)) {
                    z = true;
                    if (this.f4635p.shouldInterceptTouchEvent(motionEvent) && !z) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.f4632m);
                float abs2 = Math.abs(y2 - this.f4633n);
                if (abs > ((float) this.f4635p.getTouchSlop()) && abs2 > abs) {
                    this.f4635p.cancel();
                    this.f4630k = true;
                    return false;
                }
            }
            z = false;
            return this.f4635p.shouldInterceptTouchEvent(motionEvent) ? true : true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean h = mo7963h();
        if (h) {
            this.f4635p.setEdgeTrackingEnabled(2);
        } else {
            this.f4635p.setEdgeTrackingEnabled(1);
        }
        int i9 = i3 - i;
        int paddingRight = h ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = h ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f4637r) {
            this.f4627h = (!this.f4625f || !this.f4636q) ? 0.0f : 1.0f;
        }
        int i10 = paddingRight;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f4644a) {
                    int i12 = i9 - paddingLeft;
                    int min = (Math.min(paddingRight, i12 - this.f4624e) - i10) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f4629j = min;
                    int i13 = h ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f4645b = ((i10 + i13) + min) + (measuredWidth / 2) > i12;
                    int i14 = (int) (((float) min) * this.f4627h);
                    i10 += i13 + i14;
                    this.f4627h = ((float) i14) / ((float) min);
                    i5 = 0;
                } else if (!this.f4625f || (i8 = this.f4631l) == 0) {
                    i10 = paddingRight;
                    i5 = 0;
                } else {
                    i5 = (int) ((1.0f - this.f4627h) * ((float) i8));
                    i10 = paddingRight;
                }
                if (h) {
                    i6 = (i9 - i10) + i5;
                    i7 = i6 - measuredWidth;
                } else {
                    i7 = i10 - i5;
                    i6 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i6, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.f4637r) {
            if (this.f4625f) {
                if (this.f4631l != 0) {
                    m3637k(this.f4627h);
                }
                if (((LayoutParams) this.f4626g.getLayoutParams()).f4645b) {
                    m3635b(this.f4626g, this.f4627h, this.f4620a);
                }
            } else {
                for (int i15 = 0; i15 < childCount; i15++) {
                    m3635b(getChildAt(i15), 0.0f, this.f4620a);
                }
            }
            mo7969n(this.f4626g);
        }
        this.f4637r = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f;
        int i11;
        int i12;
        int i13;
        int i14;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = 0;
        } else if (mode2 != 1073741824) {
            i4 = 0;
            i3 = 0;
        } else {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = i4;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f4626g = null;
        int i15 = paddingLeft;
        int i16 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (true) {
            i5 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f4645b = z;
            } else {
                float f3 = layoutParams.weight;
                if (f3 > 0.0f) {
                    f2 += f3;
                    if (layoutParams.width == 0) {
                    }
                }
                int i17 = layoutParams.leftMargin + layoutParams.rightMargin;
                int i18 = layoutParams.width;
                if (i18 == -2) {
                    i11 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, Integer.MIN_VALUE);
                    f = f2;
                    i12 = Integer.MIN_VALUE;
                } else {
                    f = f2;
                    i12 = Integer.MIN_VALUE;
                    if (i18 == -1) {
                        i11 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, 1073741824);
                    } else {
                        i11 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    }
                }
                int i19 = layoutParams.height;
                if (i19 == -2) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i3, i12);
                } else {
                    if (i19 == -1) {
                        i14 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    } else {
                        i14 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    }
                    i13 = i14;
                }
                childAt.measure(i11, i13);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i12 && measuredHeight > i4) {
                    i4 = Math.min(measuredHeight, i3);
                }
                i15 -= measuredWidth;
                boolean z3 = i15 < 0;
                layoutParams.f4644a = z3;
                z2 |= z3;
                if (z3) {
                    this.f4626g = childAt;
                }
                f2 = f;
            }
            i16++;
            z = false;
        }
        if (z2 || f2 > 0.0f) {
            int i20 = paddingLeft - this.f4624e;
            int i21 = 0;
            while (i21 < childCount) {
                View childAt2 = getChildAt(i21);
                if (childAt2.getVisibility() != i5) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i5) {
                        boolean z4 = layoutParams2.width == 0 && layoutParams2.weight > 0.0f;
                        if (z4) {
                            i7 = 0;
                        } else {
                            i7 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.f4626g) {
                            if (layoutParams2.weight > 0.0f) {
                                if (layoutParams2.width == 0) {
                                    int i22 = layoutParams2.height;
                                    if (i22 == -2) {
                                        i8 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                                    } else if (i22 == -1) {
                                        i8 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                    } else {
                                        i8 = View.MeasureSpec.makeMeasureSpec(i22, 1073741824);
                                    }
                                } else {
                                    i8 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i23 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    i6 = i20;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i23, 1073741824);
                                    if (i7 != i23) {
                                        childAt2.measure(makeMeasureSpec, i8);
                                    }
                                    i21++;
                                    i20 = i6;
                                    i5 = 8;
                                } else {
                                    i6 = i20;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i7 + ((int) ((layoutParams2.weight * ((float) Math.max(0, i15))) / f2)), 1073741824), i8);
                                    i21++;
                                    i20 = i6;
                                    i5 = 8;
                                }
                            }
                        } else if (layoutParams2.width < 0 && (i7 > i20 || layoutParams2.weight > 0.0f)) {
                            if (z4) {
                                int i24 = layoutParams2.height;
                                if (i24 == -2) {
                                    i10 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                                    i9 = 1073741824;
                                } else if (i24 == -1) {
                                    i9 = 1073741824;
                                    i10 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                } else {
                                    i9 = 1073741824;
                                    i10 = View.MeasureSpec.makeMeasureSpec(i24, 1073741824);
                                }
                            } else {
                                i9 = 1073741824;
                                i10 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i20, i9), i10);
                        }
                    }
                }
                i6 = i20;
                i21++;
                i20 = i6;
                i5 = 8;
            }
        }
        setMeasuredDimension(size, i4 + getPaddingTop() + getPaddingBottom());
        this.f4625f = z2;
        if (this.f4635p.getViewDragState() != 0 && !z2) {
            this.f4635p.abort();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f4647b) {
            openPane();
        } else {
            closePane();
        }
        this.f4636q = savedState.f4647b;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4647b = isSlideable() ? isOpen() : this.f4636q;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f4637r = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4625f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4635p.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f4632m = x;
            this.f4633n = y;
        } else if (actionMasked == 1 && mo7956g(this.f4626g)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.f4632m;
            float f2 = y2 - this.f4633n;
            int touchSlop = this.f4635p.getTouchSlop();
            if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop)) && this.f4635p.isViewUnder(this.f4626g, (int) x2, (int) y2)) {
                m3634a(this.f4626g, 0);
            }
        }
        return true;
    }

    public boolean openPane() {
        return m3636j(this.f4626g, 0);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f4625f) {
            this.f4636q = view == this.f4626g;
        }
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.f4621b = i;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.f4634o = panelSlideListener;
    }

    public void setParallaxDistance(@C0129Px int i) {
        this.f4631l = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.f4622c = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.f4623d = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i));
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.f4620a = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: d */
        private static final int[] f4643d = {16843137};

        /* renamed from: a */
        boolean f4644a;

        /* renamed from: b */
        boolean f4645b;

        /* renamed from: c */
        Paint f4646c;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4643d);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4620a = -858993460;
        this.f4637r = true;
        this.f4638s = new Rect();
        this.f4639t = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.f4624e = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new C0998a());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new C1000c());
        this.f4635p = create;
        create.setMinVelocity(f * 400.0f);
    }
}
