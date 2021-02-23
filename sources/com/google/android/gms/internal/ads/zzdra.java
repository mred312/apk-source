package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzdra<E> {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final zzdyz<?> f15881d = zzdyr.zzag(null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzdzc f15882a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ScheduledExecutorService f15883b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zzdrm<E> f15884c;

    public zzdra(zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, zzdrm<E> zzdrm) {
        this.f15882a = zzdzc;
        this.f15883b = scheduledExecutorService;
        this.f15884c = zzdrm;
    }

    public final <I> zzdrg<I> zza(E e, zzdyz<I> zzdyz) {
        return new zzdrg(this, e, (String) null, zzdyz, Collections.singletonList(zzdyz), zzdyz, (C2494uz) null);
    }

    public final zzdre zzu(E e) {
        return new zzdre(this, e);
    }

    /* access modifiers changed from: protected */
    public abstract String zzv(E e);

    public final zzdrc zza(E e, zzdyz<?>... zzdyzArr) {
        return new zzdrc(this, e, Arrays.asList(zzdyzArr));
    }
}
