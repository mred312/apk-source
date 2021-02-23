package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdby implements zzdfj<Bundle> {

    /* renamed from: a */
    private final String f15204a;

    public zzdby(@Nullable String str) {
        this.f15204a = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!TextUtils.isEmpty(this.f15204a)) {
            bundle.putString("fwd_cld", this.f15204a);
        }
    }
}
