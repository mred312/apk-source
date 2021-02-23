package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzdyz;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zza {
    /* access modifiers changed from: private */
    public volatile Thread thread;
    private final Runnable zzebx = new zzc(this);
    private boolean zzeby = false;

    public abstract void zzvm();

    public final zzdyz<?> zzxl() {
        return zzazj.zzegq.zzg(this.zzebx);
    }
}
