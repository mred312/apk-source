package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqg implements zzepf<zzbxy<zzp>> {

    /* renamed from: a */
    private final zzeps<zzbul> f13662a;

    /* renamed from: b */
    private final zzeps<Executor> f13663b;

    private zzbqg(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.f13662a = zzeps;
        this.f13663b = zzeps2;
    }

    public static zzbqg zzq(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqg(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13662a.get(), this.f13663b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
