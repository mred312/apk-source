package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzdq {

    /* renamed from: a */
    private final boolean f17644a;

    public zzdq(zzdt zzdt) {
        zzeb.zza(zzdt, (Object) "BuildInfo must be non-null");
        this.f17644a = !zzdt.zza();
    }

    public final boolean zza(String str) {
        zzeb.zza(str, (Object) "flagName must not be null");
        if (!this.f17644a) {
            return true;
        }
        return zzds.zza.zza().zza(str);
    }
}
