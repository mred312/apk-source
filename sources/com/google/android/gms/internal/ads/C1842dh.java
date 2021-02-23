package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.dh */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1842dh implements zzahv<Object> {

    /* renamed from: a */
    private WeakReference<zzcbb> f8266a;

    private C1842dh(zzcbb zzcbb) {
        this.f8266a = new WeakReference<>(zzcbb);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzcbb zzcbb = (zzcbb) this.f8266a.get();
        if (zzcbb != null) {
            zzcbb.f13944g.onAdImpression();
        }
    }
}
