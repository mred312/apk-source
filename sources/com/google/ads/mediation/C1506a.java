package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* renamed from: com.google.ads.mediation.a */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1506a extends AdMetadataListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f6959a;

    C1506a(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f6959a = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.f6959a.zzmj != null && this.f6959a.zzmk != null) {
            this.f6959a.zzmk.zzb(this.f6959a.zzmj.getAdMetadata());
        }
    }
}
