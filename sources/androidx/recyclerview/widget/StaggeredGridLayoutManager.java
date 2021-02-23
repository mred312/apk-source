package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: A */
    boolean f4304A = false;

    /* renamed from: B */
    private BitSet f4305B;

    /* renamed from: C */
    int f4306C = -1;

    /* renamed from: D */
    int f4307D = Integer.MIN_VALUE;

    /* renamed from: E */
    LazySpanLookup f4308E = new LazySpanLookup();

    /* renamed from: F */
    private int f4309F = 2;

    /* renamed from: G */
    private boolean f4310G;

    /* renamed from: H */
    private boolean f4311H;

    /* renamed from: I */
    private SavedState f4312I;

    /* renamed from: J */
    private int f4313J;

    /* renamed from: K */
    private final Rect f4314K = new Rect();

    /* renamed from: L */
    private final C0927b f4315L = new C0927b();

    /* renamed from: M */
    private boolean f4316M = false;

    /* renamed from: N */
    private boolean f4317N = true;

    /* renamed from: O */
    private int[] f4318O;

    /* renamed from: P */
    private final Runnable f4319P = new C0926a();

    /* renamed from: s */
    private int f4320s = -1;

    /* renamed from: t */
    C0928c[] f4321t;
    @NonNull

    /* renamed from: u */
    OrientationHelper f4322u;
    @NonNull

    /* renamed from: v */
    OrientationHelper f4323v;

    /* renamed from: w */
    private int f4324w;

    /* renamed from: x */
    private int f4325x;
    @NonNull

    /* renamed from: y */
    private final C0947f f4326y;

    /* renamed from: z */
    boolean f4327z = false;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: e */
        C0928c f4328e;

        /* renamed from: f */
        boolean f4329f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            C0928c cVar = this.f4328e;
            if (cVar == null) {
                return -1;
            }
            return cVar.f4358e;
        }

        public boolean isFullSpan() {
            return this.f4329f;
        }

        public void setFullSpan(boolean z) {
            this.f4329f = z;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0925a();

        /* renamed from: a */
        int f4336a;

        /* renamed from: b */
        int f4337b;

        /* renamed from: c */
        int f4338c;

        /* renamed from: d */
        int[] f4339d;

        /* renamed from: e */
        int f4340e;

        /* renamed from: f */
        int[] f4341f;

        /* renamed from: g */
        List<LazySpanLookup.FullSpanItem> f4342g;

        /* renamed from: h */
        boolean f4343h;

        /* renamed from: i */
        boolean f4344i;

        /* renamed from: j */
        boolean f4345j;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$a */
        static class C0925a implements Parcelable.Creator<SavedState> {
            C0925a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7563a() {
            this.f4339d = null;
            this.f4338c = 0;
            this.f4336a = -1;
            this.f4337b = -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7564b() {
            this.f4339d = null;
            this.f4338c = 0;
            this.f4340e = 0;
            this.f4341f = null;
            this.f4342g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4336a);
            parcel.writeInt(this.f4337b);
            parcel.writeInt(this.f4338c);
            if (this.f4338c > 0) {
                parcel.writeIntArray(this.f4339d);
            }
            parcel.writeInt(this.f4340e);
            if (this.f4340e > 0) {
                parcel.writeIntArray(this.f4341f);
            }
            parcel.writeInt(this.f4343h ? 1 : 0);
            parcel.writeInt(this.f4344i ? 1 : 0);
            parcel.writeInt(this.f4345j ? 1 : 0);
            parcel.writeList(this.f4342g);
        }

        SavedState(Parcel parcel) {
            this.f4336a = parcel.readInt();
            this.f4337b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f4338c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f4339d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f4340e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f4341f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.f4343h = parcel.readInt() == 1;
            this.f4344i = parcel.readInt() == 1;
            this.f4345j = parcel.readInt() == 1 ? true : z;
            this.f4342g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f4338c = savedState.f4338c;
            this.f4336a = savedState.f4336a;
            this.f4337b = savedState.f4337b;
            this.f4339d = savedState.f4339d;
            this.f4340e = savedState.f4340e;
            this.f4341f = savedState.f4341f;
            this.f4343h = savedState.f4343h;
            this.f4344i = savedState.f4344i;
            this.f4345j = savedState.f4345j;
            this.f4342g = savedState.f4342g;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$a */
    class C0926a implements Runnable {
        C0926a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.mo7512D();
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$b */
    class C0927b {

        /* renamed from: a */
        int f4347a;

        /* renamed from: b */
        int f4348b;

        /* renamed from: c */
        boolean f4349c;

        /* renamed from: d */
        boolean f4350d;

        /* renamed from: e */
        boolean f4351e;

        /* renamed from: f */
        int[] f4352f;

        C0927b() {
            mo7574c();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7572a() {
            int i;
            if (this.f4349c) {
                i = StaggeredGridLayoutManager.this.f4322u.getEndAfterPadding();
            } else {
                i = StaggeredGridLayoutManager.this.f4322u.getStartAfterPadding();
            }
            this.f4348b = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7573b(int i) {
            if (this.f4349c) {
                this.f4348b = StaggeredGridLayoutManager.this.f4322u.getEndAfterPadding() - i;
            } else {
                this.f4348b = StaggeredGridLayoutManager.this.f4322u.getStartAfterPadding() + i;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo7574c() {
            this.f4347a = -1;
            this.f4348b = Integer.MIN_VALUE;
            this.f4349c = false;
            this.f4350d = false;
            this.f4351e = false;
            int[] iArr = this.f4352f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7575d(C0928c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f4352f;
            if (iArr == null || iArr.length < length) {
                this.f4352f = new int[StaggeredGridLayoutManager.this.f4321t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f4352f[i] = cVarArr[i].mo7597u(Integer.MIN_VALUE);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c */
    class C0928c {

        /* renamed from: a */
        ArrayList<View> f4354a = new ArrayList<>();

        /* renamed from: b */
        int f4355b = Integer.MIN_VALUE;

        /* renamed from: c */
        int f4356c = Integer.MIN_VALUE;

        /* renamed from: d */
        int f4357d = 0;

        /* renamed from: e */
        final int f4358e;

        C0928c(int i) {
            this.f4358e = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: A */
        public void mo7576A(int i) {
            this.f4355b = i;
            this.f4356c = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7577a(View view) {
            LayoutParams s = mo7595s(view);
            s.f4328e = this;
            this.f4354a.add(view);
            this.f4356c = Integer.MIN_VALUE;
            if (this.f4354a.size() == 1) {
                this.f4355b = Integer.MIN_VALUE;
            }
            if (s.isItemRemoved() || s.isItemChanged()) {
                this.f4357d += StaggeredGridLayoutManager.this.f4322u.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7578b(boolean z, int i) {
            int i2;
            if (z) {
                i2 = mo7593q(Integer.MIN_VALUE);
            } else {
                i2 = mo7597u(Integer.MIN_VALUE);
            }
            mo7581e();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < StaggeredGridLayoutManager.this.f4322u.getEndAfterPadding()) {
                    return;
                }
                if (z || i2 <= StaggeredGridLayoutManager.this.f4322u.getStartAfterPadding()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.f4356c = i2;
                    this.f4355b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo7579c() {
            LazySpanLookup.FullSpanItem f;
            ArrayList<View> arrayList = this.f4354a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams s = mo7595s(view);
            this.f4356c = StaggeredGridLayoutManager.this.f4322u.getDecoratedEnd(view);
            if (s.f4329f && (f = StaggeredGridLayoutManager.this.f4308E.mo7548f(s.getViewLayoutPosition())) != null && f.f4333b == 1) {
                this.f4356c += f.mo7555a(this.f4358e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7580d() {
            LazySpanLookup.FullSpanItem f;
            View view = this.f4354a.get(0);
            LayoutParams s = mo7595s(view);
            this.f4355b = StaggeredGridLayoutManager.this.f4322u.getDecoratedStart(view);
            if (s.f4329f && (f = StaggeredGridLayoutManager.this.f4308E.mo7548f(s.getViewLayoutPosition())) != null && f.f4333b == -1) {
                this.f4355b -= f.mo7555a(this.f4358e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo7581e() {
            this.f4354a.clear();
            mo7598v();
            this.f4357d = 0;
        }

        /* renamed from: f */
        public int mo7582f() {
            if (StaggeredGridLayoutManager.this.f4327z) {
                return mo7590n(this.f4354a.size() - 1, -1, true);
            }
            return mo7590n(0, this.f4354a.size(), true);
        }

        /* renamed from: g */
        public int mo7583g() {
            if (StaggeredGridLayoutManager.this.f4327z) {
                return mo7589m(this.f4354a.size() - 1, -1, true);
            }
            return mo7589m(0, this.f4354a.size(), true);
        }

        /* renamed from: h */
        public int mo7584h() {
            if (StaggeredGridLayoutManager.this.f4327z) {
                return mo7590n(this.f4354a.size() - 1, -1, false);
            }
            return mo7590n(0, this.f4354a.size(), false);
        }

        /* renamed from: i */
        public int mo7585i() {
            if (StaggeredGridLayoutManager.this.f4327z) {
                return mo7590n(0, this.f4354a.size(), true);
            }
            return mo7590n(this.f4354a.size() - 1, -1, true);
        }

        /* renamed from: j */
        public int mo7586j() {
            if (StaggeredGridLayoutManager.this.f4327z) {
                return mo7589m(0, this.f4354a.size(), true);
            }
            return mo7589m(this.f4354a.size() - 1, -1, true);
        }

        /* renamed from: k */
        public int mo7587k() {
            if (StaggeredGridLayoutManager.this.f4327z) {
                return mo7590n(0, this.f4354a.size(), false);
            }
            return mo7590n(this.f4354a.size() - 1, -1, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public int mo7588l(int i, int i2, boolean z, boolean z2, boolean z3) {
            int startAfterPadding = StaggeredGridLayoutManager.this.f4322u.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.f4322u.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f4354a.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.f4322u.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.f4322u.getDecoratedEnd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? decoratedStart < endAfterPadding : decoratedStart <= endAfterPadding;
                if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public int mo7589m(int i, int i2, boolean z) {
            return mo7588l(i, i2, false, false, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public int mo7590n(int i, int i2, boolean z) {
            return mo7588l(i, i2, z, true, false);
        }

        /* renamed from: o */
        public int mo7591o() {
            return this.f4357d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public int mo7592p() {
            int i = this.f4356c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo7579c();
            return this.f4356c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public int mo7593q(int i) {
            int i2 = this.f4356c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4354a.size() == 0) {
                return i;
            }
            mo7579c();
            return this.f4356c;
        }

        /* renamed from: r */
        public View mo7594r(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f4354a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f4354a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f4327z && staggeredGridLayoutManager.getPosition(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f4327z && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f4354a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f4354a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f4327z && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f4327z && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public LayoutParams mo7595s(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public int mo7596t() {
            int i = this.f4355b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo7580d();
            return this.f4355b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public int mo7597u(int i) {
            int i2 = this.f4355b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4354a.size() == 0) {
                return i;
            }
            mo7580d();
            return this.f4355b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public void mo7598v() {
            this.f4355b = Integer.MIN_VALUE;
            this.f4356c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public void mo7599w(int i) {
            int i2 = this.f4355b;
            if (i2 != Integer.MIN_VALUE) {
                this.f4355b = i2 + i;
            }
            int i3 = this.f4356c;
            if (i3 != Integer.MIN_VALUE) {
                this.f4356c = i3 + i;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: x */
        public void mo7600x() {
            int size = this.f4354a.size();
            View remove = this.f4354a.remove(size - 1);
            LayoutParams s = mo7595s(remove);
            s.f4328e = null;
            if (s.isItemRemoved() || s.isItemChanged()) {
                this.f4357d -= StaggeredGridLayoutManager.this.f4322u.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.f4355b = Integer.MIN_VALUE;
            }
            this.f4356c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public void mo7601y() {
            View remove = this.f4354a.remove(0);
            LayoutParams s = mo7595s(remove);
            s.f4328e = null;
            if (this.f4354a.size() == 0) {
                this.f4356c = Integer.MIN_VALUE;
            }
            if (s.isItemRemoved() || s.isItemChanged()) {
                this.f4357d -= StaggeredGridLayoutManager.this.f4322u.getDecoratedMeasurement(remove);
            }
            this.f4355b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z */
        public void mo7602z(View view) {
            LayoutParams s = mo7595s(view);
            s.f4328e = this;
            this.f4354a.add(0, view);
            this.f4355b = Integer.MIN_VALUE;
            if (this.f4354a.size() == 1) {
                this.f4356c = Integer.MIN_VALUE;
            }
            if (s.isItemRemoved() || s.isItemChanged()) {
                this.f4357d += StaggeredGridLayoutManager.this.f4322u.getDecoratedMeasurement(view);
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.f4326y = new C0947f();
        m3297L();
    }

    /* renamed from: B */
    private void m3288B(View view, LayoutParams layoutParams, C0947f fVar) {
        if (fVar.f4444e == 1) {
            if (layoutParams.f4329f) {
                m3324x(view);
            } else {
                layoutParams.f4328e.mo7577a(view);
            }
        } else if (layoutParams.f4329f) {
            m3313i0(view);
        } else {
            layoutParams.f4328e.mo7602z(view);
        }
    }

    /* renamed from: C */
    private int m3289C(int i) {
        if (getChildCount() != 0) {
            if ((i < mo7516U()) != this.f4304A) {
                return -1;
            }
            return 1;
        } else if (this.f4304A) {
            return 1;
        } else {
            return -1;
        }
    }

    /* renamed from: E */
    private boolean m3290E(C0928c cVar) {
        if (this.f4304A) {
            if (cVar.mo7592p() < this.f4322u.getEndAfterPadding()) {
                ArrayList<View> arrayList = cVar.f4354a;
                return !cVar.mo7595s(arrayList.get(arrayList.size() - 1)).f4329f;
            }
        } else if (cVar.mo7596t() > this.f4322u.getStartAfterPadding()) {
            return !cVar.mo7595s(cVar.f4354a.get(0)).f4329f;
        }
        return false;
    }

    /* renamed from: F */
    private int m3291F(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0957i.m3549a(state, this.f4322u, mo7514P(!this.f4317N), mo7513O(!this.f4317N), this, this.f4317N);
    }

    /* renamed from: G */
    private int m3292G(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0957i.m3550b(state, this.f4322u, mo7514P(!this.f4317N), mo7513O(!this.f4317N), this, this.f4317N, this.f4304A);
    }

    /* renamed from: H */
    private int m3293H(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0957i.m3551c(state, this.f4322u, mo7514P(!this.f4317N), mo7513O(!this.f4317N), this, this.f4317N);
    }

    /* renamed from: I */
    private int m3294I(int i) {
        if (i == 1) {
            return (this.f4324w != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.f4324w != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.f4324w == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.f4324w == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.f4324w == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.f4324w == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: J */
    private LazySpanLookup.FullSpanItem m3295J(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4334c = new int[this.f4320s];
        for (int i2 = 0; i2 < this.f4320s; i2++) {
            fullSpanItem.f4334c[i2] = i - this.f4321t[i2].mo7593q(i);
        }
        return fullSpanItem;
    }

    /* renamed from: K */
    private LazySpanLookup.FullSpanItem m3296K(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4334c = new int[this.f4320s];
        for (int i2 = 0; i2 < this.f4320s; i2++) {
            fullSpanItem.f4334c[i2] = this.f4321t[i2].mo7597u(i) - i;
        }
        return fullSpanItem;
    }

    /* renamed from: L */
    private void m3297L() {
        this.f4322u = OrientationHelper.createOrientationHelper(this, this.f4324w);
        this.f4323v = OrientationHelper.createOrientationHelper(this, 1 - this.f4324w);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* renamed from: M */
    private int m3298M(RecyclerView.Recycler recycler, C0947f fVar, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        C0928c cVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        RecyclerView.Recycler recycler2 = recycler;
        C0947f fVar2 = fVar;
        ? r9 = 0;
        this.f4305B.set(0, this.f4320s, true);
        if (this.f4326y.f4448i) {
            i = fVar2.f4444e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (fVar2.f4444e == 1) {
                i12 = fVar2.f4446g + fVar2.f4441b;
            } else {
                i12 = fVar2.f4445f - fVar2.f4441b;
            }
            i = i12;
        }
        m3320q0(fVar2.f4444e, i);
        if (this.f4304A) {
            i2 = this.f4322u.getEndAfterPadding();
        } else {
            i2 = this.f4322u.getStartAfterPadding();
        }
        int i13 = i2;
        boolean z2 = false;
        while (fVar.mo7692a(state) && (this.f4326y.f4448i || !this.f4305B.isEmpty())) {
            View b = fVar2.mo7693b(recycler2);
            LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int g = this.f4308E.mo7549g(viewLayoutPosition);
            boolean z3 = g == -1;
            if (z3) {
                cVar = layoutParams.f4329f ? this.f4321t[r9] : m3307a0(fVar2);
                this.f4308E.mo7553n(viewLayoutPosition, cVar);
            } else {
                cVar = this.f4321t[g];
            }
            C0928c cVar2 = cVar;
            layoutParams.f4328e = cVar2;
            if (fVar2.f4444e == 1) {
                addView(b);
            } else {
                addView(b, r9);
            }
            m3310e0(b, layoutParams, r9);
            if (fVar2.f4444e == 1) {
                if (layoutParams.f4329f) {
                    i11 = m3303W(i13);
                } else {
                    i11 = cVar2.mo7593q(i13);
                }
                int decoratedMeasurement = this.f4322u.getDecoratedMeasurement(b) + i11;
                if (z3 && layoutParams.f4329f) {
                    LazySpanLookup.FullSpanItem J = m3295J(i11);
                    J.f4333b = -1;
                    J.f4332a = viewLayoutPosition;
                    this.f4308E.mo7543a(J);
                }
                i4 = decoratedMeasurement;
                i5 = i11;
            } else {
                if (layoutParams.f4329f) {
                    i10 = m3306Z(i13);
                } else {
                    i10 = cVar2.mo7597u(i13);
                }
                i5 = i10 - this.f4322u.getDecoratedMeasurement(b);
                if (z3 && layoutParams.f4329f) {
                    LazySpanLookup.FullSpanItem K = m3296K(i10);
                    K.f4333b = 1;
                    K.f4332a = viewLayoutPosition;
                    this.f4308E.mo7543a(K);
                }
                i4 = i10;
            }
            if (layoutParams.f4329f && fVar2.f4443d == -1) {
                if (z3) {
                    this.f4316M = true;
                } else {
                    if (fVar2.f4444e == 1) {
                        z = mo7539z();
                    } else {
                        z = mo7511A();
                    }
                    if (!z) {
                        LazySpanLookup.FullSpanItem f = this.f4308E.mo7548f(viewLayoutPosition);
                        if (f != null) {
                            f.f4335d = true;
                        }
                        this.f4316M = true;
                    }
                }
            }
            m3288B(b, layoutParams, fVar2);
            if (!isLayoutRTL() || this.f4324w != 1) {
                if (layoutParams.f4329f) {
                    i8 = this.f4323v.getStartAfterPadding();
                } else {
                    i8 = (cVar2.f4358e * this.f4325x) + this.f4323v.getStartAfterPadding();
                }
                i7 = i8;
                i6 = this.f4323v.getDecoratedMeasurement(b) + i8;
            } else {
                if (layoutParams.f4329f) {
                    i9 = this.f4323v.getEndAfterPadding();
                } else {
                    i9 = this.f4323v.getEndAfterPadding() - (((this.f4320s - 1) - cVar2.f4358e) * this.f4325x);
                }
                i6 = i9;
                i7 = i9 - this.f4323v.getDecoratedMeasurement(b);
            }
            if (this.f4324w == 1) {
                layoutDecoratedWithMargins(b, i7, i5, i6, i4);
            } else {
                layoutDecoratedWithMargins(b, i5, i7, i4, i6);
            }
            if (layoutParams.f4329f) {
                m3320q0(this.f4326y.f4444e, i);
            } else {
                m3323w0(cVar2, this.f4326y.f4444e, i);
            }
            m3314j0(recycler2, this.f4326y);
            if (this.f4326y.f4447h && b.hasFocusable()) {
                if (layoutParams.f4329f) {
                    this.f4305B.clear();
                } else {
                    this.f4305B.set(cVar2.f4358e, false);
                    z2 = true;
                    r9 = 0;
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            m3314j0(recycler2, this.f4326y);
        }
        if (this.f4326y.f4444e == -1) {
            i3 = this.f4322u.getStartAfterPadding() - m3306Z(this.f4322u.getStartAfterPadding());
        } else {
            i3 = m3303W(this.f4322u.getEndAfterPadding()) - this.f4322u.getEndAfterPadding();
        }
        if (i3 > 0) {
            return Math.min(fVar2.f4441b, i3);
        }
        return 0;
    }

    /* renamed from: N */
    private int m3299N(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: R */
    private int m3300R(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: S */
    private void m3301S(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int W = m3303W(Integer.MIN_VALUE);
        if (W != Integer.MIN_VALUE && (endAfterPadding = this.f4322u.getEndAfterPadding() - W) > 0) {
            int i = endAfterPadding - (-mo7530o0(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.f4322u.offsetChildren(i);
            }
        }
    }

    /* renamed from: T */
    private void m3302T(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int Z = m3306Z(Integer.MAX_VALUE);
        if (Z != Integer.MAX_VALUE && (startAfterPadding = Z - this.f4322u.getStartAfterPadding()) > 0) {
            int o0 = startAfterPadding - mo7530o0(startAfterPadding, recycler, state);
            if (z && o0 > 0) {
                this.f4322u.offsetChildren(-o0);
            }
        }
    }

    /* renamed from: W */
    private int m3303W(int i) {
        int q = this.f4321t[0].mo7593q(i);
        for (int i2 = 1; i2 < this.f4320s; i2++) {
            int q2 = this.f4321t[i2].mo7593q(i);
            if (q2 > q) {
                q = q2;
            }
        }
        return q;
    }

    /* renamed from: X */
    private int m3304X(int i) {
        int u = this.f4321t[0].mo7597u(i);
        for (int i2 = 1; i2 < this.f4320s; i2++) {
            int u2 = this.f4321t[i2].mo7597u(i);
            if (u2 > u) {
                u = u2;
            }
        }
        return u;
    }

    /* renamed from: Y */
    private int m3305Y(int i) {
        int q = this.f4321t[0].mo7593q(i);
        for (int i2 = 1; i2 < this.f4320s; i2++) {
            int q2 = this.f4321t[i2].mo7593q(i);
            if (q2 < q) {
                q = q2;
            }
        }
        return q;
    }

    /* renamed from: Z */
    private int m3306Z(int i) {
        int u = this.f4321t[0].mo7597u(i);
        for (int i2 = 1; i2 < this.f4320s; i2++) {
            int u2 = this.f4321t[i2].mo7597u(i);
            if (u2 < u) {
                u = u2;
            }
        }
        return u;
    }

    /* renamed from: a0 */
    private C0928c m3307a0(C0947f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (m3312g0(fVar.f4444e)) {
            i2 = this.f4320s - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.f4320s;
            i = 1;
        }
        C0928c cVar = null;
        if (fVar.f4444e == 1) {
            int i4 = Integer.MAX_VALUE;
            int startAfterPadding = this.f4322u.getStartAfterPadding();
            while (i2 != i3) {
                C0928c cVar2 = this.f4321t[i2];
                int q = cVar2.mo7593q(startAfterPadding);
                if (q < i4) {
                    cVar = cVar2;
                    i4 = q;
                }
                i2 += i;
            }
            return cVar;
        }
        int i5 = Integer.MIN_VALUE;
        int endAfterPadding = this.f4322u.getEndAfterPadding();
        while (i2 != i3) {
            C0928c cVar3 = this.f4321t[i2];
            int u = cVar3.mo7597u(endAfterPadding);
            if (u > i5) {
                cVar = cVar3;
                i5 = u;
            }
            i2 += i;
        }
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* renamed from: b0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3308b0(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4304A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.mo7517V()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.mo7516U()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f4308E
            r4.mo7550h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4308E
            r9.mo7552k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f4308E
            r7.mo7551j(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4308E
            r9.mo7552k(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4308E
            r9.mo7551j(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.f4304A
            if (r7 == 0) goto L_0x004d
            int r7 = r6.mo7516U()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.mo7517V()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m3308b0(int, int, int):void");
    }

    /* renamed from: d0 */
    private void m3309d0(View view, int i, int i2, boolean z) {
        boolean z2;
        calculateItemDecorationsForChild(view, this.f4314K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin;
        Rect rect = this.f4314K;
        int x0 = m3325x0(i, i3 + rect.left, layoutParams.rightMargin + rect.right);
        int i4 = layoutParams.topMargin;
        Rect rect2 = this.f4314K;
        int x02 = m3325x0(i2, i4 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z) {
            z2 = mo7262v(view, x0, x02, layoutParams);
        } else {
            z2 = mo7261t(view, x0, x02, layoutParams);
        }
        if (z2) {
            view.measure(x0, x02);
        }
    }

    /* renamed from: e0 */
    private void m3310e0(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f4329f) {
            if (this.f4324w == 1) {
                m3309d0(view, this.f4313J, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z);
            } else {
                m3309d0(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.f4313J, z);
            }
        } else if (this.f4324w == 1) {
            m3309d0(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.f4325x, getWidthMode(), 0, layoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z);
        } else {
            m3309d0(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.f4325x, getHeightMode(), 0, layoutParams.height, false), z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (mo7512D() != false) goto L_0x015b;
     */
    /* renamed from: f0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3311f0(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r8.f4315L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f4312I
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f4306C
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.getItemCount()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.mo7574c()
            return
        L_0x0018:
            boolean r1 = r0.f4351e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f4306C
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f4312I
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.mo7574c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f4312I
            if (r5 == 0) goto L_0x0037
            r8.m3326y(r0)
            goto L_0x003e
        L_0x0037:
            r8.m3318n0()
            boolean r5 = r8.f4304A
            r0.f4349c = r5
        L_0x003e:
            r8.mo7537t0(r10, r0)
            r0.f4351e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f4312I
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f4306C
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f4349c
            boolean r6 = r8.f4310G
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.isLayoutRTL()
            boolean r6 = r8.f4311H
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.f4308E
            r5.mo7544b()
            r0.f4350d = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f4312I
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f4338c
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f4350d
            if (r5 == 0) goto L_0x008e
            r1 = 0
        L_0x0073:
            int r5 = r8.f4320s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f4321t
            r5 = r5[r1]
            r5.mo7581e()
            int r5 = r0.f4348b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r6 = r8.f4321t
            r6 = r6[r1]
            r6.mo7576A(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f4315L
            int[] r1 = r1.f4352f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = 0
        L_0x0098:
            int r5 = r8.f4320s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f4321t
            r5 = r5[r1]
            r5.mo7581e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r6 = r8.f4315L
            int[] r6 = r6.f4352f
            r6 = r6[r1]
            r5.mo7576A(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = 0
        L_0x00b0:
            int r5 = r8.f4320s
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f4321t
            r5 = r5[r1]
            boolean r6 = r8.f4304A
            int r7 = r0.f4348b
            r5.mo7578b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f4315L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f4321t
            r1.mo7575d(r5)
        L_0x00c9:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.f r1 = r8.f4326y
            r1.f4440a = r3
            r8.f4316M = r3
            androidx.recyclerview.widget.OrientationHelper r1 = r8.f4323v
            int r1 = r1.getTotalSpace()
            r8.mo7538v0(r1)
            int r1 = r0.f4347a
            r8.m3322u0(r1, r10)
            boolean r1 = r0.f4349c
            if (r1 == 0) goto L_0x00fc
            r8.m3319p0(r2)
            androidx.recyclerview.widget.f r1 = r8.f4326y
            r8.m3298M(r9, r1, r10)
            r8.m3319p0(r4)
            androidx.recyclerview.widget.f r1 = r8.f4326y
            int r2 = r0.f4347a
            int r5 = r1.f4443d
            int r2 = r2 + r5
            r1.f4442c = r2
            r8.m3298M(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.m3319p0(r4)
            androidx.recyclerview.widget.f r1 = r8.f4326y
            r8.m3298M(r9, r1, r10)
            r8.m3319p0(r2)
            androidx.recyclerview.widget.f r1 = r8.f4326y
            int r2 = r0.f4347a
            int r5 = r1.f4443d
            int r2 = r2 + r5
            r1.f4442c = r2
            r8.m3298M(r9, r1, r10)
        L_0x0113:
            r8.m3317m0()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.f4304A
            if (r1 == 0) goto L_0x0127
            r8.m3301S(r9, r10, r4)
            r8.m3302T(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.m3302T(r9, r10, r4)
            r8.m3301S(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.isPreLayout()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.f4309F
            if (r11 == 0) goto L_0x014b
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.f4316M
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.mo7518c0()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = 1
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.f4319P
            r8.removeCallbacks(r11)
            boolean r11 = r8.mo7512D()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = 0
        L_0x015b:
            boolean r11 = r10.isPreLayout()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f4315L
            r11.mo7574c()
        L_0x0166:
            boolean r11 = r0.f4349c
            r8.f4310G = r11
            boolean r11 = r8.isLayoutRTL()
            r8.f4311H = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f4315L
            r11.mo7574c()
            r8.m3311f0(r9, r10, r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m3311f0(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    /* renamed from: g0 */
    private boolean m3312g0(int i) {
        if (this.f4324w == 0) {
            if ((i == -1) != this.f4304A) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f4304A) == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    /* renamed from: i0 */
    private void m3313i0(View view) {
        for (int i = this.f4320s - 1; i >= 0; i--) {
            this.f4321t[i].mo7602z(view);
        }
    }

    /* renamed from: j0 */
    private void m3314j0(RecyclerView.Recycler recycler, C0947f fVar) {
        int i;
        int i2;
        if (fVar.f4440a && !fVar.f4448i) {
            if (fVar.f4441b == 0) {
                if (fVar.f4444e == -1) {
                    m3315k0(recycler, fVar.f4446g);
                } else {
                    m3316l0(recycler, fVar.f4445f);
                }
            } else if (fVar.f4444e == -1) {
                int i3 = fVar.f4445f;
                int X = i3 - m3304X(i3);
                if (X < 0) {
                    i2 = fVar.f4446g;
                } else {
                    i2 = fVar.f4446g - Math.min(X, fVar.f4441b);
                }
                m3315k0(recycler, i2);
            } else {
                int Y = m3305Y(fVar.f4446g) - fVar.f4446g;
                if (Y < 0) {
                    i = fVar.f4445f;
                } else {
                    i = Math.min(Y, fVar.f4441b) + fVar.f4445f;
                }
                m3316l0(recycler, i);
            }
        }
    }

    /* renamed from: k0 */
    private void m3315k0(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f4322u.getDecoratedStart(childAt) >= i && this.f4322u.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4329f) {
                    int i2 = 0;
                    while (i2 < this.f4320s) {
                        if (this.f4321t[i2].f4354a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f4320s; i3++) {
                        this.f4321t[i3].mo7600x();
                    }
                } else if (layoutParams.f4328e.f4354a.size() != 1) {
                    layoutParams.f4328e.mo7600x();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    /* renamed from: l0 */
    private void m3316l0(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f4322u.getDecoratedEnd(childAt) <= i && this.f4322u.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4329f) {
                    int i2 = 0;
                    while (i2 < this.f4320s) {
                        if (this.f4321t[i2].f4354a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f4320s; i3++) {
                        this.f4321t[i3].mo7601y();
                    }
                } else if (layoutParams.f4328e.f4354a.size() != 1) {
                    layoutParams.f4328e.mo7601y();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    /* renamed from: m0 */
    private void m3317m0() {
        if (this.f4323v.getMode() != 1073741824) {
            float f = 0.0f;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                float decoratedMeasurement = (float) this.f4323v.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f) {
                    if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                        decoratedMeasurement = (decoratedMeasurement * 1.0f) / ((float) this.f4320s);
                    }
                    f = Math.max(f, decoratedMeasurement);
                }
            }
            int i2 = this.f4325x;
            int round = Math.round(f * ((float) this.f4320s));
            if (this.f4323v.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f4323v.getTotalSpace());
            }
            mo7538v0(round);
            if (this.f4325x != i2) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.f4329f) {
                        if (!isLayoutRTL() || this.f4324w != 1) {
                            int i4 = layoutParams.f4328e.f4358e;
                            int i5 = this.f4325x * i4;
                            int i6 = i4 * i2;
                            if (this.f4324w == 1) {
                                childAt2.offsetLeftAndRight(i5 - i6);
                            } else {
                                childAt2.offsetTopAndBottom(i5 - i6);
                            }
                        } else {
                            int i7 = this.f4320s;
                            int i8 = layoutParams.f4328e.f4358e;
                            childAt2.offsetLeftAndRight(((-((i7 - 1) - i8)) * this.f4325x) - ((-((i7 - 1) - i8)) * i2));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: n0 */
    private void m3318n0() {
        if (this.f4324w == 1 || !isLayoutRTL()) {
            this.f4304A = this.f4327z;
        } else {
            this.f4304A = !this.f4327z;
        }
    }

    /* renamed from: p0 */
    private void m3319p0(int i) {
        C0947f fVar = this.f4326y;
        fVar.f4444e = i;
        int i2 = 1;
        if (this.f4304A != (i == -1)) {
            i2 = -1;
        }
        fVar.f4443d = i2;
    }

    /* renamed from: q0 */
    private void m3320q0(int i, int i2) {
        for (int i3 = 0; i3 < this.f4320s; i3++) {
            if (!this.f4321t[i3].f4354a.isEmpty()) {
                m3323w0(this.f4321t[i3], i, i2);
            }
        }
    }

    /* renamed from: r0 */
    private boolean m3321r0(RecyclerView.State state, C0927b bVar) {
        int i;
        if (this.f4310G) {
            i = m3300R(state.getItemCount());
        } else {
            i = m3299N(state.getItemCount());
        }
        bVar.f4347a = i;
        bVar.f4348b = Integer.MIN_VALUE;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* renamed from: u0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3322u0(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.f r0 = r4.f4326y
            r1 = 0
            r0.f4441b = r1
            r0.f4442c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.getTargetScrollPosition()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.f4304A
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f4322u
            int r5 = r5.getTotalSpace()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f4322u
            int r5 = r5.getTotalSpace()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.f r0 = r4.f4326y
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f4322u
            int r3 = r3.getStartAfterPadding()
            int r3 = r3 - r6
            r0.f4445f = r3
            androidx.recyclerview.widget.f r6 = r4.f4326y
            androidx.recyclerview.widget.OrientationHelper r0 = r4.f4322u
            int r0 = r0.getEndAfterPadding()
            int r0 = r0 + r5
            r6.f4446g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.f r0 = r4.f4326y
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f4322u
            int r3 = r3.getEnd()
            int r3 = r3 + r5
            r0.f4446g = r3
            androidx.recyclerview.widget.f r5 = r4.f4326y
            int r6 = -r6
            r5.f4445f = r6
        L_0x005d:
            androidx.recyclerview.widget.f r5 = r4.f4326y
            r5.f4447h = r1
            r5.f4440a = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f4322u
            int r6 = r6.getMode()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f4322u
            int r6 = r6.getEnd()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.f4448i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m3322u0(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    /* renamed from: w0 */
    private void m3323w0(C0928c cVar, int i, int i2) {
        int o = cVar.mo7591o();
        if (i == -1) {
            if (cVar.mo7596t() + o <= i2) {
                this.f4305B.set(cVar.f4358e, false);
            }
        } else if (cVar.mo7592p() - o >= i2) {
            this.f4305B.set(cVar.f4358e, false);
        }
    }

    /* renamed from: x */
    private void m3324x(View view) {
        for (int i = this.f4320s - 1; i >= 0; i--) {
            this.f4321t[i].mo7577a(view);
        }
    }

    /* renamed from: x0 */
    private int m3325x0(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    /* renamed from: y */
    private void m3326y(C0927b bVar) {
        int i;
        SavedState savedState = this.f4312I;
        int i2 = savedState.f4338c;
        if (i2 > 0) {
            if (i2 == this.f4320s) {
                for (int i3 = 0; i3 < this.f4320s; i3++) {
                    this.f4321t[i3].mo7581e();
                    SavedState savedState2 = this.f4312I;
                    int i4 = savedState2.f4339d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (savedState2.f4344i) {
                            i = this.f4322u.getEndAfterPadding();
                        } else {
                            i = this.f4322u.getStartAfterPadding();
                        }
                        i4 += i;
                    }
                    this.f4321t[i3].mo7576A(i4);
                }
            } else {
                savedState.mo7564b();
                SavedState savedState3 = this.f4312I;
                savedState3.f4336a = savedState3.f4337b;
            }
        }
        SavedState savedState4 = this.f4312I;
        this.f4311H = savedState4.f4345j;
        setReverseLayout(savedState4.f4343h);
        m3318n0();
        SavedState savedState5 = this.f4312I;
        int i5 = savedState5.f4336a;
        if (i5 != -1) {
            this.f4306C = i5;
            bVar.f4349c = savedState5.f4344i;
        } else {
            bVar.f4349c = this.f4304A;
        }
        if (savedState5.f4340e > 1) {
            LazySpanLookup lazySpanLookup = this.f4308E;
            lazySpanLookup.f4330a = savedState5.f4341f;
            lazySpanLookup.f4331b = savedState5.f4342g;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public boolean mo7511A() {
        int u = this.f4321t[0].mo7597u(Integer.MIN_VALUE);
        for (int i = 1; i < this.f4320s; i++) {
            if (this.f4321t[i].mo7597u(Integer.MIN_VALUE) != u) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public boolean mo7512D() {
        int i;
        int i2;
        if (getChildCount() == 0 || this.f4309F == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f4304A) {
            i2 = mo7517V();
            i = mo7516U();
        } else {
            i2 = mo7516U();
            i = mo7517V();
        }
        if (i2 == 0 && mo7518c0() != null) {
            this.f4308E.mo7544b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.f4316M) {
            return false;
        } else {
            int i3 = this.f4304A ? -1 : 1;
            int i4 = i + 1;
            LazySpanLookup.FullSpanItem e = this.f4308E.mo7547e(i2, i4, i3, true);
            if (e == null) {
                this.f4316M = false;
                this.f4308E.mo7546d(i4);
                return false;
            }
            LazySpanLookup.FullSpanItem e2 = this.f4308E.mo7547e(i2, e.f4332a, i3 * -1, true);
            if (e2 == null) {
                this.f4308E.mo7546d(e.f4332a);
            } else {
                this.f4308E.mo7546d(e2.f4332a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public View mo7513O(boolean z) {
        int startAfterPadding = this.f4322u.getStartAfterPadding();
        int endAfterPadding = this.f4322u.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.f4322u.getDecoratedStart(childAt);
            int decoratedEnd = this.f4322u.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P */
    public View mo7514P(boolean z) {
        int startAfterPadding = this.f4322u.getStartAfterPadding();
        int endAfterPadding = this.f4322u.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.f4322u.getDecoratedStart(childAt);
            if (this.f4322u.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Q */
    public int mo7515Q() {
        View view;
        if (this.f4304A) {
            view = mo7513O(true);
        } else {
            view = mo7514P(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: U */
    public int mo7516U() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: V */
    public int mo7517V() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f4312I == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* renamed from: c0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo7518c0() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f4320s
            r2.<init>(r3)
            int r3 = r12.f4320s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f4324w
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f4304A
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f4328e
            int r9 = r9.f4358e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f4328e
            boolean r9 = r12.m3290E(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f4328e
            int r9 = r9.f4358e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f4329f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f4304A
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f4322u
            int r10 = r10.getDecoratedEnd(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f4322u
            int r11 = r11.getDecoratedEnd(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f4322u
            int r10 = r10.getDecoratedStart(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f4322u
            int r11 = r11.getDecoratedStart(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f4328e
            int r8 = r8.f4358e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f4328e
            int r9 = r9.f4358e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.mo7518c0():android.view.View");
    }

    public boolean canScrollHorizontally() {
        return this.f4324w == 0;
    }

    public boolean canScrollVertically() {
        return this.f4324w == 1;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        int i4;
        if (this.f4324w != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            mo7527h0(i, state);
            int[] iArr = this.f4318O;
            if (iArr == null || iArr.length < this.f4320s) {
                this.f4318O = new int[this.f4320s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.f4320s; i6++) {
                C0947f fVar = this.f4326y;
                if (fVar.f4443d == -1) {
                    i4 = fVar.f4445f;
                    i3 = this.f4321t[i6].mo7597u(i4);
                } else {
                    i4 = this.f4321t[i6].mo7593q(fVar.f4446g);
                    i3 = this.f4326y.f4446g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.f4318O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.f4318O, 0, i5);
            for (int i8 = 0; i8 < i5 && this.f4326y.mo7692a(state); i8++) {
                layoutPrefetchRegistry.addPosition(this.f4326y.f4442c, this.f4318O[i8]);
                C0947f fVar2 = this.f4326y;
                fVar2.f4442c += fVar2.f4443d;
            }
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return m3291F(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return m3292G(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return m3293H(state);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int C = m3289C(i);
        PointF pointF = new PointF();
        if (C == 0) {
            return null;
        }
        if (this.f4324w == 0) {
            pointF.x = (float) C;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) C;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return m3291F(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return m3292G(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return m3293H(state);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f4320s];
        } else if (iArr.length < this.f4320s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f4320s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f4320s; i++) {
            iArr[i] = this.f4321t[i].mo7582f();
        }
        return iArr;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f4320s];
        } else if (iArr.length < this.f4320s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f4320s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f4320s; i++) {
            iArr[i] = this.f4321t[i].mo7584h();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f4320s];
        } else if (iArr.length < this.f4320s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f4320s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f4320s; i++) {
            iArr[i] = this.f4321t[i].mo7585i();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f4320s];
        } else if (iArr.length < this.f4320s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f4320s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f4320s; i++) {
            iArr[i] = this.f4321t[i].mo7587k();
        }
        return iArr;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f4324w == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4324w == 1) {
            return this.f4320s;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.f4309F;
    }

    public int getOrientation() {
        return this.f4324w;
    }

    public boolean getReverseLayout() {
        return this.f4327z;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4324w == 0) {
            return this.f4320s;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.f4320s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h0 */
    public void mo7527h0(int i, RecyclerView.State state) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = mo7517V();
            i2 = 1;
        } else {
            i3 = mo7516U();
            i2 = -1;
        }
        this.f4326y.f4440a = true;
        m3322u0(i3, state);
        m3319p0(i2);
        C0947f fVar = this.f4326y;
        fVar.f4442c = i3 + fVar.f4443d;
        fVar.f4441b = Math.abs(i);
    }

    public void invalidateSpanAssignments() {
        this.f4308E.mo7544b();
        requestLayout();
    }

    public boolean isAutoMeasureEnabled() {
        return this.f4309F != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o0 */
    public int mo7530o0(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        mo7527h0(i, state);
        int M = m3298M(recycler, this.f4326y, state);
        if (this.f4326y.f4441b >= M) {
            i = i < 0 ? -M : M;
        }
        this.f4322u.offsetChildren(-i);
        this.f4310G = this.f4304A;
        C0947f fVar = this.f4326y;
        fVar.f4441b = 0;
        m3314j0(recycler, fVar);
        return i;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f4320s; i2++) {
            this.f4321t[i2].mo7599w(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f4320s; i2++) {
            this.f4321t[i2].mo7599w(i);
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.f4319P);
        for (int i = 0; i < this.f4320s; i++) {
            this.f4321t[i].mo7581e();
        }
        recyclerView.requestLayout();
    }

    @Nullable
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i2;
        int i3;
        int i4;
        int i5;
        View r;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        m3318n0();
        int I = m3294I(i);
        if (I == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.f4329f;
        C0928c cVar = layoutParams.f4328e;
        if (I == 1) {
            i2 = mo7517V();
        } else {
            i2 = mo7516U();
        }
        m3322u0(i2, state);
        m3319p0(I);
        C0947f fVar = this.f4326y;
        fVar.f4442c = fVar.f4443d + i2;
        fVar.f4441b = (int) (((float) this.f4322u.getTotalSpace()) * 0.33333334f);
        C0947f fVar2 = this.f4326y;
        fVar2.f4447h = true;
        fVar2.f4440a = false;
        m3298M(recycler, fVar2, state);
        this.f4310G = this.f4304A;
        if (!z && (r = cVar.mo7594r(i2, I)) != null && r != findContainingItemView) {
            return r;
        }
        if (m3312g0(I)) {
            for (int i6 = this.f4320s - 1; i6 >= 0; i6--) {
                View r2 = this.f4321t[i6].mo7594r(i2, I);
                if (r2 != null && r2 != findContainingItemView) {
                    return r2;
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f4320s; i7++) {
                View r3 = this.f4321t[i7].mo7594r(i2, I);
                if (r3 != null && r3 != findContainingItemView) {
                    return r3;
                }
            }
        }
        boolean z2 = (this.f4327z ^ true) == (I == -1);
        if (!z) {
            if (z2) {
                i5 = cVar.mo7583g();
            } else {
                i5 = cVar.mo7586j();
            }
            View findViewByPosition = findViewByPosition(i5);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (m3312g0(I)) {
            for (int i8 = this.f4320s - 1; i8 >= 0; i8--) {
                if (i8 != cVar.f4358e) {
                    if (z2) {
                        i4 = this.f4321t[i8].mo7583g();
                    } else {
                        i4 = this.f4321t[i8].mo7586j();
                    }
                    View findViewByPosition2 = findViewByPosition(i4);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i9 = 0; i9 < this.f4320s; i9++) {
                if (z2) {
                    i3 = this.f4321t[i9].mo7583g();
                } else {
                    i3 = this.f4321t[i9].mo7586j();
                }
                View findViewByPosition3 = findViewByPosition(i3);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View P = mo7514P(false);
            View O = mo7513O(false);
            if (P != null && O != null) {
                int position = getPosition(P);
                int position2 = getPosition(O);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.mo7212j(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f4324w == 0) {
            int spanIndex = layoutParams2.getSpanIndex();
            boolean z = layoutParams2.f4329f;
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanIndex, z ? this.f4320s : 1, -1, -1, z, false));
            return;
        }
        int spanIndex2 = layoutParams2.getSpanIndex();
        boolean z2 = layoutParams2.f4329f;
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, spanIndex2, z2 ? this.f4320s : 1, z2, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m3308b0(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f4308E.mo7544b();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m3308b0(i, i2, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m3308b0(i, i2, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3308b0(i, i2, 4);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        m3311f0(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f4306C = -1;
        this.f4307D = Integer.MIN_VALUE;
        this.f4312I = null;
        this.f4315L.mo7574c();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f4312I = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i;
        int i2;
        int i3;
        int[] iArr;
        if (this.f4312I != null) {
            return new SavedState(this.f4312I);
        }
        SavedState savedState = new SavedState();
        savedState.f4343h = this.f4327z;
        savedState.f4344i = this.f4310G;
        savedState.f4345j = this.f4311H;
        LazySpanLookup lazySpanLookup = this.f4308E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f4330a) == null) {
            savedState.f4340e = 0;
        } else {
            savedState.f4341f = iArr;
            savedState.f4340e = iArr.length;
            savedState.f4342g = lazySpanLookup.f4331b;
        }
        if (getChildCount() > 0) {
            if (this.f4310G) {
                i = mo7517V();
            } else {
                i = mo7516U();
            }
            savedState.f4336a = i;
            savedState.f4337b = mo7515Q();
            int i4 = this.f4320s;
            savedState.f4338c = i4;
            savedState.f4339d = new int[i4];
            for (int i5 = 0; i5 < this.f4320s; i5++) {
                if (this.f4310G) {
                    i2 = this.f4321t[i5].mo7593q(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f4322u.getEndAfterPadding();
                    } else {
                        savedState.f4339d[i5] = i2;
                    }
                } else {
                    i2 = this.f4321t[i5].mo7597u(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f4322u.getStartAfterPadding();
                    } else {
                        savedState.f4339d[i5] = i2;
                    }
                }
                i2 -= i3;
                savedState.f4339d[i5] = i2;
            }
        } else {
            savedState.f4336a = -1;
            savedState.f4337b = -1;
            savedState.f4338c = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            mo7512D();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s0 */
    public boolean mo7531s0(RecyclerView.State state, C0927b bVar) {
        int i;
        int i2;
        int i3;
        boolean z = false;
        if (!state.isPreLayout() && (i = this.f4306C) != -1) {
            if (i < 0 || i >= state.getItemCount()) {
                this.f4306C = -1;
                this.f4307D = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.f4312I;
                if (savedState == null || savedState.f4336a == -1 || savedState.f4338c < 1) {
                    View findViewByPosition = findViewByPosition(this.f4306C);
                    if (findViewByPosition != null) {
                        if (this.f4304A) {
                            i2 = mo7517V();
                        } else {
                            i2 = mo7516U();
                        }
                        bVar.f4347a = i2;
                        if (this.f4307D != Integer.MIN_VALUE) {
                            if (bVar.f4349c) {
                                bVar.f4348b = (this.f4322u.getEndAfterPadding() - this.f4307D) - this.f4322u.getDecoratedEnd(findViewByPosition);
                            } else {
                                bVar.f4348b = (this.f4322u.getStartAfterPadding() + this.f4307D) - this.f4322u.getDecoratedStart(findViewByPosition);
                            }
                            return true;
                        } else if (this.f4322u.getDecoratedMeasurement(findViewByPosition) > this.f4322u.getTotalSpace()) {
                            if (bVar.f4349c) {
                                i3 = this.f4322u.getEndAfterPadding();
                            } else {
                                i3 = this.f4322u.getStartAfterPadding();
                            }
                            bVar.f4348b = i3;
                            return true;
                        } else {
                            int decoratedStart = this.f4322u.getDecoratedStart(findViewByPosition) - this.f4322u.getStartAfterPadding();
                            if (decoratedStart < 0) {
                                bVar.f4348b = -decoratedStart;
                                return true;
                            }
                            int endAfterPadding = this.f4322u.getEndAfterPadding() - this.f4322u.getDecoratedEnd(findViewByPosition);
                            if (endAfterPadding < 0) {
                                bVar.f4348b = endAfterPadding;
                                return true;
                            }
                            bVar.f4348b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i4 = this.f4306C;
                        bVar.f4347a = i4;
                        int i5 = this.f4307D;
                        if (i5 == Integer.MIN_VALUE) {
                            if (m3289C(i4) == 1) {
                                z = true;
                            }
                            bVar.f4349c = z;
                            bVar.mo7572a();
                        } else {
                            bVar.mo7573b(i5);
                        }
                        bVar.f4350d = true;
                    }
                } else {
                    bVar.f4348b = Integer.MIN_VALUE;
                    bVar.f4347a = this.f4306C;
                }
                return true;
            }
        }
        return false;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo7530o0(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        SavedState savedState = this.f4312I;
        if (!(savedState == null || savedState.f4336a == i)) {
            savedState.mo7563a();
        }
        this.f4306C = i;
        this.f4307D = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        SavedState savedState = this.f4312I;
        if (savedState != null) {
            savedState.mo7563a();
        }
        this.f4306C = i;
        this.f4307D = i2;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo7530o0(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (i != this.f4309F) {
            if (i == 0 || i == 2) {
                this.f4309F = i;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f4324w == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            i3 = RecyclerView.LayoutManager.chooseSize(i, (this.f4325x * this.f4320s) + paddingLeft, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            i4 = RecyclerView.LayoutManager.chooseSize(i2, (this.f4325x * this.f4320s) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.f4324w) {
                this.f4324w = i;
                OrientationHelper orientationHelper = this.f4322u;
                this.f4322u = this.f4323v;
                this.f4323v = orientationHelper;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.f4312I;
        if (!(savedState == null || savedState.f4343h == z)) {
            savedState.f4343h = z;
        }
        this.f4327z = z;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (i != this.f4320s) {
            invalidateSpanAssignments();
            this.f4320s = i;
            this.f4305B = new BitSet(this.f4320s);
            this.f4321t = new C0928c[this.f4320s];
            for (int i2 = 0; i2 < this.f4320s; i2++) {
                this.f4321t[i2] = new C0928c(i2);
            }
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f4312I == null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t0 */
    public void mo7537t0(RecyclerView.State state, C0927b bVar) {
        if (!mo7531s0(state, bVar) && !m3321r0(state, bVar)) {
            bVar.mo7572a();
            bVar.f4347a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v0 */
    public void mo7538v0(int i) {
        this.f4325x = i / this.f4320s;
        this.f4313J = View.MeasureSpec.makeMeasureSpec(i, this.f4323v.getMode());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public boolean mo7539z() {
        int q = this.f4321t[0].mo7593q(Integer.MIN_VALUE);
        for (int i = 1; i < this.f4320s; i++) {
            if (this.f4321t[i].mo7593q(Integer.MIN_VALUE) != q) {
                return false;
            }
        }
        return true;
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    static class LazySpanLookup {

        /* renamed from: a */
        int[] f4330a;

        /* renamed from: b */
        List<FullSpanItem> f4331b;

        LazySpanLookup() {
        }

        /* renamed from: i */
        private int m3341i(int i) {
            if (this.f4331b == null) {
                return -1;
            }
            FullSpanItem f = mo7548f(i);
            if (f != null) {
                this.f4331b.remove(f);
            }
            int size = this.f4331b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f4331b.get(i2).f4332a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f4331b.remove(i2);
            return this.f4331b.get(i2).f4332a;
        }

        /* renamed from: l */
        private void m3342l(int i, int i2) {
            List<FullSpanItem> list = this.f4331b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4331b.get(size);
                    int i3 = fullSpanItem.f4332a;
                    if (i3 >= i) {
                        fullSpanItem.f4332a = i3 + i2;
                    }
                }
            }
        }

        /* renamed from: m */
        private void m3343m(int i, int i2) {
            List<FullSpanItem> list = this.f4331b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4331b.get(size);
                    int i4 = fullSpanItem.f4332a;
                    if (i4 >= i) {
                        if (i4 < i3) {
                            this.f4331b.remove(size);
                        } else {
                            fullSpanItem.f4332a = i4 - i2;
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo7543a(FullSpanItem fullSpanItem) {
            if (this.f4331b == null) {
                this.f4331b = new ArrayList();
            }
            int size = this.f4331b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f4331b.get(i);
                if (fullSpanItem2.f4332a == fullSpanItem.f4332a) {
                    this.f4331b.remove(i);
                }
                if (fullSpanItem2.f4332a >= fullSpanItem.f4332a) {
                    this.f4331b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f4331b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7544b() {
            int[] iArr = this.f4330a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4331b = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo7545c(int i) {
            int[] iArr = this.f4330a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.f4330a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[mo7554o(i)];
                this.f4330a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f4330a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo7546d(int i) {
            List<FullSpanItem> list = this.f4331b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f4331b.get(size).f4332a >= i) {
                        this.f4331b.remove(size);
                    }
                }
            }
            return mo7550h(i);
        }

        /* renamed from: e */
        public FullSpanItem mo7547e(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f4331b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f4331b.get(i4);
                int i5 = fullSpanItem.f4332a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.f4333b == i3 || (z && fullSpanItem.f4335d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* renamed from: f */
        public FullSpanItem mo7548f(int i) {
            List<FullSpanItem> list = this.f4331b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4331b.get(size);
                if (fullSpanItem.f4332a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public int mo7549g(int i) {
            int[] iArr = this.f4330a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public int mo7550h(int i) {
            int[] iArr = this.f4330a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int i2 = m3341i(i);
            if (i2 == -1) {
                int[] iArr2 = this.f4330a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f4330a.length;
            }
            int i3 = i2 + 1;
            Arrays.fill(this.f4330a, i, i3, -1);
            return i3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo7551j(int i, int i2) {
            int[] iArr = this.f4330a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                mo7545c(i3);
                int[] iArr2 = this.f4330a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f4330a, i, i3, -1);
                m3342l(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo7552k(int i, int i2) {
            int[] iArr = this.f4330a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                mo7545c(i3);
                int[] iArr2 = this.f4330a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f4330a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                m3343m(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public void mo7553n(int i, C0928c cVar) {
            mo7545c(i);
            this.f4330a[i] = cVar.f4358e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public int mo7554o(int i) {
            int length = this.f4330a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new C0924a();

            /* renamed from: a */
            int f4332a;

            /* renamed from: b */
            int f4333b;

            /* renamed from: c */
            int[] f4334c;

            /* renamed from: d */
            boolean f4335d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$a */
            static class C0924a implements Parcelable.Creator<FullSpanItem> {
                C0924a() {
                }

                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f4332a = parcel.readInt();
                this.f4333b = parcel.readInt();
                this.f4335d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f4334c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public int mo7555a(int i) {
                int[] iArr = this.f4334c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4332a + ", mGapDir=" + this.f4333b + ", mHasUnwantedGapAfter=" + this.f4335d + ", mGapPerSpan=" + Arrays.toString(this.f4334c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f4332a);
                parcel.writeInt(this.f4333b);
                parcel.writeInt(this.f4335d ? 1 : 0);
                int[] iArr = this.f4334c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f4334c);
            }

            FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.f4324w = i2;
        setSpanCount(i);
        this.f4326y = new C0947f();
        m3297L();
    }
}
