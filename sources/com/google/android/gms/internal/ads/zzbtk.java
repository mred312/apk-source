package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbtk implements zzepf<zzbti> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<AdMetadataListener>>> f13762a;

    private zzbtk(zzeps<Set<zzbxy<AdMetadataListener>>> zzeps) {
        this.f13762a = zzeps;
    }

    public static zzbtk zzm(zzeps<Set<zzbxy<AdMetadataListener>>> zzeps) {
        return new zzbtk(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbti(this.f13762a.get());
    }
}
