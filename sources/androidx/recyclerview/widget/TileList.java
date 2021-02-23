package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

class TileList<T> {

    /* renamed from: a */
    final int f4360a;

    /* renamed from: b */
    private final SparseArray<Tile<T>> f4361b = new SparseArray<>(10);

    /* renamed from: c */
    Tile<T> f4362c;

    public static class Tile<T> {

        /* renamed from: a */
        Tile<T> f4363a;
        public int mItemCount;
        public final T[] mItems;
        public int mStartPosition;

        public Tile(Class<T> cls, int i) {
            this.mItems = (Object[]) Array.newInstance(cls, i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo7611a(int i) {
            int i2 = this.mStartPosition;
            return i2 <= i && i < i2 + this.mItemCount;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public T mo7612b(int i) {
            return this.mItems[i - this.mStartPosition];
        }
    }

    public TileList(int i) {
        this.f4360a = i;
    }

    /* renamed from: a */
    public Tile<T> mo7605a(Tile<T> tile) {
        int indexOfKey = this.f4361b.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.f4361b.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.f4361b.valueAt(indexOfKey);
        this.f4361b.setValueAt(indexOfKey, tile);
        if (this.f4362c == valueAt) {
            this.f4362c = tile;
        }
        return valueAt;
    }

    /* renamed from: b */
    public void mo7606b() {
        this.f4361b.clear();
    }

    /* renamed from: c */
    public Tile<T> mo7607c(int i) {
        return this.f4361b.valueAt(i);
    }

    /* renamed from: d */
    public T mo7608d(int i) {
        Tile<T> tile = this.f4362c;
        if (tile == null || !tile.mo7611a(i)) {
            int indexOfKey = this.f4361b.indexOfKey(i - (i % this.f4360a));
            if (indexOfKey < 0) {
                return null;
            }
            this.f4362c = this.f4361b.valueAt(indexOfKey);
        }
        return this.f4362c.mo7612b(i);
    }

    /* renamed from: e */
    public Tile<T> mo7609e(int i) {
        Tile<T> tile = this.f4361b.get(i);
        if (this.f4362c == tile) {
            this.f4362c = null;
        }
        this.f4361b.delete(i);
        return tile;
    }

    /* renamed from: f */
    public int mo7610f() {
        return this.f4361b.size();
    }
}
