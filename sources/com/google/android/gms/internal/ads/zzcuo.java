package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcuo {

    /* renamed from: a */
    private final zzdoa f14900a;

    /* renamed from: b */
    private final zzcil f14901b;

    /* renamed from: c */
    private final zzckq f14902c;

    public zzcuo(zzdoa zzdoa, zzcil zzcil, zzckq zzckq) {
        this.f14900a = zzdoa;
        this.f14901b = zzcil;
        this.f14902c = zzckq;
    }

    public final void zza(zzdmz zzdmz, zzdmu zzdmu, int i, @Nullable zzcrd zzcrd, long j) {
        zzcim zzcim;
        zzckp zzr = this.f14902c.zzaqg().zza(zzdmz).zzc(zzdmu).zzr("action", "adapter_status").zzr("adapter_l", String.valueOf(j));
        zzr.zzr("sc", Integer.toString(i));
        if (zzcrd != null) {
            zzr.zzr("arec", Integer.toString(zzcrd.zzarj().errorCode));
            String zzgr = this.f14900a.zzgr(zzcrd.getMessage());
            if (zzgr != null) {
                zzr.zzr("areec", zzgr);
            }
        }
        zzcil zzcil = this.f14901b;
        Iterator<String> it = zzdmu.zzhgy.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcim = null;
                break;
            }
            zzcim = zzcil.zzgd(it.next());
            if (zzcim != null) {
                break;
            }
        }
        if (zzcim != null) {
            zzr.zzr("ancn", zzcim.zzdhn);
            zzaqc zzaqc = zzcim.zzgix;
            if (zzaqc != null) {
                zzr.zzr("adapter_v", zzaqc.toString());
            }
            zzaqc zzaqc2 = zzcim.zzgiy;
            if (zzaqc2 != null) {
                zzr.zzr("adapter_sv", zzaqc2.toString());
            }
        }
        zzr.zzaqd();
    }
}
