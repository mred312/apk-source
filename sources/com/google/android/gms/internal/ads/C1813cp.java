package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.cp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1813cp implements zzcaf {

    /* renamed from: a */
    private final Context f8025a;

    /* renamed from: b */
    private final zzazh f8026b;

    /* renamed from: c */
    private final zzdyz<zzbyz> f8027c;

    /* renamed from: d */
    private final zzdmu f8028d;

    /* renamed from: e */
    private final zzbdv f8029e;

    private C1813cp(Context context, zzazh zzazh, zzdyz<zzbyz> zzdyz, zzdmu zzdmu, zzbdv zzbdv) {
        this.f8025a = context;
        this.f8026b = zzazh;
        this.f8027c = zzdyz;
        this.f8028d = zzdmu;
        this.f8029e = zzbdv;
    }

    public final void zza(boolean z, Context context) {
        this.f8029e.zzaz(true);
        zzp.zzkq();
        zzi zzi = new zzi(false, zzm.zzaz(this.f8025a), false, 0.0f, -1, z, this.f8028d.zzfsc, false);
        zzp.zzkp();
        zzbzv zzags = ((zzbyz) zzdyr.zzb(this.f8027c)).zzags();
        zzbdv zzbdv = this.f8029e;
        zzdmu zzdmu = this.f8028d;
        int i = zzdmu.zzhhg;
        zzazh zzazh = this.f8026b;
        String str = zzdmu.zzdus;
        zzdnb zzdnb = zzdmu.zzhgx;
        Context context2 = context;
        zzo.zza(context2, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzags, (zzu) null, zzbdv, i, zzazh, str, zzi, zzdnb.zzdrn, zzdnb.zzdrp), true);
    }
}
