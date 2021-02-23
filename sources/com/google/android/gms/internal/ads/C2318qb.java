package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.ads.qb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2318qb implements zzdyo<String> {

    /* renamed from: a */
    private final /* synthetic */ String f10709a;

    /* renamed from: b */
    private final /* synthetic */ zzbjv f10710b;

    C2318qb(zzbjv zzbjv, String str) {
        this.f10710b = zzbjv;
        this.f10709a = str;
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        this.f10710b.f13368g.zzi(this.f10710b.f13367f.zza(this.f10710b.f13365d, this.f10710b.f13366e, false, this.f10709a, (String) obj, this.f10710b.f13366e.zzdlt));
    }

    public final void zzb(Throwable th) {
        this.f10710b.f13368g.zzi(this.f10710b.f13367f.zza(this.f10710b.f13365d, this.f10710b.f13366e, false, this.f10709a, (String) null, this.f10710b.f13366e.zzdlt));
    }
}
