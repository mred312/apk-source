package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;

/* renamed from: com.google.android.gms.internal.ads.w8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2541w8 implements Runnable {

    /* renamed from: a */
    private final zzbdu f11675a;

    C2541w8(zzbdu zzbdu) {
        this.f11675a = zzbdu;
    }

    public final void run() {
        zzbdu zzbdu = this.f11675a;
        zzbdu.zzepg.zzadb();
        zze zzaco = zzbdu.zzepg.zzaco();
        if (zzaco != null) {
            zzaco.zzvf();
        }
    }
}
