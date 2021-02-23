package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.e8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1870e8 extends zzbm {

    /* renamed from: c */
    static final C1870e8 f8323c = new C1870e8();

    C1870e8() {
    }

    public final zzbp zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbr();
        }
        if ("mvhd".equals(str)) {
            return new zzbu();
        }
        return new zzbt(str);
    }
}
