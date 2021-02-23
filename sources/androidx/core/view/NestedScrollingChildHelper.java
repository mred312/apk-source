package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NestedScrollingChildHelper {

    /* renamed from: a */
    private ViewParent f2634a;

    /* renamed from: b */
    private ViewParent f2635b;

    /* renamed from: c */
    private final View f2636c;

    /* renamed from: d */
    private boolean f2637d;

    /* renamed from: e */
    private int[] f2638e;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.f2636c = view;
    }

    /* renamed from: a */
    private boolean m1731a(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @Nullable int[] iArr2) {
        ViewParent b;
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!isNestedScrollingEnabled() || (b = m1732b(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f2636c.getLocationInWindow(iArr4);
            i7 = iArr4[0];
            i6 = iArr4[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            int[] c = m1733c();
            c[0] = 0;
            c[1] = 0;
            iArr3 = c;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.onNestedScroll(b, this.f2636c, i, i2, i3, i4, i5, iArr3);
        if (iArr4 != null) {
            this.f2636c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i7;
            iArr4[1] = iArr4[1] - i6;
        }
        return true;
    }

    /* renamed from: b */
    private ViewParent m1732b(int i) {
        if (i == 0) {
            return this.f2634a;
        }
        if (i != 1) {
            return null;
        }
        return this.f2635b;
    }

    /* renamed from: c */
    private int[] m1733c() {
        if (this.f2638e == null) {
            this.f2638e = new int[2];
        }
        return this.f2638e;
    }

    /* renamed from: d */
    private void m1734d(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f2634a = viewParent;
        } else if (i == 1) {
            this.f2635b = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent b;
        if (!isNestedScrollingEnabled() || (b = m1732b(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(b, this.f2636c, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent b;
        if (!isNestedScrollingEnabled() || (b = m1732b(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(b, this.f2636c, f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return m1731a(i, i2, i3, i4, iArr, 0, (int[]) null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2637d;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.f2636c);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.f2636c);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.f2637d) {
            ViewCompat.stopNestedScroll(this.f2636c);
        }
        this.f2637d = z;
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        ViewParent b;
        int i4;
        int i5;
        if (!isNestedScrollingEnabled() || (b = m1732b(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f2636c.getLocationInWindow(iArr2);
                i5 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                iArr = m1733c();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.onNestedPreScroll(b, this.f2636c, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f2636c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        return m1731a(i, i2, i3, i4, iArr, i5, (int[]) null);
    }

    public boolean hasNestedScrollingParent(int i) {
        return m1732b(i) != null;
    }

    public boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.f2636c;
        for (ViewParent parent = this.f2636c.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.f2636c, i, i2)) {
                m1734d(i2, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.f2636c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i) {
        ViewParent b = m1732b(i);
        if (b != null) {
            ViewParentCompat.onStopNestedScroll(b, this.f2636c, i);
            m1734d(i, (ViewParent) null);
        }
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @Nullable int[] iArr2) {
        m1731a(i, i2, i3, i4, iArr, i5, iArr2);
    }
}
