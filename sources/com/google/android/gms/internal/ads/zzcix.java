package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcix implements zzepf<zzts> {

    /* renamed from: a */
    private final zzeps<Context> f14446a;

    /* renamed from: b */
    private final zzeps<String> f14447b;

    /* renamed from: c */
    private final zzeps<zzazh> f14448c;

    /* renamed from: d */
    private final zzeps<zzue.zza.C3992zza> f14449d;

    /* renamed from: e */
    private final zzeps<String> f14450e;

    private zzcix(zzeps<Context> zzeps, zzeps<String> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzue.zza.C3992zza> zzeps4, zzeps<String> zzeps5) {
        this.f14446a = zzeps;
        this.f14447b = zzeps2;
        this.f14448c = zzeps3;
        this.f14449d = zzeps4;
        this.f14450e = zzeps5;
    }

    public static zzcix zze(zzeps<Context> zzeps, zzeps<String> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzue.zza.C3992zza> zzeps4, zzeps<String> zzeps5) {
        return new zzcix(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        String str = this.f14447b.get();
        zzazh zzazh = this.f14448c.get();
        zzue.zza.C3992zza zza = this.f14449d.get();
        String str2 = this.f14450e.get();
        zzts zzts = new zzts(new zztx(this.f14446a.get()));
        zzts.zza((zztv) new C2067jk(zza, str, (zzue.zzu) ((zzekh) zzue.zzu.zzox().zzcq(zzazh.zzegl).zzcr(zzazh.zzegm).zzcs(zzazh.zzegn ? 0 : 2).zzbhv()), str2));
        return (zzts) zzepl.zza(zzts, "Cannot return null from a non-@Nullable @Provides method");
    }
}
