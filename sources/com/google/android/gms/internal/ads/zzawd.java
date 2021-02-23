package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzawd extends zzavf {

    /* renamed from: a */
    private final String f12876a;

    /* renamed from: b */
    private final int f12877b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzawd(@Nullable zzava zzava) {
        this(zzava != null ? zzava.type : "", zzava != null ? zzava.zzdxu : 1);
    }

    public final int getAmount() {
        return this.f12877b;
    }

    public final String getType() {
        return this.f12876a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzawd(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzawd(String str, int i) {
        this.f12876a = str;
        this.f12877b = i;
    }
}
