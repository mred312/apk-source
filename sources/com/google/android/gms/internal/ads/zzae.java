package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzae {

    /* renamed from: a */
    private final AtomicInteger f12408a;

    /* renamed from: b */
    private final Set<zzaa<?>> f12409b;

    /* renamed from: c */
    private final PriorityBlockingQueue<zzaa<?>> f12410c;

    /* renamed from: d */
    private final PriorityBlockingQueue<zzaa<?>> f12411d;

    /* renamed from: e */
    private final zzk f12412e;

    /* renamed from: f */
    private final zzx f12413f;

    /* renamed from: g */
    private final zzak f12414g;

    /* renamed from: h */
    private final zzw[] f12415h;

    /* renamed from: i */
    private zzm f12416i;

    /* renamed from: j */
    private final List<zzag> f12417j;

    /* renamed from: k */
    private final List<zzah> f12418k;

    private zzae(zzk zzk, zzx zzx, int i, zzak zzak) {
        this.f12408a = new AtomicInteger();
        this.f12409b = new HashSet();
        this.f12410c = new PriorityBlockingQueue<>();
        this.f12411d = new PriorityBlockingQueue<>();
        this.f12417j = new ArrayList();
        this.f12418k = new ArrayList();
        this.f12412e = zzk;
        this.f12413f = zzx;
        this.f12415h = new zzw[4];
        this.f12414g = zzak;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo15226a(zzaa<?> zzaa, int i) {
        synchronized (this.f12418k) {
            for (zzah zzb : this.f12418k) {
                zzb.zzb(zzaa, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final <T> void mo15227b(zzaa<T> zzaa) {
        synchronized (this.f12409b) {
            this.f12409b.remove(zzaa);
        }
        synchronized (this.f12417j) {
            for (zzag zzg : this.f12417j) {
                zzg.zzg(zzaa);
            }
        }
        mo15226a(zzaa, 5);
    }

    public final void start() {
        zzm zzm = this.f12416i;
        if (zzm != null) {
            zzm.quit();
        }
        for (zzw zzw : this.f12415h) {
            if (zzw != null) {
                zzw.quit();
            }
        }
        zzm zzm2 = new zzm(this.f12410c, this.f12411d, this.f12412e, this.f12414g);
        this.f12416i = zzm2;
        zzm2.start();
        for (int i = 0; i < this.f12415h.length; i++) {
            zzw zzw2 = new zzw(this.f12411d, this.f12413f, this.f12412e, this.f12414g);
            this.f12415h[i] = zzw2;
            zzw2.start();
        }
    }

    public final <T> zzaa<T> zze(zzaa<T> zzaa) {
        zzaa.zza(this);
        synchronized (this.f12409b) {
            this.f12409b.add(zzaa);
        }
        zzaa.zze(this.f12408a.incrementAndGet());
        zzaa.zzc("add-to-queue");
        mo15226a(zzaa, 0);
        if (!zzaa.zzh()) {
            this.f12411d.add(zzaa);
            return zzaa;
        }
        this.f12410c.add(zzaa);
        return zzaa;
    }

    private zzae(zzk zzk, zzx zzx, int i) {
        this(zzk, zzx, 4, new zzt(new Handler(Looper.getMainLooper())));
    }

    public zzae(zzk zzk, zzx zzx) {
        this(zzk, zzx, 4);
    }
}
