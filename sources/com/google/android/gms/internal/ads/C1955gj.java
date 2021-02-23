package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.gj */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1955gj implements zzdyo<zzbdv> {

    /* renamed from: a */
    private final /* synthetic */ String f8786a;

    /* renamed from: b */
    private final /* synthetic */ zzahv f8787b;

    C1955gj(zzcgh zzcgh, String str, zzahv zzahv) {
        this.f8786a = str;
        this.f8787b = zzahv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbdv) obj).zza(this.f8786a, (zzahv<? super zzbdv>) this.f8787b);
    }

    public final void zzb(Throwable th) {
    }
}
