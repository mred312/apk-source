package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwa implements zzepf<zzbvy> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<AppEventListener>>> f13793a;

    private zzbwa(zzeps<Set<zzbxy<AppEventListener>>> zzeps) {
        this.f13793a = zzeps;
    }

    public static zzbwa zzr(zzeps<Set<zzbxy<AppEventListener>>> zzeps) {
        return new zzbwa(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbvy(this.f13793a.get());
    }
}
