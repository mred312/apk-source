package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzdvd {
    protected zzdvd() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static String m8525a(char c) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static zzdvd zzb(char c) {
        return new m10(';');
    }

    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzdvv.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (zzc(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean zzc(char c);
}
