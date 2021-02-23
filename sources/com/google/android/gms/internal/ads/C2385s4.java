package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.s4 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2385s4 implements zzdyo<Void> {

    /* renamed from: a */
    private final /* synthetic */ zzdyz f10845a;

    C2385s4(zzawh zzawh, zzdyz zzdyz) {
        this.f10845a = zzdyz;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        zzawh.f12883n.remove(this.f10845a);
    }

    public final void zzb(Throwable th) {
        zzawh.f12883n.remove(this.f10845a);
    }
}
