package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddd implements zzepf<zzddb> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15443a;

    /* renamed from: b */
    private final zzeps<ViewGroup> f15444b;

    /* renamed from: c */
    private final zzeps<Context> f15445c;

    /* renamed from: d */
    private final zzeps<Set<String>> f15446d;

    private zzddd(zzeps<zzdzc> zzeps, zzeps<ViewGroup> zzeps2, zzeps<Context> zzeps3, zzeps<Set<String>> zzeps4) {
        this.f15443a = zzeps;
        this.f15444b = zzeps2;
        this.f15445c = zzeps3;
        this.f15446d = zzeps4;
    }

    public static zzddd zzi(zzeps<zzdzc> zzeps, zzeps<ViewGroup> zzeps2, zzeps<Context> zzeps3, zzeps<Set<String>> zzeps4) {
        return new zzddd(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzddb(this.f15443a.get(), this.f15444b.get(), this.f15445c.get(), this.f15446d.get());
    }
}
