package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbre;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdkd<RequestComponentT extends zzbre<AdT>, AdT> implements zzdkl<RequestComponentT, AdT> {
    @GuardedBy("this")
    @Nullable

    /* renamed from: a */
    private RequestComponentT f15715a;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized RequestComponentT zzaty() {
        return this.f15715a;
    }

    public final synchronized zzdyz<AdT> zza(zzdkm zzdkm, zzdkn<RequestComponentT> zzdkn) {
        RequestComponentT requestcomponentt;
        requestcomponentt = (zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp();
        this.f15715a = requestcomponentt;
        return requestcomponentt.zzagh().zzakj();
    }
}
