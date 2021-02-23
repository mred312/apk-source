package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class r50 {
    /* renamed from: a */
    public static zzehf m6793a(zzeek zzeek) {
        int i = q50.f10684c[zzeek.ordinal()];
        if (i == 1) {
            return zzehf.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzehf.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzehf.COMPRESSED;
        }
        String valueOf = String.valueOf(zzeek);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    /* renamed from: b */
    public static zzehg m6794b(zzeey zzeey) {
        int i = q50.f10683b[zzeey.ordinal()];
        if (i == 1) {
            return zzehg.NIST_P256;
        }
        if (i == 2) {
            return zzehg.NIST_P384;
        }
        if (i == 3) {
            return zzehg.NIST_P521;
        }
        String valueOf = String.valueOf(zzeey);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    /* renamed from: c */
    public static String m6795c(zzefa zzefa) {
        int i = q50.f10682a[zzefa.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzefa);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    /* renamed from: d */
    public static void m6796d(zzeeq zzeeq) {
        zzehe.zza(m6794b(zzeeq.zzbce().zzbcr()));
        m6795c(zzeeq.zzbce().zzbcs());
        if (zzeeq.zzbcg() != zzeek.UNKNOWN_FORMAT) {
            zzeap.zza(zzeeq.zzbcf().zzbbz());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }
}
