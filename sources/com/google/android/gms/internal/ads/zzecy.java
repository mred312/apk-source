package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzecy {
    @Deprecated

    /* renamed from: a */
    private static final zzegf f16119a = zzegf.zzbes();

    static {
        new zzecu().getKeyType();
        try {
            zzbai();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zzbai() {
        zzeap.zza(new zzecu(), true);
        zzeap.zza(new zzecp(), true);
        zzeap.zza(new y50());
    }
}
