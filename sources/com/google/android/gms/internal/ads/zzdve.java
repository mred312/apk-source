package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzdve {
    /* renamed from: a */
    private static int m8527a(char c) {
        return (char) ((c | ' ') - 'a');
    }

    public static boolean zza(CharSequence charSequence, CharSequence charSequence2) {
        int a;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence2.charAt(i);
            if (charAt != charAt2 && ((a = m8527a(charAt)) >= 26 || a != m8527a(charAt2))) {
                return false;
            }
        }
        return true;
    }
}
