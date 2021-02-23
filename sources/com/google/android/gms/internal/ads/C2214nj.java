package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.nj */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2214nj<T> implements zzahv<Object> {

    /* renamed from: a */
    private final WeakReference<T> f10206a;

    /* renamed from: b */
    private final String f10207b;

    /* renamed from: c */
    private final zzahv<T> f10208c;

    /* renamed from: d */
    private final /* synthetic */ zzcgh f10209d;

    private C2214nj(zzcgh zzcgh, WeakReference<T> weakReference, String str, zzahv<T> zzahv) {
        this.f10209d = zzcgh;
        this.f10206a = weakReference;
        this.f10207b = str;
        this.f10208c = zzahv;
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.f10206a.get();
        if (obj2 == null) {
            this.f10209d.zzb(this.f10207b, this);
        } else {
            this.f10208c.zza(obj2, map);
        }
    }

    /* synthetic */ C2214nj(zzcgh zzcgh, WeakReference weakReference, String str, zzahv zzahv, C1992hj hjVar) {
        this(zzcgh, weakReference, str, zzahv);
    }
}
