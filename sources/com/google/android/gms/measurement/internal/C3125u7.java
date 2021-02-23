package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.u7 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3125u7 implements C3143w7 {

    /* renamed from: a */
    final /* synthetic */ zzki f18401a;

    C3125u7(zzki zzki) {
        this.f18401a = zzki;
    }

    public final void zza(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f18401a.f18701j.zzq().zze().zza("AppId not known when logging error event");
        } else {
            this.f18401a.zzp().zza((Runnable) new C3116t7(this, str, bundle));
        }
    }
}
