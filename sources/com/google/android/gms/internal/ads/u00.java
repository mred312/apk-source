package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.nio.ByteBuffer;
import java.util.UUID;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class u00 implements w00 {

    /* renamed from: a */
    private static final zzcf.zza f11237a = zzcf.zza.zzar();

    u00() {
    }

    /* renamed from: a */
    public final zzcf.zza mo14852a(Context context) {
        zzcf.zza.C3977zza zzaq = zzcf.zza.zzaq();
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        advertisingIdClient.start();
        AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
        String id = info.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zzaq.zzab(id);
            zzaq.zza(info.isLimitAdTrackingEnabled());
            zzaq.zza(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
        }
        return (zzcf.zza) ((zzekh) zzaq.zzbhv());
    }

    /* renamed from: b */
    public final zzcf.zza mo14853b() {
        return f11237a;
    }
}
