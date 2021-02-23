package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class u40 extends zzead<zzedu, zzedr> {
    u40(zzebe zzebe, Class cls) {
        super(cls);
    }

    public final /* synthetic */ void zzc(zzels zzels) {
        zzedu zzedu = (zzedu) zzels;
        zzeic.zzft(zzedu.getKeySize());
        if (zzedu.zzbbk().zzbbh() != 12 && zzedu.zzbbk().zzbbh() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* synthetic */ Object zzd(zzels zzels) {
        zzedu zzedu = (zzedu) zzels;
        return (zzedr) ((zzekh) zzedr.zzbbl().zzv(zzeiu.zzt(zzehx.zzfs(zzedu.getKeySize()))).zzb(zzedu.zzbbk()).zzey(0).zzbhv());
    }

    public final /* synthetic */ zzels zzq(zzeiu zzeiu) {
        return zzedu.zzj(zzeiu, zzeju.zzbhe());
    }
}
