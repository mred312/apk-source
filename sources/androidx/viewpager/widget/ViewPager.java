package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.C0129Px;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    /* renamed from: g0 */
    static final int[] f4934g0 = {16842931};

    /* renamed from: h0 */
    private static final Comparator<C1069e> f4935h0 = new C1065a();

    /* renamed from: i0 */
    private static final Interpolator f4936i0 = new C1066b();

    /* renamed from: j0 */
    private static final C1072h f4937j0 = new C1072h();

    /* renamed from: A */
    private int f4938A;

    /* renamed from: B */
    private int f4939B;

    /* renamed from: C */
    private float f4940C;

    /* renamed from: D */
    private float f4941D;

    /* renamed from: E */
    private float f4942E;

    /* renamed from: F */
    private float f4943F;

    /* renamed from: G */
    private int f4944G = -1;

    /* renamed from: H */
    private VelocityTracker f4945H;

    /* renamed from: I */
    private int f4946I;

    /* renamed from: J */
    private int f4947J;

    /* renamed from: K */
    private int f4948K;

    /* renamed from: L */
    private int f4949L;

    /* renamed from: M */
    private boolean f4950M;

    /* renamed from: N */
    private long f4951N;

    /* renamed from: O */
    private EdgeEffect f4952O;

    /* renamed from: P */
    private EdgeEffect f4953P;

    /* renamed from: Q */
    private boolean f4954Q = true;

    /* renamed from: R */
    private boolean f4955R;

    /* renamed from: S */
    private int f4956S;

    /* renamed from: T */
    private List<OnPageChangeListener> f4957T;

    /* renamed from: U */
    private OnPageChangeListener f4958U;

    /* renamed from: V */
    private OnPageChangeListener f4959V;

    /* renamed from: W */
    private List<OnAdapterChangeListener> f4960W;

    /* renamed from: a */
    private int f4961a;

    /* renamed from: a0 */
    private PageTransformer f4962a0;

    /* renamed from: b */
    private final ArrayList<C1069e> f4963b = new ArrayList<>();

    /* renamed from: b0 */
    private int f4964b0;

    /* renamed from: c */
    private final C1069e f4965c = new C1069e();

    /* renamed from: c0 */
    private int f4966c0;

    /* renamed from: d */
    private final Rect f4967d = new Rect();

    /* renamed from: d0 */
    private ArrayList<View> f4968d0;

    /* renamed from: e */
    PagerAdapter f4969e;

    /* renamed from: e0 */
    private final Runnable f4970e0 = new C1067c();

    /* renamed from: f */
    int f4971f;

    /* renamed from: f0 */
    private int f4972f0 = 0;

    /* renamed from: g */
    private int f4973g = -1;

    /* renamed from: h */
    private Parcelable f4974h = null;

    /* renamed from: i */
    private ClassLoader f4975i = null;

    /* renamed from: j */
    private Scroller f4976j;

    /* renamed from: k */
    private boolean f4977k;

    /* renamed from: l */
    private C1071g f4978l;

    /* renamed from: m */
    private int f4979m;

    /* renamed from: n */
    private Drawable f4980n;

    /* renamed from: o */
    private int f4981o;

    /* renamed from: p */
    private int f4982p;

    /* renamed from: q */
    private float f4983q = -3.4028235E38f;

    /* renamed from: r */
    private float f4984r = Float.MAX_VALUE;

    /* renamed from: s */
    private int f4985s;

    /* renamed from: t */
    private boolean f4986t;

    /* renamed from: u */
    private boolean f4987u;

    /* renamed from: v */
    private boolean f4988v;

    /* renamed from: w */
    private int f4989w = 1;

    /* renamed from: x */
    private boolean f4990x;

    /* renamed from: y */
    private boolean f4991y;

    /* renamed from: z */
    private int f4992z;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, @C0129Px int i2);

        void onPageSelected(int i);
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1064a();

        /* renamed from: b */
        int f4997b;

        /* renamed from: c */
        Parcelable f4998c;

        /* renamed from: d */
        ClassLoader f4999d;

        /* renamed from: androidx.viewpager.widget.ViewPager$SavedState$a */
        static class C1064a implements Parcelable.ClassLoaderCreator<SavedState> {
            C1064a() {
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

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f4997b + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4997b);
            parcel.writeParcelable(this.f4998c, i);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f4997b = parcel.readInt();
            this.f4998c = parcel.readParcelable(classLoader);
            this.f4999d = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$a */
    static class C1065a implements Comparator<C1069e> {
        C1065a() {
        }

        /* renamed from: a */
        public int compare(C1069e eVar, C1069e eVar2) {
            return eVar.f5004b - eVar2.f5004b;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$b */
    static class C1066b implements Interpolator {
        C1066b() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$c */
    class C1067c implements Runnable {
        C1067c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.mo8608y();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$d */
    class C1068d implements OnApplyWindowInsetsListener {

        /* renamed from: a */
        private final Rect f5001a = new Rect();

        C1068d() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.f5001a;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$e */
    static class C1069e {

        /* renamed from: a */
        Object f5003a;

        /* renamed from: b */
        int f5004b;

        /* renamed from: c */
        boolean f5005c;

        /* renamed from: d */
        float f5006d;

        /* renamed from: e */
        float f5007e;

        C1069e() {
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$f */
    class C1070f extends AccessibilityDelegateCompat {
        C1070f() {
        }

        /* renamed from: e */
        private boolean m3866e() {
            PagerAdapter pagerAdapter = ViewPager.this.f4969e;
            return pagerAdapter != null && pagerAdapter.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m3866e());
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = ViewPager.this.f4969e) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.f4971f);
                accessibilityEvent.setToIndex(ViewPager.this.f4971f);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(m3866e());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f4971f - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f4971f + 1);
                return true;
            }
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$g */
    private class C1071g extends DataSetObserver {
        C1071g() {
        }

        public void onChanged() {
            ViewPager.this.mo8557d();
        }

        public void onInvalidated() {
            ViewPager.this.mo8557d();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$h */
    static class C1072h implements Comparator<View> {
        C1072h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.isDecor;
            if (z != layoutParams2.isDecor) {
                return z ? 1 : -1;
            }
            return layoutParams.f4995c - layoutParams2.f4995c;
        }
    }

    public ViewPager(@NonNull Context context) {
        super(context);
        mo8590q();
    }

    /* renamed from: A */
    private void m3826A(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f4963b.isEmpty()) {
            C1069e p = mo8589p(this.f4971f);
            int min = (int) ((p != null ? Math.min(p.f5007e, this.f4984r) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m3833c(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.f4976j.isFinished()) {
            this.f4976j.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3))), getScrollY());
        }
    }

    /* renamed from: B */
    private void m3827B() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    /* renamed from: C */
    private void m3828C(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: D */
    private boolean m3829D() {
        this.f4944G = -1;
        m3839k();
        this.f4952O.onRelease();
        this.f4953P.onRelease();
        return this.f4952O.isFinished() || this.f4953P.isFinished();
    }

    /* renamed from: E */
    private void m3830E(int i, boolean z, int i2, boolean z2) {
        C1069e p = mo8589p(i);
        int clientWidth = p != null ? (int) (((float) getClientWidth()) * Math.max(this.f4983q, Math.min(p.f5007e, this.f4984r))) : 0;
        if (z) {
            mo8543I(clientWidth, 0, i2);
            if (z2) {
                m3836g(i);
                return;
            }
            return;
        }
        if (z2) {
            m3836g(i);
        }
        m3833c(false);
        scrollTo(clientWidth, 0);
        m3845w(clientWidth);
    }

    /* renamed from: J */
    private void m3831J() {
        if (this.f4966c0 != 0) {
            ArrayList<View> arrayList = this.f4968d0;
            if (arrayList == null) {
                this.f4968d0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f4968d0.add(getChildAt(i));
            }
            Collections.sort(this.f4968d0, f4937j0);
        }
    }

    /* renamed from: b */
    private void m3832b(C1069e eVar, int i, C1069e eVar2) {
        int i2;
        int i3;
        C1069e eVar3;
        C1069e eVar4;
        int count = this.f4969e.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.f4979m) / ((float) clientWidth) : 0.0f;
        if (eVar2 != null) {
            int i4 = eVar2.f5004b;
            int i5 = eVar.f5004b;
            if (i4 < i5) {
                int i6 = 0;
                float f2 = eVar2.f5007e + eVar2.f5006d + f;
                while (true) {
                    i4++;
                    if (i4 > eVar.f5004b || i6 >= this.f4963b.size()) {
                        break;
                    }
                    Object obj = this.f4963b.get(i6);
                    while (true) {
                        eVar4 = (C1069e) obj;
                        if (i4 > eVar4.f5004b && i6 < this.f4963b.size() - 1) {
                            i6++;
                            obj = this.f4963b.get(i6);
                        }
                    }
                    while (i4 < eVar4.f5004b) {
                        f2 += this.f4969e.getPageWidth(i4) + f;
                        i4++;
                    }
                    eVar4.f5007e = f2;
                    f2 += eVar4.f5006d + f;
                }
            } else if (i4 > i5) {
                int size = this.f4963b.size() - 1;
                float f3 = eVar2.f5007e;
                while (true) {
                    int i7 = i4 - 1;
                    if (i7 < eVar.f5004b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f4963b.get(size);
                    while (true) {
                        eVar3 = (C1069e) obj2;
                        if (i7 < eVar3.f5004b && size > 0) {
                            size--;
                            obj2 = this.f4963b.get(size);
                        }
                    }
                    while (i4 > eVar3.f5004b) {
                        f3 -= this.f4969e.getPageWidth(i4) + f;
                        i7 = i4 - 1;
                    }
                    f3 -= eVar3.f5006d + f;
                    eVar3.f5007e = f3;
                }
            }
        }
        int size2 = this.f4963b.size();
        float f4 = eVar.f5007e;
        int i8 = eVar.f5004b;
        int i9 = i8 - 1;
        this.f4983q = i8 == 0 ? f4 : -3.4028235E38f;
        int i10 = count - 1;
        this.f4984r = i8 == i10 ? (eVar.f5006d + f4) - 1.0f : Float.MAX_VALUE;
        int i11 = i - 1;
        while (i11 >= 0) {
            C1069e eVar5 = this.f4963b.get(i11);
            while (true) {
                i3 = eVar5.f5004b;
                if (i9 <= i3) {
                    break;
                }
                f4 -= this.f4969e.getPageWidth(i9) + f;
                i9--;
            }
            f4 -= eVar5.f5006d + f;
            eVar5.f5007e = f4;
            if (i3 == 0) {
                this.f4983q = f4;
            }
            i11--;
            i9--;
        }
        float f5 = eVar.f5007e + eVar.f5006d + f;
        int i12 = eVar.f5004b + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            C1069e eVar6 = this.f4963b.get(i13);
            while (true) {
                i2 = eVar6.f5004b;
                if (i12 >= i2) {
                    break;
                }
                f5 += this.f4969e.getPageWidth(i12) + f;
                i12++;
            }
            if (i2 == i10) {
                this.f4984r = (eVar6.f5006d + f5) - 1.0f;
            }
            eVar6.f5007e = f5;
            f5 += eVar6.f5006d + f;
            i13++;
            i12++;
        }
    }

    /* renamed from: c */
    private void m3833c(boolean z) {
        boolean z2 = this.f4972f0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f4976j.isFinished()) {
                this.f4976j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4976j.getCurrX();
                int currY = this.f4976j.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m3845w(currX);
                    }
                }
            }
        }
        this.f4988v = false;
        for (int i = 0; i < this.f4963b.size(); i++) {
            C1069e eVar = this.f4963b.get(i);
            if (eVar.f5005c) {
                eVar.f5005c = false;
                z2 = true;
            }
        }
        if (!z2) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.f4970e0);
        } else {
            this.f4970e0.run();
        }
    }

    /* renamed from: e */
    private int m3834e(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f4948K || Math.abs(i2) <= this.f4946I) {
            i += (int) (f + (i >= this.f4971f ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f4963b.size() <= 0) {
            return i;
        }
        ArrayList<C1069e> arrayList = this.f4963b;
        return Math.max(this.f4963b.get(0).f5004b, Math.min(i, arrayList.get(arrayList.size() - 1).f5004b));
    }

    /* renamed from: f */
    private void m3835f(int i, float f, int i2) {
        OnPageChangeListener onPageChangeListener = this.f4958U;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        List<OnPageChangeListener> list = this.f4957T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = this.f4957T.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i, f, i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f4959V;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i, f, i2);
        }
    }

    /* renamed from: g */
    private void m3836g(int i) {
        OnPageChangeListener onPageChangeListener = this.f4958U;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
        List<OnPageChangeListener> list = this.f4957T;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = this.f4957T.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f4959V;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: h */
    private void m3837h(int i) {
        OnPageChangeListener onPageChangeListener = this.f4958U;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
        List<OnPageChangeListener> list = this.f4957T;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = this.f4957T.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f4959V;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: j */
    private void m3838j(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.f4964b0 : 0, (Paint) null);
        }
    }

    /* renamed from: k */
    private void m3839k() {
        this.f4990x = false;
        this.f4991y = false;
        VelocityTracker velocityTracker = this.f4945H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4945H = null;
        }
    }

    /* renamed from: l */
    private Rect m3840l(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* renamed from: o */
    private C1069e m3841o() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f2 = clientWidth > 0 ? ((float) this.f4979m) / ((float) clientWidth) : 0.0f;
        C1069e eVar = null;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.f4963b.size()) {
            C1069e eVar2 = this.f4963b.get(i3);
            if (!z && eVar2.f5004b != (i = i2 + 1)) {
                eVar2 = this.f4965c;
                eVar2.f5007e = f + f3 + f2;
                eVar2.f5004b = i;
                eVar2.f5006d = this.f4969e.getPageWidth(i);
                i3--;
            }
            f = eVar2.f5007e;
            float f4 = eVar2.f5006d + f + f2;
            if (!z && scrollX < f) {
                return eVar;
            }
            if (scrollX < f4 || i3 == this.f4963b.size() - 1) {
                return eVar2;
            }
            i2 = eVar2.f5004b;
            f3 = eVar2.f5006d;
            i3++;
            eVar = eVar2;
            z = false;
        }
        return eVar;
    }

    /* renamed from: r */
    private static boolean m3842r(@NonNull View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    /* renamed from: s */
    private boolean m3843s(float f, float f2) {
        return (f < ((float) this.f4938A) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f4938A)) && f2 < 0.0f);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f4987u != z) {
            this.f4987u = z;
        }
    }

    /* renamed from: t */
    private void m3844t(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4944G) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f4940C = motionEvent.getX(i);
            this.f4944G = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f4945H;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: w */
    private boolean m3845w(int i) {
        if (this.f4963b.size() != 0) {
            C1069e o = m3841o();
            int clientWidth = getClientWidth();
            int i2 = this.f4979m;
            int i3 = clientWidth + i2;
            float f = (float) clientWidth;
            int i4 = o.f5004b;
            float f2 = ((((float) i) / f) - o.f5007e) / (o.f5006d + (((float) i2) / f));
            this.f4955R = false;
            onPageScrolled(i4, f2, (int) (((float) i3) * f2));
            if (this.f4955R) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f4954Q) {
            return false;
        } else {
            this.f4955R = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.f4955R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    /* renamed from: x */
    private boolean m3846x(float f) {
        boolean z;
        boolean z2;
        float f2 = this.f4940C - f;
        this.f4940C = f;
        float scrollX = ((float) getScrollX()) + f2;
        float clientWidth = (float) getClientWidth();
        float f3 = this.f4983q * clientWidth;
        float f4 = this.f4984r * clientWidth;
        boolean z3 = false;
        C1069e eVar = this.f4963b.get(0);
        ArrayList<C1069e> arrayList = this.f4963b;
        C1069e eVar2 = arrayList.get(arrayList.size() - 1);
        if (eVar.f5004b != 0) {
            f3 = eVar.f5007e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (eVar2.f5004b != this.f4969e.getCount() - 1) {
            f4 = eVar2.f5007e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.f4952O.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f4953P.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f4940C += scrollX - ((float) i);
        scrollTo(i, getScrollY());
        m3845w(i);
        return z3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void mo8540F(int i, boolean z, boolean z2) {
        mo8541G(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void mo8541G(int i, boolean z, boolean z2, int i2) {
        PagerAdapter pagerAdapter = this.f4969e;
        boolean z3 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f4971f != i || this.f4963b.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f4969e.getCount()) {
                i = this.f4969e.getCount() - 1;
            }
            int i3 = this.f4989w;
            int i4 = this.f4971f;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.f4963b.size(); i5++) {
                    this.f4963b.get(i5).f5005c = true;
                }
            }
            if (this.f4971f != i) {
                z3 = true;
            }
            if (this.f4954Q) {
                this.f4971f = i;
                if (z3) {
                    m3836g(i);
                }
                requestLayout();
                return;
            }
            mo8609z(i);
            m3830E(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public OnPageChangeListener mo8542H(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.f4959V;
        this.f4959V = onPageChangeListener;
        return onPageChangeListener2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void mo8543I(int i, int i2, int i3) {
        int i4;
        int i5;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f4976j;
        if (scroller != null && !scroller.isFinished()) {
            i4 = this.f4977k ? this.f4976j.getCurrX() : this.f4976j.getStartX();
            this.f4976j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i4 = getScrollX();
        }
        int i6 = i4;
        int scrollY = getScrollY();
        int i7 = i - i6;
        int i8 = i2 - scrollY;
        if (i7 == 0 && i8 == 0) {
            m3833c(false);
            mo8608y();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i9 = clientWidth / 2;
        float f = (float) clientWidth;
        float f2 = (float) i9;
        float i10 = f2 + (mo8573i(Math.min(1.0f, (((float) Math.abs(i7)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(i10 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i7)) / ((f * this.f4969e.getPageWidth(this.f4971f)) + ((float) this.f4979m))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i5, 600);
        this.f4977k = false;
        this.f4976j.startScroll(i6, scrollY, i7, i8, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1069e mo8544a(int i, int i2) {
        C1069e eVar = new C1069e();
        eVar.f5004b = i;
        eVar.f5003a = this.f4969e.instantiateItem((ViewGroup) this, i);
        eVar.f5006d = this.f4969e.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f4963b.size()) {
            this.f4963b.add(eVar);
        } else {
            this.f4963b.add(i2, eVar);
        }
        return eVar;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C1069e n;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (n = mo8576n(childAt)) != null && n.f5004b == this.f4971f) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.f4960W == null) {
            this.f4960W = new ArrayList();
        }
        this.f4960W.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.f4957T == null) {
            this.f4957T = new ArrayList();
        }
        this.f4957T.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        C1069e n;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (n = mo8576n(childAt)) != null && n.f5004b == this.f4971f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean r = layoutParams2.isDecor | m3842r(view);
        layoutParams2.isDecor = r;
        if (!this.f4986t) {
            super.addView(view, i, layoutParams);
        } else if (layoutParams2 == null || !r) {
            layoutParams2.f4994b = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto L_0x000b
        L_0x0009:
            r0 = r3
            goto L_0x0069
        L_0x000b:
            if (r0 == 0) goto L_0x0069
            android.view.ViewParent r4 = r0.getParent()
        L_0x0011:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001e
            if (r4 != r6) goto L_0x0019
            r4 = 1
            goto L_0x001f
        L_0x0019:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0011
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 != 0) goto L_0x0069
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0035:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0035
        L_0x004e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L_0x0009
        L_0x0069:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto L_0x00ba
            if (r3 == r0) goto L_0x00ba
            if (r7 != r5) goto L_0x009a
            android.graphics.Rect r1 = r6.f4967d
            android.graphics.Rect r1 = r6.m3840l(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f4967d
            android.graphics.Rect r2 = r6.m3840l(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x0094
            if (r1 < r2) goto L_0x0094
            boolean r0 = r6.mo8605u()
            goto L_0x0098
        L_0x0094:
            boolean r0 = r3.requestFocus()
        L_0x0098:
            r2 = r0
            goto L_0x00cd
        L_0x009a:
            if (r7 != r4) goto L_0x00cd
            android.graphics.Rect r1 = r6.f4967d
            android.graphics.Rect r1 = r6.m3840l(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f4967d
            android.graphics.Rect r2 = r6.m3840l(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x00b5
            if (r1 > r2) goto L_0x00b5
            boolean r0 = r6.mo8606v()
            goto L_0x0098
        L_0x00b5:
            boolean r0 = r3.requestFocus()
            goto L_0x0098
        L_0x00ba:
            if (r7 == r5) goto L_0x00c9
            if (r7 != r1) goto L_0x00bf
            goto L_0x00c9
        L_0x00bf:
            if (r7 == r4) goto L_0x00c4
            r0 = 2
            if (r7 != r0) goto L_0x00cd
        L_0x00c4:
            boolean r2 = r6.mo8606v()
            goto L_0x00cd
        L_0x00c9:
            boolean r2 = r6.mo8605u()
        L_0x00cd:
            if (r2 == 0) goto L_0x00d6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        L_0x00d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.f4990x) {
            return false;
        }
        this.f4950M = true;
        setScrollState(1);
        this.f4940C = 0.0f;
        this.f4942E = 0.0f;
        VelocityTracker velocityTracker = this.f4945H;
        if (velocityTracker == null) {
            this.f4945H = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f4945H.addMovement(obtain);
        obtain.recycle();
        this.f4951N = uptimeMillis;
        return true;
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
        if (!z || !view.canScrollHorizontally(-i)) {
            return false;
        }
        return true;
    }

    public boolean canScrollHorizontally(int i) {
        if (this.f4969e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.f4983q))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.f4984r))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.f4957T;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        this.f4977k = true;
        if (this.f4976j.isFinished() || !this.f4976j.computeScrollOffset()) {
            m3833c(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f4976j.getCurrX();
        int currY = this.f4976j.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m3845w(currX)) {
                this.f4976j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8557d() {
        int count = this.f4969e.getCount();
        this.f4961a = count;
        boolean z = this.f4963b.size() < (this.f4989w * 2) + 1 && this.f4963b.size() < count;
        int i = this.f4971f;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f4963b.size()) {
            C1069e eVar = this.f4963b.get(i2);
            int itemPosition = this.f4969e.getItemPosition(eVar.f5003a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f4963b.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f4969e.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.f4969e.destroyItem((ViewGroup) this, eVar.f5004b, eVar.f5003a);
                    int i3 = this.f4971f;
                    if (i3 == eVar.f5004b) {
                        i = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = eVar.f5004b;
                    if (i4 != itemPosition) {
                        if (i4 == this.f4971f) {
                            i = itemPosition;
                        }
                        eVar.f5004b = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f4969e.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f4963b, f4935h0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.f4993a = 0.0f;
                }
            }
            mo8540F(i, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C1069e n;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (n = mo8576n(childAt)) != null && n.f5004b == this.f4971f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.f4969e) != null && pagerAdapter.getCount() > 1)) {
            if (!this.f4952O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f4983q * ((float) width));
                this.f4952O.setSize(height, width);
                z = false | this.f4952O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f4953P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f4984r + 1.0f)) * ((float) width2));
                this.f4953P.setSize(height2, width2);
                z |= this.f4953P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f4952O.finish();
            this.f4953P.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4980n;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.f4950M) {
            if (this.f4969e != null) {
                VelocityTracker velocityTracker = this.f4945H;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f4947J);
                int xVelocity = (int) velocityTracker.getXVelocity(this.f4944G);
                this.f4988v = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C1069e o = m3841o();
                mo8541G(m3834e(o.f5004b, ((((float) scrollX) / ((float) clientWidth)) - o.f5007e) / o.f5006d, xVelocity, (int) (this.f4940C - this.f4942E)), true, true, xVelocity);
            }
            m3839k();
            this.f4950M = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return mo8606v();
                } else {
                    return arrowScroll(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return mo8605u();
            } else {
                return arrowScroll(17);
            }
        }
        return false;
    }

    public void fakeDragBy(float f) {
        if (!this.f4950M) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.f4969e != null) {
            this.f4940C += f;
            float scrollX = ((float) getScrollX()) - f;
            float clientWidth = (float) getClientWidth();
            float f2 = this.f4983q * clientWidth;
            float f3 = this.f4984r * clientWidth;
            C1069e eVar = this.f4963b.get(0);
            ArrayList<C1069e> arrayList = this.f4963b;
            C1069e eVar2 = arrayList.get(arrayList.size() - 1);
            if (eVar.f5004b != 0) {
                f2 = eVar.f5007e * clientWidth;
            }
            if (eVar2.f5004b != this.f4969e.getCount() - 1) {
                f3 = eVar2.f5007e * clientWidth;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.f4940C += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            m3845w(i);
            MotionEvent obtain = MotionEvent.obtain(this.f4951N, SystemClock.uptimeMillis(), 2, this.f4940C, 0.0f, 0);
            this.f4945H.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.f4969e;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f4966c0 == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f4968d0.get(i2).getLayoutParams()).f4996d;
    }

    public int getCurrentItem() {
        return this.f4971f;
    }

    public int getOffscreenPageLimit() {
        return this.f4989w;
    }

    public int getPageMargin() {
        return this.f4979m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public float mo8573i(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    public boolean isFakeDragging() {
        return this.f4950M;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public C1069e mo8575m(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo8576n(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public C1069e mo8576n(View view) {
        for (int i = 0; i < this.f4963b.size(); i++) {
            C1069e eVar = this.f4963b.get(i);
            if (this.f4969e.isViewFromObject(view, eVar.f5003a)) {
                return eVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4954Q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4970e0);
        Scroller scroller = this.f4976j;
        if (scroller != null && !scroller.isFinished()) {
            this.f4976j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            super.onDraw(r18)
            int r1 = r0.f4979m
            if (r1 <= 0) goto L_0x00aa
            android.graphics.drawable.Drawable r1 = r0.f4980n
            if (r1 == 0) goto L_0x00aa
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r1 = r0.f4963b
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00aa
            androidx.viewpager.widget.PagerAdapter r1 = r0.f4969e
            if (r1 == 0) goto L_0x00aa
            int r1 = r17.getScrollX()
            int r2 = r17.getWidth()
            int r3 = r0.f4979m
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            float r7 = r5.f5007e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r8 = r0.f4963b
            int r8 = r8.size()
            int r9 = r5.f5004b
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r10 = r0.f4963b
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            androidx.viewpager.widget.ViewPager$e r10 = (androidx.viewpager.widget.ViewPager.C1069e) r10
            int r10 = r10.f5004b
        L_0x0045:
            if (r9 >= r10) goto L_0x00aa
        L_0x0047:
            int r11 = r5.f5004b
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0065
            float r7 = r5.f5007e
            float r11 = r5.f5006d
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x0071
        L_0x0065:
            androidx.viewpager.widget.PagerAdapter r11 = r0.f4969e
            float r11 = r11.getPageWidth(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x0071:
            int r11 = r0.f4979m
            float r11 = (float) r11
            float r11 = r11 + r12
            float r13 = (float) r1
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0099
            android.graphics.drawable.Drawable r11 = r0.f4980n
            int r13 = java.lang.Math.round(r12)
            int r14 = r0.f4981o
            int r15 = r0.f4979m
            float r15 = (float) r15
            float r15 = r15 + r12
            int r15 = java.lang.Math.round(r15)
            r16 = r3
            int r3 = r0.f4982p
            r11.setBounds(r13, r14, r15, r3)
            android.graphics.drawable.Drawable r3 = r0.f4980n
            r11 = r18
            r3.draw(r11)
            goto L_0x009d
        L_0x0099:
            r11 = r18
            r16 = r3
        L_0x009d:
            int r3 = r1 + r2
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a5
            goto L_0x00aa
        L_0x00a5:
            int r9 = r9 + 1
            r3 = r16
            goto L_0x0045
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m3829D();
            return false;
        }
        if (action != 0) {
            if (this.f4990x) {
                return true;
            }
            if (this.f4991y) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f4942E = x;
            this.f4940C = x;
            float y = motionEvent.getY();
            this.f4943F = y;
            this.f4941D = y;
            this.f4944G = motionEvent2.getPointerId(0);
            this.f4991y = false;
            this.f4977k = true;
            this.f4976j.computeScrollOffset();
            if (this.f4972f0 != 2 || Math.abs(this.f4976j.getFinalX() - this.f4976j.getCurrX()) <= this.f4949L) {
                m3833c(false);
                this.f4990x = false;
            } else {
                this.f4976j.abortAnimation();
                this.f4988v = false;
                mo8608y();
                this.f4990x = true;
                m3828C(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f4944G;
            if (i != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i);
                float x2 = motionEvent2.getX(findPointerIndex);
                float f = x2 - this.f4940C;
                float abs = Math.abs(f);
                float y2 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.f4943F);
                if (f != 0.0f && !m3843s(this.f4940C, f)) {
                    if (canScroll(this, false, (int) f, (int) x2, (int) y2)) {
                        this.f4940C = x2;
                        this.f4941D = y2;
                        this.f4991y = true;
                        return false;
                    }
                }
                int i2 = this.f4939B;
                if (abs > ((float) i2) && abs * 0.5f > abs2) {
                    this.f4990x = true;
                    m3828C(true);
                    setScrollState(1);
                    this.f4940C = f > 0.0f ? this.f4942E + ((float) this.f4939B) : this.f4942E - ((float) this.f4939B);
                    this.f4941D = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i2)) {
                    this.f4991y = true;
                }
                if (this.f4990x && m3846x(x2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            m3844t(motionEvent);
        }
        if (this.f4945H == null) {
            this.f4945H = VelocityTracker.obtain();
        }
        this.f4945H.addMovement(motionEvent2);
        return this.f4990x;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r12 = (androidx.viewpager.widget.ViewPager.LayoutParams) r12
            boolean r14 = r12.isDecor
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.gravity
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00b9:
            if (r6 >= r1) goto L_0x0108
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0105
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L_0x0105
            androidx.viewpager.widget.ViewPager$e r10 = r0.mo8576n(r8)
            if (r10 == 0) goto L_0x0105
            float r13 = (float) r2
            float r10 = r10.f5007e
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.f4994b
            if (r14 == 0) goto L_0x00f8
            r14 = 0
            r9.f4994b = r14
            float r9 = r9.f4993a
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00f8:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0105:
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x0108:
            r0.f4981o = r5
            int r3 = r3 - r7
            r0.f4982p = r3
            r0.f4956S = r11
            boolean r1 = r0.f4954Q
            if (r1 == 0) goto L_0x011a
            int r1 = r0.f4971f
            r2 = 0
            r0.m3830E(r1, r2, r2, r2)
            goto L_0x011b
        L_0x011a:
            r2 = 0
        L_0x011b:
            r0.f4954Q = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            int r14 = android.view.ViewGroup.getDefaultSize(r0, r14)
            int r15 = android.view.ViewGroup.getDefaultSize(r0, r15)
            r13.setMeasuredDimension(r14, r15)
            int r14 = r13.getMeasuredWidth()
            int r15 = r14 / 10
            int r1 = r13.f4992z
            int r15 = java.lang.Math.min(r15, r1)
            r13.f4938A = r15
            int r15 = r13.getPaddingLeft()
            int r14 = r14 - r15
            int r15 = r13.getPaddingRight()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredHeight()
            int r1 = r13.getPaddingTop()
            int r15 = r15 - r1
            int r1 = r13.getPaddingBottom()
            int r15 = r15 - r1
            int r1 = r13.getChildCount()
            r2 = 0
        L_0x0037:
            r3 = 8
            r4 = 1
            r5 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r1) goto L_0x00b2
            android.view.View r6 = r13.getChildAt(r2)
            int r7 = r6.getVisibility()
            if (r7 == r3) goto L_0x00af
            android.view.ViewGroup$LayoutParams r3 = r6.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r3 = (androidx.viewpager.widget.ViewPager.LayoutParams) r3
            if (r3 == 0) goto L_0x00af
            boolean r7 = r3.isDecor
            if (r7 == 0) goto L_0x00af
            int r7 = r3.gravity
            r8 = r7 & 7
            r7 = r7 & 112(0x70, float:1.57E-43)
            r9 = 48
            if (r7 == r9) goto L_0x0065
            r9 = 80
            if (r7 != r9) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r7 = 0
            goto L_0x0066
        L_0x0065:
            r7 = 1
        L_0x0066:
            r9 = 3
            if (r8 == r9) goto L_0x006e
            r9 = 5
            if (r8 != r9) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == 0) goto L_0x0075
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x007a
        L_0x0075:
            if (r4 == 0) goto L_0x007a
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x007c
        L_0x007a:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x007c:
            int r10 = r3.width
            r11 = -1
            r12 = -2
            if (r10 == r12) goto L_0x0089
            if (r10 == r11) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r10 = r14
        L_0x0086:
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x008a
        L_0x0089:
            r10 = r14
        L_0x008a:
            int r3 = r3.height
            if (r3 == r12) goto L_0x0093
            if (r3 == r11) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            r3 = r15
            goto L_0x0095
        L_0x0093:
            r3 = r15
            r5 = r9
        L_0x0095:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r5)
            r6.measure(r8, r3)
            if (r7 == 0) goto L_0x00a8
            int r3 = r6.getMeasuredHeight()
            int r15 = r15 - r3
            goto L_0x00af
        L_0x00a8:
            if (r4 == 0) goto L_0x00af
            int r3 = r6.getMeasuredWidth()
            int r14 = r14 - r3
        L_0x00af:
            int r2 = r2 + 1
            goto L_0x0037
        L_0x00b2:
            android.view.View.MeasureSpec.makeMeasureSpec(r14, r5)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
            r13.f4985s = r15
            r13.f4986t = r4
            r13.mo8608y()
            r13.f4986t = r0
            int r15 = r13.getChildCount()
        L_0x00c6:
            if (r0 >= r15) goto L_0x00f0
            android.view.View r1 = r13.getChildAt(r0)
            int r2 = r1.getVisibility()
            if (r2 == r3) goto L_0x00ed
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r2 = (androidx.viewpager.widget.ViewPager.LayoutParams) r2
            if (r2 == 0) goto L_0x00de
            boolean r4 = r2.isDecor
            if (r4 != 0) goto L_0x00ed
        L_0x00de:
            float r4 = (float) r14
            float r2 = r2.f4993a
            float r4 = r4 * r2
            int r2 = (int) r4
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r5)
            int r4 = r13.f4985s
            r1.measure(r2, r4)
        L_0x00ed:
            int r0 = r0 + 1
            goto L_0x00c6
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f4956S
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L_0x001b:
            if (r7 >= r6) goto L_0x006b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            int r9 = r9.gravity
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004d
            r10 = 3
            if (r9 == r10) goto L_0x0047
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005c
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L_0x0059
        L_0x0047:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005c
        L_0x004d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L_0x0059:
            r11 = r9
            r9 = r3
            r3 = r11
        L_0x005c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0067
            r8.offsetLeftAndRight(r3)
        L_0x0067:
            r3 = r9
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006b:
            r12.m3835f(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$PageTransformer r13 = r12.f4962a0
            if (r13 == 0) goto L_0x009f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007a:
            if (r1 >= r14) goto L_0x009f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.isDecor
            if (r0 == 0) goto L_0x008b
            goto L_0x009c
        L_0x008b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$PageTransformer r3 = r12.f4962a0
            r3.transformPage(r15, r0)
        L_0x009c:
            int r1 = r1 + 1
            goto L_0x007a
        L_0x009f:
            r12.f4955R = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        C1069e n;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (n = mo8576n(childAt)) != null && n.f5004b == this.f4971f && childAt.requestFocus(i, rect)) {
                return true;
            }
            i3 += i2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.f4969e;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f4998c, savedState.f4999d);
            mo8540F(savedState.f4997b, false, true);
            return;
        }
        this.f4973g = savedState.f4997b;
        this.f4974h = savedState.f4998c;
        this.f4975i = savedState.f4999d;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4997b = this.f4971f;
        PagerAdapter pagerAdapter = this.f4969e;
        if (pagerAdapter != null) {
            savedState.f4998c = pagerAdapter.saveState();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.f4979m;
            m3826A(i, i3, i5, i5);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        if (this.f4950M) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f4969e) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.f4945H == null) {
            this.f4945H = VelocityTracker.obtain();
        }
        this.f4945H.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f4976j.abortAnimation();
            this.f4988v = false;
            mo8608y();
            float x = motionEvent.getX();
            this.f4942E = x;
            this.f4940C = x;
            float y = motionEvent.getY();
            this.f4943F = y;
            this.f4941D = y;
            this.f4944G = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f4990x) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f4944G);
                    if (findPointerIndex == -1) {
                        z = m3829D();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.f4940C);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f4941D);
                        if (abs > ((float) this.f4939B) && abs > abs2) {
                            this.f4990x = true;
                            m3828C(true);
                            float f = this.f4942E;
                            this.f4940C = x2 - f > 0.0f ? f + ((float) this.f4939B) : f - ((float) this.f4939B);
                            this.f4941D = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f4990x) {
                    z = false | m3846x(motionEvent.getX(motionEvent.findPointerIndex(this.f4944G)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.f4940C = motionEvent.getX(actionIndex);
                    this.f4944G = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    m3844t(motionEvent);
                    this.f4940C = motionEvent.getX(motionEvent.findPointerIndex(this.f4944G));
                }
            } else if (this.f4990x) {
                m3830E(this.f4971f, true, 0, false);
                z = m3829D();
            }
        } else if (this.f4990x) {
            VelocityTracker velocityTracker = this.f4945H;
            velocityTracker.computeCurrentVelocity(1000, (float) this.f4947J);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f4944G);
            this.f4988v = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            C1069e o = m3841o();
            float f2 = (float) clientWidth;
            mo8541G(m3834e(o.f5004b, ((((float) scrollX) / f2) - o.f5007e) / (o.f5006d + (((float) this.f4979m) / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f4944G)) - this.f4942E)), true, true, xVelocity);
            z = m3829D();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public C1069e mo8589p(int i) {
        for (int i2 = 0; i2 < this.f4963b.size(); i2++) {
            C1069e eVar = this.f4963b.get(i2);
            if (eVar.f5004b == i) {
                return eVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo8590q() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f4976j = new Scroller(context, f4936i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f4939B = viewConfiguration.getScaledPagingTouchSlop();
        this.f4946I = (int) (400.0f * f);
        this.f4947J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4952O = new EdgeEffect(context);
        this.f4953P = new EdgeEffect(context);
        this.f4948K = (int) (25.0f * f);
        this.f4949L = (int) (2.0f * f);
        this.f4992z = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new C1070f());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new C1068d());
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.f4960W;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.f4957T;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.f4986t) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.f4969e;
        if (pagerAdapter2 != null) {
            pagerAdapter2.mo8493a((DataSetObserver) null);
            this.f4969e.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f4963b.size(); i++) {
                C1069e eVar = this.f4963b.get(i);
                this.f4969e.destroyItem((ViewGroup) this, eVar.f5004b, eVar.f5003a);
            }
            this.f4969e.finishUpdate((ViewGroup) this);
            this.f4963b.clear();
            m3827B();
            this.f4971f = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f4969e;
        this.f4969e = pagerAdapter;
        this.f4961a = 0;
        if (pagerAdapter != null) {
            if (this.f4978l == null) {
                this.f4978l = new C1071g();
            }
            this.f4969e.mo8493a(this.f4978l);
            this.f4988v = false;
            boolean z = this.f4954Q;
            this.f4954Q = true;
            this.f4961a = this.f4969e.getCount();
            if (this.f4973g >= 0) {
                this.f4969e.restoreState(this.f4974h, this.f4975i);
                mo8540F(this.f4973g, false, true);
                this.f4973g = -1;
                this.f4974h = null;
                this.f4975i = null;
            } else if (!z) {
                mo8608y();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.f4960W;
        if (list != null && !list.isEmpty()) {
            int size = this.f4960W.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4960W.get(i2).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f4988v = false;
        mo8540F(i, !this.f4954Q, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f4989w) {
            this.f4989w = i;
            mo8608y();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f4958U = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.f4979m;
        this.f4979m = i;
        int width = getWidth();
        m3826A(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.f4980n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, @Nullable PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, 2);
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (this.f4972f0 != i) {
            this.f4972f0 = i;
            if (this.f4962a0 != null) {
                m3838j(i != 0);
            }
            m3837h(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean mo8605u() {
        int i = this.f4971f;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public boolean mo8606v() {
        PagerAdapter pagerAdapter = this.f4969e;
        if (pagerAdapter == null || this.f4971f >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f4971f + 1, true);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4980n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo8608y() {
        mo8609z(this.f4971f);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    /* renamed from: z */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8609z(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.f4971f
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$e r2 = r0.mo8589p(r2)
            r0.f4971f = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f4969e
            if (r1 != 0) goto L_0x0018
            r17.m3831J()
            return
        L_0x0018:
            boolean r1 = r0.f4988v
            if (r1 == 0) goto L_0x0020
            r17.m3831J()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f4969e
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.f4989w
            int r4 = r0.f4971f
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.PagerAdapter r6 = r0.f4969e
            int r6 = r6.getCount()
            int r7 = r6 + -1
            int r8 = r0.f4971f
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.f4961a
            if (r6 != r7) goto L_0x020e
            r7 = 0
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r8 = r0.f4963b
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0066
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r8 = r0.f4963b
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$e r8 = (androidx.viewpager.widget.ViewPager.C1069e) r8
            int r9 = r8.f5004b
            int r10 = r0.f4971f
            if (r9 < r10) goto L_0x0063
            if (r9 != r10) goto L_0x0066
            goto L_0x0067
        L_0x0063:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0066:
            r8 = 0
        L_0x0067:
            if (r8 != 0) goto L_0x0071
            if (r6 <= 0) goto L_0x0071
            int r8 = r0.f4971f
            androidx.viewpager.widget.ViewPager$e r8 = r0.mo8544a(r8, r7)
        L_0x0071:
            r9 = 0
            if (r8 == 0) goto L_0x019b
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0081
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r11 = r0.f4963b
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$e r11 = (androidx.viewpager.widget.ViewPager.C1069e) r11
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x008c
            r14 = 0
            goto L_0x0098
        L_0x008c:
            float r14 = r8.f5006d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r14 = r14 + r15
        L_0x0098:
            int r3 = r0.f4971f
            int r3 = r3 + -1
            r15 = 0
        L_0x009d:
            if (r3 < 0) goto L_0x00fd
            int r16 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00cb
            if (r3 >= r4) goto L_0x00cb
            if (r11 != 0) goto L_0x00a8
            goto L_0x00fd
        L_0x00a8:
            int r5 = r11.f5004b
            if (r3 != r5) goto L_0x00f9
            boolean r5 = r11.f5005c
            if (r5 != 0) goto L_0x00f9
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            r5.remove(r10)
            androidx.viewpager.widget.PagerAdapter r5 = r0.f4969e
            java.lang.Object r11 = r11.f5003a
            r5.destroyItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r11)
            int r10 = r10 + -1
            int r7 = r7 + -1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            goto L_0x00f8
        L_0x00cb:
            if (r11 == 0) goto L_0x00e1
            int r5 = r11.f5004b
            if (r3 != r5) goto L_0x00e1
            float r5 = r11.f5006d
            float r15 = r15 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            goto L_0x00f8
        L_0x00e1:
            int r5 = r10 + 1
            androidx.viewpager.widget.ViewPager$e r5 = r0.mo8544a(r3, r5)
            float r5 = r5.f5006d
            float r15 = r15 + r5
            int r7 = r7 + 1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            goto L_0x00f8
        L_0x00f7:
            r5 = 0
        L_0x00f8:
            r11 = r5
        L_0x00f9:
            int r3 = r3 + -1
            r5 = 0
            goto L_0x009d
        L_0x00fd:
            float r3 = r8.f5006d
            int r4 = r7 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x018f
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0116
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            goto L_0x0117
        L_0x0116:
            r5 = 0
        L_0x0117:
            if (r12 > 0) goto L_0x011b
            r10 = 0
            goto L_0x0123
        L_0x011b:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r12
            float r10 = r10 / r11
            float r10 = r10 + r13
        L_0x0123:
            int r11 = r0.f4971f
        L_0x0125:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x018f
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x0159
            if (r11 <= r1) goto L_0x0159
            if (r5 != 0) goto L_0x0132
            goto L_0x018f
        L_0x0132:
            int r12 = r5.f5004b
            if (r11 != r12) goto L_0x018e
            boolean r12 = r5.f5005c
            if (r12 != 0) goto L_0x018e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r12 = r0.f4963b
            r12.remove(r4)
            androidx.viewpager.widget.PagerAdapter r12 = r0.f4969e
            java.lang.Object r5 = r5.f5003a
            r12.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            goto L_0x018e
        L_0x0157:
            r5 = 0
            goto L_0x018e
        L_0x0159:
            if (r5 == 0) goto L_0x0175
            int r12 = r5.f5004b
            if (r11 != r12) goto L_0x0175
            float r5 = r5.f5006d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
            goto L_0x018e
        L_0x0175:
            androidx.viewpager.widget.ViewPager$e r5 = r0.mo8544a(r11, r4)
            int r4 = r4 + 1
            float r5 = r5.f5006d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$e> r5 = r0.f4963b
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.C1069e) r5
        L_0x018e:
            goto L_0x0125
        L_0x018f:
            r0.m3832b(r8, r7, r2)
            androidx.viewpager.widget.PagerAdapter r1 = r0.f4969e
            int r2 = r0.f4971f
            java.lang.Object r3 = r8.f5003a
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
        L_0x019b:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f4969e
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01a5:
            if (r2 >= r1) goto L_0x01ce
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r4 = (androidx.viewpager.widget.ViewPager.LayoutParams) r4
            r4.f4996d = r2
            boolean r5 = r4.isDecor
            if (r5 != 0) goto L_0x01cb
            float r5 = r4.f4993a
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01cb
            androidx.viewpager.widget.ViewPager$e r3 = r0.mo8576n(r3)
            if (r3 == 0) goto L_0x01cb
            float r5 = r3.f5006d
            r4.f4993a = r5
            int r3 = r3.f5004b
            r4.f4995c = r3
        L_0x01cb:
            int r2 = r2 + 1
            goto L_0x01a5
        L_0x01ce:
            r17.m3831J()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x020d
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01e2
            androidx.viewpager.widget.ViewPager$e r3 = r0.mo8575m(r1)
            goto L_0x01e3
        L_0x01e2:
            r3 = 0
        L_0x01e3:
            if (r3 == 0) goto L_0x01eb
            int r1 = r3.f5004b
            int r2 = r0.f4971f
            if (r1 == r2) goto L_0x020d
        L_0x01eb:
            r5 = 0
        L_0x01ec:
            int r1 = r17.getChildCount()
            if (r5 >= r1) goto L_0x020d
            android.view.View r1 = r0.getChildAt(r5)
            androidx.viewpager.widget.ViewPager$e r2 = r0.mo8576n(r1)
            if (r2 == 0) goto L_0x020a
            int r2 = r2.f5004b
            int r3 = r0.f4971f
            if (r2 != r3) goto L_0x020a
            r2 = 2
            boolean r1 = r1.requestFocus(r2)
            if (r1 == 0) goto L_0x020a
            goto L_0x020d
        L_0x020a:
            int r5 = r5 + 1
            goto L_0x01ec
        L_0x020d:
            return
        L_0x020e:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x021b }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x021b }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x021b }
            goto L_0x0223
        L_0x021b:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0223:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.f4961a
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.PagerAdapter r1 = r0.f4969e
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            goto L_0x0267
        L_0x0266:
            throw r2
        L_0x0267:
            goto L_0x0266
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.mo8609z(int):void");
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        float f4993a = 0.0f;

        /* renamed from: b */
        boolean f4994b;

        /* renamed from: c */
        int f4995c;

        /* renamed from: d */
        int f4996d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f4934g0);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z, @Nullable PageTransformer pageTransformer, int i) {
        int i2 = 1;
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.f4962a0 != null);
        this.f4962a0 = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.f4966c0 = i2;
            this.f4964b0 = i;
        } else {
            this.f4966c0 = 0;
        }
        if (z3) {
            mo8608y();
        }
    }

    public void setCurrentItem(int i, boolean z) {
        this.f4988v = false;
        mo8540F(i, z, false);
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mo8590q();
    }
}
