package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxz implements zzepf<zzbxx> {

    /* renamed from: a */
    private final zzeps<Context> f13846a;

    /* renamed from: b */
    private final zzeps<Set<zzbxy<zzqu>>> f13847b;

    /* renamed from: c */
    private final zzeps<zzdmu> f13848c;

    private zzbxz(zzeps<Context> zzeps, zzeps<Set<zzbxy<zzqu>>> zzeps2, zzeps<zzdmu> zzeps3) {
        this.f13846a = zzeps;
        this.f13847b = zzeps2;
        this.f13848c = zzeps3;
    }

    public static zzbxz zzk(zzeps<Context> zzeps, zzeps<Set<zzbxy<zzqu>>> zzeps2, zzeps<zzdmu> zzeps3) {
        return new zzbxz(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbxx(this.f13846a.get(), this.f13847b.get(), this.f13848c.get());
    }
}
