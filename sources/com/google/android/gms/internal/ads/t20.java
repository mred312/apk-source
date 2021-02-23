package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class t20<I, O, F, T> extends j30<O> implements Runnable {
    @NullableDecl

    /* renamed from: h */
    private zzdyz<? extends I> f11128h;
    @NullableDecl

    /* renamed from: i */
    private F f11129i;

    t20(zzdyz<? extends I> zzdyz, F f) {
        this.f11128h = (zzdyz) zzdvv.checkNotNull(zzdyz);
        this.f11129i = zzdvv.checkNotNull(f);
    }

    /* renamed from: u */
    static <I, O> zzdyz<O> m6983u(zzdyz<I> zzdyz, zzdvm<? super I, ? extends O> zzdvm, Executor executor) {
        zzdvv.checkNotNull(zzdvm);
        u20 u20 = new u20(zzdyz, zzdvm);
        zzdyz.addListener(u20, zzdzb.m8610a(executor, u20));
        return u20;
    }

    /* renamed from: v */
    static <I, O> zzdyz<O> m6984v(zzdyz<I> zzdyz, zzdyb<? super I, ? extends O> zzdyb, Executor executor) {
        zzdvv.checkNotNull(executor);
        v20 v20 = new v20(zzdyz, zzdyb);
        zzdyz.addListener(v20, zzdzb.m8610a(executor, v20));
        return v20;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        mo17379c(this.f11128h);
        this.f11128h = null;
        this.f11129i = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        String str;
        zzdyz<? extends I> zzdyz = this.f11128h;
        F f = this.f11129i;
        String pendingToString = super.pendingToString();
        if (zzdyz != null) {
            String valueOf = String.valueOf(zzdyz);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf2).length());
            sb2.append(str);
            sb2.append("function=[");
            sb2.append(valueOf2);
            sb2.append("]");
            return sb2.toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(pendingToString);
            return valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
    }

    public final void run() {
        zzdyz<? extends I> zzdyz = this.f11128h;
        F f = this.f11129i;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzdyz == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.f11128h = null;
            if (zzdyz.isCancelled()) {
                setFuture(zzdyz);
                return;
            }
            try {
                try {
                    Object w = mo14817w(f, zzdyr.zza(zzdyz));
                    this.f11129i = null;
                    mo14816t(w);
                } catch (Throwable th) {
                    this.f11129i = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public abstract void mo14816t(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    /* renamed from: w */
    public abstract T mo14817w(F f, @NullableDecl I i);
}
