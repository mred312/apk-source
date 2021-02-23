package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzik {

    /* renamed from: a */
    private final Handler f16465a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzih f16466b;

    public zzik(Handler handler, zzih zzih) {
        this.f16465a = zzih != null ? (Handler) zzpc.checkNotNull(handler) : null;
        this.f16466b = zzih;
    }

    public final void zzb(String str, long j, long j2) {
        if (this.f16466b != null) {
            this.f16465a.post(new td0(this, str, j, j2));
        }
    }

    public final void zzc(zzjm zzjm) {
        if (this.f16466b != null) {
            this.f16465a.post(new rd0(this, zzjm));
        }
    }

    public final void zzd(zzjm zzjm) {
        if (this.f16466b != null) {
            this.f16465a.post(new ud0(this, zzjm));
        }
    }

    public final void zzx(int i) {
        if (this.f16466b != null) {
            this.f16465a.post(new wd0(this, i));
        }
    }

    public final void zzb(int i, long j, long j2) {
        if (this.f16466b != null) {
            this.f16465a.post(new vd0(this, i, j, j2));
        }
    }

    public final void zzc(zzhp zzhp) {
        if (this.f16466b != null) {
            this.f16465a.post(new sd0(this, zzhp));
        }
    }
}
