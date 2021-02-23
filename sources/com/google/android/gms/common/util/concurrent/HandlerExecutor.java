package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class HandlerExecutor implements Executor {

    /* renamed from: a */
    private final Handler f7637a;

    @KeepForSdk
    public HandlerExecutor(Looper looper) {
        this.f7637a = new zzi(looper);
    }

    public void execute(@NonNull Runnable runnable) {
        this.f7637a.post(runnable);
    }
}
