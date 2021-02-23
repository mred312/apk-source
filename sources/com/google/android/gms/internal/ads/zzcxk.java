package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcxk extends zzxc {

    /* renamed from: a */
    private final Context f15028a;

    /* renamed from: b */
    private final zzbgm f15029b;
    @VisibleForTesting

    /* renamed from: c */
    private final zzdnp f15030c;
    @VisibleForTesting

    /* renamed from: d */
    private final zzccn f15031d = new zzccn();

    /* renamed from: e */
    private zzwt f15032e;

    public zzcxk(zzbgm zzbgm, Context context, String str) {
        zzdnp zzdnp = new zzdnp();
        this.f15030c = zzdnp;
        this.f15029b = zzbgm;
        zzdnp.zzgq(str);
        this.f15028a = context;
    }

    public final void zza(zzafj zzafj) {
        this.f15031d.zzb(zzafj);
    }

    public final void zzb(zzwt zzwt) {
        this.f15032e = zzwt;
    }

    public final zzwy zzqj() {
        zzccl zzany = this.f15031d.zzany();
        this.f15030c.zzc(zzany.zzanw());
        this.f15030c.zzd(zzany.zzanx());
        zzdnp zzdnp = this.f15030c;
        if (zzdnp.zzkf() == null) {
            zzdnp.zzf(zzvn.zzpo());
        }
        return new zzcxj(this.f15028a, this.f15029b, this.f15030c, zzany, this.f15032e);
    }

    public final void zza(zzafy zzafy) {
        this.f15031d.zzb(zzafy);
    }

    public final void zzb(zzxu zzxu) {
        this.f15030c.zzc(zzxu);
    }

    public final void zza(zzafk zzafk) {
        this.f15031d.zzb(zzafk);
    }

    public final void zza(String str, zzafq zzafq, zzafp zzafp) {
        this.f15031d.zzb(str, zzafq, zzafp);
    }

    public final void zza(zzadz zzadz) {
        this.f15030c.zzb(zzadz);
    }

    public final void zza(zzajl zzajl) {
        this.f15030c.zzb(zzajl);
    }

    public final void zza(zzajt zzajt) {
        this.f15031d.zzb(zzajt);
    }

    public final void zza(zzafx zzafx, zzvn zzvn) {
        this.f15031d.zza(zzafx);
        this.f15030c.zzf(zzvn);
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.f15030c.zzb(publisherAdViewOptions);
    }
}
