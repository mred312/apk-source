package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcek implements zzepf<zzbxy<VideoController.VideoLifecycleCallbacks>> {

    /* renamed from: a */
    private final zzeps<zzcgy> f14189a;

    /* renamed from: b */
    private final zzeps<Executor> f14190b;

    public zzcek(zzceb zzceb, zzeps<zzcgy> zzeps, zzeps<Executor> zzeps2) {
        this.f14189a = zzeps;
        this.f14190b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14189a.get(), this.f14190b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
