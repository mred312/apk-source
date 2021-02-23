package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzecu extends zzeae<zzefc> {
    public zzecu() {
        super(zzefc.class, new v50(zzeak.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m8638b(zzefg zzefg) {
        if (zzefg.zzbar() >= 10) {
            int i = w50.f11668a[zzefg.zzbdc().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzefg.zzbar() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzefg.zzbar() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzefg.zzbar() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public static void zza(zzefc zzefc) {
        zzeic.zzz(zzefc.getVersion(), 0);
        if (zzefc.zzbam().size() >= 16) {
            m8638b(zzefc.zzbcw());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzefd, zzefc> zzazy() {
        return new x50(this, zzefd.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zza((zzefc) zzels);
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzefc.zzt(zzeiu, zzeju.zzbhe());
    }
}
