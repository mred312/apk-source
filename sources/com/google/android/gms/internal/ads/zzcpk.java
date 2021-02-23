package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpk implements zzepf<zzcou> {

    /* renamed from: a */
    private final zzeps<Context> f14667a;

    /* renamed from: b */
    private final zzeps<Executor> f14668b;

    /* renamed from: c */
    private final zzeps<zzaty> f14669c;

    /* renamed from: d */
    private final zzeps<zzbjl> f14670d;

    /* renamed from: e */
    private final zzeps<zzatz> f14671e;

    /* renamed from: f */
    private final zzeps<HashMap<String, zzcpf>> f14672f;

    private zzcpk(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzaty> zzeps3, zzeps<zzbjl> zzeps4, zzeps<zzatz> zzeps5, zzeps<HashMap<String, zzcpf>> zzeps6) {
        this.f14667a = zzeps;
        this.f14668b = zzeps2;
        this.f14669c = zzeps3;
        this.f14670d = zzeps4;
        this.f14671e = zzeps5;
        this.f14672f = zzeps6;
    }

    public static zzcpk zzb(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzaty> zzeps3, zzeps<zzbjl> zzeps4, zzeps<zzatz> zzeps5, zzeps<HashMap<String, zzcpf>> zzeps6) {
        return new zzcpk(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6);
    }

    public final /* synthetic */ Object get() {
        return new zzcou(this.f14667a.get(), this.f14668b.get(), this.f14669c.get(), this.f14670d.get(), this.f14671e.get(), this.f14672f.get());
    }
}
