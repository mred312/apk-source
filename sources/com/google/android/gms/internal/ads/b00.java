package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class b00 implements zzdyo<O> {

    /* renamed from: a */
    private final /* synthetic */ zzdqx f7860a;

    /* renamed from: b */
    private final /* synthetic */ zzdrg f7861b;

    b00(zzdrg zzdrg, zzdqx zzdqx) {
        this.f7861b = zzdrg;
        this.f7860a = zzdqx;
    }

    public final void onSuccess(O o) {
        this.f7861b.f15895f.f15884c.zzc(this.f7860a);
    }

    public final void zzb(Throwable th) {
        this.f7861b.f15895f.f15884c.zza(this.f7860a, th);
    }
}
