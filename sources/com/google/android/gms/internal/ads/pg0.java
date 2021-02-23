package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class pg0 implements ThreadFactory {

    /* renamed from: a */
    private final /* synthetic */ String f10626a;

    pg0(String str) {
        this.f10626a = str;
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.f10626a);
    }
}
