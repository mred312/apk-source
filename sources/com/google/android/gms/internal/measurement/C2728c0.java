package com.google.android.gms.internal.measurement;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzgw;

/* renamed from: com.google.android.gms.internal.measurement.c0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2728c0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ zzgw f17242e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17243f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2728c0(zzag zzag, zzgw zzgw) {
        super(zzag);
        this.f17243f = zzag;
        this.f17242e = zzgw;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.f17243f.f17562d.size()) {
                pair = null;
                break;
            } else if (this.f17242e.equals(((Pair) this.f17243f.f17562d.get(i)).first)) {
                pair = (Pair) this.f17243f.f17562d.get(i);
                break;
            } else {
                i++;
            }
        }
        if (pair == null) {
            Log.w(this.f17243f.f17559a, "OnEventListener had not been registered.");
            return;
        }
        this.f17243f.f17566h.unregisterOnMeasurementEventListener((zzab) pair.second);
        this.f17243f.f17562d.remove(pair);
    }
}
