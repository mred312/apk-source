package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzela extends g80<String> implements zzekz, RandomAccess {

    /* renamed from: c */
    private static final zzela f16276c;

    /* renamed from: b */
    private final List<Object> f16277b;

    static {
        zzela zzela = new zzela();
        f16276c = zzela;
        zzela.zzbfl();
    }

    public zzela() {
        this(10);
    }

    /* renamed from: a */
    private static String m8838a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeiu) {
            return ((zzeiu) obj).zzbfq();
        }
        return zzekk.zzy((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzbfm();
        this.f16277b.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzbfm();
        this.f16277b.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f16277b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeiu) {
            zzeiu zzeiu = (zzeiu) obj;
            String zzbfq = zzeiu.zzbfq();
            if (zzeiu.zzbfr()) {
                this.f16277b.set(i, zzbfq);
            }
            return zzbfq;
        }
        byte[] bArr = (byte[]) obj;
        String zzy = zzekk.zzy(bArr);
        if (zzekk.zzx(bArr)) {
            this.f16277b.set(i, zzy);
        }
        return zzy;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzbfm();
        return m8838a(this.f16277b.set(i, (String) obj));
    }

    public final int size() {
        return this.f16277b.size();
    }

    public final void zzak(zzeiu zzeiu) {
        zzbfm();
        this.f16277b.add(zzeiu);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean zzbfk() {
        return super.zzbfk();
    }

    public final List<?> zzbiu() {
        return Collections.unmodifiableList(this.f16277b);
    }

    public final zzekz zzbiv() {
        return zzbfk() ? new zzenk(this) : this;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f16277b);
            return new zzela((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final Object zzhi(int i) {
        return this.f16277b.get(i);
    }

    public zzela(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbfm();
        if (collection instanceof zzekz) {
            collection = ((zzekz) collection).zzbiu();
        }
        boolean addAll = this.f16277b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        Object remove = this.f16277b.remove(i);
        this.modCount++;
        return m8838a(remove);
    }

    private zzela(ArrayList<Object> arrayList) {
        this.f16277b = arrayList;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
