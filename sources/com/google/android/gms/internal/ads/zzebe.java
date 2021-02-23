package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzebe extends zzeae<zzedr> {
    zzebe() {
        super(zzedr.class, new v40(zzdzt.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzedu, zzedr> zzazy() {
        return new u40(this, zzedu.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzedr zzedr = (zzedr) zzels;
        zzeic.zzz(zzedr.getVersion(), 0);
        zzeic.zzft(zzedr.zzbam().size());
        if (zzedr.zzbbk().zzbbh() != 12 && zzedr.zzbbk().zzbbh() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzedr.zzi(zzeiu, zzeju.zzbhe());
    }
}
