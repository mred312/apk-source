package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxx extends zzbwk<zzqu> implements zzqu {
    @GuardedBy("this")

    /* renamed from: b */
    private Map<View, zzqq> f13843b = new WeakHashMap(1);

    /* renamed from: c */
    private final Context f13844c;

    /* renamed from: d */
    private final zzdmu f13845d;

    public zzbxx(Context context, Set<zzbxy<zzqu>> set, zzdmu zzdmu) {
        super(set);
        this.f13844c = context;
        this.f13845d = zzdmu;
    }

    public final synchronized void zza(zzqv zzqv) {
        zza(new C1915fg(zzqv));
    }

    public final synchronized void zzv(View view) {
        zzqq zzqq = this.f13843b.get(view);
        if (zzqq == null) {
            zzqq = new zzqq(this.f13844c, view);
            zzqq.zza(this);
            this.f13843b.put(view, zzqq);
        }
        zzdmu zzdmu = this.f13845d;
        if (zzdmu != null && zzdmu.zzdvp) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcpw)).booleanValue()) {
                zzqq.zzen(((Long) zzwq.zzqe().zzd(zzabf.zzcpv)).longValue());
                return;
            }
        }
        zzqq.zzls();
    }

    public final synchronized void zzw(View view) {
        if (this.f13843b.containsKey(view)) {
            this.f13843b.get(view).zzb(this);
            this.f13843b.remove(view);
        }
    }
}
