package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzacf implements zzept {
    @Nullable

    /* renamed from: a */
    private CustomTabsSession f12379a;
    @Nullable

    /* renamed from: b */
    private CustomTabsClient f12380b;
    @Nullable

    /* renamed from: c */
    private CustomTabsServiceConnection f12381c;
    @Nullable

    /* renamed from: d */
    private zzace f12382d;

    public static boolean zzj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzepr.zzcn(context));
                }
            }
        }
        return false;
    }

    public final void zza(zzace zzace) {
        this.f12382d = zzace;
    }

    public final void zzc(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.f12381c;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
            this.f12380b = null;
            this.f12379a = null;
            this.f12381c = null;
        }
    }

    public final void zzd(Activity activity) {
        String zzcn;
        if (this.f12380b == null && (zzcn = zzepr.zzcn(activity)) != null) {
            zzepu zzepu = new zzepu(this);
            this.f12381c = zzepu;
            CustomTabsClient.bindCustomTabsService(activity, zzcn, zzepu);
        }
    }

    @Nullable
    public final CustomTabsSession zzse() {
        CustomTabsClient customTabsClient = this.f12380b;
        if (customTabsClient == null) {
            this.f12379a = null;
        } else if (this.f12379a == null) {
            this.f12379a = customTabsClient.newSession((CustomTabsCallback) null);
        }
        return this.f12379a;
    }

    public final void zzsf() {
        this.f12380b = null;
        this.f12379a = null;
        zzace zzace = this.f12382d;
        if (zzace != null) {
            zzace.zzsd();
        }
    }

    public final void zza(CustomTabsClient customTabsClient) {
        this.f12380b = customTabsClient;
        customTabsClient.warmup(0);
        zzace zzace = this.f12382d;
        if (zzace != null) {
            zzace.zzsc();
        }
    }
}
