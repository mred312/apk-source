package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* renamed from: com.google.android.gms.measurement.internal.o3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3067o3 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private final String f18278a;

    /* renamed from: b */
    private final /* synthetic */ zzfo f18279b;

    public C3067o3(zzfo zzfo, String str) {
        this.f18279b = zzfo;
        Preconditions.checkNotNull(str);
        this.f18278a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f18279b.zzq().zze().zza(this.f18278a, th);
    }
}
