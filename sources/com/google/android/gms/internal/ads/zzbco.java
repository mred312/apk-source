package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbco implements zzbdf {
    public final zzbcx zza(zzbbe zzbbe, int i, String str, zzbbf zzbbf) {
        if (i <= 0) {
            return new zzbde(zzbbe);
        }
        int zzabr = zzbca.zzabr();
        if (zzabr < zzbbf.zzeky) {
            return new zzbdi(zzbbe, zzbbf);
        }
        if (zzabr < zzbbf.zzeks) {
            return new zzbdj(zzbbe, zzbbf);
        }
        return new zzbdh(zzbbe);
    }
}
