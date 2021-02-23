package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.ol */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2254ol implements Callable {

    /* renamed from: a */
    private final zzef f10389a;

    /* renamed from: b */
    private final Context f10390b;

    C2254ol(zzef zzef, Context context) {
        this.f10389a = zzef;
        this.f10390b = context;
    }

    public final Object call() {
        zzef zzef = this.f10389a;
        return zzef.zzca().zzb(this.f10390b);
    }
}
