package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.ij */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2029ij implements zzdyo<zzbdv> {

    /* renamed from: a */
    private final /* synthetic */ String f9330a;

    /* renamed from: b */
    private final /* synthetic */ Map f9331b;

    C2029ij(zzcgh zzcgh, String str, Map map) {
        this.f9330a = str;
        this.f9331b = map;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbdv) obj).zza(this.f9330a, this.f9331b);
    }

    public final void zzb(Throwable th) {
    }
}
