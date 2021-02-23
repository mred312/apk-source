package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzboz<T> {

    /* renamed from: a */
    private final zzcne f13602a;

    /* renamed from: b */
    private final zzcno f13603b;

    /* renamed from: c */
    private final zzdnn f13604c;

    /* renamed from: d */
    private final zzdro f13605d;

    /* renamed from: e */
    private final zzbjo f13606e;

    /* renamed from: f */
    private final zzcup<T> f13607f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzbwd f13608g;
    @Nullable

    /* renamed from: h */
    private final zzdnj f13609h;

    /* renamed from: i */
    private final zzcok f13610i;

    /* renamed from: j */
    private final zzbqz f13611j;

    /* renamed from: k */
    private final Executor f13612k;

    /* renamed from: l */
    private final zzcod f13613l;

    /* renamed from: m */
    private final zzcrg f13614m;

    zzboz(zzcne zzcne, zzcno zzcno, zzdnn zzdnn, zzdro zzdro, zzbjo zzbjo, zzcup<T> zzcup, zzbwd zzbwd, @Nullable zzdnj zzdnj, zzcok zzcok, zzbqz zzbqz, Executor executor, zzcod zzcod, zzcrg zzcrg) {
        this.f13602a = zzcne;
        this.f13603b = zzcno;
        this.f13604c = zzdnn;
        this.f13605d = zzdro;
        this.f13606e = zzbjo;
        this.f13607f = zzcup;
        this.f13608g = zzbwd;
        this.f13609h = zzdnj;
        this.f13610i = zzcok;
        this.f13611j = zzbqz;
        this.f13612k = executor;
        this.f13613l = zzcod;
        this.f13614m = zzcrg;
    }

    /* renamed from: c */
    private final zzdyz<zzdnj> m7842c(zzdyz<zzatl> zzdyz) {
        if (this.f13609h != null) {
            return this.f13605d.zzu(zzdrl.SERVER_TRANSACTION).zze(zzdyr.zzag(this.f13609h)).zzaww();
        }
        zzp.zzkw().zzmu();
        if (this.f13604c.zzhio.zzchn != null) {
            return this.f13605d.zzu(zzdrl.SERVER_TRANSACTION).zze(this.f13603b.zzaqz()).zzaww();
        }
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyu)).booleanValue()) {
            return this.f13605d.zza(zzdrl.SERVER_TRANSACTION, zzdyz).zza(this.f13602a).zzaww();
        }
        zzdrg<I> zza = this.f13605d.zza(zzdrl.SERVER_TRANSACTION, zzdyz);
        zzcod zzcod = this.f13613l;
        zzcod.getClass();
        return zza.zza(C2508vc.m7090a(zzcod)).zzaww();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo16395b(zzdpk zzdpk, zzatl zzatl) {
        zzatl.zzdwa = zzdpk;
        return this.f13610i.zzl(zzatl);
    }

    public final zzdyz<zzdnj> zza(@NonNull zzatl zzatl) {
        return m7842c(zzdyr.zzag(zzatl));
    }

    public final zzdyz<zzdnj> zzaki() {
        return m7842c(this.f13611j.zzakr());
    }

    public final zzdyz<T> zzakj() {
        return zzb(zzaki());
    }

    public final zzbwd zzakk() {
        return this.f13608g;
    }

    public final zzdyz<T> zzb(zzdyz<zzdnj> zzdyz) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvi)).booleanValue()) {
            return this.f13605d.zza(zzdrl.RENDERER, zzdyz).zza(this.f13606e).zza(this.f13607f).zzaww();
        }
        return this.f13605d.zza(zzdrl.RENDERER, zzdyz).zza(this.f13606e).zza(this.f13607f).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS).zzaww();
    }

    public final zzdyz<Void> zzc(zzatl zzatl) {
        zzdqx<E, I> zzaww = this.f13605d.zza(zzdrl.NOTIFY_CACHE_HIT, this.f13610i.zzm(zzatl)).zzaww();
        zzdyr.zza(zzaww, new C2545wc(this), this.f13612k);
        return zzaww;
    }

    public final zzve zze(Throwable th) {
        return zzdoi.zza(th, this.f13614m);
    }

    public final zzdyz<zzatl> zza(zzdpk zzdpk) {
        zzdqx<E, O2> zzaww = this.f13605d.zza(zzdrl.GET_CACHE_KEY, this.f13611j.zzakr()).zza(new C2471uc(this, zzdpk)).zzaww();
        zzdyr.zza(zzaww, new C2583xc(this), this.f13612k);
        return zzaww;
    }

    public final zzdyz<T> zzb(@NonNull zzatl zzatl) {
        return zzb(zza(zzatl));
    }
}
