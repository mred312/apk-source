package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbrj implements zzepf<Context> {

    /* renamed from: a */
    private final zzbrg f13734a;

    /* renamed from: b */
    private final zzeps<Context> f13735b;

    private zzbrj(zzbrg zzbrg, zzeps<Context> zzeps) {
        this.f13734a = zzbrg;
        this.f13735b = zzeps;
    }

    public static zzbrj zza(zzbrg zzbrg, zzeps<Context> zzeps) {
        return new zzbrj(zzbrg, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzepl.zza(this.f13734a.mo16423f(this.f13735b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
