package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* renamed from: com.google.android.gms.internal.ads.d4 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1829d4 extends zzaxo {

    /* renamed from: a */
    private final /* synthetic */ QueryInfoGenerationCallback f8049a;

    C1829d4(zzasf zzasf, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.f8049a = queryInfoGenerationCallback;
    }

    public final void onError(String str) {
        this.f8049a.onFailure(str);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzn(str, bundle));
        zzwq.zzqi().put(queryInfo, str2);
        this.f8049a.onSuccess(queryInfo);
    }

    public final void zzk(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzn(str, (Bundle) null));
        zzwq.zzqi().put(queryInfo, str2);
        this.f8049a.onSuccess(queryInfo);
    }
}
