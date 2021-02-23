package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzayf {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Clock f12914a;

    /* renamed from: b */
    private final zzayq f12915b;
    @GuardedBy("lock")

    /* renamed from: c */
    private final LinkedList<C2238o5> f12916c;

    /* renamed from: d */
    private final Object f12917d = new Object();

    /* renamed from: e */
    private final String f12918e;

    /* renamed from: f */
    private final String f12919f;
    @GuardedBy("lock")

    /* renamed from: g */
    private long f12920g = -1;
    @GuardedBy("lock")

    /* renamed from: h */
    private long f12921h = -1;
    @GuardedBy("lock")

    /* renamed from: i */
    private long f12922i = -1;
    @GuardedBy("lock")

    /* renamed from: j */
    private long f12923j = 0;
    @GuardedBy("lock")

    /* renamed from: k */
    private long f12924k = -1;
    @GuardedBy("lock")

    /* renamed from: l */
    private long f12925l = -1;

    zzayf(Clock clock, zzayq zzayq, String str, String str2) {
        this.f12914a = clock;
        this.f12915b = zzayq;
        this.f12918e = str;
        this.f12919f = str2;
        this.f12916c = new LinkedList<>();
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.f12917d) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f12918e);
            bundle.putString("slotid", this.f12919f);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.f12924k);
            bundle.putLong("tresponse", this.f12925l);
            bundle.putLong("timp", this.f12921h);
            bundle.putLong("tload", this.f12922i);
            bundle.putLong("pcc", this.f12923j);
            bundle.putLong("tfetch", this.f12920g);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f12916c.iterator();
            while (it.hasNext()) {
                arrayList.add(((C2238o5) it.next()).mo14519a());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzan(boolean z) {
        synchronized (this.f12917d) {
            if (this.f12925l != -1) {
                this.f12922i = this.f12914a.elapsedRealtime();
            }
        }
    }

    public final void zze(zzvk zzvk) {
        synchronized (this.f12917d) {
            long elapsedRealtime = this.f12914a.elapsedRealtime();
            this.f12924k = elapsedRealtime;
            this.f12915b.zza(zzvk, elapsedRealtime);
        }
    }

    public final void zzey(long j) {
        synchronized (this.f12917d) {
            this.f12925l = j;
            if (j != -1) {
                this.f12915b.zzb(this);
            }
        }
    }

    public final void zzwp() {
        synchronized (this.f12917d) {
            if (this.f12925l != -1 && this.f12921h == -1) {
                this.f12921h = this.f12914a.elapsedRealtime();
                this.f12915b.zzb(this);
            }
            this.f12915b.zzwp();
        }
    }

    public final void zzwq() {
        synchronized (this.f12917d) {
            if (this.f12925l != -1) {
                C2238o5 o5Var = new C2238o5(this);
                o5Var.mo14522d();
                this.f12916c.add(o5Var);
                this.f12923j++;
                this.f12915b.zzwq();
                this.f12915b.zzb(this);
            }
        }
    }

    public final void zzwr() {
        synchronized (this.f12917d) {
            if (this.f12925l != -1 && !this.f12916c.isEmpty()) {
                C2238o5 last = this.f12916c.getLast();
                if (last.mo14520b() == -1) {
                    last.mo14521c();
                    this.f12915b.zzb(this);
                }
            }
        }
    }

    public final String zzws() {
        return this.f12918e;
    }
}
