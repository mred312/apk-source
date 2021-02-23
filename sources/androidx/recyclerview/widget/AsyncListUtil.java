package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {

    /* renamed from: a */
    final Class<T> f3863a;

    /* renamed from: b */
    final int f3864b;

    /* renamed from: c */
    final DataCallback<T> f3865c;

    /* renamed from: d */
    final ViewCallback f3866d;

    /* renamed from: e */
    final TileList<T> f3867e;

    /* renamed from: f */
    final ThreadUtil.MainThreadCallback<T> f3868f;

    /* renamed from: g */
    final ThreadUtil.BackgroundCallback<T> f3869g;

    /* renamed from: h */
    final int[] f3870h = new int[2];

    /* renamed from: i */
    final int[] f3871i = new int[2];

    /* renamed from: j */
    final int[] f3872j = new int[2];

    /* renamed from: k */
    boolean f3873k;

    /* renamed from: l */
    private int f3874l = 0;

    /* renamed from: m */
    int f3875m = 0;

    /* renamed from: n */
    int f3876n = 0;

    /* renamed from: o */
    int f3877o = 0;

    /* renamed from: p */
    final SparseIntArray f3878p = new SparseIntArray();

    /* renamed from: q */
    private final ThreadUtil.MainThreadCallback<T> f3879q;

    /* renamed from: r */
    private final ThreadUtil.BackgroundCallback<T> f3880r;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i, int i2);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i);
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$a */
    class C0875a implements ThreadUtil.MainThreadCallback<T> {
        C0875a() {
        }

        /* renamed from: a */
        private boolean m2850a(int i) {
            return i == AsyncListUtil.this.f3877o;
        }

        /* renamed from: b */
        private void m2851b() {
            for (int i = 0; i < AsyncListUtil.this.f3867e.mo7610f(); i++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.f3869g.recycleTile(asyncListUtil.f3867e.mo7607c(i));
            }
            AsyncListUtil.this.f3867e.mo7606b();
        }

        public void addTile(int i, TileList.Tile<T> tile) {
            if (!m2850a(i)) {
                AsyncListUtil.this.f3869g.recycleTile(tile);
                return;
            }
            TileList.Tile<T> a = AsyncListUtil.this.f3867e.mo7605a(tile);
            if (a != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + a.mStartPosition);
                AsyncListUtil.this.f3869g.recycleTile(a);
            }
            int i2 = tile.mStartPosition + tile.mItemCount;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.f3878p.size()) {
                int keyAt = AsyncListUtil.this.f3878p.keyAt(i3);
                if (tile.mStartPosition > keyAt || keyAt >= i2) {
                    i3++;
                } else {
                    AsyncListUtil.this.f3878p.removeAt(i3);
                    AsyncListUtil.this.f3866d.onItemLoaded(keyAt);
                }
            }
        }

        public void removeTile(int i, int i2) {
            if (m2850a(i)) {
                TileList.Tile<T> e = AsyncListUtil.this.f3867e.mo7609e(i2);
                if (e == null) {
                    Log.e("AsyncListUtil", "tile not found @" + i2);
                    return;
                }
                AsyncListUtil.this.f3869g.recycleTile(e);
            }
        }

        public void updateItemCount(int i, int i2) {
            if (m2850a(i)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.f3875m = i2;
                asyncListUtil.f3866d.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.f3876n = asyncListUtil2.f3877o;
                m2851b();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.f3873k = false;
                asyncListUtil3.mo6640b();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$b */
    class C0876b implements ThreadUtil.BackgroundCallback<T> {

        /* renamed from: a */
        private TileList.Tile<T> f3882a;

        /* renamed from: b */
        final SparseBooleanArray f3883b = new SparseBooleanArray();

        /* renamed from: c */
        private int f3884c;

        /* renamed from: d */
        private int f3885d;

        /* renamed from: e */
        private int f3886e;

        /* renamed from: f */
        private int f3887f;

        C0876b() {
        }

        /* renamed from: a */
        private TileList.Tile<T> m2852a() {
            TileList.Tile<T> tile = this.f3882a;
            if (tile != null) {
                this.f3882a = tile.f4363a;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile<>(asyncListUtil.f3863a, asyncListUtil.f3864b);
        }

        /* renamed from: b */
        private void m2853b(TileList.Tile<T> tile) {
            this.f3883b.put(tile.mStartPosition, true);
            AsyncListUtil.this.f3868f.addTile(this.f3884c, tile);
        }

        /* renamed from: c */
        private void m2854c(int i) {
            int maxCachedTiles = AsyncListUtil.this.f3865c.getMaxCachedTiles();
            while (this.f3883b.size() >= maxCachedTiles) {
                int keyAt = this.f3883b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f3883b;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i2 = this.f3886e - keyAt;
                int i3 = keyAt2 - this.f3887f;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    m2857f(keyAt);
                } else if (i3 <= 0) {
                    return;
                } else {
                    if (i2 < i3 || i == 1) {
                        m2857f(keyAt2);
                    } else {
                        return;
                    }
                }
            }
        }

        /* renamed from: d */
        private int m2855d(int i) {
            return i - (i % AsyncListUtil.this.f3864b);
        }

        /* renamed from: e */
        private boolean m2856e(int i) {
            return this.f3883b.get(i);
        }

        /* renamed from: f */
        private void m2857f(int i) {
            this.f3883b.delete(i);
            AsyncListUtil.this.f3868f.removeTile(this.f3884c, i);
        }

        /* renamed from: g */
        private void m2858g(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.f3869g.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.f3864b;
            }
        }

        public void loadTile(int i, int i2) {
            if (!m2856e(i)) {
                TileList.Tile a = m2852a();
                a.mStartPosition = i;
                int min = Math.min(AsyncListUtil.this.f3864b, this.f3885d - i);
                a.mItemCount = min;
                AsyncListUtil.this.f3865c.fillData(a.mItems, a.mStartPosition, min);
                m2854c(i2);
                m2853b(a);
            }
        }

        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.f3865c.recycleData(tile.mItems, tile.mItemCount);
            tile.f4363a = this.f3882a;
            this.f3882a = tile;
        }

        public void refresh(int i) {
            this.f3884c = i;
            this.f3883b.clear();
            int refreshData = AsyncListUtil.this.f3865c.refreshData();
            this.f3885d = refreshData;
            AsyncListUtil.this.f3868f.updateItemCount(this.f3884c, refreshData);
        }

        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                int d = m2855d(i);
                int d2 = m2855d(i2);
                this.f3886e = m2855d(i3);
                int d3 = m2855d(i4);
                this.f3887f = d3;
                if (i5 == 1) {
                    m2858g(this.f3886e, d2, i5, true);
                    m2858g(d2 + AsyncListUtil.this.f3864b, this.f3887f, i5, false);
                    return;
                }
                m2858g(d, d3, i5, false);
                m2858g(this.f3886e, d - AsyncListUtil.this.f3864b, i5, true);
            }
        }
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        C0875a aVar = new C0875a();
        this.f3879q = aVar;
        C0876b bVar = new C0876b();
        this.f3880r = bVar;
        this.f3863a = cls;
        this.f3864b = i;
        this.f3865c = dataCallback;
        this.f3866d = viewCallback;
        this.f3867e = new TileList<>(i);
        C0948g gVar = new C0948g();
        this.f3868f = gVar.mo7604b(aVar);
        this.f3869g = gVar.mo7603a(bVar);
        refresh();
    }

    /* renamed from: a */
    private boolean m2848a() {
        return this.f3877o != this.f3876n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6640b() {
        this.f3866d.getItemRangeInto(this.f3870h);
        int[] iArr = this.f3870h;
        if (iArr[0] <= iArr[1] && iArr[0] >= 0 && iArr[1] < this.f3875m) {
            if (!this.f3873k) {
                this.f3874l = 0;
            } else {
                int i = iArr[0];
                int[] iArr2 = this.f3871i;
                if (i > iArr2[1] || iArr2[0] > iArr[1]) {
                    this.f3874l = 0;
                } else if (iArr[0] < iArr2[0]) {
                    this.f3874l = 1;
                } else if (iArr[0] > iArr2[0]) {
                    this.f3874l = 2;
                }
            }
            int[] iArr3 = this.f3871i;
            iArr3[0] = iArr[0];
            iArr3[1] = iArr[1];
            this.f3866d.extendRangeInto(iArr, this.f3872j, this.f3874l);
            int[] iArr4 = this.f3872j;
            iArr4[0] = Math.min(this.f3870h[0], Math.max(iArr4[0], 0));
            int[] iArr5 = this.f3872j;
            iArr5[1] = Math.max(this.f3870h[1], Math.min(iArr5[1], this.f3875m - 1));
            ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f3869g;
            int[] iArr6 = this.f3870h;
            int i2 = iArr6[0];
            int i3 = iArr6[1];
            int[] iArr7 = this.f3872j;
            backgroundCallback.updateRange(i2, i3, iArr7[0], iArr7[1], this.f3874l);
        }
    }

    @Nullable
    public T getItem(int i) {
        if (i < 0 || i >= this.f3875m) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.f3875m);
        }
        T d = this.f3867e.mo7608d(i);
        if (d == null && !m2848a()) {
            this.f3878p.put(i, 0);
        }
        return d;
    }

    public int getItemCount() {
        return this.f3875m;
    }

    public void onRangeChanged() {
        if (!m2848a()) {
            mo6640b();
            this.f3873k = true;
        }
    }

    public void refresh() {
        this.f3878p.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f3869g;
        int i = this.f3877o + 1;
        this.f3877o = i;
        backgroundCallback.refresh(i);
    }
}
