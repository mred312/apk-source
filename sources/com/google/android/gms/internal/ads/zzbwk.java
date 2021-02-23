package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbwk<ListenerT> {
    @GuardedBy("this")

    /* renamed from: a */
    private final Map<ListenerT, Executor> f13795a = new HashMap();

    protected zzbwk(Set<zzbxy<ListenerT>> set) {
        m7885a(set);
    }

    /* renamed from: a */
    private final synchronized void m7885a(Set<zzbxy<ListenerT>> set) {
        for (zzbxy<ListenerT> zza : set) {
            zza(zza);
        }
    }

    public final synchronized void zza(zzbxy<ListenerT> zzbxy) {
        zza(zzbxy.zzfzl, zzbxy.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.f13795a.put(listenert, executor);
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzbwm<ListenerT> zzbwm) {
        for (Map.Entry next : this.f13795a.entrySet()) {
            ((Executor) next.getValue()).execute(new C2624yf(zzbwm, next.getKey()));
        }
    }
}
