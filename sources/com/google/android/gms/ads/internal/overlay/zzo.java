package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzva;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzo {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzdrr == 4 && adOverlayInfoParcel.zzdrm == null) {
            zzva zzva = adOverlayInfoParcel.zzcgp;
            if (zzva != null) {
                zzva.onAdClicked();
            }
            zzp.zzko();
            zza.zza(context, adOverlayInfoParcel.zzdrl, adOverlayInfoParcel.zzdrq);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzbpd.zzegn);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzp.zzkq();
        zzm.zza(context, intent);
    }
}
