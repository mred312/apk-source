package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabh {
    /* renamed from: a */
    private static boolean m7428a(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzp.zzku().zza(e, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }

    public static boolean zzcp(String str) {
        return m7428a((String) zzwq.zzqe().zzd(zzabf.zzcuz), str);
    }
}
