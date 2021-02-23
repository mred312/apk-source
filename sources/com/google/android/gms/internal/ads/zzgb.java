package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzgb extends zzgl {

    /* renamed from: e */
    private List<Long> f16418e = null;

    public zzgb(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzq(-1);
        this.zzaay.zzr(-1);
        if (this.f16418e == null) {
            this.f16418e = (List) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()});
        }
        List<Long> list = this.f16418e;
        if (list != null && list.size() == 2) {
            synchronized (this.zzaay) {
                this.zzaay.zzq(this.f16418e.get(0).longValue());
                this.zzaay.zzr(this.f16418e.get(1).longValue());
            }
        }
    }
}
