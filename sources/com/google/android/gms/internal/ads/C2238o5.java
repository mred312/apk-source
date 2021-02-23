package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.o5 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2238o5 {

    /* renamed from: a */
    private long f10253a = -1;

    /* renamed from: b */
    private long f10254b = -1;

    /* renamed from: c */
    private final /* synthetic */ zzayf f10255c;

    public C2238o5(zzayf zzayf) {
        this.f10255c = zzayf;
    }

    /* renamed from: a */
    public final Bundle mo14519a() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.f10253a);
        bundle.putLong("tclose", this.f10254b);
        return bundle;
    }

    /* renamed from: b */
    public final long mo14520b() {
        return this.f10254b;
    }

    /* renamed from: c */
    public final void mo14521c() {
        this.f10254b = this.f10255c.f12914a.elapsedRealtime();
    }

    /* renamed from: d */
    public final void mo14522d() {
        this.f10253a = this.f10255c.f12914a.elapsedRealtime();
    }
}
