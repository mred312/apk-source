package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkp implements zzepf<Set<zzbxy<zzqu>>> {

    /* renamed from: a */
    private final zzeps<zzbki> f13427a;

    /* renamed from: b */
    private final zzeps<Executor> f13428b;

    /* renamed from: c */
    private final zzeps<JSONObject> f13429c;

    private zzbkp(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        this.f13427a = zzeps;
        this.f13428b = zzeps2;
        this.f13429c = zzeps3;
    }

    public static zzbkp zzc(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        return new zzbkp(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbki zzbki = this.f13427a.get();
        Executor executor = this.f13428b.get();
        if (this.f13429c.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbxy(zzbki, executor));
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
