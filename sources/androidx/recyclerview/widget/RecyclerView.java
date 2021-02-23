package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.C0129Px;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.p003os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.C0868R;
import androidx.recyclerview.widget.C0931a;
import androidx.recyclerview.widget.C0934b;
import androidx.recyclerview.widget.C0942d;
import androidx.recyclerview.widget.C0958j;
import androidx.recyclerview.widget.ViewBoundsCheck;
import com.facebook.ads.AdError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2 {

    /* renamed from: A0 */
    private static final int[] f4086A0 = {16842987};

    /* renamed from: B0 */
    static final boolean f4087B0;

    /* renamed from: C0 */
    static final boolean f4088C0;

    /* renamed from: D0 */
    static final boolean f4089D0;

    /* renamed from: E0 */
    static final boolean f4090E0;

    /* renamed from: F0 */
    private static final boolean f4091F0;

    /* renamed from: G0 */
    private static final boolean f4092G0;

    /* renamed from: H0 */
    private static final Class<?>[] f4093H0;
    public static final int HORIZONTAL = 0;

    /* renamed from: I0 */
    static final Interpolator f4094I0 = new C0914c();
    public static final int INVALID_TYPE = -1;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;

    /* renamed from: z0 */
    private static final int[] f4095z0 = {16843830};

    /* renamed from: A */
    boolean f4096A;

    /* renamed from: B */
    private final AccessibilityManager f4097B;

    /* renamed from: C */
    private List<OnChildAttachStateChangeListener> f4098C;

    /* renamed from: D */
    boolean f4099D;

    /* renamed from: E */
    boolean f4100E;

    /* renamed from: F */
    private int f4101F;

    /* renamed from: G */
    private int f4102G;
    @NonNull

    /* renamed from: H */
    private EdgeEffectFactory f4103H;

    /* renamed from: I */
    private EdgeEffect f4104I;

    /* renamed from: J */
    private EdgeEffect f4105J;

    /* renamed from: K */
    private EdgeEffect f4106K;

    /* renamed from: L */
    private EdgeEffect f4107L;

    /* renamed from: M */
    ItemAnimator f4108M;

    /* renamed from: N */
    private int f4109N;

    /* renamed from: O */
    private int f4110O;

    /* renamed from: P */
    private VelocityTracker f4111P;

    /* renamed from: Q */
    private int f4112Q;

    /* renamed from: R */
    private int f4113R;

    /* renamed from: S */
    private int f4114S;

    /* renamed from: T */
    private int f4115T;

    /* renamed from: U */
    private int f4116U;

    /* renamed from: V */
    private OnFlingListener f4117V;

    /* renamed from: W */
    private final int f4118W;

    /* renamed from: a */
    private final C0920i f4119a;

    /* renamed from: a0 */
    private final int f4120a0;

    /* renamed from: b */
    final Recycler f4121b;

    /* renamed from: b0 */
    private float f4122b0;

    /* renamed from: c */
    private SavedState f4123c;

    /* renamed from: c0 */
    private float f4124c0;

    /* renamed from: d */
    C0931a f4125d;

    /* renamed from: d0 */
    private boolean f4126d0;

    /* renamed from: e */
    C0934b f4127e;

    /* renamed from: e0 */
    final C0921j f4128e0;

    /* renamed from: f */
    final C0958j f4129f;

    /* renamed from: f0 */
    C0942d f4130f0;

    /* renamed from: g */
    boolean f4131g;

    /* renamed from: g0 */
    C0942d.C0944b f4132g0;

    /* renamed from: h */
    final Runnable f4133h;

    /* renamed from: h0 */
    final State f4134h0;

    /* renamed from: i */
    final Rect f4135i;

    /* renamed from: i0 */
    private OnScrollListener f4136i0;

    /* renamed from: j */
    private final Rect f4137j;

    /* renamed from: j0 */
    private List<OnScrollListener> f4138j0;

    /* renamed from: k */
    final RectF f4139k;

    /* renamed from: k0 */
    boolean f4140k0;

    /* renamed from: l */
    Adapter f4141l;

    /* renamed from: l0 */
    boolean f4142l0;
    @VisibleForTesting

    /* renamed from: m */
    LayoutManager f4143m;

    /* renamed from: m0 */
    private ItemAnimator.C0907a f4144m0;

    /* renamed from: n */
    RecyclerListener f4145n;

    /* renamed from: n0 */
    boolean f4146n0;

    /* renamed from: o */
    final ArrayList<ItemDecoration> f4147o;

    /* renamed from: o0 */
    RecyclerViewAccessibilityDelegate f4148o0;

    /* renamed from: p */
    private final ArrayList<OnItemTouchListener> f4149p;

    /* renamed from: p0 */
    private ChildDrawingOrderCallback f4150p0;

    /* renamed from: q */
    private OnItemTouchListener f4151q;

    /* renamed from: q0 */
    private final int[] f4152q0;

    /* renamed from: r */
    boolean f4153r;

    /* renamed from: r0 */
    private NestedScrollingChildHelper f4154r0;

    /* renamed from: s */
    boolean f4155s;

    /* renamed from: s0 */
    private final int[] f4156s0;

    /* renamed from: t */
    boolean f4157t;

    /* renamed from: t0 */
    final int[] f4158t0;
    @VisibleForTesting

    /* renamed from: u */
    boolean f4159u;

    /* renamed from: u0 */
    private final int[] f4160u0;

    /* renamed from: v */
    private int f4161v;

    /* renamed from: v0 */
    final int[] f4162v0;

    /* renamed from: w */
    boolean f4163w;
    @VisibleForTesting

    /* renamed from: w0 */
    final List<ViewHolder> f4164w0;

    /* renamed from: x */
    boolean f4165x;

    /* renamed from: x0 */
    private Runnable f4166x0;

    /* renamed from: y */
    private boolean f4167y;

    /* renamed from: y0 */
    private final C0958j.C0960b f4168y0;

    /* renamed from: z */
    private int f4169z;

    public static abstract class Adapter<VH extends ViewHolder> {

        /* renamed from: a */
        private final C0918g f4170a = new C0918g();

        /* renamed from: b */
        private boolean f4171b = false;

        public final void bindViewHolder(@NonNull VH vh, int i) {
            vh.f4252b = i;
            if (hasStableIds()) {
                vh.f4254d = getItemId(i);
            }
            vh.mo7418y(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            onBindViewHolder(vh, i, vh.mo7401j());
            vh.mo7389d();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f4200c = true;
            }
            TraceCompat.endSection();
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.f4255e = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.f4170a.mo7447a();
        }

        public final boolean hasStableIds() {
            return this.f4171b;
        }

        public final void notifyDataSetChanged() {
            this.f4170a.mo7448b();
        }

        public final void notifyItemChanged(int i) {
            this.f4170a.mo7450d(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.f4170a.mo7452f(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.f4170a.mo7449c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.f4170a.mo7450d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.f4170a.mo7452f(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.f4170a.mo7453g(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.f4170a.mo7453g(i, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
            onBindViewHolder(vh, i);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f4170a.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.f4171b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f4170a.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i, @Nullable Object obj) {
            this.f4170a.mo7451e(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            this.f4170a.mo7451e(i, i2, obj);
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        /* access modifiers changed from: protected */
        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;

        /* renamed from: a */
        private C0907a f4172a = null;

        /* renamed from: b */
        private ArrayList<ItemAnimatorFinishedListener> f4173b = new ArrayList<>();

        /* renamed from: c */
        private long f4174c = 120;

        /* renamed from: d */
        private long f4175d = 120;

        /* renamed from: e */
        private long f4176e = 250;

        /* renamed from: f */
        private long f4177f = 250;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$ItemAnimator$a */
        interface C0907a {
            /* renamed from: a */
            void mo7145a(@NonNull ViewHolder viewHolder);
        }

        /* renamed from: a */
        static int m3104a(ViewHolder viewHolder) {
            int i = viewHolder.f4259i & 14;
            if (viewHolder.mo7405n()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = viewHolder.getOldPosition();
            int adapterPosition = viewHolder.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7123b(C0907a aVar) {
            this.f4172a = aVar;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            C0907a aVar = this.f4172a;
            if (aVar != null) {
                aVar.mo7145a(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.f4173b.size();
            for (int i = 0; i < size; i++) {
                this.f4173b.get(i).onAnimationsFinished();
            }
            this.f4173b.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.f4174c;
        }

        public long getChangeDuration() {
            return this.f4177f;
        }

        public long getMoveDuration() {
            return this.f4176e;
        }

        public long getRemoveDuration() {
            return this.f4175d;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.f4173b.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.f4174c = j;
        }

        public void setChangeDuration(long j) {
            this.f4177f = j;
        }

        public void setMoveDuration(long j) {
            this.f4176e = j;
        }

        public void setRemoveDuration(long j) {
            this.f4175d = j;
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    public static abstract class LayoutManager {

        /* renamed from: a */
        C0934b f4178a;

        /* renamed from: b */
        RecyclerView f4179b;

        /* renamed from: c */
        private final ViewBoundsCheck.C0930b f4180c;

        /* renamed from: d */
        private final ViewBoundsCheck.C0930b f4181d;

        /* renamed from: e */
        ViewBoundsCheck f4182e;

        /* renamed from: f */
        ViewBoundsCheck f4183f;
        @Nullable

        /* renamed from: g */
        SmoothScroller f4184g;

        /* renamed from: h */
        boolean f4185h = false;

        /* renamed from: i */
        boolean f4186i = false;

        /* renamed from: j */
        boolean f4187j = false;

        /* renamed from: k */
        private boolean f4188k = true;

        /* renamed from: l */
        private boolean f4189l = true;

        /* renamed from: m */
        int f4190m;

        /* renamed from: n */
        boolean f4191n;

        /* renamed from: o */
        private int f4192o;

        /* renamed from: p */
        private int f4193p;

        /* renamed from: q */
        private int f4194q;

        /* renamed from: r */
        private int f4195r;

        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$LayoutManager$a */
        class C0908a implements ViewBoundsCheck.C0930b {
            C0908a() {
            }

            /* renamed from: a */
            public View mo7265a(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            /* renamed from: b */
            public int mo7266b(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: c */
            public int mo7267c() {
                return LayoutManager.this.getPaddingLeft();
            }

            /* renamed from: d */
            public int mo7268d() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            /* renamed from: e */
            public int mo7269e(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$LayoutManager$b */
        class C0909b implements ViewBoundsCheck.C0930b {
            C0909b() {
            }

            /* renamed from: a */
            public View mo7265a(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            /* renamed from: b */
            public int mo7266b(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            /* renamed from: c */
            public int mo7267c() {
                return LayoutManager.this.getPaddingTop();
            }

            /* renamed from: d */
            public int mo7268d() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            /* renamed from: e */
            public int mo7269e(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        }

        public LayoutManager() {
            C0908a aVar = new C0908a();
            this.f4180c = aVar;
            C0909b bVar = new C0909b();
            this.f4181d = bVar;
            this.f4182e = new ViewBoundsCheck(aVar);
            this.f4183f = new ViewBoundsCheck(bVar);
        }

        /* renamed from: a */
        private void m3107a(View view, int i, boolean z) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (z || S.mo7406o()) {
                this.f4179b.f4129f.mo7706b(S);
            } else {
                this.f4179b.f4129f.mo7719p(S);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (S.mo7385E() || S.mo7407p()) {
                if (S.mo7407p()) {
                    S.mo7384D();
                } else {
                    S.mo7390e();
                }
                this.f4178a.mo7644c(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f4179b) {
                int m = this.f4178a.mo7652m(view);
                if (i == -1) {
                    i = this.f4178a.mo7648g();
                }
                if (m == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f4179b.indexOfChild(view) + this.f4179b.mo6933K());
                } else if (m != i) {
                    this.f4179b.f4143m.moveView(m, i);
                }
            } else {
                this.f4178a.mo7642a(view, i, false);
                layoutParams.f4200c = true;
                SmoothScroller smoothScroller = this.f4184g;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.f4184g.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.f4201d) {
                S.itemView.invalidate();
                layoutParams.f4201d = false;
            }
        }

        /* renamed from: b */
        private void m3108b(int i, @NonNull View view) {
            this.f4178a.mo7645d(i);
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* renamed from: e */
        private int[] m3109e(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        /* renamed from: g */
        private boolean m3110g(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.f4179b.f4135i;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i >= width || rect.right - i <= paddingLeft || rect.top - i2 >= height || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r3 = 0
                goto L_0x0021
            L_0x000f:
                if (r3 < 0) goto L_0x0014
            L_0x0011:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0021
            L_0x0014:
                r4 = -1
                if (r3 != r4) goto L_0x001b
                r2 = 1073741824(0x40000000, float:2.0)
            L_0x0019:
                r3 = r1
                goto L_0x0021
            L_0x001b:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0019
            L_0x0021:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0868R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(C0868R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(C0868R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(C0868R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(C0868R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        /* renamed from: h */
        private static boolean m3111h(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        /* renamed from: o */
        private void m3112o(Recycler recycler, int i, View view) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (!S.mo7382B()) {
                if (!S.mo7405n() || S.mo7406o() || this.f4179b.f4141l.hasStableIds()) {
                    detachViewAt(i);
                    recycler.mo7327y(view);
                    this.f4179b.f4129f.mo7715k(S);
                    return;
                }
                removeViewAt(i);
                recycler.mo7326x(S);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                recyclerView.mo7008j(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                recyclerView.mo7010k(str);
            }
        }

        public void attachView(@NonNull View view, int i, LayoutParams layoutParams) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (S.mo7406o()) {
                this.f4179b.f4129f.mo7706b(S);
            } else {
                this.f4179b.f4129f.mo7719p(S);
            }
            this.f4178a.mo7644c(view, i, layoutParams, S.mo7406o());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo7157c(RecyclerView recyclerView) {
            this.f4186i = true;
            onAttachedToWindow(recyclerView);
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.mo6942W(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7159d(RecyclerView recyclerView, Recycler recycler) {
            this.f4186i = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                m3112o(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            m3112o(recycler, this.f4178a.mo7652m(view), view);
        }

        public void detachAndScrapViewAt(int i, @NonNull Recycler recycler) {
            m3112o(recycler, i, getChildAt(i));
        }

        public void detachView(@NonNull View view) {
            int m = this.f4178a.mo7652m(view);
            if (m >= 0) {
                m3108b(m, view);
            }
        }

        public void detachViewAt(int i) {
            m3108b(i, getChildAt(i));
        }

        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.f4179b.f4108M;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.m3023S(view));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public boolean mo7166f() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f4178a.mo7653n(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        @Nullable
        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder S = RecyclerView.m3023S(childAt);
                if (S != null && S.getLayoutPosition() == i && !S.mo7382B() && (this.f4179b.f4134h0.isPreLayout() || !S.mo7406o())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f4199b.bottom;
        }

        @Nullable
        public View getChildAt(int i) {
            C0934b bVar = this.f4178a;
            if (bVar != null) {
                return bVar.mo7647f(i);
            }
            return null;
        }

        public int getChildCount() {
            C0934b bVar = this.f4178a;
            if (bVar != null) {
                return bVar.mo7648g();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.f4179b;
            return recyclerView != null && recyclerView.f4131g;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView == null || recyclerView.f4141l == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.f4179b.f4141l.getItemCount();
        }

        public int getDecoratedBottom(@NonNull View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.m3024T(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4199b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4199b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f4178a.mo7653n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @C0129Px
        public int getHeight() {
            return this.f4195r;
        }

        public int getHeightMode() {
            return this.f4193p;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.f4179b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.m3023S(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.f4179b);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f4199b.left;
        }

        @C0129Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.f4179b);
        }

        @C0129Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.f4179b);
        }

        @C0129Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @C0129Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @C0129Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @C0129Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @C0129Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @C0129Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f4199b.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView == null || recyclerView.f4141l == null || !canScrollVertically()) {
                return 1;
            }
            return this.f4179b.f4141l.getItemCount();
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f4199b.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f4199b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f4179b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f4179b.f4139k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        @C0129Px
        public int getWidth() {
            return this.f4194q;
        }

        public int getWidthMode() {
            return this.f4192o;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.f4179b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo7203i(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.f4179b;
            onInitializeAccessibilityNodeInfo(recyclerView.f4121b, recyclerView.f4134h0, accessibilityNodeInfoCompat);
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.f4179b;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.f4179b.mo6933K());
            }
            ViewHolder S = RecyclerView.m3023S(view);
            S.mo7387b(128);
            this.f4179b.f4129f.mo7720q(S);
        }

        public boolean isAttachedToWindow() {
            return this.f4186i;
        }

        public boolean isAutoMeasureEnabled() {
            return this.f4187j;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.f4179b;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.f4189l;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.f4188k;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.f4184g;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z, boolean z2) {
            boolean z3 = this.f4182e.mo7614b(view, 24579) && this.f4183f.mo7614b(view, 24579);
            return z ? z3 : !z3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo7212j(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (S != null && !S.mo7406o() && !this.f4178a.mo7653n(S.itemView)) {
                RecyclerView recyclerView = this.f4179b;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.f4121b, recyclerView.f4134h0, view, accessibilityNodeInfoCompat);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo7213k(SmoothScroller smoothScroller) {
            if (this.f4184g == smoothScroller) {
                this.f4184g = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public boolean mo7214l(int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.f4179b;
            return performAccessibilityAction(recyclerView.f4121b, recyclerView.f4134h0, i, bundle);
        }

        public void layoutDecorated(@NonNull View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4199b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f4199b;
            view.layout(i + rect.left + layoutParams.leftMargin, i2 + rect.top + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public boolean mo7217m(@NonNull View view, int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.f4179b;
            return performAccessibilityActionForItem(recyclerView.f4121b, recyclerView.f4134h0, view, i, bundle);
        }

        public void measureChild(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect W = this.f4179b.mo6942W(view);
            int i3 = i + W.left + W.right;
            int i4 = i2 + W.top + W.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, layoutParams.height, canScrollVertically());
            if (mo7261t(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect W = this.f4179b.mo6942W(view);
            int i3 = i + W.left + W.right;
            int i4 = i2 + W.top + W.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i4, layoutParams.height, canScrollVertically());
            if (mo7261t(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f4179b.toString());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public void mo7221n(Recycler recycler) {
            int h = recycler.mo7310h();
            for (int i = h - 1; i >= 0; i--) {
                View k = recycler.mo7313k(i);
                ViewHolder S = RecyclerView.m3023S(k);
                if (!S.mo7382B()) {
                    S.setIsRecyclable(false);
                    if (S.mo7408q()) {
                        this.f4179b.removeDetachedView(k, false);
                    }
                    ItemAnimator itemAnimator = this.f4179b.f4108M;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(S);
                    }
                    S.setIsRecyclable(true);
                    recycler.mo7323u(k);
                }
            }
            recycler.mo7304d();
            if (h > 0) {
                this.f4179b.invalidate();
            }
        }

        public void offsetChildrenHorizontal(@C0129Px int i) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(@C0129Px int i) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4179b;
            onInitializeAccessibilityEvent(recyclerView.f4121b, recyclerView.f4134h0, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f4179b.canScrollVertically(-1) || this.f4179b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.f4179b.canScrollVertically(1) || this.f4179b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i, int i2) {
            this.f4179b.mo7049s(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public void mo7236p(RecyclerView recyclerView) {
            mo7240q(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler r2, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State r3, int r4, @androidx.annotation.Nullable android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f4179b
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L_0x0042
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x006e
            L_0x0012:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L_0x0029
                int r2 = r1.getHeight()
                int r5 = r1.getPaddingTop()
                int r2 = r2 - r5
                int r5 = r1.getPaddingBottom()
                int r2 = r2 - r5
                int r2 = -r2
                goto L_0x002a
            L_0x0029:
                r2 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.f4179b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.getWidth()
                int r5 = r1.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r1.getPaddingRight()
                int r4 = r4 - r5
                int r4 = -r4
                goto L_0x006e
            L_0x0042:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L_0x0057
                int r2 = r1.getHeight()
                int r4 = r1.getPaddingTop()
                int r2 = r2 - r4
                int r4 = r1.getPaddingBottom()
                int r2 = r2 - r4
                goto L_0x0058
            L_0x0057:
                r2 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f4179b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.getWidth()
                int r5 = r1.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r1.getPaddingRight()
                int r4 = r4 - r5
            L_0x006e:
                if (r2 != 0) goto L_0x0073
                if (r4 != 0) goto L_0x0073
                return r3
            L_0x0073:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f4179b
                r3.smoothScrollBy(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public void mo7240q(int i, int i2) {
            this.f4194q = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.f4192o = mode;
            if (mode == 0 && !RecyclerView.f4088C0) {
                this.f4194q = 0;
            }
            this.f4195r = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f4193p = mode2;
            if (mode2 == 0 && !RecyclerView.f4088C0) {
                this.f4195r = 0;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public void mo7241r(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.f4179b.mo7049s(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.f4179b.f4135i;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.f4179b.f4135i.set(i5, i6, i3, i4);
            setMeasuredDimension(this.f4179b.f4135i, i, i2);
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.f4178a.mo7656q(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.m3023S(getChildAt(childCount)).mo7382B()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, @NonNull Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.f4179b.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.f4178a.mo7655p(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.f4178a.mo7656q(i);
            }
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.f4185h = true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public void mo7254s(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f4179b = null;
                this.f4178a = null;
                this.f4194q = 0;
                this.f4195r = 0;
            } else {
                this.f4179b = recyclerView;
                this.f4178a = recyclerView.f4127e;
                this.f4194q = recyclerView.getWidth();
                this.f4195r = recyclerView.getHeight();
            }
            this.f4192o = 1073741824;
            this.f4193p = 1073741824;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.f4187j = z;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.f4189l) {
                this.f4189l = z;
                this.f4190m = 0;
                RecyclerView recyclerView = this.f4179b;
                if (recyclerView != null) {
                    recyclerView.f4121b.mo7296E();
                }
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.f4188k = z;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.f4184g;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.isRunning())) {
                this.f4184g.stop();
            }
            this.f4184g = smoothScroller;
            smoothScroller.mo7338b(this.f4179b, this);
        }

        public void stopIgnoringView(@NonNull View view) {
            ViewHolder S = RecyclerView.m3023S(view);
            S.mo7383C();
            S.mo7416w();
            S.mo7387b(4);
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public boolean mo7261t(View view, int i, int i2, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.f4188k || !m3111h(view.getWidth(), i, layoutParams.width) || !m3111h(view.getHeight(), i2, layoutParams.height);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public boolean mo6862u() {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public boolean mo7262v(View view, int i, int i2, LayoutParams layoutParams) {
            return !this.f4188k || !m3111h(view.getMeasuredWidth(), i, layoutParams.width) || !m3111h(view.getMeasuredHeight(), i2, layoutParams.height);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public void mo7263w() {
            SmoothScroller smoothScroller = this.f4184g;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public void addDisappearingView(View view, int i) {
            m3107a(view, i, true);
        }

        public void addView(View view, int i) {
            m3107a(view, i, false);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4179b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f4179b.canScrollVertically(-1) && !this.f4179b.canScrollHorizontally(-1) && !this.f4179b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                Adapter adapter = this.f4179b.f4141l;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            int[] e = m3109e(recyclerView, view, rect, z);
            int i = e[0];
            int i2 = e[1];
            if ((z2 && !m3110g(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void attachView(@NonNull View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.f4179b.setMeasuredDimension(i, i2);
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public static class RecycledViewPool {

        /* renamed from: a */
        SparseArray<C0910a> f4202a = new SparseArray<>();

        /* renamed from: b */
        private int f4203b = 0;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$RecycledViewPool$a */
        static class C0910a {

            /* renamed from: a */
            final ArrayList<ViewHolder> f4204a = new ArrayList<>();

            /* renamed from: b */
            int f4205b = 5;

            /* renamed from: c */
            long f4206c = 0;

            /* renamed from: d */
            long f4207d = 0;

            C0910a() {
            }
        }

        /* renamed from: e */
        private C0910a m3140e(int i) {
            C0910a aVar = this.f4202a.get(i);
            if (aVar != null) {
                return aVar;
            }
            C0910a aVar2 = new C0910a();
            this.f4202a.put(i, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7280a() {
            this.f4203b++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7281b() {
            this.f4203b--;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo7282c(int i, long j) {
            C0910a e = m3140e(i);
            e.f4207d = mo7286g(e.f4207d, j);
        }

        public void clear() {
            for (int i = 0; i < this.f4202a.size(); i++) {
                this.f4202a.valueAt(i).f4204a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7284d(int i, long j) {
            C0910a e = m3140e(i);
            e.f4206c = mo7286g(e.f4206c, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo7285f(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                mo7281b();
            }
            if (!z && this.f4203b == 0) {
                clear();
            }
            if (adapter2 != null) {
                mo7280a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public long mo7286g(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        @Nullable
        public ViewHolder getRecycledView(int i) {
            C0910a aVar = this.f4202a.get(i);
            if (aVar == null || aVar.f4204a.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = aVar.f4204a;
            return arrayList.remove(arrayList.size() - 1);
        }

        public int getRecycledViewCount(int i) {
            return m3140e(i).f4204a.size();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public boolean mo7289h(int i, long j, long j2) {
            long j3 = m3140e(i).f4207d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public boolean mo7290i(int i, long j, long j2) {
            long j3 = m3140e(i).f4206c;
            return j3 == 0 || j + j3 < j2;
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = m3140e(itemViewType).f4204a;
            if (this.f4202a.get(itemViewType).f4205b > arrayList.size()) {
                viewHolder.mo7416w();
                arrayList.add(viewHolder);
            }
        }

        public void setMaxRecycledViews(int i, int i2) {
            C0910a e = m3140e(i);
            e.f4205b = i2;
            ArrayList<ViewHolder> arrayList = e.f4204a;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    public final class Recycler {

        /* renamed from: a */
        final ArrayList<ViewHolder> f4208a;

        /* renamed from: b */
        ArrayList<ViewHolder> f4209b = null;

        /* renamed from: c */
        final ArrayList<ViewHolder> f4210c = new ArrayList<>();

        /* renamed from: d */
        private final List<ViewHolder> f4211d;

        /* renamed from: e */
        private int f4212e;

        /* renamed from: f */
        int f4213f;

        /* renamed from: g */
        RecycledViewPool f4214g;

        /* renamed from: h */
        private ViewCacheExtension f4215h;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.f4208a = arrayList;
            this.f4211d = Collections.unmodifiableList(arrayList);
            this.f4212e = 2;
            this.f4213f = 2;
        }

        /* renamed from: B */
        private boolean m3149B(@NonNull ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.f4267q = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.f4214g.mo7289h(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.f4141l.bindViewHolder(viewHolder, i);
            this.f4214g.mo7282c(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            m3150b(viewHolder);
            if (!RecyclerView.this.f4134h0.isPreLayout()) {
                return true;
            }
            viewHolder.f4256f = i2;
            return true;
        }

        /* renamed from: b */
        private void m3150b(ViewHolder viewHolder) {
            if (RecyclerView.this.mo6960e0()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view)) {
                    viewHolder.mo7387b(16384);
                    ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.f4148o0.getItemDelegate());
                }
            }
        }

        /* renamed from: m */
        private void m3151m(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m3151m((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* renamed from: n */
        private void m3152n(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                m3151m((ViewGroup) view, false);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: A */
        public void mo7293A(ViewCacheExtension viewCacheExtension) {
            this.f4215h = viewCacheExtension;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01a7  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01d0  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01d3  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0203  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0211  */
        @androidx.annotation.Nullable
        /* renamed from: C */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder mo7294C(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x0234
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.f4134h0
                int r1 = r1.getItemCount()
                if (r3 >= r1) goto L_0x0234
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.f4134h0
                boolean r1 = r1.isPreLayout()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r16.mo7306f(r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r16.mo7312j(r17, r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.mo7297F(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.mo7387b(r5)
                boolean r5 = r1.mo7407p()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.mo7384D()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.mo7385E()
                if (r5 == 0) goto L_0x0057
                r1.mo7390e()
            L_0x0057:
                r6.mo7326x(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0186
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.f4125d
                int r5 = r5.mo7626m(r3)
                if (r5 < 0) goto L_0x0149
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.f4141l
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x0149
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.f4141l
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.f4141l
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.f4141l
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r6.mo7311i(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.f4252b = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$ViewCacheExtension r0 = r6.f4215h
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.getViewForPositionAndType(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.getChildViewHolder(r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.mo7382B()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo6933K()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo6933K()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0102
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r0 = r16.mo7307g()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.getRecycledView(r9)
                if (r0 == 0) goto L_0x0101
                r0.mo7416w()
                boolean r1 = androidx.recyclerview.widget.RecyclerView.f4087B0
                if (r1 == 0) goto L_0x0101
                r6.m3152n(r0)
            L_0x0101:
                r1 = r0
            L_0x0102:
                if (r1 != 0) goto L_0x0186
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x0120
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r10 = r6.f4214g
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.mo7290i(r11, r12, r14)
                if (r5 != 0) goto L_0x0120
                return r2
            L_0x0120:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r5 = r2.f4141l
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r5.createViewHolder(r2, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.f4090E0
                if (r5 == 0) goto L_0x013b
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.m3020N(r5)
                if (r5 == 0) goto L_0x013b
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.f4251a = r10
            L_0x013b:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r5 = r6.f4214g
                long r10 = r10 - r0
                r5.mo7284d(r9, r10)
                r9 = r2
                goto L_0x0187
            L_0x0149:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")."
                r1.append(r2)
                java.lang.String r2 = "state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.f4134h0
                int r2 = r2.getItemCount()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo6933K()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0186:
                r9 = r1
            L_0x0187:
                r10 = r4
                if (r10 == 0) goto L_0x01c0
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.f4134h0
                boolean r0 = r0.isPreLayout()
                if (r0 != 0) goto L_0x01c0
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.mo7402k(r0)
                if (r1 == 0) goto L_0x01c0
                r9.mo7418y(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.f4134h0
                boolean r0 = r0.f4243k
                if (r0 == 0) goto L_0x01c0
                int r0 = androidx.recyclerview.widget.RecyclerView.ItemAnimator.m3104a(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ItemAnimator r2 = r1.f4108M
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.f4134h0
                java.util.List r4 = r9.mo7401j()
                androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r0 = r2.recordPreLayoutInformation(r1, r9, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.mo7080v0(r9, r0)
            L_0x01c0:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.f4134h0
                boolean r0 = r0.isPreLayout()
                if (r0 == 0) goto L_0x01d3
                boolean r0 = r9.mo7404m()
                if (r0 == 0) goto L_0x01d3
                r9.f4256f = r3
                goto L_0x01e6
            L_0x01d3:
                boolean r0 = r9.mo7404m()
                if (r0 == 0) goto L_0x01e8
                boolean r0 = r9.mo7410s()
                if (r0 != 0) goto L_0x01e8
                boolean r0 = r9.mo7405n()
                if (r0 == 0) goto L_0x01e6
                goto L_0x01e8
            L_0x01e6:
                r0 = 0
                goto L_0x01fb
            L_0x01e8:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.f4125d
                int r2 = r0.mo7626m(r3)
                r0 = r16
                r1 = r9
                r3 = r17
                r4 = r19
                boolean r0 = r0.m3149B(r1, r2, r3, r4)
            L_0x01fb:
                android.view.View r1 = r9.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x0211
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0229
            L_0x0211:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0227
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0229
            L_0x0227:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0229:
                r1.f4198a = r9
                if (r10 == 0) goto L_0x0230
                if (r0 == 0) goto L_0x0230
                goto L_0x0231
            L_0x0230:
                r7 = 0
            L_0x0231:
                r1.f4201d = r7
                return r9
            L_0x0234:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.f4134h0
                int r2 = r2.getItemCount()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo6933K()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.mo7294C(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: D */
        public void mo7295D(ViewHolder viewHolder) {
            if (viewHolder.f4264n) {
                this.f4209b.remove(viewHolder);
            } else {
                this.f4208a.remove(viewHolder);
            }
            viewHolder.f4263m = null;
            viewHolder.f4264n = false;
            viewHolder.mo7390e();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: E */
        public void mo7296E() {
            LayoutManager layoutManager = RecyclerView.this.f4143m;
            this.f4213f = this.f4212e + (layoutManager != null ? layoutManager.f4190m : 0);
            for (int size = this.f4210c.size() - 1; size >= 0 && this.f4210c.size() > this.f4213f; size--) {
                mo7325w(size);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: F */
        public boolean mo7297F(ViewHolder viewHolder) {
            if (viewHolder.mo7406o()) {
                return RecyclerView.this.f4134h0.isPreLayout();
            }
            int i = viewHolder.f4252b;
            if (i < 0 || i >= RecyclerView.this.f4141l.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.mo6933K());
            } else if (!RecyclerView.this.f4134h0.isPreLayout() && RecyclerView.this.f4141l.getItemViewType(viewHolder.f4252b) != viewHolder.getItemViewType()) {
                return false;
            } else {
                if (!RecyclerView.this.f4141l.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.f4141l.getItemId(viewHolder.f4252b)) {
                    return true;
                }
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: G */
        public void mo7298G(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f4210c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f4210c.get(size);
                if (viewHolder != null && (i3 = viewHolder.f4252b) >= i && i3 < i4) {
                    viewHolder.mo7387b(2);
                    mo7325w(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7299a(@NonNull ViewHolder viewHolder, boolean z) {
            RecyclerView.m3039n(viewHolder);
            if (viewHolder.mo7402k(16384)) {
                viewHolder.mo7418y(0, 16384);
                ViewCompat.setAccessibilityDelegate(viewHolder.itemView, (AccessibilityDelegateCompat) null);
            }
            if (z) {
                mo7305e(viewHolder);
            }
            viewHolder.f4267q = null;
            mo7307g().putRecycledView(viewHolder);
        }

        public void bindViewToPosition(@NonNull View view, int i) {
            LayoutParams layoutParams;
            ViewHolder S = RecyclerView.m3023S(view);
            if (S != null) {
                int m = RecyclerView.this.f4125d.mo7626m(i);
                if (m < 0 || m >= RecyclerView.this.f4141l.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + m + ")." + "state:" + RecyclerView.this.f4134h0.getItemCount() + RecyclerView.this.mo6933K());
                }
                m3149B(S, m, i, Long.MAX_VALUE);
                ViewGroup.LayoutParams layoutParams2 = S.itemView.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                    S.itemView.setLayoutParams(layoutParams);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                    S.itemView.setLayoutParams(layoutParams);
                } else {
                    layoutParams = (LayoutParams) layoutParams2;
                }
                boolean z = true;
                layoutParams.f4200c = true;
                layoutParams.f4198a = S;
                if (S.itemView.getParent() != null) {
                    z = false;
                }
                layoutParams.f4201d = z;
                return;
            }
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.mo6933K());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo7301c() {
            int size = this.f4210c.size();
            for (int i = 0; i < size; i++) {
                this.f4210c.get(i).mo7388c();
            }
            int size2 = this.f4208a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f4208a.get(i2).mo7388c();
            }
            ArrayList<ViewHolder> arrayList = this.f4209b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f4209b.get(i3).mo7388c();
                }
            }
        }

        public void clear() {
            this.f4208a.clear();
            mo7324v();
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i < 0 || i >= RecyclerView.this.f4134h0.getItemCount()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + RecyclerView.this.f4134h0.getItemCount() + RecyclerView.this.mo6933K());
            } else if (!RecyclerView.this.f4134h0.isPreLayout()) {
                return i;
            } else {
                return RecyclerView.this.f4125d.mo7626m(i);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7304d() {
            this.f4208a.clear();
            ArrayList<ViewHolder> arrayList = this.f4209b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo7305e(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.f4145n;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            Adapter adapter = RecyclerView.this.f4141l;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f4134h0 != null) {
                recyclerView.f4129f.mo7720q(viewHolder);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public ViewHolder mo7306f(int i) {
            int size;
            int m;
            ArrayList<ViewHolder> arrayList = this.f4209b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    ViewHolder viewHolder = this.f4209b.get(i3);
                    if (viewHolder.mo7385E() || viewHolder.getLayoutPosition() != i) {
                        i3++;
                    } else {
                        viewHolder.mo7387b(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.f4141l.hasStableIds() && (m = RecyclerView.this.f4125d.mo7626m(i)) > 0 && m < RecyclerView.this.f4141l.getItemCount()) {
                    long itemId = RecyclerView.this.f4141l.getItemId(m);
                    while (i2 < size) {
                        ViewHolder viewHolder2 = this.f4209b.get(i2);
                        if (viewHolder2.mo7385E() || viewHolder2.getItemId() != itemId) {
                            i2++;
                        } else {
                            viewHolder2.mo7387b(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public RecycledViewPool mo7307g() {
            if (this.f4214g == null) {
                this.f4214g = new RecycledViewPool();
            }
            return this.f4214g;
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.f4211d;
        }

        @NonNull
        public View getViewForPosition(int i) {
            return mo7314l(i, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public int mo7310h() {
            return this.f4208a.size();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public ViewHolder mo7311i(long j, int i, boolean z) {
            for (int size = this.f4208a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f4208a.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.mo7385E()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.mo7387b(32);
                        if (viewHolder.mo7406o() && !RecyclerView.this.f4134h0.isPreLayout()) {
                            viewHolder.mo7418y(2, 14);
                        }
                        return viewHolder;
                    } else if (!z) {
                        this.f4208a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        mo7323u(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.f4210c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.f4210c.get(size2);
                if (viewHolder2.getItemId() == j) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.f4210c.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z) {
                        mo7325w(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public ViewHolder mo7312j(int i, boolean z) {
            View e;
            int size = this.f4208a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                ViewHolder viewHolder = this.f4208a.get(i3);
                if (viewHolder.mo7385E() || viewHolder.getLayoutPosition() != i || viewHolder.mo7405n() || (!RecyclerView.this.f4134h0.f4240h && viewHolder.mo7406o())) {
                    i3++;
                } else {
                    viewHolder.mo7387b(32);
                    return viewHolder;
                }
            }
            if (z || (e = RecyclerView.this.f4127e.mo7646e(i)) == null) {
                int size2 = this.f4210c.size();
                while (i2 < size2) {
                    ViewHolder viewHolder2 = this.f4210c.get(i2);
                    if (viewHolder2.mo7405n() || viewHolder2.getLayoutPosition() != i) {
                        i2++;
                    } else {
                        if (!z) {
                            this.f4210c.remove(i2);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            ViewHolder S = RecyclerView.m3023S(e);
            RecyclerView.this.f4127e.mo7658s(e);
            int m = RecyclerView.this.f4127e.mo7652m(e);
            if (m != -1) {
                RecyclerView.this.f4127e.mo7645d(m);
                mo7327y(e);
                S.mo7387b(8224);
                return S;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + S + RecyclerView.this.mo6933K());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public View mo7313k(int i) {
            return this.f4208a.get(i).itemView;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public View mo7314l(int i, boolean z) {
            return mo7294C(i, z, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public void mo7315o() {
            int size = this.f4210c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.f4210c.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f4200c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public void mo7316p() {
            int size = this.f4210c.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.f4210c.get(i);
                if (viewHolder != null) {
                    viewHolder.mo7387b(6);
                    viewHolder.mo7386a((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.f4141l;
            if (adapter == null || !adapter.hasStableIds()) {
                mo7324v();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public void mo7317q(int i, int i2) {
            int size = this.f4210c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.f4210c.get(i3);
                if (viewHolder != null && viewHolder.f4252b >= i) {
                    viewHolder.mo7412t(i2, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public void mo7318r(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i5 = -1;
                i4 = i;
                i3 = i2;
            } else {
                i5 = 1;
                i3 = i;
                i4 = i2;
            }
            int size = this.f4210c.size();
            for (int i7 = 0; i7 < size; i7++) {
                ViewHolder viewHolder = this.f4210c.get(i7);
                if (viewHolder != null && (i6 = viewHolder.f4252b) >= i4 && i6 <= i3) {
                    if (i6 == i) {
                        viewHolder.mo7412t(i2 - i, false);
                    } else {
                        viewHolder.mo7412t(i5, false);
                    }
                }
            }
        }

        public void recycleView(@NonNull View view) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (S.mo7408q()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (S.mo7407p()) {
                S.mo7384D();
            } else if (S.mo7385E()) {
                S.mo7390e();
            }
            mo7326x(S);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public void mo7320s(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f4210c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f4210c.get(size);
                if (viewHolder != null) {
                    int i4 = viewHolder.f4252b;
                    if (i4 >= i3) {
                        viewHolder.mo7412t(-i2, z);
                    } else if (i4 >= i) {
                        viewHolder.mo7387b(8);
                        mo7325w(size);
                    }
                }
            }
        }

        public void setViewCacheSize(int i) {
            this.f4212e = i;
            mo7296E();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public void mo7322t(Adapter adapter, Adapter adapter2, boolean z) {
            clear();
            mo7307g().mo7285f(adapter, adapter2, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public void mo7323u(View view) {
            ViewHolder S = RecyclerView.m3023S(view);
            S.f4263m = null;
            S.f4264n = false;
            S.mo7390e();
            mo7326x(S);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public void mo7324v() {
            for (int size = this.f4210c.size() - 1; size >= 0; size--) {
                mo7325w(size);
            }
            this.f4210c.clear();
            if (RecyclerView.f4090E0) {
                RecyclerView.this.f4132g0.mo7687a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public void mo7325w(int i) {
            mo7299a(this.f4210c.get(i), true);
            this.f4210c.remove(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: x */
        public void mo7326x(ViewHolder viewHolder) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (viewHolder.mo7407p() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.mo7407p());
                sb.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.mo6933K());
                throw new IllegalArgumentException(sb.toString());
            } else if (viewHolder.mo7408q()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.mo6933K());
            } else if (!viewHolder.mo7382B()) {
                boolean h = viewHolder.mo7398h();
                Adapter adapter = RecyclerView.this.f4141l;
                if ((adapter != null && h && adapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                    if (this.f4213f <= 0 || viewHolder.mo7402k(526)) {
                        z = false;
                    } else {
                        int size = this.f4210c.size();
                        if (size >= this.f4213f && size > 0) {
                            mo7325w(0);
                            size--;
                        }
                        if (RecyclerView.f4090E0 && size > 0 && !RecyclerView.this.f4132g0.mo7689c(viewHolder.f4252b)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.f4132g0.mo7689c(this.f4210c.get(i).f4252b)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.f4210c.add(size, viewHolder);
                        z = true;
                    }
                    if (!z) {
                        mo7299a(viewHolder, true);
                        z2 = z;
                        RecyclerView.this.f4129f.mo7720q(viewHolder);
                        if (!z2 && !z3 && h) {
                            viewHolder.f4267q = null;
                            return;
                        }
                        return;
                    }
                    z2 = z;
                }
                z3 = false;
                RecyclerView.this.f4129f.mo7720q(viewHolder);
                if (!z2) {
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.mo6933K());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public void mo7327y(View view) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (!S.mo7402k(12) && S.mo7409r() && !RecyclerView.this.mo7012l(S)) {
                if (this.f4209b == null) {
                    this.f4209b = new ArrayList<>();
                }
                S.mo7419z(this, true);
                this.f4209b.add(S);
            } else if (!S.mo7405n() || S.mo7406o() || RecyclerView.this.f4141l.hasStableIds()) {
                S.mo7419z(this, false);
                this.f4208a.add(S);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.mo6933K());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z */
        public void mo7328z(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.f4214g;
            if (recycledViewPool2 != null) {
                recycledViewPool2.mo7281b();
            }
            this.f4214g = recycledViewPool;
            if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                this.f4214g.mo7280a();
            }
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    public static abstract class SmoothScroller {

        /* renamed from: a */
        private int f4218a = -1;

        /* renamed from: b */
        private RecyclerView f4219b;

        /* renamed from: c */
        private LayoutManager f4220c;

        /* renamed from: d */
        private boolean f4221d;

        /* renamed from: e */
        private boolean f4222e;

        /* renamed from: f */
        private View f4223f;

        /* renamed from: g */
        private final Action f4224g = new Action(0, 0);

        /* renamed from: h */
        private boolean f4225h;

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;

            /* renamed from: a */
            private int f4226a;

            /* renamed from: b */
            private int f4227b;

            /* renamed from: c */
            private int f4228c;

            /* renamed from: d */
            private int f4229d;

            /* renamed from: e */
            private Interpolator f4230e;

            /* renamed from: f */
            private boolean f4231f;

            /* renamed from: g */
            private int f4232g;

            public Action(@C0129Px int i, @C0129Px int i2) {
                this(i, i2, Integer.MIN_VALUE, (Interpolator) null);
            }

            /* renamed from: c */
            private void m3188c() {
                if (this.f4230e != null && this.f4228c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f4228c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo7352a() {
                return this.f4229d >= 0;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public void mo7353b(RecyclerView recyclerView) {
                int i = this.f4229d;
                if (i >= 0) {
                    this.f4229d = -1;
                    recyclerView.mo6971g0(i);
                    this.f4231f = false;
                } else if (this.f4231f) {
                    m3188c();
                    Interpolator interpolator = this.f4230e;
                    if (interpolator == null) {
                        int i2 = this.f4228c;
                        if (i2 == Integer.MIN_VALUE) {
                            recyclerView.f4128e0.mo7457g(this.f4226a, this.f4227b);
                        } else {
                            recyclerView.f4128e0.mo7458h(this.f4226a, this.f4227b, i2);
                        }
                    } else {
                        recyclerView.f4128e0.mo7460j(this.f4226a, this.f4227b, this.f4228c, interpolator);
                    }
                    int i3 = this.f4232g + 1;
                    this.f4232g = i3;
                    if (i3 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f4231f = false;
                } else {
                    this.f4232g = 0;
                }
            }

            public int getDuration() {
                return this.f4228c;
            }

            @C0129Px
            public int getDx() {
                return this.f4226a;
            }

            @C0129Px
            public int getDy() {
                return this.f4227b;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.f4230e;
            }

            public void jumpTo(int i) {
                this.f4229d = i;
            }

            public void setDuration(int i) {
                this.f4231f = true;
                this.f4228c = i;
            }

            public void setDx(@C0129Px int i) {
                this.f4231f = true;
                this.f4226a = i;
            }

            public void setDy(@C0129Px int i) {
                this.f4231f = true;
                this.f4227b = i;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.f4231f = true;
                this.f4230e = interpolator;
            }

            public void update(@C0129Px int i, @C0129Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.f4226a = i;
                this.f4227b = i2;
                this.f4228c = i3;
                this.f4230e = interpolator;
                this.f4231f = true;
            }

            public Action(@C0129Px int i, @C0129Px int i2, int i3) {
                this(i, i2, i3, (Interpolator) null);
            }

            public Action(@C0129Px int i, @C0129Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.f4229d = -1;
                this.f4231f = false;
                this.f4232g = 0;
                this.f4226a = i;
                this.f4227b = i2;
                this.f4228c = i3;
                this.f4230e = interpolator;
            }
        }

        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7337a(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.f4219b;
            if (!this.f4222e || this.f4218a == -1 || recyclerView == null) {
                stop();
            }
            if (this.f4221d && this.f4223f == null && this.f4220c != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.f4218a)) != null) {
                float f = computeScrollVectorForPosition.x;
                if (!(f == 0.0f && computeScrollVectorForPosition.y == 0.0f)) {
                    recyclerView.mo6929H0((int) Math.signum(f), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
                }
            }
            this.f4221d = false;
            View view = this.f4223f;
            if (view != null) {
                if (getChildPosition(view) == this.f4218a) {
                    onTargetFound(this.f4223f, recyclerView.f4134h0, this.f4224g);
                    this.f4224g.mo7353b(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f4223f = null;
                }
            }
            if (this.f4222e) {
                onSeekTargetStep(i, i2, recyclerView.f4134h0, this.f4224g);
                boolean a = this.f4224g.mo7352a();
                this.f4224g.mo7353b(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f4222e) {
                    this.f4221d = true;
                    recyclerView.f4128e0.mo7456f();
                    return;
                }
                stop();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7338b(RecyclerView recyclerView, LayoutManager layoutManager) {
            if (this.f4225h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started " + "more than once. Each instance of" + getClass().getSimpleName() + " " + "is intended to only be used once. You should create a new instance for " + "each use.");
            }
            this.f4219b = recyclerView;
            this.f4220c = layoutManager;
            int i = this.f4218a;
            if (i != -1) {
                recyclerView.f4134h0.f4233a = i;
                this.f4222e = true;
                this.f4221d = true;
                this.f4223f = findViewByPosition(getTargetPosition());
                onStart();
                this.f4219b.f4128e0.mo7456f();
                this.f4225h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.f4219b.f4143m.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.f4219b.f4143m.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.f4219b.getChildLayoutPosition(view);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.f4220c;
        }

        public int getTargetPosition() {
            return this.f4218a;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.f4219b.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.f4221d;
        }

        public boolean isRunning() {
            return this.f4222e;
        }

        /* access modifiers changed from: protected */
        public void normalize(@NonNull PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.f4223f = view;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(@C0129Px int i, @C0129Px int i2, @NonNull State state, @NonNull Action action);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void setTargetPosition(int i) {
            this.f4218a = i;
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.f4222e) {
                this.f4222e = false;
                onStop();
                this.f4219b.f4134h0.f4233a = -1;
                this.f4223f = null;
                this.f4218a = -1;
                this.f4221d = false;
                this.f4220c.mo7213k(this);
                this.f4220c = null;
                this.f4219b = null;
            }
        }
    }

    public static class State {

        /* renamed from: a */
        int f4233a = -1;

        /* renamed from: b */
        private SparseArray<Object> f4234b;

        /* renamed from: c */
        int f4235c = 0;

        /* renamed from: d */
        int f4236d = 0;

        /* renamed from: e */
        int f4237e = 1;

        /* renamed from: f */
        int f4238f = 0;

        /* renamed from: g */
        boolean f4239g = false;

        /* renamed from: h */
        boolean f4240h = false;

        /* renamed from: i */
        boolean f4241i = false;

        /* renamed from: j */
        boolean f4242j = false;

        /* renamed from: k */
        boolean f4243k = false;

        /* renamed from: l */
        boolean f4244l = false;

        /* renamed from: m */
        int f4245m;

        /* renamed from: n */
        long f4246n;

        /* renamed from: o */
        int f4247o;

        /* renamed from: p */
        int f4248p;

        /* renamed from: q */
        int f4249q;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7364a(int i) {
            if ((this.f4237e & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f4237e));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7365b(Adapter adapter) {
            this.f4237e = 1;
            this.f4238f = adapter.getItemCount();
            this.f4240h = false;
            this.f4241i = false;
            this.f4242j = false;
        }

        public boolean didStructureChange() {
            return this.f4239g;
        }

        public <T> T get(int i) {
            SparseArray<Object> sparseArray = this.f4234b;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }

        public int getItemCount() {
            return this.f4240h ? this.f4235c - this.f4236d : this.f4238f;
        }

        public int getRemainingScrollHorizontal() {
            return this.f4248p;
        }

        public int getRemainingScrollVertical() {
            return this.f4249q;
        }

        public int getTargetScrollPosition() {
            return this.f4233a;
        }

        public boolean hasTargetScrollPosition() {
            return this.f4233a != -1;
        }

        public boolean isMeasuring() {
            return this.f4242j;
        }

        public boolean isPreLayout() {
            return this.f4240h;
        }

        public void put(int i, Object obj) {
            if (this.f4234b == null) {
                this.f4234b = new SparseArray<>();
            }
            this.f4234b.put(i, obj);
        }

        public void remove(int i) {
            SparseArray<Object> sparseArray = this.f4234b;
            if (sparseArray != null) {
                sparseArray.remove(i);
            }
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4233a + ", mData=" + this.f4234b + ", mItemCount=" + this.f4238f + ", mIsMeasuring=" + this.f4242j + ", mPreviousLayoutItemCount=" + this.f4235c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4236d + ", mStructureChanged=" + this.f4239g + ", mInPreLayout=" + this.f4240h + ", mRunSimpleAnimations=" + this.f4243k + ", mRunPredictiveAnimations=" + this.f4244l + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.f4244l;
        }

        public boolean willRunSimpleAnimations() {
            return this.f4243k;
        }
    }

    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i, int i2);
    }

    public static abstract class ViewHolder {

        /* renamed from: r */
        private static final List<Object> f4250r = Collections.emptyList();

        /* renamed from: a */
        WeakReference<RecyclerView> f4251a;

        /* renamed from: b */
        int f4252b = -1;

        /* renamed from: c */
        int f4253c = -1;

        /* renamed from: d */
        long f4254d = -1;

        /* renamed from: e */
        int f4255e = -1;

        /* renamed from: f */
        int f4256f = -1;

        /* renamed from: g */
        ViewHolder f4257g = null;

        /* renamed from: h */
        ViewHolder f4258h = null;

        /* renamed from: i */
        int f4259i;
        @NonNull
        public final View itemView;

        /* renamed from: j */
        List<Object> f4260j = null;

        /* renamed from: k */
        List<Object> f4261k = null;

        /* renamed from: l */
        private int f4262l = 0;

        /* renamed from: m */
        Recycler f4263m = null;

        /* renamed from: n */
        boolean f4264n = false;

        /* renamed from: o */
        private int f4265o = 0;
        @VisibleForTesting

        /* renamed from: p */
        int f4266p = -1;

        /* renamed from: q */
        RecyclerView f4267q;

        public ViewHolder(@NonNull View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* renamed from: g */
        private void m3193g() {
            if (this.f4260j == null) {
                ArrayList arrayList = new ArrayList();
                this.f4260j = arrayList;
                this.f4261k = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: A */
        public boolean mo7381A() {
            return (this.f4259i & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public boolean mo7382B() {
            return (this.f4259i & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: C */
        public void mo7383C() {
            this.f4259i &= -129;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: D */
        public void mo7384D() {
            this.f4263m.mo7295D(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: E */
        public boolean mo7385E() {
            return (this.f4259i & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7386a(Object obj) {
            if (obj == null) {
                mo7387b(1024);
            } else if ((1024 & this.f4259i) == 0) {
                m3193g();
                this.f4260j.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7387b(int i) {
            this.f4259i = i | this.f4259i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo7388c() {
            this.f4253c = -1;
            this.f4256f = -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7389d() {
            List<Object> list = this.f4260j;
            if (list != null) {
                list.clear();
            }
            this.f4259i &= -1025;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo7390e() {
            this.f4259i &= -33;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo7391f() {
            this.f4259i &= -257;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.f4267q;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.mo6940Q(this);
        }

        public final long getItemId() {
            return this.f4254d;
        }

        public final int getItemViewType() {
            return this.f4255e;
        }

        public final int getLayoutPosition() {
            int i = this.f4256f;
            return i == -1 ? this.f4252b : i;
        }

        public final int getOldPosition() {
            return this.f4253c;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.f4256f;
            return i == -1 ? this.f4252b : i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public boolean mo7398h() {
            return (this.f4259i & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo7399i(int i, int i2, boolean z) {
            mo7387b(8);
            mo7412t(i2, z);
            this.f4252b = i;
        }

        public final boolean isRecyclable() {
            return (this.f4259i & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public List<Object> mo7401j() {
            if ((this.f4259i & 1024) != 0) {
                return f4250r;
            }
            List<Object> list = this.f4260j;
            if (list == null || list.size() == 0) {
                return f4250r;
            }
            return this.f4261k;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean mo7402k(int i) {
            return (i & this.f4259i) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public boolean mo7403l() {
            return (this.f4259i & 512) != 0 || mo7405n();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public boolean mo7404m() {
            return (this.f4259i & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public boolean mo7405n() {
            return (this.f4259i & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public boolean mo7406o() {
            return (this.f4259i & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public boolean mo7407p() {
            return this.f4263m != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public boolean mo7408q() {
            return (this.f4259i & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public boolean mo7409r() {
            return (this.f4259i & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public boolean mo7410s() {
            return (this.f4259i & 2) != 0;
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.f4262l;
            int i2 = z ? i - 1 : i + 1;
            this.f4262l = i2;
            if (i2 < 0) {
                this.f4262l = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.f4259i |= 16;
            } else if (z && i2 == 0) {
                this.f4259i &= -17;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public void mo7412t(int i, boolean z) {
            if (this.f4253c == -1) {
                this.f4253c = this.f4252b;
            }
            if (this.f4256f == -1) {
                this.f4256f = this.f4252b;
            }
            if (z) {
                this.f4256f += i;
            }
            this.f4252b += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f4200c = true;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f4252b + " id=" + this.f4254d + ", oldPos=" + this.f4253c + ", pLpos:" + this.f4256f);
            if (mo7407p()) {
                sb.append(" scrap ");
                sb.append(this.f4264n ? "[changeScrap]" : "[attachedScrap]");
            }
            if (mo7405n()) {
                sb.append(" invalid");
            }
            if (!mo7404m()) {
                sb.append(" unbound");
            }
            if (mo7410s()) {
                sb.append(" update");
            }
            if (mo7406o()) {
                sb.append(" removed");
            }
            if (mo7382B()) {
                sb.append(" ignored");
            }
            if (mo7408q()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.f4262l + ")");
            }
            if (mo7403l()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public void mo7414u(RecyclerView recyclerView) {
            int i = this.f4266p;
            if (i != -1) {
                this.f4265o = i;
            } else {
                this.f4265o = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.mo6932J0(this, 4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public void mo7415v(RecyclerView recyclerView) {
            recyclerView.mo6932J0(this, this.f4265o);
            this.f4265o = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public void mo7416w() {
            this.f4259i = 0;
            this.f4252b = -1;
            this.f4253c = -1;
            this.f4254d = -1;
            this.f4256f = -1;
            this.f4262l = 0;
            this.f4257g = null;
            this.f4258h = null;
            mo7389d();
            this.f4265o = 0;
            this.f4266p = -1;
            RecyclerView.m3039n(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: x */
        public void mo7417x() {
            if (this.f4253c == -1) {
                this.f4253c = this.f4252b;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public void mo7418y(int i, int i2) {
            this.f4259i = (i & i2) | (this.f4259i & (i2 ^ -1));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z */
        public void mo7419z(Recycler recycler, boolean z) {
            this.f4263m = recycler;
            this.f4264n = z;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a */
    class C0912a implements Runnable {
        C0912a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f4159u && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.f4153r) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.f4165x) {
                    recyclerView2.f4163w = true;
                } else {
                    recyclerView2.mo7037q();
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b */
    class C0913b implements Runnable {
        C0913b() {
        }

        public void run() {
            ItemAnimator itemAnimator = RecyclerView.this.f4108M;
            if (itemAnimator != null) {
                itemAnimator.runPendingAnimations();
            }
            RecyclerView.this.f4146n0 = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c */
    static class C0914c implements Interpolator {
        C0914c() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$d */
    class C0915d implements C0958j.C0960b {
        C0915d() {
        }

        /* renamed from: a */
        public void mo7423a(ViewHolder viewHolder) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4143m.removeAndRecycleView(viewHolder.itemView, recyclerView.f4121b);
        }

        /* renamed from: b */
        public void mo7424b(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            RecyclerView.this.mo6970g(viewHolder, itemHolderInfo, itemHolderInfo2);
        }

        /* renamed from: c */
        public void mo7425c(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            RecyclerView.this.f4121b.mo7295D(viewHolder);
            RecyclerView.this.mo7001i(viewHolder, itemHolderInfo, itemHolderInfo2);
        }

        /* renamed from: d */
        public void mo7426d(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            viewHolder.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f4099D) {
                if (recyclerView.f4108M.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.mo7038q0();
                }
            } else if (recyclerView.f4108M.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                RecyclerView.this.mo7038q0();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$e */
    class C0916e implements C0934b.C0936b {
        C0916e() {
        }

        /* renamed from: a */
        public View mo7427a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        public void addView(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.mo7078u(view);
        }

        /* renamed from: b */
        public void mo7429b(View view) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (S != null) {
                S.mo7414u(RecyclerView.this);
            }
        }

        /* renamed from: c */
        public int mo7430c() {
            return RecyclerView.this.getChildCount();
        }

        /* renamed from: d */
        public void mo7431d() {
            int c = mo7430c();
            for (int i = 0; i < c; i++) {
                View a = mo7427a(i);
                RecyclerView.this.mo7079v(a);
                a.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        /* renamed from: e */
        public int mo7432e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        /* renamed from: f */
        public ViewHolder mo7433f(View view) {
            return RecyclerView.m3023S(view);
        }

        /* renamed from: g */
        public void mo7434g(int i) {
            ViewHolder S;
            View a = mo7427a(i);
            if (!(a == null || (S = RecyclerView.m3023S(a)) == null)) {
                if (!S.mo7408q() || S.mo7382B()) {
                    S.mo7387b(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + S + RecyclerView.this.mo6933K());
                }
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        /* renamed from: h */
        public void mo7435h(View view) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (S != null) {
                S.mo7415v(RecyclerView.this);
            }
        }

        /* renamed from: i */
        public void mo7436i(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.mo7079v(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        /* renamed from: j */
        public void mo7437j(View view, int i, ViewGroup.LayoutParams layoutParams) {
            ViewHolder S = RecyclerView.m3023S(view);
            if (S != null) {
                if (S.mo7408q() || S.mo7382B()) {
                    S.mo7391f();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + S + RecyclerView.this.mo6933K());
                }
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$f */
    class C0917f implements C0931a.C0932a {
        C0917f() {
        }

        /* renamed from: a */
        public void mo7438a(int i, int i2) {
            RecyclerView.this.mo7011k0(i, i2);
            RecyclerView.this.f4140k0 = true;
        }

        /* renamed from: b */
        public void mo7439b(C0931a.C0933b bVar) {
            mo7446i(bVar);
        }

        /* renamed from: c */
        public void mo7440c(int i, int i2, Object obj) {
            RecyclerView.this.mo6938O0(i, i2, obj);
            RecyclerView.this.f4142l0 = true;
        }

        /* renamed from: d */
        public void mo7441d(C0931a.C0933b bVar) {
            mo7446i(bVar);
        }

        /* renamed from: e */
        public ViewHolder mo7442e(int i) {
            ViewHolder P = RecyclerView.this.mo6939P(i, true);
            if (P != null && !RecyclerView.this.f4127e.mo7653n(P.itemView)) {
                return P;
            }
            return null;
        }

        /* renamed from: f */
        public void mo7443f(int i, int i2) {
            RecyclerView.this.mo7013l0(i, i2, false);
            RecyclerView.this.f4140k0 = true;
        }

        /* renamed from: g */
        public void mo7444g(int i, int i2) {
            RecyclerView.this.mo7009j0(i, i2);
            RecyclerView.this.f4140k0 = true;
        }

        /* renamed from: h */
        public void mo7445h(int i, int i2) {
            RecyclerView.this.mo7013l0(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4140k0 = true;
            recyclerView.f4134h0.f4236d += i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo7446i(C0931a.C0933b bVar) {
            int i = bVar.f4379a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f4143m.onItemsAdded(recyclerView, bVar.f4380b, bVar.f4382d);
            } else if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f4143m.onItemsRemoved(recyclerView2, bVar.f4380b, bVar.f4382d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f4143m.onItemsUpdated(recyclerView3, bVar.f4380b, bVar.f4382d, bVar.f4381c);
            } else if (i == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f4143m.onItemsMoved(recyclerView4, bVar.f4380b, bVar.f4382d, 1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$g */
    static class C0918g extends Observable<AdapterDataObserver> {
        C0918g() {
        }

        /* renamed from: a */
        public boolean mo7447a() {
            return !this.mObservers.isEmpty();
        }

        /* renamed from: b */
        public void mo7448b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        /* renamed from: c */
        public void mo7449c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        /* renamed from: d */
        public void mo7450d(int i, int i2) {
            mo7451e(i, i2, (Object) null);
        }

        /* renamed from: e */
        public void mo7451e(int i, int i2, @Nullable Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        /* renamed from: f */
        public void mo7452f(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        /* renamed from: g */
        public void mo7453g(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$h */
    private class C0919h implements ItemAnimator.C0907a {
        C0919h() {
        }

        /* renamed from: a */
        public void mo7145a(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.f4257g != null && viewHolder.f4258h == null) {
                viewHolder.f4257g = null;
            }
            viewHolder.f4258h = null;
            if (!viewHolder.mo7381A() && !RecyclerView.this.mo7083z0(viewHolder.itemView) && viewHolder.mo7408q()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$i */
    private class C0920i extends AdapterDataObserver {
        C0920i() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7454a() {
            if (RecyclerView.f4089D0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f4155s && recyclerView.f4153r) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.f4133h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f4096A = true;
            recyclerView2.requestLayout();
        }

        public void onChanged() {
            RecyclerView.this.mo7010k((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4134h0.f4239g = true;
            recyclerView.mo7077t0(true);
            if (!RecyclerView.this.f4125d.mo7629p()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.mo7010k((String) null);
            if (RecyclerView.this.f4125d.mo7631r(i, i2, obj)) {
                mo7454a();
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.mo7010k((String) null);
            if (RecyclerView.this.f4125d.mo7632s(i, i2)) {
                mo7454a();
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.mo7010k((String) null);
            if (RecyclerView.this.f4125d.mo7633t(i, i2, i3)) {
                mo7454a();
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.mo7010k((String) null);
            if (RecyclerView.this.f4125d.mo7634u(i, i2)) {
                mo7454a();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$j */
    class C0921j implements Runnable {

        /* renamed from: a */
        private int f4275a;

        /* renamed from: b */
        private int f4276b;

        /* renamed from: c */
        OverScroller f4277c;

        /* renamed from: d */
        Interpolator f4278d;

        /* renamed from: e */
        private boolean f4279e = false;

        /* renamed from: f */
        private boolean f4280f = false;

        C0921j() {
            Interpolator interpolator = RecyclerView.f4094I0;
            this.f4278d = interpolator;
            this.f4277c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        /* renamed from: a */
        private int m3256a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = (float) width;
            float f2 = (float) i6;
            float c = f2 + (m3258c(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(c / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, AdError.SERVER_ERROR_CODE);
        }

        /* renamed from: b */
        private void m3257b() {
            this.f4280f = false;
            this.f4279e = true;
        }

        /* renamed from: c */
        private float m3258c(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* renamed from: d */
        private void m3259d() {
            this.f4279e = false;
            if (this.f4280f) {
                mo7456f();
            }
        }

        /* renamed from: e */
        public void mo7455e(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f4276b = 0;
            this.f4275a = 0;
            this.f4277c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            mo7456f();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo7456f() {
            if (this.f4279e) {
                this.f4280f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        /* renamed from: g */
        public void mo7457g(int i, int i2) {
            mo7459i(i, i2, 0, 0);
        }

        /* renamed from: h */
        public void mo7458h(int i, int i2, int i3) {
            mo7460j(i, i2, i3, RecyclerView.f4094I0);
        }

        /* renamed from: i */
        public void mo7459i(int i, int i2, int i3, int i4) {
            mo7458h(i, i2, m3256a(i, i2, i3, i4));
        }

        /* renamed from: j */
        public void mo7460j(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f4278d != interpolator) {
                this.f4278d = interpolator;
                this.f4277c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f4276b = 0;
            this.f4275a = 0;
            this.f4277c.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4277c.computeScrollOffset();
            }
            mo7456f();
        }

        /* renamed from: k */
        public void mo7461k(int i, int i2, Interpolator interpolator) {
            int a = m3256a(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f4094I0;
            }
            mo7460j(i, i2, a, interpolator);
        }

        /* renamed from: l */
        public void mo7462l() {
            RecyclerView.this.removeCallbacks(this);
            this.f4277c.abortAnimation();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
            if (r8 > 0) goto L_0x00ef;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00f7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r0 = r22
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r1.f4143m
                if (r1 != 0) goto L_0x000c
                r22.mo7462l()
                return
            L_0x000c:
                r22.m3257b()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.mo7037q()
                android.widget.OverScroller r1 = r0.f4277c
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.f4143m
                androidx.recyclerview.widget.RecyclerView$SmoothScroller r2 = r2.f4184g
                boolean r3 = r1.computeScrollOffset()
                r4 = 0
                if (r3 == 0) goto L_0x018b
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.f4158t0
                int r11 = r1.getCurrX()
                int r12 = r1.getCurrY()
                int r5 = r0.f4275a
                int r13 = r11 - r5
                int r5 = r0.f4276b
                int r14 = r12 - r5
                r0.f4275a = r11
                r0.f4276b = r12
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                r9 = 0
                r10 = 1
                r6 = r13
                r7 = r14
                r8 = r3
                boolean r5 = r5.dispatchNestedPreScroll(r6, r7, r8, r9, r10)
                r6 = 1
                if (r5 == 0) goto L_0x004f
                r5 = r3[r4]
                int r13 = r13 - r5
                r3 = r3[r6]
                int r14 = r14 - r3
            L_0x004f:
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r5 = r3.f4141l
                if (r5 == 0) goto L_0x009c
                int[] r5 = r3.f4162v0
                r3.mo6929H0(r13, r14, r5)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.f4162v0
                r5 = r3[r4]
                r3 = r3[r6]
                int r7 = r13 - r5
                int r8 = r14 - r3
                if (r2 == 0) goto L_0x00a0
                boolean r9 = r2.isPendingInitialRun()
                if (r9 != 0) goto L_0x00a0
                boolean r9 = r2.isRunning()
                if (r9 == 0) goto L_0x00a0
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r9 = r9.f4134h0
                int r9 = r9.getItemCount()
                if (r9 != 0) goto L_0x0082
                r2.stop()
                goto L_0x00a0
            L_0x0082:
                int r10 = r2.getTargetPosition()
                if (r10 < r9) goto L_0x0094
                int r9 = r9 - r6
                r2.setTargetPosition(r9)
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.mo7337a(r9, r10)
                goto L_0x00a0
            L_0x0094:
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.mo7337a(r9, r10)
                goto L_0x00a0
            L_0x009c:
                r3 = 0
                r5 = 0
                r7 = 0
                r8 = 0
            L_0x00a0:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ItemDecoration> r9 = r9.f4147o
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L_0x00af
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.invalidate()
            L_0x00af:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                int r9 = r9.getOverScrollMode()
                r10 = 2
                if (r9 == r10) goto L_0x00bd
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.mo7036p(r13, r14)
            L_0x00bd:
                androidx.recyclerview.widget.RecyclerView r15 = androidx.recyclerview.widget.RecyclerView.this
                r20 = 0
                r21 = 1
                r16 = r5
                r17 = r3
                r18 = r7
                r19 = r8
                boolean r9 = r15.dispatchNestedScroll(r16, r17, r18, r19, r20, r21)
                if (r9 != 0) goto L_0x0113
                if (r7 != 0) goto L_0x00d5
                if (r8 == 0) goto L_0x0113
            L_0x00d5:
                float r9 = r1.getCurrVelocity()
                int r9 = (int) r9
                if (r7 == r11) goto L_0x00e4
                if (r7 >= 0) goto L_0x00e0
                int r15 = -r9
                goto L_0x00e5
            L_0x00e0:
                if (r7 <= 0) goto L_0x00e4
                r15 = r9
                goto L_0x00e5
            L_0x00e4:
                r15 = 0
            L_0x00e5:
                if (r8 == r12) goto L_0x00ee
                if (r8 >= 0) goto L_0x00eb
                int r9 = -r9
                goto L_0x00ef
            L_0x00eb:
                if (r8 <= 0) goto L_0x00ee
                goto L_0x00ef
            L_0x00ee:
                r9 = 0
            L_0x00ef:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                int r4 = r4.getOverScrollMode()
                if (r4 == r10) goto L_0x00fc
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.mo6944a(r15, r9)
            L_0x00fc:
                if (r15 != 0) goto L_0x0106
                if (r7 == r11) goto L_0x0106
                int r4 = r1.getFinalX()
                if (r4 != 0) goto L_0x0113
            L_0x0106:
                if (r9 != 0) goto L_0x0110
                if (r8 == r12) goto L_0x0110
                int r4 = r1.getFinalY()
                if (r4 != 0) goto L_0x0113
            L_0x0110:
                r1.abortAnimation()
            L_0x0113:
                if (r5 != 0) goto L_0x0117
                if (r3 == 0) goto L_0x011c
            L_0x0117:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.mo6923E(r5, r3)
            L_0x011c:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                boolean r4 = r4.awakenScrollBars()
                if (r4 != 0) goto L_0x0129
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.invalidate()
            L_0x0129:
                if (r14 == 0) goto L_0x0139
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r4.f4143m
                boolean r4 = r4.canScrollVertically()
                if (r4 == 0) goto L_0x0139
                if (r3 != r14) goto L_0x0139
                r3 = 1
                goto L_0x013a
            L_0x0139:
                r3 = 0
            L_0x013a:
                if (r13 == 0) goto L_0x014a
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r4.f4143m
                boolean r4 = r4.canScrollHorizontally()
                if (r4 == 0) goto L_0x014a
                if (r5 != r13) goto L_0x014a
                r4 = 1
                goto L_0x014b
            L_0x014a:
                r4 = 0
            L_0x014b:
                if (r13 != 0) goto L_0x014f
                if (r14 == 0) goto L_0x0156
            L_0x014f:
                if (r4 != 0) goto L_0x0156
                if (r3 == 0) goto L_0x0154
                goto L_0x0156
            L_0x0154:
                r3 = 0
                goto L_0x0157
            L_0x0156:
                r3 = 1
            L_0x0157:
                boolean r1 = r1.isFinished()
                if (r1 != 0) goto L_0x0175
                if (r3 != 0) goto L_0x0168
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                boolean r1 = r1.hasNestedScrollingParent(r6)
                if (r1 != 0) goto L_0x0168
                goto L_0x0175
            L_0x0168:
                r22.mo7456f()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.d r3 = r1.f4130f0
                if (r3 == 0) goto L_0x018b
                r3.mo7681f(r1, r13, r14)
                goto L_0x018b
            L_0x0175:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r3 = 0
                r1.setScrollState(r3)
                boolean r1 = androidx.recyclerview.widget.RecyclerView.f4090E0
                if (r1 == 0) goto L_0x0186
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.d$b r1 = r1.f4132g0
                r1.mo7687a()
            L_0x0186:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.stopNestedScroll(r6)
            L_0x018b:
                if (r2 == 0) goto L_0x019e
                boolean r1 = r2.isPendingInitialRun()
                if (r1 == 0) goto L_0x0197
                r1 = 0
                r2.mo7337a(r1, r1)
            L_0x0197:
                boolean r1 = r0.f4280f
                if (r1 != 0) goto L_0x019e
                r2.stop()
            L_0x019e:
                r22.m3259d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C0921j.run():void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 16843830(0x1010436, float:2.369658E-38)
            r3 = 0
            r1[r3] = r2
            f4095z0 = r1
            int[] r1 = new int[r0]
            r2 = 16842987(0x10100eb, float:2.3694217E-38)
            r1[r3] = r2
            f4086A0 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 18
            if (r1 == r2) goto L_0x0025
            r2 = 19
            if (r1 == r2) goto L_0x0025
            r2 = 20
            if (r1 != r2) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r2 = 0
            goto L_0x0026
        L_0x0025:
            r2 = 1
        L_0x0026:
            f4087B0 = r2
            r2 = 23
            if (r1 < r2) goto L_0x002e
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            f4088C0 = r2
            r2 = 16
            if (r1 < r2) goto L_0x0037
            r2 = 1
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            f4089D0 = r2
            r2 = 21
            if (r1 < r2) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            f4090E0 = r2
            r2 = 15
            if (r1 > r2) goto L_0x0049
            r4 = 1
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            f4091F0 = r4
            if (r1 > r2) goto L_0x0050
            r1 = 1
            goto L_0x0051
        L_0x0050:
            r1 = 0
        L_0x0051:
            f4092G0 = r1
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r3] = r2
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            r0 = 2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r1[r0] = r2
            r0 = 3
            r1[r0] = r2
            f4093H0 = r1
            androidx.recyclerview.widget.RecyclerView$c r0 = new androidx.recyclerview.widget.RecyclerView$c
            r0.<init>()
            f4094I0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: A */
    private void m3011A() {
        this.f4134h0.mo7364a(4);
        mo6936L0();
        mo7014m0();
        State state = this.f4134h0;
        state.f4237e = 1;
        if (state.f4243k) {
            for (int g = this.f4127e.mo7648g() - 1; g >= 0; g--) {
                ViewHolder S = m3023S(this.f4127e.mo7647f(g));
                if (!S.mo7382B()) {
                    long R = mo6941R(S);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.f4108M.recordPostLayoutInformation(this.f4134h0, S);
                    ViewHolder g2 = this.f4129f.mo7711g(R);
                    if (g2 == null || g2.mo7382B()) {
                        this.f4129f.mo7708d(S, recordPostLayoutInformation);
                    } else {
                        boolean h = this.f4129f.mo7712h(g2);
                        boolean h2 = this.f4129f.mo7712h(S);
                        if (!h || g2 != S) {
                            ItemAnimator.ItemHolderInfo n = this.f4129f.mo7717n(g2);
                            this.f4129f.mo7708d(S, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo m = this.f4129f.mo7716m(S);
                            if (n == null) {
                                m3027X(R, S, g2);
                            } else {
                                m3037h(g2, S, n, m, h, h2);
                            }
                        } else {
                            this.f4129f.mo7708d(S, recordPostLayoutInformation);
                        }
                    }
                }
            }
            this.f4129f.mo7718o(this.f4168y0);
        }
        this.f4143m.mo7221n(this.f4121b);
        State state2 = this.f4134h0;
        state2.f4235c = state2.f4238f;
        this.f4099D = false;
        this.f4100E = false;
        state2.f4243k = false;
        state2.f4244l = false;
        this.f4143m.f4185h = false;
        ArrayList<ViewHolder> arrayList = this.f4121b.f4209b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager.f4191n) {
            layoutManager.f4190m = 0;
            layoutManager.f4191n = false;
            this.f4121b.mo7296E();
        }
        this.f4143m.onLayoutCompleted(this.f4134h0);
        mo7015n0();
        mo6937M0(false);
        this.f4129f.mo7710f();
        int[] iArr = this.f4152q0;
        if (m3044t(iArr[0], iArr[1])) {
            mo6923E(0, 0);
        }
        m3047w0();
        m3015C0();
    }

    /* renamed from: B */
    private boolean m3012B(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        OnItemTouchListener onItemTouchListener = this.f4151q;
        if (onItemTouchListener != null) {
            if (action == 0) {
                this.f4151q = null;
            } else {
                onItemTouchListener.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f4151q = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f4149p.size();
            for (int i = 0; i < size; i++) {
                OnItemTouchListener onItemTouchListener2 = this.f4149p.get(i);
                if (onItemTouchListener2.onInterceptTouchEvent(this, motionEvent)) {
                    this.f4151q = onItemTouchListener2;
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: B0 */
    private void m3013B0(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f4135i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f4200c) {
                Rect rect = layoutParams2.f4199b;
                Rect rect2 = this.f4135i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f4135i);
            offsetRectIntoDescendantCoords(view, this.f4135i);
        }
        this.f4143m.requestChildRectangleOnScreen(this, view, this.f4135i, !this.f4159u, view2 == null);
    }

    /* renamed from: C */
    private boolean m3014C(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f4151q = null;
        }
        int size = this.f4149p.size();
        int i = 0;
        while (i < size) {
            OnItemTouchListener onItemTouchListener = this.f4149p.get(i);
            if (!onItemTouchListener.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f4151q = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    /* renamed from: C0 */
    private void m3015C0() {
        State state = this.f4134h0;
        state.f4246n = -1;
        state.f4245m = -1;
        state.f4247o = -1;
    }

    /* renamed from: D0 */
    private void m3016D0() {
        VelocityTracker velocityTracker = this.f4111P;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        m3048x0();
    }

    /* renamed from: E0 */
    private void m3017E0() {
        int i;
        ViewHolder viewHolder = null;
        View focusedChild = (!this.f4126d0 || !hasFocus() || this.f4141l == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            viewHolder = findContainingViewHolder(focusedChild);
        }
        if (viewHolder == null) {
            m3015C0();
            return;
        }
        this.f4134h0.f4246n = this.f4141l.hasStableIds() ? viewHolder.getItemId() : -1;
        State state = this.f4134h0;
        if (this.f4099D) {
            i = -1;
        } else if (viewHolder.mo7406o()) {
            i = viewHolder.f4253c;
        } else {
            i = viewHolder.getAdapterPosition();
        }
        state.f4245m = i;
        this.f4134h0.f4247o = m3025U(viewHolder.itemView);
    }

    /* renamed from: I0 */
    private void m3018I0(@Nullable Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.f4141l;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f4119a);
            this.f4141l.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            mo7082y0();
        }
        this.f4125d.mo7637y();
        Adapter adapter3 = this.f4141l;
        this.f4141l = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f4119a);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.f4141l);
        }
        this.f4121b.mo7322t(adapter3, this.f4141l, z);
        this.f4134h0.f4239g = true;
    }

    /* renamed from: M */
    private void m3019M(int[] iArr) {
        int g = this.f4127e.mo7648g();
        if (g == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < g; i3++) {
            ViewHolder S = m3023S(this.f4127e.mo7647f(i3));
            if (!S.mo7382B()) {
                int layoutPosition = S.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    @Nullable
    /* renamed from: N */
    static RecyclerView m3020N(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView N = m3020N(viewGroup.getChildAt(i));
            if (N != null) {
                return N;
            }
        }
        return null;
    }

    /* renamed from: N0 */
    private void m3021N0() {
        this.f4128e0.mo7462l();
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.mo7263w();
        }
    }

    @Nullable
    /* renamed from: O */
    private View m3022O() {
        ViewHolder findViewHolderForAdapterPosition;
        State state = this.f4134h0;
        int i = state.f4245m;
        if (i == -1) {
            i = 0;
        }
        int itemCount = state.getItemCount();
        int i2 = i;
        while (i2 < itemCount) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i2++;
            }
        }
        int min = Math.min(itemCount, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    /* renamed from: S */
    static ViewHolder m3023S(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f4198a;
    }

    /* renamed from: T */
    static void m3024T(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f4199b;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    /* renamed from: U */
    private int m3025U(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* renamed from: V */
    private String m3026V(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    /* renamed from: X */
    private void m3027X(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int g = this.f4127e.mo7648g();
        for (int i = 0; i < g; i++) {
            ViewHolder S = m3023S(this.f4127e.mo7647f(i));
            if (S != viewHolder && mo6941R(S) == j) {
                Adapter adapter = this.f4141l;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + S + " \n View Holder 2:" + viewHolder + mo6933K());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + S + " \n View Holder 2:" + viewHolder + mo6933K());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + mo6933K());
    }

    /* renamed from: Y */
    private boolean m3028Y() {
        int g = this.f4127e.mo7648g();
        for (int i = 0; i < g; i++) {
            ViewHolder S = m3023S(this.f4127e.mo7647f(i));
            if (S != null && !S.mo7382B() && S.mo7409r()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a0 */
    private void m3029a0() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    /* renamed from: b0 */
    private void m3031b0() {
        this.f4127e = new C0934b(new C0916e());
    }

    /* renamed from: f */
    private void m3035f(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.f4121b.mo7295D(getChildViewHolder(view));
        if (viewHolder.mo7408q()) {
            this.f4127e.mo7644c(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.f4127e.mo7643b(view, true);
        } else {
            this.f4127e.mo7651k(view);
        }
    }

    /* renamed from: f0 */
    private boolean m3036f0(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.f4135i.set(0, 0, view.getWidth(), view.getHeight());
        this.f4137j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f4135i);
        offsetDescendantRectToMyCoords(view2, this.f4137j);
        char c = 65535;
        int i3 = this.f4143m.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.f4135i;
        int i4 = rect.left;
        Rect rect2 = this.f4137j;
        int i5 = rect2.left;
        if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
            i2 = 1;
        } else {
            int i6 = rect.right;
            int i7 = rect2.right;
            i2 = ((i6 > i7 || i4 >= i7) && i4 > i5) ? -1 : 0;
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
            c = 1;
        } else {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            if ((i10 <= i11 && i8 < i11) || i8 <= i9) {
                c = 0;
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i + mo6933K());
                            } else if (c > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i2 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i2 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c > 0 || (c == 0 && i2 * i3 >= 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c < 0 || (c == 0 && i2 * i3 <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f4154r0 == null) {
            this.f4154r0 = new NestedScrollingChildHelper(this);
        }
        return this.f4154r0;
    }

    /* renamed from: h */
    private void m3037h(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            m3035f(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                m3035f(viewHolder2);
            }
            viewHolder.f4257g = viewHolder2;
            m3035f(viewHolder);
            this.f4121b.mo7295D(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.f4258h = viewHolder;
        }
        if (this.f4108M.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            mo7038q0();
        }
    }

    /* renamed from: m */
    private void m3038m() {
        m3016D0();
        setScrollState(0);
    }

    /* renamed from: n */
    static void m3039n(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.f4251a;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view != viewHolder.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.f4251a = null;
        }
    }

    /* renamed from: p0 */
    private void m3040p0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4110O) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f4110O = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.f4114S = x;
            this.f4112Q = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f4115T = y;
            this.f4113R = y;
        }
    }

    /* renamed from: r */
    private void m3041r(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String V = m3026V(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(V).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(f4093H0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + V, e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + V, e3);
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + V, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + V, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + V, e6);
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + V, e7);
                }
            }
        }
    }

    /* renamed from: r0 */
    private boolean m3042r0() {
        return this.f4108M != null && this.f4143m.supportsPredictiveItemAnimations();
    }

    /* renamed from: s0 */
    private void m3043s0() {
        boolean z;
        if (this.f4099D) {
            this.f4125d.mo7637y();
            if (this.f4100E) {
                this.f4143m.onItemsChanged(this);
            }
        }
        if (m3042r0()) {
            this.f4125d.mo7635w();
        } else {
            this.f4125d.mo7624j();
        }
        boolean z2 = false;
        boolean z3 = this.f4140k0 || this.f4142l0;
        this.f4134h0.f4243k = this.f4159u && this.f4108M != null && ((z = this.f4099D) || z3 || this.f4143m.f4185h) && (!z || this.f4141l.hasStableIds());
        State state = this.f4134h0;
        if (state.f4243k && z3 && !this.f4099D && m3042r0()) {
            z2 = true;
        }
        state.f4244l = z2;
    }

    /* renamed from: t */
    private boolean m3044t(int i, int i2) {
        m3019M(this.f4152q0);
        int[] iArr = this.f4152q0;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: u0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3045u0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.mo6928H()
            android.widget.EdgeEffect r3 = r6.f4104I
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.EdgeEffectCompat.onPull(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.mo6930I()
            android.widget.EdgeEffect r3 = r6.f4106K
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.onPull(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.mo6931J()
            android.widget.EdgeEffect r9 = r6.f4105J
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.EdgeEffectCompat.onPull(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.mo6926G()
            android.widget.EdgeEffect r9 = r6.f4107L
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.EdgeEffectCompat.onPull(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m3045u0(float, float, float, float):void");
    }

    /* renamed from: w */
    private void m3046w() {
        int i = this.f4169z;
        this.f4169z = 0;
        if (i != 0 && mo6960e0()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    /* renamed from: w0 */
    private void m3047w0() {
        View findViewById;
        if (this.f4126d0 && this.f4141l != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!f4092G0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f4127e.mo7653n(focusedChild)) {
                            return;
                        }
                    } else if (this.f4127e.mo7648g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                ViewHolder findViewHolderForItemId = (this.f4134h0.f4246n == -1 || !this.f4141l.hasStableIds()) ? null : findViewHolderForItemId(this.f4134h0.f4246n);
                if (findViewHolderForItemId != null && !this.f4127e.mo7653n(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view = findViewHolderForItemId.itemView;
                } else if (this.f4127e.mo7648g() > 0) {
                    view = m3022O();
                }
                if (view != null) {
                    int i = this.f4134h0.f4247o;
                    if (!(((long) i) == -1 || (findViewById = view.findViewById(i)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    /* renamed from: x0 */
    private void m3048x0() {
        boolean z;
        EdgeEffect edgeEffect = this.f4104I;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.f4104I.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f4105J;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.f4105J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4106K;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.f4106K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4107L;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.f4107L.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: y */
    private void m3049y() {
        boolean z = true;
        this.f4134h0.mo7364a(1);
        mo6935L(this.f4134h0);
        this.f4134h0.f4242j = false;
        mo6936L0();
        this.f4129f.mo7710f();
        mo7014m0();
        m3043s0();
        m3017E0();
        State state = this.f4134h0;
        if (!state.f4243k || !this.f4142l0) {
            z = false;
        }
        state.f4241i = z;
        this.f4142l0 = false;
        this.f4140k0 = false;
        state.f4240h = state.f4244l;
        state.f4238f = this.f4141l.getItemCount();
        m3019M(this.f4152q0);
        if (this.f4134h0.f4243k) {
            int g = this.f4127e.mo7648g();
            for (int i = 0; i < g; i++) {
                ViewHolder S = m3023S(this.f4127e.mo7647f(i));
                if (!S.mo7382B() && (!S.mo7405n() || this.f4141l.hasStableIds())) {
                    this.f4129f.mo7709e(S, this.f4108M.recordPreLayoutInformation(this.f4134h0, S, ItemAnimator.m3104a(S), S.mo7401j()));
                    if (this.f4134h0.f4241i && S.mo7409r() && !S.mo7406o() && !S.mo7382B() && !S.mo7405n()) {
                        this.f4129f.mo7707c(mo6941R(S), S);
                    }
                }
            }
        }
        if (this.f4134h0.f4244l) {
            mo6925F0();
            State state2 = this.f4134h0;
            boolean z2 = state2.f4239g;
            state2.f4239g = false;
            this.f4143m.onLayoutChildren(this.f4121b, state2);
            this.f4134h0.f4239g = z2;
            for (int i2 = 0; i2 < this.f4127e.mo7648g(); i2++) {
                ViewHolder S2 = m3023S(this.f4127e.mo7647f(i2));
                if (!S2.mo7382B() && !this.f4129f.mo7713i(S2)) {
                    int a = ItemAnimator.m3104a(S2);
                    boolean k = S2.mo7402k(8192);
                    if (!k) {
                        a |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.f4108M.recordPreLayoutInformation(this.f4134h0, S2, a, S2.mo7401j());
                    if (k) {
                        mo7080v0(S2, recordPreLayoutInformation);
                    } else {
                        this.f4129f.mo7705a(S2, recordPreLayoutInformation);
                    }
                }
            }
            mo7016o();
        } else {
            mo7016o();
        }
        mo7015n0();
        mo6937M0(false);
        this.f4134h0.f4237e = 2;
    }

    /* renamed from: z */
    private void m3050z() {
        mo6936L0();
        mo7014m0();
        this.f4134h0.mo7364a(6);
        this.f4125d.mo7624j();
        this.f4134h0.f4238f = this.f4141l.getItemCount();
        State state = this.f4134h0;
        state.f4236d = 0;
        state.f4240h = false;
        this.f4143m.onLayoutChildren(this.f4121b, state);
        State state2 = this.f4134h0;
        state2.f4239g = false;
        this.f4123c = null;
        state2.f4243k = state2.f4243k && this.f4108M != null;
        state2.f4237e = 4;
        mo7015n0();
        mo6937M0(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A0 */
    public void mo6921A0() {
        ViewHolder viewHolder;
        int g = this.f4127e.mo7648g();
        for (int i = 0; i < g; i++) {
            View f = this.f4127e.mo7647f(i);
            ViewHolder childViewHolder = getChildViewHolder(f);
            if (!(childViewHolder == null || (viewHolder = childViewHolder.f4258h) == null)) {
                View view = viewHolder.itemView;
                int left = f.getLeft();
                int top = f.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public void mo6922D(int i) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.f4136i0;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.f4138j0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4138j0.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo6923E(int i, int i2) {
        this.f4102G++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.f4136i0;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.f4138j0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4138j0.get(size).onScrolled(this, i, i2);
            }
        }
        this.f4102G--;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void mo6924F() {
        int i;
        for (int size = this.f4164w0.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.f4164w0.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.mo7382B() && (i = viewHolder.f4266p) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                viewHolder.f4266p = -1;
            }
        }
        this.f4164w0.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F0 */
    public void mo6925F0() {
        int j = this.f4127e.mo7650j();
        for (int i = 0; i < j; i++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i));
            if (!S.mo7382B()) {
                S.mo7417x();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void mo6926G() {
        if (this.f4107L == null) {
            EdgeEffect createEdgeEffect = this.f4103H.createEdgeEffect(this, 3);
            this.f4107L = createEdgeEffect;
            if (this.f4131g) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G0 */
    public boolean mo6927G0(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        MotionEvent motionEvent2 = motionEvent;
        mo7037q();
        if (this.f4141l != null) {
            mo6929H0(i7, i8, this.f4162v0);
            int[] iArr = this.f4162v0;
            int i9 = iArr[0];
            int i10 = iArr[1];
            i5 = i10;
            i4 = i9;
            i3 = i7 - i9;
            i6 = i8 - i10;
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!this.f4147o.isEmpty()) {
            invalidate();
        }
        int i11 = i6;
        if (dispatchNestedScroll(i4, i5, i3, i6, this.f4156s0, 0)) {
            int i12 = this.f4114S;
            int[] iArr2 = this.f4156s0;
            this.f4114S = i12 - iArr2[0];
            this.f4115T -= iArr2[1];
            if (motionEvent2 != null) {
                motionEvent2.offsetLocation((float) iArr2[0], (float) iArr2[1]);
            }
            int[] iArr3 = this.f4160u0;
            int i13 = iArr3[0];
            int[] iArr4 = this.f4156s0;
            iArr3[0] = i13 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !MotionEventCompat.isFromSource(motionEvent2, 8194)) {
                m3045u0(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i11);
            }
            mo7036p(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            mo6923E(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public void mo6928H() {
        if (this.f4104I == null) {
            EdgeEffect createEdgeEffect = this.f4103H.createEdgeEffect(this, 0);
            this.f4104I = createEdgeEffect;
            if (this.f4131g) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H0 */
    public void mo6929H0(int i, int i2, @Nullable int[] iArr) {
        mo6936L0();
        mo7014m0();
        TraceCompat.beginSection("RV Scroll");
        mo6935L(this.f4134h0);
        int scrollHorizontallyBy = i != 0 ? this.f4143m.scrollHorizontallyBy(i, this.f4121b, this.f4134h0) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.f4143m.scrollVerticallyBy(i2, this.f4121b, this.f4134h0) : 0;
        TraceCompat.endSection();
        mo6921A0();
        mo7015n0();
        mo6937M0(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void mo6930I() {
        if (this.f4106K == null) {
            EdgeEffect createEdgeEffect = this.f4103H.createEdgeEffect(this, 2);
            this.f4106K = createEdgeEffect;
            if (this.f4131g) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public void mo6931J() {
        if (this.f4105J == null) {
            EdgeEffect createEdgeEffect = this.f4103H.createEdgeEffect(this, 1);
            this.f4105J = createEdgeEffect;
            if (this.f4131g) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: J0 */
    public boolean mo6932J0(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.f4266p = i;
            this.f4164w0.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public String mo6933K() {
        return " " + super.toString() + ", adapter:" + this.f4141l + ", layout:" + this.f4143m + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K0 */
    public boolean mo6934K0(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        if (contentChangeTypes != 0) {
            i = contentChangeTypes;
        }
        this.f4169z |= i;
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public final void mo6935L(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f4128e0.f4277c;
            state.f4248p = overScroller.getFinalX() - overScroller.getCurrX();
            state.f4249q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.f4248p = 0;
        state.f4249q = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L0 */
    public void mo6936L0() {
        int i = this.f4161v + 1;
        this.f4161v = i;
        if (i == 1 && !this.f4165x) {
            this.f4163w = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M0 */
    public void mo6937M0(boolean z) {
        if (this.f4161v < 1) {
            this.f4161v = 1;
        }
        if (!z && !this.f4165x) {
            this.f4163w = false;
        }
        if (this.f4161v == 1) {
            if (z && this.f4163w && !this.f4165x && this.f4143m != null && this.f4141l != null) {
                mo7081x();
            }
            if (!this.f4165x) {
                this.f4163w = false;
            }
        }
        this.f4161v--;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O0 */
    public void mo6938O0(int i, int i2, Object obj) {
        int i3;
        int j = this.f4127e.mo7650j();
        int i4 = i + i2;
        for (int i5 = 0; i5 < j; i5++) {
            View i6 = this.f4127e.mo7649i(i5);
            ViewHolder S = m3023S(i6);
            if (S != null && !S.mo7382B() && (i3 = S.f4252b) >= i && i3 < i4) {
                S.mo7387b(2);
                S.mo7386a(obj);
                ((LayoutParams) i6.getLayoutParams()).f4200c = true;
            }
        }
        this.f4121b.mo7298G(i, i2);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: P */
    public ViewHolder mo6939P(int i, boolean z) {
        int j = this.f4127e.mo7650j();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < j; i2++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i2));
            if (S != null && !S.mo7406o()) {
                if (z) {
                    if (S.f4252b != i) {
                        continue;
                    }
                } else if (S.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.f4127e.mo7653n(S.itemView)) {
                    return S;
                }
                viewHolder = S;
            }
        }
        return viewHolder;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Q */
    public int mo6940Q(ViewHolder viewHolder) {
        if (viewHolder.mo7402k(524) || !viewHolder.mo7404m()) {
            return -1;
        }
        return this.f4125d.mo7622e(viewHolder.f4252b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: R */
    public long mo6941R(ViewHolder viewHolder) {
        return this.f4141l.hasStableIds() ? viewHolder.getItemId() : (long) viewHolder.f4252b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: W */
    public Rect mo6942W(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f4200c) {
            return layoutParams.f4199b;
        }
        if (this.f4134h0.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.f4199b;
        }
        Rect rect = layoutParams.f4199b;
        rect.set(0, 0, 0, 0);
        int size = this.f4147o.size();
        for (int i = 0; i < size; i++) {
            this.f4135i.set(0, 0, 0, 0);
            this.f4147o.get(i).getItemOffsets(this.f4135i, view, this, this.f4134h0);
            int i2 = rect.left;
            Rect rect2 = this.f4135i;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f4200c = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Z */
    public void mo6943Z() {
        this.f4125d = new C0931a(new C0917f());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6944a(int i, int i2) {
        if (i < 0) {
            mo6928H();
            this.f4104I.onAbsorb(-i);
        } else if (i > 0) {
            mo6930I();
            this.f4106K.onAbsorb(i);
        }
        if (i2 < 0) {
            mo6931J();
            this.f4105J.onAbsorb(-i2);
        } else if (i2 > 0) {
            mo6926G();
            this.f4107L.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f4147o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f4147o.add(itemDecoration);
        } else {
            this.f4147o.add(i, itemDecoration);
        }
        mo6998h0();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.f4098C == null) {
            this.f4098C = new ArrayList();
        }
        this.f4098C.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.f4149p.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.f4138j0 == null) {
            this.f4138j0 = new ArrayList();
        }
        this.f4138j0.add(onScrollListener);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c0 */
    public void mo6951c0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + mo6933K());
        }
        Resources resources = getContext().getResources();
        new C0937c(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C0868R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(C0868R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(C0868R.dimen.fastscroll_margin));
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f4143m.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.f4098C;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.f4138j0;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.f4143m.computeHorizontalScrollExtent(this.f4134h0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.f4143m.computeHorizontalScrollOffset(this.f4134h0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.f4143m.computeHorizontalScrollRange(this.f4134h0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.f4143m.computeVerticalScrollExtent(this.f4134h0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.f4143m.computeVerticalScrollOffset(this.f4134h0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.f4143m.computeVerticalScrollRange(this.f4134h0);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d0 */
    public void mo6955d0() {
        this.f4107L = null;
        this.f4105J = null;
        this.f4106K = null;
        this.f4104I = null;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.f4147o.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.f4147o.get(i).onDrawOver(canvas, this, this.f4134h0);
        }
        EdgeEffect edgeEffect = this.f4104I;
        boolean z3 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f4131g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.f4104I;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.f4105J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f4131g) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f4105J;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f4106K;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f4131g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.f4106K;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f4107L;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f4131g) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.f4107L;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.f4108M == null || this.f4147o.size() <= 0 || !this.f4108M.isRunning()) {
            z3 = z;
        }
        if (z3) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e0 */
    public boolean mo6960e0() {
        AccessibilityManager accessibilityManager = this.f4097B;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    @Nullable
    public View findChildViewUnder(float f, float f2) {
        for (int g = this.f4127e.mo7648g() - 1; g >= 0; g--) {
            View f3 = this.f4127e.mo7647f(g);
            float translationX = f3.getTranslationX();
            float translationY = f3.getTranslationY();
            if (f >= ((float) f3.getLeft()) + translationX && f <= ((float) f3.getRight()) + translationX && f2 >= ((float) f3.getTop()) + translationY && f2 <= ((float) f3.getBottom()) + translationY) {
                return f3;
            }
        }
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.f4099D) {
            return null;
        }
        int j = this.f4127e.mo7650j();
        for (int i2 = 0; i2 < j; i2++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i2));
            if (S != null && !S.mo7406o() && mo6940Q(S) == i) {
                if (!this.f4127e.mo7653n(S.itemView)) {
                    return S;
                }
                viewHolder = S;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.f4141l;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int j2 = this.f4127e.mo7650j();
            for (int i = 0; i < j2; i++) {
                ViewHolder S = m3023S(this.f4127e.mo7649i(i));
                if (S != null && !S.mo7406o() && S.getItemId() == j) {
                    if (!this.f4127e.mo7653n(S.itemView)) {
                        return S;
                    }
                    viewHolder = S;
                }
            }
        }
        return viewHolder;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return mo6939P(i, false);
    }

    @Deprecated
    @Nullable
    public ViewHolder findViewHolderForPosition(int i) {
        return mo6939P(i, false);
    }

    public boolean fling(int i, int i2) {
        LayoutManager layoutManager = this.f4143m;
        int i3 = 0;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f4165x) {
            return false;
        } else {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.f4143m.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.f4118W) {
                i = 0;
            }
            if (!canScrollVertically || Math.abs(i2) < this.f4118W) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = (float) i;
            float f2 = (float) i2;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f, f2, z);
                OnFlingListener onFlingListener = this.f4117V;
                if (onFlingListener != null && onFlingListener.onFling(i, i2)) {
                    return true;
                }
                if (z) {
                    if (canScrollHorizontally) {
                        i3 = 1;
                    }
                    if (canScrollVertically) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3, 1);
                    int i4 = this.f4120a0;
                    int max = Math.max(-i4, Math.min(i, i4));
                    int i5 = this.f4120a0;
                    this.f4128e0.mo7455e(max, Math.max(-i5, Math.min(i2, i5)));
                    return true;
                }
            }
            return false;
        }
    }

    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.f4143m.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = true;
        boolean z3 = this.f4141l != null && this.f4143m != null && !isComputingLayout() && !this.f4165x;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                mo7037q();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                mo6936L0();
                view2 = this.f4143m.onFocusSearchFailed(view, i, this.f4121b, this.f4134h0);
                mo6937M0(false);
            }
        } else {
            if (this.f4143m.canScrollVertically()) {
                int i2 = i == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i2) == null;
                if (f4091F0) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.f4143m.canScrollHorizontally()) {
                int i3 = (this.f4143m.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i3) != null) {
                    z2 = false;
                }
                if (f4091F0) {
                    i = i3;
                }
                z = z2;
            }
            if (z) {
                mo7037q();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                mo6936L0();
                this.f4143m.onFocusSearchFailed(view, i, this.f4121b, this.f4134h0);
                mo6937M0(false);
            }
            view2 = instance.findNextFocus(this, view, i);
        }
        if (view2 == null || view2.hasFocusable()) {
            return m3036f0(view, view2, i) ? view2 : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        m3013B0(view2, (View) null);
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6970g(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.f4108M.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            mo7038q0();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g0 */
    public void mo6971g0(int i) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo6933K());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo6933K());
    }

    @Nullable
    public Adapter getAdapter() {
        return this.f4141l;
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public int getChildAdapterPosition(@NonNull View view) {
        ViewHolder S = m3023S(view);
        if (S != null) {
            return S.getAdapterPosition();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.f4150p0;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
    }

    public long getChildItemId(@NonNull View view) {
        ViewHolder S;
        Adapter adapter = this.f4141l;
        if (adapter == null || !adapter.hasStableIds() || (S = m3023S(view)) == null) {
            return -1;
        }
        return S.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ViewHolder S = m3023S(view);
        if (S != null) {
            return S.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return m3023S(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.f4131g;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f4148o0;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        m3024T(view, rect);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.f4103H;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.f4108M;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.f4147o.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.f4147o.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.f4143m;
    }

    public int getMaxFlingVelocity() {
        return this.f4120a0;
    }

    public int getMinFlingVelocity() {
        return this.f4118W;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f4090E0) {
            return System.nanoTime();
        }
        return 0;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.f4117V;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f4126d0;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.f4121b.mo7307g();
    }

    public int getScrollState() {
        return this.f4109N;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h0 */
    public void mo6998h0() {
        int j = this.f4127e.mo7650j();
        for (int i = 0; i < j; i++) {
            ((LayoutParams) this.f4127e.mo7649i(i).getLayoutParams()).f4200c = true;
        }
        this.f4121b.mo7315o();
    }

    public boolean hasFixedSize() {
        return this.f4155s;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.f4159u || this.f4099D || this.f4125d.mo7629p();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo7001i(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        m3035f(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.f4108M.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            mo7038q0();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i0 */
    public void mo7002i0() {
        int j = this.f4127e.mo7650j();
        for (int i = 0; i < j; i++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i));
            if (S != null && !S.mo7382B()) {
                S.mo7387b(6);
            }
        }
        mo6998h0();
        this.f4121b.mo7316p();
    }

    public void invalidateItemDecorations() {
        if (this.f4147o.size() != 0) {
            LayoutManager layoutManager = this.f4143m;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            mo6998h0();
            requestLayout();
        }
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.f4108M;
        return itemAnimator != null && itemAnimator.isRunning();
    }

    public boolean isAttachedToWindow() {
        return this.f4153r;
    }

    public boolean isComputingLayout() {
        return this.f4101F > 0;
    }

    public boolean isLayoutFrozen() {
        return this.f4165x;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo7008j(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + mo6933K());
        }
        throw new IllegalStateException(str + mo6933K());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j0 */
    public void mo7009j0(int i, int i2) {
        int j = this.f4127e.mo7650j();
        for (int i3 = 0; i3 < j; i3++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i3));
            if (S != null && !S.mo7382B() && S.f4252b >= i) {
                S.mo7412t(i2, false);
                this.f4134h0.f4239g = true;
            }
        }
        this.f4121b.mo7317q(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo7010k(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + mo6933K());
            }
            throw new IllegalStateException(str);
        } else if (this.f4102G > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + mo6933K()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k0 */
    public void mo7011k0(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int j = this.f4127e.mo7650j();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < j; i7++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i7));
            if (S != null && (i6 = S.f4252b) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    S.mo7412t(i2 - i, false);
                } else {
                    S.mo7412t(i5, false);
                }
                this.f4134h0.f4239g = true;
            }
        }
        this.f4121b.mo7318r(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo7012l(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.f4108M;
        return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.mo7401j());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l0 */
    public void mo7013l0(int i, int i2, boolean z) {
        int i3 = i + i2;
        int j = this.f4127e.mo7650j();
        for (int i4 = 0; i4 < j; i4++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i4));
            if (S != null && !S.mo7382B()) {
                int i5 = S.f4252b;
                if (i5 >= i3) {
                    S.mo7412t(-i2, z);
                    this.f4134h0.f4239g = true;
                } else if (i5 >= i) {
                    S.mo7399i(i - 1, -i2, z);
                    this.f4134h0.f4239g = true;
                }
            }
        }
        this.f4121b.mo7320s(i, i2, z);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m0 */
    public void mo7014m0() {
        this.f4101F++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n0 */
    public void mo7015n0() {
        mo7017o0(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo7016o() {
        int j = this.f4127e.mo7650j();
        for (int i = 0; i < j; i++) {
            ViewHolder S = m3023S(this.f4127e.mo7649i(i));
            if (!S.mo7382B()) {
                S.mo7388c();
            }
        }
        this.f4121b.mo7301c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o0 */
    public void mo7017o0(boolean z) {
        int i = this.f4101F - 1;
        this.f4101F = i;
        if (i < 1) {
            this.f4101F = 0;
            if (z) {
                m3046w();
                mo6924F();
            }
        }
    }

    public void offsetChildrenHorizontal(@C0129Px int i) {
        int g = this.f4127e.mo7648g();
        for (int i2 = 0; i2 < g; i2++) {
            this.f4127e.mo7647f(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(@C0129Px int i) {
        int g = this.f4127e.mo7648g();
        for (int i2 = 0; i2 < g; i2++) {
            this.f4127e.mo7647f(i2).offsetTopAndBottom(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4101F = 0;
        boolean z = true;
        this.f4153r = true;
        if (!this.f4159u || isLayoutRequested()) {
            z = false;
        }
        this.f4159u = z;
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.mo7157c(this);
        }
        this.f4146n0 = false;
        if (f4090E0) {
            ThreadLocal<C0942d> threadLocal = C0942d.f4424e;
            C0942d dVar = threadLocal.get();
            this.f4130f0 = dVar;
            if (dVar == null) {
                this.f4130f0 = new C0942d();
                Display display = ViewCompat.getDisplay(this);
                float f = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                C0942d dVar2 = this.f4130f0;
                dVar2.f4428c = (long) (1.0E9f / f);
                threadLocal.set(dVar2);
            }
            this.f4130f0.mo7680a(this);
        }
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        C0942d dVar;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.f4108M;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.f4153r = false;
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.mo7159d(this, this.f4121b);
        }
        this.f4164w0.clear();
        removeCallbacks(this.f4166x0);
        this.f4129f.mo7714j();
        if (f4090E0 && (dVar = this.f4130f0) != null) {
            dVar.mo7683j(this);
            this.f4130f0 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f4147o.size();
        for (int i = 0; i < size; i++) {
            this.f4147o.get(i).onDraw(canvas, this, this.f4134h0);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.f4143m != null && !this.f4165x && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.f4143m.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.f4143m.canScrollHorizontally()) {
                    f = motionEvent.getAxisValue(10);
                    if (!(f2 == 0.0f && f == 0.0f)) {
                        mo6927G0((int) (f * this.f4122b0), (int) (f2 * this.f4124c0), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f4143m.canScrollVertically()) {
                        f2 = -axisValue;
                    } else if (this.f4143m.canScrollHorizontally()) {
                        f = axisValue;
                        f2 = 0.0f;
                        mo6927G0((int) (f * this.f4122b0), (int) (f2 * this.f4124c0), motionEvent);
                    }
                }
                f2 = 0.0f;
            }
            f = 0.0f;
            mo6927G0((int) (f * this.f4122b0), (int) (f2 * this.f4124c0), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f4165x) {
            return false;
        }
        if (m3014C(motionEvent)) {
            m3038m();
            return true;
        }
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.f4143m.canScrollVertically();
        if (this.f4111P == null) {
            this.f4111P = VelocityTracker.obtain();
        }
        this.f4111P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f4167y) {
                this.f4167y = false;
            }
            this.f4110O = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.f4114S = x;
            this.f4112Q = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f4115T = y;
            this.f4113R = y;
            if (this.f4109N == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f4160u0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.f4111P.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f4110O);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f4110O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.f4109N != 1) {
                int i = x2 - this.f4112Q;
                int i2 = y2 - this.f4113R;
                if (!canScrollHorizontally || Math.abs(i) <= this.f4116U) {
                    z = false;
                } else {
                    this.f4114S = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i2) > this.f4116U) {
                    this.f4115T = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            m3038m();
        } else if (actionMasked == 5) {
            this.f4110O = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f4114S = x3;
            this.f4112Q = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f4115T = y3;
            this.f4113R = y3;
        } else if (actionMasked == 6) {
            m3040p0(motionEvent);
        }
        if (this.f4109N == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection("RV OnLayout");
        mo7081x();
        TraceCompat.endSection();
        this.f4159u = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager == null) {
            mo7049s(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f4143m.onMeasure(this.f4121b, this.f4134h0, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.f4141l != null) {
                if (this.f4134h0.f4237e == 1) {
                    m3049y();
                }
                this.f4143m.mo7240q(i, i2);
                this.f4134h0.f4242j = true;
                m3050z();
                this.f4143m.mo7241r(i, i2);
                if (this.f4143m.mo6862u()) {
                    this.f4143m.mo7240q(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f4134h0.f4242j = true;
                    m3050z();
                    this.f4143m.mo7241r(i, i2);
                }
            }
        } else if (this.f4155s) {
            this.f4143m.onMeasure(this.f4121b, this.f4134h0, i, i2);
        } else {
            if (this.f4096A) {
                mo6936L0();
                mo7014m0();
                m3043s0();
                mo7015n0();
                State state = this.f4134h0;
                if (state.f4244l) {
                    state.f4240h = true;
                } else {
                    this.f4125d.mo7624j();
                    this.f4134h0.f4240h = false;
                }
                this.f4096A = false;
                mo6937M0(false);
            } else if (this.f4134h0.f4244l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.f4141l;
            if (adapter != null) {
                this.f4134h0.f4238f = adapter.getItemCount();
            } else {
                this.f4134h0.f4238f = 0;
            }
            mo6936L0();
            this.f4143m.onMeasure(this.f4121b, this.f4134h0, i, i2);
            mo6937M0(false);
            this.f4134h0.f4240h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f4123c = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null && (parcelable2 = this.f4123c.f4217b) != null) {
            layoutManager.onRestoreInstanceState(parcelable2);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f4123c;
        if (savedState2 != null) {
            savedState.mo7330a(savedState2);
        } else {
            LayoutManager layoutManager = this.f4143m;
            if (layoutManager != null) {
                savedState.f4217b = layoutManager.onSaveInstanceState();
            } else {
                savedState.f4217b = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(@C0129Px int i, @C0129Px int i2) {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            mo6955d0();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        boolean z2 = false;
        if (this.f4165x || this.f4167y) {
            return false;
        }
        if (m3012B(motionEvent)) {
            m3038m();
            return true;
        }
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.f4143m.canScrollVertically();
        if (this.f4111P == null) {
            this.f4111P = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.f4160u0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.f4160u0;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.f4110O = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.f4114S = x;
            this.f4112Q = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f4115T = y;
            this.f4113R = y;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.f4111P.addMovement(obtain);
            this.f4111P.computeCurrentVelocity(1000, (float) this.f4120a0);
            float f = canScrollHorizontally ? -this.f4111P.getXVelocity(this.f4110O) : 0.0f;
            float f2 = canScrollVertically ? -this.f4111P.getYVelocity(this.f4110O) : 0.0f;
            if ((f == 0.0f && f2 == 0.0f) || !fling((int) f, (int) f2)) {
                setScrollState(0);
            }
            m3016D0();
            z2 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f4110O);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f4110O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i5 = this.f4114S - x2;
            int i6 = this.f4115T - y2;
            if (dispatchNestedPreScroll(i5, i6, this.f4158t0, this.f4156s0, 0)) {
                int[] iArr3 = this.f4158t0;
                i5 -= iArr3[0];
                i6 -= iArr3[1];
                int[] iArr4 = this.f4156s0;
                obtain.offsetLocation((float) iArr4[0], (float) iArr4[1]);
                int[] iArr5 = this.f4160u0;
                int i7 = iArr5[0];
                int[] iArr6 = this.f4156s0;
                iArr5[0] = i7 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.f4109N != 1) {
                if (!canScrollHorizontally || Math.abs(i2) <= (i4 = this.f4116U)) {
                    z = false;
                } else {
                    i2 = i2 > 0 ? i2 - i4 : i2 + i4;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i) > (i3 = this.f4116U)) {
                    i = i > 0 ? i - i3 : i + i3;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
            if (this.f4109N == 1) {
                int[] iArr7 = this.f4156s0;
                this.f4114S = x2 - iArr7[0];
                this.f4115T = y2 - iArr7[1];
                if (mo6927G0(canScrollHorizontally ? i2 : 0, canScrollVertically ? i : 0, obtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                C0942d dVar = this.f4130f0;
                if (!(dVar == null || (i2 == 0 && i == 0))) {
                    dVar.mo7681f(this, i2, i);
                }
            }
        } else if (actionMasked == 3) {
            m3038m();
        } else if (actionMasked == 5) {
            this.f4110O = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f4114S = x3;
            this.f4112Q = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f4115T = y3;
            this.f4113R = y3;
        } else if (actionMasked == 6) {
            m3040p0(motionEvent);
        }
        if (!z2) {
            this.f4111P.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo7036p(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.f4104I;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.f4104I.onRelease();
            z = this.f4104I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f4106K;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f4106K.onRelease();
            z |= this.f4106K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4105J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.f4105J.onRelease();
            z |= this.f4105J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4107L;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.f4107L.onRelease();
            z |= this.f4107L.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo7037q() {
        if (!this.f4159u || this.f4099D) {
            TraceCompat.beginSection("RV FullInvalidate");
            mo7081x();
            TraceCompat.endSection();
        } else if (this.f4125d.mo7629p()) {
            if (this.f4125d.mo7628o(4) && !this.f4125d.mo7628o(11)) {
                TraceCompat.beginSection("RV PartialInvalidate");
                mo6936L0();
                mo7014m0();
                this.f4125d.mo7635w();
                if (!this.f4163w) {
                    if (m3028Y()) {
                        mo7081x();
                    } else {
                        this.f4125d.mo7623i();
                    }
                }
                mo6937M0(true);
                mo7015n0();
                TraceCompat.endSection();
            } else if (this.f4125d.mo7629p()) {
                TraceCompat.beginSection("RV FullInvalidate");
                mo7081x();
                TraceCompat.endSection();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q0 */
    public void mo7038q0() {
        if (!this.f4146n0 && this.f4153r) {
            ViewCompat.postOnAnimation(this, this.f4166x0);
            this.f4146n0 = true;
        }
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        ViewHolder S = m3023S(view);
        if (S != null) {
            if (S.mo7408q()) {
                S.mo7391f();
            } else if (!S.mo7382B()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + S + mo6933K());
            }
        }
        view.clearAnimation();
        mo7079v(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.f4147o.remove(itemDecoration);
        if (this.f4147o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        mo6998h0();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.f4098C;
        if (list != null) {
            list.remove(onChildAttachStateChangeListener);
        }
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.f4149p.remove(onItemTouchListener);
        if (this.f4151q == onItemTouchListener) {
            this.f4151q = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.f4138j0;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f4143m.onRequestChildFocus(this, this.f4134h0, view, view2) && view2 != null) {
            m3013B0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f4143m.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f4149p.size();
        for (int i = 0; i < size; i++) {
            this.f4149p.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.f4161v != 0 || this.f4165x) {
            this.f4163w = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo7049s(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f4165x) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.f4143m.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                mo6927G0(i, i2, (MotionEvent) null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (!this.f4165x) {
            stopScroll();
            LayoutManager layoutManager = this.f4143m;
            if (layoutManager == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!mo6934K0(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f4148o0 = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        m3018I0(adapter, false, true);
        mo7077t0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.f4150p0) {
            this.f4150p0 = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f4131g) {
            mo6955d0();
        }
        this.f4131g = z;
        super.setClipToPadding(z);
        if (this.f4159u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.f4103H = edgeEffectFactory;
        mo6955d0();
    }

    public void setHasFixedSize(boolean z) {
        this.f4155s = z;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.f4108M;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.f4108M.mo7123b((ItemAnimator.C0907a) null);
        }
        this.f4108M = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.mo7123b(this.f4144m0);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f4121b.setViewCacheSize(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f4165x) {
            mo7010k("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.f4165x = false;
                if (!(!this.f4163w || this.f4143m == null || this.f4141l == null)) {
                    requestLayout();
                }
                this.f4163w = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f4165x = true;
            this.f4167y = true;
            stopScroll();
        }
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager != this.f4143m) {
            stopScroll();
            if (this.f4143m != null) {
                ItemAnimator itemAnimator = this.f4108M;
                if (itemAnimator != null) {
                    itemAnimator.endAnimations();
                }
                this.f4143m.removeAndRecycleAllViews(this.f4121b);
                this.f4143m.mo7221n(this.f4121b);
                this.f4121b.clear();
                if (this.f4153r) {
                    this.f4143m.mo7159d(this, this.f4121b);
                }
                this.f4143m.mo7254s((RecyclerView) null);
                this.f4143m = null;
            } else {
                this.f4121b.clear();
            }
            this.f4127e.mo7654o();
            this.f4143m = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f4179b == null) {
                    layoutManager.mo7254s(this);
                    if (this.f4153r) {
                        this.f4143m.mo7157c(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.f4179b.mo6933K());
                }
            }
            this.f4121b.mo7296E();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.f4117V = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.f4136i0 = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f4126d0 = z;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        this.f4121b.mo7328z(recycledViewPool);
    }

    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.f4145n = recyclerListener;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (i != this.f4109N) {
            this.f4109N = i;
            if (i != 2) {
                m3021N0();
            }
            mo6922D(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.f4116U = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f4116U = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.f4121b.mo7293A(viewCacheExtension);
    }

    public void smoothScrollBy(@C0129Px int i, @C0129Px int i2) {
        smoothScrollBy(i, i2, (Interpolator) null);
    }

    public void smoothScrollToPosition(int i) {
        if (!this.f4165x) {
            LayoutManager layoutManager = this.f4143m;
            if (layoutManager == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.smoothScrollToPosition(this, this.f4134h0, i);
            }
        }
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        m3021N0();
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        m3018I0(adapter, true, z);
        mo7077t0(true);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t0 */
    public void mo7077t0(boolean z) {
        this.f4100E = z | this.f4100E;
        this.f4099D = true;
        mo7002i0();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo7078u(View view) {
        ViewHolder S = m3023S(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.f4141l;
        if (!(adapter == null || S == null)) {
            adapter.onViewAttachedToWindow(S);
        }
        List<OnChildAttachStateChangeListener> list = this.f4098C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4098C.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo7079v(View view) {
        ViewHolder S = m3023S(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.f4141l;
        if (!(adapter == null || S == null)) {
            adapter.onViewDetachedFromWindow(S);
        }
        List<OnChildAttachStateChangeListener> list = this.f4098C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4098C.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v0 */
    public void mo7080v0(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.mo7418y(0, 8192);
        if (this.f4134h0.f4241i && viewHolder.mo7409r() && !viewHolder.mo7406o() && !viewHolder.mo7382B()) {
            this.f4129f.mo7707c(mo6941R(viewHolder), viewHolder);
        }
        this.f4129f.mo7709e(viewHolder, itemHolderInfo);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo7081x() {
        if (this.f4141l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f4143m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            State state = this.f4134h0;
            state.f4242j = false;
            if (state.f4237e == 1) {
                m3049y();
                this.f4143m.mo7236p(this);
                m3050z();
            } else if (!this.f4125d.mo7630q() && this.f4143m.getWidth() == getWidth() && this.f4143m.getHeight() == getHeight()) {
                this.f4143m.mo7236p(this);
            } else {
                this.f4143m.mo7236p(this);
                m3050z();
            }
            m3011A();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y0 */
    public void mo7082y0() {
        ItemAnimator itemAnimator = this.f4108M;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.f4121b);
            this.f4143m.mo7221n(this.f4121b);
        }
        this.f4121b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z0 */
    public boolean mo7083z0(View view) {
        mo6936L0();
        boolean r = this.f4127e.mo7657r(view);
        if (r) {
            ViewHolder S = m3023S(view);
            this.f4121b.mo7295D(S);
            this.f4121b.mo7326x(S);
        }
        mo6937M0(!r);
        return r;
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    public void smoothScrollBy(@C0129Px int i, @C0129Px int i2, @Nullable Interpolator interpolator) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f4165x) {
            if (!layoutManager.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.f4143m.canScrollVertically()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                this.f4128e0.mo7461k(i, i2, interpolator);
            }
        }
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4119a = new C0920i();
        this.f4121b = new Recycler();
        this.f4129f = new C0958j();
        this.f4133h = new C0912a();
        this.f4135i = new Rect();
        this.f4137j = new Rect();
        this.f4139k = new RectF();
        this.f4147o = new ArrayList<>();
        this.f4149p = new ArrayList<>();
        this.f4161v = 0;
        this.f4099D = false;
        this.f4100E = false;
        this.f4101F = 0;
        this.f4102G = 0;
        this.f4103H = new EdgeEffectFactory();
        this.f4108M = new DefaultItemAnimator();
        this.f4109N = 0;
        this.f4110O = -1;
        this.f4122b0 = Float.MIN_VALUE;
        this.f4124c0 = Float.MIN_VALUE;
        boolean z = true;
        this.f4126d0 = true;
        this.f4128e0 = new C0921j();
        this.f4132g0 = f4090E0 ? new C0942d.C0944b() : null;
        this.f4134h0 = new State();
        this.f4140k0 = false;
        this.f4142l0 = false;
        this.f4144m0 = new C0919h();
        this.f4146n0 = false;
        this.f4152q0 = new int[2];
        this.f4156s0 = new int[2];
        this.f4158t0 = new int[2];
        this.f4160u0 = new int[2];
        this.f4162v0 = new int[2];
        this.f4164w0 = new ArrayList();
        this.f4166x0 = new C0913b();
        this.f4168y0 = new C0915d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4086A0, i, 0);
            this.f4131g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f4131g = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4116U = viewConfiguration.getScaledTouchSlop();
        this.f4122b0 = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.f4124c0 = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.f4118W = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4120a0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f4108M.mo7123b(this.f4144m0);
        mo6943Z();
        m3031b0();
        m3029a0();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.f4097B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0868R.styleable.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(C0868R.styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(C0868R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            boolean z2 = obtainStyledAttributes2.getBoolean(C0868R.styleable.RecyclerView_fastScrollEnabled, false);
            this.f4157t = z2;
            if (z2) {
                mo6951c0((StateListDrawable) obtainStyledAttributes2.getDrawable(C0868R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(C0868R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(C0868R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(C0868R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            m3041r(context, string, attributeSet, i, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f4095z0, i, 0);
                boolean z3 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z3;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        ViewHolder f4198a;

        /* renamed from: b */
        final Rect f4199b = new Rect();

        /* renamed from: c */
        boolean f4200c = true;

        /* renamed from: d */
        boolean f4201d = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getViewAdapterPosition() {
            return this.f4198a.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.f4198a.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.f4198a.getPosition();
        }

        public boolean isItemChanged() {
            return this.f4198a.mo7409r();
        }

        public boolean isItemRemoved() {
            return this.f4198a.mo7406o();
        }

        public boolean isViewInvalid() {
            return this.f4198a.mo7405n();
        }

        public boolean viewNeedsUpdate() {
            return this.f4198a.mo7410s();
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

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0911a();

        /* renamed from: b */
        Parcelable f4217b;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$SavedState$a */
        static class C0911a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0911a() {
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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4217b = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7330a(SavedState savedState) {
            this.f4217b = savedState.f4217b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f4217b, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.f4143m;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo6933K());
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }
}
