package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbti extends zzbwk<AdMetadataListener> implements zzagy {

    /* renamed from: b */
    private Bundle f13761b = new Bundle();

    public zzbti(Set<zzbxy<AdMetadataListener>> set) {
        super(set);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.f13761b);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.f13761b.putAll(bundle);
        zza(C2584xd.f11885a);
    }
}
