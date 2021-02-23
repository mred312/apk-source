package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    public static final int DEFAULT_SPAN_COUNT = -1;

    /* renamed from: H */
    boolean f3969H = false;

    /* renamed from: I */
    int f3970I = -1;

    /* renamed from: J */
    int[] f3971J;

    /* renamed from: K */
    View[] f3972K;

    /* renamed from: L */
    final SparseIntArray f3973L = new SparseIntArray();

    /* renamed from: M */
    final SparseIntArray f3974M = new SparseIntArray();

    /* renamed from: N */
    SpanSizeLookup f3975N = new DefaultSpanSizeLookup();

    /* renamed from: O */
    final Rect f3976O = new Rect();

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        public int getSpanSize(int i) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {

        /* renamed from: a */
        final SparseIntArray f3979a = new SparseIntArray();

        /* renamed from: b */
        private boolean f3980b = false;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo6737a(int i) {
            int size = this.f3979a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f3979a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f3979a.size()) {
                return -1;
            }
            return this.f3979a.keyAt(i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo6738b(int i, int i2) {
            if (!this.f3980b) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.f3979a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.f3979a.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int spanSize2 = getSpanSize(i5);
                i3 += spanSize2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = spanSize2;
                }
            }
            return i3 + spanSize > i2 ? i4 + 1 : i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f3980b
                if (r2 == 0) goto L_0x0026
                android.util.SparseIntArray r2 = r5.f3979a
                int r2 = r2.size()
                if (r2 <= 0) goto L_0x0026
                int r2 = r5.mo6737a(r6)
                if (r2 < 0) goto L_0x0026
                android.util.SparseIntArray r3 = r5.f3979a
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0036
            L_0x0026:
                r2 = 0
                r3 = 0
            L_0x0028:
                if (r2 >= r6) goto L_0x0039
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x0033
                r3 = 0
                goto L_0x0036
            L_0x0033:
                if (r3 <= r7) goto L_0x0036
                r3 = r4
            L_0x0036:
                int r2 = r2 + 1
                goto L_0x0028
            L_0x0039:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x003d
                return r3
            L_0x003d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanIndexCache() {
            this.f3979a.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.f3980b;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            this.f3980b = z;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    /* renamed from: A0 */
    private void m2881A0(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f4199b;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int v0 = mo6731v0(layoutParams.f3977e, layoutParams.f3978f);
        if (this.f4049s == 1) {
            i2 = RecyclerView.LayoutManager.getChildMeasureSpec(v0, i, i5, layoutParams.width, false);
            i3 = RecyclerView.LayoutManager.getChildMeasureSpec(this.f4051u.getTotalSpace(), getHeightMode(), i4, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(v0, i, i4, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.f4051u.getTotalSpace(), getWidthMode(), i5, layoutParams.width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        m2882B0(view, i2, i3, z);
    }

    /* renamed from: B0 */
    private void m2882B0(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = mo7262v(view, i, i2, layoutParams);
        } else {
            z2 = mo7261t(view, i, i2, layoutParams);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    /* renamed from: C0 */
    private void m2883C0() {
        int i;
        int i2;
        if (getOrientation() == 1) {
            i2 = getWidth() - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = getHeight() - getPaddingBottom();
            i = getPaddingTop();
        }
        m2886q0(i2 - i);
    }

    /* renamed from: o0 */
    private void m2884o0(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
        }
        while (i4 != i6) {
            View view = this.f3972K[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int y0 = m2893y0(recycler, state, getPosition(view));
            layoutParams.f3978f = y0;
            layoutParams.f3977e = i5;
            i5 += y0;
            i4 += i3;
        }
    }

    /* renamed from: p0 */
    private void m2885p0() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.f3973L.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.f3974M.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    /* renamed from: q0 */
    private void m2886q0(int i) {
        this.f3971J = m2887r0(this.f3971J, this.f3970I, i);
    }

    /* renamed from: r0 */
    static int[] m2887r0(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* renamed from: s0 */
    private void m2888s0() {
        this.f3973L.clear();
        this.f3974M.clear();
    }

    /* renamed from: t0 */
    private void m2889t0(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.C0902a aVar, int i) {
        boolean z = i == 1;
        int x0 = m2892x0(recycler, state, aVar.f4061b);
        if (z) {
            while (x0 > 0) {
                int i2 = aVar.f4061b;
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    aVar.f4061b = i3;
                    x0 = m2892x0(recycler, state, i3);
                } else {
                    return;
                }
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i4 = aVar.f4061b;
        while (i4 < itemCount) {
            int i5 = i4 + 1;
            int x02 = m2892x0(recycler, state, i5);
            if (x02 <= x0) {
                break;
            }
            i4 = i5;
            x0 = x02;
        }
        aVar.f4061b = i4;
    }

    /* renamed from: u0 */
    private void m2890u0() {
        View[] viewArr = this.f3972K;
        if (viewArr == null || viewArr.length != this.f3970I) {
            this.f3972K = new View[this.f3970I];
        }
    }

    /* renamed from: w0 */
    private int m2891w0(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.f3975N.getSpanGroupIndex(i, this.f3970I);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.f3975N.getSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.f3970I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* renamed from: x0 */
    private int m2892x0(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.f3975N.mo6738b(i, this.f3970I);
        }
        int i2 = this.f3974M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.f3975N.mo6738b(convertPreLayoutPositionToPostLayout, this.f3970I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    /* renamed from: y0 */
    private int m2893y0(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.f3975N.getSpanSize(i);
        }
        int i2 = this.f3973L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.f3975N.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    /* renamed from: z0 */
    private void m2894z0(float f, int i) {
        m2886q0(Math.max(Math.round(f * ((float) this.f3970I)), i));
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
            if (position >= 0 && position < i3 && m2892x0(recycler, state, position) == 0) {
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
    public void mo6705W(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.C0903b bVar, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        View d;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.C0903b bVar2 = bVar;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int modeInOther = this.f4051u.getModeInOther();
        boolean z2 = modeInOther != 1073741824;
        int i11 = getChildCount() > 0 ? this.f3971J[this.f3970I] : 0;
        if (z2) {
            m2883C0();
        }
        boolean z3 = bVar2.f4069e == 1;
        int i12 = this.f3970I;
        if (!z3) {
            i12 = m2892x0(recycler2, state2, bVar2.f4068d) + m2893y0(recycler2, state2, bVar2.f4068d);
        }
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.f3970I && bVar2.mo6880c(state2) && i12 > 0) {
            int i15 = bVar2.f4068d;
            int y0 = m2893y0(recycler2, state2, i15);
            if (y0 <= this.f3970I) {
                i12 -= y0;
                if (i12 < 0 || (d = bVar2.mo6881d(recycler2)) == null) {
                    break;
                }
                i13 += y0;
                this.f3972K[i14] = d;
                i14++;
            } else {
                throw new IllegalArgumentException("Item at position " + i15 + " requires " + y0 + " spans but GridLayoutManager has only " + this.f3970I + " spans.");
            }
        }
        if (i14 == 0) {
            layoutChunkResult2.mFinished = true;
            return;
        }
        float f = 0.0f;
        int i16 = i14;
        m2884o0(recycler, state, i14, i13, z3);
        int i17 = 0;
        for (int i18 = 0; i18 < i16; i18++) {
            View view = this.f3972K[i18];
            if (bVar2.f4075k != null) {
                z = false;
                if (z3) {
                    addDisappearingView(view);
                } else {
                    addDisappearingView(view, 0);
                }
            } else if (z3) {
                addView(view);
                z = false;
            } else {
                z = false;
                addView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.f3976O);
            m2881A0(view, modeInOther, z);
            int decoratedMeasurement = this.f4051u.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i17) {
                i17 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.f4051u.getDecoratedMeasurementInOther(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).f3978f);
            if (decoratedMeasurementInOther > f) {
                f = decoratedMeasurementInOther;
            }
        }
        if (z2) {
            m2894z0(f, i11);
            i17 = 0;
            for (int i19 = 0; i19 < i16; i19++) {
                View view2 = this.f3972K[i19];
                m2881A0(view2, 1073741824, true);
                int decoratedMeasurement2 = this.f4051u.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i17) {
                    i17 = decoratedMeasurement2;
                }
            }
        }
        for (int i20 = 0; i20 < i16; i20++) {
            View view3 = this.f3972K[i20];
            if (this.f4051u.getDecoratedMeasurement(view3) != i17) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f4199b;
                int i21 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i22 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int v0 = mo6731v0(layoutParams.f3977e, layoutParams.f3978f);
                if (this.f4049s == 1) {
                    i10 = RecyclerView.LayoutManager.getChildMeasureSpec(v0, 1073741824, i22, layoutParams.width, false);
                    i9 = View.MeasureSpec.makeMeasureSpec(i17 - i21, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - i22, 1073741824);
                    i9 = RecyclerView.LayoutManager.getChildMeasureSpec(v0, 1073741824, i21, layoutParams.height, false);
                    i10 = makeMeasureSpec;
                }
                m2882B0(view3, i10, i9, true);
            }
        }
        int i23 = 0;
        layoutChunkResult2.mConsumed = i17;
        if (this.f4049s != 1) {
            if (bVar2.f4070f == -1) {
                int i24 = bVar2.f4066b;
                i3 = i24 - i17;
                i2 = i24;
            } else {
                int i25 = bVar2.f4066b;
                i2 = i25 + i17;
                i3 = i25;
            }
            i4 = 0;
            i = 0;
        } else if (bVar2.f4070f == -1) {
            int i26 = bVar2.f4066b;
            int i27 = i26 - i17;
            i3 = 0;
            i2 = 0;
            int i28 = i26;
            i = i27;
            i4 = i28;
        } else {
            i = bVar2.f4066b;
            i4 = i + i17;
            i3 = 0;
            i2 = 0;
        }
        while (i23 < i16) {
            View view4 = this.f3972K[i23];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.f4049s == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f3971J[this.f3970I - layoutParams2.f3977e];
                    i8 = i4;
                    i6 = paddingLeft;
                    i7 = paddingLeft - this.f4051u.getDecoratedMeasurementInOther(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f3971J[layoutParams2.f3977e];
                    i8 = i4;
                    i7 = paddingLeft2;
                    i6 = this.f4051u.getDecoratedMeasurementInOther(view4) + paddingLeft2;
                }
                i5 = i;
            } else {
                int paddingTop = getPaddingTop() + this.f3971J[layoutParams2.f3977e];
                i5 = paddingTop;
                i7 = i3;
                i6 = i2;
                i8 = this.f4051u.getDecoratedMeasurementInOther(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, i7, i5, i6, i8);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult2.mIgnoreConsumed = true;
            }
            layoutChunkResult2.mFocusable |= view4.hasFocusable();
            i23++;
            i4 = i8;
            i3 = i7;
            i2 = i6;
            i = i5;
        }
        Arrays.fill(this.f3972K, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y */
    public void mo6706Y(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.C0902a aVar, int i) {
        super.mo6706Y(recycler, state, aVar, i);
        m2883C0();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            m2889t0(recycler, state, aVar, i);
        }
        m2890u0();
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f4049s == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4049s == 1) {
            return this.f3970I;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return m2891w0(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f4049s == 0) {
            return this.f3970I;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return m2891w0(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpanCount() {
        return this.f3970I;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.f3975N;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.f3977e
            int r5 = r5.f3978f
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.mo6816B(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.f4054x
            if (r7 == r10) goto L_0x0032
            r7 = 1
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.getChildCount()
            int r7 = r7 - r9
            r11 = -1
            r12 = -1
            goto L_0x0045
        L_0x003e:
            int r7 = r23.getChildCount()
            r11 = r7
            r7 = 0
            r12 = 1
        L_0x0045:
            int r13 = r0.f4049s
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.isLayoutRTL()
            if (r13 == 0) goto L_0x0051
            r13 = 1
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.m2891w0(r1, r2, r7)
            r10 = r7
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.m2891w0(r1, r2, r10)
            android.view.View r1 = r0.getChildAt(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.f3977e
            r18 = r3
            int r3 = r9.f3978f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.f3977e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.f3977e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.mo7212j(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int w0 = m2891w0(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.f4049s == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), w0, 1, this.f3970I > 1 && layoutParams2.getSpanSize() == this.f3970I, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(w0, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), this.f3970I > 1 && layoutParams2.getSpanSize() == this.f3970I, false));
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f3975N.invalidateSpanIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3975N.invalidateSpanIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f3975N.invalidateSpanIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f3975N.invalidateSpanIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f3975N.invalidateSpanIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            m2885p0();
        }
        super.onLayoutChildren(recycler, state);
        m2888s0();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f3969H = false;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        m2883C0();
        m2890u0();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        m2883C0();
        m2890u0();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f3971J == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f4049s == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f3971J;
            i3 = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f3971J;
            i4 = RecyclerView.LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void setSpanCount(int i) {
        if (i != this.f3970I) {
            this.f3969H = true;
            if (i >= 1) {
                this.f3970I = i;
                this.f3975N.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.f3975N = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f4045D == null && !this.f3969H;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v0 */
    public int mo6731v0(int i, int i2) {
        if (this.f4049s != 1 || !isLayoutRTL()) {
            int[] iArr = this.f3971J;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f3971J;
        int i3 = this.f3970I;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo6732x(RecyclerView.State state, LinearLayoutManager.C0903b bVar, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.f3970I;
        for (int i2 = 0; i2 < this.f3970I && bVar.mo6880c(state) && i > 0; i2++) {
            int i3 = bVar.f4068d;
            layoutPrefetchRegistry.addPosition(i3, Math.max(0, bVar.f4071g));
            i -= this.f3975N.getSpanSize(i3);
            bVar.f4068d += bVar.f4069e;
        }
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: e */
        int f3977e = -1;

        /* renamed from: f */
        int f3978f = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getSpanIndex() {
            return this.f3977e;
        }

        public int getSpanSize() {
            return this.f3978f;
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

    public GridLayoutManager(Context context, int i) {
        super(context);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        setSpanCount(i);
    }
}
