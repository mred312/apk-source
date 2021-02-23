package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
abstract class b20<E> extends zzdxg<E> {

    /* renamed from: a */
    private final int f7867a;

    /* renamed from: b */
    private int f7868b;

    protected b20(int i, int i2) {
        zzdvv.zzu(i2, i);
        this.f7867a = i;
        this.f7868b = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract E mo13617a(int i);

    public final boolean hasNext() {
        return this.f7868b < this.f7867a;
    }

    public final boolean hasPrevious() {
        return this.f7868b > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.f7868b;
            this.f7868b = i + 1;
            return mo13617a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f7868b;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.f7868b - 1;
            this.f7868b = i;
            return mo13617a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f7868b - 1;
    }
}
