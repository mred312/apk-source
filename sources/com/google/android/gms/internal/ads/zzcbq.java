package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcbq implements zzepf<zzqr> {

    /* renamed from: a */
    private final zzeps<zzazh> f13994a;

    /* renamed from: b */
    private final zzeps<String> f13995b;

    public zzcbq(zzeps<zzazh> zzeps, zzeps<String> zzeps2) {
        this.f13994a = zzeps;
        this.f13995b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        zzp.zzkq();
        return (zzqr) zzepl.zza(new zzqr(zzm.zzyf(), this.f13994a.get(), this.f13995b.get(), new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
