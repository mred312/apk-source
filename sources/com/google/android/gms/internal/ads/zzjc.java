package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzjc extends zzlv implements zzpg {
    /* access modifiers changed from: private */

    /* renamed from: U */
    public final zzik f16522U;

    /* renamed from: V */
    private final zzip f16523V;

    /* renamed from: W */
    private boolean f16524W;

    /* renamed from: X */
    private boolean f16525X;

    /* renamed from: Y */
    private MediaFormat f16526Y;

    /* renamed from: Z */
    private int f16527Z;

    /* renamed from: a0 */
    private int f16528a0;

    /* renamed from: b0 */
    private long f16529b0;
    /* access modifiers changed from: private */

    /* renamed from: c0 */
    public boolean f16530c0;

    public zzjc(zzlx zzlx, Handler handler, zzih zzih) {
        this(zzlx, (zzjt<zzjv>) null, true, handler, zzih);
    }

    /* renamed from: g */
    private final boolean m8981g(String str) {
        return false;
    }

    protected static void zza(int i, long j, long j2) {
    }

    protected static void zzgd() {
    }

    protected static void zzw(int i) {
    }

    public final boolean isReady() {
        return this.f16523V.zzfr() || super.isReady();
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int[] iArr;
        int i;
        MediaFormat mediaFormat2 = this.f16526Y;
        boolean z = mediaFormat2 != null;
        String string = z ? mediaFormat2.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.f16526Y;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.f16525X || integer != 6 || (i = this.f16528a0) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.f16528a0; i2++) {
                iArr[i2] = i2;
            }
        }
        try {
            this.f16523V.zza(string, integer, integer2, this.f16527Z, 0, iArr);
        } catch (zzit e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.f16523V.play();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.f16523V.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzlx zzlx, zzhp zzhp) {
        int i;
        int i2;
        String str = zzhp.zzaha;
        boolean z = false;
        if (!zzpj.zzbc(str)) {
            return 0;
        }
        int i3 = zzpt.SDK_INT;
        int i4 = i3 >= 21 ? 16 : 0;
        int i5 = 3;
        if (m8981g(str) && zzlx.zzhj() != null) {
            return i4 | 4 | 3;
        }
        zzls zzc = zzlx.zzc(str, false);
        if (zzc == null) {
            return 1;
        }
        if (i3 < 21 || (((i = zzhp.zzahl) == -1 || zzc.zzaw(i)) && ((i2 = zzhp.zzahk) == -1 || zzc.zzax(i2)))) {
            z = true;
        }
        if (!z) {
            i5 = 2;
        }
        return i4 | 4 | i5;
    }

    public final zzhv zzb(zzhv zzhv) {
        return this.f16523V.zzb(zzhv);
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.f16522U.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzhp zzhp) {
        super.zzd(zzhp);
        this.f16522U.zzc(zzhp);
        this.f16527Z = "audio/raw".equals(zzhp.zzaha) ? zzhp.zzahm : 2;
        this.f16528a0 = zzhp.zzahk;
    }

    /* access modifiers changed from: protected */
    public final void zze(boolean z) {
        super.zze(z);
        this.f16522U.zzc(this.zzbct);
        int i = zzei().zzaid;
        this.f16523V.zzft();
    }

    public final zzpg zzea() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final void zzeh() {
        try {
            this.f16523V.release();
            try {
                super.zzeh();
            } finally {
                this.zzbct.zzgn();
                this.f16522U.zzd(this.zzbct);
            }
        } catch (Throwable th) {
            super.zzeh();
            throw th;
        } finally {
            this.zzbct.zzgn();
            this.f16522U.zzd(this.zzbct);
        }
    }

    public final boolean zzfe() {
        return super.zzfe() && this.f16523V.zzfe();
    }

    public final zzhv zzfs() {
        return this.f16523V.zzfs();
    }

    public final long zzfz() {
        long zzj = this.f16523V.zzj(zzfe());
        if (zzj != Long.MIN_VALUE) {
            if (!this.f16530c0) {
                zzj = Math.max(this.f16529b0, zzj);
            }
            this.f16529b0 = zzj;
            this.f16530c0 = false;
        }
        return this.f16529b0;
    }

    /* access modifiers changed from: protected */
    public final void zzge() {
        try {
            this.f16523V.zzfp();
        } catch (zzix e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    private zzjc(zzlx zzlx, zzjt<zzjv> zzjt, boolean z, Handler handler, zzih zzih) {
        this(zzlx, (zzjt<zzjv>) null, true, handler, zzih, (zzig) null, new zzif[0]);
    }

    private zzjc(zzlx zzlx, zzjt<zzjv> zzjt, boolean z, Handler handler, zzih zzih, zzig zzig, zzif... zzifArr) {
        super(1, zzlx, (zzjt<zzjv>) null, true);
        this.f16523V = new zzip((zzig) null, zzifArr, new fe0(this));
        this.f16522U = new zzik(handler, zzih);
    }

    /* access modifiers changed from: protected */
    public final zzls zza(zzlx zzlx, zzhp zzhp, boolean z) {
        zzls zzhj;
        if (!m8981g(zzhp.zzaha) || (zzhj = zzlx.zzhj()) == null) {
            this.f16524W = false;
            return super.zza(zzlx, zzhp, z);
        }
        this.f16524W = true;
        return zzhj;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzls r4, android.media.MediaCodec r5, com.google.android.gms.internal.ads.zzhp r6, android.media.MediaCrypto r7) {
        /*
            r3 = this;
            java.lang.String r4 = r4.name
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r0 = 0
            r1 = 24
            if (r7 >= r1) goto L_0x0037
            java.lang.String r7 = "OMX.SEC.aac.dec"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0037
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpt.MANUFACTURER
            java.lang.String r7 = "samsung"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0037
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r7 = "zeroflte"
            boolean r7 = r4.startsWith(r7)
            if (r7 != 0) goto L_0x0035
            java.lang.String r7 = "herolte"
            boolean r7 = r4.startsWith(r7)
            if (r7 != 0) goto L_0x0035
            java.lang.String r7 = "heroqlte"
            boolean r4 = r4.startsWith(r7)
            if (r4 == 0) goto L_0x0037
        L_0x0035:
            r4 = 1
            goto L_0x0038
        L_0x0037:
            r4 = 0
        L_0x0038:
            r3.f16525X = r4
            boolean r4 = r3.f16524W
            r7 = 0
            if (r4 == 0) goto L_0x0059
            android.media.MediaFormat r4 = r6.zzfa()
            r3.f16526Y = r4
            java.lang.String r1 = "mime"
            java.lang.String r2 = "audio/raw"
            r4.setString(r1, r2)
            android.media.MediaFormat r4 = r3.f16526Y
            r5.configure(r4, r7, r7, r0)
            android.media.MediaFormat r4 = r3.f16526Y
            java.lang.String r5 = r6.zzaha
            r4.setString(r1, r5)
            return
        L_0x0059:
            android.media.MediaFormat r4 = r6.zzfa()
            r5.configure(r4, r7, r7, r0)
            r3.f16526Y = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjc.zza(com.google.android.gms.internal.ads.zzls, android.media.MediaCodec, com.google.android.gms.internal.ads.zzhp, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) {
        super.zza(j, z);
        this.f16523V.reset();
        this.f16529b0 = j;
        this.f16530c0 = true;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.f16524W && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbct.zzaof++;
            this.f16523V.zzfo();
            return true;
        } else {
            try {
                if (!this.f16523V.zzb(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzbct.zzaoe++;
                return true;
            } catch (zziw | zzix e) {
                throw zzhe.zza(e, getIndex());
            }
        }
    }

    public final void zza(int i, Object obj) {
        if (i == 2) {
            this.f16523V.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.f16523V.setStreamType(((Integer) obj).intValue());
        }
    }
}
