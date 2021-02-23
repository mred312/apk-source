package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzeon extends zzeop implements zzbp {

    /* renamed from: f */
    private zzbs f16318f;

    /* renamed from: g */
    private String f16319g;

    /* renamed from: h */
    private boolean f16320h;

    public zzeon(String str) {
        this.f16319g = str;
    }

    public final String getType() {
        return this.f16319g;
    }

    public final void zza(zzbs zzbs) {
        this.f16318f = zzbs;
    }

    public final void zza(zzeor zzeor, ByteBuffer byteBuffer, long j, zzbo zzbo) {
        zzeor.position();
        byteBuffer.remaining();
        this.f16320h = byteBuffer.remaining() == 16;
        zza(zzeor, j, zzbo);
    }

    public final void zza(zzeor zzeor, long j, zzbo zzbo) {
        this.zziyc = zzeor;
        this.f16332b = zzeor.position();
        if (!this.f16320h) {
            int i = ((8 + j) > 4294967296L ? 1 : ((8 + j) == 4294967296L ? 0 : -1));
        }
        zzeor.zzfc(zzeor.position() + j);
        this.f16333c = zzeor.position();
        this.zziyf = zzbo;
    }
}
