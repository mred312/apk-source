package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbvw implements zzepf<zzbvv> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbvz>>> f13790a;

    private zzbvw(zzeps<Set<zzbxy<zzbvz>>> zzeps) {
        this.f13790a = zzeps;
    }

    public static zzbvw zzq(zzeps<Set<zzbxy<zzbvz>>> zzeps) {
        return new zzbvw(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbvv(this.f13790a.get());
    }
}
