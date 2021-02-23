package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.j */
/* compiled from: ViewInfoStore */
class C0958j {
    @VisibleForTesting

    /* renamed from: a */
    final ArrayMap<RecyclerView.ViewHolder, C0959a> f4472a = new ArrayMap<>();
    @VisibleForTesting

    /* renamed from: b */
    final LongSparseArray<RecyclerView.ViewHolder> f4473b = new LongSparseArray<>();

    /* renamed from: androidx.recyclerview.widget.j$a */
    /* compiled from: ViewInfoStore */
    static class C0959a {

        /* renamed from: d */
        static Pools.Pool<C0959a> f4474d = new Pools.SimplePool(20);

        /* renamed from: a */
        int f4475a;
        @Nullable

        /* renamed from: b */
        RecyclerView.ItemAnimator.ItemHolderInfo f4476b;
        @Nullable

        /* renamed from: c */
        RecyclerView.ItemAnimator.ItemHolderInfo f4477c;

        private C0959a() {
        }

        /* renamed from: a */
        static void m3569a() {
            do {
            } while (f4474d.acquire() != null);
        }

        /* renamed from: b */
        static C0959a m3570b() {
            C0959a acquire = f4474d.acquire();
            return acquire == null ? new C0959a() : acquire;
        }

        /* renamed from: c */
        static void m3571c(C0959a aVar) {
            aVar.f4475a = 0;
            aVar.f4476b = null;
            aVar.f4477c = null;
            f4474d.release(aVar);
        }
    }

    /* renamed from: androidx.recyclerview.widget.j$b */
    /* compiled from: ViewInfoStore */
    interface C0960b {
        /* renamed from: a */
        void mo7423a(RecyclerView.ViewHolder viewHolder);

        /* renamed from: b */
        void mo7424b(RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        /* renamed from: c */
        void mo7425c(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        /* renamed from: d */
        void mo7426d(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    C0958j() {
    }

    /* renamed from: l */
    private RecyclerView.ItemAnimator.ItemHolderInfo m3552l(RecyclerView.ViewHolder viewHolder, int i) {
        C0959a valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.f4472a.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = this.f4472a.valueAt(indexOfKey)) != null) {
            int i2 = valueAt.f4475a;
            if ((i2 & i) != 0) {
                int i3 = (i ^ -1) & i2;
                valueAt.f4475a = i3;
                if (i == 4) {
                    itemHolderInfo = valueAt.f4476b;
                } else if (i == 8) {
                    itemHolderInfo = valueAt.f4477c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.f4472a.removeAt(indexOfKey);
                    C0959a.m3571c(valueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7705a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        C0959a aVar = this.f4472a.get(viewHolder);
        if (aVar == null) {
            aVar = C0959a.m3570b();
            this.f4472a.put(viewHolder, aVar);
        }
        aVar.f4475a |= 2;
        aVar.f4476b = itemHolderInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7706b(RecyclerView.ViewHolder viewHolder) {
        C0959a aVar = this.f4472a.get(viewHolder);
        if (aVar == null) {
            aVar = C0959a.m3570b();
            this.f4472a.put(viewHolder, aVar);
        }
        aVar.f4475a |= 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7707c(long j, RecyclerView.ViewHolder viewHolder) {
        this.f4473b.put(j, viewHolder);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo7708d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        C0959a aVar = this.f4472a.get(viewHolder);
        if (aVar == null) {
            aVar = C0959a.m3570b();
            this.f4472a.put(viewHolder, aVar);
        }
        aVar.f4477c = itemHolderInfo;
        aVar.f4475a |= 8;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo7709e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        C0959a aVar = this.f4472a.get(viewHolder);
        if (aVar == null) {
            aVar = C0959a.m3570b();
            this.f4472a.put(viewHolder, aVar);
        }
        aVar.f4476b = itemHolderInfo;
        aVar.f4475a |= 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo7710f() {
        this.f4472a.clear();
        this.f4473b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public RecyclerView.ViewHolder mo7711g(long j) {
        return this.f4473b.get(j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo7712h(RecyclerView.ViewHolder viewHolder) {
        C0959a aVar = this.f4472a.get(viewHolder);
        if (aVar == null || (aVar.f4475a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo7713i(RecyclerView.ViewHolder viewHolder) {
        C0959a aVar = this.f4472a.get(viewHolder);
        return (aVar == null || (aVar.f4475a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo7714j() {
        C0959a.m3569a();
    }

    /* renamed from: k */
    public void mo7715k(RecyclerView.ViewHolder viewHolder) {
        mo7719p(viewHolder);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: m */
    public RecyclerView.ItemAnimator.ItemHolderInfo mo7716m(RecyclerView.ViewHolder viewHolder) {
        return m3552l(viewHolder, 8);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: n */
    public RecyclerView.ItemAnimator.ItemHolderInfo mo7717n(RecyclerView.ViewHolder viewHolder) {
        return m3552l(viewHolder, 4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo7718o(C0960b bVar) {
        for (int size = this.f4472a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder keyAt = this.f4472a.keyAt(size);
            C0959a removeAt = this.f4472a.removeAt(size);
            int i = removeAt.f4475a;
            if ((i & 3) == 3) {
                bVar.mo7423a(keyAt);
            } else if ((i & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = removeAt.f4476b;
                if (itemHolderInfo == null) {
                    bVar.mo7423a(keyAt);
                } else {
                    bVar.mo7425c(keyAt, itemHolderInfo, removeAt.f4477c);
                }
            } else if ((i & 14) == 14) {
                bVar.mo7424b(keyAt, removeAt.f4476b, removeAt.f4477c);
            } else if ((i & 12) == 12) {
                bVar.mo7426d(keyAt, removeAt.f4476b, removeAt.f4477c);
            } else if ((i & 4) != 0) {
                bVar.mo7425c(keyAt, removeAt.f4476b, (RecyclerView.ItemAnimator.ItemHolderInfo) null);
            } else if ((i & 8) != 0) {
                bVar.mo7424b(keyAt, removeAt.f4476b, removeAt.f4477c);
            }
            C0959a.m3571c(removeAt);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo7719p(RecyclerView.ViewHolder viewHolder) {
        C0959a aVar = this.f4472a.get(viewHolder);
        if (aVar != null) {
            aVar.f4475a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo7720q(RecyclerView.ViewHolder viewHolder) {
        int size = this.f4473b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (viewHolder == this.f4473b.valueAt(size)) {
                this.f4473b.removeAt(size);
                break;
            } else {
                size--;
            }
        }
        C0959a remove = this.f4472a.remove(viewHolder);
        if (remove != null) {
            C0959a.m3571c(remove);
        }
    }
}
