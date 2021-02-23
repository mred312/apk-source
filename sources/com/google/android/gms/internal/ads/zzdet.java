package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdet implements zzdfi<zzdeq> {

    /* renamed from: a */
    private final zzawx f15508a;

    /* renamed from: b */
    private final zzdzc f15509b;

    /* renamed from: c */
    private final Context f15510c;

    public zzdet(zzawx zzawx, zzdzc zzdzc, Context context) {
        this.f15508a = zzawx;
        this.f15509b = zzdzc;
        this.f15510c = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdeq mo17090a() {
        String str;
        String str2;
        String str3;
        if (!this.f15508a.zzz(this.f15510c)) {
            return new zzdeq((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzac = this.f15508a.zzac(this.f15510c);
        String str4 = zzac == null ? "" : zzac;
        String zzad = this.f15508a.zzad(this.f15510c);
        if (zzad == null) {
            str = "";
        } else {
            str = zzad;
        }
        String zzae = this.f15508a.zzae(this.f15510c);
        if (zzae == null) {
            str2 = "";
        } else {
            str2 = zzae;
        }
        String zzaf = this.f15508a.zzaf(this.f15510c);
        if (zzaf == null) {
            str3 = "";
        } else {
            str3 = zzaf;
        }
        return new zzdeq(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzwq.zzqe().zzd(zzabf.zzcnq) : null);
    }

    public final zzdyz<zzdeq> zzasm() {
        return this.f15509b.zze(new C1929fu(this));
    }
}
