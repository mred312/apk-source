package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public enum zzuo implements zzekj {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);
    

    /* renamed from: a */
    private final int f17063a;

    private zzuo(int i) {
        this.f17063a = i;
    }

    public static zzuo zzcd(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzekl zzw() {
        return pi0.f10635a;
    }

    public final String toString() {
        return "<" + zzuo.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17063a + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.f17063a;
    }
}
