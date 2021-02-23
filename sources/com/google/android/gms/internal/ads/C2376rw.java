package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.ads.rw */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2376rw<R> implements zzdqb {

    /* renamed from: a */
    public final zzdkn<R> f10827a;

    /* renamed from: b */
    public final zzdkm f10828b;

    /* renamed from: c */
    public final zzvk f10829c;

    /* renamed from: d */
    public final String f10830d;

    /* renamed from: e */
    public final Executor f10831e;

    /* renamed from: f */
    public final zzvw f10832f;
    @Nullable

    /* renamed from: g */
    private final zzdpq f10833g;

    public C2376rw(zzdkn<R> zzdkn, zzdkm zzdkm, zzvk zzvk, String str, Executor executor, zzvw zzvw, @Nullable zzdpq zzdpq) {
        this.f10827a = zzdkn;
        this.f10828b = zzdkm;
        this.f10829c = zzvk;
        this.f10830d = str;
        this.f10831e = executor;
        this.f10832f = zzvw;
        this.f10833g = zzdpq;
    }

    public final Executor getExecutor() {
        return this.f10831e;
    }

    @Nullable
    public final zzdpq zzaua() {
        return this.f10833g;
    }

    public final zzdqb zzaub() {
        return new C2376rw(this.f10827a, this.f10828b, this.f10829c, this.f10830d, this.f10831e, this.f10832f, this.f10833g);
    }
}
