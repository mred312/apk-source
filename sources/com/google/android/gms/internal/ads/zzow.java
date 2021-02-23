package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ExecutorService f16813a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ng0<? extends zzpb> f16814b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IOException f16815c;

    public zzow(String str) {
        this.f16813a = zzpt.zzbf(str);
    }

    public final boolean isLoading() {
        return this.f16814b != null;
    }

    public final <T extends zzpb> long zza(T t, zzoz<T> zzoz, int i) {
        Looper myLooper = Looper.myLooper();
        zzpc.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new ng0(this, myLooper, t, zzoz, i, elapsedRealtime).mo14492d(0);
        return elapsedRealtime;
    }

    public final void zzbg(int i) {
        IOException iOException = this.f16815c;
        if (iOException == null) {
            ng0<? extends zzpb> ng0 = this.f16814b;
            if (ng0 != null) {
                ng0.mo14491c(ng0.f10194c);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzis() {
        this.f16814b.mo14493e(false);
    }

    public final void zza(Runnable runnable) {
        ng0<? extends zzpb> ng0 = this.f16814b;
        if (ng0 != null) {
            ng0.mo14493e(true);
        }
        this.f16813a.execute(runnable);
        this.f16813a.shutdown();
    }
}
