package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.ads.ax */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1747ax implements zzdvm<zzcoh, zzdkj> {

    /* renamed from: a */
    private final /* synthetic */ C2641yw f7855a;

    C1747ax(C2641yw ywVar) {
        this.f7855a = ywVar;
    }

    @NullableDecl
    public final /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzaza.zzc("", (zzcoh) obj);
        zzd.zzee("Failed to get a cache key, reverting to legacy flow.");
        C2641yw ywVar = this.f7855a;
        zzdkj unused = ywVar.f12238e = new zzdkj((zzatl) null, ywVar.m7383d(), (C1747ax) null);
        return this.f7855a.f12238e;
    }
}
