package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwu implements zzepf<Set<zzbxy<zzp>>> {

    /* renamed from: a */
    private final zzbwp f13825a;

    private zzbwu(zzbwp zzbwp) {
        this.f13825a = zzbwp;
    }

    public static zzbwu zzl(zzbwp zzbwp) {
        return new zzbwu(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13825a.zzalr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
