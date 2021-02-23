package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckp {

    /* renamed from: a */
    private final Map<String, String> f14507a = new ConcurrentHashMap();

    /* renamed from: b */
    private final /* synthetic */ zzckq f14508b;

    @VisibleForTesting
    zzckp(zzckq zzckq) {
        this.f14508b = zzckq;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final zzckp m8177a() {
        this.f14507a.putAll(this.f14508b.f14511c);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16892b() {
        this.f14508b.f14509a.zzo(this.f14507a);
    }

    public final zzckp zza(zzdmz zzdmz) {
        this.f14507a.put("gqi", zzdmz.zzbvf);
        return this;
    }

    public final void zzaqd() {
        this.f14508b.f14510b.execute(new C2553wk(this));
    }

    public final String zzaqe() {
        return this.f14508b.f14509a.zzp(this.f14507a);
    }

    public final zzckp zzc(zzdmu zzdmu) {
        this.f14507a.put("aai", zzdmu.zzdkx);
        return this;
    }

    public final zzckp zzr(String str, String str2) {
        this.f14507a.put(str, str2);
        return this;
    }
}
