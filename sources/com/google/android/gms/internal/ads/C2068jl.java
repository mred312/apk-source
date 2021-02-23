package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.jl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2068jl extends zzaja {

    /* renamed from: a */
    private final /* synthetic */ Object f9528a;

    /* renamed from: b */
    private final /* synthetic */ String f9529b;

    /* renamed from: c */
    private final /* synthetic */ long f9530c;

    /* renamed from: d */
    private final /* synthetic */ zzazq f9531d;

    /* renamed from: e */
    private final /* synthetic */ zzclp f9532e;

    C2068jl(zzclp zzclp, Object obj, String str, long j, zzazq zzazq) {
        this.f9532e = zzclp;
        this.f9528a = obj;
        this.f9529b = str;
        this.f9530c = j;
        this.f9531d = zzazq;
    }

    public final void onInitializationFailed(String str) {
        synchronized (this.f9528a) {
            this.f9532e.m8190g(this.f9529b, false, str, (int) (zzp.zzkx().elapsedRealtime() - this.f9530c));
            this.f9532e.f14570k.zzs(this.f9529b, "error");
            this.f9531d.set(Boolean.FALSE);
        }
    }

    public final void onInitializationSucceeded() {
        synchronized (this.f9528a) {
            this.f9532e.m8190g(this.f9529b, true, "", (int) (zzp.zzkx().elapsedRealtime() - this.f9530c));
            this.f9532e.f14570k.zzgg(this.f9529b);
            this.f9531d.set(Boolean.TRUE);
        }
    }
}
