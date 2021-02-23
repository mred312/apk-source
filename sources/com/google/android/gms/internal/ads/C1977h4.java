package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* renamed from: com.google.android.gms.internal.ads.h4 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1977h4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private final /* synthetic */ Thread.UncaughtExceptionHandler f8829a;

    /* renamed from: b */
    private final /* synthetic */ zzasn f8830b;

    C1977h4(zzasn zzasn, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f8830b = zzasn;
        this.f8829a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.f8830b.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f8829a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f8829a;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
