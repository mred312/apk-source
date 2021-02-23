package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.m3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2815m3 {

    /* renamed from: a */
    private final zzhg f17378a;

    /* renamed from: b */
    private final byte[] f17379b;

    private C2815m3(int i) {
        byte[] bArr = new byte[i];
        this.f17379b = bArr;
        this.f17378a = zzhg.zza(bArr);
    }

    /* renamed from: a */
    public final zzgr mo18760a() {
        this.f17378a.zzb();
        return new C2831o3(this.f17379b);
    }

    /* renamed from: b */
    public final zzhg mo18761b() {
        return this.f17378a;
    }

    /* synthetic */ C2815m3(int i, C2767g3 g3Var) {
        this(i);
    }
}
