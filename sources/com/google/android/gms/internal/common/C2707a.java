package com.google.android.gms.internal.common;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.common.a */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C2707a implements zzf {
    private C2707a() {
    }

    @NonNull
    public final ScheduledExecutorService zza(int i, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
