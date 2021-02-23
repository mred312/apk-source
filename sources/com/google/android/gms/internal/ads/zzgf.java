package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzgf extends zzgl {

    /* renamed from: e */
    private final zzfh f16421e;

    /* renamed from: f */
    private long f16422f;

    public zzgf(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2, zzfh zzfh) {
        super(zzfa, str, str2, zza, i, 53);
        this.f16421e = zzfh;
        if (zzfh != null) {
            this.f16422f = zzfh.zzcu();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.f16421e != null) {
            this.zzaay.zzae(((Long) this.zzabi.invoke((Object) null, new Object[]{Long.valueOf(this.f16422f)})).longValue());
        }
    }
}
