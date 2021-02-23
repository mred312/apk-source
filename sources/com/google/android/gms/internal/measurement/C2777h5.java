package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.h5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2777h5 implements C2888v4 {

    /* renamed from: a */
    private final zzjh f17336a;

    /* renamed from: b */
    private final String f17337b;

    /* renamed from: c */
    private final Object[] f17338c;

    /* renamed from: d */
    private final int f17339d;

    C2777h5(zzjh zzjh, String str, Object[] objArr) {
        this.f17336a = zzjh;
        this.f17337b = str;
        this.f17338c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f17339d = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f17339d = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo18668a() {
        return this.f17337b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object[] mo18669b() {
        return this.f17338c;
    }

    public final int zza() {
        return (this.f17339d & 1) == 1 ? zzjw.zza : zzjw.zzb;
    }

    public final boolean zzb() {
        return (this.f17339d & 2) == 2;
    }

    public final zzjh zzc() {
        return this.f17336a;
    }
}
