package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public enum zzcn implements zzekj {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    

    /* renamed from: a */
    private final int f14621a;

    private zzcn(int i) {
        this.f14621a = i;
    }

    public static zzcn zzn(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i == 2) {
            return ENUM_FAILURE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzekl zzw() {
        return C1774bn.f7930a;
    }

    public final String toString() {
        return "<" + zzcn.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f14621a + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.f14621a;
    }
}
