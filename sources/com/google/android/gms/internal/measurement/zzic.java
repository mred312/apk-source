package com.google.android.gms.internal.measurement;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public final class zzic {

    /* renamed from: a */
    static final Charset f17731a = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final byte[] zzb;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzhd.m10358a(bArr, 0, bArr.length, false);
    }

    /* renamed from: a */
    static int m10382a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* renamed from: b */
    static <T> T m10383b(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: c */
    static Object m10384c(Object obj, Object obj2) {
        return ((zzjh) obj).zzbs().zza((zzjh) obj2).zzy();
    }

    /* renamed from: d */
    static <T> T m10385d(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: e */
    static boolean m10386e(zzjh zzjh) {
        if (!(zzjh instanceof zzgj)) {
            return false;
        }
        zzgj zzgj = (zzgj) zzjh;
        return false;
    }

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static boolean zza(byte[] bArr) {
        return C2794j6.m9535f(bArr);
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, f17731a);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        int a = m10382a(length, bArr, 0, length);
        if (a == 0) {
            return 1;
        }
        return a;
    }
}
