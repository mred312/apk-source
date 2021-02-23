package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzq;

/* renamed from: com.google.android.gms.measurement.internal.g */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
abstract class C2990g {

    /* renamed from: d */
    private static volatile Handler f18066d;

    /* renamed from: a */
    private final C3050m4 f18067a;

    /* renamed from: b */
    private final Runnable f18068b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile long f18069c;

    C2990g(C3050m4 m4Var) {
        Preconditions.checkNotNull(m4Var);
        this.f18067a = m4Var;
        this.f18068b = new C2980f(this, m4Var);
    }

    /* renamed from: f */
    private final Handler m10504f() {
        Handler handler;
        if (f18066d != null) {
            return f18066d;
        }
        synchronized (C2990g.class) {
            if (f18066d == null) {
                f18066d = new zzq(this.f18067a.zzm().getMainLooper());
            }
            handler = f18066d;
        }
        return handler;
    }

    /* renamed from: b */
    public abstract void mo19827b();

    /* renamed from: c */
    public final void mo19913c(long j) {
        mo19915e();
        if (j >= 0) {
            this.f18069c = this.f18067a.zzl().currentTimeMillis();
            if (!m10504f().postDelayed(this.f18068b, j)) {
                this.f18067a.zzq().zze().zza("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    /* renamed from: d */
    public final boolean mo19914d() {
        return this.f18069c != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo19915e() {
        this.f18069c = 0;
        m10504f().removeCallbacks(this.f18068b);
    }
}
