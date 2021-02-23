package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.util.zzm;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbaz {

    /* renamed from: a */
    private final long f13021a = TimeUnit.MILLISECONDS.toNanos(((Long) zzwq.zzqe().zzd(zzabf.zzcmo)).longValue());

    /* renamed from: b */
    private long f13022b;

    /* renamed from: c */
    private boolean f13023c = true;

    zzbaz() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbam zzbam) {
        if (zzbam != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.f13023c || Math.abs(timestamp - this.f13022b) >= this.f13021a) {
                this.f13023c = false;
                this.f13022b = timestamp;
                zzm.zzedd.post(new C1721a7(this, zzbam));
            }
        }
    }

    public final void zzzs() {
        this.f13023c = true;
    }
}
