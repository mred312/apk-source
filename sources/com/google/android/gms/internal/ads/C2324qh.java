package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.facebook.FacebookAdapter;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.qh */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2324qh implements zzahv {

    /* renamed from: a */
    private final zzcdd f10718a;

    /* renamed from: b */
    private final zzage f10719b;

    C2324qh(zzcdd zzcdd, zzage zzage) {
        this.f10718a = zzcdd;
        this.f10719b = zzage;
    }

    public final void zza(Object obj, Map map) {
        zzcdd zzcdd = this.f10718a;
        zzage zzage = this.f10719b;
        try {
            zzcdd.f14129f = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzaza.zzey("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzcdd.f14128e = (String) map.get(FacebookAdapter.KEY_ID);
        String str = (String) map.get("asset_id");
        if (zzage == null) {
            zzaza.zzeb("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzage.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
