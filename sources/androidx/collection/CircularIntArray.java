package androidx.collection;

public final class CircularIntArray {

    /* renamed from: a */
    private int[] f1858a;

    /* renamed from: b */
    private int f1859b;

    /* renamed from: c */
    private int f1860c;

    /* renamed from: d */
    private int f1861d;

    public CircularIntArray() {
        this(8);
    }

    /* renamed from: a */
    private void m1232a() {
        int[] iArr = this.f1858a;
        int length = iArr.length;
        int i = this.f1859b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            int[] iArr2 = new int[i3];
            System.arraycopy(iArr, i, iArr2, 0, i2);
            System.arraycopy(this.f1858a, 0, iArr2, i2, this.f1859b);
            this.f1858a = iArr2;
            this.f1859b = 0;
            this.f1860c = length;
            this.f1861d = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int i) {
        int i2 = (this.f1859b - 1) & this.f1861d;
        this.f1859b = i2;
        this.f1858a[i2] = i;
        if (i2 == this.f1860c) {
            m1232a();
        }
    }

    public void addLast(int i) {
        int[] iArr = this.f1858a;
        int i2 = this.f1860c;
        iArr[i2] = i;
        int i3 = this.f1861d & (i2 + 1);
        this.f1860c = i3;
        if (i3 == this.f1859b) {
            m1232a();
        }
    }

    public void clear() {
        this.f1860c = this.f1859b;
    }

    public int get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f1858a[this.f1861d & (this.f1859b + i)];
    }

    public int getFirst() {
        int i = this.f1859b;
        if (i != this.f1860c) {
            return this.f1858a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i = this.f1859b;
        int i2 = this.f1860c;
        if (i != i2) {
            return this.f1858a[(i2 - 1) & this.f1861d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1859b == this.f1860c;
    }

    public int popFirst() {
        int i = this.f1859b;
        if (i != this.f1860c) {
            int i2 = this.f1858a[i];
            this.f1859b = (i + 1) & this.f1861d;
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i = this.f1859b;
        int i2 = this.f1860c;
        if (i != i2) {
            int i3 = this.f1861d & (i2 - 1);
            int i4 = this.f1858a[i3];
            this.f1860c = i3;
            return i4;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i) {
        if (i > 0) {
            if (i <= size()) {
                this.f1860c = this.f1861d & (this.f1860c - i);
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeFromStart(int i) {
        if (i > 0) {
            if (i <= size()) {
                this.f1859b = this.f1861d & (this.f1859b + i);
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return (this.f1860c - this.f1859b) & this.f1861d;
    }

    public CircularIntArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.f1861d = i - 1;
            this.f1858a = new int[i];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
