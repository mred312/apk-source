package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzecc extends zzeaq<zzeer, zzeeu> {
    zzecc() {
        super(zzeer.class, zzeeu.class, new l50(zzdzx.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.ASYMMETRIC_PRIVATE;
    }

    public final zzead<zzeen, zzeer> zzazy() {
        return new k50(this, zzeen.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzeer zzeer = (zzeer) zzels;
        if (!zzeer.zzbam().isEmpty()) {
            zzeic.zzz(zzeer.getVersion(), 0);
            r50.m6796d(zzeer.zzbcj().zzbcc());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzeer.zzr(zzeiu, zzeju.zzbhe());
    }
}
