package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class zi0 extends lj0<zzaxq> {

    /* renamed from: b */
    private final /* synthetic */ Context f12306b;

    /* renamed from: c */
    private final /* synthetic */ zzani f12307c;

    zi0(zzvx zzvx, Context context, zzani zzani) {
        this.f12306b = context;
        this.f12307c = zzani;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final zzaxq mo13607d() {
        try {
            return ((zzaxv) zzazd.zza(this.f12306b, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", cj0.f8017a)).zze(ObjectWrapper.wrap(this.f12306b), this.f12307c, 203404000);
        } catch (RemoteException | zzazf | NullPointerException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zzb(ObjectWrapper.wrap(this.f12306b), this.f12307c, 203404000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo13606c() {
        return null;
    }
}
