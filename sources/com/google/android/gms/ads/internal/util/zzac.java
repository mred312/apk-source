package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzuo;

@TargetApi(26)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzac extends zzz {
    public final zzuo zza(Context context, TelephonyManager telephonyManager) {
        zzp.zzkq();
        if (zzm.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzuo.ENUM_TRUE : zzuo.ENUM_FALSE;
        }
        return zzuo.ENUM_FALSE;
    }
}
