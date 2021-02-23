package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcil {
    @GuardedBy("this")

    /* renamed from: a */
    private final Map<String, zzcim> f14437a = new HashMap();

    zzcil() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo16873a(String str, zzapo zzapo) {
        if (!this.f14437a.containsKey(str)) {
            try {
                this.f14437a.put(str, new zzcim(str, zzapo.zzul(), zzapo.zzum()));
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void mo16874b(String str, zzdoe zzdoe) {
        if (!this.f14437a.containsKey(str)) {
            try {
                this.f14437a.put(str, new zzcim(str, zzdoe.zzul(), zzdoe.zzum()));
            } catch (zzdnr unused) {
            }
        }
    }

    @Nullable
    public final synchronized zzcim zzgd(String str) {
        return this.f14437a.get(str);
    }
}
