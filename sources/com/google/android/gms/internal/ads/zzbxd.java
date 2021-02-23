package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxd implements zzepf<Set<zzbxy<AppEventListener>>> {

    /* renamed from: a */
    private final zzbwp f13834a;

    private zzbxd(zzbwp zzbwp) {
        this.f13834a = zzbwp;
    }

    public static zzbxd zzv(zzbwp zzbwp) {
        return new zzbxd(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13834a.zzalm(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
