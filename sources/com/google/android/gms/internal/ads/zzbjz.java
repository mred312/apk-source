package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbjz {

    /* renamed from: a */
    private final String f13379a;

    /* renamed from: b */
    private final zzamq f13380b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Executor f13381c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzbki f13382d;

    /* renamed from: e */
    private final zzahv<Object> f13383e = new C2433tb(this);

    /* renamed from: f */
    private final zzahv<Object> f13384f = new C2507vb(this);

    public zzbjz(String str, zzamq zzamq, Executor executor) {
        this.f13379a = str;
        this.f13380b = zzamq;
        this.f13381c = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final boolean m7817d(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(this.f13379a)) {
            return false;
        }
        return true;
    }

    public final void zza(zzbki zzbki) {
        this.f13380b.zzc("/updateActiveView", this.f13383e);
        this.f13380b.zzc("/untrackActiveViewUnit", this.f13384f);
        this.f13382d = zzbki;
    }

    public final void zzaif() {
        this.f13380b.zzd("/updateActiveView", this.f13383e);
        this.f13380b.zzd("/untrackActiveViewUnit", this.f13384f);
    }

    public final void zzd(zzbdv zzbdv) {
        zzbdv.zza("/updateActiveView", (zzahv<? super zzbdv>) this.f13383e);
        zzbdv.zza("/untrackActiveViewUnit", (zzahv<? super zzbdv>) this.f13384f);
    }

    public final void zze(zzbdv zzbdv) {
        zzbdv.zzb("/updateActiveView", this.f13383e);
        zzbdv.zzb("/untrackActiveViewUnit", this.f13384f);
    }
}
