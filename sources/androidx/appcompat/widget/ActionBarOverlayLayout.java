package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {

    /* renamed from: F */
    static final int[] f1055F = {C0131R.attr.actionBarSize, 16842841};

    /* renamed from: A */
    ViewPropertyAnimator f1056A;

    /* renamed from: B */
    final AnimatorListenerAdapter f1057B;

    /* renamed from: C */
    private final Runnable f1058C;

    /* renamed from: D */
    private final Runnable f1059D;

    /* renamed from: E */
    private final NestedScrollingParentHelper f1060E;

    /* renamed from: a */
    private int f1061a;

    /* renamed from: b */
    private int f1062b;

    /* renamed from: c */
    private ContentFrameLayout f1063c;

    /* renamed from: d */
    ActionBarContainer f1064d;

    /* renamed from: e */
    private DecorToolbar f1065e;

    /* renamed from: f */
    private Drawable f1066f;

    /* renamed from: g */
    private boolean f1067g;

    /* renamed from: h */
    private boolean f1068h;

    /* renamed from: i */
    private boolean f1069i;

    /* renamed from: j */
    private boolean f1070j;

    /* renamed from: k */
    boolean f1071k;

    /* renamed from: l */
    private int f1072l;

    /* renamed from: m */
    private int f1073m;

    /* renamed from: n */
    private final Rect f1074n;

    /* renamed from: o */
    private final Rect f1075o;

    /* renamed from: p */
    private final Rect f1076p;

    /* renamed from: q */
    private final Rect f1077q;

    /* renamed from: r */
    private final Rect f1078r;

    /* renamed from: s */
    private final Rect f1079s;

    /* renamed from: t */
    private final Rect f1080t;
    @NonNull

    /* renamed from: u */
    private WindowInsetsCompat f1081u;
    @NonNull

    /* renamed from: v */
    private WindowInsetsCompat f1082v;
    @NonNull

    /* renamed from: w */
    private WindowInsetsCompat f1083w;
    @NonNull

    /* renamed from: x */
    private WindowInsetsCompat f1084x;

    /* renamed from: y */
    private ActionBarVisibilityCallback f1085y;

    /* renamed from: z */
    private OverScroller f1086z;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$a */
    class C0235a extends AnimatorListenerAdapter {
        C0235a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1056A = null;
            actionBarOverlayLayout.f1071k = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1056A = null;
            actionBarOverlayLayout.f1071k = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$b */
    class C0236b implements Runnable {
        C0236b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.mo1976d();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1056A = actionBarOverlayLayout.f1064d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1057B);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$c */
    class C0237c implements Runnable {
        C0237c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.mo1976d();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1056A = actionBarOverlayLayout.f1064d.animate().translationY((float) (-ActionBarOverlayLayout.this.f1064d.getHeight())).setListener(ActionBarOverlayLayout.this.f1057B);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m733a() {
        mo1976d();
        this.f1059D.run();
    }

    /* renamed from: b */
    private boolean m734b(@NonNull View view, @NonNull Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z || layoutParams.leftMargin == (i4 = rect.left)) {
            z5 = false;
        } else {
            layoutParams.leftMargin = i4;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != (i3 = rect.top)) {
            layoutParams.topMargin = i3;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != (i2 = rect.right)) {
            layoutParams.rightMargin = i2;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == (i = rect.bottom)) {
            return z5;
        }
        layoutParams.bottomMargin = i;
        return true;
    }

    /* renamed from: c */
    private DecorToolbar m735c(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: e */
    private void m736e(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1055F);
        boolean z = false;
        this.f1061a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1066f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f1067g = z;
        this.f1086z = new OverScroller(context);
    }

    /* renamed from: f */
    private void m737f() {
        mo1976d();
        postDelayed(this.f1059D, 600);
    }

    /* renamed from: g */
    private void m738g() {
        mo1976d();
        postDelayed(this.f1058C, 600);
    }

    /* renamed from: i */
    private void m739i() {
        mo1976d();
        this.f1058C.run();
    }

    /* renamed from: j */
    private boolean m740j(float f) {
        this.f1086z.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1086z.getFinalY() > this.f1064d.getHeight();
    }

    public boolean canShowOverflowMenu() {
        mo1986h();
        return this.f1065e.canShowOverflowMenu();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1976d() {
        removeCallbacks(this.f1058C);
        removeCallbacks(this.f1059D);
        ViewPropertyAnimator viewPropertyAnimator = this.f1056A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void dismissPopups() {
        mo1986h();
        this.f1065e.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1066f != null && !this.f1067g) {
            int bottom = this.f1064d.getVisibility() == 0 ? (int) (((float) this.f1064d.getBottom()) + this.f1064d.getTranslationY() + 0.5f) : 0;
            this.f1066f.setBounds(0, bottom, getWidth(), this.f1066f.getIntrinsicHeight() + bottom);
            this.f1066f.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        mo1986h();
        boolean b = m734b(this.f1064d, rect, true, true, false, true);
        this.f1077q.set(rect);
        ViewUtils.computeFitSystemWindows(this, this.f1077q, this.f1074n);
        if (!this.f1078r.equals(this.f1077q)) {
            this.f1078r.set(this.f1077q);
            b = true;
        }
        if (!this.f1075o.equals(this.f1074n)) {
            this.f1075o.set(this.f1074n);
            b = true;
        }
        if (b) {
            requestLayout();
        }
        return true;
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1064d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.f1060E.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        mo1986h();
        return this.f1065e.getTitle();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1986h() {
        if (this.f1063c == null) {
            this.f1063c = (ContentFrameLayout) findViewById(C0131R.C0133id.action_bar_activity_content);
            this.f1064d = (ActionBarContainer) findViewById(C0131R.C0133id.action_bar_container);
            this.f1065e = m735c(findViewById(C0131R.C0133id.action_bar));
        }
    }

    public boolean hasIcon() {
        mo1986h();
        return this.f1065e.hasIcon();
    }

    public boolean hasLogo() {
        mo1986h();
        return this.f1065e.hasLogo();
    }

    public boolean hideOverflowMenu() {
        mo1986h();
        return this.f1065e.hideOverflowMenu();
    }

    public void initFeature(int i) {
        mo1986h();
        if (i == 2) {
            this.f1065e.initProgress();
        } else if (i == 5) {
            this.f1065e.initIndeterminateProgress();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f1070j;
    }

    public boolean isInOverlayMode() {
        return this.f1068h;
    }

    public boolean isOverflowMenuShowPending() {
        mo1986h();
        return this.f1065e.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        mo1986h();
        return this.f1065e.isOverflowMenuShowing();
    }

    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        mo1986h();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, this);
        boolean b = m734b(this.f1064d, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, this.f1074n);
        Rect rect = this.f1074n;
        WindowInsetsCompat inset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.f1081u = inset;
        boolean z = true;
        if (!this.f1082v.equals(inset)) {
            this.f1082v = this.f1081u;
            b = true;
        }
        if (!this.f1075o.equals(this.f1074n)) {
            this.f1075o.set(this.f1074n);
        } else {
            z = b;
        }
        if (z) {
            requestLayout();
        }
        return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m736e(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo1976d();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        mo1986h();
        measureChildWithMargins(this.f1064d, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1064d.getLayoutParams();
        int max = Math.max(0, this.f1064d.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.f1064d.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1064d.getMeasuredState());
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            i3 = this.f1061a;
            if (this.f1069i && this.f1064d.getTabContainer() != null) {
                i3 += this.f1061a;
            }
        } else {
            i3 = this.f1064d.getVisibility() != 8 ? this.f1064d.getMeasuredHeight() : 0;
        }
        this.f1076p.set(this.f1074n);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            this.f1083w = this.f1081u;
        } else {
            this.f1079s.set(this.f1077q);
        }
        if (!this.f1068h && !z) {
            Rect rect = this.f1076p;
            rect.top += i3;
            rect.bottom += 0;
            if (i4 >= 21) {
                this.f1083w = this.f1083w.inset(0, i3, 0, 0);
            }
        } else if (i4 >= 21) {
            this.f1083w = new WindowInsetsCompat.Builder(this.f1083w).setSystemWindowInsets(Insets.m1529of(this.f1083w.getSystemWindowInsetLeft(), this.f1083w.getSystemWindowInsetTop() + i3, this.f1083w.getSystemWindowInsetRight(), this.f1083w.getSystemWindowInsetBottom() + 0)).build();
        } else {
            Rect rect2 = this.f1079s;
            rect2.top += i3;
            rect2.bottom += 0;
        }
        m734b(this.f1063c, this.f1076p, true, true, true, true);
        if (i4 >= 21 && !this.f1084x.equals(this.f1083w)) {
            WindowInsetsCompat windowInsetsCompat = this.f1083w;
            this.f1084x = windowInsetsCompat;
            ViewCompat.dispatchApplyWindowInsets(this.f1063c, windowInsetsCompat);
        } else if (i4 < 21 && !this.f1080t.equals(this.f1079s)) {
            this.f1080t.set(this.f1079s);
            this.f1063c.dispatchFitSystemWindows(this.f1079s);
        }
        measureChildWithMargins(this.f1063c, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1063c.getLayoutParams();
        int max3 = Math.max(max, this.f1063c.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.f1063c.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1063c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1070j || !z) {
            return false;
        }
        if (m740j(f2)) {
            m733a();
        } else {
            m739i();
        }
        this.f1071k = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo1986h();
        int i2 = this.f1073m ^ i;
        this.f1073m = i;
        boolean z = false;
        boolean z2 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1085y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.enableContentAnimations(!z);
            if (z2 || !z) {
                this.f1085y.showForSystem();
            } else {
                this.f1085y.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.f1085y != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1062b = i;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1085y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        mo1986h();
        this.f1065e.restoreHierarchyState(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        mo1986h();
        this.f1065e.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int i) {
        mo1976d();
        this.f1064d.setTranslationY((float) (-Math.max(0, Math.min(i, this.f1064d.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f1085y = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f1085y.onWindowVisibilityChanged(this.f1062b);
            int i = this.f1073m;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1069i = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1070j) {
            this.f1070j = z;
            if (!z) {
                mo1976d();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        mo1986h();
        this.f1065e.setIcon(i);
    }

    public void setLogo(int i) {
        mo1986h();
        this.f1065e.setLogo(i);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        mo1986h();
        this.f1065e.setMenu(menu, callback);
    }

    public void setMenuPrepared() {
        mo1986h();
        this.f1065e.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.f1068h = z;
        this.f1067g = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        mo1986h();
        this.f1065e.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        mo1986h();
        this.f1065e.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        mo1986h();
        return this.f1065e.showOverflowMenu();
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1062b = 0;
        this.f1074n = new Rect();
        this.f1075o = new Rect();
        this.f1076p = new Rect();
        this.f1077q = new Rect();
        this.f1078r = new Rect();
        this.f1079s = new Rect();
        this.f1080t = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.f1081u = windowInsetsCompat;
        this.f1082v = windowInsetsCompat;
        this.f1083w = windowInsetsCompat;
        this.f1084x = windowInsetsCompat;
        this.f1057B = new C0235a();
        this.f1058C = new C0236b();
        this.f1059D = new C0237c();
        m736e(context);
        this.f1060E = new NestedScrollingParentHelper(this);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1060E.onNestedScrollAccepted(view, view2, i);
        this.f1072l = getActionBarHideOffset();
        mo1976d();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1085y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1064d.getVisibility() != 0) {
            return false;
        }
        return this.f1070j;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1070j && !this.f1071k) {
            if (this.f1072l <= this.f1064d.getHeight()) {
                m738g();
            } else {
                m737f();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1085y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.f1072l + i2;
        this.f1072l = i5;
        setActionBarHideOffset(i5);
    }

    public void setIcon(Drawable drawable) {
        mo1986h();
        this.f1065e.setIcon(drawable);
    }
}
