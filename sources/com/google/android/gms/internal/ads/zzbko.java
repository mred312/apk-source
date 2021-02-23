package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbko implements zzepf<zzqr> {

    /* renamed from: a */
    private final zzeps<zzdmu> f13423a;

    /* renamed from: b */
    private final zzeps<zzazh> f13424b;

    /* renamed from: c */
    private final zzeps<JSONObject> f13425c;

    /* renamed from: d */
    private final zzeps<String> f13426d;

    private zzbko(zzeps<zzdmu> zzeps, zzeps<zzazh> zzeps2, zzeps<JSONObject> zzeps3, zzeps<String> zzeps4) {
        this.f13423a = zzeps;
        this.f13424b = zzeps2;
        this.f13425c = zzeps3;
        this.f13426d = zzeps4;
    }

    public static zzbko zza(zzeps<zzdmu> zzeps, zzeps<zzazh> zzeps2, zzeps<JSONObject> zzeps3, zzeps<String> zzeps4) {
        return new zzbko(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        zzdmu zzdmu = this.f13423a.get();
        String str = this.f13426d.get();
        boolean equals = "native".equals(str);
        zzp.zzkq();
        return (zzqr) zzepl.zza(new zzqr(zzm.zzyf(), this.f13424b.get(), str, this.f13425c.get(), false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
