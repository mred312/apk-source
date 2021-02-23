package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzasf;
import com.google.android.gms.internal.ads.zzza;
import com.google.android.gms.internal.ads.zzzn;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class QueryInfo {
    private final zzzn zzhpg;

    public QueryInfo(zzzn zzzn) {
        this.zzhpg = zzzn;
    }

    @KeepForSdk
    public static void generate(Context context, AdFormat adFormat, @Nullable AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzza zzza;
        if (adRequest == null) {
            zzza = null;
        } else {
            zzza = adRequest.zzds();
        }
        new zzasf(context, adFormat, zzza).zza(queryInfoGenerationCallback);
    }

    @KeepForSdk
    public String getQuery() {
        return this.zzhpg.getQuery();
    }

    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zzhpg.getQueryBundle();
    }

    @KeepForSdk
    public String getRequestId() {
        return zzzn.zza(this);
    }
}
