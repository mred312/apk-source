package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.InputStream;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.ads.i6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2016i6 extends FilterInputStream {

    /* renamed from: a */
    private final long f9259a;

    /* renamed from: b */
    private long f9260b;

    C2016i6(InputStream inputStream, long j) {
        super(inputStream);
        this.f9259a = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo14249a() {
        return this.f9259a - this.f9260b;
    }

    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.f9260b++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f9260b += (long) read;
        }
        return read;
    }
}
