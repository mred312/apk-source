package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class c40 extends q30<zzdyz<V>> {

    /* renamed from: d */
    private final zzdxz<V> f7964d;

    /* renamed from: e */
    private final /* synthetic */ d40 f7965e;

    c40(d40 d40, zzdxz<V> zzdxz) {
        this.f7965e = d40;
        this.f7964d = (zzdxz) zzdvv.checkNotNull(zzdxz);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo13732b() {
        return this.f7965e.isDone();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Object mo13733c() {
        return (zzdyz) zzdvv.zza(this.f7964d.zzata(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.f7964d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo13734d() {
        return this.f7964d.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo13735e(Object obj, Throwable th) {
        zzdyz zzdyz = (zzdyz) obj;
        if (th == null) {
            this.f7965e.setFuture(zzdyz);
        } else {
            this.f7965e.setException(th);
        }
    }
}
