package com.google.android.gms.internal.ads;

import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class k50 extends zzead<zzeen, zzeer> {
    k50(zzecc zzecc, Class cls) {
        super(cls);
    }

    public final /* synthetic */ void zzc(zzels zzels) {
        r50.m6796d(((zzeen) zzels).zzbcc());
    }

    public final /* synthetic */ Object zzd(zzels zzels) {
        zzeen zzeen = (zzeen) zzels;
        KeyPair zza = zzehe.zza(zzehe.zza(r50.m6794b(zzeen.zzbcc().zzbce().zzbcr())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzeer) ((zzekh) zzeer.zzbck().zzfd(0).zzb((zzeeu) ((zzekh) zzeeu.zzbco().zzfe(0).zzc(zzeen.zzbcc()).zzac(zzeiu.zzt(w.getAffineX().toByteArray())).zzad(zzeiu.zzt(w.getAffineY().toByteArray())).zzbhv())).zzz(zzeiu.zzt(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbhv());
    }

    public final /* synthetic */ zzels zzq(zzeiu zzeiu) {
        return zzeen.zzq(zzeiu, zzeju.zzbhe());
    }
}
