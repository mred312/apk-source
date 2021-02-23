package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckq {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzckv f14509a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Executor f14510b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<String, String> f14511c;

    public zzckq(zzckv zzckv, Executor executor) {
        this.f14509a = zzckv;
        this.f14511c = zzckv.zzaqh();
        this.f14510b = executor;
    }

    public final zzckp zzaqg() {
        zzckp zzckp = new zzckp(this);
        zzckp unused = zzckp.m8177a();
        return zzckp;
    }
}
