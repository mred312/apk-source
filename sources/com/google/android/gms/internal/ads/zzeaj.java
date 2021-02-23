package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import com.google.android.gms.internal.ads.zzefr;
import java.security.GeneralSecurityException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeaj {
    @Deprecated
    public static final zzeaf zzk(byte[] bArr) {
        try {
            zzefr zzc = zzefr.zzc(bArr, zzeju.zzbhe());
            for (zzefr.zza next : zzc.zzbdt()) {
                if (next.zzbdx().zzbdh() == zzefh.zzb.UNKNOWN_KEYMATERIAL || next.zzbdx().zzbdh() == zzefh.zzb.SYMMETRIC || next.zzbdx().zzbdh() == zzefh.zzb.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzeaf.m8614a(zzc);
        } catch (zzeks unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
