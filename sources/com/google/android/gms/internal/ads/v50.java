package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class v50 extends zzeag<zzeak, zzefc> {
    v50(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) {
        zzefc zzefc = (zzefc) obj;
        zzefa zzbdc = zzefc.zzbcw().zzbdc();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzefc.zzbam().toByteArray(), "HMAC");
        int zzbar = zzefc.zzbcw().zzbar();
        int i = w50.f11668a[zzbdc.ordinal()];
        if (i == 1) {
            return new zzehy(new zzehw("HMACSHA1", secretKeySpec), zzbar);
        }
        if (i == 2) {
            return new zzehy(new zzehw("HMACSHA256", secretKeySpec), zzbar);
        }
        if (i == 3) {
            return new zzehy(new zzehw("HMACSHA512", secretKeySpec), zzbar);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
