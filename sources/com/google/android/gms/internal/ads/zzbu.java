package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbu extends zzeoq {

    /* renamed from: k */
    private Date f13769k;

    /* renamed from: l */
    private Date f13770l;

    /* renamed from: m */
    private long f13771m;

    /* renamed from: n */
    private long f13772n;

    /* renamed from: o */
    private double f13773o = 1.0d;

    /* renamed from: p */
    private float f13774p = 1.0f;

    /* renamed from: q */
    private zzepa f13775q = zzepa.zziyq;

    /* renamed from: r */
    private long f13776r;

    public zzbu() {
        super("mvhd");
    }

    public final long getDuration() {
        return this.f13772n;
    }

    public final String toString() {
        return "MovieHeaderBox[" + "creationTime=" + this.f13769k + ";" + "modificationTime=" + this.f13770l + ";" + "timescale=" + this.f13771m + ";" + "duration=" + this.f13772n + ";" + "rate=" + this.f13773o + ";" + "volume=" + this.f13774p + ";" + "matrix=" + this.f13775q + ";" + "nextTrackId=" + this.f13776r + "]";
    }

    public final void zzl(ByteBuffer byteBuffer) {
        zzr(byteBuffer);
        if (getVersion() == 1) {
            this.f13769k = zzeot.zzfu(zzbq.zzh(byteBuffer));
            this.f13770l = zzeot.zzfu(zzbq.zzh(byteBuffer));
            this.f13771m = zzbq.zzf(byteBuffer);
            this.f13772n = zzbq.zzh(byteBuffer);
        } else {
            this.f13769k = zzeot.zzfu(zzbq.zzf(byteBuffer));
            this.f13770l = zzeot.zzfu(zzbq.zzf(byteBuffer));
            this.f13771m = zzbq.zzf(byteBuffer);
            this.f13772n = zzbq.zzf(byteBuffer);
        }
        this.f13773o = zzbq.zzi(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.f13774p = ((float) ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)))))) / 256.0f;
        zzbq.zzg(byteBuffer);
        zzbq.zzf(byteBuffer);
        zzbq.zzf(byteBuffer);
        this.f13775q = zzepa.zzs(byteBuffer);
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.f13776r = zzbq.zzf(byteBuffer);
    }

    public final long zzr() {
        return this.f13771m;
    }
}
