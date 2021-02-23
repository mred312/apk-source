package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbks implements zzepf<Set<zzbxy<zzp>>> {

    /* renamed from: a */
    private final zzeps<zzbki> f13440a;

    /* renamed from: b */
    private final zzeps<Executor> f13441b;

    /* renamed from: c */
    private final zzeps<JSONObject> f13442c;

    private zzbks(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        this.f13440a = zzeps;
        this.f13441b = zzeps2;
        this.f13442c = zzeps3;
    }

    public static zzbks zze(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        return new zzbks(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbki zzbki = this.f13440a.get();
        Executor executor = this.f13441b.get();
        if (this.f13442c.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbxy(zzbki, executor));
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
