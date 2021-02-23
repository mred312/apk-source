package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzecj {
    @Deprecated
    public static final zzegf zzhzr = zzegf.zzbes();

    static {
        new n50().getKeyType();
        new zzecc().getKeyType();
        zzegf.zzbes();
        zzegf.zzbes();
        try {
            zzeav.zzbai();
            zzeap.zza(new zzecc(), new n50(), true);
            zzeap.zza(new zzeci());
            zzeap.zza(new p50());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
