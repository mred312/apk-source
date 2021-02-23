package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class l50 extends zzeag<zzdzx, zzeer> {
    l50(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) {
        zzeer zzeer = (zzeer) obj;
        zzeeq zzbcc = zzeer.zzbcj().zzbcc();
        zzeev zzbce = zzbcc.zzbce();
        zzehg b = r50.m6794b(zzbce.zzbcr());
        byte[] byteArray = zzeer.zzbam().toByteArray();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, byteArray), zzehe.zza(b));
        return new zzegx((ECPrivateKey) zzehh.zzihj.zzhq("EC").generatePrivate(eCPrivateKeySpec), zzbce.zzbct().toByteArray(), r50.m6795c(zzbce.zzbcs()), r50.m6793a(zzbcc.zzbcg()), new s50(zzbcc.zzbcf().zzbbz()));
    }
}
