package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;

    /* renamed from: n */
    private static final Rect f2842n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o */
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> f2843o = new C0590a();

    /* renamed from: p */
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> f2844p = new C0591b();

    /* renamed from: d */
    private final Rect f2845d = new Rect();

    /* renamed from: e */
    private final Rect f2846e = new Rect();

    /* renamed from: f */
    private final Rect f2847f = new Rect();

    /* renamed from: g */
    private final int[] f2848g = new int[2];

    /* renamed from: h */
    private final AccessibilityManager f2849h;

    /* renamed from: i */
    private final View f2850i;

    /* renamed from: j */
    private C0592c f2851j;

    /* renamed from: k */
    int f2852k = Integer.MIN_VALUE;

    /* renamed from: l */
    int f2853l = Integer.MIN_VALUE;

    /* renamed from: m */
    private int f2854m = Integer.MIN_VALUE;

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$a */
    static class C0590a implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
        C0590a() {
        }

        /* renamed from: a */
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    }

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$b */
    static class C0591b implements FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
        C0591b() {
        }

        /* renamed from: a */
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
            return sparseArrayCompat.valueAt(i);
        }

        /* renamed from: b */
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    }

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$c */
    private class C0592c extends AccessibilityNodeProviderCompat {
        C0592c() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.mo5225r(i));
        }

        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.f2852k : ExploreByTouchHelper.this.f2853l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i2);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.mo5227s(i, i2, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.f2850i = view;
            this.f2849h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    /* renamed from: e */
    private boolean m1986e(int i) {
        if (this.f2852k != i) {
            return false;
        }
        this.f2852k = Integer.MIN_VALUE;
        this.f2850i.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    /* renamed from: f */
    private boolean m1987f() {
        int i = this.f2853l;
        return i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, (Bundle) null);
    }

    /* renamed from: g */
    private AccessibilityEvent m1988g(int i, int i2) {
        if (i != -1) {
            return m1989h(i, i2);
        }
        return m1990i(i2);
    }

    /* renamed from: h */
    private AccessibilityEvent m1989h(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat r = mo5225r(i);
        obtain.getText().add(r.getText());
        obtain.setContentDescription(r.getContentDescription());
        obtain.setScrollable(r.isScrollable());
        obtain.setPassword(r.isPassword());
        obtain.setEnabled(r.isEnabled());
        obtain.setChecked(r.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(r.getClassName());
            AccessibilityRecordCompat.setSource(obtain, this.f2850i, i);
            obtain.setPackageName(this.f2850i.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* renamed from: i */
    private AccessibilityEvent m1990i(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.f2850i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    /* renamed from: j */
    private AccessibilityNodeInfoCompat m1991j(int i) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        Rect rect = f2842n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.f2850i);
        onPopulateNodeForVirtualView(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.f2846e);
        if (!this.f2846e.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                obtain.setPackageName(this.f2850i.getContext().getPackageName());
                obtain.setSource(this.f2850i, i);
                if (this.f2852k == i) {
                    obtain.setAccessibilityFocused(true);
                    obtain.addAction(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    obtain.addAction(64);
                }
                boolean z = this.f2853l == i;
                if (z) {
                    obtain.addAction(2);
                } else if (obtain.isFocusable()) {
                    obtain.addAction(1);
                }
                obtain.setFocused(z);
                this.f2850i.getLocationOnScreen(this.f2848g);
                obtain.getBoundsInScreen(this.f2845d);
                if (this.f2845d.equals(rect)) {
                    obtain.getBoundsInParent(this.f2845d);
                    if (obtain.mParentVirtualDescendantId != -1) {
                        AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                        for (int i2 = obtain.mParentVirtualDescendantId; i2 != -1; i2 = obtain2.mParentVirtualDescendantId) {
                            obtain2.setParent(this.f2850i, -1);
                            obtain2.setBoundsInParent(f2842n);
                            onPopulateNodeForVirtualView(i2, obtain2);
                            obtain2.getBoundsInParent(this.f2846e);
                            Rect rect2 = this.f2845d;
                            Rect rect3 = this.f2846e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        obtain2.recycle();
                    }
                    this.f2845d.offset(this.f2848g[0] - this.f2850i.getScrollX(), this.f2848g[1] - this.f2850i.getScrollY());
                }
                if (this.f2850i.getLocalVisibleRect(this.f2847f)) {
                    this.f2847f.offset(this.f2848g[0] - this.f2850i.getScrollX(), this.f2848g[1] - this.f2850i.getScrollY());
                    if (this.f2845d.intersect(this.f2847f)) {
                        obtain.setBoundsInScreen(this.f2845d);
                        if (m1996o(this.f2845d)) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
                return obtain;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    @NonNull
    /* renamed from: k */
    private AccessibilityNodeInfoCompat m1992k() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.f2850i);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.f2850i, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                obtain.addChild(this.f2850i, ((Integer) arrayList.get(i)).intValue());
            }
            return obtain;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    /* renamed from: l */
    private SparseArrayCompat<AccessibilityNodeInfoCompat> m1993l() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i = 0; i < arrayList.size(); i++) {
            sparseArrayCompat.put(i, m1991j(i));
        }
        return sparseArrayCompat;
    }

    /* renamed from: m */
    private void m1994m(int i, Rect rect) {
        mo5225r(i).getBoundsInParent(rect);
    }

    /* renamed from: n */
    private static Rect m1995n(@NonNull View view, int i, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    /* renamed from: o */
    private boolean m1996o(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f2850i.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f2850i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    /* renamed from: p */
    private static int m1997p(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    /* renamed from: q */
    private boolean m1998q(int i, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        SparseArrayCompat<AccessibilityNodeInfoCompat> l = m1993l();
        int i2 = this.f2853l;
        int i3 = Integer.MIN_VALUE;
        if (i2 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = l.get(i2);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
        if (i == 1 || i == 2) {
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.m2011d(l, f2844p, f2843o, accessibilityNodeInfoCompat3, i, ViewCompat.getLayoutDirection(this.f2850i) == 1, false);
        } else if (i == 17 || i == 33 || i == 66 || i == 130) {
            Rect rect2 = new Rect();
            int i4 = this.f2853l;
            if (i4 != Integer.MIN_VALUE) {
                m1994m(i4, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                m1995n(this.f2850i, i, rect2);
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.m2010c(l, f2844p, f2843o, accessibilityNodeInfoCompat3, rect2, i);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (accessibilityNodeInfoCompat2 != null) {
            i3 = l.keyAt(l.indexOfValue(accessibilityNodeInfoCompat2));
        }
        return requestKeyboardFocusForVirtualView(i3);
    }

    /* renamed from: t */
    private boolean m1999t(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return requestKeyboardFocusForVirtualView(i);
        }
        if (i2 == 2) {
            return clearKeyboardFocusForVirtualView(i);
        }
        if (i2 == 64) {
            return m2001v(i);
        }
        if (i2 != 128) {
            return onPerformActionForVirtualView(i, i2, bundle);
        }
        return m1986e(i);
    }

    /* renamed from: u */
    private boolean m2000u(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.f2850i, i, bundle);
    }

    /* renamed from: v */
    private boolean m2001v(int i) {
        int i2;
        if (!this.f2849h.isEnabled() || !this.f2849h.isTouchExplorationEnabled() || (i2 = this.f2852k) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            m1986e(i2);
        }
        this.f2852k = i;
        this.f2850i.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    /* renamed from: w */
    private void m2002w(int i) {
        int i2 = this.f2854m;
        if (i2 != i) {
            this.f2854m = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.f2853l != i) {
            return false;
        }
        this.f2853l = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.f2849h.isEnabled() || !this.f2849h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            m2002w(virtualViewAt);
            if (virtualViewAt != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.f2854m == Integer.MIN_VALUE) {
            return false;
        } else {
            m2002w(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int p = m1997p(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && m1998q(p, (Rect) null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            m1987f();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return m1998q(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return m1998q(1, (Rect) null);
            }
            return false;
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f2852k;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f2851j == null) {
            this.f2851j = new C0592c();
        }
        return this.f2851j;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.f2853l;
    }

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f, float f2);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        int i2 = this.f2853l;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            m1998q(i, rect);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i, int i2, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForVirtualView(int i, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    /* access modifiers changed from: protected */
    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: r */
    public AccessibilityNodeInfoCompat mo5225r(int i) {
        if (i == -1) {
            return m1992k();
        }
        return m1991j(i);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((!this.f2850i.isFocused() && !this.f2850i.requestFocus()) || (i2 = this.f2853l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.f2853l = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo5227s(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return m1999t(i, i2, bundle);
        }
        return m2000u(i2, bundle);
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f2849h.isEnabled() || (parent = this.f2850i.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.f2850i, m1988g(i, i2));
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i != Integer.MIN_VALUE && this.f2849h.isEnabled() && (parent = this.f2850i.getParent()) != null) {
            AccessibilityEvent g = m1988g(i, 2048);
            AccessibilityEventCompat.setContentChangeTypes(g, i2);
            ViewParentCompat.requestSendAccessibilityEvent(parent, this.f2850i, g);
        }
    }
}
