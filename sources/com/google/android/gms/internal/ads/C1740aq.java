package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.aq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1740aq implements zzcaf {

    /* renamed from: a */
    private final Context f7842a;

    /* renamed from: b */
    private final zzchp f7843b;

    /* renamed from: c */
    private final zzdnn f7844c;

    /* renamed from: d */
    private final zzazh f7845d;

    /* renamed from: e */
    private final zzdmu f7846e;

    /* renamed from: f */
    private final zzdyz<zzche> f7847f;

    /* renamed from: g */
    private final zzbdv f7848g;

    private C1740aq(Context context, zzchp zzchp, zzdnn zzdnn, zzazh zzazh, zzdmu zzdmu, zzdyz<zzche> zzdyz, zzbdv zzbdv) {
        this.f7842a = context;
        this.f7843b = zzchp;
        this.f7844c = zzdnn;
        this.f7845d = zzazh;
        this.f7846e = zzdmu;
        this.f7847f = zzdyz;
        this.f7848g = zzbdv;
    }

    public final void zza(boolean z, Context context) {
        zzbdv zzbdv;
        zzbdv zzbdv2;
        zzche zzche = (zzche) zzdyr.zzb(this.f7847f);
        try {
            zzdmu zzdmu = this.f7846e;
            if (!this.f7848g.zzadh()) {
                zzbdv2 = this.f7848g;
            } else {
                if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcog)).booleanValue()) {
                    zzbdv2 = this.f7848g;
                } else {
                    zzbdv zzd = this.f7843b.zzd(this.f7844c.zzbpe);
                    zzaig.zza(zzd, (zzaij) zzche.zzahr());
                    zzcif zzcif = new zzcif();
                    zzcif.zzc(this.f7842a, zzd.getView());
                    zzche.zzagr().zzb(zzd, true);
                    zzd.zzacs().zza((zzbfj) new C2671zp(zzcif, zzd));
                    zzbfg zzacs = zzd.zzacs();
                    zzd.getClass();
                    zzacs.zza(C1777bq.m5868a(zzd));
                    zzdnb zzdnb = zzdmu.zzhgx;
                    zzd.zzb(zzdnb.zzdrn, zzdnb.zzdrp, (String) null);
                    zzbdv = zzd;
                    zzbdv.zzaz(true);
                    zzp.zzkq();
                    boolean zzaz = zzm.zzaz(this.f7842a);
                    zzdmu zzdmu2 = this.f7846e;
                    zzi zzi = new zzi(false, zzaz, false, 0.0f, -1, z, zzdmu2.zzfsc, zzdmu2.zzbpc);
                    zzp.zzkp();
                    zzbzv zzags = zzche.zzags();
                    zzdmu zzdmu3 = this.f7846e;
                    int i = zzdmu3.zzhhg;
                    zzazh zzazh = this.f7845d;
                    String str = zzdmu3.zzdus;
                    zzdnb zzdnb2 = zzdmu3.zzhgx;
                    String str2 = zzdnb2.zzdrn;
                    zzo.zza(context, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzags, (zzu) null, zzbdv, i, zzazh, str, zzi, str2, zzdnb2.zzdrp), true);
                }
            }
            zzbdv = zzbdv2;
            zzbdv.zzaz(true);
            zzp.zzkq();
            boolean zzaz2 = zzm.zzaz(this.f7842a);
            zzdmu zzdmu22 = this.f7846e;
            zzi zzi2 = new zzi(false, zzaz2, false, 0.0f, -1, z, zzdmu22.zzfsc, zzdmu22.zzbpc);
            zzp.zzkp();
            zzbzv zzags2 = zzche.zzags();
            zzdmu zzdmu32 = this.f7846e;
            int i2 = zzdmu32.zzhhg;
            zzazh zzazh2 = this.f7845d;
            String str3 = zzdmu32.zzdus;
            zzdnb zzdnb22 = zzdmu32.zzhgx;
            String str22 = zzdnb22.zzdrn;
            zzo.zza(context, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzags2, (zzu) null, zzbdv, i2, zzazh2, str3, zzi2, str22, zzdnb22.zzdrp), true);
        } catch (zzbeh e) {
            zzaza.zzc("", e);
        }
    }
}
