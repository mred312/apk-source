package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class i00 implements zzdtn {

    /* renamed from: a */
    private final /* synthetic */ zzdsi f9245a;

    i00(zzdsi zzdsi) {
        this.f9245a = zzdsi;
    }

    public final void zza(int i, long j) {
        this.f9245a.zzh(i, System.currentTimeMillis() - j);
    }

    public final void zza(int i, long j, String str) {
        this.f9245a.zzb(i, System.currentTimeMillis() - j, str);
    }
}
