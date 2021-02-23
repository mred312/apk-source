package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.core.p003os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.recyclerview.widget.d */
/* compiled from: GapWorker */
final class C0942d implements Runnable {

    /* renamed from: e */
    static final ThreadLocal<C0942d> f4424e = new ThreadLocal<>();

    /* renamed from: f */
    static Comparator<C0945c> f4425f = new C0943a();

    /* renamed from: a */
    ArrayList<RecyclerView> f4426a = new ArrayList<>();

    /* renamed from: b */
    long f4427b;

    /* renamed from: c */
    long f4428c;

    /* renamed from: d */
    private ArrayList<C0945c> f4429d = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.d$a */
    /* compiled from: GapWorker */
    static class C0943a implements Comparator<C0945c> {
        C0943a() {
        }

        /* renamed from: a */
        public int compare(C0945c cVar, C0945c cVar2) {
            RecyclerView recyclerView = cVar.f4437d;
            if ((recyclerView == null) != (cVar2.f4437d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = cVar.f4434a;
            if (z == cVar2.f4434a) {
                int i = cVar2.f4435b - cVar.f4435b;
                if (i != 0) {
                    return i;
                }
                int i2 = cVar.f4436c - cVar2.f4436c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            } else if (z) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$b */
    /* compiled from: GapWorker */
    static class C0944b implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a */
        int f4430a;

        /* renamed from: b */
        int f4431b;

        /* renamed from: c */
        int[] f4432c;

        /* renamed from: d */
        int f4433d;

        C0944b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7687a() {
            int[] iArr = this.f4432c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4433d = 0;
        }

        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f4433d * 2;
                int[] iArr = this.f4432c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f4432c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.f4432c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f4432c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.f4433d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7688b(RecyclerView recyclerView, boolean z) {
            this.f4433d = 0;
            int[] iArr = this.f4432c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.f4143m;
            if (recyclerView.f4141l != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.f4125d.mo7629p()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.f4141l.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.f4430a, this.f4431b, recyclerView.f4134h0, this);
                }
                int i = this.f4433d;
                if (i > layoutManager.f4190m) {
                    layoutManager.f4190m = i;
                    layoutManager.f4191n = z;
                    recyclerView.f4121b.mo7296E();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo7689c(int i) {
            if (this.f4432c != null) {
                int i2 = this.f4433d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f4432c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7690d(int i, int i2) {
            this.f4430a = i;
            this.f4431b = i2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$c */
    /* compiled from: GapWorker */
    static class C0945c {

        /* renamed from: a */
        public boolean f4434a;

        /* renamed from: b */
        public int f4435b;

        /* renamed from: c */
        public int f4436c;

        /* renamed from: d */
        public RecyclerView f4437d;

        /* renamed from: e */
        public int f4438e;

        C0945c() {
        }

        /* renamed from: a */
        public void mo7691a() {
            this.f4434a = false;
            this.f4435b = 0;
            this.f4436c = 0;
            this.f4437d = null;
            this.f4438e = 0;
        }
    }

    C0942d() {
    }

    /* renamed from: b */
    private void m3508b() {
        C0945c cVar;
        int size = this.f4426a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f4426a.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f4132g0.mo7688b(recyclerView, false);
                i += recyclerView.f4132g0.f4433d;
            }
        }
        this.f4429d.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f4426a.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                C0944b bVar = recyclerView2.f4132g0;
                int abs = Math.abs(bVar.f4430a) + Math.abs(bVar.f4431b);
                for (int i5 = 0; i5 < bVar.f4433d * 2; i5 += 2) {
                    if (i3 >= this.f4429d.size()) {
                        cVar = new C0945c();
                        this.f4429d.add(cVar);
                    } else {
                        cVar = this.f4429d.get(i3);
                    }
                    int[] iArr = bVar.f4432c;
                    int i6 = iArr[i5 + 1];
                    cVar.f4434a = i6 <= abs;
                    cVar.f4435b = abs;
                    cVar.f4436c = i6;
                    cVar.f4437d = recyclerView2;
                    cVar.f4438e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f4429d, f4425f);
    }

    /* renamed from: c */
    private void m3509c(C0945c cVar, long j) {
        RecyclerView.ViewHolder i = m3513i(cVar.f4437d, cVar.f4438e, cVar.f4434a ? Long.MAX_VALUE : j);
        if (i != null && i.f4251a != null && i.mo7404m() && !i.mo7405n()) {
            m3512h((RecyclerView) i.f4251a.get(), j);
        }
    }

    /* renamed from: d */
    private void m3510d(long j) {
        int i = 0;
        while (i < this.f4429d.size()) {
            C0945c cVar = this.f4429d.get(i);
            if (cVar.f4437d != null) {
                m3509c(cVar, j);
                cVar.mo7691a();
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    static boolean m3511e(RecyclerView recyclerView, int i) {
        int j = recyclerView.f4127e.mo7650j();
        for (int i2 = 0; i2 < j; i2++) {
            RecyclerView.ViewHolder S = RecyclerView.m3023S(recyclerView.f4127e.mo7649i(i2));
            if (S.f4252b == i && !S.mo7405n()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private void m3512h(@Nullable RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.f4099D && recyclerView.f4127e.mo7650j() != 0) {
                recyclerView.mo7082y0();
            }
            C0944b bVar = recyclerView.f4132g0;
            bVar.mo7688b(recyclerView, true);
            if (bVar.f4433d != 0) {
                try {
                    TraceCompat.beginSection("RV Nested Prefetch");
                    recyclerView.f4134h0.mo7365b(recyclerView.f4141l);
                    for (int i = 0; i < bVar.f4433d * 2; i += 2) {
                        m3513i(recyclerView, bVar.f4432c[i], j);
                    }
                } finally {
                    TraceCompat.endSection();
                }
            }
        }
    }

    /* renamed from: i */
    private RecyclerView.ViewHolder m3513i(RecyclerView recyclerView, int i, long j) {
        if (m3511e(recyclerView, i)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.f4121b;
        try {
            recyclerView.mo7014m0();
            RecyclerView.ViewHolder C = recycler.mo7294C(i, false, j);
            if (C != null) {
                if (!C.mo7404m() || C.mo7405n()) {
                    recycler.mo7299a(C, false);
                } else {
                    recycler.recycleView(C.itemView);
                }
            }
            return C;
        } finally {
            recyclerView.mo7017o0(false);
        }
    }

    /* renamed from: a */
    public void mo7680a(RecyclerView recyclerView) {
        this.f4426a.add(recyclerView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo7681f(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f4427b == 0) {
            this.f4427b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f4132g0.mo7690d(i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo7682g(long j) {
        m3508b();
        m3510d(j);
    }

    /* renamed from: j */
    public void mo7683j(RecyclerView recyclerView) {
        this.f4426a.remove(recyclerView);
    }

    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.f4426a.isEmpty()) {
                int size = this.f4426a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f4426a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    mo7682g(TimeUnit.MILLISECONDS.toNanos(j) + this.f4428c);
                    this.f4427b = 0;
                    TraceCompat.endSection();
                }
            }
        } finally {
            this.f4427b = 0;
            TraceCompat.endSection();
        }
    }
}
