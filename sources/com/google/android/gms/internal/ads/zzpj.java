package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpj {
    /* renamed from: a */
    private static String m9045a(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid mime type: ".concat(valueOf) : new String("Invalid mime type: "));
    }

    public static boolean zzbc(String str) {
        return "audio".equals(m9045a(str));
    }

    public static boolean zzbd(String str) {
        return "video".equals(m9045a(str));
    }
}
