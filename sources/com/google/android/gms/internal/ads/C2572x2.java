package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* renamed from: com.google.android.gms.internal.ads.x2 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class C2572x2 implements Runnable {

    /* renamed from: a */
    private final Context f11747a;

    /* renamed from: b */
    private final String f11748b;

    C2572x2(zzand zzand, Context context, String str) {
        this.f11747a = context;
        this.f11748b = str;
    }

    public final void run() {
        Context context = this.f11747a;
        String str = this.f11748b;
        zzabf.initialize(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzwq.zzqe().zzd(zzabf.zzcns)).booleanValue());
        try {
            ((zzbgh) zzazd.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", C2610y2.f11972a)).zza(ObjectWrapper.wrap(context), new zzana(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzazf | NullPointerException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
