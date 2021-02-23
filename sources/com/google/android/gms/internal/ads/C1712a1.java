package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* renamed from: com.google.android.gms.internal.ads.a1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1712a1 implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzazq f7775a;

    /* renamed from: b */
    private final /* synthetic */ zzait f7776b;

    C1712a1(zzait zzait, zzazq zzazq) {
        this.f7776b = zzait;
        this.f7775a = zzazq;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.f7775a.set(this.f7776b.f12482a.zztk());
        } catch (DeadObjectException e) {
            this.f7775a.setException(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzazq zzazq = this.f7775a;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzazq.setException(new RuntimeException(sb.toString()));
    }
}
