package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbrq implements zzepf<zzawq> {

    /* renamed from: a */
    private final zzeps<Context> f13747a;

    /* renamed from: b */
    private final zzeps<zzazh> f13748b;

    /* renamed from: c */
    private final zzeps<zzdmu> f13749c;

    /* renamed from: d */
    private final zzeps<zzaws> f13750d;

    private zzbrq(zzbrr zzbrr, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzaws> zzeps4) {
        this.f13747a = zzeps;
        this.f13748b = zzeps2;
        this.f13749c = zzeps3;
        this.f13750d = zzeps4;
    }

    public static zzbrq zza(zzbrr zzbrr, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzaws> zzeps4) {
        return new zzbrq(zzbrr, zzeps, zzeps2, zzeps3, zzeps4);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        Context context = this.f13747a.get();
        zzazh zzazh = this.f13748b.get();
        zzdmu zzdmu = this.f13749c.get();
        zzaws zzaws = this.f13750d.get();
        if (zzdmu.zzhhb != null) {
            return new zzawh(context, zzazh, zzdmu.zzhhb, zzdmu.zzhgx.zzdrn, zzaws);
        }
        return null;
    }
}
