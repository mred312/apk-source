package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.h0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2772h0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Bundle f17332e;

    /* renamed from: f */
    private final /* synthetic */ Activity f17333f;

    /* renamed from: g */
    private final /* synthetic */ zzag.C2921c f17334g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2772h0(zzag.C2921c cVar, Bundle bundle, Activity activity) {
        super(zzag.this);
        this.f17334g = cVar;
        this.f17332e = bundle;
        this.f17333f = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        Bundle bundle;
        if (this.f17332e != null) {
            bundle = new Bundle();
            if (this.f17332e.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f17332e.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        zzag.this.f17566h.onActivityCreated(ObjectWrapper.wrap(this.f17333f), bundle, this.f17569b);
    }
}
