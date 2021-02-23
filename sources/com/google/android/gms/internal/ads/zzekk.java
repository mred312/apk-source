package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzekk {

    /* renamed from: a */
    static final Charset f16269a = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final byte[] zzijg;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzijg = bArr;
        ByteBuffer.wrap(bArr);
        zzejj.m8796a(bArr, 0, bArr.length, false);
    }

    /* renamed from: a */
    static <T> T m8823a(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: b */
    static int m8824b(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* renamed from: c */
    static <T> T m8825c(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: d */
    static Object m8826d(Object obj, Object obj2) {
        return ((zzels) obj).zzbid().zzf((zzels) obj2).zzbhu();
    }

    /* renamed from: e */
    static boolean m8827e(zzels zzels) {
        if (!(zzels instanceof zzeim)) {
            return false;
        }
        zzeim zzeim = (zzeim) zzels;
        return false;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int b = m8824b(length, bArr, 0, length);
        if (b == 0) {
            return 1;
        }
        return b;
    }

    public static int zzbu(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzfq(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean zzx(byte[] bArr) {
        return vb0.m7089n(bArr);
    }

    public static String zzy(byte[] bArr) {
        return new String(bArr, f16269a);
    }
}
