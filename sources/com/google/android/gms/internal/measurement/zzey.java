package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public abstract class zzey<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a */
    private static final Object[] f17645a = new Object[0];

    zzey() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo18762a(Object[] objArr, int i) {
        zzfx zzfx = (zzfx) iterator();
        while (zzfx.hasNext()) {
            objArr[i] = zzfx.next();
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
    public Object[] mo18702b() {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo18703c() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo18704d() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract boolean mo18705e();

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
        return toArray(f17645a);
    }

    /* renamed from: zza */
    public abstract zzfx<E> iterator();

    public zzfb<E> zze() {
        return isEmpty() ? zzfb.zzg() : zzfb.m10332f(toArray());
    }

    public final <T> T[] toArray(T[] tArr) {
        zzeb.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] b = mo18702b();
            if (b != null) {
                return Arrays.copyOfRange(b, mo18703c(), mo18704d(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        mo18762a(tArr, 0);
        return tArr;
    }
}
