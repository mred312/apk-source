package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzand {

    /* renamed from: b */
    private static zzand f12539b;

    /* renamed from: a */
    private AtomicBoolean f12540a = new AtomicBoolean(false);

    @VisibleForTesting
    zzand() {
    }

    public static zzand zzuc() {
        if (f12539b == null) {
            f12539b = new zzand();
        }
        return f12539b;
    }

    @Nullable
    public final Thread zzc(Context context, String str) {
        if (!this.f12540a.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new C2572x2(this, context, str));
        thread.start();
        return thread;
    }
}
