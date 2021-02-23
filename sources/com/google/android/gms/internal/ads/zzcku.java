package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcku implements zzdru {

    /* renamed from: a */
    private final Map<zzdrl, Long> f14514a = new HashMap();

    /* renamed from: b */
    private final zzcko f14515b;

    /* renamed from: c */
    private final Clock f14516c;

    /* renamed from: d */
    private final Map<zzdrl, C2591xk> f14517d = new HashMap();

    public zzcku(zzcko zzcko, Set<C2591xk> set, Clock clock) {
        this.f14515b = zzcko;
        for (C2591xk next : set) {
            this.f14517d.put(next.f11946c, next);
        }
        this.f14516c = clock;
    }

    /* renamed from: a */
    private final void m8183a(zzdrl zzdrl, boolean z) {
        zzdrl b = this.f14517d.get(zzdrl).f11945b;
        String str = z ? "s." : "f.";
        if (this.f14514a.containsKey(b)) {
            long elapsedRealtime = this.f14516c.elapsedRealtime() - this.f14514a.get(b).longValue();
            Map<String, String> zzrx = this.f14515b.zzrx();
            String valueOf = String.valueOf(this.f14517d.get(zzdrl).f11944a);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrx.put(concat, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public final void zza(zzdrl zzdrl, String str) {
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        if (this.f14514a.containsKey(zzdrl)) {
            long elapsedRealtime = this.f14516c.elapsedRealtime() - this.f14514a.get(zzdrl).longValue();
            Map<String, String> zzrx = this.f14515b.zzrx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrx.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.f14517d.containsKey(zzdrl)) {
            m8183a(zzdrl, false);
        }
    }

    public final void zzb(zzdrl zzdrl, String str) {
        this.f14514a.put(zzdrl, Long.valueOf(this.f14516c.elapsedRealtime()));
    }

    public final void zzc(zzdrl zzdrl, String str) {
        if (this.f14514a.containsKey(zzdrl)) {
            long elapsedRealtime = this.f14516c.elapsedRealtime() - this.f14514a.get(zzdrl).longValue();
            Map<String, String> zzrx = this.f14515b.zzrx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrx.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.f14517d.containsKey(zzdrl)) {
            m8183a(zzdrl, true);
        }
    }
}
