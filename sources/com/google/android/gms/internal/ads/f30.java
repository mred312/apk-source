package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.x20;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class f30<V> extends x20<Object, V> {
    /* access modifiers changed from: private */

    /* renamed from: p */
    public h30<?> f8424p;

    f30(zzdwl<? extends zzdyz<?>> zzdwl, boolean z, Executor executor, Callable<V> callable) {
        super(zzdwl, z, false);
        this.f8424p = new e30(this, callable, executor);
        mo14998H();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public final void mo13625E(x20.C2573a aVar) {
        super.mo13625E(aVar);
        if (aVar == x20.C2573a.OUTPUT_FUTURE_DONE) {
            this.f8424p = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public final void mo13626I() {
        h30<?> h30 = this.f8424p;
        if (h30 != null) {
            h30.mo14078f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public final void mo13627J(int i, @NullableDecl Object obj) {
    }

    /* access modifiers changed from: protected */
    public final void interruptTask() {
        h30<?> h30 = this.f8424p;
        if (h30 != null) {
            h30.mo14632a();
        }
    }
}
