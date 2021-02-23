package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.eh */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1879eh implements zzahv<Object> {

    /* renamed from: a */
    private WeakReference<zzcbb> f8362a;

    private C1879eh(zzcbb zzcbb) {
        this.f8362a = new WeakReference<>(zzcbb);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzcbb zzcbb = (zzcbb) this.f8362a.get();
        if (zzcbb != null) {
            zzcbb.f13945h.onAdClicked();
        }
    }
}
