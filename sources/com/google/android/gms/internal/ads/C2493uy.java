package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.uy */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2493uy implements zzahv {

    /* renamed from: a */
    private final zzdrz f11450a;

    /* renamed from: b */
    private final zzcqo f11451b;

    C2493uy(zzdrz zzdrz, zzcqo zzcqo) {
        this.f11450a = zzdrz;
        this.f11451b = zzcqo;
    }

    public final void zza(Object obj, Map map) {
        zzdrz zzdrz = this.f11450a;
        zzcqo zzcqo = this.f11451b;
        zzbdk zzbdk = (zzbdk) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzaza.zzfa("URL missing from httpTrack GMSG.");
        } else if (!zzbdk.zzabw().zzhhq) {
            zzdrz.zzeo(str);
        } else {
            zzcqo.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), ((zzbeq) zzbdk).zzadk().zzbvf, str, zzcql.zzgqc));
        }
    }
}
