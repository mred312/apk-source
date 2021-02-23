package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.ep */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1887ep implements zzcaf {

    /* renamed from: a */
    private final zzdmu f8388a;

    /* renamed from: b */
    private final zzapo f8389b;

    /* renamed from: c */
    private final boolean f8390c;
    @Nullable

    /* renamed from: d */
    private zzbsl f8391d = null;

    C1887ep(zzdmu zzdmu, zzapo zzapo, boolean z) {
        this.f8388a = zzdmu;
        this.f8389b = zzapo;
        this.f8390c = z;
    }

    /* renamed from: a */
    public final void mo13915a(zzbsl zzbsl) {
        this.f8391d = zzbsl;
    }

    public final void zza(boolean z, Context context) {
        boolean z2;
        try {
            if (this.f8390c) {
                z2 = this.f8389b.zzaa(ObjectWrapper.wrap(context));
            } else {
                z2 = this.f8389b.zzz(ObjectWrapper.wrap(context));
            }
            if (!z2) {
                throw new zzcai("Adapter failed to show.");
            } else if (this.f8391d != null) {
                if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcqh)).booleanValue() && this.f8388a.zzhhj == 2) {
                    this.f8391d.onAdImpression();
                }
            }
        } catch (Throwable th) {
            throw new zzcai(th);
        }
    }
}
