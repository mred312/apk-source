package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzag;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqr implements zzepf<zzdvm<zzdmu, zzag>> {

    /* renamed from: a */
    private final zzeps<Context> f13685a;

    /* renamed from: b */
    private final zzeps<zzazh> f13686b;

    /* renamed from: c */
    private final zzeps<zzdnn> f13687c;

    public zzbqr(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdnn> zzeps3) {
        this.f13685a = zzeps;
        this.f13686b = zzeps2;
        this.f13687c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return (zzdvm) zzepl.zza(new C2621yc(this.f13685a.get(), this.f13686b.get(), this.f13687c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
