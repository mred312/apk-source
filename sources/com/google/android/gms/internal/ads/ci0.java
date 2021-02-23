package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ci0 implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zztf f8013a;

    /* renamed from: b */
    private final /* synthetic */ zzazq f8014b;

    /* renamed from: c */
    final /* synthetic */ zztl f8015c;

    ci0(zztl zztl, zztf zztf, zzazq zzazq) {
        this.f8015c = zztl;
        this.f8013a = zztf;
        this.f8014b = zzazq;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.f8015c.f17005d) {
            if (!this.f8015c.f17003b) {
                boolean unused = this.f8015c.f17003b = true;
                zztc f = this.f8015c.f17002a;
                if (f != null) {
                    zzdyz<?> zzg = zzazj.zzegp.zzg(new bi0(this, f, this.f8013a, this.f8014b));
                    zzazq zzazq = this.f8014b;
                    zzazq.addListener(new ei0(zzazq, zzg), zzazj.zzegu);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
