package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.a9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1723a9 implements zzdyo<Map<String, String>> {

    /* renamed from: a */
    private final /* synthetic */ List f7795a;

    /* renamed from: b */
    private final /* synthetic */ String f7796b;

    /* renamed from: c */
    private final /* synthetic */ zzbdu f7797c;

    C1723a9(zzbdu zzbdu, List list, String str) {
        this.f7797c = zzbdu;
        this.f7795a = list;
        this.f7796b = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.f7797c.m7730e((Map) obj, this.f7795a, this.f7796b);
    }

    public final void zzb(Throwable th) {
    }
}
