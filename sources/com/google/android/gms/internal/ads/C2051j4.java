package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.ads.j4 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2051j4 implements Runnable {

    /* renamed from: a */
    private final OutputStream f9370a;

    /* renamed from: b */
    private final byte[] f9371b;

    C2051j4(OutputStream outputStream, byte[] bArr) {
        this.f9370a = outputStream;
        this.f9371b = bArr;
    }

    public final void run() {
        zzatg.m7548a(this.f9370a, this.f9371b);
    }
}
