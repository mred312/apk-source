package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbtx implements zzepf<zzbtr> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzp>>> f13766a;

    private zzbtx(zzeps<Set<zzbxy<zzp>>> zzeps) {
        this.f13766a = zzeps;
    }

    public static zzbtx zzo(zzeps<Set<zzbxy<zzp>>> zzeps) {
        return new zzbtx(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbtr(this.f13766a.get());
    }
}
