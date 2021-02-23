package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: a */
    RecyclerView f4286a;

    /* renamed from: b */
    private Scroller f4287b;

    /* renamed from: c */
    private final RecyclerView.OnScrollListener f4288c = new C0922a();

    /* renamed from: androidx.recyclerview.widget.SnapHelper$a */
    class C0922a extends RecyclerView.OnScrollListener {

        /* renamed from: a */
        boolean f4289a = false;

        C0922a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f4289a) {
                this.f4289a = false;
                SnapHelper.this.mo7487d();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f4289a = true;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.SnapHelper$b */
    class C0923b extends LinearSmoothScroller {
        C0923b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        /* access modifiers changed from: protected */
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            SnapHelper snapHelper = SnapHelper.this;
            RecyclerView recyclerView = snapHelper.f4286a;
            if (recyclerView != null) {
                int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3269a() {
        this.f4286a.removeOnScrollListener(this.f4288c);
        this.f4286a.setOnFlingListener((RecyclerView.OnFlingListener) null);
    }

    /* renamed from: b */
    private void m3270b() {
        if (this.f4286a.getOnFlingListener() == null) {
            this.f4286a.addOnScrollListener(this.f4288c);
            this.f4286a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    /* renamed from: c */
    private boolean m3271c(@NonNull RecyclerView.LayoutManager layoutManager, int i, int i2) {
        RecyclerView.SmoothScroller createScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createScroller = createScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createScroller);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4286a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                m3269a();
            }
            this.f4286a = recyclerView;
            if (recyclerView != null) {
                m3270b();
                this.f4287b = new Scroller(this.f4286a.getContext(), new DecelerateInterpolator());
                mo7487d();
            }
        }
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view);

    public int[] calculateScrollDistance(int i, int i2) {
        this.f4287b.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f4287b.getFinalX(), this.f4287b.getFinalY()};
    }

    /* access modifiers changed from: protected */
    @Nullable
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        return createSnapScroller(layoutManager);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    @Nullable
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new C0923b(this.f4286a.getContext());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo7487d() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.f4286a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (findSnapView = findSnapView(layoutManager)) != null) {
            int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
            if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.f4286a.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
            }
        }
    }

    @Nullable
    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2);

    public boolean onFling(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.f4286a.getLayoutManager();
        if (layoutManager == null || this.f4286a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f4286a.getMinFlingVelocity();
        if ((Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && m3271c(layoutManager, i, i2)) {
            return true;
        }
        return false;
    }
}
