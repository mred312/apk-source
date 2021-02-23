package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.eo */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1886eo implements zzcaf {

    /* renamed from: a */
    private final zzazh f8383a;

    /* renamed from: b */
    private final zzdyz<zzbln> f8384b;

    /* renamed from: c */
    private final zzdmu f8385c;

    /* renamed from: d */
    private final zzbdv f8386d;

    /* renamed from: e */
    private final zzdnn f8387e;

    C1886eo(Context context, zzazh zzazh, zzdyz<zzbln> zzdyz, zzdmu zzdmu, zzbdv zzbdv, zzdnn zzdnn) {
        this.f8383a = zzazh;
        this.f8384b = zzdyz;
        this.f8385c = zzdmu;
        this.f8386d = zzbdv;
        this.f8387e = zzdnn;
    }

    public final void zza(boolean z, Context context) {
        int i;
        this.f8386d.zzaz(true);
        zzi zzi = new zzi(true, true, false, 0.0f, -1, z, this.f8385c.zzfsc, false);
        zzp.zzkp();
        zzbzv zzags = ((zzbln) zzdyr.zzb(this.f8384b)).zzags();
        zzbdv zzbdv = this.f8386d;
        int i2 = this.f8385c.zzhhg;
        if (i2 == -1) {
            zzvw zzvw = this.f8387e.zzhis;
            if (zzvw != null) {
                int i3 = zzvw.orientation;
                if (i3 == 1) {
                    zzp.zzks();
                    i = 7;
                } else if (i3 == 2) {
                    zzp.zzks();
                    i = 6;
                }
                zzazh zzazh = this.f8383a;
                zzdmu zzdmu = this.f8385c;
                String str = zzdmu.zzdus;
                zzdnb zzdnb = zzdmu.zzhgx;
                Context context2 = context;
                zzo.zza(context2, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzags, (zzu) null, zzbdv, i, zzazh, str, zzi, zzdnb.zzdrn, zzdnb.zzdrp), true);
            }
            zzaza.zzeb("Error setting app open orientation; no targeting orientation available.");
            i2 = this.f8385c.zzhhg;
        }
        i = i2;
        zzazh zzazh2 = this.f8383a;
        zzdmu zzdmu2 = this.f8385c;
        String str2 = zzdmu2.zzdus;
        zzdnb zzdnb2 = zzdmu2.zzhgx;
        Context context22 = context;
        zzo.zza(context22, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzags, (zzu) null, zzbdv, i, zzazh2, str2, zzi, zzdnb2.zzdrn, zzdnb2.zzdrp), true);
    }
}
