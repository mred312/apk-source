package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public enum zzli {
    DOUBLE(zzll.DOUBLE, 1),
    FLOAT(zzll.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzll.BOOLEAN, 0),
    STRING(zzll.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzll.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzll.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    

    /* renamed from: a */
    private final zzll f17749a;

    /* renamed from: b */
    private final int f17750b;

    private zzli(zzll zzll, int i) {
        this.f17749a = zzll;
        this.f17750b = i;
    }

    public final zzll zza() {
        return this.f17749a;
    }

    public final int zzb() {
        return this.f17750b;
    }
}
