package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkl implements zzepf<Set<zzbxy<zzbsm>>> {

    /* renamed from: a */
    private final zzeps<zzbki> f13416a;

    /* renamed from: b */
    private final zzeps<Executor> f13417b;

    /* renamed from: c */
    private final zzeps<JSONObject> f13418c;

    private zzbkl(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        this.f13416a = zzeps;
        this.f13417b = zzeps2;
        this.f13418c = zzeps3;
    }

    public static zzbkl zza(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        return new zzbkl(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbki zzbki = this.f13416a.get();
        Executor executor = this.f13417b.get();
        if (this.f13418c.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbxy(zzbki, executor));
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
