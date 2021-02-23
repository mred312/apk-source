package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbyt implements zzepf<zzbyn> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> f13857a;

    private zzbyt(zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> zzeps) {
        this.f13857a = zzeps;
    }

    public static zzbyt zzv(zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> zzeps) {
        return new zzbyt(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbyn(this.f13857a.get());
    }
}
