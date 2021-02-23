package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgu implements Callable<zzcgh> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzb f14331a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzbed f14332b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f14333c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzckq f14334d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzcqo f14335e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Executor f14336f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzef f14337g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzazh f14338h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final zzdrz f14339i;

    public zzcgu(Context context, Executor executor, zzef zzef, zzazh zzazh, zzb zzb, zzbed zzbed, zzcqo zzcqo, zzdrz zzdrz, zzckq zzckq) {
        this.f14333c = context;
        this.f14336f = executor;
        this.f14337g = zzef;
        this.f14338h = zzazh;
        this.f14331a = zzb;
        this.f14332b = zzbed;
        this.f14335e = zzcqo;
        this.f14339i = zzdrz;
        this.f14334d = zzckq;
    }

    public final /* synthetic */ Object call() {
        zzcgh zzcgh = new zzcgh(this);
        zzcgh.zzaou();
        return zzcgh;
    }
}
