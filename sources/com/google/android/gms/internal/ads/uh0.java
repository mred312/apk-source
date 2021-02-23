package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class uh0 {
    @VisibleForTesting

    /* renamed from: a */
    private ByteArrayOutputStream f11422a = new ByteArrayOutputStream(4096);
    @VisibleForTesting

    /* renamed from: b */
    private Base64OutputStream f11423b = new Base64OutputStream(this.f11422a, 10);

    /* renamed from: a */
    public final void mo14883a(byte[] bArr) {
        this.f11423b.write(bArr);
    }

    public final String toString() {
        try {
            this.f11423b.close();
        } catch (IOException e) {
            zzaza.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.f11422a.close();
            return this.f11422a.toString();
        } catch (IOException e2) {
            zzaza.zzc("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.f11422a = null;
            this.f11423b = null;
        }
    }
}
