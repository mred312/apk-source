package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclj implements zzepf<Set<zzbxy<AppEventListener>>> {

    /* renamed from: a */
    private final zzeps<zzcln> f14549a;

    /* renamed from: b */
    private final zzeps<Executor> f14550b;

    private zzclj(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14549a = zzeps;
        this.f14550b = zzeps2;
    }

    public static zzclj zze(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclj(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zzb(this.f14549a.get(), this.f14550b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
