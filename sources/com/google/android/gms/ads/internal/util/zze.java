package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzaza;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zze extends zza {
    private Context context;

    zze(Context context2) {
        this.context = context2;
    }

    public final void zzvm() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.context);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzaza.zzc("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzayu.zzaq(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzaza.zzfa(sb.toString());
    }
}
