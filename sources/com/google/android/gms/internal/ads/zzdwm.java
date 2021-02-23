package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzdwm<E> extends zzdwl<E> implements List<E>, RandomAccess {

    /* renamed from: b */
    private static final zzdxg<Object> f16032b = new e20(h20.f8823e, 0);

    zzdwm() {
    }

    /* renamed from: f */
    static <E> zzdwm<E> m8543f(Object[] objArr, int i) {
        if (i == 0) {
            return h20.f8823e;
        }
        return new h20(objArr, i);
    }

    /* renamed from: g */
    static <E> zzdwm<E> m8544g(Object[] objArr) {
        return m8543f(objArr, objArr.length);
    }

    public static <E> zzdwm<E> zzad(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdwx.m8556a(objArr[0], 0);
        }
        return m8543f(objArr, 1);
    }

    public static <E> zzdwm<E> zzayv() {
        return h20.f8823e;
    }

    public static <E> zzdwm<E> zzb(Collection<? extends E> collection) {
        if (collection instanceof zzdwl) {
            zzdwm<E> zzayt = ((zzdwl) collection).zzayt();
            if (!zzayt.mo13936e()) {
                return zzayt;
            }
            Object[] array = zzayt.toArray();
            return m8543f(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            zzdwx.m8556a(array2[i], i);
        }
        return m8543f(array2, array2.length);
    }

    public static <E> zzdwm<E> zzh(Iterable<? extends E> iterable) {
        zzdvv.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return zzb((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return h20.f8823e;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzad(next);
        }
        zzdwp zzdwp = (zzdwp) ((zzdwp) new zzdwp().zzac(next)).zza(it);
        zzdwp.f8047c = true;
        return m8543f(zzdwp.f8045a, zzdwp.f8046b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo14074a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdvv.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzdvs.equal(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i2);
                        i2++;
                        if (!zzdvs.equal(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size) {
                if (obj.equals(get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzdvv.zzu(i, size());
        if (isEmpty()) {
            return f16032b;
        }
        return new e20(this, i);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final zzdxh<E> zzayp() {
        return (zzdxg) listIterator();
    }

    public final zzdwm<E> zzayt() {
        return this;
    }

    /* renamed from: zzv */
    public zzdwm<E> subList(int i, int i2) {
        zzdvv.zzf(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return h20.f8823e;
        }
        return new f20(this, i, i3);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzdxg) listIterator(0);
    }

    public static <E> zzdwm<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return h20.f8823e;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdwx.m8556a(objArr[i], i);
        }
        return m8543f(objArr, objArr.length);
    }
}
