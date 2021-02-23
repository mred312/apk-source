package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.work.WorkRequest;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzqa extends zzlv {

    /* renamed from: z0 */
    private static final int[] f16850z0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: U */
    private final Context f16851U;

    /* renamed from: V */
    private final zzqe f16852V;

    /* renamed from: W */
    private final zzqj f16853W;

    /* renamed from: X */
    private final int f16854X;

    /* renamed from: Y */
    private final boolean f16855Y;

    /* renamed from: Z */
    private final long[] f16856Z;

    /* renamed from: a0 */
    private zzhp[] f16857a0;

    /* renamed from: b0 */
    private zzqc f16858b0;

    /* renamed from: c0 */
    private Surface f16859c0;

    /* renamed from: d0 */
    private Surface f16860d0;

    /* renamed from: e0 */
    private int f16861e0;

    /* renamed from: f0 */
    private boolean f16862f0;

    /* renamed from: g0 */
    private long f16863g0;

    /* renamed from: h0 */
    private long f16864h0;

    /* renamed from: i0 */
    private int f16865i0;

    /* renamed from: j0 */
    private int f16866j0;

    /* renamed from: k0 */
    private int f16867k0;

    /* renamed from: l0 */
    private float f16868l0;

    /* renamed from: m0 */
    private int f16869m0;

    /* renamed from: n0 */
    private int f16870n0;

    /* renamed from: o0 */
    private int f16871o0;

    /* renamed from: p0 */
    private float f16872p0;

    /* renamed from: q0 */
    private int f16873q0;

    /* renamed from: r0 */
    private int f16874r0;

    /* renamed from: s0 */
    private int f16875s0;

    /* renamed from: t0 */
    private float f16876t0;

    /* renamed from: u0 */
    private boolean f16877u0;

    /* renamed from: v0 */
    private int f16878v0;

    /* renamed from: w0 */
    ug0 f16879w0;

    /* renamed from: x0 */
    private long f16880x0;

    /* renamed from: y0 */
    private int f16881y0;

    public zzqa(Context context, zzlx zzlx, long j, Handler handler, zzqg zzqg, int i) {
        this(context, zzlx, 0, (zzjt<zzjv>) null, false, handler, zzqg, -1);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m9050e(java.lang.String r5, int r6, int r7) {
        /*
            r0 = -1
            if (r6 == r0) goto L_0x0083
            if (r7 != r0) goto L_0x0007
            goto L_0x0083
        L_0x0007:
            r5.hashCode()
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 4
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x004d;
                case -1662541442: goto L_0x0042;
                case 1187890754: goto L_0x0037;
                case 1331836730: goto L_0x002c;
                case 1599127256: goto L_0x0021;
                case 1599127257: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r5 = -1
            goto L_0x0057
        L_0x0016:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            r5 = 5
            goto L_0x0057
        L_0x0021:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            r5 = 4
            goto L_0x0057
        L_0x002c:
            java.lang.String r1 = "video/avc"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r5 = 3
            goto L_0x0057
        L_0x0037:
            java.lang.String r1 = "video/mp4v-es"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0040
            goto L_0x0014
        L_0x0040:
            r5 = 2
            goto L_0x0057
        L_0x0042:
            java.lang.String r1 = "video/hevc"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x004b
            goto L_0x0014
        L_0x004b:
            r5 = 1
            goto L_0x0057
        L_0x004d:
            java.lang.String r1 = "video/3gpp"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            r5 = 0
        L_0x0057:
            switch(r5) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0077;
                case 2: goto L_0x007a;
                case 3: goto L_0x005b;
                case 4: goto L_0x007a;
                case 5: goto L_0x0077;
                default: goto L_0x005a;
            }
        L_0x005a:
            return r0
        L_0x005b:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzpt.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0066
            return r0
        L_0x0066:
            r5 = 16
            int r6 = com.google.android.gms.internal.ads.zzpt.zzf(r6, r5)
            int r5 = com.google.android.gms.internal.ads.zzpt.zzf(r7, r5)
            int r6 = r6 * r5
            int r5 = r6 << 4
            int r6 = r5 << 4
            goto L_0x007c
        L_0x0077:
            int r6 = r6 * r7
            goto L_0x007d
        L_0x007a:
            int r6 = r6 * r7
        L_0x007c:
            r3 = 2
        L_0x007d:
            int r6 = r6 * 3
            int r3 = r3 * 2
            int r6 = r6 / r3
            return r6
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqa.m9050e(java.lang.String, int, int):int");
    }

    /* renamed from: f */
    private final void m9051f(MediaCodec mediaCodec, int i, long j) {
        zzpq.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpq.endSection();
        this.zzbct.zzaof++;
    }

    @TargetApi(21)
    /* renamed from: g */
    private final void m9052g(MediaCodec mediaCodec, int i, long j, long j2) {
        m9061q();
        zzpq.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpq.endSection();
        this.zzbct.zzaoe++;
        this.f16866j0 = 0;
        mo18135o();
    }

    /* renamed from: h */
    private static boolean m9053h(boolean z, zzhp zzhp, zzhp zzhp2) {
        if (!zzhp.zzaha.equals(zzhp2.zzaha) || m9057l(zzhp) != m9057l(zzhp2)) {
            return false;
        }
        if (!z) {
            return zzhp.width == zzhp2.width && zzhp.height == zzhp2.height;
        }
        return true;
    }

    /* renamed from: i */
    private final void m9054i(MediaCodec mediaCodec, int i, long j) {
        m9061q();
        zzpq.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpq.endSection();
        this.zzbct.zzaoe++;
        this.f16866j0 = 0;
        mo18135o();
    }

    /* renamed from: j */
    private static boolean m9055j(long j) {
        return j < -30000;
    }

    /* renamed from: k */
    private static int m9056k(zzhp zzhp) {
        int i = zzhp.zzahb;
        if (i != -1) {
            return i;
        }
        return m9050e(zzhp.zzaha, zzhp.width, zzhp.height);
    }

    /* renamed from: l */
    private static int m9057l(zzhp zzhp) {
        int i = zzhp.zzahf;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    /* renamed from: m */
    private final void m9058m() {
        this.f16863g0 = -9223372036854775807L;
    }

    /* renamed from: n */
    private final void m9059n() {
        MediaCodec zzhe;
        this.f16862f0 = false;
        if (zzpt.SDK_INT >= 23 && this.f16877u0 && (zzhe = zzhe()) != null) {
            this.f16879w0 = new ug0(this, zzhe);
        }
    }

    /* renamed from: p */
    private final void m9060p() {
        this.f16873q0 = -1;
        this.f16874r0 = -1;
        this.f16876t0 = -1.0f;
        this.f16875s0 = -1;
    }

    /* renamed from: q */
    private final void m9061q() {
        int i = this.f16873q0;
        int i2 = this.f16869m0;
        if (i != i2 || this.f16874r0 != this.f16870n0 || this.f16875s0 != this.f16871o0 || this.f16876t0 != this.f16872p0) {
            this.f16853W.zzb(i2, this.f16870n0, this.f16871o0, this.f16872p0);
            this.f16873q0 = this.f16869m0;
            this.f16874r0 = this.f16870n0;
            this.f16875s0 = this.f16871o0;
            this.f16876t0 = this.f16872p0;
        }
    }

    /* renamed from: r */
    private final void m9062r() {
        if (this.f16873q0 != -1 || this.f16874r0 != -1) {
            this.f16853W.zzb(this.f16869m0, this.f16870n0, this.f16871o0, this.f16872p0);
        }
    }

    /* renamed from: s */
    private final void m9063s() {
        if (this.f16865i0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f16853W.zzg(this.f16865i0, elapsedRealtime - this.f16864h0);
            this.f16865i0 = 0;
            this.f16864h0 = elapsedRealtime;
        }
    }

    /* renamed from: t */
    private final boolean m9064t(boolean z) {
        if (zzpt.SDK_INT < 23 || this.f16877u0) {
            return false;
        }
        return !z || zzpw.zzc(this.f16851U);
    }

    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.f16862f0 || (((surface = this.f16860d0) != null && this.f16859c0 == surface) || zzhe() == null))) {
            this.f16863g0 = -9223372036854775807L;
            return true;
        } else if (this.f16863g0 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f16863g0) {
                return true;
            }
            this.f16863g0 = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final void mo18135o() {
        if (!this.f16862f0) {
            this.f16862f0 = true;
            this.f16853W.zzb(this.f16859c0);
        }
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.f16869m0 = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.f16870n0 = i2;
        float f = this.f16868l0;
        this.f16872p0 = f;
        if (zzpt.SDK_INT >= 21) {
            int i3 = this.f16867k0;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.f16869m0;
                this.f16869m0 = i2;
                this.f16870n0 = i4;
                this.f16872p0 = 1.0f / f;
            }
        } else {
            this.f16871o0 = this.f16867k0;
        }
        mediaCodec.setVideoScalingMode(this.f16861e0);
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.f16865i0 = 0;
        this.f16864h0 = SystemClock.elapsedRealtime();
        this.f16863g0 = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        m9063s();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzlx zzlx, zzhp zzhp) {
        boolean z;
        int i;
        int i2;
        String str = zzhp.zzaha;
        int i3 = 0;
        if (!zzpj.zzbd(str)) {
            return 0;
        }
        zzjo zzjo = zzhp.zzahd;
        if (zzjo != null) {
            z = false;
            for (int i4 = 0; i4 < zzjo.zzaoj; i4++) {
                z |= zzjo.zzae(i4).zzaok;
            }
        } else {
            z = false;
        }
        zzls zzc = zzlx.zzc(str, z);
        boolean z2 = true;
        if (zzc == null) {
            return 1;
        }
        boolean zzaz = zzc.zzaz(zzhp.zzagx);
        if (zzaz && (i = zzhp.width) > 0 && (i2 = zzhp.height) > 0) {
            if (zzpt.SDK_INT >= 21) {
                zzaz = zzc.zza(i, i2, (double) zzhp.zzahe);
            } else {
                if (i * i2 > zzlz.zzhk()) {
                    z2 = false;
                }
                if (!z2) {
                    int i5 = zzhp.width;
                    int i6 = zzhp.height;
                    String str2 = zzpt.zzbkl;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i5);
                    sb.append("x");
                    sb.append(i6);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
                zzaz = z2;
            }
        }
        int i7 = zzc.zzbbc ? 8 : 4;
        if (zzc.zzalk) {
            i3 = 16;
        }
        return (zzaz ? 3 : 2) | i7 | i3;
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.f16853W.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzhp zzhp) {
        super.zzd(zzhp);
        this.f16853W.zzc(zzhp);
        float f = zzhp.zzahg;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.f16868l0 = f;
        this.f16867k0 = m9057l(zzhp);
    }

    /* access modifiers changed from: protected */
    public final void zze(boolean z) {
        super.zze(z);
        int i = zzei().zzaid;
        this.f16878v0 = i;
        this.f16877u0 = i != 0;
        this.f16853W.zzc(this.zzbct);
        this.f16852V.enable();
    }

    /* access modifiers changed from: protected */
    public final void zzeh() {
        this.f16869m0 = -1;
        this.f16870n0 = -1;
        this.f16872p0 = -1.0f;
        this.f16868l0 = -1.0f;
        this.f16880x0 = -9223372036854775807L;
        this.f16881y0 = 0;
        m9060p();
        m9059n();
        this.f16852V.disable();
        this.f16879w0 = null;
        this.f16877u0 = false;
        try {
            super.zzeh();
        } finally {
            this.zzbct.zzgn();
            this.f16853W.zzd(this.zzbct);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzhg() {
        try {
            super.zzhg();
            Surface surface = this.f16860d0;
            if (surface != null) {
                if (this.f16859c0 == surface) {
                    this.f16859c0 = null;
                }
                surface.release();
                this.f16860d0 = null;
            }
        } catch (Throwable th) {
            if (this.f16860d0 != null) {
                Surface surface2 = this.f16859c0;
                Surface surface3 = this.f16860d0;
                if (surface2 == surface3) {
                    this.f16859c0 = null;
                }
                surface3.release();
                this.f16860d0 = null;
            }
            throw th;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzqa(Context context, zzlx zzlx, long j, zzjt<zzjv> zzjt, boolean z, Handler handler, zzqg zzqg, int i) {
        super(2, zzlx, (zzjt<zzjv>) null, false);
        boolean z2 = false;
        this.f16854X = -1;
        this.f16851U = context.getApplicationContext();
        this.f16852V = new zzqe(context);
        this.f16853W = new zzqj(handler, zzqg);
        if (zzpt.SDK_INT <= 22 && "foster".equals(zzpt.DEVICE) && "NVIDIA".equals(zzpt.MANUFACTURER)) {
            z2 = true;
        }
        this.f16855Y = z2;
        this.f16856Z = new long[10];
        this.f16880x0 = -9223372036854775807L;
        this.f16863g0 = -9223372036854775807L;
        this.f16869m0 = -1;
        this.f16870n0 = -1;
        this.f16872p0 = -1.0f;
        this.f16868l0 = -1.0f;
        this.f16861e0 = 1;
        m9060p();
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhp[] zzhpArr, long j) {
        this.f16857a0 = zzhpArr;
        if (this.f16880x0 == -9223372036854775807L) {
            this.f16880x0 = j;
        } else {
            int i = this.f16881y0;
            long[] jArr = this.f16856Z;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.f16881y0 = i + 1;
            }
            this.f16856Z[this.f16881y0 - 1] = j;
        }
        super.zza(zzhpArr, j);
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) {
        super.zza(j, z);
        m9059n();
        this.f16866j0 = 0;
        int i = this.f16881y0;
        if (i != 0) {
            this.f16880x0 = this.f16856Z[i - 1];
            this.f16881y0 = 0;
        }
        if (z) {
            m9058m();
        } else {
            this.f16863g0 = -9223372036854775807L;
        }
    }

    public final void zza(int i, Object obj) {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.f16860d0;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzls zzhf = zzhf();
                    if (zzhf != null && m9064t(zzhf.zzbbd)) {
                        surface = zzpw.zzc(this.f16851U, zzhf.zzbbd);
                        this.f16860d0 = surface;
                    }
                }
            }
            if (this.f16859c0 != surface) {
                this.f16859c0 = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzhe = zzhe();
                    if (zzpt.SDK_INT < 23 || zzhe == null || surface == null) {
                        zzhg();
                        zzhd();
                    } else {
                        zzhe.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.f16860d0) {
                    m9060p();
                    m9059n();
                    return;
                }
                m9062r();
                m9059n();
                if (state == 2) {
                    m9058m();
                }
            } else if (surface != null && surface != this.f16860d0) {
                m9062r();
                if (this.f16862f0) {
                    this.f16853W.zzb(this.f16859c0);
                }
            }
        } else if (i == 4) {
            this.f16861e0 = ((Integer) obj).intValue();
            MediaCodec zzhe2 = zzhe();
            if (zzhe2 != null) {
                zzhe2.setVideoScalingMode(this.f16861e0);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzls zzls) {
        return this.f16859c0 != null || m9064t(zzls.zzbbd);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f8, code lost:
        r20 = r10;
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzls r22, android.media.MediaCodec r23, com.google.android.gms.internal.ads.zzhp r24, android.media.MediaCrypto r25) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            com.google.android.gms.internal.ads.zzhp[] r4 = r0.f16857a0
            int r5 = r3.width
            int r6 = r3.height
            int r7 = m9056k(r24)
            int r8 = r4.length
            r9 = -1
            r11 = 1
            if (r8 != r11) goto L_0x001e
            com.google.android.gms.internal.ads.zzqc r4 = new com.google.android.gms.internal.ads.zzqc
            r4.<init>(r5, r6, r7)
            goto L_0x0136
        L_0x001e:
            int r8 = r4.length
            r13 = 0
            r14 = 0
        L_0x0021:
            if (r13 >= r8) goto L_0x0050
            r15 = r4[r13]
            boolean r10 = r1.zzbbc
            boolean r10 = m9053h(r10, r3, r15)
            if (r10 == 0) goto L_0x004c
            int r10 = r15.width
            if (r10 == r9) goto L_0x0038
            int r11 = r15.height
            if (r11 != r9) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r11 = 0
            goto L_0x0039
        L_0x0038:
            r11 = 1
        L_0x0039:
            r14 = r14 | r11
            int r5 = java.lang.Math.max(r5, r10)
            int r10 = r15.height
            int r6 = java.lang.Math.max(r6, r10)
            int r10 = m9056k(r15)
            int r7 = java.lang.Math.max(r7, r10)
        L_0x004c:
            int r13 = r13 + 1
            r11 = 1
            goto L_0x0021
        L_0x0050:
            if (r14 == 0) goto L_0x0131
            r4 = 66
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r4)
            java.lang.String r4 = "Resolutions unknown. Codec max resolution: "
            r8.append(r4)
            r8.append(r5)
            java.lang.String r4 = "x"
            r8.append(r4)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            java.lang.String r10 = "MediaCodecVideoRenderer"
            android.util.Log.w(r10, r8)
            int r8 = r3.height
            int r11 = r3.width
            if (r8 <= r11) goto L_0x007a
            r13 = 1
            goto L_0x007b
        L_0x007a:
            r13 = 0
        L_0x007b:
            if (r13 == 0) goto L_0x007f
            r14 = r8
            goto L_0x0080
        L_0x007f:
            r14 = r11
        L_0x0080:
            if (r13 == 0) goto L_0x0083
            r8 = r11
        L_0x0083:
            float r11 = (float) r8
            float r15 = (float) r14
            float r11 = r11 / r15
            int[] r15 = f16850z0
            int r12 = r15.length
            r9 = 0
        L_0x008a:
            if (r9 >= r12) goto L_0x00f8
            r16 = r12
            r12 = r15[r9]
            r17 = r15
            float r15 = (float) r12
            float r15 = r15 * r11
            int r15 = (int) r15
            if (r12 <= r14) goto L_0x00f8
            if (r15 > r8) goto L_0x009c
            goto L_0x00f8
        L_0x009c:
            r18 = r8
            int r8 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r19 = r11
            r11 = 21
            if (r8 < r11) goto L_0x00c3
            if (r13 == 0) goto L_0x00aa
            r8 = r15
            goto L_0x00ab
        L_0x00aa:
            r8 = r12
        L_0x00ab:
            if (r13 == 0) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r12 = r15
        L_0x00af:
            android.graphics.Point r8 = r1.zzd(r8, r12)
            float r11 = r3.zzahe
            int r12 = r8.x
            int r15 = r8.y
            r20 = r10
            double r10 = (double) r11
            boolean r10 = r1.zza(r12, r15, r10)
            if (r10 == 0) goto L_0x00eb
            goto L_0x00fb
        L_0x00c3:
            r20 = r10
            r8 = 16
            int r10 = com.google.android.gms.internal.ads.zzpt.zzf(r12, r8)
            int r10 = r10 << 4
            int r8 = com.google.android.gms.internal.ads.zzpt.zzf(r15, r8)
            int r8 = r8 << 4
            int r11 = r10 * r8
            int r12 = com.google.android.gms.internal.ads.zzlz.zzhk()
            if (r11 > r12) goto L_0x00eb
            android.graphics.Point r9 = new android.graphics.Point
            if (r13 == 0) goto L_0x00e1
            r11 = r8
            goto L_0x00e2
        L_0x00e1:
            r11 = r10
        L_0x00e2:
            if (r13 == 0) goto L_0x00e5
            goto L_0x00e6
        L_0x00e5:
            r10 = r8
        L_0x00e6:
            r9.<init>(r11, r10)
            r8 = r9
            goto L_0x00fb
        L_0x00eb:
            int r9 = r9 + 1
            r12 = r16
            r15 = r17
            r8 = r18
            r11 = r19
            r10 = r20
            goto L_0x008a
        L_0x00f8:
            r20 = r10
            r8 = 0
        L_0x00fb:
            if (r8 == 0) goto L_0x0131
            int r9 = r8.x
            int r5 = java.lang.Math.max(r5, r9)
            int r8 = r8.y
            int r6 = java.lang.Math.max(r6, r8)
            java.lang.String r8 = r3.zzaha
            int r8 = m9050e(r8, r5, r6)
            int r7 = java.lang.Math.max(r7, r8)
            r8 = 57
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r8 = "Codec max resolution adjusted to: "
            r9.append(r8)
            r9.append(r5)
            r9.append(r4)
            r9.append(r6)
            java.lang.String r4 = r9.toString()
            r8 = r20
            android.util.Log.w(r8, r4)
        L_0x0131:
            com.google.android.gms.internal.ads.zzqc r4 = new com.google.android.gms.internal.ads.zzqc
            r4.<init>(r5, r6, r7)
        L_0x0136:
            r0.f16858b0 = r4
            boolean r5 = r0.f16855Y
            int r6 = r0.f16878v0
            android.media.MediaFormat r3 = r24.zzfa()
            int r7 = r4.width
            java.lang.String r8 = "max-width"
            r3.setInteger(r8, r7)
            int r7 = r4.height
            java.lang.String r8 = "max-height"
            r3.setInteger(r8, r7)
            int r4 = r4.zzbme
            r7 = -1
            if (r4 == r7) goto L_0x0158
            java.lang.String r7 = "max-input-size"
            r3.setInteger(r7, r4)
        L_0x0158:
            if (r5 == 0) goto L_0x0160
            java.lang.String r4 = "auto-frc"
            r5 = 0
            r3.setInteger(r4, r5)
        L_0x0160:
            if (r6 == 0) goto L_0x016d
            java.lang.String r4 = "tunneled-playback"
            r5 = 1
            r3.setFeatureEnabled(r4, r5)
            java.lang.String r4 = "audio-session-id"
            r3.setInteger(r4, r6)
        L_0x016d:
            android.view.Surface r4 = r0.f16859c0
            if (r4 != 0) goto L_0x018c
            boolean r4 = r1.zzbbd
            boolean r4 = r0.m9064t(r4)
            com.google.android.gms.internal.ads.zzpc.checkState(r4)
            android.view.Surface r4 = r0.f16860d0
            if (r4 != 0) goto L_0x0188
            android.content.Context r4 = r0.f16851U
            boolean r1 = r1.zzbbd
            com.google.android.gms.internal.ads.zzpw r1 = com.google.android.gms.internal.ads.zzpw.zzc(r4, r1)
            r0.f16860d0 = r1
        L_0x0188:
            android.view.Surface r1 = r0.f16860d0
            r0.f16859c0 = r1
        L_0x018c:
            android.view.Surface r1 = r0.f16859c0
            r4 = 0
            r5 = 0
            r2.configure(r3, r1, r4, r5)
            int r1 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r3 = 23
            if (r1 < r3) goto L_0x01a4
            boolean r1 = r0.f16877u0
            if (r1 == 0) goto L_0x01a4
            com.google.android.gms.internal.ads.ug0 r1 = new com.google.android.gms.internal.ads.ug0
            r1.<init>(r0, r2)
            r0.f16879w0 = r1
        L_0x01a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqa.zza(com.google.android.gms.internal.ads.zzls, android.media.MediaCodec, com.google.android.gms.internal.ads.zzhp, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public final void zza(zzjl zzjl) {
        if (zzpt.SDK_INT < 23 && this.f16877u0) {
            mo18135o();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzhp zzhp, zzhp zzhp2) {
        if (!m9053h(z, zzhp, zzhp2)) {
            return false;
        }
        int i = zzhp2.width;
        zzqc zzqc = this.f16858b0;
        return i <= zzqc.width && zzhp2.height <= zzqc.height && zzhp2.zzahb <= zzqc.zzbme;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.f16881y0;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.f16856Z;
            if (j4 < jArr[0]) {
                break;
            }
            this.f16880x0 = jArr[0];
            int i5 = i4 - 1;
            this.f16881y0 = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j5 = j4 - this.f16880x0;
        if (z) {
            m9051f(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.f16859c0 == this.f16860d0) {
            if (!m9055j(j6)) {
                return false;
            }
            m9051f(mediaCodec2, i3, j5);
            return true;
        } else if (!this.f16862f0) {
            if (zzpt.SDK_INT >= 21) {
                m9052g(mediaCodec, i, j5, System.nanoTime());
            } else {
                m9054i(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.f16852V.zzf(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzf - nanoTime) / 1000;
            if (m9055j(j7)) {
                zzpq.beginSection("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzpq.endSection();
                zzjm zzjm = this.zzbct;
                zzjm.zzaog++;
                this.f16865i0++;
                int i6 = this.f16866j0 + 1;
                this.f16866j0 = i6;
                zzjm.zzaoh = Math.max(i6, zzjm.zzaoh);
                if (this.f16865i0 == this.f16854X) {
                    m9063s();
                }
                return true;
            }
            if (zzpt.SDK_INT >= 21) {
                if (j7 < 50000) {
                    m9052g(mediaCodec, i, j5, zzf);
                    return true;
                }
            } else if (j7 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - WorkRequest.MIN_BACKOFF_MILLIS) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                m9054i(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }
}
