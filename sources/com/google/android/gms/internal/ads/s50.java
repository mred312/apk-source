package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedi;
import com.google.android.gms.internal.ads.zzedm;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzefc;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class s50 implements zzegy {

    /* renamed from: a */
    private final String f10849a;

    /* renamed from: b */
    private final int f10850b;

    /* renamed from: c */
    private zzedy f10851c;

    /* renamed from: d */
    private zzedi f10852d;

    /* renamed from: e */
    private int f10853e;

    s50(zzefn zzefn) {
        String zzbdf = zzefn.zzbdf();
        this.f10849a = zzbdf;
        if (zzbdf.equals(zzeav.zzhzk)) {
            try {
                zzedz zzl = zzedz.zzl(zzefn.zzbdg(), zzeju.zzbhe());
                this.f10851c = (zzedy) zzeap.zzb(zzefn);
                this.f10850b = zzl.getKeySize();
            } catch (zzeks e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zzbdf.equals(zzeav.zzhzj)) {
            try {
                zzedj zzf = zzedj.zzf(zzefn.zzbdg(), zzeju.zzbhe());
                this.f10852d = (zzedi) zzeap.zzb(zzefn);
                this.f10853e = zzf.zzbay().getKeySize();
                this.f10850b = this.f10853e + zzf.zzbaz().getKeySize();
            } catch (zzeks e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(zzbdf);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final int zzbal() {
        return this.f10850b;
    }

    public final zzdzt zzm(byte[] bArr) {
        Class<zzdzt> cls = zzdzt.class;
        if (bArr.length != this.f10850b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.f10849a.equals(zzeav.zzhzk)) {
            return (zzdzt) zzeap.zza(this.f10849a, (zzels) (zzedy) ((zzekh) ((zzedy.zza) zzedy.zzbbq().zza(this.f10851c)).zzw(zzeiu.zzh(bArr, 0, this.f10850b)).zzbhv()), cls);
        } else if (this.f10849a.equals(zzeav.zzhzj)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.f10853e);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.f10853e, this.f10850b);
            zzedi.zza zzc = zzedi.zzbaw().zzew(this.f10852d.getVersion()).zzc((zzedm) ((zzekh) ((zzedm.zza) zzedm.zzbbc().zza(this.f10852d.zzbau())).zzu(zzeiu.zzt(copyOfRange)).zzbhv()));
            return (zzdzt) zzeap.zza(this.f10849a, (zzels) (zzedi) ((zzekh) zzc.zzc((zzefc) ((zzekh) ((zzefc.zza) zzefc.zzbcx().zza(this.f10852d.zzbav())).zzae(zzeiu.zzt(copyOfRange2)).zzbhv())).zzbhv()), cls);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
