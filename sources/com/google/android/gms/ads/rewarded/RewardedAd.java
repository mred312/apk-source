package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzavs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class RewardedAd {
    private final zzavs zzhpj;

    public RewardedAd(Context context, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.zzhpj = new zzavs(context, str);
    }

    public final Bundle getAdMetadata() {
        return this.zzhpj.getAdMetadata();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzhpj.getMediationAdapterClassName();
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        return this.zzhpj.getResponseInfo();
    }

    @Nullable
    public final RewardItem getRewardItem() {
        return this.zzhpj.getRewardItem();
    }

    public final boolean isLoaded() {
        return this.zzhpj.isLoaded();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzhpj.zza(adRequest.zzds(), rewardedAdLoadCallback);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzhpj.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzhpj.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.zzhpj.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzhpj.show(activity, rewardedAdCallback);
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzhpj.zza(publisherAdRequest.zzds(), rewardedAdLoadCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzhpj.show(activity, rewardedAdCallback, z);
    }
}
