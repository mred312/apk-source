package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.bh */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1768bh implements zzahv<Object> {

    /* renamed from: a */
    private WeakReference<zzcbb> f7917a;

    private C1768bh(zzcbb zzcbb) {
        this.f7917a = new WeakReference<>(zzcbb);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzcbb zzcbb = (zzcbb) this.f7917a.get();
        if (zzcbb != null && "_ac".equals(map.get("eventName"))) {
            zzcbb.f13945h.onAdClicked();
        }
    }
}
