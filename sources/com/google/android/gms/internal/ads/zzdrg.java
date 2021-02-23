package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdrg<O> {

    /* renamed from: a */
    private final E f15890a;
    @Nullable

    /* renamed from: b */
    private final String f15891b;

    /* renamed from: c */
    private final zzdyz<?> f15892c;

    /* renamed from: d */
    private final List<zzdyz<?>> f15893d;

    /* renamed from: e */
    private final zzdyz<O> f15894e;

    /* renamed from: f */
    final /* synthetic */ zzdra f15895f;

    private zzdrg(zzdra zzdra, E e, String str, zzdyz<?> zzdyz, List<zzdyz<?>> list, zzdyz<O> zzdyz2) {
        this.f15895f = zzdra;
        this.f15890a = e;
        this.f15891b = str;
        this.f15892c = zzdyz;
        this.f15893d = list;
        this.f15894e = zzdyz2;
    }

    /* renamed from: a */
    private final <O2> zzdrg<O2> m8475a(zzdyb<O, O2> zzdyb, Executor executor) {
        return new zzdrg(this.f15895f, this.f15890a, this.f15891b, this.f15892c, this.f15893d, zzdyr.zzb(this.f15894e, zzdyb, executor));
    }

    public final <O2> zzdrg<O2> zza(zzdyb<O, O2> zzdyb) {
        return m8475a(zzdyb, this.f15895f.f15882a);
    }

    public final zzdqx<E, O> zzaww() {
        E e = this.f15890a;
        String str = this.f15891b;
        if (str == null) {
            str = this.f15895f.zzv(e);
        }
        zzdqx<E, O> zzdqx = new zzdqx<>(e, str, this.f15894e);
        this.f15895f.f15884c.zza(zzdqx);
        zzdyz<?> zzdyz = this.f15892c;
        c00 c00 = new c00(this, zzdqx);
        zzdzc zzdzc = zzazj.zzegu;
        zzdyz.addListener(c00, zzdzc);
        zzdyr.zza(zzdqx, new b00(this, zzdqx), zzdzc);
        return zzdqx;
    }

    public final <O2> zzdrg<O2> zzb(zzdqv<O, O2> zzdqv) {
        return zza(new C2644yz(zzdqv));
    }

    public final <O2> zzdrg<O2> zze(zzdyz<O2> zzdyz) {
        return m8475a(new a00(zzdyz), zzazj.zzegu);
    }

    public final zzdrg<O> zzgu(String str) {
        return new zzdrg(this.f15895f, this.f15890a, str, this.f15892c, this.f15893d, this.f15894e);
    }

    public final zzdrg<O> zzw(E e) {
        return this.f15895f.zza(e, zzaww());
    }

    public final <T extends Throwable> zzdrg<O> zza(Class<T> cls, zzdqv<T, O> zzdqv) {
        return zza(cls, new C2681zz(zzdqv));
    }

    public final <T extends Throwable> zzdrg<O> zza(Class<T> cls, zzdyb<T, O> zzdyb) {
        zzdra zzdra = this.f15895f;
        return new zzdrg(zzdra, this.f15890a, this.f15891b, this.f15892c, this.f15893d, zzdyr.zzb(this.f15894e, cls, zzdyb, zzdra.f15882a));
    }

    public final zzdrg<O> zza(long j, TimeUnit timeUnit) {
        zzdra zzdra = this.f15895f;
        return new zzdrg(zzdra, this.f15890a, this.f15891b, this.f15892c, this.f15893d, zzdyr.zza(this.f15894e, j, timeUnit, zzdra.f15883b));
    }

    /* synthetic */ zzdrg(zzdra zzdra, Object obj, String str, zzdyz zzdyz, List list, zzdyz zzdyz2, C2494uz uzVar) {
        this(zzdra, obj, (String) null, zzdyz, list, zzdyz2);
    }
}
