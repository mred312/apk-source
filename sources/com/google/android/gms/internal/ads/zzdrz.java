package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdrz {

    /* renamed from: a */
    private final Executor f15913a;

    /* renamed from: b */
    private final zzaze f15914b;

    public zzdrz(Executor executor, zzaze zzaze) {
        this.f15913a = executor;
        this.f15914b = zzaze;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo17255a(String str) {
        this.f15914b.zzeo(str);
    }

    public final void zzeo(String str) {
        this.f15913a.execute(new j00(this, str));
    }

    public final void zzj(List<String> list) {
        for (String zzeo : list) {
            zzeo(zzeo);
        }
    }
}
