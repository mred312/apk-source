package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;

public final class EncodedPayload {

    /* renamed from: a */
    private final Encoding f7164a;

    /* renamed from: b */
    private final byte[] f7165b;

    public EncodedPayload(@NonNull Encoding encoding, @NonNull byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f7164a = encoding;
            this.f7165b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.f7164a.equals(encodedPayload.f7164a)) {
            return false;
        }
        return Arrays.equals(this.f7165b, encodedPayload.f7165b);
    }

    public byte[] getBytes() {
        return this.f7165b;
    }

    public Encoding getEncoding() {
        return this.f7164a;
    }

    public int hashCode() {
        return ((this.f7164a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f7165b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f7164a + ", bytes=[...]}";
    }
}
