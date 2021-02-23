package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxv implements zzepf<zzbxu> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbxr>>> f13842a;

    private zzbxv(zzeps<Set<zzbxy<zzbxr>>> zzeps) {
        this.f13842a = zzeps;
    }

    public static zzbxv zzt(zzeps<Set<zzbxy<zzbxr>>> zzeps) {
        return new zzbxv(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbxu(this.f13842a.get());
    }
}
