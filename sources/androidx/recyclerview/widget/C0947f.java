package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.f */
/* compiled from: LayoutState */
class C0947f {

    /* renamed from: a */
    boolean f4440a = true;

    /* renamed from: b */
    int f4441b;

    /* renamed from: c */
    int f4442c;

    /* renamed from: d */
    int f4443d;

    /* renamed from: e */
    int f4444e;

    /* renamed from: f */
    int f4445f = 0;

    /* renamed from: g */
    int f4446g = 0;

    /* renamed from: h */
    boolean f4447h;

    /* renamed from: i */
    boolean f4448i;

    C0947f() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo7692a(RecyclerView.State state) {
        int i = this.f4442c;
        return i >= 0 && i < state.getItemCount();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo7693b(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.f4442c);
        this.f4442c += this.f4443d;
        return viewForPosition;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4441b + ", mCurrentPosition=" + this.f4442c + ", mItemDirection=" + this.f4443d + ", mLayoutDirection=" + this.f4444e + ", mStartLine=" + this.f4445f + ", mEndLine=" + this.f4446g + '}';
    }
}
