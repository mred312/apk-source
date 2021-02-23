package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccl {
    public static final zzccl zzgdq = new zzccn().zzany();
    @Nullable

    /* renamed from: a */
    private final zzafk f14075a;
    @Nullable

    /* renamed from: b */
    private final zzafj f14076b;
    @Nullable

    /* renamed from: c */
    private final zzafy f14077c;
    @Nullable

    /* renamed from: d */
    private final zzafx f14078d;
    @Nullable

    /* renamed from: e */
    private final zzajt f14079e;

    /* renamed from: f */
    private final SimpleArrayMap<String, zzafq> f14080f;

    /* renamed from: g */
    private final SimpleArrayMap<String, zzafp> f14081g;

    private zzccl(zzccn zzccn) {
        this.f14075a = zzccn.f14082a;
        this.f14076b = zzccn.f14083b;
        this.f14077c = zzccn.f14084c;
        this.f14080f = new SimpleArrayMap<>(zzccn.f14087f);
        this.f14081g = new SimpleArrayMap<>(zzccn.f14088g);
        this.f14078d = zzccn.f14085d;
        this.f14079e = zzccn.f14086e;
    }

    @Nullable
    public final zzafk zzanr() {
        return this.f14075a;
    }

    @Nullable
    public final zzafj zzans() {
        return this.f14076b;
    }

    @Nullable
    public final zzafy zzant() {
        return this.f14077c;
    }

    @Nullable
    public final zzafx zzanu() {
        return this.f14078d;
    }

    @Nullable
    public final zzajt zzanv() {
        return this.f14079e;
    }

    public final ArrayList<String> zzanw() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f14077c != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.f14075a != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.f14076b != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.f14080f.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.f14079e != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzanx() {
        ArrayList<String> arrayList = new ArrayList<>(this.f14080f.size());
        for (int i = 0; i < this.f14080f.size(); i++) {
            arrayList.add(this.f14080f.keyAt(i));
        }
        return arrayList;
    }

    @Nullable
    public final zzafq zzga(String str) {
        return this.f14080f.get(str);
    }

    @Nullable
    public final zzafp zzgb(String str) {
        return this.f14081g.get(str);
    }
}
