package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.l */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2120l implements zzadp {

    /* renamed from: a */
    private final /* synthetic */ zzabb f9790a;

    C2120l(zzabb zzabb) {
        this.f9790a = zzabb;
    }

    public final String get(String str, String str2) {
        return this.f9790a.f12345e.getString(str, str2);
    }

    public final Long getLong(String str, long j) {
        try {
            return Long.valueOf(this.f9790a.f12345e.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.f9790a.f12345e.getInt(str, (int) j));
        }
    }

    public final Double zza(String str, double d) {
        return Double.valueOf((double) this.f9790a.f12345e.getFloat(str, (float) d));
    }

    public final Boolean zzf(String str, boolean z) {
        return Boolean.valueOf(this.f9790a.f12345e.getBoolean(str, z));
    }
}
