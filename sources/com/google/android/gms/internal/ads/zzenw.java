package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public enum zzenw {
    DOUBLE(zzenz.DOUBLE, 1),
    FLOAT(zzenz.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzenz.BOOLEAN, 0),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzenz.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzenz.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    

    /* renamed from: a */
    private final zzenz f16288a;

    /* renamed from: b */
    private final int f16289b;

    private zzenw(zzenz zzenz, int i) {
        this.f16288a = zzenz;
        this.f16289b = i;
    }

    public final zzenz zzbkp() {
        return this.f16288a;
    }

    public final int zzbkq() {
        return this.f16289b;
    }
}
