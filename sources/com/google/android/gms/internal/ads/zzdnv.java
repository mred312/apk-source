package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdnv {

    /* renamed from: a */
    private final zzdmu f15808a;

    /* renamed from: b */
    private final zzdmz f15809b;

    /* renamed from: c */
    private final zzcqo f15810c;

    /* renamed from: d */
    private final zzdrz f15811d;

    @VisibleForTesting
    public zzdnv(zzcqo zzcqo, zzdrz zzdrz, zzdmu zzdmu, zzdmz zzdmz) {
        this.f15808a = zzdmu;
        this.f15809b = zzdmz;
        this.f15810c = zzcqo;
        this.f15811d = zzdrz;
    }

    /* renamed from: a */
    private final void m8442a(String str, int i) {
        if (!this.f15808a.zzhhq) {
            this.f15811d.zzeo(str);
            return;
        }
        this.f15810c.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), this.f15809b.zzbvf, str, i));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.util.List<java.lang.String> r2, java.lang.Integer r3) {
        /*
            r1 = this;
            java.util.Iterator r2 = r2.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r2.next()
            java.lang.String r0 = (java.lang.String) r0
            r1.m8442a(r0, r3)
            goto L_0x0004
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnv.zza(java.util.List, int):void");
    }

    public final void zzi(List<String> list) {
        for (String a : list) {
            m8442a(a, zzcql.zzgqc);
        }
    }
}
