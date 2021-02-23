package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcbn implements zzepf<zzbxx> {

    /* renamed from: a */
    private final zzeps<Context> f13990a;

    /* renamed from: b */
    private final zzeps<zzdmu> f13991b;

    public zzcbn(zzeps<Context> zzeps, zzeps<zzdmu> zzeps2) {
        this.f13990a = zzeps;
        this.f13991b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzbxx) zzepl.zza(new zzbxx(this.f13990a.get(), new HashSet(), this.f13991b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
