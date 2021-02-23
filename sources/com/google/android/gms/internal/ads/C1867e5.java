package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.e5 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1867e5 implements C2126l5 {

    /* renamed from: a */
    private final Context f8316a;

    /* renamed from: b */
    private final String f8317b;

    C1867e5(Context context, String str) {
        this.f8316a = context;
        this.f8317b = str;
    }

    /* renamed from: a */
    public final void mo13736a(zzbgf zzbgf) {
        Context context = this.f8316a;
        zzbgf.zzb(ObjectWrapper.wrap(context), this.f8317b, context.getPackageName());
    }
}
