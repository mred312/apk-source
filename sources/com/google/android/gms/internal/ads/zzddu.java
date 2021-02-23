package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddu implements zzepf<zzdds> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15466a;

    /* renamed from: b */
    private final zzeps<Context> f15467b;

    /* renamed from: c */
    private final zzeps<Set<String>> f15468c;

    private zzddu(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<Set<String>> zzeps3) {
        this.f15466a = zzeps;
        this.f15467b = zzeps2;
        this.f15468c = zzeps3;
    }

    public static zzddu zzu(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<Set<String>> zzeps3) {
        return new zzddu(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdds(this.f15466a.get(), this.f15467b.get(), this.f15468c.get());
    }
}
