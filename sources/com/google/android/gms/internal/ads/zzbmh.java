package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbmh {

    /* renamed from: a */
    private final zzbnz f13488a;

    /* renamed from: b */
    private final View f13489b;

    /* renamed from: c */
    private final zzdmx f13490c;

    /* renamed from: d */
    private final zzbdv f13491d;

    public zzbmh(View view, @Nullable zzbdv zzbdv, zzbnz zzbnz, zzdmx zzdmx) {
        this.f13489b = view;
        this.f13491d = zzbdv;
        this.f13488a = zzbnz;
        this.f13490c = zzdmx;
    }

    public zzbte zza(Set<zzbxy<zzbtj>> set) {
        return new zzbte(set);
    }

    @Nullable
    public final zzbdv zzaim() {
        return this.f13491d;
    }

    public final View zzaiz() {
        return this.f13489b;
    }

    public final zzbnz zzajl() {
        return this.f13488a;
    }

    public final zzdmx zzajm() {
        return this.f13490c;
    }
}
