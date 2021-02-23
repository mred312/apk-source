package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzawr {
    public static boolean isEnabled() {
        return zzadh.zzddl.get().booleanValue();
    }

    public static void zzeb(String str) {
        if (zzadh.zzddl.get().booleanValue()) {
            zzaza.zzeb(str);
        }
    }
}
