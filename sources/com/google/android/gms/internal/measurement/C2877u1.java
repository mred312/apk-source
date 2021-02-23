package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.u1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
abstract class C2877u1<E> extends zzfw<E> {

    /* renamed from: a */
    private final int f17478a;

    /* renamed from: b */
    private int f17479b;

    protected C2877u1(int i, int i2) {
        zzeb.zzb(i2, i);
        this.f17478a = i;
        this.f17479b = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract E mo18690a(int i);

    public final boolean hasNext() {
        return this.f17479b < this.f17478a;
    }

    public final boolean hasPrevious() {
        return this.f17479b > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.f17479b;
            this.f17479b = i + 1;
            return mo18690a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f17479b;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.f17479b - 1;
            this.f17479b = i;
            return mo18690a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f17479b - 1;
    }
}
