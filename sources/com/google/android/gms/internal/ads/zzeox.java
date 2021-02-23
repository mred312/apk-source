package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzeox {
    public static zzeox zzn(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzeou(cls.getSimpleName());
        }
        return new zzeow(cls.getSimpleName());
    }

    public abstract void zzii(String str);
}
