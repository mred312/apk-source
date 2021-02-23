package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
class o30<V> implements zzdyz<V> {

    /* renamed from: b */
    static final zzdyz<?> f10250b = new o30((Object) null);

    /* renamed from: c */
    private static final Logger f10251c = Logger.getLogger(o30.class.getName());
    @NullableDecl

    /* renamed from: a */
    private final V f10252a;

    /* renamed from: com.google.android.gms.internal.ads.o30$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2236a<V> extends zzdxo.C2695k<V> {
        C2236a(Throwable th) {
            setException(th);
        }
    }

    o30(@NullableDecl V v) {
        this.f10252a = v;
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzdvv.checkNotNull(runnable, "Runnable was null.");
        zzdvv.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f10251c;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb.toString(), e);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public V get() {
        return this.f10252a;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.f10252a);
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 27 + String.valueOf(valueOf).length());
        sb.append(obj);
        sb.append("[status=SUCCESS, result=[");
        sb.append(valueOf);
        sb.append("]]");
        return sb.toString();
    }

    public V get(long j, TimeUnit timeUnit) {
        zzdvv.checkNotNull(timeUnit);
        return get();
    }
}
