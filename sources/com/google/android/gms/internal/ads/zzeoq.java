package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzeoq extends zzeoo implements zzbp {

    /* renamed from: j */
    private int f16335j;

    protected zzeoq(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.f16324c) {
            zzblq();
        }
        return this.f16335j;
    }

    /* access modifiers changed from: protected */
    public final long zzr(ByteBuffer byteBuffer) {
        this.f16335j = zzbq.zza(byteBuffer.get());
        zzbq.zzg(byteBuffer);
        zzbq.zza(byteBuffer.get());
        return 4;
    }
}
