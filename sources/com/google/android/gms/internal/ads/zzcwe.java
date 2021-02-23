package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcwe implements zzcqz<zzbme> {

    /* renamed from: a */
    private final Context f14974a;

    /* renamed from: b */
    private final zzbna f14975b;
    @Nullable

    /* renamed from: c */
    private final zzacb f14976c;

    /* renamed from: d */
    private final zzdzc f14977d;

    /* renamed from: e */
    private final zzdro f14978e;

    public zzcwe(Context context, zzbna zzbna, zzdro zzdro, zzdzc zzdzc, @Nullable zzacb zzacb) {
        this.f14974a = context;
        this.f14975b = zzbna;
        this.f14978e = zzdro;
        this.f14977d = zzdzc;
        this.f14976c = zzacb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo17012a(zzabu zzabu) {
        this.f14976c.zza(zzabu);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzhgx;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzdnj r1, com.google.android.gms.internal.ads.zzdmu r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzacb r1 = r0.f14976c
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzdnb r1 = r2.zzhgx
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zzdrp
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwe.zza(com.google.android.gms.internal.ads.zzdnj, com.google.android.gms.internal.ads.zzdmu):boolean");
    }

    public final zzdyz<zzbme> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzbmd zza = this.f14975b.zza(new zzbos(zzdnj, zzdmu, (String) null), (zzbmh) new C2110kq(this, new View(this.f14974a), (zzbdv) null, C2073jq.f9540a, zzdmu.zzhgz.get(0)));
        zzcwi zzahe = zza.zzahe();
        zzdnb zzdnb = zzdmu.zzhgx;
        return this.f14978e.zzu(zzdrl.CUSTOM_RENDER_SYN).zza(new C2147lq(this, new zzabu(zzahe, zzdnb.zzdrn, zzdnb.zzdrp)), this.f14977d).zzw(zzdrl.CUSTOM_RENDER_ACK).zze(zzdyr.zzag(zza.zzahc())).zzaww();
    }
}
