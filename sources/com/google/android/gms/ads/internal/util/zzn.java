package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzacf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zzn implements zzace {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Uri val$uri;
    private final /* synthetic */ zzacf zzedh;

    zzn(zzm zzm, zzacf zzacf, Context context, Uri uri) {
        this.zzedh = zzacf;
        this.val$context = context;
        this.val$uri = uri;
    }

    public final void zzsc() {
        new CustomTabsIntent.Builder(this.zzedh.zzse()).build().launchUrl(this.val$context, this.val$uri);
        this.zzedh.zzc((Activity) this.val$context);
    }

    public final void zzsd() {
    }
}
