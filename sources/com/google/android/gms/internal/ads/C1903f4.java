package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.f4 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1903f4 extends zzasd {

    /* renamed from: a */
    private final /* synthetic */ UpdateClickUrlCallback f8425a;

    C1903f4(zzash zzash, UpdateClickUrlCallback updateClickUrlCallback) {
        this.f8425a = updateClickUrlCallback;
    }

    public final void onError(String str) {
        this.f8425a.onFailure(str);
    }

    public final void onSuccess(List<Uri> list) {
        this.f8425a.onSuccess(list.get(0));
    }
}
