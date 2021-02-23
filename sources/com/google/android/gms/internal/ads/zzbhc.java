package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbhc implements zzepf<zzatz> {

    /* renamed from: a */
    private final zzeps<Context> f13265a;

    public zzbhc(zzeps<Context> zzeps) {
        this.f13265a = zzeps;
    }

    public final /* synthetic */ Object get() {
        Context context = this.f13265a.get();
        return (zzatz) zzepl.zza(new zzatx(context, new zzaua(context).zzvs()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
