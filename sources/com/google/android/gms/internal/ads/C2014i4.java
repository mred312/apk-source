package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* renamed from: com.google.android.gms.internal.ads.i4 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2014i4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private final /* synthetic */ Thread.UncaughtExceptionHandler f9254a;

    /* renamed from: b */
    private final /* synthetic */ zzasn f9255b;

    C2014i4(zzasn zzasn, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f9255b = zzasn;
        this.f9254a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.f9255b.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f9254a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f9254a;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
