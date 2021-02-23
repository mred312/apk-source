package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {
    public static final int INVALID_POSITION = -1;

    /* renamed from: a */
    T[] f4292a;

    /* renamed from: b */
    private T[] f4293b;

    /* renamed from: c */
    private int f4294c;

    /* renamed from: d */
    private int f4295d;

    /* renamed from: e */
    private int f4296e;

    /* renamed from: f */
    private Callback f4297f;

    /* renamed from: g */
    private BatchedCallback f4298g;

    /* renamed from: h */
    private int f4299h;

    /* renamed from: i */
    private final Class<T> f4300i;

    public static class BatchedCallback<T2> extends Callback<T2> {

        /* renamed from: a */
        final Callback<T2> f4301a;

        /* renamed from: b */
        private final BatchingListUpdateCallback f4302b;

        public BatchedCallback(Callback<T2> callback) {
            this.f4301a = callback;
            this.f4302b = new BatchingListUpdateCallback(callback);
        }

        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.f4301a.areContentsTheSame(t2, t22);
        }

        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.f4301a.areItemsTheSame(t2, t22);
        }

        public int compare(T2 t2, T2 t22) {
            return this.f4301a.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.f4302b.dispatchLastEvent();
        }

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.f4301a.getChangePayload(t2, t22);
        }

        public void onChanged(int i, int i2) {
            this.f4302b.onChanged(i, i2, (Object) null);
        }

        public void onInserted(int i, int i2) {
            this.f4302b.onInserted(i, i2);
        }

        public void onMoved(int i, int i2) {
            this.f4302b.onMoved(i, i2);
        }

        public void onRemoved(int i, int i2) {
            this.f4302b.onRemoved(i, i2);
        }

        public void onChanged(int i, int i2, Object obj) {
            this.f4302b.onChanged(i, i2, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i, int i2);

        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    /* renamed from: a */
    private int m3273a(T t, boolean z) {
        int e = m3277e(t, this.f4292a, 0, this.f4299h, 1);
        if (e == -1) {
            e = 0;
        } else if (e < this.f4299h) {
            T t2 = this.f4292a[e];
            if (this.f4297f.areItemsTheSame(t2, t)) {
                if (this.f4297f.areContentsTheSame(t2, t)) {
                    this.f4292a[e] = t;
                    return e;
                }
                this.f4292a[e] = t;
                Callback callback = this.f4297f;
                callback.onChanged(e, 1, callback.getChangePayload(t2, t));
                return e;
            }
        }
        m3275c(e, t);
        if (z) {
            this.f4297f.onInserted(e, 1);
        }
        return e;
    }

    /* renamed from: b */
    private void m3274b(T[] tArr) {
        if (tArr.length >= 1) {
            int n = m3286n(tArr);
            if (this.f4299h == 0) {
                this.f4292a = tArr;
                this.f4299h = n;
                this.f4297f.onInserted(0, n);
                return;
            }
            m3280h(tArr, n);
        }
    }

    /* renamed from: c */
    private void m3275c(int i, T t) {
        int i2 = this.f4299h;
        if (i <= i2) {
            T[] tArr = this.f4292a;
            if (i2 == tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(this.f4300i, tArr.length + 10);
                System.arraycopy(this.f4292a, 0, tArr2, 0, i);
                tArr2[i] = t;
                System.arraycopy(this.f4292a, i, tArr2, i + 1, this.f4299h - i);
                this.f4292a = tArr2;
            } else {
                System.arraycopy(tArr, i, tArr, i + 1, i2 - i);
                this.f4292a[i] = t;
            }
            this.f4299h++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.f4299h);
    }

    /* renamed from: d */
    private T[] m3276d(T[] tArr) {
        T[] tArr2 = (Object[]) Array.newInstance(this.f4300i, tArr.length);
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    /* renamed from: e */
    private int m3277e(T t, T[] tArr, int i, int i2, int i3) {
        while (i < i2) {
            int i4 = (i + i2) / 2;
            T t2 = tArr[i4];
            int compare = this.f4297f.compare(t2, t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare != 0) {
                i2 = i4;
            } else if (this.f4297f.areItemsTheSame(t2, t)) {
                return i4;
            } else {
                int g = m3279g(t, i4, i, i2);
                if (i3 == 1) {
                    return g == -1 ? i4 : g;
                }
                return g;
            }
        }
        if (i3 == 1) {
            return i;
        }
        return -1;
    }

    /* renamed from: f */
    private int m3278f(T t, T[] tArr, int i, int i2) {
        while (i < i2) {
            if (this.f4297f.areItemsTheSame(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: g */
    private int m3279g(T t, int i, int i2, int i3) {
        T t2;
        int i4 = i - 1;
        while (i4 >= i2) {
            T t3 = this.f4292a[i4];
            if (this.f4297f.compare(t3, t) != 0) {
                break;
            } else if (this.f4297f.areItemsTheSame(t3, t)) {
                return i4;
            } else {
                i4--;
            }
        }
        do {
            i++;
            if (i >= i3) {
                return -1;
            }
            t2 = this.f4292a[i];
            if (this.f4297f.compare(t2, t) != 0) {
                return -1;
            }
        } while (!this.f4297f.areItemsTheSame(t2, t));
        return i;
    }

    /* renamed from: h */
    private void m3280h(T[] tArr, int i) {
        boolean z = !(this.f4297f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f4293b = this.f4292a;
        int i2 = 0;
        this.f4294c = 0;
        int i3 = this.f4299h;
        this.f4295d = i3;
        this.f4292a = (Object[]) Array.newInstance(this.f4300i, i3 + i + 10);
        this.f4296e = 0;
        while (true) {
            int i4 = this.f4294c;
            int i5 = this.f4295d;
            if (i4 >= i5 && i2 >= i) {
                break;
            } else if (i4 == i5) {
                int i6 = i - i2;
                System.arraycopy(tArr, i2, this.f4292a, this.f4296e, i6);
                int i7 = this.f4296e + i6;
                this.f4296e = i7;
                this.f4299h += i6;
                this.f4297f.onInserted(i7 - i6, i6);
                break;
            } else if (i2 == i) {
                int i8 = i5 - i4;
                System.arraycopy(this.f4293b, i4, this.f4292a, this.f4296e, i8);
                this.f4296e += i8;
                break;
            } else {
                T t = this.f4293b[i4];
                T t2 = tArr[i2];
                int compare = this.f4297f.compare(t, t2);
                if (compare > 0) {
                    T[] tArr2 = this.f4292a;
                    int i9 = this.f4296e;
                    int i10 = i9 + 1;
                    this.f4296e = i10;
                    tArr2[i9] = t2;
                    this.f4299h++;
                    i2++;
                    this.f4297f.onInserted(i10 - 1, 1);
                } else if (compare != 0 || !this.f4297f.areItemsTheSame(t, t2)) {
                    T[] tArr3 = this.f4292a;
                    int i11 = this.f4296e;
                    this.f4296e = i11 + 1;
                    tArr3[i11] = t;
                    this.f4294c++;
                } else {
                    T[] tArr4 = this.f4292a;
                    int i12 = this.f4296e;
                    this.f4296e = i12 + 1;
                    tArr4[i12] = t2;
                    i2++;
                    this.f4294c++;
                    if (!this.f4297f.areContentsTheSame(t, t2)) {
                        Callback callback = this.f4297f;
                        callback.onChanged(this.f4296e - 1, 1, callback.getChangePayload(t, t2));
                    }
                }
            }
        }
        this.f4293b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    /* renamed from: i */
    private boolean m3281i(T t, boolean z) {
        int e = m3277e(t, this.f4292a, 0, this.f4299h, 2);
        if (e == -1) {
            return false;
        }
        m3282j(e, z);
        return true;
    }

    /* renamed from: j */
    private void m3282j(int i, boolean z) {
        T[] tArr = this.f4292a;
        System.arraycopy(tArr, i + 1, tArr, i, (this.f4299h - i) - 1);
        int i2 = this.f4299h - 1;
        this.f4299h = i2;
        this.f4292a[i2] = null;
        if (z) {
            this.f4297f.onRemoved(i, 1);
        }
    }

    /* renamed from: k */
    private void m3283k(T t) {
        T[] tArr = this.f4292a;
        int i = this.f4296e;
        tArr[i] = t;
        int i2 = i + 1;
        this.f4296e = i2;
        this.f4299h++;
        this.f4297f.onInserted(i2 - 1, 1);
    }

    /* renamed from: l */
    private void m3284l(@NonNull T[] tArr) {
        boolean z = !(this.f4297f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f4294c = 0;
        this.f4295d = this.f4299h;
        this.f4293b = this.f4292a;
        this.f4296e = 0;
        int n = m3286n(tArr);
        this.f4292a = (Object[]) Array.newInstance(this.f4300i, n);
        while (true) {
            int i = this.f4296e;
            if (i >= n && this.f4294c >= this.f4295d) {
                break;
            }
            int i2 = this.f4294c;
            int i3 = this.f4295d;
            if (i2 >= i3) {
                int i4 = n - i;
                System.arraycopy(tArr, i, this.f4292a, i, i4);
                this.f4296e += i4;
                this.f4299h += i4;
                this.f4297f.onInserted(i, i4);
                break;
            } else if (i >= n) {
                int i5 = i3 - i2;
                this.f4299h -= i5;
                this.f4297f.onRemoved(i, i5);
                break;
            } else {
                T t = this.f4293b[i2];
                T t2 = tArr[i];
                int compare = this.f4297f.compare(t, t2);
                if (compare < 0) {
                    m3285m();
                } else if (compare > 0) {
                    m3283k(t2);
                } else if (!this.f4297f.areItemsTheSame(t, t2)) {
                    m3285m();
                    m3283k(t2);
                } else {
                    T[] tArr2 = this.f4292a;
                    int i6 = this.f4296e;
                    tArr2[i6] = t2;
                    this.f4294c++;
                    this.f4296e = i6 + 1;
                    if (!this.f4297f.areContentsTheSame(t, t2)) {
                        Callback callback = this.f4297f;
                        callback.onChanged(this.f4296e - 1, 1, callback.getChangePayload(t, t2));
                    }
                }
            }
        }
        this.f4293b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    /* renamed from: m */
    private void m3285m() {
        this.f4299h--;
        this.f4294c++;
        this.f4297f.onRemoved(this.f4296e, 1);
    }

    /* renamed from: n */
    private int m3286n(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.f4297f);
        int i = 1;
        int i2 = 0;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T t = tArr[i3];
            if (this.f4297f.compare(tArr[i2], t) == 0) {
                int f = m3278f(t, tArr, i2, i);
                if (f != -1) {
                    tArr[f] = t;
                } else {
                    if (i != i3) {
                        tArr[i] = t;
                    }
                    i++;
                }
            } else {
                if (i != i3) {
                    tArr[i] = t;
                }
                i2 = i;
                i++;
            }
        }
        return i;
    }

    /* renamed from: o */
    private void m3287o() {
        if (this.f4293b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t) {
        m3287o();
        return m3273a(t, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z) {
        m3287o();
        if (tArr.length != 0) {
            if (z) {
                m3274b(tArr);
            } else {
                m3274b(m3276d(tArr));
            }
        }
    }

    public void beginBatchedUpdates() {
        m3287o();
        Callback callback = this.f4297f;
        if (!(callback instanceof BatchedCallback)) {
            if (this.f4298g == null) {
                this.f4298g = new BatchedCallback(callback);
            }
            this.f4297f = this.f4298g;
        }
    }

    public void clear() {
        m3287o();
        int i = this.f4299h;
        if (i != 0) {
            Arrays.fill(this.f4292a, 0, i, (Object) null);
            this.f4299h = 0;
            this.f4297f.onRemoved(0, i);
        }
    }

    public void endBatchedUpdates() {
        m3287o();
        Callback callback = this.f4297f;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.f4297f;
        BatchedCallback batchedCallback = this.f4298g;
        if (callback2 == batchedCallback) {
            this.f4297f = batchedCallback.f4301a;
        }
    }

    public T get(int i) {
        int i2;
        if (i >= this.f4299h || i < 0) {
            throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.f4299h);
        }
        T[] tArr = this.f4293b;
        if (tArr == null || i < (i2 = this.f4296e)) {
            return this.f4292a[i];
        }
        return tArr[(i - i2) + this.f4294c];
    }

    public int indexOf(T t) {
        if (this.f4293b != null) {
            int e = m3277e(t, this.f4292a, 0, this.f4296e, 4);
            if (e != -1) {
                return e;
            }
            int e2 = m3277e(t, this.f4293b, this.f4294c, this.f4295d, 4);
            if (e2 != -1) {
                return (e2 - this.f4294c) + this.f4296e;
            }
            return -1;
        }
        return m3277e(t, this.f4292a, 0, this.f4299h, 4);
    }

    public void recalculatePositionOfItemAt(int i) {
        m3287o();
        Object obj = get(i);
        m3282j(i, false);
        int a = m3273a(obj, false);
        if (i != a) {
            this.f4297f.onMoved(i, a);
        }
    }

    public boolean remove(T t) {
        m3287o();
        return m3281i(t, true);
    }

    public T removeItemAt(int i) {
        m3287o();
        T t = get(i);
        m3282j(i, true);
        return t;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z) {
        m3287o();
        if (z) {
            m3284l(tArr);
        } else {
            m3284l(m3276d(tArr));
        }
    }

    public int size() {
        return this.f4299h;
    }

    public void updateItemAt(int i, T t) {
        m3287o();
        T t2 = get(i);
        boolean z = t2 == t || !this.f4297f.areContentsTheSame(t2, t);
        if (t2 == t || this.f4297f.compare(t2, t) != 0) {
            if (z) {
                Callback callback = this.f4297f;
                callback.onChanged(i, 1, callback.getChangePayload(t2, t));
            }
            m3282j(i, false);
            int a = m3273a(t, false);
            if (i != a) {
                this.f4297f.onMoved(i, a);
                return;
            }
            return;
        }
        this.f4292a[i] = t;
        if (z) {
            Callback callback2 = this.f4297f;
            callback2.onChanged(i, 1, callback2.getChangePayload(t2, t));
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i) {
        this.f4300i = cls;
        this.f4292a = (Object[]) Array.newInstance(cls, i);
        this.f4297f = callback;
        this.f4299h = 0;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance(this.f4300i, collection.size())), true);
    }

    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance(this.f4300i, collection.size())), true);
    }
}
