package androidx.collection;

public final class CircularArray<E> {

    /* renamed from: a */
    private E[] f1854a;

    /* renamed from: b */
    private int f1855b;

    /* renamed from: c */
    private int f1856c;

    /* renamed from: d */
    private int f1857d;

    public CircularArray() {
        this(8);
    }

    /* renamed from: a */
    private void m1231a() {
        E[] eArr = this.f1854a;
        int length = eArr.length;
        int i = this.f1855b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            E[] eArr2 = new Object[i3];
            System.arraycopy(eArr, i, eArr2, 0, i2);
            System.arraycopy(this.f1854a, 0, eArr2, i2, this.f1855b);
            this.f1854a = eArr2;
            this.f1855b = 0;
            this.f1856c = length;
            this.f1857d = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e) {
        int i = (this.f1855b - 1) & this.f1857d;
        this.f1855b = i;
        this.f1854a[i] = e;
        if (i == this.f1856c) {
            m1231a();
        }
    }

    public void addLast(E e) {
        E[] eArr = this.f1854a;
        int i = this.f1856c;
        eArr[i] = e;
        int i2 = this.f1857d & (i + 1);
        this.f1856c = i2;
        if (i2 == this.f1855b) {
            m1231a();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f1854a[this.f1857d & (this.f1855b + i)];
    }

    public E getFirst() {
        int i = this.f1855b;
        if (i != this.f1856c) {
            return this.f1854a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i = this.f1855b;
        int i2 = this.f1856c;
        if (i != i2) {
            return this.f1854a[(i2 - 1) & this.f1857d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1855b == this.f1856c;
    }

    public E popFirst() {
        int i = this.f1855b;
        if (i != this.f1856c) {
            E[] eArr = this.f1854a;
            E e = eArr[i];
            eArr[i] = null;
            this.f1855b = (i + 1) & this.f1857d;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i = this.f1855b;
        int i2 = this.f1856c;
        if (i != i2) {
            int i3 = this.f1857d & (i2 - 1);
            E[] eArr = this.f1854a;
            E e = eArr[i3];
            eArr[i3] = null;
            this.f1856c = i3;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i) {
        int i2;
        if (i > 0) {
            if (i <= size()) {
                int i3 = 0;
                int i4 = this.f1856c;
                if (i < i4) {
                    i3 = i4 - i;
                }
                int i5 = i3;
                while (true) {
                    i2 = this.f1856c;
                    if (i5 >= i2) {
                        break;
                    }
                    this.f1854a[i5] = null;
                    i5++;
                }
                int i6 = i2 - i3;
                int i7 = i - i6;
                this.f1856c = i2 - i6;
                if (i7 > 0) {
                    int length = this.f1854a.length;
                    this.f1856c = length;
                    int i8 = length - i7;
                    for (int i9 = i8; i9 < this.f1856c; i9++) {
                        this.f1854a[i9] = null;
                    }
                    this.f1856c = i8;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeFromStart(int i) {
        if (i > 0) {
            if (i <= size()) {
                int length = this.f1854a.length;
                int i2 = this.f1855b;
                if (i < length - i2) {
                    length = i2 + i;
                }
                while (i2 < length) {
                    this.f1854a[i2] = null;
                    i2++;
                }
                int i3 = this.f1855b;
                int i4 = length - i3;
                int i5 = i - i4;
                this.f1855b = this.f1857d & (i3 + i4);
                if (i5 > 0) {
                    for (int i6 = 0; i6 < i5; i6++) {
                        this.f1854a[i6] = null;
                    }
                    this.f1855b = i5;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return (this.f1856c - this.f1855b) & this.f1857d;
    }

    public CircularArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.f1857d = i - 1;
            this.f1854a = new Object[i];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
