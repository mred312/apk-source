package com.google.android.gms.ads.mediation.rtb;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public interface SignalCallbacks {
    void onFailure(@NonNull AdError adError);

    @Deprecated
    void onFailure(String str);

    void onSuccess(String str);
}
