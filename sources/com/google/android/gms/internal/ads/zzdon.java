package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdon implements zzaym, zzbrz {
    @GuardedBy("this")

    /* renamed from: a */
    private final HashSet<zzayf> f15822a = new HashSet<>();

    /* renamed from: b */
    private final Context f15823b;

    /* renamed from: c */
    private final zzayq f15824c;

    public zzdon(Context context, zzayq zzayq) {
        this.f15823b = context;
        this.f15824c = zzayq;
    }

    public final synchronized void zza(HashSet<zzayf> hashSet) {
        this.f15822a.clear();
        this.f15822a.addAll(hashSet);
    }

    public final Bundle zzauy() {
        return this.f15824c.zza(this.f15823b, (zzaym) this);
    }

    public final synchronized void zzk(zzve zzve) {
        if (zzve.errorCode != 3) {
            this.f15824c.zzb(this.f15822a);
        }
    }
}
