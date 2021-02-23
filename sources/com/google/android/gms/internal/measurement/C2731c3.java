package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.c3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
abstract class C2731c3<E> extends AbstractList<E> implements zzii<E> {

    /* renamed from: a */
    private boolean f17245a = true;

    C2731c3() {
    }

    public abstract void add(int i, E e);

    public boolean add(E e) {
        zzc();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzc();
        return super.addAll(collection);
    }

    public void clear() {
        zzc();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public abstract E remove(int i);

    public boolean remove(Object obj) {
        zzc();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        zzc();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzc();
        return super.retainAll(collection);
    }

    public abstract E set(int i, E e);

    public boolean zza() {
        return this.f17245a;
    }

    public final void zzb() {
        this.f17245a = false;
    }

    /* access modifiers changed from: protected */
    public final void zzc() {
        if (!this.f17245a) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzc();
        return super.addAll(i, collection);
    }
}
