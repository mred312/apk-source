package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbre;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdkc<RequestComponentT extends zzbre<AdT>, AdT> implements zzdkl<RequestComponentT, AdT> {

    /* renamed from: a */
    private final zzdkl<RequestComponentT, AdT> f15713a;
    @GuardedBy("this")
    @Nullable

    /* renamed from: b */
    private RequestComponentT f15714b;

    public zzdkc(zzdkl<RequestComponentT, AdT> zzdkl) {
        this.f15713a = zzdkl;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized RequestComponentT zzaty() {
        return this.f15714b;
    }

    public final synchronized zzdyz<AdT> zza(zzdkm zzdkm, zzdkn<RequestComponentT> zzdkn) {
        if (zzdkm.zzhfj != null) {
            RequestComponentT requestcomponentt = (zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp();
            this.f15714b = requestcomponentt;
            return requestcomponentt.zzagh().zzb(zzdkm.zzhfj);
        }
        zzdyz<AdT> zza = this.f15713a.zza(zzdkm, zzdkn);
        this.f15714b = (zzbre) this.f15713a.zzaty();
        return zza;
    }
}
