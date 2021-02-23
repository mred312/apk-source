package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzzd;
import com.google.android.gms.internal.ads.zzzl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    public static final class Settings {
        private final zzzl zzadj = new zzzl();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }
    }

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzzd.zzrb().disableMediationAdapterInitialization(context);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzzd.zzrb().getInitializationStatus();
    }

    @NonNull
    public static RequestConfiguration getRequestConfiguration() {
        return zzzd.zzrb().getRequestConfiguration();
    }

    @Deprecated
    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzzd.zzrb().getRewardedVideoAdInstance(context);
    }

    public static String getVersionString() {
        return zzzd.zzrb().getVersionString();
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    public static void openDebugMenu(Context context, String str) {
        zzzd.zzrb().openDebugMenu(context, str);
    }

    @KeepForSdk
    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzzd.zzrb().registerRtbAdapter(cls);
    }

    public static void setAppMuted(boolean z) {
        zzzd.zzrb().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzzd.zzrb().setAppVolume(f);
    }

    public static void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        zzzd.zzrb().setRequestConfiguration(requestConfiguration);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzzd.zzrb().zza(context, str, (OnInitializationCompleteListener) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context) {
        initialize(context, (String) null, (Settings) null);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzzd.zzrb().zza(context, (String) null, onInitializationCompleteListener);
    }
}
