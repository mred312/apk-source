package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.C0868R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;

    /* renamed from: UP */
    public static final int f3981UP = 1;

    /* renamed from: A */
    private C0898f f3982A;

    /* renamed from: B */
    private final RecyclerView.OnItemTouchListener f3983B = new C0894b();

    /* renamed from: C */
    private Rect f3984C;

    /* renamed from: D */
    private long f3985D;

    /* renamed from: a */
    final List<View> f3986a = new ArrayList();

    /* renamed from: b */
    private final float[] f3987b = new float[2];

    /* renamed from: c */
    RecyclerView.ViewHolder f3988c = null;

    /* renamed from: d */
    float f3989d;

    /* renamed from: e */
    float f3990e;

    /* renamed from: f */
    private float f3991f;

    /* renamed from: g */
    private float f3992g;

    /* renamed from: h */
    float f3993h;

    /* renamed from: i */
    float f3994i;

    /* renamed from: j */
    private float f3995j;

    /* renamed from: k */
    private float f3996k;

    /* renamed from: l */
    int f3997l = -1;
    @NonNull

    /* renamed from: m */
    Callback f3998m;

    /* renamed from: n */
    private int f3999n = 0;

    /* renamed from: o */
    int f4000o;

    /* renamed from: p */
    List<C0899g> f4001p = new ArrayList();

    /* renamed from: q */
    private int f4002q;

    /* renamed from: r */
    RecyclerView f4003r;

    /* renamed from: s */
    final Runnable f4004s = new C0893a();

    /* renamed from: t */
    VelocityTracker f4005t;

    /* renamed from: u */
    private List<RecyclerView.ViewHolder> f4006u;

    /* renamed from: v */
    private List<Integer> f4007v;

    /* renamed from: w */
    private RecyclerView.ChildDrawingOrderCallback f4008w = null;

    /* renamed from: x */
    View f4009x = null;

    /* renamed from: y */
    int f4010y = -1;

    /* renamed from: z */
    GestureDetectorCompat f4011z;

    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        /* renamed from: b */
        private static final Interpolator f4012b = new C0891a();

        /* renamed from: c */
        private static final Interpolator f4013c = new C0892b();

        /* renamed from: a */
        private int f4014a = -1;

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$Callback$a */
        static class C0891a implements Interpolator {
            C0891a() {
            }

            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        }

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$Callback$b */
        static class C0892b implements Interpolator {
            C0892b() {
            }

            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        /* renamed from: b */
        private int m2927b(RecyclerView recyclerView) {
            if (this.f4014a == -1) {
                this.f4014a = recyclerView.getResources().getDimensionPixelSize(C0868R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f4014a;
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= -789517 & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return C0946e.f4439a;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            int makeFlag = makeFlag(0, i2 | i);
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final int mo6761a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo6762c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (mo6761a(recyclerView, viewHolder) & 16711680) != 0;
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i, int i2) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            int width = i + viewHolder2.itemView.getWidth();
            int height = i2 + viewHolder2.itemView.getHeight();
            int left2 = i - viewHolder2.itemView.getLeft();
            int top2 = i2 - viewHolder2.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder3 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.ViewHolder viewHolder4 = list.get(i4);
                if (left2 > 0 && (right = viewHolder4.itemView.getRight() - width) < 0 && viewHolder4.itemView.getRight() > viewHolder2.itemView.getRight() && (abs4 = Math.abs(right)) > i3) {
                    viewHolder3 = viewHolder4;
                    i3 = abs4;
                }
                if (left2 < 0 && (left = viewHolder4.itemView.getLeft() - i) > 0 && viewHolder4.itemView.getLeft() < viewHolder2.itemView.getLeft() && (abs3 = Math.abs(left)) > i3) {
                    viewHolder3 = viewHolder4;
                    i3 = abs3;
                }
                if (top2 < 0 && (top = viewHolder4.itemView.getTop() - i2) > 0 && viewHolder4.itemView.getTop() < viewHolder2.itemView.getTop() && (abs2 = Math.abs(top)) > i3) {
                    viewHolder3 = viewHolder4;
                    i3 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder4.itemView.getBottom() - height) < 0 && viewHolder4.itemView.getBottom() > viewHolder2.itemView.getBottom() && (abs = Math.abs(bottom)) > i3) {
                    viewHolder3 = viewHolder4;
                    i3 = abs;
                }
            }
            return viewHolder3;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            C0946e.f4439a.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= -3158065 & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo6767d(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (mo6761a(recyclerView, viewHolder) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6768e(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<C0899g> list, int i, float f, float f2) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0899g gVar = list.get(i2);
                gVar.mo6807e();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, gVar.f4032e, gVar.f4036i, gVar.f4037j, gVar.f4033f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo6769f(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<C0899g> list, int i, float f, float f2) {
            Canvas canvas2 = canvas;
            List<C0899g> list2 = list;
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                C0899g gVar = list2.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, gVar.f4032e, gVar.f4036i, gVar.f4037j, gVar.f4033f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                C0899g gVar2 = list2.get(i3);
                boolean z2 = gVar2.f4039l;
                if (z2 && !gVar2.f4035h) {
                    list2.remove(i3);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            }
            if (i == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i2)) * m2927b(recyclerView))) * f4013c.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f4012b.getInterpolation(f));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            }
            return interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            C0946e.f4439a.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            C0946e.f4439a.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                C0946e.f4439a.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i);
    }

    public static abstract class SimpleCallback extends Callback {

        /* renamed from: d */
        private int f4015d;

        /* renamed from: e */
        private int f4016e;

        public SimpleCallback(int i, int i2) {
            this.f4015d = i2;
            this.f4016e = i;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f4016e;
        }

        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f4015d;
        }

        public void setDefaultDragDirs(int i) {
            this.f4016e = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.f4015d = i;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$a */
    class C0893a implements Runnable {
        C0893a() {
        }

        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.f3988c != null && itemTouchHelper.mo6756s()) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper2.f3988c;
                if (viewHolder != null) {
                    itemTouchHelper2.mo6749n(viewHolder);
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                itemTouchHelper3.f4003r.removeCallbacks(itemTouchHelper3.f4004s);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.f4003r, this);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$b */
    class C0894b implements RecyclerView.OnItemTouchListener {
        C0894b() {
        }

        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            C0899g g;
            ItemTouchHelper.this.f4011z.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.f3997l = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f3989d = motionEvent.getX();
                ItemTouchHelper.this.f3990e = motionEvent.getY();
                ItemTouchHelper.this.mo6750o();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f3988c == null && (g = itemTouchHelper.mo6746g(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f3989d -= g.f4036i;
                    itemTouchHelper2.f3990e -= g.f4037j;
                    itemTouchHelper2.mo6745f(g.f4032e, true);
                    if (ItemTouchHelper.this.f3986a.remove(g.f4032e.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.f3998m.clearView(itemTouchHelper3.f4003r, g.f4032e);
                    }
                    ItemTouchHelper.this.mo6759t(g.f4032e, g.f4033f);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.mo6760y(motionEvent, itemTouchHelper4.f4000o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.f3997l = -1;
                itemTouchHelper5.mo6759t((RecyclerView.ViewHolder) null, 0);
            } else {
                int i = ItemTouchHelper.this.f3997l;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                    ItemTouchHelper.this.mo6744c(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.f4005t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f3988c != null) {
                return true;
            }
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.mo6759t((RecyclerView.ViewHolder) null, 0);
            }
        }

        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.f4011z.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.f4005t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f3997l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.f3997l);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.mo6744c(actionMasked, motionEvent, findPointerIndex);
                }
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper.f3988c;
                if (viewHolder != null) {
                    int i = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = itemTouchHelper.f4005t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                                if (pointerId == itemTouchHelper2.f3997l) {
                                    if (actionIndex == 0) {
                                        i = 1;
                                    }
                                    itemTouchHelper2.f3997l = motionEvent.getPointerId(i);
                                    ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                    itemTouchHelper3.mo6760y(motionEvent, itemTouchHelper3.f4000o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            itemTouchHelper.mo6760y(motionEvent, itemTouchHelper.f4000o, findPointerIndex);
                            ItemTouchHelper.this.mo6749n(viewHolder);
                            ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                            itemTouchHelper4.f4003r.removeCallbacks(itemTouchHelper4.f4004s);
                            ItemTouchHelper.this.f4004s.run();
                            ItemTouchHelper.this.f4003r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    ItemTouchHelper.this.mo6759t((RecyclerView.ViewHolder) null, 0);
                    ItemTouchHelper.this.f3997l = -1;
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$c */
    class C0895c extends C0899g {

        /* renamed from: n */
        final /* synthetic */ int f4019n;

        /* renamed from: o */
        final /* synthetic */ RecyclerView.ViewHolder f4020o;

        /* renamed from: p */
        final /* synthetic */ ItemTouchHelper f4021p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0895c(ItemTouchHelper itemTouchHelper, RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i, i2, f, f2, f3, f4);
            this.f4021p = itemTouchHelper;
            this.f4019n = i3;
            this.f4020o = viewHolder2;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f4038k) {
                if (this.f4019n <= 0) {
                    ItemTouchHelper itemTouchHelper = this.f4021p;
                    itemTouchHelper.f3998m.clearView(itemTouchHelper.f4003r, this.f4020o);
                } else {
                    this.f4021p.f3986a.add(this.f4020o.itemView);
                    this.f4035h = true;
                    int i = this.f4019n;
                    if (i > 0) {
                        this.f4021p.mo6754p(this, i);
                    }
                }
                ItemTouchHelper itemTouchHelper2 = this.f4021p;
                View view = itemTouchHelper2.f4009x;
                View view2 = this.f4020o.itemView;
                if (view == view2) {
                    itemTouchHelper2.mo6755r(view2);
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$d */
    class C0896d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0899g f4022a;

        /* renamed from: b */
        final /* synthetic */ int f4023b;

        C0896d(C0899g gVar, int i) {
            this.f4022a = gVar;
            this.f4023b = i;
        }

        public void run() {
            RecyclerView recyclerView = ItemTouchHelper.this.f4003r;
            if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                C0899g gVar = this.f4022a;
                if (!gVar.f4038k && gVar.f4032e.getAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.f4003r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) null)) && !ItemTouchHelper.this.mo6748l()) {
                        ItemTouchHelper.this.f3998m.onSwiped(this.f4022a.f4032e, this.f4023b);
                    } else {
                        ItemTouchHelper.this.f4003r.post(this);
                    }
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$e */
    class C0897e implements RecyclerView.ChildDrawingOrderCallback {
        C0897e() {
        }

        public int onGetChildDrawingOrder(int i, int i2) {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            View view = itemTouchHelper.f4009x;
            if (view == null) {
                return i2;
            }
            int i3 = itemTouchHelper.f4010y;
            if (i3 == -1) {
                i3 = itemTouchHelper.f4003r.indexOfChild(view);
                ItemTouchHelper.this.f4010y = i3;
            }
            if (i2 == i - 1) {
                return i3;
            }
            return i2 < i3 ? i2 : i2 + 1;
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$f */
    private class C0898f extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a */
        private boolean f4026a = true;

        C0898f() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6800a() {
            this.f4026a = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View h;
            RecyclerView.ViewHolder childViewHolder;
            int i;
            if (this.f4026a && (h = ItemTouchHelper.this.mo6747h(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.f4003r.getChildViewHolder(h)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f3998m.mo6762c(itemTouchHelper.f4003r, childViewHolder) && motionEvent.getPointerId(0) == (i = ItemTouchHelper.this.f3997l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f3989d = x;
                    itemTouchHelper2.f3990e = y;
                    itemTouchHelper2.f3994i = 0.0f;
                    itemTouchHelper2.f3993h = 0.0f;
                    if (itemTouchHelper2.f3998m.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.mo6759t(childViewHolder, 2);
                    }
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$g */
    private static class C0899g implements Animator.AnimatorListener {

        /* renamed from: a */
        final float f4028a;

        /* renamed from: b */
        final float f4029b;

        /* renamed from: c */
        final float f4030c;

        /* renamed from: d */
        final float f4031d;

        /* renamed from: e */
        final RecyclerView.ViewHolder f4032e;

        /* renamed from: f */
        final int f4033f;

        /* renamed from: g */
        private final ValueAnimator f4034g;

        /* renamed from: h */
        boolean f4035h;

        /* renamed from: i */
        float f4036i;

        /* renamed from: j */
        float f4037j;

        /* renamed from: k */
        boolean f4038k = false;

        /* renamed from: l */
        boolean f4039l = false;

        /* renamed from: m */
        private float f4040m;

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$g$a */
        class C0900a implements ValueAnimator.AnimatorUpdateListener {
            C0900a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C0899g.this.mo6805c(valueAnimator.getAnimatedFraction());
            }
        }

        C0899g(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.f4033f = i2;
            this.f4032e = viewHolder;
            this.f4028a = f;
            this.f4029b = f2;
            this.f4030c = f3;
            this.f4031d = f4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f4034g = ofFloat;
            ofFloat.addUpdateListener(new C0900a());
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            mo6805c(0.0f);
        }

        /* renamed from: a */
        public void mo6803a() {
            this.f4034g.cancel();
        }

        /* renamed from: b */
        public void mo6804b(long j) {
            this.f4034g.setDuration(j);
        }

        /* renamed from: c */
        public void mo6805c(float f) {
            this.f4040m = f;
        }

        /* renamed from: d */
        public void mo6806d() {
            this.f4032e.setIsRecyclable(false);
            this.f4034g.start();
        }

        /* renamed from: e */
        public void mo6807e() {
            float f = this.f4028a;
            float f2 = this.f4030c;
            if (f == f2) {
                this.f4036i = this.f4032e.itemView.getTranslationX();
            } else {
                this.f4036i = f + (this.f4040m * (f2 - f));
            }
            float f3 = this.f4029b;
            float f4 = this.f4031d;
            if (f3 == f4) {
                this.f4037j = this.f4032e.itemView.getTranslationY();
            } else {
                this.f4037j = f3 + (this.f4040m * (f4 - f3));
            }
        }

        public void onAnimationCancel(Animator animator) {
            mo6805c(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f4039l) {
                this.f4032e.setIsRecyclable(true);
            }
            this.f4039l = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.f3998m = callback;
    }

    /* renamed from: a */
    private void m2902a() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.f4008w == null) {
                this.f4008w = new C0897e();
            }
            this.f4003r.setChildDrawingOrderCallback(this.f4008w);
        }
    }

    /* renamed from: b */
    private int m2903b(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = 8;
        int i3 = this.f3993h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f4005t;
        if (velocityTracker != null && this.f3997l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f3998m.getSwipeVelocityThreshold(this.f3992g));
            float xVelocity = this.f4005t.getXVelocity(this.f3997l);
            float yVelocity = this.f4005t.getYVelocity(this.f3997l);
            if (xVelocity <= 0.0f) {
                i2 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i2 & i) != 0 && i3 == i2 && abs >= this.f3998m.getSwipeEscapeVelocity(this.f3991f) && abs > Math.abs(yVelocity)) {
                return i2;
            }
        }
        float width = ((float) this.f4003r.getWidth()) * this.f3998m.getSwipeThreshold(viewHolder);
        if ((i & i3) == 0 || Math.abs(this.f3993h) <= width) {
            return 0;
        }
        return i3;
    }

    /* renamed from: d */
    private int m2904d(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = 2;
        int i3 = this.f3994i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f4005t;
        if (velocityTracker != null && this.f3997l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f3998m.getSwipeVelocityThreshold(this.f3992g));
            float xVelocity = this.f4005t.getXVelocity(this.f3997l);
            float yVelocity = this.f4005t.getYVelocity(this.f3997l);
            if (yVelocity <= 0.0f) {
                i2 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i2 & i) != 0 && i2 == i3 && abs >= this.f3998m.getSwipeEscapeVelocity(this.f3991f) && abs > Math.abs(xVelocity)) {
                return i2;
            }
        }
        float height = ((float) this.f4003r.getHeight()) * this.f3998m.getSwipeThreshold(viewHolder);
        if ((i & i3) == 0 || Math.abs(this.f3994i) <= height) {
            return 0;
        }
        return i3;
    }

    /* renamed from: e */
    private void m2905e() {
        this.f4003r.removeItemDecoration(this);
        this.f4003r.removeOnItemTouchListener(this.f3983B);
        this.f4003r.removeOnChildAttachStateChangeListener(this);
        for (int size = this.f4001p.size() - 1; size >= 0; size--) {
            this.f3998m.clearView(this.f4003r, this.f4001p.get(0).f4032e);
        }
        this.f4001p.clear();
        this.f4009x = null;
        this.f4010y = -1;
        m2910q();
        m2913w();
    }

    /* renamed from: i */
    private List<RecyclerView.ViewHolder> m2906i(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.f4006u;
        if (list == null) {
            this.f4006u = new ArrayList();
            this.f4007v = new ArrayList();
        } else {
            list.clear();
            this.f4007v.clear();
        }
        int boundingBoxMargin = this.f3998m.getBoundingBoxMargin();
        int round = Math.round(this.f3995j + this.f3993h) - boundingBoxMargin;
        int round2 = Math.round(this.f3996k + this.f3994i) - boundingBoxMargin;
        int i = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i;
        int height = viewHolder2.itemView.getHeight() + round2 + i;
        int i2 = (round + width) / 2;
        int i3 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f4003r.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = layoutManager.getChildAt(i4);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.f4003r.getChildViewHolder(childAt);
                if (this.f3998m.canDropOver(this.f4003r, this.f3988c, childViewHolder)) {
                    int abs = Math.abs(i2 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i3 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i5 = (abs * abs) + (abs2 * abs2);
                    int size = this.f4006u.size();
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < size && i5 > this.f4007v.get(i6).intValue()) {
                        i7++;
                        i6++;
                        RecyclerView.ViewHolder viewHolder3 = viewHolder;
                    }
                    this.f4006u.add(i7, childViewHolder);
                    this.f4007v.add(i7, Integer.valueOf(i5));
                }
            }
            i4++;
            viewHolder2 = viewHolder;
        }
        return this.f4006u;
    }

    /* renamed from: j */
    private RecyclerView.ViewHolder m2907j(MotionEvent motionEvent) {
        View h;
        RecyclerView.LayoutManager layoutManager = this.f4003r.getLayoutManager();
        int i = this.f3997l;
        if (i == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f3989d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f3990e);
        int i2 = this.f4002q;
        if (abs < ((float) i2) && abs2 < ((float) i2)) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (h = mo6747h(motionEvent)) != null) {
            return this.f4003r.getChildViewHolder(h);
        }
        return null;
    }

    /* renamed from: k */
    private void m2908k(float[] fArr) {
        if ((this.f4000o & 12) != 0) {
            fArr[0] = (this.f3995j + this.f3993h) - ((float) this.f3988c.itemView.getLeft());
        } else {
            fArr[0] = this.f3988c.itemView.getTranslationX();
        }
        if ((this.f4000o & 3) != 0) {
            fArr[1] = (this.f3996k + this.f3994i) - ((float) this.f3988c.itemView.getTop());
        } else {
            fArr[1] = this.f3988c.itemView.getTranslationY();
        }
    }

    /* renamed from: m */
    private static boolean m2909m(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    /* renamed from: q */
    private void m2910q() {
        VelocityTracker velocityTracker = this.f4005t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4005t = null;
        }
    }

    /* renamed from: u */
    private void m2911u() {
        this.f4002q = ViewConfiguration.get(this.f4003r.getContext()).getScaledTouchSlop();
        this.f4003r.addItemDecoration(this);
        this.f4003r.addOnItemTouchListener(this.f3983B);
        this.f4003r.addOnChildAttachStateChangeListener(this);
        m2912v();
    }

    /* renamed from: v */
    private void m2912v() {
        this.f3982A = new C0898f();
        this.f4011z = new GestureDetectorCompat(this.f4003r.getContext(), this.f3982A);
    }

    /* renamed from: w */
    private void m2913w() {
        C0898f fVar = this.f3982A;
        if (fVar != null) {
            fVar.mo6800a();
            this.f3982A = null;
        }
        if (this.f4011z != null) {
            this.f4011z = null;
        }
    }

    /* renamed from: x */
    private int m2914x(RecyclerView.ViewHolder viewHolder) {
        if (this.f3999n == 2) {
            return 0;
        }
        int movementFlags = this.f3998m.getMovementFlags(this.f4003r, viewHolder);
        int convertToAbsoluteDirection = (this.f3998m.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.f4003r)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (Math.abs(this.f3993h) > Math.abs(this.f3994i)) {
            int b = m2903b(viewHolder, convertToAbsoluteDirection);
            if (b > 0) {
                return (i & b) == 0 ? Callback.convertToRelativeDirection(b, ViewCompat.getLayoutDirection(this.f4003r)) : b;
            }
            int d = m2904d(viewHolder, convertToAbsoluteDirection);
            if (d > 0) {
                return d;
            }
        } else {
            int d2 = m2904d(viewHolder, convertToAbsoluteDirection);
            if (d2 > 0) {
                return d2;
            }
            int b2 = m2903b(viewHolder, convertToAbsoluteDirection);
            if (b2 > 0) {
                return (i & b2) == 0 ? Callback.convertToRelativeDirection(b2, ViewCompat.getLayoutDirection(this.f4003r)) : b2;
            }
        }
        return 0;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4003r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                m2905e();
            }
            this.f4003r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f3991f = resources.getDimension(C0868R.dimen.item_touch_helper_swipe_escape_velocity);
                this.f3992g = resources.getDimension(C0868R.dimen.item_touch_helper_swipe_escape_max_velocity);
                m2911u();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6744c(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder j;
        int a;
        if (this.f3988c == null && i == 2 && this.f3999n != 2 && this.f3998m.isItemViewSwipeEnabled() && this.f4003r.getScrollState() != 1 && (j = m2907j(motionEvent)) != null && (a = (this.f3998m.mo6761a(this.f4003r, j) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) != 0) {
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            float f = x - this.f3989d;
            float f2 = y - this.f3990e;
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            int i3 = this.f4002q;
            if (abs >= ((float) i3) || abs2 >= ((float) i3)) {
                if (abs > abs2) {
                    if (f < 0.0f && (a & 4) == 0) {
                        return;
                    }
                    if (f > 0.0f && (a & 8) == 0) {
                        return;
                    }
                } else if (f2 < 0.0f && (a & 1) == 0) {
                    return;
                } else {
                    if (f2 > 0.0f && (a & 2) == 0) {
                        return;
                    }
                }
                this.f3994i = 0.0f;
                this.f3993h = 0.0f;
                this.f3997l = motionEvent.getPointerId(0);
                mo6759t(j, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6745f(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.f4001p.size() - 1; size >= 0; size--) {
            C0899g gVar = this.f4001p.get(size);
            if (gVar.f4032e == viewHolder) {
                gVar.f4038k |= z;
                if (!gVar.f4039l) {
                    gVar.mo6803a();
                }
                this.f4001p.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C0899g mo6746g(MotionEvent motionEvent) {
        if (this.f4001p.isEmpty()) {
            return null;
        }
        View h = mo6747h(motionEvent);
        for (int size = this.f4001p.size() - 1; size >= 0; size--) {
            C0899g gVar = this.f4001p.get(size);
            if (gVar.f4032e.itemView == h) {
                return gVar;
            }
        }
        return null;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public View mo6747h(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f3988c;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (m2909m(view, x, y, this.f3995j + this.f3993h, this.f3996k + this.f3994i)) {
                return view;
            }
        }
        for (int size = this.f4001p.size() - 1; size >= 0; size--) {
            C0899g gVar = this.f4001p.get(size);
            View view2 = gVar.f4032e.itemView;
            if (m2909m(view2, x, y, gVar.f4036i, gVar.f4037j)) {
                return view2;
            }
        }
        return this.f4003r.findChildViewUnder(x, y);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo6748l() {
        int size = this.f4001p.size();
        for (int i = 0; i < size; i++) {
            if (!this.f4001p.get(i).f4039l) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo6749n(RecyclerView.ViewHolder viewHolder) {
        if (!this.f4003r.isLayoutRequested() && this.f3999n == 2) {
            float moveThreshold = this.f3998m.getMoveThreshold(viewHolder);
            int i = (int) (this.f3995j + this.f3993h);
            int i2 = (int) (this.f3996k + this.f3994i);
            if (((float) Math.abs(i2 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i - viewHolder.itemView.getLeft())) >= ((float) viewHolder.itemView.getWidth()) * moveThreshold) {
                List<RecyclerView.ViewHolder> i3 = m2906i(viewHolder);
                if (i3.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.f3998m.chooseDropTarget(viewHolder, i3, i, i2);
                    if (chooseDropTarget == null) {
                        this.f4006u.clear();
                        this.f4007v.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.f3998m.onMove(this.f4003r, viewHolder, chooseDropTarget)) {
                        this.f3998m.onMoved(this.f4003r, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo6750o() {
        VelocityTracker velocityTracker = this.f4005t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f4005t = VelocityTracker.obtain();
    }

    public void onChildViewAttachedToWindow(@NonNull View view) {
    }

    public void onChildViewDetachedFromWindow(@NonNull View view) {
        mo6755r(view);
        RecyclerView.ViewHolder childViewHolder = this.f4003r.getChildViewHolder(view);
        if (childViewHolder != null) {
            RecyclerView.ViewHolder viewHolder = this.f3988c;
            if (viewHolder == null || childViewHolder != viewHolder) {
                mo6745f(childViewHolder, false);
                if (this.f3986a.remove(childViewHolder.itemView)) {
                    this.f3998m.clearView(this.f4003r, childViewHolder);
                    return;
                }
                return;
            }
            mo6759t((RecyclerView.ViewHolder) null, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        this.f4010y = -1;
        if (this.f3988c != null) {
            m2908k(this.f3987b);
            float[] fArr = this.f3987b;
            float f3 = fArr[0];
            f = fArr[1];
            f2 = f3;
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        this.f3998m.mo6768e(canvas, recyclerView, this.f3988c, this.f4001p, this.f3999n, f2, f);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        if (this.f3988c != null) {
            m2908k(this.f3987b);
            float[] fArr = this.f3987b;
            float f3 = fArr[0];
            f = fArr[1];
            f2 = f3;
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        this.f3998m.mo6769f(canvas, recyclerView, this.f3988c, this.f4001p, this.f3999n, f2, f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo6754p(C0899g gVar, int i) {
        this.f4003r.post(new C0896d(gVar, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo6755r(View view) {
        if (view == this.f4009x) {
            this.f4009x = null;
            if (this.f4008w != null) {
                this.f4003r.setChildDrawingOrderCallback((RecyclerView.ChildDrawingOrderCallback) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        if (r1 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo6756s() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r0.f3988c
            r2 = 0
            r3 = -9223372036854775808
            if (r1 != 0) goto L_0x000c
            r0.f3985D = r3
            return r2
        L_0x000c:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.f3985D
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0019
            r7 = 0
            goto L_0x001b
        L_0x0019:
            long r7 = r5 - r7
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r1 = r0.f4003r
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r1.getLayoutManager()
            android.graphics.Rect r9 = r0.f3984C
            if (r9 != 0) goto L_0x002c
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r0.f3984C = r9
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r0.f3988c
            android.view.View r9 = r9.itemView
            android.graphics.Rect r10 = r0.f3984C
            r1.calculateItemDecorationsForChild(r9, r10)
            boolean r9 = r1.canScrollHorizontally()
            r10 = 0
            if (r9 == 0) goto L_0x007d
            float r9 = r0.f3995j
            float r11 = r0.f3993h
            float r9 = r9 + r11
            int r9 = (int) r9
            android.graphics.Rect r11 = r0.f3984C
            int r11 = r11.left
            int r11 = r9 - r11
            androidx.recyclerview.widget.RecyclerView r12 = r0.f4003r
            int r12 = r12.getPaddingLeft()
            int r11 = r11 - r12
            float r12 = r0.f3993h
            int r13 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0059
            if (r11 >= 0) goto L_0x0059
            r12 = r11
            goto L_0x007e
        L_0x0059:
            int r11 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x007d
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f3988c
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            int r9 = r9 + r11
            android.graphics.Rect r11 = r0.f3984C
            int r11 = r11.right
            int r9 = r9 + r11
            androidx.recyclerview.widget.RecyclerView r11 = r0.f4003r
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f4003r
            int r12 = r12.getPaddingRight()
            int r11 = r11 - r12
            int r9 = r9 - r11
            if (r9 <= 0) goto L_0x007d
            r12 = r9
            goto L_0x007e
        L_0x007d:
            r12 = 0
        L_0x007e:
            boolean r1 = r1.canScrollVertically()
            if (r1 == 0) goto L_0x00c4
            float r1 = r0.f3996k
            float r9 = r0.f3994i
            float r1 = r1 + r9
            int r1 = (int) r1
            android.graphics.Rect r9 = r0.f3984C
            int r9 = r9.top
            int r9 = r1 - r9
            androidx.recyclerview.widget.RecyclerView r11 = r0.f4003r
            int r11 = r11.getPaddingTop()
            int r9 = r9 - r11
            float r11 = r0.f3994i
            int r13 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a1
            if (r9 >= 0) goto L_0x00a1
            r1 = r9
            goto L_0x00c5
        L_0x00a1:
            int r9 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r0.f3988c
            android.view.View r9 = r9.itemView
            int r9 = r9.getHeight()
            int r1 = r1 + r9
            android.graphics.Rect r9 = r0.f3984C
            int r9 = r9.bottom
            int r1 = r1 + r9
            androidx.recyclerview.widget.RecyclerView r9 = r0.f4003r
            int r9 = r9.getHeight()
            androidx.recyclerview.widget.RecyclerView r10 = r0.f4003r
            int r10 = r10.getPaddingBottom()
            int r9 = r9 - r10
            int r1 = r1 - r9
            if (r1 <= 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r1 = 0
        L_0x00c5:
            if (r12 == 0) goto L_0x00de
            androidx.recyclerview.widget.ItemTouchHelper$Callback r9 = r0.f3998m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f4003r
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f3988c
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r13 = r0.f4003r
            int r13 = r13.getWidth()
            r14 = r7
            int r12 = r9.interpolateOutOfBoundsScroll(r10, r11, r12, r13, r14)
        L_0x00de:
            r14 = r12
            if (r1 == 0) goto L_0x00fd
            androidx.recyclerview.widget.ItemTouchHelper$Callback r9 = r0.f3998m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f4003r
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f3988c
            android.view.View r11 = r11.itemView
            int r11 = r11.getHeight()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f4003r
            int r13 = r12.getHeight()
            r12 = r1
            r1 = r14
            r14 = r7
            int r7 = r9.interpolateOutOfBoundsScroll(r10, r11, r12, r13, r14)
            r12 = r1
            r1 = r7
            goto L_0x00fe
        L_0x00fd:
            r12 = r14
        L_0x00fe:
            if (r12 != 0) goto L_0x0106
            if (r1 == 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r0.f3985D = r3
            return r2
        L_0x0106:
            long r7 = r0.f3985D
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010e
            r0.f3985D = r5
        L_0x010e:
            androidx.recyclerview.widget.RecyclerView r2 = r0.f4003r
            r2.scrollBy(r12, r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.mo6756s():boolean");
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.f3998m.mo6762c(this.f4003r, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.f4003r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            mo6750o();
            this.f3994i = 0.0f;
            this.f3993h = 0.0f;
            mo6759t(viewHolder, 2);
        }
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.f3998m.mo6767d(this.f4003r, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.f4003r) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            mo6750o();
            this.f3994i = 0.0f;
            this.f3993h = 0.0f;
            mo6759t(viewHolder, 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0137  */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6759t(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
            r23 = this;
            r11 = r23
            r12 = r24
            r13 = r25
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r11.f3988c
            if (r12 != r0) goto L_0x000f
            int r0 = r11.f3999n
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.f3985D = r0
            int r4 = r11.f3999n
            r14 = 1
            r11.mo6745f(r12, r14)
            r11.f3999n = r13
            r15 = 2
            if (r13 != r15) goto L_0x0030
            if (r12 == 0) goto L_0x0028
            android.view.View r0 = r12.itemView
            r11.f4009x = r0
            r23.m2902a()
            goto L_0x0030
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r11.f3988c
            r8 = 0
            if (r9 == 0) goto L_0x00ee
            android.view.View r0 = r9.itemView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00da
            if (r4 != r15) goto L_0x004a
            r7 = 0
            goto L_0x004f
        L_0x004a:
            int r0 = r11.m2914x(r9)
            r7 = r0
        L_0x004f:
            r23.m2910q()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x007b
            if (r7 == r15) goto L_0x007b
            if (r7 == r0) goto L_0x0067
            if (r7 == r10) goto L_0x0067
            r2 = 16
            if (r7 == r2) goto L_0x0067
            r2 = 32
            if (r7 == r2) goto L_0x0067
            r17 = 0
            goto L_0x0078
        L_0x0067:
            float r2 = r11.f3993h
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f4003r
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r2
        L_0x0078:
            r18 = 0
            goto L_0x008e
        L_0x007b:
            float r2 = r11.f3994i
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f4003r
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r2
            r17 = 0
        L_0x008e:
            if (r4 != r15) goto L_0x0093
            r6 = 8
            goto L_0x0098
        L_0x0093:
            if (r7 <= 0) goto L_0x0097
            r6 = 2
            goto L_0x0098
        L_0x0097:
            r6 = 4
        L_0x0098:
            float[] r0 = r11.f3987b
            r11.m2908k(r0)
            float[] r0 = r11.f3987b
            r19 = r0[r8]
            r20 = r0[r14]
            androidx.recyclerview.widget.ItemTouchHelper$c r5 = new androidx.recyclerview.widget.ItemTouchHelper$c
            r0 = r5
            r1 = r23
            r2 = r9
            r3 = r6
            r14 = r5
            r5 = r19
            r15 = r6
            r6 = r20
            r21 = r7
            r7 = r17
            r8 = r18
            r22 = r9
            r9 = r21
            r21 = 8
            r10 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f3998m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f4003r
            float r2 = r17 - r19
            float r3 = r18 - r20
            long r0 = r0.getAnimationDuration(r1, r15, r2, r3)
            r14.mo6804b(r0)
            java.util.List<androidx.recyclerview.widget.ItemTouchHelper$g> r0 = r11.f4001p
            r0.add(r14)
            r14.mo6806d()
            r8 = 1
            goto L_0x00ea
        L_0x00da:
            r0 = r9
            r21 = 8
            android.view.View r1 = r0.itemView
            r11.mo6755r(r1)
            androidx.recyclerview.widget.ItemTouchHelper$Callback r1 = r11.f3998m
            androidx.recyclerview.widget.RecyclerView r2 = r11.f4003r
            r1.clearView(r2, r0)
            r8 = 0
        L_0x00ea:
            r0 = 0
            r11.f3988c = r0
            goto L_0x00f1
        L_0x00ee:
            r21 = 8
            r8 = 0
        L_0x00f1:
            if (r12 == 0) goto L_0x0122
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f3998m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f4003r
            int r0 = r0.mo6761a(r1, r12)
            r0 = r0 & r16
            int r1 = r11.f3999n
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.f4000o = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.f3995j = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.f3996k = r0
            r11.f3988c = r12
            r0 = 2
            if (r13 != r0) goto L_0x0122
            android.view.View r0 = r12.itemView
            r1 = 0
            r0.performHapticFeedback(r1)
            goto L_0x0123
        L_0x0122:
            r1 = 0
        L_0x0123:
            androidx.recyclerview.widget.RecyclerView r0 = r11.f4003r
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0135
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r11.f3988c
            if (r2 == 0) goto L_0x0131
            r14 = 1
            goto L_0x0132
        L_0x0131:
            r14 = 0
        L_0x0132:
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0135:
            if (r8 != 0) goto L_0x0140
            androidx.recyclerview.widget.RecyclerView r0 = r11.f4003r
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r0.requestSimpleAnimationsInNextLayout()
        L_0x0140:
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f3998m
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r11.f3988c
            int r2 = r11.f3999n
            r0.onSelectedChanged(r1, r2)
            androidx.recyclerview.widget.RecyclerView r0 = r11.f4003r
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.mo6759t(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo6760y(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.f3989d;
        this.f3993h = f;
        this.f3994i = y - this.f3990e;
        if ((i & 4) == 0) {
            this.f3993h = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.f3993h = Math.min(0.0f, this.f3993h);
        }
        if ((i & 1) == 0) {
            this.f3994i = Math.max(0.0f, this.f3994i);
        }
        if ((i & 2) == 0) {
            this.f3994i = Math.min(0.0f, this.f3994i);
        }
    }
}
