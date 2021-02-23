package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbrv implements zzepf<zzbrt> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzva>>> f13751a;

    private zzbrv(zzeps<Set<zzbxy<zzva>>> zzeps) {
        this.f13751a = zzeps;
    }

    public static zzbrv zzg(zzeps<Set<zzbxy<zzva>>> zzeps) {
        return new zzbrv(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbrt(this.f13751a.get());
    }
}
