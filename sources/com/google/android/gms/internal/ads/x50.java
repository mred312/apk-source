package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class x50 extends zzead<zzefd, zzefc> {
    x50(zzecu zzecu, Class cls) {
        super(cls);
    }

    public final /* synthetic */ void zzc(zzels zzels) {
        zzefd zzefd = (zzefd) zzels;
        if (zzefd.getKeySize() >= 16) {
            zzecu.m8638b(zzefd.zzbcw());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final /* synthetic */ Object zzd(zzels zzels) {
        zzefd zzefd = (zzefd) zzels;
        return (zzefc) ((zzekh) zzefc.zzbcx().zzfh(0).zzd(zzefd.zzbcw()).zzae(zzeiu.zzt(zzehx.zzfs(zzefd.getKeySize()))).zzbhv());
    }

    public final /* synthetic */ zzels zzq(zzeiu zzeiu) {
        return zzefd.zzu(zzeiu, zzeju.zzbhe());
    }
}
