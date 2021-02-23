package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.e4 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1866e4 extends zzasd {

    /* renamed from: a */
    private final /* synthetic */ UpdateImpressionUrlsCallback f8313a;

    C1866e4(zzash zzash, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.f8313a = updateImpressionUrlsCallback;
    }

    public final void onError(String str) {
        this.f8313a.onFailure(str);
    }

    public final void onSuccess(List<Uri> list) {
        this.f8313a.onSuccess(list);
    }
}
