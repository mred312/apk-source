package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.b6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1757b6 implements Executor {

    /* renamed from: a */
    private final Handler f7874a = new zzg(Looper.getMainLooper());

    C1757b6() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzp.zzkq();
                zzm.zza(zzp.zzku().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.f7874a.post(runnable);
        }
    }
}
