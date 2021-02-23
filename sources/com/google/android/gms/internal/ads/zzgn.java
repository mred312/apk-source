package com.google.android.gms.internal.ads;

import androidx.room.RoomDatabase;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public enum zzgn implements zzekj {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(RoomDatabase.MAX_BIND_PARAMETER_CNT);
    

    /* renamed from: a */
    private final int f16437a;

    private zzgn(int i) {
        this.f16437a = i;
    }

    public final String toString() {
        return "<" + zzgn.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f16437a + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.f16437a;
    }
}
