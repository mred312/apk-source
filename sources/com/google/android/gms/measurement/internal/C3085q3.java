package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzm;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.android.gms.measurement.internal.q3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3085q3<V> extends FutureTask<V> implements Comparable<C3085q3<V>> {

    /* renamed from: a */
    private final long f18314a;

    /* renamed from: b */
    final boolean f18315b;

    /* renamed from: c */
    private final String f18316c;

    /* renamed from: d */
    private final /* synthetic */ zzfo f18317d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3085q3(zzfo zzfo, Callable<V> callable, boolean z, String str) {
        super(zzm.zza().zza(callable));
        this.f18317d = zzfo;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfo.f18583k.getAndIncrement();
        this.f18314a = andIncrement;
        this.f18316c = str;
        this.f18315b = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfo.zzq().zze().zza("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        C3085q3 q3Var = (C3085q3) obj;
        boolean z = this.f18315b;
        if (z != q3Var.f18315b) {
            return z ? -1 : 1;
        }
        long j = this.f18314a;
        long j2 = q3Var.f18314a;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f18317d.zzq().zzf().zza("Two tasks share the same index. index", Long.valueOf(this.f18314a));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.f18317d.zzq().zze().zza(this.f18316c, th);
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3085q3(zzfo zzfo, Runnable runnable, boolean z, String str) {
        super(zzm.zza().zza(runnable), (Object) null);
        this.f18317d = zzfo;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfo.f18583k.getAndIncrement();
        this.f18314a = andIncrement;
        this.f18316c = str;
        this.f18315b = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfo.zzq().zze().zza("Tasks index overflow");
        }
    }
}
