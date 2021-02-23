package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class x20<InputT, OutputT> extends a30<OutputT> {

    /* renamed from: o */
    private static final Logger f11749o = Logger.getLogger(x20.class.getName());
    /* access modifiers changed from: private */
    @NullableDecl

    /* renamed from: l */
    public zzdwl<? extends zzdyz<? extends InputT>> f11750l;

    /* renamed from: m */
    private final boolean f11751m;

    /* renamed from: n */
    private final boolean f11752n;

    /* renamed from: com.google.android.gms.internal.ads.x20$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    enum C2573a {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    x20(zzdwl<? extends zzdyz<? extends InputT>> zzdwl, boolean z, boolean z2) {
        super(zzdwl.size());
        this.f11750l = (zzdwl) zzdvv.checkNotNull(zzdwl);
        this.f11751m = z;
        this.f11752n = z2;
    }

    /* renamed from: A */
    private final void m7142A(Throwable th) {
        zzdvv.checkNotNull(th);
        if (this.f11751m && !setException(th) && m7147G(mo13526v(), th)) {
            m7149L(th);
        } else if (th instanceof Error) {
            m7149L(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public final void m7144C(int i, Future<? extends InputT> future) {
        try {
            mo13627J(i, zzdyr.zza(future));
        } catch (ExecutionException e) {
            m7142A(e.getCause());
        } catch (Throwable th) {
            m7142A(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public final void m7145D(@NullableDecl zzdwl<? extends Future<? extends InputT>> zzdwl) {
        int w = mo13527w();
        int i = 0;
        if (!(w >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        } else if (w == 0) {
            if (zzdwl != null) {
                zzdxh zzdxh = (zzdxh) zzdwl.iterator();
                while (zzdxh.hasNext()) {
                    Future future = (Future) zzdxh.next();
                    if (!future.isCancelled()) {
                        m7144C(i, future);
                    }
                    i++;
                }
            }
            mo13528x();
            mo13626I();
            mo13625E(C2573a.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    /* renamed from: G */
    private static boolean m7147G(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* renamed from: L */
    private static void m7149L(Throwable th) {
        f11749o.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo13625E(C2573a aVar) {
        zzdvv.checkNotNull(aVar);
        this.f11750l = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public final void mo14998H() {
        if (this.f11750l.isEmpty()) {
            mo13626I();
        } else if (this.f11751m) {
            int i = 0;
            zzdxh zzdxh = (zzdxh) this.f11750l.iterator();
            while (zzdxh.hasNext()) {
                zzdyz zzdyz = (zzdyz) zzdxh.next();
                zzdyz.addListener(new w20(this, zzdyz, i), g30.INSTANCE);
                i++;
            }
        } else {
            y20 y20 = new y20(this, this.f11752n ? this.f11750l : null);
            zzdxh zzdxh2 = (zzdxh) this.f11750l.iterator();
            while (zzdxh2.hasNext()) {
                ((zzdyz) zzdxh2.next()).addListener(y20, g30.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public abstract void mo13626I();

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public abstract void mo13627J(int i, @NullableDecl InputT inputt);

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        zzdwl<? extends zzdyz<? extends InputT>> zzdwl = this.f11750l;
        mo13625E(C2573a.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdwl != null)) {
            boolean wasInterrupted = wasInterrupted();
            zzdxh zzdxh = (zzdxh) zzdwl.iterator();
            while (zzdxh.hasNext()) {
                ((Future) zzdxh.next()).cancel(wasInterrupted);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdwl<? extends zzdyz<? extends InputT>> zzdwl = this.f11750l;
        if (zzdwl == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdwl);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("futures=");
        sb.append(valueOf);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public final void mo13529z(Set<Throwable> set) {
        zzdvv.checkNotNull(set);
        if (!isCancelled()) {
            m7147G(set, zzazc());
        }
    }
}
