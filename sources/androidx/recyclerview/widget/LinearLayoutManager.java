package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;

    /* renamed from: A */
    int f4042A;

    /* renamed from: B */
    int f4043B;

    /* renamed from: C */
    private boolean f4044C;

    /* renamed from: D */
    SavedState f4045D;

    /* renamed from: E */
    final C0902a f4046E;

    /* renamed from: F */
    private final LayoutChunkResult f4047F;

    /* renamed from: G */
    private int f4048G;

    /* renamed from: s */
    int f4049s;

    /* renamed from: t */
    private C0903b f4050t;

    /* renamed from: u */
    OrientationHelper f4051u;

    /* renamed from: v */
    private boolean f4052v;

    /* renamed from: w */
    private boolean f4053w;

    /* renamed from: x */
    boolean f4054x;

    /* renamed from: y */
    private boolean f4055y;

    /* renamed from: z */
    private boolean f4056z;

    protected static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6863a() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0901a();

        /* renamed from: a */
        int f4057a;

        /* renamed from: b */
        int f4058b;

        /* renamed from: c */
        boolean f4059c;

        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$SavedState$a */
        static class C0901a implements Parcelable.Creator<SavedState> {
            C0901a() {
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
        public boolean mo6864a() {
            return this.f4057a >= 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6865b() {
            this.f4057a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4057a);
            parcel.writeInt(this.f4058b);
            parcel.writeInt(this.f4059c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f4057a = parcel.readInt();
            this.f4058b = parcel.readInt();
            this.f4059c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f4057a = savedState.f4057a;
            this.f4058b = savedState.f4058b;
            this.f4059c = savedState.f4059c;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$a */
    static class C0902a {

        /* renamed from: a */
        OrientationHelper f4060a;

        /* renamed from: b */
        int f4061b;

        /* renamed from: c */
        int f4062c;

        /* renamed from: d */
        boolean f4063d;

        /* renamed from: e */
        boolean f4064e;

        C0902a() {
            mo6876e();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6872a() {
            int i;
            if (this.f4063d) {
                i = this.f4060a.getEndAfterPadding();
            } else {
                i = this.f4060a.getStartAfterPadding();
            }
            this.f4062c = i;
        }

        /* renamed from: b */
        public void mo6873b(View view, int i) {
            if (this.f4063d) {
                this.f4062c = this.f4060a.getDecoratedEnd(view) + this.f4060a.getTotalSpaceChange();
            } else {
                this.f4062c = this.f4060a.getDecoratedStart(view);
            }
            this.f4061b = i;
        }

        /* renamed from: c */
        public void mo6874c(View view, int i) {
            int totalSpaceChange = this.f4060a.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                mo6873b(view, i);
                return;
            }
            this.f4061b = i;
            if (this.f4063d) {
                int endAfterPadding = (this.f4060a.getEndAfterPadding() - totalSpaceChange) - this.f4060a.getDecoratedEnd(view);
                this.f4062c = this.f4060a.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.f4062c - this.f4060a.getDecoratedMeasurement(view);
                    int startAfterPadding = this.f4060a.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(this.f4060a.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.f4062c += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.f4060a.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.f4060a.getStartAfterPadding();
            this.f4062c = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.f4060a.getEndAfterPadding() - Math.min(0, (this.f4060a.getEndAfterPadding() - totalSpaceChange) - this.f4060a.getDecoratedEnd(view))) - (decoratedStart + this.f4060a.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.f4062c -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo6875d(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6876e() {
            this.f4061b = -1;
            this.f4062c = Integer.MIN_VALUE;
            this.f4063d = false;
            this.f4064e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f4061b + ", mCoordinate=" + this.f4062c + ", mLayoutFromEnd=" + this.f4063d + ", mValid=" + this.f4064e + '}';
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$b */
    static class C0903b {

        /* renamed from: a */
        boolean f4065a = true;

        /* renamed from: b */
        int f4066b;

        /* renamed from: c */
        int f4067c;

        /* renamed from: d */
        int f4068d;

        /* renamed from: e */
        int f4069e;

        /* renamed from: f */
        int f4070f;

        /* renamed from: g */
        int f4071g;

        /* renamed from: h */
        int f4072h = 0;

        /* renamed from: i */
        boolean f4073i;

        /* renamed from: j */
        int f4074j;

        /* renamed from: k */
        List<RecyclerView.ViewHolder> f4075k = null;

        /* renamed from: l */
        boolean f4076l;

        C0903b() {
        }

        /* renamed from: e */
        private View m2993e() {
            int size = this.f4075k.size();
            for (int i = 0; i < size; i++) {
                View view = this.f4075k.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.f4068d == layoutParams.getViewLayoutPosition()) {
                    mo6879b(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void mo6878a() {
            mo6879b((View) null);
        }

        /* renamed from: b */
        public void mo6879b(View view) {
            View f = mo6882f(view);
            if (f == null) {
                this.f4068d = -1;
            } else {
                this.f4068d = ((RecyclerView.LayoutParams) f.getLayoutParams()).getViewLayoutPosition();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo6880c(RecyclerView.State state) {
            int i = this.f4068d;
            return i >= 0 && i < state.getItemCount();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public View mo6881d(RecyclerView.Recycler recycler) {
            if (this.f4075k != null) {
                return m2993e();
            }
            View viewForPosition = recycler.getViewForPosition(this.f4068d);
            this.f4068d += this.f4069e;
            return viewForPosition;
        }

        /* renamed from: f */
        public View mo6882f(View view) {
            int viewLayoutPosition;
            int size = this.f4075k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f4075k.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.f4068d) * this.f4069e) >= 0 && viewLayoutPosition < i) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    /* renamed from: A */
    private int m2939A(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        mo6818D();
        OrientationHelper orientationHelper = this.f4051u;
        View I = m2943I(!this.f4056z, true);
        return C0957i.m3551c(state, orientationHelper, I, m2942H(!this.f4056z, true), this, this.f4056z);
    }

    /* renamed from: F */
    private View m2940F(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo6820L(0, getChildCount());
    }

    /* renamed from: G */
    private View m2941G(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo6704P(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    /* renamed from: H */
    private View m2942H(boolean z, boolean z2) {
        if (this.f4054x) {
            return mo6821M(0, getChildCount(), z, z2);
        }
        return mo6821M(getChildCount() - 1, -1, z, z2);
    }

    /* renamed from: I */
    private View m2943I(boolean z, boolean z2) {
        if (this.f4054x) {
            return mo6821M(getChildCount() - 1, -1, z, z2);
        }
        return mo6821M(0, getChildCount(), z, z2);
    }

    /* renamed from: J */
    private View m2944J(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo6820L(getChildCount() - 1, -1);
    }

    /* renamed from: K */
    private View m2945K(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo6704P(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    /* renamed from: N */
    private View m2946N(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4054x) {
            return m2940F(recycler, state);
        }
        return m2944J(recycler, state);
    }

    /* renamed from: O */
    private View m2947O(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4054x) {
            return m2944J(recycler, state);
        }
        return m2940F(recycler, state);
    }

    /* renamed from: Q */
    private View m2948Q(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4054x) {
            return m2941G(recycler, state);
        }
        return m2945K(recycler, state);
    }

    /* renamed from: R */
    private View m2949R(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4054x) {
            return m2945K(recycler, state);
        }
        return m2941G(recycler, state);
    }

    /* renamed from: S */
    private int m2950S(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.f4051u.getEndAfterPadding() - i;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -mo6835f0(-endAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (endAfterPadding = this.f4051u.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.f4051u.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    /* renamed from: T */
    private int m2951T(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.f4051u.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -mo6835f0(startAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (startAfterPadding = i3 - this.f4051u.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.f4051u.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    /* renamed from: U */
    private View m2952U() {
        return getChildAt(this.f4054x ? 0 : getChildCount() - 1);
    }

    /* renamed from: V */
    private View m2953V() {
        return getChildAt(this.f4054x ? getChildCount() - 1 : 0);
    }

    /* renamed from: X */
    private void m2954X(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i5);
                if (!viewHolder.mo7406o()) {
                    char c = 1;
                    if ((viewHolder.getLayoutPosition() < position) != this.f4054x) {
                        c = 65535;
                    }
                    if (c == 65535) {
                        i3 += this.f4051u.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        i4 += this.f4051u.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
            }
            this.f4050t.f4075k = scrapList;
            if (i3 > 0) {
                m2966m0(getPosition(m2953V()), i);
                C0903b bVar = this.f4050t;
                bVar.f4072h = i3;
                bVar.f4067c = 0;
                bVar.mo6878a();
                mo6819E(recycler2, this.f4050t, state2, false);
            }
            if (i4 > 0) {
                m2964k0(getPosition(m2952U()), i2);
                C0903b bVar2 = this.f4050t;
                bVar2.f4072h = i4;
                bVar2.f4067c = 0;
                bVar2.mo6878a();
                mo6819E(recycler2, this.f4050t, state2, false);
            }
            this.f4050t.f4075k = null;
        }
    }

    /* renamed from: Z */
    private void m2955Z(RecyclerView.Recycler recycler, C0903b bVar) {
        if (bVar.f4065a && !bVar.f4076l) {
            if (bVar.f4070f == -1) {
                m2957b0(recycler, bVar.f4071g);
            } else {
                m2958c0(recycler, bVar.f4071g);
            }
        }
    }

    /* renamed from: a0 */
    private void m2956a0(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    /* renamed from: b0 */
    private void m2957b0(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.f4051u.getEnd() - i;
            if (this.f4054x) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (this.f4051u.getDecoratedStart(childAt) < end || this.f4051u.getTransformedStartWithDecoration(childAt) < end) {
                        m2956a0(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = childCount - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View childAt2 = getChildAt(i4);
                if (this.f4051u.getDecoratedStart(childAt2) < end || this.f4051u.getTransformedStartWithDecoration(childAt2) < end) {
                    m2956a0(recycler, i3, i4);
                    return;
                }
            }
        }
    }

    /* renamed from: c0 */
    private void m2958c0(RecyclerView.Recycler recycler, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            if (this.f4054x) {
                int i2 = childCount - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    View childAt = getChildAt(i3);
                    if (this.f4051u.getDecoratedEnd(childAt) > i || this.f4051u.getTransformedEndWithDecoration(childAt) > i) {
                        m2956a0(recycler, i2, i3);
                        return;
                    }
                }
                return;
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (this.f4051u.getDecoratedEnd(childAt2) > i || this.f4051u.getTransformedEndWithDecoration(childAt2) > i) {
                    m2956a0(recycler, 0, i4);
                    return;
                }
            }
        }
    }

    /* renamed from: e0 */
    private void m2959e0() {
        if (this.f4049s == 1 || !isLayoutRTL()) {
            this.f4054x = this.f4053w;
        } else {
            this.f4054x = !this.f4053w;
        }
    }

    /* renamed from: g0 */
    private boolean m2960g0(RecyclerView.Recycler recycler, RecyclerView.State state, C0902a aVar) {
        View view;
        int i;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.mo6875d(focusedChild, state)) {
            aVar.mo6874c(focusedChild, getPosition(focusedChild));
            return true;
        } else if (this.f4052v != this.f4055y) {
            return false;
        } else {
            if (aVar.f4063d) {
                view = m2948Q(recycler, state);
            } else {
                view = m2949R(recycler, state);
            }
            if (view == null) {
                return false;
            }
            aVar.mo6873b(view, getPosition(view));
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.f4051u.getDecoratedStart(view) >= this.f4051u.getEndAfterPadding() || this.f4051u.getDecoratedEnd(view) < this.f4051u.getStartAfterPadding()) {
                    z = true;
                }
                if (z) {
                    if (aVar.f4063d) {
                        i = this.f4051u.getEndAfterPadding();
                    } else {
                        i = this.f4051u.getStartAfterPadding();
                    }
                    aVar.f4062c = i;
                }
            }
            return true;
        }
    }

    /* renamed from: h0 */
    private boolean m2961h0(RecyclerView.State state, C0902a aVar) {
        int i;
        int i2;
        boolean z = false;
        if (!state.isPreLayout() && (i = this.f4042A) != -1) {
            if (i < 0 || i >= state.getItemCount()) {
                this.f4042A = -1;
                this.f4043B = Integer.MIN_VALUE;
            } else {
                aVar.f4061b = this.f4042A;
                SavedState savedState = this.f4045D;
                if (savedState != null && savedState.mo6864a()) {
                    boolean z2 = this.f4045D.f4059c;
                    aVar.f4063d = z2;
                    if (z2) {
                        aVar.f4062c = this.f4051u.getEndAfterPadding() - this.f4045D.f4058b;
                    } else {
                        aVar.f4062c = this.f4051u.getStartAfterPadding() + this.f4045D.f4058b;
                    }
                    return true;
                } else if (this.f4043B == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.f4042A);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if ((this.f4042A < getPosition(getChildAt(0))) == this.f4054x) {
                                z = true;
                            }
                            aVar.f4063d = z;
                        }
                        aVar.mo6872a();
                    } else if (this.f4051u.getDecoratedMeasurement(findViewByPosition) > this.f4051u.getTotalSpace()) {
                        aVar.mo6872a();
                        return true;
                    } else if (this.f4051u.getDecoratedStart(findViewByPosition) - this.f4051u.getStartAfterPadding() < 0) {
                        aVar.f4062c = this.f4051u.getStartAfterPadding();
                        aVar.f4063d = false;
                        return true;
                    } else if (this.f4051u.getEndAfterPadding() - this.f4051u.getDecoratedEnd(findViewByPosition) < 0) {
                        aVar.f4062c = this.f4051u.getEndAfterPadding();
                        aVar.f4063d = true;
                        return true;
                    } else {
                        if (aVar.f4063d) {
                            i2 = this.f4051u.getDecoratedEnd(findViewByPosition) + this.f4051u.getTotalSpaceChange();
                        } else {
                            i2 = this.f4051u.getDecoratedStart(findViewByPosition);
                        }
                        aVar.f4062c = i2;
                    }
                    return true;
                } else {
                    boolean z3 = this.f4054x;
                    aVar.f4063d = z3;
                    if (z3) {
                        aVar.f4062c = this.f4051u.getEndAfterPadding() - this.f4043B;
                    } else {
                        aVar.f4062c = this.f4051u.getStartAfterPadding() + this.f4043B;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: i0 */
    private void m2962i0(RecyclerView.Recycler recycler, RecyclerView.State state, C0902a aVar) {
        if (!m2961h0(state, aVar) && !m2960g0(recycler, state, aVar)) {
            aVar.mo6872a();
            aVar.f4061b = this.f4055y ? state.getItemCount() - 1 : 0;
        }
    }

    /* renamed from: j0 */
    private void m2963j0(int i, int i2, boolean z, RecyclerView.State state) {
        int i3;
        this.f4050t.f4076l = mo6834d0();
        this.f4050t.f4072h = getExtraLayoutSpace(state);
        C0903b bVar = this.f4050t;
        bVar.f4070f = i;
        int i4 = -1;
        if (i == 1) {
            bVar.f4072h += this.f4051u.getEndPadding();
            View U = m2952U();
            C0903b bVar2 = this.f4050t;
            if (!this.f4054x) {
                i4 = 1;
            }
            bVar2.f4069e = i4;
            int position = getPosition(U);
            C0903b bVar3 = this.f4050t;
            bVar2.f4068d = position + bVar3.f4069e;
            bVar3.f4066b = this.f4051u.getDecoratedEnd(U);
            i3 = this.f4051u.getDecoratedEnd(U) - this.f4051u.getEndAfterPadding();
        } else {
            View V = m2953V();
            this.f4050t.f4072h += this.f4051u.getStartAfterPadding();
            C0903b bVar4 = this.f4050t;
            if (this.f4054x) {
                i4 = 1;
            }
            bVar4.f4069e = i4;
            int position2 = getPosition(V);
            C0903b bVar5 = this.f4050t;
            bVar4.f4068d = position2 + bVar5.f4069e;
            bVar5.f4066b = this.f4051u.getDecoratedStart(V);
            i3 = (-this.f4051u.getDecoratedStart(V)) + this.f4051u.getStartAfterPadding();
        }
        C0903b bVar6 = this.f4050t;
        bVar6.f4067c = i2;
        if (z) {
            bVar6.f4067c = i2 - i3;
        }
        bVar6.f4071g = i3;
    }

    /* renamed from: k0 */
    private void m2964k0(int i, int i2) {
        this.f4050t.f4067c = this.f4051u.getEndAfterPadding() - i2;
        C0903b bVar = this.f4050t;
        bVar.f4069e = this.f4054x ? -1 : 1;
        bVar.f4068d = i;
        bVar.f4070f = 1;
        bVar.f4066b = i2;
        bVar.f4071g = Integer.MIN_VALUE;
    }

    /* renamed from: l0 */
    private void m2965l0(C0902a aVar) {
        m2964k0(aVar.f4061b, aVar.f4062c);
    }

    /* renamed from: m0 */
    private void m2966m0(int i, int i2) {
        this.f4050t.f4067c = i2 - this.f4051u.getStartAfterPadding();
        C0903b bVar = this.f4050t;
        bVar.f4068d = i;
        bVar.f4069e = this.f4054x ? 1 : -1;
        bVar.f4070f = -1;
        bVar.f4066b = i2;
        bVar.f4071g = Integer.MIN_VALUE;
    }

    /* renamed from: n0 */
    private void m2967n0(C0902a aVar) {
        m2966m0(aVar.f4061b, aVar.f4062c);
    }

    /* renamed from: y */
    private int m2968y(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        mo6818D();
        OrientationHelper orientationHelper = this.f4051u;
        View I = m2943I(!this.f4056z, true);
        return C0957i.m3549a(state, orientationHelper, I, m2942H(!this.f4056z, true), this, this.f4056z);
    }

    /* renamed from: z */
    private int m2969z(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        mo6818D();
        OrientationHelper orientationHelper = this.f4051u;
        View I = m2943I(!this.f4056z, true);
        return C0957i.m3550b(state, orientationHelper, I, m2942H(!this.f4056z, true), this, this.f4056z, this.f4054x);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public int mo6816B(int i) {
        if (i == 1) {
            return (this.f4049s != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.f4049s != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.f4049s == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.f4049s == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.f4049s == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.f4049s == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public C0903b mo6817C() {
        return new C0903b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public void mo6818D() {
        if (this.f4050t == null) {
            this.f4050t = mo6817C();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public int mo6819E(RecyclerView.Recycler recycler, C0903b bVar, RecyclerView.State state, boolean z) {
        int i = bVar.f4067c;
        int i2 = bVar.f4071g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                bVar.f4071g = i2 + i;
            }
            m2955Z(recycler, bVar);
        }
        int i3 = bVar.f4067c + bVar.f4072h;
        LayoutChunkResult layoutChunkResult = this.f4047F;
        while (true) {
            if ((!bVar.f4076l && i3 <= 0) || !bVar.mo6880c(state)) {
                break;
            }
            layoutChunkResult.mo6863a();
            mo6705W(recycler, state, bVar, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                bVar.f4066b += layoutChunkResult.mConsumed * bVar.f4070f;
                if (!layoutChunkResult.mIgnoreConsumed || this.f4050t.f4075k != null || !state.isPreLayout()) {
                    int i4 = bVar.f4067c;
                    int i5 = layoutChunkResult.mConsumed;
                    bVar.f4067c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = bVar.f4071g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + layoutChunkResult.mConsumed;
                    bVar.f4071g = i7;
                    int i8 = bVar.f4067c;
                    if (i8 < 0) {
                        bVar.f4071g = i7 + i8;
                    }
                    m2955Z(recycler, bVar);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - bVar.f4067c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public View mo6820L(int i, int i2) {
        int i3;
        int i4;
        mo6818D();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return getChildAt(i);
        }
        if (this.f4051u.getDecoratedStart(getChildAt(i)) < this.f4051u.getStartAfterPadding()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.f4049s == 0) {
            return this.f4182e.mo7613a(i, i2, i4, i3);
        }
        return this.f4183f.mo7613a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public View mo6821M(int i, int i2, boolean z, boolean z2) {
        mo6818D();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        if (this.f4049s == 0) {
            return this.f4182e.mo7613a(i, i2, i4, i3);
        }
        return this.f4183f.mo7613a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P */
    public View mo6704P(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        mo6818D();
        int startAfterPadding = this.f4051u.getStartAfterPadding();
        int endAfterPadding = this.f4051u.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.f4051u.getDecoratedStart(childAt) < endAfterPadding && this.f4051u.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: W */
    public void mo6705W(RecyclerView.Recycler recycler, RecyclerView.State state, C0903b bVar, LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View d = bVar.mo6881d(recycler);
        if (d == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) d.getLayoutParams();
        if (bVar.f4075k == null) {
            if (this.f4054x == (bVar.f4070f == -1)) {
                addView(d);
            } else {
                addView(d, 0);
            }
        } else {
            if (this.f4054x == (bVar.f4070f == -1)) {
                addDisappearingView(d);
            } else {
                addDisappearingView(d, 0);
            }
        }
        measureChildWithMargins(d, 0, 0);
        layoutChunkResult.mConsumed = this.f4051u.getDecoratedMeasurement(d);
        if (this.f4049s == 1) {
            if (isLayoutRTL()) {
                i5 = getWidth() - getPaddingRight();
                i4 = i5 - this.f4051u.getDecoratedMeasurementInOther(d);
            } else {
                i4 = getPaddingLeft();
                i5 = this.f4051u.getDecoratedMeasurementInOther(d) + i4;
            }
            if (bVar.f4070f == -1) {
                int i6 = bVar.f4066b;
                i = i6;
                i2 = i5;
                i3 = i6 - layoutChunkResult.mConsumed;
            } else {
                int i7 = bVar.f4066b;
                i3 = i7;
                i2 = i5;
                i = layoutChunkResult.mConsumed + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther = this.f4051u.getDecoratedMeasurementInOther(d) + paddingTop;
            if (bVar.f4070f == -1) {
                int i8 = bVar.f4066b;
                i2 = i8;
                i3 = paddingTop;
                i = decoratedMeasurementInOther;
                i4 = i8 - layoutChunkResult.mConsumed;
            } else {
                int i9 = bVar.f4066b;
                i3 = paddingTop;
                i2 = layoutChunkResult.mConsumed + i9;
                i = decoratedMeasurementInOther;
                i4 = i9;
            }
        }
        layoutDecoratedWithMargins(d, i4, i3, i2, i);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = d.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y */
    public void mo6706Y(RecyclerView.Recycler recycler, RecyclerView.State state, C0902a aVar, int i) {
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f4045D == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean canScrollHorizontally() {
        return this.f4049s == 0;
    }

    public boolean canScrollVertically() {
        return this.f4049s == 1;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.f4049s != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            mo6818D();
            m2963j0(i > 0 ? 1 : -1, Math.abs(i), true, state);
            mo6732x(state, this.f4050t, layoutPrefetchRegistry);
        }
    }

    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        SavedState savedState = this.f4045D;
        int i3 = -1;
        if (savedState == null || !savedState.mo6864a()) {
            m2959e0();
            z = this.f4054x;
            i2 = this.f4042A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.f4045D;
            z = savedState2.f4059c;
            i2 = savedState2.f4057a;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.f4048G && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.addPosition(i2, 0);
            i2 += i3;
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return m2968y(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return m2969z(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return m2939A(state);
    }

    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.f4054x) {
            i2 = -1;
        }
        if (this.f4049s == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return m2968y(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return m2969z(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return m2939A(state);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d0 */
    public boolean mo6834d0() {
        return this.f4051u.getMode() == 0 && this.f4051u.getEnd() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f0 */
    public int mo6835f0(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.f4050t.f4065a = true;
        mo6818D();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m2963j0(i2, abs, true, state);
        C0903b bVar = this.f4050t;
        int E = bVar.f4071g + mo6819E(recycler, bVar, state, false);
        if (E < 0) {
            return 0;
        }
        if (abs > E) {
            i = i2 * E;
        }
        this.f4051u.offsetChildren(-i);
        this.f4050t.f4074j = i;
        return i;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View M = mo6821M(0, getChildCount(), true, false);
        if (M == null) {
            return -1;
        }
        return getPosition(M);
    }

    public int findFirstVisibleItemPosition() {
        View M = mo6821M(0, getChildCount(), false, true);
        if (M == null) {
            return -1;
        }
        return getPosition(M);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View M = mo6821M(getChildCount() - 1, -1, true, false);
        if (M == null) {
            return -1;
        }
        return getPosition(M);
    }

    public int findLastVisibleItemPosition() {
        View M = mo6821M(getChildCount() - 1, -1, false, true);
        if (M == null) {
            return -1;
        }
        return getPosition(M);
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.f4051u.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.f4048G;
    }

    public int getOrientation() {
        return this.f4049s;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.f4044C;
    }

    public boolean getReverseLayout() {
        return this.f4053w;
    }

    public boolean getStackFromEnd() {
        return this.f4055y;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.f4056z;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f4044C) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int B;
        View view2;
        View view3;
        m2959e0();
        if (getChildCount() == 0 || (B = mo6816B(i)) == Integer.MIN_VALUE) {
            return null;
        }
        mo6818D();
        mo6818D();
        m2963j0(B, (int) (((float) this.f4051u.getTotalSpace()) * 0.33333334f), false, state);
        C0903b bVar = this.f4050t;
        bVar.f4071g = Integer.MIN_VALUE;
        bVar.f4065a = false;
        mo6819E(recycler, bVar, state, true);
        if (B == -1) {
            view2 = m2947O(recycler, state);
        } else {
            view2 = m2946N(recycler, state);
        }
        if (B == -1) {
            view3 = m2953V();
        } else {
            view3 = m2952U();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View findViewByPosition;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.f4045D == null && this.f4042A == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.f4045D;
        if (savedState != null && savedState.mo6864a()) {
            this.f4042A = this.f4045D.f4057a;
        }
        mo6818D();
        this.f4050t.f4065a = false;
        m2959e0();
        View focusedChild = getFocusedChild();
        C0902a aVar = this.f4046E;
        if (!aVar.f4064e || this.f4042A != -1 || this.f4045D != null) {
            aVar.mo6876e();
            C0902a aVar2 = this.f4046E;
            aVar2.f4063d = this.f4054x ^ this.f4055y;
            m2962i0(recycler, state, aVar2);
            this.f4046E.f4064e = true;
        } else if (focusedChild != null && (this.f4051u.getDecoratedStart(focusedChild) >= this.f4051u.getEndAfterPadding() || this.f4051u.getDecoratedEnd(focusedChild) <= this.f4051u.getStartAfterPadding())) {
            this.f4046E.mo6874c(focusedChild, getPosition(focusedChild));
        }
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.f4050t.f4074j >= 0) {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        } else {
            i = 0;
        }
        int startAfterPadding = extraLayoutSpace + this.f4051u.getStartAfterPadding();
        int endPadding = i + this.f4051u.getEndPadding();
        if (!(!state.isPreLayout() || (i7 = this.f4042A) == -1 || this.f4043B == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i7)) == null)) {
            if (this.f4054x) {
                i8 = this.f4051u.getEndAfterPadding() - this.f4051u.getDecoratedEnd(findViewByPosition);
                i9 = this.f4043B;
            } else {
                i9 = this.f4051u.getDecoratedStart(findViewByPosition) - this.f4051u.getStartAfterPadding();
                i8 = this.f4043B;
            }
            int i11 = i8 - i9;
            if (i11 > 0) {
                startAfterPadding += i11;
            } else {
                endPadding -= i11;
            }
        }
        C0902a aVar3 = this.f4046E;
        if (!aVar3.f4063d ? !this.f4054x : this.f4054x) {
            i10 = 1;
        }
        mo6706Y(recycler, state, aVar3, i10);
        detachAndScrapAttachedViews(recycler);
        this.f4050t.f4076l = mo6834d0();
        this.f4050t.f4073i = state.isPreLayout();
        C0902a aVar4 = this.f4046E;
        if (aVar4.f4063d) {
            m2967n0(aVar4);
            C0903b bVar = this.f4050t;
            bVar.f4072h = startAfterPadding;
            mo6819E(recycler, bVar, state, false);
            C0903b bVar2 = this.f4050t;
            i3 = bVar2.f4066b;
            int i12 = bVar2.f4068d;
            int i13 = bVar2.f4067c;
            if (i13 > 0) {
                endPadding += i13;
            }
            m2965l0(this.f4046E);
            C0903b bVar3 = this.f4050t;
            bVar3.f4072h = endPadding;
            bVar3.f4068d += bVar3.f4069e;
            mo6819E(recycler, bVar3, state, false);
            C0903b bVar4 = this.f4050t;
            i2 = bVar4.f4066b;
            int i14 = bVar4.f4067c;
            if (i14 > 0) {
                m2966m0(i12, i3);
                C0903b bVar5 = this.f4050t;
                bVar5.f4072h = i14;
                mo6819E(recycler, bVar5, state, false);
                i3 = this.f4050t.f4066b;
            }
        } else {
            m2965l0(aVar4);
            C0903b bVar6 = this.f4050t;
            bVar6.f4072h = endPadding;
            mo6819E(recycler, bVar6, state, false);
            C0903b bVar7 = this.f4050t;
            i2 = bVar7.f4066b;
            int i15 = bVar7.f4068d;
            int i16 = bVar7.f4067c;
            if (i16 > 0) {
                startAfterPadding += i16;
            }
            m2967n0(this.f4046E);
            C0903b bVar8 = this.f4050t;
            bVar8.f4072h = startAfterPadding;
            bVar8.f4068d += bVar8.f4069e;
            mo6819E(recycler, bVar8, state, false);
            C0903b bVar9 = this.f4050t;
            i3 = bVar9.f4066b;
            int i17 = bVar9.f4067c;
            if (i17 > 0) {
                m2964k0(i15, i2);
                C0903b bVar10 = this.f4050t;
                bVar10.f4072h = i17;
                mo6819E(recycler, bVar10, state, false);
                i2 = this.f4050t.f4066b;
            }
        }
        if (getChildCount() > 0) {
            if (this.f4054x ^ this.f4055y) {
                int S = m2950S(i2, recycler, state, true);
                i5 = i3 + S;
                i4 = i2 + S;
                i6 = m2951T(i5, recycler, state, false);
            } else {
                int T = m2951T(i3, recycler, state, true);
                i5 = i3 + T;
                i4 = i2 + T;
                i6 = m2950S(i4, recycler, state, false);
            }
            i3 = i5 + i6;
            i2 = i4 + i6;
        }
        m2954X(recycler, state, i3, i2);
        if (!state.isPreLayout()) {
            this.f4051u.onLayoutComplete();
        } else {
            this.f4046E.mo6876e();
        }
        this.f4052v = this.f4055y;
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f4045D = null;
        this.f4042A = -1;
        this.f4043B = Integer.MIN_VALUE;
        this.f4046E.mo6876e();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f4045D = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.f4045D != null) {
            return new SavedState(this.f4045D);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            mo6818D();
            boolean z = this.f4052v ^ this.f4054x;
            savedState.f4059c = z;
            if (z) {
                View U = m2952U();
                savedState.f4058b = this.f4051u.getEndAfterPadding() - this.f4051u.getDecoratedEnd(U);
                savedState.f4057a = getPosition(U);
            } else {
                View V = m2953V();
                savedState.f4057a = getPosition(V);
                savedState.f4058b = this.f4051u.getDecoratedStart(V) - this.f4051u.getStartAfterPadding();
            }
        } else {
            savedState.mo6865b();
        }
        return savedState;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        mo6818D();
        m2959e0();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : 65535;
        if (this.f4054x) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.f4051u.getEndAfterPadding() - (this.f4051u.getDecoratedStart(view2) + this.f4051u.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.f4051u.getEndAfterPadding() - this.f4051u.getDecoratedEnd(view2));
            }
        } else if (c == 65535) {
            scrollToPositionWithOffset(position2, this.f4051u.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.f4051u.getDecoratedEnd(view2) - this.f4051u.getDecoratedMeasurement(view));
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4049s == 1) {
            return 0;
        }
        return mo6835f0(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        this.f4042A = i;
        this.f4043B = Integer.MIN_VALUE;
        SavedState savedState = this.f4045D;
        if (savedState != null) {
            savedState.mo6865b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.f4042A = i;
        this.f4043B = i2;
        SavedState savedState = this.f4045D;
        if (savedState != null) {
            savedState.mo6865b();
        }
        requestLayout();
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4049s == 0) {
            return 0;
        }
        return mo6835f0(i, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.f4048G = i;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.f4049s || this.f4051u == null) {
                OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i);
                this.f4051u = createOrientationHelper;
                this.f4046E.f4060a = createOrientationHelper;
                this.f4049s = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.f4044C = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.f4053w) {
            this.f4053w = z;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.f4056z = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (this.f4055y != z) {
            this.f4055y = z;
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f4045D == null && this.f4052v == this.f4055y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean mo6862u() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !mo7166f()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo6732x(RecyclerView.State state, C0903b bVar, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = bVar.f4068d;
        if (i >= 0 && i < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i, Math.max(0, bVar.f4071g));
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f4049s = 1;
        this.f4053w = false;
        this.f4054x = false;
        this.f4055y = false;
        this.f4056z = true;
        this.f4042A = -1;
        this.f4043B = Integer.MIN_VALUE;
        this.f4045D = null;
        this.f4046E = new C0902a();
        this.f4047F = new LayoutChunkResult();
        this.f4048G = 2;
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f4049s = 1;
        this.f4053w = false;
        this.f4054x = false;
        this.f4055y = false;
        this.f4056z = true;
        this.f4042A = -1;
        this.f4043B = Integer.MIN_VALUE;
        this.f4045D = null;
        this.f4046E = new C0902a();
        this.f4047F = new LayoutChunkResult();
        this.f4048G = 2;
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
