package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzdwl<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a */
    private static final Object[] f16031a = new Object[0];

    zzdwl() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo14074a(Object[] objArr, int i) {
        zzdxh zzdxh = (zzdxh) iterator();
        while (zzdxh.hasNext()) {
            objArr[i] = zzdxh.next();
            i++;
        }
        return i;
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    /* renamed from: b */
    public Object[] mo13933b() {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo13934c() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo13935d() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract boolean mo13936e();

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(f16031a);
    }

    /* renamed from: zzayp */
    public abstract zzdxh<E> iterator();

    public zzdwm<E> zzayt() {
        return isEmpty() ? zzdwm.zzayv() : zzdwm.m8544g(toArray());
    }

    public final <T> T[] toArray(T[] tArr) {
        zzdvv.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] b = mo13933b();
            if (b != null) {
                return Arrays.copyOfRange(b, mo13934c(), mo13935d(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        mo14074a(tArr, 0);
        return tArr;
    }
}
