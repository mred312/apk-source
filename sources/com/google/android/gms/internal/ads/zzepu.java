package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepu extends CustomTabsServiceConnection {

    /* renamed from: a */
    private WeakReference<zzept> f16370a;

    public zzepu(zzept zzept) {
        this.f16370a = new WeakReference<>(zzept);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzept zzept = (zzept) this.f16370a.get();
        if (zzept != null) {
            zzept.zza(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzept zzept = (zzept) this.f16370a.get();
        if (zzept != null) {
            zzept.zzsf();
        }
    }
}
