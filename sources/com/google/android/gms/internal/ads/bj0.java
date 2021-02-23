package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class bj0 extends lj0<zzaqw> {

    /* renamed from: b */
    private final /* synthetic */ Context f7925b;

    /* renamed from: c */
    private final /* synthetic */ zzani f7926c;

    bj0(zzvx zzvx, Context context, zzani zzani) {
        this.f7925b = context;
        this.f7926c = zzani;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final zzaqw mo13607d() {
        try {
            return ((zzarb) zzazd.zza(this.f7925b, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", ej0.f8372a)).zzc(ObjectWrapper.wrap(this.f7925b), this.f7926c, 203404000);
        } catch (RemoteException | zzazf | NullPointerException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zzc(ObjectWrapper.wrap(this.f7925b), this.f7926c, 203404000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo13606c() {
        return null;
    }
}
