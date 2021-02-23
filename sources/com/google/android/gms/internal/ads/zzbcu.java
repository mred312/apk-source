package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbcu implements Iterable<zzbcs> {

    /* renamed from: a */
    private final List<zzbcs> f13151a = new ArrayList();

    /* renamed from: a */
    static zzbcs m7710a(zzbbe zzbbe) {
        Iterator<zzbcs> it = zzp.zzlm().iterator();
        while (it.hasNext()) {
            zzbcs next = it.next();
            if (next.f13147a == zzbbe) {
                return next;
            }
        }
        return null;
    }

    public static boolean zzc(zzbbe zzbbe) {
        zzbcs a = m7710a(zzbbe);
        if (a == null) {
            return false;
        }
        a.f13148b.abort();
        return true;
    }

    public final Iterator<zzbcs> iterator() {
        return this.f13151a.iterator();
    }

    public final void zza(zzbcs zzbcs) {
        this.f13151a.add(zzbcs);
    }

    public final void zzb(zzbcs zzbcs) {
        this.f13151a.remove(zzbcs);
    }
}
