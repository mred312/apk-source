package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.vz */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2531vz implements zzduf {

    /* renamed from: a */
    private final /* synthetic */ zzdsg f11648a;

    C2531vz(zzdp zzdp, zzdsg zzdsg) {
        this.f11648a = zzdsg;
    }

    public final boolean zzb(File file) {
        try {
            return this.f11648a.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
