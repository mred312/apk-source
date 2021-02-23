package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcok {

    /* renamed from: a */
    private final zzdzc f14653a;

    /* renamed from: b */
    private final zzcnx f14654b;

    /* renamed from: c */
    private final zzeoz<zzcou> f14655c;

    public zzcok(zzdzc zzdzc, zzcnx zzcnx, zzeoz<zzcou> zzeoz) {
        this.f14653a = zzdzc;
        this.f14654b = zzcnx;
        this.f14655c = zzeoz;
    }

    /* renamed from: a */
    private final <RetT> zzdyz<RetT> m8216a(zzatl zzatl, C2444tm<InputStream> tmVar, C2444tm<InputStream> tmVar2, zzdyb<InputStream, RetT> zzdyb) {
        zzdyz<V> zzdyz;
        String str = zzatl.packageName;
        zzp.zzkq();
        if (zzm.zzen(str)) {
            zzdyz = zzdyr.immediateFailedFuture(new zzcoh(zzdok.INTERNAL_ERROR));
        } else {
            zzdyz = zzdyr.zzb(tmVar.mo14621a(zzatl), ExecutionException.class, C2180mm.f9997a, this.f14653a);
        }
        return zzdyi.zzg(zzdyz).zzb(zzdyb, this.f14653a).zza(zzcoh.class, new C2255om(this, tmVar2, zzatl, zzdyb), (Executor) this.f14653a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo16939b(C2444tm tmVar, zzatl zzatl, zzdyb zzdyb, zzcoh zzcoh) {
        return zzdyr.zzb(tmVar.mo14621a(zzatl), zzdyb, (Executor) this.f14653a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ zzdyz mo16940c(zzatl zzatl) {
        return this.f14655c.get().zzgj(zzatl.zzdwb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ zzdyz mo16941d(zzatl zzatl) {
        return this.f14654b.zzgi(zzatl.zzdwb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ zzdyz mo16942e(zzatl zzatl) {
        return this.f14655c.get().zzc(zzatl, Binder.getCallingUid());
    }

    public final zzdyz<zzatl> zzl(zzatl zzatl) {
        C2217nm nmVar = new C2217nm(zzatl);
        zzcnx zzcnx = this.f14654b;
        zzcnx.getClass();
        return m8216a(zzatl, C2329qm.m6783b(zzcnx), new C2292pm(this), nmVar);
    }

    public final zzdyz<Void> zzm(zzatl zzatl) {
        if (zzff.zzar(zzatl.zzdwb)) {
            return zzdyr.immediateFailedFuture(new zzcme(zzdok.INVALID_REQUEST, "Pool key missing from removeUrl call."));
        }
        return m8216a(zzatl, new C2366rm(this), new C2481um(this), C2407sm.f11097a);
    }
}
