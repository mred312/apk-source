package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public enum zzcb implements zzekj {
    ENUM_SIGNAL_SOURCE_UNKNOWN(0),
    ENUM_SIGNAL_SOURCE_DISABLE(1),
    ENUM_SIGNAL_SOURCE_ADSHIELD(2),
    ENUM_SIGNAL_SOURCE_GASS(3),
    ENUM_SIGNAL_SOURCE_CALLER_PROVIDED(4);
    

    /* renamed from: a */
    private final int f13937a;

    private zzcb(int i) {
        this.f13937a = i;
    }

    public static zzcb zzj(int i) {
        if (i == 0) {
            return ENUM_SIGNAL_SOURCE_UNKNOWN;
        }
        if (i == 1) {
            return ENUM_SIGNAL_SOURCE_DISABLE;
        }
        if (i == 2) {
            return ENUM_SIGNAL_SOURCE_ADSHIELD;
        }
        if (i == 3) {
            return ENUM_SIGNAL_SOURCE_GASS;
        }
        if (i != 4) {
            return null;
        }
        return ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
    }

    public static zzekl zzw() {
        return C2064jh.f9512a;
    }

    public final String toString() {
        return "<" + zzcb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f13937a + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.f13937a;
    }
}
