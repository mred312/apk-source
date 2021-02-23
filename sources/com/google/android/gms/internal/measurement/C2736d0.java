package com.google.android.gms.internal.measurement;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzgw;

/* renamed from: com.google.android.gms.internal.measurement.d0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2736d0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ zzgw f17252e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17253f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2736d0(zzag zzag, zzgw zzgw) {
        super(zzag);
        this.f17253f = zzag;
        this.f17252e = zzgw;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        for (int i = 0; i < this.f17253f.f17562d.size(); i++) {
            if (this.f17252e.equals(((Pair) this.f17253f.f17562d.get(i)).first)) {
                Log.w(this.f17253f.f17559a, "OnEventListener already registered.");
                return;
            }
        }
        zzag.C2922d dVar = new zzag.C2922d(this.f17252e);
        this.f17253f.f17562d.add(new Pair(this.f17252e, dVar));
        this.f17253f.f17566h.registerOnMeasurementEventListener(dVar);
    }
}
