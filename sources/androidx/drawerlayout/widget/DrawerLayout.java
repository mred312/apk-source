package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {

    /* renamed from: K */
    private static final int[] f2890K = {16843828};

    /* renamed from: L */
    static final int[] f2891L = {16842931};
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;

    /* renamed from: M */
    static final boolean f2892M;

    /* renamed from: N */
    private static final boolean f2893N;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: A */
    private CharSequence f2894A;

    /* renamed from: B */
    private Object f2895B;

    /* renamed from: C */
    private boolean f2896C;

    /* renamed from: D */
    private Drawable f2897D;

    /* renamed from: E */
    private Drawable f2898E;

    /* renamed from: F */
    private Drawable f2899F;

    /* renamed from: G */
    private Drawable f2900G;

    /* renamed from: H */
    private final ArrayList<View> f2901H;

    /* renamed from: I */
    private Rect f2902I;

    /* renamed from: J */
    private Matrix f2903J;

    /* renamed from: a */
    private final C0607c f2904a;

    /* renamed from: b */
    private float f2905b;

    /* renamed from: c */
    private int f2906c;

    /* renamed from: d */
    private int f2907d;

    /* renamed from: e */
    private float f2908e;

    /* renamed from: f */
    private Paint f2909f;

    /* renamed from: g */
    private final ViewDragHelper f2910g;

    /* renamed from: h */
    private final ViewDragHelper f2911h;

    /* renamed from: i */
    private final C0608d f2912i;

    /* renamed from: j */
    private final C0608d f2913j;

    /* renamed from: k */
    private int f2914k;

    /* renamed from: l */
    private boolean f2915l;

    /* renamed from: m */
    private boolean f2916m;

    /* renamed from: n */
    private int f2917n;

    /* renamed from: o */
    private int f2918o;

    /* renamed from: p */
    private int f2919p;

    /* renamed from: q */
    private int f2920q;

    /* renamed from: r */
    private boolean f2921r;
    @Nullable

    /* renamed from: s */
    private DrawerListener f2922s;

    /* renamed from: t */
    private List<DrawerListener> f2923t;

    /* renamed from: u */
    private float f2924u;

    /* renamed from: v */
    private float f2925v;

    /* renamed from: w */
    private Drawable f2926w;

    /* renamed from: x */
    private Drawable f2927x;

    /* renamed from: y */
    private Drawable f2928y;

    /* renamed from: z */
    private CharSequence f2929z;

    public interface DrawerListener {
        void onDrawerClosed(@NonNull View view);

        void onDrawerOpened(@NonNull View view);

        void onDrawerSlide(@NonNull View view, float f);

        void onDrawerStateChanged(int i);
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public void onDrawerClosed(View view) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerStateChanged(int i) {
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$a */
    class C0605a implements View.OnApplyWindowInsetsListener {
        C0605a(DrawerLayout drawerLayout) {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$b */
    class C0606b extends AccessibilityDelegateCompat {

        /* renamed from: d */
        private final Rect f2938d = new Rect();

        C0606b() {
        }

        /* renamed from: e */
        private void m2096e(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m2071r(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        /* renamed from: f */
        private void m2097f(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f2938d;
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
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence drawerTitle;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View j = DrawerLayout.this.mo5331j();
            if (j == null || (drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.mo5332k(j))) == null) {
                return true;
            }
            text.add(drawerTitle);
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f2892M) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                accessibilityNodeInfoCompat.setSource(view);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                m2097f(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                m2096e(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f2892M || DrawerLayout.m2071r(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$c */
    static final class C0607c extends AccessibilityDelegateCompat {
        C0607c() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.m2071r(view)) {
                accessibilityNodeInfoCompat.setParent((View) null);
            }
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$d */
    private class C0608d extends ViewDragHelper.Callback {

        /* renamed from: a */
        private final int f2940a;

        /* renamed from: b */
        private ViewDragHelper f2941b;

        /* renamed from: c */
        private final Runnable f2942c = new C0609a();

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$d$a */
        class C0609a implements Runnable {
            C0609a() {
            }

            public void run() {
                C0608d.this.mo5376b();
            }
        }

        C0608d(int i) {
            this.f2940a = i;
        }

        /* renamed from: a */
        private void m2098a() {
            int i = 3;
            if (this.f2940a == 3) {
                i = 5;
            }
            View h = DrawerLayout.this.mo5325h(i);
            if (h != null) {
                DrawerLayout.this.closeDrawer(h);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5376b() {
            View view;
            int i;
            int edgeSize = this.f2941b.getEdgeSize();
            int i2 = 0;
            boolean z = this.f2940a == 3;
            if (z) {
                view = DrawerLayout.this.mo5325h(3);
                if (view != null) {
                    i2 = -view.getWidth();
                }
                i = i2 + edgeSize;
            } else {
                view = DrawerLayout.this.mo5325h(5);
                i = DrawerLayout.this.getWidth() - edgeSize;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.f2941b.smoothSlideViewTo(view, i, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f2931b = true;
                DrawerLayout.this.invalidate();
                m2098a();
                DrawerLayout.this.mo5299a();
            }
        }

        /* renamed from: c */
        public void mo5377c() {
            DrawerLayout.this.removeCallbacks(this.f2942c);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.mo5303b(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        /* renamed from: d */
        public void mo5378d(ViewDragHelper viewDragHelper) {
            this.f2941b = viewDragHelper;
        }

        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.mo5367t(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
            View view;
            if ((i & 1) == 1) {
                view = DrawerLayout.this.mo5325h(3);
            } else {
                view = DrawerLayout.this.mo5325h(5);
            }
            if (view != null && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.f2941b.captureChildView(view, i2);
            }
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f2942c, 160);
        }

        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f2931b = false;
            m2098a();
        }

        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.mo5298C(this.f2940a, i, this.f2941b.getCapturedView());
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.mo5303b(view, 3)) {
                f = (float) (i + width);
            } else {
                f = (float) (DrawerLayout.this.getWidth() - i);
            }
            float f2 = f / ((float) width);
            DrawerLayout.this.mo5297A(view, f2);
            view.setVisibility(f2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            float l = DrawerLayout.this.mo5333l(view);
            int width = view.getWidth();
            if (DrawerLayout.this.mo5303b(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && l > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && l > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f2941b.settleCapturedViewAt(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.mo5367t(view) && DrawerLayout.this.mo5303b(view, this.f2940a) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }
    }

    static {
        boolean z = true;
        int i = Build.VERSION.SDK_INT;
        f2892M = i >= 19;
        if (i < 21) {
            z = false;
        }
        f2893N = z;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: B */
    private void m2064B(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || mo5367t(childAt)) && (!z || childAt != view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    /* renamed from: g */
    private boolean m2065g(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent m = m2066m(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(m);
            m.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    /* renamed from: m */
    private MotionEvent m2066m(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f2903J == null) {
                this.f2903J = new Matrix();
            }
            matrix.invert(this.f2903J);
            obtain.transform(this.f2903J);
        }
        return obtain;
    }

    /* renamed from: n */
    static String m2067n(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    /* renamed from: o */
    private static boolean m2068o(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    /* renamed from: p */
    private boolean m2069p() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f2931b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    private boolean m2070q() {
        return mo5331j() != null;
    }

    /* renamed from: r */
    static boolean m2071r(View view) {
        return (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true;
    }

    /* renamed from: u */
    private boolean m2072u(float f, float f2, View view) {
        if (this.f2902I == null) {
            this.f2902I = new Rect();
        }
        view.getHitRect(this.f2902I);
        return this.f2902I.contains((int) f, (int) f2);
    }

    /* renamed from: v */
    private boolean m2073v(Drawable drawable, int i) {
        if (drawable == null || !DrawableCompat.isAutoMirrored(drawable)) {
            return false;
        }
        DrawableCompat.setLayoutDirection(drawable, i);
        return true;
    }

    /* renamed from: x */
    private Drawable m2074x() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.f2897D;
            if (drawable != null) {
                m2073v(drawable, layoutDirection);
                return this.f2897D;
            }
        } else {
            Drawable drawable2 = this.f2898E;
            if (drawable2 != null) {
                m2073v(drawable2, layoutDirection);
                return this.f2898E;
            }
        }
        return this.f2899F;
    }

    /* renamed from: y */
    private Drawable m2075y() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.f2898E;
            if (drawable != null) {
                m2073v(drawable, layoutDirection);
                return this.f2898E;
            }
        } else {
            Drawable drawable2 = this.f2897D;
            if (drawable2 != null) {
                m2073v(drawable2, layoutDirection);
                return this.f2897D;
            }
        }
        return this.f2900G;
    }

    /* renamed from: z */
    private void m2076z() {
        if (!f2893N) {
            this.f2927x = m2074x();
            this.f2928y = m2075y();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public void mo5297A(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f2930a) {
            layoutParams.f2930a = f;
            mo5316f(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public void mo5298C(int i, int i2, View view) {
        int viewDragState = this.f2910g.getViewDragState();
        int viewDragState2 = this.f2911h.getViewDragState();
        int i3 = 2;
        if (viewDragState == 1 || viewDragState2 == 1) {
            i3 = 1;
        } else if (!(viewDragState == 2 || viewDragState2 == 2)) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f = ((LayoutParams) view.getLayoutParams()).f2930a;
            if (f == 0.0f) {
                mo5312d(view);
            } else if (f == 1.0f) {
                mo5315e(view);
            }
        }
        if (i3 != this.f2914k) {
            this.f2914k = i3;
            List<DrawerListener> list = this.f2923t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2923t.get(size).onDrawerStateChanged(i3);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5299a() {
        if (!this.f2921r) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f2921r = true;
        }
    }

    public void addDrawerListener(@NonNull DrawerListener drawerListener) {
        if (drawerListener != null) {
            if (this.f2923t == null) {
                this.f2923t = new ArrayList();
            }
            this.f2923t.add(drawerListener);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!mo5367t(childAt)) {
                    this.f2901H.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            }
            if (!z) {
                int size = this.f2901H.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.f2901H.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f2901H.clear();
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (mo5326i() != null || mo5367t(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (!f2892M) {
            ViewCompat.setAccessibilityDelegate(view, this.f2904a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5303b(View view, int i) {
        return (mo5332k(view) & i) == i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5304c(boolean z) {
        boolean z2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (mo5367t(childAt) && (!z || layoutParams.f2931b)) {
                int width = childAt.getWidth();
                if (mo5303b(childAt, 3)) {
                    z2 = this.f2910g.smoothSlideViewTo(childAt, -width, childAt.getTop());
                } else {
                    z2 = this.f2911h.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                }
                z3 |= z2;
                layoutParams.f2931b = false;
            }
        }
        this.f2912i.mo5377c();
        this.f2913j.mo5377c();
        if (z3) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void closeDrawer(@NonNull View view) {
        closeDrawer(view, true);
    }

    public void closeDrawers() {
        mo5304c(false);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f2930a);
        }
        this.f2908e = f;
        boolean continueSettling = this.f2910g.continueSettling(true);
        boolean continueSettling2 = this.f2911h.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5312d(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2932c & 1) == 1) {
            layoutParams.f2932c = 0;
            List<DrawerListener> list = this.f2923t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2923t.get(size).onDrawerClosed(view);
                }
            }
            m2064B(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2908e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (m2072u(x, y, childAt) && !mo5353s(childAt) && m2065g(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean s = mo5353s(view2);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (s) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view2 && childAt.getVisibility() == 0 && m2068o(childAt) && mo5367t(childAt) && childAt.getHeight() >= height) {
                    if (mo5303b(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.f2908e;
        if (f > 0.0f && s) {
            int i4 = this.f2907d;
            this.f2909f.setColor((i4 & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) ((-16777216 & i4) >>> 24)) * f)) << 24));
            canvas.drawRect((float) i, 0.0f, (float) width, (float) getHeight(), this.f2909f);
        } else if (this.f2927x != null && mo5303b(view2, 3)) {
            int intrinsicWidth = this.f2927x.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f2910g.getEdgeSize()), 1.0f));
            this.f2927x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f2927x.setAlpha((int) (max * 255.0f));
            this.f2927x.draw(canvas);
        } else if (this.f2928y != null && mo5303b(view2, 5)) {
            int intrinsicWidth2 = this.f2928y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f2911h.getEdgeSize()), 1.0f));
            this.f2928y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f2928y.setAlpha((int) (max2 * 255.0f));
            this.f2928y.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5315e(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2932c & 1) == 0) {
            layoutParams.f2932c = 1;
            List<DrawerListener> list = this.f2923t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2923t.get(size).onDrawerOpened(view);
                }
            }
            m2064B(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5316f(View view, float f) {
        List<DrawerListener> list = this.f2923t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2923t.get(size).onDrawerSlide(view, f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (f2893N) {
            return this.f2905b;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i == 3) {
            int i2 = this.f2917n;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.f2919p : this.f2920q;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i == 5) {
            int i4 = this.f2918o;
            if (i4 != 3) {
                return i4;
            }
            int i5 = layoutDirection == 0 ? this.f2920q : this.f2919p;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        } else if (i == 8388611) {
            int i6 = this.f2919p;
            if (i6 != 3) {
                return i6;
            }
            int i7 = layoutDirection == 0 ? this.f2917n : this.f2918o;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i != 8388613) {
            return 0;
        } else {
            int i8 = this.f2920q;
            if (i8 != 3) {
                return i8;
            }
            int i9 = layoutDirection == 0 ? this.f2918o : this.f2917n;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        }
    }

    @Nullable
    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.f2929z;
        }
        if (absoluteGravity == 5) {
            return this.f2894A;
        }
        return null;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2926w;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public View mo5325h(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((mo5332k(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public View mo5326i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f2932c & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        if (mo5367t(view)) {
            return (((LayoutParams) view.getLayoutParams()).f2932c & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(@NonNull View view) {
        if (mo5367t(view)) {
            return ((LayoutParams) view.getLayoutParams()).f2930a > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public View mo5331j() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (mo5367t(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo5332k(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public float mo5333l(View view) {
        return ((LayoutParams) view.getLayoutParams()).f2930a;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2916m = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2916m = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.f2895B;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.f2896C
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.f2926w
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.f2895B
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.f2926w
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.f2926w
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r7 = r6.f2910g.findTopChildUnder((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.f2910g
            boolean r1 = r1.shouldInterceptTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.f2911h
            boolean r2 = r2.shouldInterceptTouchEvent(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0036
        L_0x001e:
            androidx.customview.widget.ViewDragHelper r7 = r6.f2910g
            boolean r7 = r7.checkTouchSlop(r4)
            if (r7 == 0) goto L_0x0036
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.f2912i
            r7.mo5377c()
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.f2913j
            r7.mo5377c()
            goto L_0x0036
        L_0x0031:
            r6.mo5304c(r2)
            r6.f2921r = r3
        L_0x0036:
            r7 = 0
            goto L_0x0060
        L_0x0038:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2924u = r0
            r6.f2925v = r7
            float r4 = r6.f2908e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            androidx.customview.widget.ViewDragHelper r4 = r6.f2910g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.findTopChildUnder(r0, r7)
            if (r7 == 0) goto L_0x005d
            boolean r7 = r6.mo5353s(r7)
            if (r7 == 0) goto L_0x005d
            r7 = 1
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            r6.f2921r = r3
        L_0x0060:
            if (r1 != 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.m2069p()
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.f2921r
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = 0
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m2070q()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View j = mo5331j();
        if (j != null && getDrawerLockMode(j) == 0) {
            closeDrawers();
        }
        return j != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        this.f2915l = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (mo5353s(childAt)) {
                    int i8 = layoutParams.leftMargin;
                    childAt.layout(i8, layoutParams.topMargin, childAt.getMeasuredWidth() + i8, layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mo5303b(childAt, 3)) {
                        float f2 = (float) measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.f2930a * f2));
                        f = ((float) (measuredWidth + i5)) / f2;
                    } else {
                        float f3 = (float) measuredWidth;
                        int i9 = i6 - ((int) (layoutParams.f2930a * f3));
                        f = ((float) (i6 - i9)) / f3;
                        i5 = i9;
                    }
                    boolean z2 = f != layoutParams.f2930a;
                    int i10 = layoutParams.gravity & 112;
                    if (i10 == 16) {
                        int i11 = i4 - i2;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = layoutParams.topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = layoutParams.bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i12, measuredWidth + i5, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = layoutParams.topMargin;
                        childAt.layout(i5, i16, measuredWidth + i5, measuredHeight + i16);
                    } else {
                        int i17 = i4 - i2;
                        childAt.layout(i5, (i17 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i17 - layoutParams.bottomMargin);
                    }
                    if (z2) {
                        mo5297A(childAt, f);
                    }
                    int i18 = layoutParams.f2930a > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
        }
        this.f2915l = false;
        this.f2916m = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011e  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = android.view.View.MeasureSpec.getMode(r19)
            int r3 = android.view.View.MeasureSpec.getMode(r20)
            int r4 = android.view.View.MeasureSpec.getSize(r19)
            int r5 = android.view.View.MeasureSpec.getSize(r20)
            r6 = 300(0x12c, float:4.2E-43)
            r7 = 1073741824(0x40000000, float:2.0)
            if (r2 != r7) goto L_0x001c
            if (r3 == r7) goto L_0x0032
        L_0x001c:
            boolean r8 = r18.isInEditMode()
            if (r8 == 0) goto L_0x01d2
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r8) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            if (r2 != 0) goto L_0x002b
            r4 = 300(0x12c, float:4.2E-43)
        L_0x002b:
            if (r3 != r8) goto L_0x002e
            goto L_0x0032
        L_0x002e:
            if (r3 != 0) goto L_0x0032
            r5 = 300(0x12c, float:4.2E-43)
        L_0x0032:
            r0.setMeasuredDimension(r4, r5)
            java.lang.Object r2 = r0.f2895B
            r6 = 0
            if (r2 == 0) goto L_0x0042
            boolean r2 = androidx.core.view.ViewCompat.getFitsSystemWindows(r18)
            if (r2 == 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            int r8 = androidx.core.view.ViewCompat.getLayoutDirection(r18)
            int r9 = r18.getChildCount()
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x004e:
            if (r10 >= r9) goto L_0x01d1
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0062
            r17 = r2
            r3 = 1073741824(0x40000000, float:2.0)
            goto L_0x0118
        L_0x0062:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r14 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r14
            r15 = 3
            if (r2 == 0) goto L_0x00f5
            int r3 = r14.gravity
            int r3 = androidx.core.view.GravityCompat.getAbsoluteGravity(r3, r8)
            boolean r16 = androidx.core.view.ViewCompat.getFitsSystemWindows(r13)
            r7 = 21
            if (r16 == 0) goto L_0x00ad
            if (r1 < r7) goto L_0x00f5
            java.lang.Object r7 = r0.f2895B
            android.view.WindowInsets r7 = (android.view.WindowInsets) r7
            if (r3 != r15) goto L_0x0094
            int r3 = r7.getSystemWindowInsetLeft()
            int r15 = r7.getSystemWindowInsetTop()
            r17 = r2
            int r2 = r7.getSystemWindowInsetBottom()
            android.view.WindowInsets r7 = r7.replaceSystemWindowInsets(r3, r15, r6, r2)
            goto L_0x00a9
        L_0x0094:
            r17 = r2
            r2 = 5
            if (r3 != r2) goto L_0x00a9
            int r2 = r7.getSystemWindowInsetTop()
            int r3 = r7.getSystemWindowInsetRight()
            int r15 = r7.getSystemWindowInsetBottom()
            android.view.WindowInsets r7 = r7.replaceSystemWindowInsets(r6, r2, r3, r15)
        L_0x00a9:
            r13.dispatchApplyWindowInsets(r7)
            goto L_0x00f7
        L_0x00ad:
            r17 = r2
            if (r1 < r7) goto L_0x00f7
            java.lang.Object r2 = r0.f2895B
            android.view.WindowInsets r2 = (android.view.WindowInsets) r2
            r7 = 3
            if (r3 != r7) goto L_0x00c9
            int r3 = r2.getSystemWindowInsetLeft()
            int r7 = r2.getSystemWindowInsetTop()
            int r15 = r2.getSystemWindowInsetBottom()
            android.view.WindowInsets r2 = r2.replaceSystemWindowInsets(r3, r7, r6, r15)
            goto L_0x00dc
        L_0x00c9:
            r7 = 5
            if (r3 != r7) goto L_0x00dc
            int r3 = r2.getSystemWindowInsetTop()
            int r7 = r2.getSystemWindowInsetRight()
            int r15 = r2.getSystemWindowInsetBottom()
            android.view.WindowInsets r2 = r2.replaceSystemWindowInsets(r6, r3, r7, r15)
        L_0x00dc:
            int r3 = r2.getSystemWindowInsetLeft()
            r14.leftMargin = r3
            int r3 = r2.getSystemWindowInsetTop()
            r14.topMargin = r3
            int r3 = r2.getSystemWindowInsetRight()
            r14.rightMargin = r3
            int r2 = r2.getSystemWindowInsetBottom()
            r14.bottomMargin = r2
            goto L_0x00f7
        L_0x00f5:
            r17 = r2
        L_0x00f7:
            boolean r2 = r0.mo5353s(r13)
            if (r2 == 0) goto L_0x011e
            int r2 = r14.leftMargin
            int r2 = r4 - r2
            int r3 = r14.rightMargin
            int r2 = r2 - r3
            r3 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r3)
            int r7 = r14.topMargin
            int r7 = r5 - r7
            int r14 = r14.bottomMargin
            int r7 = r7 - r14
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r13.measure(r2, r7)
        L_0x0118:
            r15 = r19
            r14 = r20
            goto L_0x01a0
        L_0x011e:
            r3 = 1073741824(0x40000000, float:2.0)
            boolean r2 = r0.mo5367t(r13)
            if (r2 == 0) goto L_0x01a8
            boolean r2 = f2893N
            if (r2 == 0) goto L_0x0137
            float r2 = androidx.core.view.ViewCompat.getElevation(r13)
            float r7 = r0.f2905b
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0137
            androidx.core.view.ViewCompat.setElevation(r13, r7)
        L_0x0137:
            int r2 = r0.mo5332k(r13)
            r2 = r2 & 7
            r7 = 3
            if (r2 != r7) goto L_0x0142
            r7 = 1
            goto L_0x0143
        L_0x0142:
            r7 = 0
        L_0x0143:
            if (r7 == 0) goto L_0x0147
            if (r11 != 0) goto L_0x014c
        L_0x0147:
            if (r7 != 0) goto L_0x017b
            if (r12 != 0) goto L_0x014c
            goto L_0x017b
        L_0x014c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Child drawer has absolute gravity "
            r3.append(r4)
            java.lang.String r2 = m2067n(r2)
            r3.append(r2)
            java.lang.String r2 = " but this "
            r3.append(r2)
            java.lang.String r2 = "DrawerLayout"
            r3.append(r2)
            java.lang.String r2 = " already has a "
            r3.append(r2)
            java.lang.String r2 = "drawer view along that edge"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x017b:
            if (r7 == 0) goto L_0x017f
            r11 = 1
            goto L_0x0180
        L_0x017f:
            r12 = 1
        L_0x0180:
            int r2 = r0.f2906c
            int r7 = r14.leftMargin
            int r2 = r2 + r7
            int r7 = r14.rightMargin
            int r2 = r2 + r7
            int r7 = r14.width
            r15 = r19
            int r2 = android.view.ViewGroup.getChildMeasureSpec(r15, r2, r7)
            int r7 = r14.topMargin
            int r3 = r14.bottomMargin
            int r7 = r7 + r3
            int r3 = r14.height
            r14 = r20
            int r3 = android.view.ViewGroup.getChildMeasureSpec(r14, r7, r3)
            r13.measure(r2, r3)
        L_0x01a0:
            int r10 = r10 + 1
            r2 = r17
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x004e
        L_0x01a8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Child "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = " at index "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r3 = " does not have a valid layout_gravity - must be Gravity.LEFT, "
            r2.append(r3)
            java.lang.String r3 = "Gravity.RIGHT or Gravity.NO_GRAVITY"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d1:
            return
        L_0x01d2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "DrawerLayout must be measured with MeasureSpec.EXACTLY."
            r1.<init>(r2)
            goto L_0x01db
        L_0x01da:
            throw r1
        L_0x01db:
            goto L_0x01da
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View h;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f2933b;
        if (!(i == 0 || (h = mo5325h(i)) == null)) {
            openDrawer(h);
        }
        int i2 = savedState.f2934c;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = savedState.f2935d;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = savedState.f2936e;
        if (i4 != 3) {
            setDrawerLockMode(i4, (int) GravityCompat.START);
        }
        int i5 = savedState.f2937f;
        if (i5 != 3) {
            setDrawerLockMode(i5, (int) GravityCompat.END);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        m2076z();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int i2 = layoutParams.f2932c;
            boolean z = true;
            boolean z2 = i2 == 1;
            if (i2 != 2) {
                z = false;
            }
            if (z2 || z) {
                savedState.f2933b = layoutParams.gravity;
            } else {
                i++;
            }
        }
        savedState.f2934c = this.f2917n;
        savedState.f2935d = this.f2918o;
        savedState.f2936e = this.f2919p;
        savedState.f2937f = this.f2920q;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (getDrawerLockMode(r7) != 2) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.f2910g
            r0.processTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.f2911h
            r0.processTouchEvent(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0062
            if (r0 == r2) goto L_0x0020
            r7 = 3
            if (r0 == r7) goto L_0x001a
            goto L_0x0070
        L_0x001a:
            r6.mo5304c(r2)
            r6.f2921r = r1
            goto L_0x0070
        L_0x0020:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.f2910g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.findTopChildUnder(r4, r5)
            if (r3 == 0) goto L_0x005d
            boolean r3 = r6.mo5353s(r3)
            if (r3 == 0) goto L_0x005d
            float r3 = r6.f2924u
            float r0 = r0 - r3
            float r3 = r6.f2925v
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.f2910g
            int r3 = r3.getTouchSlop()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x005d
            android.view.View r7 = r6.mo5326i()
            if (r7 == 0) goto L_0x005d
            int r7 = r6.getDrawerLockMode((android.view.View) r7)
            r0 = 2
            if (r7 != r0) goto L_0x005e
        L_0x005d:
            r1 = 1
        L_0x005e:
            r6.mo5304c(r1)
            goto L_0x0070
        L_0x0062:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2924u = r0
            r6.f2925v = r7
            r6.f2921r = r1
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void openDrawer(@NonNull View view) {
        openDrawer(view, true);
    }

    public void removeDrawerListener(@NonNull DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener != null && (list = this.f2923t) != null) {
            list.remove(drawerListener);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            mo5304c(true);
        }
    }

    public void requestLayout() {
        if (!this.f2915l) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo5353s(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setChildInsets(Object obj, boolean z) {
        this.f2895B = obj;
        this.f2896C = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f2905b = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (mo5367t(childAt)) {
                ViewCompat.setElevation(childAt, this.f2905b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.f2922s;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.f2922s = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (!f2893N) {
            if ((i & GravityCompat.START) == 8388611) {
                this.f2897D = drawable;
            } else if ((i & GravityCompat.END) == 8388613) {
                this.f2898E = drawable;
            } else if ((i & 3) == 3) {
                this.f2899F = drawable;
            } else if ((i & 5) == 5) {
                this.f2900G = drawable;
            } else {
                return;
            }
            m2076z();
            invalidate();
        }
    }

    public void setDrawerTitle(int i, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.f2929z = charSequence;
        } else if (absoluteGravity == 5) {
            this.f2894A = charSequence;
        }
    }

    public void setScrimColor(@ColorInt int i) {
        this.f2907d = i;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.f2926w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        this.f2926w = new ColorDrawable(i);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public boolean mo5367t(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo5368w(View view, float f) {
        float l = mo5333l(view);
        float width = (float) view.getWidth();
        int i = ((int) (width * f)) - ((int) (l * width));
        if (!mo5303b(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        mo5297A(view, f);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void closeDrawer(@NonNull View view, boolean z) {
        if (mo5367t(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f2916m) {
                layoutParams.f2930a = 0.0f;
                layoutParams.f2932c = 0;
            } else if (z) {
                layoutParams.f2932c |= 4;
                if (mo5303b(view, 3)) {
                    this.f2910g.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
                } else {
                    this.f2911h.smoothSlideViewTo(view, getWidth(), view.getTop());
                }
            } else {
                mo5368w(view, 0.0f);
                mo5298C(layoutParams.gravity, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void openDrawer(@NonNull View view, boolean z) {
        if (mo5367t(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f2916m) {
                layoutParams.f2930a = 1.0f;
                layoutParams.f2932c = 1;
                m2064B(view, true);
            } else if (z) {
                layoutParams.f2932c |= 2;
                if (mo5303b(view, 3)) {
                    this.f2910g.smoothSlideViewTo(view, 0, view.getTop());
                } else {
                    this.f2911h.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                mo5368w(view, 1.0f);
                mo5298C(layoutParams.gravity, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2904a = new C0607c();
        this.f2907d = -1728053248;
        this.f2909f = new Paint();
        this.f2916m = true;
        this.f2917n = 3;
        this.f2918o = 3;
        this.f2919p = 3;
        this.f2920q = 3;
        this.f2897D = null;
        this.f2898E = null;
        this.f2899F = null;
        this.f2900G = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f2906c = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        C0608d dVar = new C0608d(3);
        this.f2912i = dVar;
        C0608d dVar2 = new C0608d(5);
        this.f2913j = dVar2;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, dVar);
        this.f2910g = create;
        create.setEdgeTrackingEnabled(1);
        create.setMinVelocity(f2);
        dVar.mo5378d(create);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, dVar2);
        this.f2911h = create2;
        create2.setEdgeTrackingEnabled(2);
        create2.setMinVelocity(f2);
        dVar2.mo5378d(create2);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new C0606b());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new C0605a(this));
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f2890K);
                try {
                    this.f2926w = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.f2926w = null;
            }
        }
        this.f2905b = f * 10.0f;
        this.f2901H = new ArrayList<>();
    }

    public void setDrawerLockMode(int i, int i2) {
        View h;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (i2 == 3) {
            this.f2917n = i;
        } else if (i2 == 5) {
            this.f2918o = i;
        } else if (i2 == 8388611) {
            this.f2919p = i;
        } else if (i2 == 8388613) {
            this.f2920q = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f2910g : this.f2911h).cancel();
        }
        if (i == 1) {
            View h2 = mo5325h(absoluteGravity);
            if (h2 != null) {
                closeDrawer(h2);
            }
        } else if (i == 2 && (h = mo5325h(absoluteGravity)) != null) {
            openDrawer(h);
        }
    }

    public void setStatusBarBackground(int i) {
        this.f2926w = i != 0 ? ContextCompat.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i) {
        View h = mo5325h(i);
        if (h != null) {
            return isDrawerVisible(h);
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        float f2930a;

        /* renamed from: b */
        boolean f2931b;

        /* renamed from: c */
        int f2932c;
        public int gravity;

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2891L);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }
    }

    public boolean isDrawerOpen(int i) {
        View h = mo5325h(i);
        if (h != null) {
            return isDrawerOpen(h);
        }
        return false;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0604a();

        /* renamed from: b */
        int f2933b = 0;

        /* renamed from: c */
        int f2934c;

        /* renamed from: d */
        int f2935d;

        /* renamed from: e */
        int f2936e;

        /* renamed from: f */
        int f2937f;

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$SavedState$a */
        static class C0604a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0604a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2933b = parcel.readInt();
            this.f2934c = parcel.readInt();
            this.f2935d = parcel.readInt();
            this.f2936e = parcel.readInt();
            this.f2937f = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2933b);
            parcel.writeInt(this.f2934c);
            parcel.writeInt(this.f2935d);
            parcel.writeInt(this.f2936e);
            parcel.writeInt(this.f2937f);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setDrawerShadow(@DrawableRes int i, int i2) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), i), i2);
    }

    public int getDrawerLockMode(@NonNull View view) {
        if (mo5367t(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).gravity);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerLockMode(int i, @NonNull View view) {
        if (mo5367t(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).gravity);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a " + "drawer with appropriate layout_gravity");
    }

    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public void closeDrawer(int i, boolean z) {
        View h = mo5325h(i);
        if (h != null) {
            closeDrawer(h, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + m2067n(i));
    }

    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void openDrawer(int i, boolean z) {
        View h = mo5325h(i);
        if (h != null) {
            openDrawer(h, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + m2067n(i));
    }
}
