package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzebk extends zzeae<zzeec> {
    zzebk() {
        super(zzeec.class, new z40(zzdzt.class));
    }

    /* renamed from: b */
    private static boolean m8632b() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void zzbr(boolean z) {
        if (m8632b()) {
            zzeap.zza(new zzebk(), true);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzeed, zzeec> zzazy() {
        return new y40(this, zzeed.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzeec zzeec = (zzeec) zzels;
        zzeic.zzz(zzeec.getVersion(), 0);
        zzeic.zzft(zzeec.zzbam().size());
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzeec.zzm(zzeiu, zzeju.zzbhe());
    }
}
