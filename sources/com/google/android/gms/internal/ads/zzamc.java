package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzamc {

    /* renamed from: a */
    private final Object f12520a = new Object();

    /* renamed from: b */
    private final Object f12521b = new Object();
    @GuardedBy("lockClient")

    /* renamed from: c */
    private zzaml f12522c;
    @GuardedBy("lockService")

    /* renamed from: d */
    private zzaml f12523d;

    /* renamed from: a */
    private static Context m7494a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzaml zza(Context context, zzazh zzazh) {
        zzaml zzaml;
        synchronized (this.f12521b) {
            if (this.f12523d == null) {
                this.f12523d = new zzaml(m7494a(context), zzazh, zzadj.zzddo.get());
            }
            zzaml = this.f12523d;
        }
        return zzaml;
    }

    public final zzaml zzb(Context context, zzazh zzazh) {
        zzaml zzaml;
        synchronized (this.f12520a) {
            if (this.f12522c == null) {
                this.f12522c = new zzaml(m7494a(context), zzazh, (String) zzwq.zzqe().zzd(zzabf.zzclr));
            }
            zzaml = this.f12522c;
        }
        return zzaml;
    }
}
