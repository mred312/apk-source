package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbdh extends zzbcx {
    public zzbdh(zzbbe zzbbe) {
        super(zzbbe);
    }

    public final void abort() {
    }

    public final boolean zzfj(String str) {
        zzbbe zzbbe = (zzbbe) this.zzeog.get();
        if (zzbbe != null) {
            zzbbe.zza(zzfk(str), (zzbcx) this);
        }
        zzaza.zzfa("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfk(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
