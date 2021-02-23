package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
class d20<E> extends zzdwn<E> {

    /* renamed from: a */
    Object[] f8045a;

    /* renamed from: b */
    int f8046b = 0;

    /* renamed from: c */
    boolean f8047c;

    d20(int i) {
        a20.m5747b(i, "initialCapacity");
        this.f8045a = new Object[i];
    }

    /* renamed from: a */
    private final void m5920a(int i) {
        Object[] objArr = this.f8045a;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.f8045a = Arrays.copyOf(objArr, i2);
                this.f8047c = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.f8047c) {
            this.f8045a = (Object[]) objArr.clone();
            this.f8047c = false;
        }
    }

    public d20<E> zzab(E e) {
        zzdvv.checkNotNull(e);
        m5920a(this.f8046b + 1);
        Object[] objArr = this.f8045a;
        int i = this.f8046b;
        this.f8046b = i + 1;
        objArr[i] = e;
        return this;
    }

    public /* synthetic */ zzdwn zzac(Object obj) {
        throw null;
    }

    public zzdwn<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            m5920a(this.f8046b + collection.size());
            if (collection instanceof zzdwl) {
                this.f8046b = ((zzdwl) collection).mo14074a(this.f8045a, this.f8046b);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
