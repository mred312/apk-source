package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzaze;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbp extends zza {
    private final String url;
    private final zzaze zzeff;

    public zzbp(Context context, String str, String str2) {
        this(str2, zzp.zzkq().zzq(context, str));
    }

    public final void zzvm() {
        this.zzeff.zzeo(this.url);
    }

    private zzbp(String str, String str2) {
        this.zzeff = new zzaze(str2);
        this.url = str;
    }
}
