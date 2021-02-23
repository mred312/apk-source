package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
class y50 implements zzeao<zzeak> {

    /* renamed from: com.google.android.gms.internal.ads.y50$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static class C2614a implements zzeak {

        /* renamed from: a */
        private final zzeam<zzeak> f11987a;

        /* renamed from: b */
        private final byte[] f11988b;

        private C2614a(zzeam<zzeak> zzeam) {
            this.f11988b = new byte[]{0};
            this.f11987a = zzeam;
        }

        public final byte[] zzl(byte[] bArr) {
            if (this.f11987a.zzbae().zzbac().equals(zzegd.LEGACY)) {
                return zzegr.zza(this.f11987a.zzbae().zzbad(), this.f11987a.zzbae().zzbaa().zzl(zzegr.zza(bArr, this.f11988b)));
            }
            return zzegr.zza(this.f11987a.zzbae().zzbad(), this.f11987a.zzbae().zzbaa().zzl(bArr));
        }
    }

    static {
        Logger.getLogger(y50.class.getName());
    }

    y50() {
    }

    public final /* synthetic */ Object zza(zzeam zzeam) {
        return new C2614a(zzeam);
    }

    public final Class<zzeak> zzazr() {
        return zzeak.class;
    }
}
