package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzqj {

    /* renamed from: a */
    private final Handler f16893a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzqg f16894b;

    public zzqj(Handler handler, zzqg zzqg) {
        this.f16893a = zzqg != null ? (Handler) zzpc.checkNotNull(handler) : null;
        this.f16894b = zzqg;
    }

    public final void zzb(String str, long j, long j2) {
        if (this.f16894b != null) {
            this.f16893a.post(new yg0(this, str, j, j2));
        }
    }

    public final void zzc(zzjm zzjm) {
        if (this.f16894b != null) {
            this.f16893a.post(new wg0(this, zzjm));
        }
    }

    public final void zzd(zzjm zzjm) {
        if (this.f16894b != null) {
            this.f16893a.post(new bh0(this, zzjm));
        }
    }

    public final void zzg(int i, long j) {
        if (this.f16894b != null) {
            this.f16893a.post(new ah0(this, i, j));
        }
    }

    public final void zzb(int i, int i2, int i3, float f) {
        if (this.f16894b != null) {
            this.f16893a.post(new zg0(this, i, i2, i3, f));
        }
    }

    public final void zzc(zzhp zzhp) {
        if (this.f16894b != null) {
            this.f16893a.post(new xg0(this, zzhp));
        }
    }

    public final void zzb(Surface surface) {
        if (this.f16894b != null) {
            this.f16893a.post(new ch0(this, surface));
        }
    }
}
