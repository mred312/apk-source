package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzgd extends zzgl {

    /* renamed from: e */
    private final StackTraceElement[] f16419e;

    public zzgd(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzfa, str, str2, zza, i, 45);
        this.f16419e = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        zzcn zzcn;
        Object obj = this.f16419e;
        if (obj != null) {
            zzew zzew = new zzew((String) this.zzabi.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zzaay) {
                this.zzaay.zzab(zzew.zzyn.longValue());
                if (zzew.zzyo.booleanValue()) {
                    zzcf.zza.C3977zza zza = this.zzaay;
                    if (zzew.zzyp.booleanValue()) {
                        zzcn = zzcn.ENUM_FALSE;
                    } else {
                        zzcn = zzcn.ENUM_TRUE;
                    }
                    zza.zzc(zzcn);
                } else {
                    this.zzaay.zzc(zzcn.ENUM_FAILURE);
                }
            }
        }
    }
}
