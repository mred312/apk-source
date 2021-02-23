package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.n5 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2200n5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f10036a;

    /* renamed from: b */
    private final /* synthetic */ zzazq f10037b;

    C2200n5(zzaya zzaya, Context context, zzazq zzazq) {
        this.f10036a = context;
        this.f10037b = zzazq;
    }

    public final void run() {
        try {
            this.f10037b.set(AdvertisingIdClient.getAdvertisingIdInfo(this.f10036a));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.f10037b.setException(e);
            zzaza.zzc("Exception while getting advertising Id info", e);
        }
    }
}
