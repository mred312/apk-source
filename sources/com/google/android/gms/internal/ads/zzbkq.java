package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkq implements zzepf<Set<zzbxy<zzbsp>>> {

    /* renamed from: a */
    private final zzeps<zzbki> f13430a;

    /* renamed from: b */
    private final zzeps<Executor> f13431b;

    /* renamed from: c */
    private final zzeps<JSONObject> f13432c;

    private zzbkq(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        this.f13430a = zzeps;
        this.f13431b = zzeps2;
        this.f13432c = zzeps3;
    }

    public static zzbkq zzd(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        return new zzbkq(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbki zzbki = this.f13430a.get();
        Executor executor = this.f13431b.get();
        if (this.f13432c.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbxy(zzbki, executor));
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
