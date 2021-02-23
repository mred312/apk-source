package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzoh {

    /* renamed from: a */
    private zzog f16785a;

    /* access modifiers changed from: protected */
    public final void invalidate() {
        zzog zzog = this.f16785a;
        if (zzog != null) {
            zzog.zzes();
        }
    }

    public abstract zzoj zza(zzhx[] zzhxArr, zznq zznq);

    public final void zza(zzog zzog) {
        this.f16785a = zzog;
    }

    public abstract void zzd(Object obj);
}
