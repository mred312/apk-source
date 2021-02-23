package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;

/* renamed from: com.google.android.gms.internal.ads.p9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2279p9 implements Runnable {

    /* renamed from: a */
    private final zzbfm f10457a;

    C2279p9(zzbfm zzbfm) {
        this.f10457a = zzbfm;
    }

    public final void run() {
        zzbfm zzbfm = this.f10457a;
        zzbfm.zzepg.zzadb();
        zze zzaco = zzbfm.zzepg.zzaco();
        if (zzaco != null) {
            zzaco.zzvf();
        }
    }
}
