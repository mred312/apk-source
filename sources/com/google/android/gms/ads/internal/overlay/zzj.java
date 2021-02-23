package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zzj extends zza {
    final /* synthetic */ zze zzdrb;

    private zzj(zze zze) {
        this.zzdrb = zze;
    }

    public final void zzvm() {
        Bitmap zza = zzp.zzlj().zza(Integer.valueOf(this.zzdrb.zzdqi.zzdrt.zzboz));
        if (zza != null) {
            zzu zzks = zzp.zzks();
            zze zze = this.zzdrb;
            Activity activity = zze.zzaap;
            zzi zzi = zze.zzdqi.zzdrt;
            zzm.zzedd.post(new zzm(this, zzks.zza(activity, zza, zzi.zzbox, zzi.zzboy)));
        }
    }
}
