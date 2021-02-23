package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcao implements zzepf<zzcal> {

    /* renamed from: a */
    private final zzeps<zzawu> f13918a;

    /* renamed from: b */
    private final zzeps<Context> f13919b;

    /* renamed from: c */
    private final zzeps<zzawx> f13920c;

    /* renamed from: d */
    private final zzeps<View> f13921d;

    /* renamed from: e */
    private final zzeps<zzue.zza.C3992zza> f13922e;

    private zzcao(zzeps<zzawu> zzeps, zzeps<Context> zzeps2, zzeps<zzawx> zzeps3, zzeps<View> zzeps4, zzeps<zzue.zza.C3992zza> zzeps5) {
        this.f13918a = zzeps;
        this.f13919b = zzeps2;
        this.f13920c = zzeps3;
        this.f13921d = zzeps4;
        this.f13922e = zzeps5;
    }

    public static zzcao zzd(zzeps<zzawu> zzeps, zzeps<Context> zzeps2, zzeps<zzawx> zzeps3, zzeps<View> zzeps4, zzeps<zzue.zza.C3992zza> zzeps5) {
        return new zzcao(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzcal(this.f13918a.get(), this.f13919b.get(), this.f13920c.get(), this.f13921d.get(), this.f13922e.get());
    }
}
