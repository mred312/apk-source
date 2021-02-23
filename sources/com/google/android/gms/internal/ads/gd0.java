package com.google.android.gms.internal.ads;

import java.security.cert.X509Certificate;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class gd0 extends be0 {

    /* renamed from: b */
    private byte[] f8742b;

    public gd0(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f8742b = bArr;
    }

    public final byte[] getEncoded() {
        return this.f8742b;
    }
}
