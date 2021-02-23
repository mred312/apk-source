package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzebd extends zzeae<zzedm> {
    zzebd() {
        super(zzedm.class, new s40(zzehr.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m8631c(zzedq zzedq) {
        if (zzedq.zzbbh() < 12 || zzedq.zzbbh() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public static void zza(zzedm zzedm) {
        zzeic.zzz(zzedm.getVersion(), 0);
        zzeic.zzft(zzedm.zzbam().size());
        m8631c(zzedm.zzbbb());
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzedn, zzedm> zzazy() {
        return new t40(this, zzedn.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zza((zzedm) zzels);
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzedm.zzg(zzeiu, zzeju.zzbhe());
    }
}
