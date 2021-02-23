package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgc implements zzdfi<zzdgd> {

    /* renamed from: a */
    private final zzayc f15573a;

    /* renamed from: b */
    private final Executor f15574b;

    /* renamed from: c */
    private final String f15575c;
    @Nullable

    /* renamed from: d */
    private final PackageInfo f15576d;

    public zzdgc(zzayc zzayc, Executor executor, String str, @Nullable PackageInfo packageInfo) {
        this.f15573a = zzayc;
        this.f15574b = executor;
        this.f15575c = str;
        this.f15576d = packageInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo17096a(Throwable th) {
        return zzdyr.zzag(new zzdgd(this.f15575c));
    }

    public final zzdyz<zzdgd> zzasm() {
        return zzdyr.zzb(zzdyr.zzb(this.f15573a.zza(this.f15575c, this.f15576d), C2563wu.f11735a, this.f15574b), Throwable.class, new C2526vu(this), this.f15574b);
    }
}
