package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcjx implements zzepf<Set<zzbxy<zzdru>>> {

    /* renamed from: a */
    private final zzeps<String> f14469a;

    /* renamed from: b */
    private final zzeps<Context> f14470b;

    /* renamed from: c */
    private final zzeps<Executor> f14471c;

    /* renamed from: d */
    private final zzeps<Map<zzdrl, zzckc>> f14472d;

    public zzcjx(zzeps<String> zzeps, zzeps<Context> zzeps2, zzeps<Executor> zzeps3, zzeps<Map<zzdrl, zzckc>> zzeps4) {
        this.f14469a = zzeps;
        this.f14470b = zzeps2;
        this.f14471c = zzeps3;
        this.f14472d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        Set set;
        String str = this.f14469a.get();
        Context context = this.f14470b.get();
        Executor executor = this.f14471c.get();
        Map map = this.f14472d.get();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue()) {
            zzts zzts = new zzts(new zztx(context));
            zzts.zza((zztv) new C2479uk(str));
            set = Collections.singleton(new zzbxy(new zzcka(zzts, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
