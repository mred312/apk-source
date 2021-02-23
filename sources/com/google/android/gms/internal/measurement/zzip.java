package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public final class zzip extends C2731c3<String> implements zzis, RandomAccess {

    /* renamed from: c */
    private static final zzip f17735c;

    /* renamed from: b */
    private final List<Object> f17736b;

    static {
        zzip zzip = new zzip();
        f17735c = zzip;
        zzip.zzb();
    }

    public zzip() {
        this(10);
    }

    /* renamed from: a */
    private static String m10395a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgr) {
            return ((zzgr) obj).zzb();
        }
        return zzic.zzb((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.f17736b.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzc();
        this.f17736b.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f17736b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgr) {
            zzgr zzgr = (zzgr) obj;
            String zzb = zzgr.zzb();
            if (zzgr.zzc()) {
                this.f17736b.set(i, zzb);
            }
            return zzb;
        }
        byte[] bArr = (byte[]) obj;
        String zzb2 = zzic.zzb(bArr);
        if (zzic.zza(bArr)) {
            this.f17736b.set(i, zzb2);
        }
        return zzb2;
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
        zzc();
        return m10395a(this.f17736b.set(i, (String) obj));
    }

    public final int size() {
        return this.f17736b.size();
    }

    public final void zza(zzgr zzgr) {
        zzc();
        this.f17736b.add(zzgr);
        this.modCount++;
    }

    public final Object zzb(int i) {
        return this.f17736b.get(i);
    }

    public final List<?> zzd() {
        return Collections.unmodifiableList(this.f17736b);
    }

    public final zzis zze() {
        return zza() ? new zzkw(this) : this;
    }

    public zzip(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzis) {
            collection = ((zzis) collection).zzd();
        }
        boolean addAll = this.f17736b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        Object remove = this.f17736b.remove(i);
        this.modCount++;
        return m10395a(remove);
    }

    private zzip(ArrayList<Object> arrayList) {
        this.f17736b = arrayList;
    }

    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final /* synthetic */ zzii zza(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f17736b);
            return new zzip((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }
}
