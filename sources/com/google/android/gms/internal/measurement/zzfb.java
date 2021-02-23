package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public abstract class zzfb<E> extends zzey<E> implements List<E>, RandomAccess {

    /* renamed from: b */
    private static final zzfw<Object> f17646b = new C2798k2(C2822n2.f17388e, 0);

    zzfb() {
    }

    /* renamed from: f */
    static <E> zzfb<E> m10332f(Object[] objArr) {
        return m10333g(objArr, objArr.length);
    }

    /* renamed from: g */
    static <E> zzfb<E> m10333g(Object[] objArr, int i) {
        if (i == 0) {
            return C2822n2.f17388e;
        }
        return new C2822n2(objArr, i);
    }

    public static <E> zzfb<E> zza(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzfn.m10341a(objArr[0], 0);
        }
        return m10333g(objArr, 1);
    }

    public static <E> zzfb<E> zzg() {
        return C2822n2.f17388e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo18762a(Object[] objArr, int i) {
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
        if (obj == zzeb.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzdz.zza(get(i), list.get(i))) {
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
                        if (!zzdz.zza(obj2, it.next())) {
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
        zzeb.zzb(i, size());
        if (isEmpty()) {
            return f17646b;
        }
        return new C2798k2(this, i);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final zzfb<E> zze() {
        return this;
    }

    public final zzfx<E> zza() {
        return (zzfw) listIterator();
    }

    /* renamed from: zza */
    public zzfb<E> subList(int i, int i2) {
        zzeb.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return C2822n2.f17388e;
        }
        return new C2806l2(this, i, i3);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzfw) listIterator(0);
    }
}
