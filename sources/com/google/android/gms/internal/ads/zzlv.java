package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(19)
@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzlv extends zzhc {

    /* renamed from: T */
    private static final byte[] f16671T = zzpt.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");

    /* renamed from: A */
    private boolean f16672A;

    /* renamed from: B */
    private boolean f16673B;

    /* renamed from: C */
    private boolean f16674C;

    /* renamed from: D */
    private boolean f16675D;

    /* renamed from: E */
    private ByteBuffer[] f16676E;

    /* renamed from: F */
    private ByteBuffer[] f16677F;

    /* renamed from: G */
    private long f16678G;

    /* renamed from: H */
    private int f16679H;

    /* renamed from: I */
    private int f16680I;

    /* renamed from: J */
    private boolean f16681J;

    /* renamed from: K */
    private boolean f16682K;

    /* renamed from: L */
    private int f16683L;

    /* renamed from: M */
    private int f16684M;

    /* renamed from: N */
    private boolean f16685N;

    /* renamed from: O */
    private boolean f16686O;

    /* renamed from: P */
    private boolean f16687P;

    /* renamed from: Q */
    private boolean f16688Q;

    /* renamed from: R */
    private boolean f16689R;

    /* renamed from: S */
    private boolean f16690S;

    /* renamed from: i */
    private final zzlx f16691i;

    /* renamed from: j */
    private final zzjt<zzjv> f16692j;

    /* renamed from: k */
    private final boolean f16693k;

    /* renamed from: l */
    private final zzjl f16694l;

    /* renamed from: m */
    private final zzjl f16695m;

    /* renamed from: n */
    private final zzhr f16696n;

    /* renamed from: o */
    private final List<Long> f16697o;

    /* renamed from: p */
    private final MediaCodec.BufferInfo f16698p;

    /* renamed from: q */
    private zzhp f16699q;

    /* renamed from: r */
    private zzjr<zzjv> f16700r;

    /* renamed from: s */
    private zzjr<zzjv> f16701s;

    /* renamed from: t */
    private MediaCodec f16702t;

    /* renamed from: u */
    private zzls f16703u;

    /* renamed from: v */
    private boolean f16704v;

    /* renamed from: w */
    private boolean f16705w;

    /* renamed from: x */
    private boolean f16706x;

    /* renamed from: y */
    private boolean f16707y;

    /* renamed from: z */
    private boolean f16708z;
    protected zzjm zzbct;

    public zzlv(int i, zzlx zzlx, zzjt<zzjv> zzjt, boolean z) {
        super(i);
        zzpc.checkState(zzpt.SDK_INT >= 16);
        this.f16691i = (zzlx) zzpc.checkNotNull(zzlx);
        this.f16692j = null;
        this.f16693k = z;
        this.f16694l = new zzjl(0);
        this.f16695m = new zzjl(0);
        this.f16696n = new zzhr();
        this.f16697o = new ArrayList();
        this.f16698p = new MediaCodec.BufferInfo();
        this.f16683L = 0;
        this.f16684M = 0;
    }

    /* renamed from: a */
    private final void m9015a(zzlu zzlu) {
        throw zzhe.zza(zzlu, getIndex());
    }

    /* renamed from: b */
    private final boolean m9016b(long j, long j2) {
        boolean z;
        boolean z2;
        if (this.f16680I < 0) {
            if (!this.f16672A || !this.f16686O) {
                this.f16680I = this.f16702t.dequeueOutputBuffer(this.f16698p, 0);
            } else {
                try {
                    this.f16680I = this.f16702t.dequeueOutputBuffer(this.f16698p, 0);
                } catch (IllegalStateException unused) {
                    m9018d();
                    if (this.f16688Q) {
                        zzhg();
                    }
                    return false;
                }
            }
            int i = this.f16680I;
            if (i >= 0) {
                if (this.f16675D) {
                    this.f16675D = false;
                    this.f16702t.releaseOutputBuffer(i, false);
                    this.f16680I = -1;
                    return true;
                }
                MediaCodec.BufferInfo bufferInfo = this.f16698p;
                if ((bufferInfo.flags & 4) != 0) {
                    m9018d();
                    this.f16680I = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.f16677F[i];
                if (byteBuffer != null) {
                    byteBuffer.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.f16698p;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                long j3 = this.f16698p.presentationTimeUs;
                int size = this.f16697o.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z2 = false;
                        break;
                    } else if (this.f16697o.get(i2).longValue() == j3) {
                        this.f16697o.remove(i2);
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                this.f16681J = z2;
            } else if (i == -2) {
                MediaFormat outputFormat = this.f16702t.getOutputFormat();
                if (this.f16706x && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.f16675D = true;
                } else {
                    if (this.f16673B) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.f16702t, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.f16677F = this.f16702t.getOutputBuffers();
                return true;
            } else {
                if (this.f16707y && (this.f16687P || this.f16684M == 2)) {
                    m9018d();
                }
                return false;
            }
        }
        if (!this.f16672A || !this.f16686O) {
            MediaCodec mediaCodec = this.f16702t;
            ByteBuffer[] byteBufferArr = this.f16677F;
            int i3 = this.f16680I;
            ByteBuffer byteBuffer2 = byteBufferArr[i3];
            MediaCodec.BufferInfo bufferInfo3 = this.f16698p;
            z = zza(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.f16681J);
        } else {
            try {
                MediaCodec mediaCodec2 = this.f16702t;
                ByteBuffer[] byteBufferArr2 = this.f16677F;
                int i4 = this.f16680I;
                ByteBuffer byteBuffer3 = byteBufferArr2[i4];
                MediaCodec.BufferInfo bufferInfo4 = this.f16698p;
                z = zza(j, j2, mediaCodec2, byteBuffer3, i4, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.f16681J);
            } catch (IllegalStateException unused2) {
                m9018d();
                if (this.f16688Q) {
                    zzhg();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.f16698p.presentationTimeUs;
        this.f16680I = -1;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0145 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0146  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m9017c() {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.f16702t
            r1 = 0
            if (r0 == 0) goto L_0x01ce
            int r2 = r14.f16684M
            r3 = 2
            if (r2 == r3) goto L_0x01ce
            boolean r2 = r14.f16687P
            if (r2 == 0) goto L_0x0010
            goto L_0x01ce
        L_0x0010:
            int r2 = r14.f16679H
            if (r2 >= 0) goto L_0x002a
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r14.f16679H = r0
            if (r0 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            com.google.android.gms.internal.ads.zzjl r2 = r14.f16694l
            java.nio.ByteBuffer[] r4 = r14.f16676E
            r0 = r4[r0]
            r2.zzda = r0
            r2.clear()
        L_0x002a:
            int r0 = r14.f16684M
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0047
            boolean r0 = r14.f16707y
            if (r0 != 0) goto L_0x0044
            r14.f16686O = r4
            android.media.MediaCodec r5 = r14.f16702t
            int r6 = r14.f16679H
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.f16679H = r2
        L_0x0044:
            r14.f16684M = r3
            return r1
        L_0x0047:
            boolean r0 = r14.f16674C
            if (r0 == 0) goto L_0x0067
            r14.f16674C = r1
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            java.nio.ByteBuffer r0 = r0.zzda
            byte[] r1 = f16671T
            r0.put(r1)
            android.media.MediaCodec r5 = r14.f16702t
            int r6 = r14.f16679H
            r7 = 0
            int r8 = r1.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.f16679H = r2
            r14.f16685N = r4
            return r4
        L_0x0067:
            boolean r0 = r14.f16689R
            if (r0 == 0) goto L_0x006e
            r0 = -4
            r5 = 0
            goto L_0x00a6
        L_0x006e:
            int r0 = r14.f16683L
            if (r0 != r4) goto L_0x0093
            r0 = 0
        L_0x0073:
            com.google.android.gms.internal.ads.zzhp r5 = r14.f16699q
            java.util.List<byte[]> r5 = r5.zzahc
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0091
            com.google.android.gms.internal.ads.zzhp r5 = r14.f16699q
            java.util.List<byte[]> r5 = r5.zzahc
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zzjl r6 = r14.f16694l
            java.nio.ByteBuffer r6 = r6.zzda
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0073
        L_0x0091:
            r14.f16683L = r3
        L_0x0093:
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            java.nio.ByteBuffer r0 = r0.zzda
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzhr r5 = r14.f16696n
            com.google.android.gms.internal.ads.zzjl r6 = r14.f16694l
            int r5 = r14.zza((com.google.android.gms.internal.ads.zzhr) r5, (com.google.android.gms.internal.ads.zzjl) r6, (boolean) r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00a6:
            r6 = -3
            if (r0 != r6) goto L_0x00aa
            return r1
        L_0x00aa:
            r6 = -5
            if (r0 != r6) goto L_0x00c0
            int r0 = r14.f16683L
            if (r0 != r3) goto L_0x00b8
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            r0.clear()
            r14.f16683L = r4
        L_0x00b8:
            com.google.android.gms.internal.ads.zzhr r0 = r14.f16696n
            com.google.android.gms.internal.ads.zzhp r0 = r0.zzahv
            r14.zzd(r0)
            return r4
        L_0x00c0:
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            boolean r0 = r0.zzgl()
            if (r0 == 0) goto L_0x00fc
            int r0 = r14.f16683L
            if (r0 != r3) goto L_0x00d3
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            r0.clear()
            r14.f16683L = r4
        L_0x00d3:
            r14.f16687P = r4
            boolean r0 = r14.f16685N
            if (r0 != 0) goto L_0x00dd
            r14.m9018d()
            return r1
        L_0x00dd:
            boolean r0 = r14.f16707y     // Catch:{ CryptoException -> 0x00f2 }
            if (r0 != 0) goto L_0x00f1
            r14.f16686O = r4     // Catch:{ CryptoException -> 0x00f2 }
            android.media.MediaCodec r5 = r14.f16702t     // Catch:{ CryptoException -> 0x00f2 }
            int r6 = r14.f16679H     // Catch:{ CryptoException -> 0x00f2 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f2 }
            r14.f16679H = r2     // Catch:{ CryptoException -> 0x00f2 }
        L_0x00f1:
            return r1
        L_0x00f2:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x00fc:
            boolean r0 = r14.f16690S
            if (r0 == 0) goto L_0x0114
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            boolean r0 = r0.zzgm()
            if (r0 != 0) goto L_0x0114
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            r0.clear()
            int r0 = r14.f16683L
            if (r0 != r3) goto L_0x0113
            r14.f16683L = r4
        L_0x0113:
            return r4
        L_0x0114:
            r14.f16690S = r1
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l
            boolean r0 = r0.isEncrypted()
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r3 = r14.f16700r
            if (r3 == 0) goto L_0x0140
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0131
            r6 = 4
            if (r3 == r6) goto L_0x0140
            if (r0 != 0) goto L_0x012f
            boolean r3 = r14.f16693k
            if (r3 != 0) goto L_0x0140
        L_0x012f:
            r3 = 1
            goto L_0x0141
        L_0x0131:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r0 = r14.f16700r
            com.google.android.gms.internal.ads.zzjq r0 = r0.zzgp()
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x0140:
            r3 = 0
        L_0x0141:
            r14.f16689R = r3
            if (r3 == 0) goto L_0x0146
            return r1
        L_0x0146:
            boolean r3 = r14.f16704v
            if (r3 == 0) goto L_0x0160
            if (r0 != 0) goto L_0x0160
            com.google.android.gms.internal.ads.zzjl r3 = r14.f16694l
            java.nio.ByteBuffer r3 = r3.zzda
            com.google.android.gms.internal.ads.zzpi.zzp(r3)
            com.google.android.gms.internal.ads.zzjl r3 = r14.f16694l
            java.nio.ByteBuffer r3 = r3.zzda
            int r3 = r3.position()
            if (r3 != 0) goto L_0x015e
            return r4
        L_0x015e:
            r14.f16704v = r1
        L_0x0160:
            com.google.android.gms.internal.ads.zzjl r3 = r14.f16694l     // Catch:{ CryptoException -> 0x01c4 }
            long r10 = r3.zzanz     // Catch:{ CryptoException -> 0x01c4 }
            boolean r3 = r3.zzgk()     // Catch:{ CryptoException -> 0x01c4 }
            if (r3 == 0) goto L_0x0173
            java.util.List<java.lang.Long> r3 = r14.f16697o     // Catch:{ CryptoException -> 0x01c4 }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01c4 }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01c4 }
        L_0x0173:
            com.google.android.gms.internal.ads.zzjl r3 = r14.f16694l     // Catch:{ CryptoException -> 0x01c4 }
            java.nio.ByteBuffer r3 = r3.zzda     // Catch:{ CryptoException -> 0x01c4 }
            r3.flip()     // Catch:{ CryptoException -> 0x01c4 }
            com.google.android.gms.internal.ads.zzjl r3 = r14.f16694l     // Catch:{ CryptoException -> 0x01c4 }
            r14.zza((com.google.android.gms.internal.ads.zzjl) r3)     // Catch:{ CryptoException -> 0x01c4 }
            if (r0 == 0) goto L_0x01a5
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l     // Catch:{ CryptoException -> 0x01c4 }
            com.google.android.gms.internal.ads.zzjh r0 = r0.zzany     // Catch:{ CryptoException -> 0x01c4 }
            android.media.MediaCodec$CryptoInfo r9 = r0.zzgj()     // Catch:{ CryptoException -> 0x01c4 }
            if (r5 != 0) goto L_0x018c
            goto L_0x019b
        L_0x018c:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01c4 }
            if (r0 != 0) goto L_0x0194
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01c4 }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01c4 }
        L_0x0194:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01c4 }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01c4 }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01c4 }
        L_0x019b:
            android.media.MediaCodec r6 = r14.f16702t     // Catch:{ CryptoException -> 0x01c4 }
            int r7 = r14.f16679H     // Catch:{ CryptoException -> 0x01c4 }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01c4 }
            goto L_0x01b6
        L_0x01a5:
            android.media.MediaCodec r6 = r14.f16702t     // Catch:{ CryptoException -> 0x01c4 }
            int r7 = r14.f16679H     // Catch:{ CryptoException -> 0x01c4 }
            r8 = 0
            com.google.android.gms.internal.ads.zzjl r0 = r14.f16694l     // Catch:{ CryptoException -> 0x01c4 }
            java.nio.ByteBuffer r0 = r0.zzda     // Catch:{ CryptoException -> 0x01c4 }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01c4 }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01c4 }
        L_0x01b6:
            r14.f16679H = r2     // Catch:{ CryptoException -> 0x01c4 }
            r14.f16685N = r4     // Catch:{ CryptoException -> 0x01c4 }
            r14.f16683L = r1     // Catch:{ CryptoException -> 0x01c4 }
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbct     // Catch:{ CryptoException -> 0x01c4 }
            int r1 = r0.zzaod     // Catch:{ CryptoException -> 0x01c4 }
            int r1 = r1 + r4
            r0.zzaod = r1     // Catch:{ CryptoException -> 0x01c4 }
            return r4
        L_0x01c4:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x01ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.m9017c():boolean");
    }

    /* renamed from: d */
    private final void m9018d() {
        if (this.f16684M == 2) {
            zzhg();
            zzhd();
            return;
        }
        this.f16688Q = true;
        zzge();
    }

    public boolean isReady() {
        if (this.f16699q == null || this.f16689R) {
            return false;
        }
        if (zzej() || this.f16680I >= 0) {
            return true;
        }
        return this.f16678G != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f16678G;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    public final int zza(zzhp zzhp) {
        try {
            return zza(this.f16691i, zzhp);
        } catch (zzma e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzlx zzlx, zzhp zzhp);

    /* access modifiers changed from: protected */
    public void zza(zzjl zzjl) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzls zzls, MediaCodec mediaCodec, zzhp zzhp, MediaCrypto mediaCrypto);

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzhp zzhp, zzhp zzhp2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzls zzls) {
        return true;
    }

    public final void zzb(long j, long j2) {
        if (this.f16688Q) {
            zzge();
            return;
        }
        if (this.f16699q == null) {
            this.f16695m.clear();
            int zza = zza(this.f16696n, this.f16695m, true);
            if (zza == -5) {
                zzd(this.f16696n.zzahv);
            } else if (zza == -4) {
                zzpc.checkState(this.f16695m.zzgl());
                this.f16687P = true;
                m9018d();
                return;
            } else {
                return;
            }
        }
        zzhd();
        if (this.f16702t != null) {
            zzpq.beginSection("drainAndFeed");
            do {
            } while (m9016b(j, j2));
            do {
            } while (m9017c());
            zzpq.endSection();
        } else {
            zzdp(j);
            this.f16695m.clear();
            int zza2 = zza(this.f16696n, this.f16695m, false);
            if (zza2 == -5) {
                zzd(this.f16696n.zzahv);
            } else if (zza2 == -4) {
                zzpc.checkState(this.f16695m.zzgl());
                this.f16687P = true;
                m9018d();
            }
        }
        this.zzbct.zzgn();
    }

    /* access modifiers changed from: protected */
    public void zzc(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r5.height == r0.height) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzd(com.google.android.gms.internal.ads.zzhp r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzhp r0 = r4.f16699q
            r4.f16699q = r5
            com.google.android.gms.internal.ads.zzjo r5 = r5.zzahd
            r1 = 0
            if (r0 != 0) goto L_0x000b
            r2 = r1
            goto L_0x000d
        L_0x000b:
            com.google.android.gms.internal.ads.zzjo r2 = r0.zzahd
        L_0x000d:
            boolean r5 = com.google.android.gms.internal.ads.zzpt.zza(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzhp r5 = r4.f16699q
            com.google.android.gms.internal.ads.zzjo r5 = r5.zzahd
            if (r5 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzjt<com.google.android.gms.internal.ads.zzjv> r5 = r4.f16692j
            if (r5 == 0) goto L_0x0037
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzhp r3 = r4.f16699q
            com.google.android.gms.internal.ads.zzjo r3 = r3.zzahd
            com.google.android.gms.internal.ads.zzjr r5 = r5.zza(r1, r3)
            r4.f16701s = r5
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r1 = r4.f16700r
            if (r5 != r1) goto L_0x0049
            com.google.android.gms.internal.ads.zzjt<com.google.android.gms.internal.ads.zzjv> r1 = r4.f16692j
            r1.zza(r5)
            goto L_0x0049
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.google.android.gms.internal.ads.zzhe r5 = com.google.android.gms.internal.ads.zzhe.zza(r5, r0)
            throw r5
        L_0x0047:
            r4.f16701s = r1
        L_0x0049:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r5 = r4.f16701s
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r1 = r4.f16700r
            if (r5 != r1) goto L_0x007a
            android.media.MediaCodec r5 = r4.f16702t
            if (r5 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzls r1 = r4.f16703u
            boolean r1 = r1.zzbbc
            com.google.android.gms.internal.ads.zzhp r3 = r4.f16699q
            boolean r5 = r4.zza((android.media.MediaCodec) r5, (boolean) r1, (com.google.android.gms.internal.ads.zzhp) r0, (com.google.android.gms.internal.ads.zzhp) r3)
            if (r5 == 0) goto L_0x007a
            r4.f16682K = r2
            r4.f16683L = r2
            boolean r5 = r4.f16706x
            if (r5 == 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzhp r5 = r4.f16699q
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L_0x0076
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r2 = 0
        L_0x0077:
            r4.f16674C = r2
            return
        L_0x007a:
            boolean r5 = r4.f16685N
            if (r5 == 0) goto L_0x0081
            r4.f16684M = r2
            return
        L_0x0081:
            r4.zzhg()
            r4.zzhd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.zzd(com.google.android.gms.internal.ads.zzhp):void");
    }

    /* access modifiers changed from: protected */
    public void zze(boolean z) {
        this.zzbct = new zzjm();
    }

    public final int zzeg() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzeh() {
        this.f16699q = null;
        try {
            zzhg();
            try {
                zzjr<zzjv> zzjr = this.f16700r;
                if (zzjr != null) {
                    this.f16692j.zza(zzjr);
                }
                try {
                    zzjr<zzjv> zzjr2 = this.f16701s;
                    if (!(zzjr2 == null || zzjr2 == this.f16700r)) {
                        this.f16692j.zza(zzjr2);
                    }
                } finally {
                    this.f16700r = null;
                    this.f16701s = null;
                }
            } catch (Throwable th) {
                zzjr<zzjv> zzjr3 = this.f16701s;
                if (!(zzjr3 == null || zzjr3 == this.f16700r)) {
                    this.f16692j.zza(zzjr3);
                }
                throw th;
            } finally {
                this.f16700r = null;
                this.f16701s = null;
            }
        } catch (Throwable th2) {
            try {
                zzjr<zzjv> zzjr4 = this.f16701s;
                if (!(zzjr4 == null || zzjr4 == this.f16700r)) {
                    this.f16692j.zza(zzjr4);
                }
                throw th2;
            } finally {
                this.f16700r = null;
                this.f16701s = null;
            }
        } finally {
        }
    }

    public boolean zzfe() {
        return this.f16688Q;
    }

    /* access modifiers changed from: protected */
    public void zzge() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0184 A[Catch:{ Exception -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A[Catch:{ Exception -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzhd() {
        /*
            r11 = this;
            android.media.MediaCodec r0 = r11.f16702t
            if (r0 != 0) goto L_0x0205
            com.google.android.gms.internal.ads.zzhp r0 = r11.f16699q
            if (r0 != 0) goto L_0x000a
            goto L_0x0205
        L_0x000a:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r1 = r11.f16701s
            r11.f16700r = r1
            java.lang.String r2 = r0.zzaha
            if (r1 == 0) goto L_0x003c
            int r0 = r1.getState()
            if (r0 == 0) goto L_0x002d
            r1 = 3
            if (r0 == r1) goto L_0x001f
            r1 = 4
            if (r0 == r1) goto L_0x001f
            return
        L_0x001f:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r0 = r11.f16700r
            com.google.android.gms.internal.ads.zzjs r0 = r0.zzgo()
            com.google.android.gms.internal.ads.zzjv r0 = (com.google.android.gms.internal.ads.zzjv) r0
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x002d:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r0 = r11.f16700r
            com.google.android.gms.internal.ads.zzjq r0 = r0.zzgp()
            int r1 = r11.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x003c:
            com.google.android.gms.internal.ads.zzls r1 = r11.f16703u
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzlx r1 = r11.f16691i     // Catch:{ zzma -> 0x005b }
            com.google.android.gms.internal.ads.zzls r0 = r11.zza(r1, r0, r3)     // Catch:{ zzma -> 0x005b }
            r11.f16703u = r0     // Catch:{ zzma -> 0x005b }
            if (r0 == 0) goto L_0x004d
            goto L_0x006a
        L_0x004d:
            com.google.android.gms.internal.ads.zzlu r0 = new com.google.android.gms.internal.ads.zzlu
            com.google.android.gms.internal.ads.zzhp r1 = r11.f16699q
            r4 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>((com.google.android.gms.internal.ads.zzhp) r1, (java.lang.Throwable) r2, (boolean) r3, (int) r4)
            r11.m9015a(r0)
            throw r2
        L_0x005b:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzlu r1 = new com.google.android.gms.internal.ads.zzlu
            com.google.android.gms.internal.ads.zzhp r4 = r11.f16699q
            r5 = -49998(0xffffffffffff3cb2, float:NaN)
            r1.<init>((com.google.android.gms.internal.ads.zzhp) r4, (java.lang.Throwable) r0, (boolean) r3, (int) r5)
            r11.m9015a(r1)
            throw r2
        L_0x006a:
            com.google.android.gms.internal.ads.zzls r0 = r11.f16703u
            boolean r0 = r11.zza((com.google.android.gms.internal.ads.zzls) r0)
            if (r0 != 0) goto L_0x0073
            return
        L_0x0073:
            com.google.android.gms.internal.ads.zzls r0 = r11.f16703u
            java.lang.String r0 = r0.name
            com.google.android.gms.internal.ads.zzhp r1 = r11.f16699q
            int r4 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r5 = 21
            r10 = 1
            if (r4 >= r5) goto L_0x0092
            java.util.List<byte[]> r1 = r1.zzahc
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0092
            r1 = 1
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            r11.f16704v = r1
            r1 = 19
            r6 = 18
            if (r4 < r6) goto L_0x00cc
            if (r4 != r6) goto L_0x00ad
            java.lang.String r7 = "OMX.SEC.avc.dec"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00cc
            java.lang.String r7 = "OMX.SEC.avc.dec.secure"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00cc
        L_0x00ad:
            if (r4 != r1) goto L_0x00ca
            java.lang.String r7 = com.google.android.gms.internal.ads.zzpt.MODEL
            java.lang.String r8 = "SM-G800"
            boolean r7 = r7.startsWith(r8)
            if (r7 == 0) goto L_0x00ca
            java.lang.String r7 = "OMX.Exynos.avc.dec"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00cc
            java.lang.String r7 = "OMX.Exynos.avc.dec.secure"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r7 = 0
            goto L_0x00cd
        L_0x00cc:
            r7 = 1
        L_0x00cd:
            r11.f16705w = r7
            r7 = 24
            if (r4 >= r7) goto L_0x0107
            java.lang.String r7 = "OMX.Nvidia.h264.decode"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00e3
            java.lang.String r7 = "OMX.Nvidia.h264.decode.secure"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0107
        L_0x00e3:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r8 = "flounder"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x0105
            java.lang.String r8 = "flounder_lte"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x0105
            java.lang.String r8 = "grouper"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x0105
            java.lang.String r8 = "tilapia"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0107
        L_0x0105:
            r7 = 1
            goto L_0x0108
        L_0x0107:
            r7 = 0
        L_0x0108:
            r11.f16706x = r7
            r7 = 17
            if (r4 > r7) goto L_0x0120
            java.lang.String r7 = "OMX.rk.video_decoder.avc"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x011e
            java.lang.String r7 = "OMX.allwinner.video.decoder.avc"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0120
        L_0x011e:
            r7 = 1
            goto L_0x0121
        L_0x0120:
            r7 = 0
        L_0x0121:
            r11.f16707y = r7
            r7 = 23
            if (r4 > r7) goto L_0x012f
            java.lang.String r7 = "OMX.google.vorbis.decoder"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x014b
        L_0x012f:
            if (r4 > r1) goto L_0x014d
            java.lang.String r1 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r7 = "hb2000"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x014d
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x014b
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x014d
        L_0x014b:
            r1 = 1
            goto L_0x014e
        L_0x014d:
            r1 = 0
        L_0x014e:
            r11.f16708z = r1
            if (r4 != r5) goto L_0x015c
            java.lang.String r1 = "OMX.google.aac.decoder"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x015c
            r1 = 1
            goto L_0x015d
        L_0x015c:
            r1 = 0
        L_0x015d:
            r11.f16672A = r1
            com.google.android.gms.internal.ads.zzhp r1 = r11.f16699q
            if (r4 > r6) goto L_0x0171
            int r1 = r1.zzahk
            if (r1 != r10) goto L_0x0171
            java.lang.String r1 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0171
            r1 = 1
            goto L_0x0172
        L_0x0171:
            r1 = 0
        L_0x0172:
            r11.f16673B = r1
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01f9 }
            java.lang.String r1 = "createCodec:"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x01f9 }
            int r7 = r6.length()     // Catch:{ Exception -> 0x01f9 }
            if (r7 == 0) goto L_0x0189
            java.lang.String r1 = r1.concat(r6)     // Catch:{ Exception -> 0x01f9 }
            goto L_0x018f
        L_0x0189:
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x01f9 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x01f9 }
            r1 = r6
        L_0x018f:
            com.google.android.gms.internal.ads.zzpq.beginSection(r1)     // Catch:{ Exception -> 0x01f9 }
            android.media.MediaCodec r1 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x01f9 }
            r11.f16702t = r1     // Catch:{ Exception -> 0x01f9 }
            com.google.android.gms.internal.ads.zzpq.endSection()     // Catch:{ Exception -> 0x01f9 }
            java.lang.String r1 = "configureCodec"
            com.google.android.gms.internal.ads.zzpq.beginSection(r1)     // Catch:{ Exception -> 0x01f9 }
            com.google.android.gms.internal.ads.zzls r1 = r11.f16703u     // Catch:{ Exception -> 0x01f9 }
            android.media.MediaCodec r6 = r11.f16702t     // Catch:{ Exception -> 0x01f9 }
            com.google.android.gms.internal.ads.zzhp r7 = r11.f16699q     // Catch:{ Exception -> 0x01f9 }
            r11.zza((com.google.android.gms.internal.ads.zzls) r1, (android.media.MediaCodec) r6, (com.google.android.gms.internal.ads.zzhp) r7, (android.media.MediaCrypto) r2)     // Catch:{ Exception -> 0x01f9 }
            com.google.android.gms.internal.ads.zzpq.endSection()     // Catch:{ Exception -> 0x01f9 }
            java.lang.String r1 = "startCodec"
            com.google.android.gms.internal.ads.zzpq.beginSection(r1)     // Catch:{ Exception -> 0x01f9 }
            android.media.MediaCodec r1 = r11.f16702t     // Catch:{ Exception -> 0x01f9 }
            r1.start()     // Catch:{ Exception -> 0x01f9 }
            com.google.android.gms.internal.ads.zzpq.endSection()     // Catch:{ Exception -> 0x01f9 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01f9 }
            long r8 = r6 - r4
            r4 = r11
            r5 = r0
            r4.zzc(r5, r6, r8)     // Catch:{ Exception -> 0x01f9 }
            android.media.MediaCodec r1 = r11.f16702t     // Catch:{ Exception -> 0x01f9 }
            java.nio.ByteBuffer[] r1 = r1.getInputBuffers()     // Catch:{ Exception -> 0x01f9 }
            r11.f16676E = r1     // Catch:{ Exception -> 0x01f9 }
            android.media.MediaCodec r1 = r11.f16702t     // Catch:{ Exception -> 0x01f9 }
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch:{ Exception -> 0x01f9 }
            r11.f16677F = r1     // Catch:{ Exception -> 0x01f9 }
            int r0 = r11.getState()
            r1 = 2
            if (r0 != r1) goto L_0x01e3
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r2
            goto L_0x01e8
        L_0x01e3:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x01e8:
            r11.f16678G = r0
            r0 = -1
            r11.f16679H = r0
            r11.f16680I = r0
            r11.f16690S = r10
            com.google.android.gms.internal.ads.zzjm r0 = r11.zzbct
            int r1 = r0.zzaob
            int r1 = r1 + r10
            r0.zzaob = r1
            return
        L_0x01f9:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzlu r4 = new com.google.android.gms.internal.ads.zzlu
            com.google.android.gms.internal.ads.zzhp r5 = r11.f16699q
            r4.<init>((com.google.android.gms.internal.ads.zzhp) r5, (java.lang.Throwable) r1, (boolean) r3, (java.lang.String) r0)
            r11.m9015a(r4)
            throw r2
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.zzhd():void");
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzhe() {
        return this.f16702t;
    }

    /* access modifiers changed from: protected */
    public final zzls zzhf() {
        return this.f16703u;
    }

    /* access modifiers changed from: protected */
    public void zzhg() {
        this.f16678G = -9223372036854775807L;
        this.f16679H = -1;
        this.f16680I = -1;
        this.f16689R = false;
        this.f16681J = false;
        this.f16697o.clear();
        this.f16676E = null;
        this.f16677F = null;
        this.f16703u = null;
        this.f16682K = false;
        this.f16685N = false;
        this.f16704v = false;
        this.f16705w = false;
        this.f16706x = false;
        this.f16707y = false;
        this.f16708z = false;
        this.f16673B = false;
        this.f16674C = false;
        this.f16675D = false;
        this.f16686O = false;
        this.f16683L = 0;
        this.f16684M = 0;
        this.f16694l.zzda = null;
        MediaCodec mediaCodec = this.f16702t;
        if (mediaCodec != null) {
            this.zzbct.zzaoc++;
            try {
                mediaCodec.stop();
                try {
                    this.f16702t.release();
                    this.f16702t = null;
                    zzjr<zzjv> zzjr = this.f16700r;
                    if (zzjr != null && this.f16701s != zzjr) {
                        try {
                            this.f16692j.zza(zzjr);
                        } finally {
                            this.f16700r = null;
                        }
                    }
                } catch (Throwable th) {
                    this.f16702t = null;
                    zzjr<zzjv> zzjr2 = this.f16700r;
                    if (!(zzjr2 == null || this.f16701s == zzjr2)) {
                        this.f16692j.zza(zzjr2);
                    }
                    throw th;
                } finally {
                    this.f16700r = null;
                }
            } catch (Throwable th2) {
                this.f16702t = null;
                zzjr<zzjv> zzjr3 = this.f16700r;
                if (!(zzjr3 == null || this.f16701s == zzjr3)) {
                    try {
                        this.f16692j.zza(zzjr3);
                    } finally {
                        this.f16700r = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzls zza(zzlx zzlx, zzhp zzhp, boolean z) {
        return zzlx.zzc(zzhp.zzaha, z);
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) {
        this.f16687P = false;
        this.f16688Q = false;
        if (this.f16702t != null) {
            this.f16678G = -9223372036854775807L;
            this.f16679H = -1;
            this.f16680I = -1;
            this.f16690S = true;
            this.f16689R = false;
            this.f16681J = false;
            this.f16697o.clear();
            this.f16674C = false;
            this.f16675D = false;
            if (this.f16705w || (this.f16708z && this.f16686O)) {
                zzhg();
                zzhd();
            } else if (this.f16684M != 0) {
                zzhg();
                zzhd();
            } else {
                this.f16702t.flush();
                this.f16685N = false;
            }
            if (this.f16682K && this.f16699q != null) {
                this.f16683L = 1;
            }
        }
    }
}
