package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzgh extends zzgl {
    public zzgh(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zza(zzcn.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()})).booleanValue();
        synchronized (this.zzaay) {
            if (booleanValue) {
                this.zzaay.zza(zzcn.ENUM_TRUE);
            } else {
                this.zzaay.zza(zzcn.ENUM_FALSE);
            }
        }
    }
}
