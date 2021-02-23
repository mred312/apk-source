package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.g5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2996g5 implements C3143w7 {

    /* renamed from: a */
    private final /* synthetic */ zzgy f18082a;

    C2996g5(zzgy zzgy) {
        this.f18082a = zzgy;
    }

    public final void zza(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f18082a.zza("auto", "_err", bundle, str);
        } else {
            this.f18082a.zza("auto", "_err", bundle);
        }
    }
}
