package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzayq implements zzrl {

    /* renamed from: a */
    private final Object f12958a = new Object();

    /* renamed from: b */
    private final zzf f12959b;

    /* renamed from: c */
    private final zzayp f12960c;
    @VisibleForTesting

    /* renamed from: d */
    private final zzayn f12961d;
    @VisibleForTesting

    /* renamed from: e */
    private final HashSet<zzayf> f12962e = new HashSet<>();
    @VisibleForTesting

    /* renamed from: f */
    private final HashSet<zzayo> f12963f = new HashSet<>();

    /* renamed from: g */
    private boolean f12964g = false;

    public zzayq(String str, zzf zzf) {
        this.f12961d = new zzayn(str, zzf);
        this.f12959b = zzf;
        this.f12960c = new zzayp();
    }

    public final Bundle zza(Context context, zzaym zzaym) {
        HashSet hashSet = new HashSet();
        synchronized (this.f12958a) {
            hashSet.addAll(this.f12962e);
            this.f12962e.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.f12961d.zzn(context, this.f12960c.zzxk()));
        Bundle bundle2 = new Bundle();
        Iterator<zzayo> it = this.f12963f.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzayf) it2.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzaym.zza(hashSet);
            return bundle;
        }
        zzayo next = it.next();
        throw new NoSuchMethodError();
    }

    public final void zzb(zzayf zzayf) {
        synchronized (this.f12958a) {
            this.f12962e.add(zzayf);
        }
    }

    public final void zzp(boolean z) {
        long currentTimeMillis = zzp.zzkx().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.f12959b.zzxw() > ((Long) zzwq.zzqe().zzd(zzabf.zzcop)).longValue()) {
                this.f12961d.f12949d = -1;
            } else {
                this.f12961d.f12949d = this.f12959b.zzxx();
            }
            this.f12964g = true;
            return;
        }
        this.f12959b.zzez(currentTimeMillis);
        this.f12959b.zzdf(this.f12961d.f12949d);
    }

    public final void zzwp() {
        synchronized (this.f12958a) {
            this.f12961d.zzwp();
        }
    }

    public final void zzwq() {
        synchronized (this.f12958a) {
            this.f12961d.zzwq();
        }
    }

    public final boolean zzxm() {
        return this.f12964g;
    }

    public final void zzb(HashSet<zzayf> hashSet) {
        synchronized (this.f12958a) {
            this.f12962e.addAll(hashSet);
        }
    }

    public final void zza(zzvk zzvk, long j) {
        synchronized (this.f12958a) {
            this.f12961d.zza(zzvk, j);
        }
    }

    public final zzayf zza(Clock clock, String str) {
        return new zzayf(clock, this, this.f12960c.zzxj(), str);
    }
}
