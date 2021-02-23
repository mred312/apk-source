package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.ty */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2456ty implements zzahv {

    /* renamed from: a */
    private final zzdrz f11231a;

    /* renamed from: b */
    private final zzcqo f11232b;

    C2456ty(zzdrz zzdrz, zzcqo zzcqo) {
        this.f11231a = zzdrz;
        this.f11232b = zzcqo;
    }

    /* JADX WARNING: type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbex, com.google.android.gms.internal.ads.zzbdk] */
    public final void zza(Object obj, Map map) {
        int i;
        zzdrz zzdrz = this.f11231a;
        zzcqo zzcqo = this.f11232b;
        ? r9 = (zzbdk) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzaza.zzfa("URL missing from click GMSG.");
            return;
        }
        String zza = zzahc.zza(r9, str);
        if (!r9.zzabw().zzhhq) {
            zzdrz.zzeo(zza);
            return;
        }
        long currentTimeMillis = zzp.zzkx().currentTimeMillis();
        String str2 = r9.zzadk().zzbvf;
        zzp.zzkq();
        if (zzm.zzbc(((zzbex) r9).getContext())) {
            i = zzcql.zzgqc;
        } else {
            i = zzcql.zzgqb;
        }
        zzcqo.zza(new zzcqv(currentTimeMillis, str2, zza, i));
    }
}
