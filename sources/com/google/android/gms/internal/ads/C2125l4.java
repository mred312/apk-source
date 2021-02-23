package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.l4 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2125l4 implements Callable<zzatq> {

    /* renamed from: a */
    private final /* synthetic */ Context f9802a;

    /* renamed from: b */
    private final /* synthetic */ zzats f9803b;

    C2125l4(zzats zzats, Context context) {
        this.f9803b = zzats;
        this.f9802a = context;
    }

    public final /* synthetic */ Object call() {
        zzatq zzatq;
        C2088k4 k4Var = (C2088k4) this.f9803b.f12815a.get(this.f9802a);
        if (k4Var != null) {
            if (!(k4Var.f9563a + zzact.zzdbo.get().longValue() < zzp.zzkx().currentTimeMillis())) {
                zzatq = new zzatt(this.f9802a, k4Var.f9564b).zzvz();
                this.f9803b.f12815a.put(this.f9802a, new C2088k4(this.f9803b, zzatq));
                return zzatq;
            }
        }
        zzatq = new zzatt(this.f9802a).zzvz();
        this.f9803b.f12815a.put(this.f9802a, new C2088k4(this.f9803b, zzatq));
        return zzatq;
    }
}
