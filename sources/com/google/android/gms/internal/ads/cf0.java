package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class cf0 implements bf0 {

    /* renamed from: a */
    private final zzpn f8000a;

    /* renamed from: b */
    private final int f8001b;

    /* renamed from: c */
    private final int f8002c;

    /* renamed from: d */
    private int f8003d;

    /* renamed from: e */
    private int f8004e;

    public cf0(we0 we0) {
        zzpn zzpn = we0.f11705P0;
        this.f8000a = zzpn;
        zzpn.zzbl(12);
        this.f8002c = zzpn.zzjf() & 255;
        this.f8001b = zzpn.zzjf();
    }

    /* renamed from: a */
    public final int mo13703a() {
        int i = this.f8002c;
        if (i == 8) {
            return this.f8000a.readUnsignedByte();
        }
        if (i == 16) {
            return this.f8000a.readUnsignedShort();
        }
        int i2 = this.f8003d;
        this.f8003d = i2 + 1;
        if (i2 % 2 != 0) {
            return this.f8004e & 15;
        }
        int readUnsignedByte = this.f8000a.readUnsignedByte();
        this.f8004e = readUnsignedByte;
        return (readUnsignedByte & 240) >> 4;
    }

    /* renamed from: b */
    public final boolean mo13704b() {
        return false;
    }

    /* renamed from: c */
    public final int mo13705c() {
        return this.f8001b;
    }
}
