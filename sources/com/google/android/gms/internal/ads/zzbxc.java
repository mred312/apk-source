package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxc implements zzepf<Set<zzbxy<AdMetadataListener>>> {

    /* renamed from: a */
    private final zzbwp f13833a;

    private zzbxc(zzbwp zzbwp) {
        this.f13833a = zzbwp;
    }

    public static zzbxc zzu(zzbwp zzbwp) {
        return new zzbxc(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13833a.zzall(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
