package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkw implements zzepf<JSONObject> {

    /* renamed from: a */
    private final zzeps<zzdmu> f13450a;

    private zzbkw(zzeps<zzdmu> zzeps) {
        this.f13450a = zzeps;
    }

    public static zzbkw zzc(zzeps<zzdmu> zzeps) {
        return new zzbkw(zzeps);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return zzbkt.zza(this.f13450a.get());
    }
}
