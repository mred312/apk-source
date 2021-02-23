package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzebj extends zzeae<zzedy> {
    zzebj() {
        super(zzedy.class, new w40(zzdzt.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzedz, zzedy> zzazy() {
        return new x40(this, zzedz.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzedy zzedy = (zzedy) zzels;
        zzeic.zzz(zzedy.getVersion(), 0);
        zzeic.zzft(zzedy.zzbam().size());
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzedy.zzk(zzeiu, zzeju.zzbhe());
    }
}
