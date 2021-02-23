package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmo implements zzepf<zzdyz<String>> {

    /* renamed from: a */
    private final zzeps<zzef> f14601a;

    /* renamed from: b */
    private final zzeps<Context> f14602b;

    /* renamed from: c */
    private final zzeps<zzdzc> f14603c;

    private zzcmo(zzeps<zzef> zzeps, zzeps<Context> zzeps2, zzeps<zzdzc> zzeps3) {
        this.f14601a = zzeps;
        this.f14602b = zzeps2;
        this.f14603c = zzeps3;
    }

    public static zzcmo zzp(zzeps<zzef> zzeps, zzeps<Context> zzeps2, zzeps<zzdzc> zzeps3) {
        return new zzcmo(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzdyz) zzepl.zza(this.f14603c.get().zze(new C2254ol(this.f14601a.get(), this.f14602b.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
