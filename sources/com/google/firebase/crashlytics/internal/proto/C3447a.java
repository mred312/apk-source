package com.google.firebase.crashlytics.internal.proto;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.google.firebase.crashlytics.internal.proto.a */
/* compiled from: ByteString */
final class C3447a {

    /* renamed from: a */
    private final byte[] f19483a;

    /* renamed from: b */
    private volatile int f19484b = 0;

    private C3447a(byte[] bArr) {
        this.f19483a = bArr;
    }

    /* renamed from: a */
    public static C3447a m11674a(byte[] bArr) {
        return m11675b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public static C3447a m11675b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C3447a(bArr2);
    }

    /* renamed from: c */
    public static C3447a m11676c(String str) {
        try {
            return new C3447a(str.getBytes(Key.STRING_CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    /* renamed from: d */
    public void mo21476d(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f19483a, i, bArr, i2, i3);
    }

    /* renamed from: e */
    public InputStream mo21477e() {
        return new ByteArrayInputStream(this.f19483a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3447a)) {
            return false;
        }
        byte[] bArr = this.f19483a;
        int length = bArr.length;
        byte[] bArr2 = ((C3447a) obj).f19483a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public int mo21479f() {
        return this.f19483a.length;
    }

    public int hashCode() {
        int i = this.f19484b;
        if (i == 0) {
            int i2 = r1;
            for (byte b : this.f19483a) {
                i2 = (i2 * 31) + b;
            }
            i = i2 == 0 ? 1 : i2;
            this.f19484b = i;
        }
        return i;
    }
}
