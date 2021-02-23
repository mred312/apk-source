package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepd<T> implements zzepf<T> {

    /* renamed from: a */
    private zzeps<T> f16354a;

    public static <T> void zzbl(zzeps<T> zzeps, zzeps<T> zzeps2) {
        zzepl.checkNotNull(zzeps2);
        zzepd zzepd = (zzepd) zzeps;
        if (zzepd.f16354a == null) {
            zzepd.f16354a = zzeps2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T get() {
        zzeps<T> zzeps = this.f16354a;
        if (zzeps != null) {
            return zzeps.get();
        }
        throw new IllegalStateException();
    }
}
