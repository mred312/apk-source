package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmd {

    /* renamed from: a */
    private final zzdzc f14590a;

    /* renamed from: b */
    private final zzdzc f14591b;

    /* renamed from: c */
    private final zzcns f14592c;

    /* renamed from: d */
    private final zzeoz<zzcou> f14593d;

    public zzcmd(zzdzc zzdzc, zzdzc zzdzc2, zzcns zzcns, zzeoz<zzcou> zzeoz) {
        this.f14590a = zzdzc;
        this.f14591b = zzdzc2;
        this.f14592c = zzcns;
        this.f14593d = zzeoz;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16921a(zzatl zzatl, int i, zzcoh zzcoh) {
        return this.f14593d.get().zzb(zzatl, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ InputStream mo16922b(zzatl zzatl) {
        return this.f14592c.zzi(zzatl).get((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS);
    }

    public final zzdyz<InputStream> zze(zzatl zzatl) {
        zzdyz<V> zzdyz;
        String str = zzatl.packageName;
        zzp.zzkq();
        if (zzm.zzen(str)) {
            zzdyz = zzdyr.immediateFailedFuture(new zzcoh(zzdok.INTERNAL_ERROR));
        } else {
            zzdyz = zzdyr.zzb(this.f14590a.zze(new C2142ll(this, zzatl)), ExecutionException.class, C2105kl.f9769a, this.f14591b);
        }
        return zzdyr.zzb(zzdyz, zzcoh.class, new C2179ml(this, zzatl, Binder.getCallingUid()), this.f14591b);
    }
}
