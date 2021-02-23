package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzgk extends zzgl {

    /* renamed from: e */
    private final View f16431e;

    public zzgk(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2, View view) {
        super(zzfa, str, str2, zza, i, 57);
        this.f16431e = view;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.f16431e != null) {
            Boolean bool = (Boolean) zzwq.zzqe().zzd(zzabf.zzcrm);
            DisplayMetrics displayMetrics = this.zzwb.getContext().getResources().getDisplayMetrics();
            zzfi zzfi = new zzfi((String) this.zzabi.invoke((Object) null, new Object[]{this.f16431e, displayMetrics, bool}));
            zzcf.zza.zzf.C3979zza zzax = zzcf.zza.zzf.zzax();
            zzax.zzcy(zzfi.zzaak.longValue()).zzcz(zzfi.zzaal.longValue()).zzda(zzfi.zzaam.longValue());
            if (bool.booleanValue()) {
                zzax.zzdb(zzfi.zzaan.longValue());
            }
            this.zzaay.zza((zzcf.zza.zzf) ((zzekh) zzax.zzbhv()));
        }
    }
}
