package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdds implements zzdfi<zzddt> {

    /* renamed from: a */
    private final zzdzc f15462a;

    /* renamed from: b */
    private final Context f15463b;

    /* renamed from: c */
    private final Set<String> f15464c;

    public zzdds(zzdzc zzdzc, Context context, Set<String> set) {
        this.f15462a = zzdzc;
        this.f15463b = context;
        this.f15464c = set;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzddt mo17085a() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue() || !zzddt.m8352a(this.f15464c)) {
            return new zzddt((String) null);
        }
        return new zzddt(zzp.zzlf().getVersion(this.f15463b));
    }

    public final zzdyz<zzddt> zzasm() {
        return this.f15462a.zze(new C2562wt(this));
    }
}
