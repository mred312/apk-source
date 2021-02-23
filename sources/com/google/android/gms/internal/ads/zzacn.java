package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class zzacn<T> {

    /* renamed from: a */
    private final String f12385a;

    /* renamed from: b */
    private final T f12386b;

    /* renamed from: c */
    private final int f12387c;

    /* JADX WARNING: type inference failed for: r3v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected zzacn(java.lang.String r1, T r2, java.lang.Integer r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.f12385a = r1
            r0.f12386b = r2
            r0.f12387c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacn.<init>(java.lang.String, java.lang.Object, int):void");
    }

    public static zzacn<Long> zzb(String str, long j) {
        return new zzacn<>(str, Long.valueOf(j), C2495v.f11453b);
    }

    public static zzacn<Boolean> zzg(String str, boolean z) {
        return new zzacn<>(str, Boolean.valueOf(z), C2495v.f11452a);
    }

    public static zzacn<String> zzi(String str, String str2) {
        return new zzacn<>(str, str2, C2495v.f11455d);
    }

    public T get() {
        zzadp a = zzado.m7436a();
        if (a != null) {
            int i = C2458u.f11234a[this.f12387c - 1];
            if (i == 1) {
                return a.zzf(this.f12385a, ((Boolean) this.f12386b).booleanValue());
            }
            if (i == 2) {
                return a.getLong(this.f12385a, ((Long) this.f12386b).longValue());
            }
            if (i == 3) {
                return a.zza(this.f12385a, ((Double) this.f12386b).doubleValue());
            }
            if (i == 4) {
                return a.get(this.f12385a, (String) this.f12386b);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException("Flag is not initialized.");
    }

    public static zzacn<Double> zzb(String str, double d) {
        return new zzacn<>(str, Double.valueOf(d), C2495v.f11454c);
    }
}
