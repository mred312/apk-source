package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.p5 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2275p5 extends zza {

    /* renamed from: a */
    private final /* synthetic */ zzayg f10433a;

    C2275p5(zzayg zzayg) {
        this.f10433a = zzayg;
    }

    public final void zzvm() {
        zzabj zzabj = new zzabj(this.f10433a.f12930e, this.f10433a.f12931f.zzbrf);
        synchronized (this.f10433a.f12926a) {
            try {
                zzp.zzkz();
                zzabk.zza(this.f10433a.f12932g, zzabj);
            } catch (IllegalArgumentException e) {
                zzaza.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
