package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzeay implements zzeao<zzdzt> {

    /* renamed from: com.google.android.gms.internal.ads.zzeay$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static class C2699a implements zzdzt {

        /* renamed from: a */
        private final zzeam<zzdzt> f16113a;

        private C2699a(zzeam<zzdzt> zzeam) {
            this.f16113a = zzeam;
        }

        public final byte[] zzc(byte[] bArr, byte[] bArr2) {
            return zzegr.zza(this.f16113a.zzbae().zzbad(), this.f16113a.zzbae().zzbaa().zzc(bArr, bArr2));
        }
    }

    static {
        Logger.getLogger(zzeay.class.getName());
    }

    zzeay() {
    }

    public final /* synthetic */ Object zza(zzeam zzeam) {
        return new C2699a(zzeam);
    }

    public final Class<zzdzt> zzazr() {
        return zzdzt.class;
    }
}
