package com.google.android.gms.internal.ads;

import android.os.Build;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpt {
    public static final String DEVICE;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;
    public static final String zzbkl;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i = 26;
        }
        SDK_INT = i;
        String str = Build.DEVICE;
        DEVICE = str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = str2;
        String str3 = Build.MODEL;
        MODEL = str3;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 17 + String.valueOf(str3).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(i);
        zzbkl = sb.toString();
        Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(long[] r4, long r5, boolean r7, boolean r8) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x0009
            r5 = r0 ^ -1
            goto L_0x001a
        L_0x0009:
            int r0 = r0 + 1
            int r1 = r4.length
            if (r0 >= r1) goto L_0x0014
            r1 = r4[r0]
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0009
        L_0x0014:
            if (r7 == 0) goto L_0x0019
            int r5 = r0 + -1
            goto L_0x001a
        L_0x0019:
            r5 = r0
        L_0x001a:
            if (r8 == 0) goto L_0x0024
            int r4 = r4.length
            int r4 = r4 + -1
            int r4 = java.lang.Math.min(r4, r5)
            return r4
        L_0x0024:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpt.zzb(long[], long, boolean, boolean):int");
    }

    public static ExecutorService zzbf(String str) {
        return Executors.newSingleThreadExecutor(new pg0(str));
    }

    public static byte[] zzbg(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    public static int zzbh(String str) {
        int length = str.length();
        zzpc.checkArgument(length <= 4);
        char c = 0;
        for (int i = 0; i < length; i++) {
            c = (c << 8) | str.charAt(i);
        }
        return c;
    }

    public static byte[] zzbi(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i << 1;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static int zzbo(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i != 24) {
            return i != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static int zzbp(int i) {
        if (i == 0) {
            return 16777216;
        }
        if (i == 1) {
            return 3538944;
        }
        if (i == 2) {
            return 13107200;
        }
        if (i == 3 || i == 4) {
            return 131072;
        }
        throw new IllegalStateException();
    }

    public static int zzd(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static int zzf(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int zzg(int i, int i2) {
        if (i == Integer.MIN_VALUE) {
            return i2 * 3;
        }
        if (i == 1073741824) {
            return i2 << 2;
        }
        if (i == 2) {
            return i2 << 1;
        }
        if (i == 3) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static void zza(zzon zzon) {
        if (zzon != null) {
            try {
                zzon.close();
            } catch (IOException unused) {
            }
        }
    }

    public static float zza(float f, float f2, float f3) {
        return Math.max(0.1f, Math.min(f, 8.0f));
    }

    public static int zza(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j) {
                    i = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j);
            i = binarySearch + 1;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static long zza(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        double d = (double) j2;
        double d2 = (double) j3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (double) j;
        Double.isNaN(d3);
        return (long) (d3 * (d / d2));
    }

    public static void zza(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
        } else if (j2 >= 1000000 || 1000000 % j2 != 0) {
            double d = (double) j2;
            Double.isNaN(d);
            double d2 = 1000000.0d / d;
            while (i < jArr.length) {
                double d3 = (double) jArr[i];
                Double.isNaN(d3);
                jArr[i] = (long) (d3 * d2);
                i++;
            }
        } else {
            long j4 = 1000000 / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j4;
                i++;
            }
        }
    }

    public static String zza(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
