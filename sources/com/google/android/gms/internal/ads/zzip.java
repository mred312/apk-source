package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.work.WorkRequest;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzip {

    /* renamed from: A */
    private long f16467A;

    /* renamed from: B */
    private boolean f16468B;

    /* renamed from: C */
    private long f16469C;

    /* renamed from: D */
    private Method f16470D;

    /* renamed from: E */
    private int f16471E;

    /* renamed from: F */
    private long f16472F;

    /* renamed from: G */
    private long f16473G;

    /* renamed from: H */
    private int f16474H;

    /* renamed from: I */
    private long f16475I;

    /* renamed from: J */
    private long f16476J;

    /* renamed from: K */
    private int f16477K;

    /* renamed from: L */
    private int f16478L;

    /* renamed from: M */
    private long f16479M;

    /* renamed from: N */
    private long f16480N;

    /* renamed from: O */
    private long f16481O;

    /* renamed from: P */
    private float f16482P;

    /* renamed from: Q */
    private zzif[] f16483Q;

    /* renamed from: R */
    private ByteBuffer[] f16484R;

    /* renamed from: S */
    private ByteBuffer f16485S;

    /* renamed from: T */
    private ByteBuffer f16486T;

    /* renamed from: U */
    private byte[] f16487U;

    /* renamed from: V */
    private int f16488V;

    /* renamed from: W */
    private int f16489W;

    /* renamed from: X */
    private boolean f16490X;

    /* renamed from: Y */
    private boolean f16491Y;

    /* renamed from: Z */
    private int f16492Z;

    /* renamed from: a */
    private final ce0 f16493a;

    /* renamed from: a0 */
    private boolean f16494a0;

    /* renamed from: b */
    private final zzjf f16495b;

    /* renamed from: b0 */
    private boolean f16496b0;

    /* renamed from: c */
    private final zzif[] f16497c;

    /* renamed from: c0 */
    private long f16498c0;

    /* renamed from: d */
    private final zziv f16499d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ConditionVariable f16500e = new ConditionVariable(true);

    /* renamed from: f */
    private final long[] f16501f;

    /* renamed from: g */
    private final xd0 f16502g;

    /* renamed from: h */
    private final LinkedList<ae0> f16503h;

    /* renamed from: i */
    private AudioTrack f16504i;

    /* renamed from: j */
    private int f16505j;

    /* renamed from: k */
    private int f16506k;

    /* renamed from: l */
    private int f16507l;

    /* renamed from: m */
    private int f16508m;

    /* renamed from: n */
    private int f16509n;

    /* renamed from: o */
    private boolean f16510o;

    /* renamed from: p */
    private int f16511p;

    /* renamed from: q */
    private long f16512q;

    /* renamed from: r */
    private zzhv f16513r;

    /* renamed from: s */
    private zzhv f16514s;

    /* renamed from: t */
    private long f16515t;

    /* renamed from: u */
    private long f16516u;

    /* renamed from: v */
    private ByteBuffer f16517v;

    /* renamed from: w */
    private int f16518w;

    /* renamed from: x */
    private int f16519x;

    /* renamed from: y */
    private int f16520y;

    /* renamed from: z */
    private long f16521z;

    public zzip(zzig zzig, zzif[] zzifArr, zziv zziv) {
        this.f16499d = zziv;
        if (zzpt.SDK_INT >= 18) {
            try {
                this.f16470D = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpt.SDK_INT >= 19) {
            this.f16502g = new zd0();
        } else {
            this.f16502g = new xd0((yd0) null);
        }
        ce0 ce0 = new ce0();
        this.f16493a = ce0;
        zzjf zzjf = new zzjf();
        this.f16495b = zzjf;
        zzif[] zzifArr2 = new zzif[(zzifArr.length + 3)];
        this.f16497c = zzifArr2;
        zzifArr2[0] = new ee0();
        zzifArr2[1] = ce0;
        System.arraycopy(zzifArr, 0, zzifArr2, 2, zzifArr.length);
        zzifArr2[zzifArr.length + 2] = zzjf;
        this.f16501f = new long[10];
        this.f16482P = 1.0f;
        this.f16478L = 0;
        this.f16509n = 3;
        this.f16492Z = 0;
        this.f16514s = zzhv.zzahx;
        this.f16489W = -1;
        this.f16483Q = new zzif[0];
        this.f16484R = new ByteBuffer[0];
        this.f16503h = new LinkedList<>();
    }

    /* renamed from: a */
    private final boolean m8967a() {
        return this.f16504i != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0113  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m8969c(java.nio.ByteBuffer r9, long r10) {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.f16486T
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r9) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.google.android.gms.internal.ads.zzpc.checkArgument(r0)
            goto L_0x003b
        L_0x0018:
            r8.f16486T = r9
            int r0 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r0 >= r2) goto L_0x003b
            int r0 = r9.remaining()
            byte[] r4 = r8.f16487U
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r8.f16487U = r4
        L_0x002d:
            int r4 = r9.position()
            byte[] r5 = r8.f16487U
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.f16488V = r3
        L_0x003b:
            int r0 = r9.remaining()
            int r4 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r4 >= r2) goto L_0x0079
            long r10 = r8.f16475I
            com.google.android.gms.internal.ads.xd0 r2 = r8.f16502g
            long r4 = r2.mo15021d()
            int r2 = r8.f16474H
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r11 = (int) r10
            int r10 = r8.f16511p
            int r10 = r10 - r11
            if (r10 <= 0) goto L_0x0076
            int r10 = java.lang.Math.min(r0, r10)
            android.media.AudioTrack r11 = r8.f16504i
            byte[] r2 = r8.f16487U
            int r4 = r8.f16488V
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00f0
            int r11 = r8.f16488V
            int r11 = r11 + r10
            r8.f16488V = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00f0
        L_0x0076:
            r10 = 0
            goto L_0x00f0
        L_0x0079:
            boolean r2 = r8.f16494a0
            if (r2 == 0) goto L_0x00ea
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            com.google.android.gms.internal.ads.zzpc.checkState(r2)
            android.media.AudioTrack r2 = r8.f16504i
            java.nio.ByteBuffer r4 = r8.f16517v
            if (r4 != 0) goto L_0x00a7
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.f16517v = r4
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.f16517v
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00a7:
            int r4 = r8.f16518w
            if (r4 != 0) goto L_0x00c3
            java.nio.ByteBuffer r4 = r8.f16517v
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.f16517v
            r5 = 8
            r6 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r6
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.f16517v
            r10.position(r3)
            r8.f16518w = r0
        L_0x00c3:
            java.nio.ByteBuffer r10 = r8.f16517v
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00da
            java.nio.ByteBuffer r11 = r8.f16517v
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00d7
            r8.f16518w = r3
            r10 = r11
            goto L_0x00f0
        L_0x00d7:
            if (r11 >= r10) goto L_0x00da
            goto L_0x0076
        L_0x00da:
            int r9 = r2.write(r9, r0, r1)
            if (r9 >= 0) goto L_0x00e3
            r8.f16518w = r3
            goto L_0x00e8
        L_0x00e3:
            int r10 = r8.f16518w
            int r10 = r10 - r9
            r8.f16518w = r10
        L_0x00e8:
            r10 = r9
            goto L_0x00f0
        L_0x00ea:
            android.media.AudioTrack r10 = r8.f16504i
            int r10 = r10.write(r9, r0, r1)
        L_0x00f0:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.f16498c0 = r4
            if (r10 < 0) goto L_0x0113
            boolean r9 = r8.f16510o
            if (r9 != 0) goto L_0x0102
            long r4 = r8.f16475I
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.f16475I = r4
        L_0x0102:
            if (r10 != r0) goto L_0x0112
            if (r9 == 0) goto L_0x010e
            long r9 = r8.f16476J
            int r11 = r8.f16477K
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.f16476J = r9
        L_0x010e:
            r9 = 0
            r8.f16486T = r9
            return r1
        L_0x0112:
            return r3
        L_0x0113:
            com.google.android.gms.internal.ads.zzix r9 = new com.google.android.gms.internal.ads.zzix
            r9.<init>(r10)
            goto L_0x011a
        L_0x0119:
            throw r9
        L_0x011a:
            goto L_0x0119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.m8969c(java.nio.ByteBuffer, long):boolean");
    }

    /* renamed from: d */
    private final void m8970d(long j) {
        ByteBuffer byteBuffer;
        int length = this.f16483Q.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.f16484R[i - 1];
            } else {
                byteBuffer = this.f16485S;
                if (byteBuffer == null) {
                    byteBuffer = zzif.zzaiw;
                }
            }
            if (i == length) {
                m8969c(byteBuffer, j);
            } else {
                zzif zzif = this.f16483Q[i];
                zzif.zzn(byteBuffer);
                ByteBuffer zzfm = zzif.zzfm();
                this.f16484R[i] = zzfm;
                if (zzfm.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    private final long m8971e(long j) {
        return (j * 1000000) / ((long) this.f16505j);
    }

    /* renamed from: f */
    private final long m8972f(long j) {
        return (j * ((long) this.f16505j)) / 1000000;
    }

    /* renamed from: g */
    private final void m8973g() {
        ArrayList arrayList = new ArrayList();
        for (zzif zzif : this.f16497c) {
            if (zzif.isActive()) {
                arrayList.add(zzif);
            } else {
                zzif.flush();
            }
        }
        int size = arrayList.size();
        this.f16483Q = (zzif[]) arrayList.toArray(new zzif[size]);
        this.f16484R = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzif zzif2 = this.f16483Q[i];
            zzif2.flush();
            this.f16484R[i] = zzif2.zzfm();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m8974h() {
        /*
            r9 = this;
            int r0 = r9.f16489W
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.f16510o
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzif[] r0 = r9.f16483Q
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.f16489W = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.f16489W
            com.google.android.gms.internal.ads.zzif[] r5 = r9.f16483Q
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzfl()
        L_0x0028:
            r9.m8970d(r7)
            boolean r0 = r4.zzfe()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.f16489W
            int r0 = r0 + r2
            r9.f16489W = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.f16486T
            if (r0 == 0) goto L_0x0044
            r9.m8969c(r0, r7)
            java.nio.ByteBuffer r0 = r9.f16486T
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.f16489W = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.m8974h():boolean");
    }

    /* renamed from: i */
    private final void m8975i() {
        if (!m8967a()) {
            return;
        }
        if (zzpt.SDK_INT >= 21) {
            this.f16504i.setVolume(this.f16482P);
            return;
        }
        AudioTrack audioTrack = this.f16504i;
        float f = this.f16482P;
        audioTrack.setStereoVolume(f, f);
    }

    /* renamed from: j */
    private final long m8976j() {
        return this.f16510o ? this.f16476J : this.f16475I / ((long) this.f16474H);
    }

    /* renamed from: k */
    private final void m8977k() {
        this.f16521z = 0;
        this.f16520y = 0;
        this.f16519x = 0;
        this.f16467A = 0;
        this.f16468B = false;
        this.f16469C = 0;
    }

    /* renamed from: l */
    private final boolean m8978l() {
        if (zzpt.SDK_INT >= 23) {
            return false;
        }
        int i = this.f16508m;
        return i == 5 || i == 6;
    }

    public final void pause() {
        this.f16491Y = false;
        if (m8967a()) {
            m8977k();
            this.f16502g.mo15018a();
        }
    }

    public final void play() {
        this.f16491Y = true;
        if (m8967a()) {
            this.f16480N = System.nanoTime() / 1000;
            this.f16504i.play();
        }
    }

    public final void release() {
        reset();
        for (zzif reset : this.f16497c) {
            reset.reset();
        }
        this.f16492Z = 0;
        this.f16491Y = false;
    }

    public final void reset() {
        if (m8967a()) {
            this.f16472F = 0;
            this.f16473G = 0;
            this.f16475I = 0;
            this.f16476J = 0;
            this.f16477K = 0;
            zzhv zzhv = this.f16513r;
            if (zzhv != null) {
                this.f16514s = zzhv;
                this.f16513r = null;
            } else if (!this.f16503h.isEmpty()) {
                this.f16514s = this.f16503h.getLast().f7807a;
            }
            this.f16503h.clear();
            this.f16515t = 0;
            this.f16516u = 0;
            this.f16485S = null;
            this.f16486T = null;
            int i = 0;
            while (true) {
                zzif[] zzifArr = this.f16483Q;
                if (i >= zzifArr.length) {
                    break;
                }
                zzif zzif = zzifArr[i];
                zzif.flush();
                this.f16484R[i] = zzif.zzfm();
                i++;
            }
            this.f16490X = false;
            this.f16489W = -1;
            this.f16517v = null;
            this.f16518w = 0;
            this.f16478L = 0;
            this.f16481O = 0;
            m8977k();
            if (this.f16504i.getPlayState() == 3) {
                this.f16504i.pause();
            }
            AudioTrack audioTrack = this.f16504i;
            this.f16504i = null;
            this.f16502g.mo15019b((AudioTrack) null, false);
            this.f16500e.close();
            new yd0(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i) {
        if (this.f16509n != i) {
            this.f16509n = i;
            if (!this.f16494a0) {
                reset();
                this.f16492Z = 0;
            }
        }
    }

    public final void setVolume(float f) {
        if (this.f16482P != f) {
            this.f16482P = f;
            m8975i();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0122 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r18, int r19, int r20, int r21, int r22, int[] r23) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r20
            java.lang.String r3 = "audio/raw"
            boolean r3 = r3.equals(r0)
            r4 = 1
            r3 = r3 ^ r4
            r5 = 7
            r6 = 6
            r7 = 3
            r8 = 5
            r9 = 2
            if (r3 == 0) goto L_0x005a
            r18.hashCode()
            r11 = -1
            int r12 = r18.hashCode()
            switch(r12) {
                case -1095064472: goto L_0x0042;
                case 187078296: goto L_0x0037;
                case 1504578661: goto L_0x002c;
                case 1505942594: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x004c
        L_0x0021:
            java.lang.String r12 = "audio/vnd.dts.hd"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x002a
            goto L_0x004c
        L_0x002a:
            r11 = 3
            goto L_0x004c
        L_0x002c:
            java.lang.String r12 = "audio/eac3"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x0035
            goto L_0x004c
        L_0x0035:
            r11 = 2
            goto L_0x004c
        L_0x0037:
            java.lang.String r12 = "audio/ac3"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x0040
            goto L_0x004c
        L_0x0040:
            r11 = 1
            goto L_0x004c
        L_0x0042:
            java.lang.String r12 = "audio/vnd.dts"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r11 = 0
        L_0x004c:
            switch(r11) {
                case 0: goto L_0x0058;
                case 1: goto L_0x0056;
                case 2: goto L_0x0054;
                case 3: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            r0 = 0
            goto L_0x005c
        L_0x0051:
            r0 = 8
            goto L_0x005c
        L_0x0054:
            r0 = 6
            goto L_0x005c
        L_0x0056:
            r0 = 5
            goto L_0x005c
        L_0x0058:
            r0 = 7
            goto L_0x005c
        L_0x005a:
            r0 = r21
        L_0x005c:
            r11 = r19
            if (r3 != 0) goto L_0x009d
            r12 = r21
            int r12 = com.google.android.gms.internal.ads.zzpt.zzg(r12, r11)
            r1.f16471E = r12
            com.google.android.gms.internal.ads.ce0 r12 = r1.f16493a
            r13 = r23
            r12.mo13768a(r13)
            com.google.android.gms.internal.ads.zzif[] r12 = r1.f16497c
            int r13 = r12.length
            r14 = 0
            r15 = 0
        L_0x0074:
            if (r14 >= r13) goto L_0x0097
            r10 = r12[r14]
            boolean r16 = r10.zzb(r2, r11, r0)     // Catch:{ zzii -> 0x008f }
            r15 = r15 | r16
            boolean r16 = r10.isActive()
            if (r16 == 0) goto L_0x008c
            int r11 = r10.zzfj()
            int r0 = r10.zzfk()
        L_0x008c:
            int r14 = r14 + 1
            goto L_0x0074
        L_0x008f:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzit r0 = new com.google.android.gms.internal.ads.zzit
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0097:
            if (r15 == 0) goto L_0x009e
            r17.m8973g()
            goto L_0x009e
        L_0x009d:
            r15 = 0
        L_0x009e:
            switch(r11) {
                case 1: goto L_0x00cf;
                case 2: goto L_0x00cc;
                case 3: goto L_0x00c9;
                case 4: goto L_0x00c6;
                case 5: goto L_0x00c3;
                case 6: goto L_0x00c0;
                case 7: goto L_0x00bd;
                case 8: goto L_0x00ba;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            com.google.android.gms.internal.ads.zzit r0 = new com.google.android.gms.internal.ads.zzit
            r2 = 38
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unsupported channel count: "
            r3.append(r2)
            r3.append(r11)
            java.lang.String r2 = r3.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x00ba:
            int r13 = com.google.android.gms.internal.ads.zzhb.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00d0
        L_0x00bd:
            r13 = 1276(0x4fc, float:1.788E-42)
            goto L_0x00d0
        L_0x00c0:
            r13 = 252(0xfc, float:3.53E-43)
            goto L_0x00d0
        L_0x00c3:
            r13 = 220(0xdc, float:3.08E-43)
            goto L_0x00d0
        L_0x00c6:
            r13 = 204(0xcc, float:2.86E-43)
            goto L_0x00d0
        L_0x00c9:
            r13 = 28
            goto L_0x00d0
        L_0x00cc:
            r13 = 12
            goto L_0x00d0
        L_0x00cf:
            r13 = 4
        L_0x00d0:
            int r14 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r10 = 23
            if (r14 > r10) goto L_0x00f7
            java.lang.String r10 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r12 = "foster"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x00f7
            java.lang.String r10 = com.google.android.gms.internal.ads.zzpt.MANUFACTURER
            java.lang.String r12 = "NVIDIA"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x00f7
            if (r11 == r7) goto L_0x00f4
            if (r11 == r8) goto L_0x00f4
            if (r11 == r5) goto L_0x00f1
            goto L_0x00f7
        L_0x00f1:
            int r10 = com.google.android.gms.internal.ads.zzhb.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00f8
        L_0x00f4:
            r10 = 252(0xfc, float:3.53E-43)
            goto L_0x00f8
        L_0x00f7:
            r10 = r13
        L_0x00f8:
            r5 = 25
            if (r14 > r5) goto L_0x010d
            java.lang.String r5 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r7 = "fugu"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x010d
            if (r3 == 0) goto L_0x010d
            if (r11 != r4) goto L_0x010d
            r12 = 12
            goto L_0x010e
        L_0x010d:
            r12 = r10
        L_0x010e:
            if (r15 != 0) goto L_0x0123
            boolean r5 = r17.m8967a()
            if (r5 == 0) goto L_0x0123
            int r5 = r1.f16507l
            if (r5 != r0) goto L_0x0123
            int r5 = r1.f16505j
            if (r5 != r2) goto L_0x0123
            int r5 = r1.f16506k
            if (r5 != r12) goto L_0x0123
            return
        L_0x0123:
            r17.reset()
            r1.f16507l = r0
            r1.f16510o = r3
            r1.f16505j = r2
            r1.f16506k = r12
            if (r3 == 0) goto L_0x0131
            goto L_0x0132
        L_0x0131:
            r0 = 2
        L_0x0132:
            r1.f16508m = r0
            int r0 = com.google.android.gms.internal.ads.zzpt.zzg(r9, r11)
            r1.f16474H = r0
            if (r3 == 0) goto L_0x014a
            int r0 = r1.f16508m
            if (r0 == r8) goto L_0x0147
            if (r0 != r6) goto L_0x0143
            goto L_0x0147
        L_0x0143:
            r0 = 49152(0xc000, float:6.8877E-41)
            goto L_0x0180
        L_0x0147:
            r0 = 20480(0x5000, float:2.8699E-41)
            goto L_0x0180
        L_0x014a:
            int r0 = r1.f16508m
            int r0 = android.media.AudioTrack.getMinBufferSize(r2, r12, r0)
            r2 = -2
            if (r0 == r2) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r4 = 0
        L_0x0155:
            com.google.android.gms.internal.ads.zzpc.checkState(r4)
            int r2 = r0 << 2
            r4 = 250000(0x3d090, double:1.235164E-318)
            long r4 = r1.m8972f(r4)
            int r5 = (int) r4
            int r4 = r1.f16474H
            int r4 = r4 * r5
            long r5 = (long) r0
            r7 = 750000(0xb71b0, double:3.70549E-318)
            long r7 = r1.m8972f(r7)
            int r0 = r1.f16474H
            long r9 = (long) r0
            long r7 = r7 * r9
            long r5 = java.lang.Math.max(r5, r7)
            int r0 = (int) r5
            if (r2 >= r4) goto L_0x017c
            r0 = r4
            goto L_0x0180
        L_0x017c:
            if (r2 <= r0) goto L_0x017f
            goto L_0x0180
        L_0x017f:
            r0 = r2
        L_0x0180:
            r1.f16511p = r0
            if (r3 == 0) goto L_0x018a
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0192
        L_0x018a:
            int r2 = r1.f16474H
            int r0 = r0 / r2
            long r2 = (long) r0
            long r2 = r1.m8971e(r2)
        L_0x0192:
            r1.f16512q = r2
            com.google.android.gms.internal.ads.zzhv r0 = r1.f16514s
            r1.zzb(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    public final boolean zzb(ByteBuffer byteBuffer, long j) {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        ByteBuffer byteBuffer3 = this.f16485S;
        zzpc.checkArgument(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!m8967a()) {
            this.f16500e.block();
            if (this.f16494a0) {
                this.f16504i = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.f16506k).setEncoding(this.f16508m).setSampleRate(this.f16505j).build(), this.f16511p, 1, this.f16492Z);
            } else if (this.f16492Z == 0) {
                this.f16504i = new AudioTrack(this.f16509n, this.f16505j, this.f16506k, this.f16508m, this.f16511p, 1);
            } else {
                this.f16504i = new AudioTrack(this.f16509n, this.f16505j, this.f16506k, this.f16508m, this.f16511p, 1, this.f16492Z);
            }
            int state = this.f16504i.getState();
            if (state == 1) {
                int audioSessionId = this.f16504i.getAudioSessionId();
                if (this.f16492Z != audioSessionId) {
                    this.f16492Z = audioSessionId;
                    this.f16499d.zzw(audioSessionId);
                }
                this.f16502g.mo15019b(this.f16504i, m8978l());
                m8975i();
                this.f16496b0 = false;
                if (this.f16491Y) {
                    play();
                }
            } else {
                try {
                    this.f16504i.release();
                } catch (Exception unused) {
                } finally {
                    this.f16504i = null;
                }
                throw new zziw(state, this.f16505j, this.f16506k, this.f16511p);
            }
        }
        if (m8978l()) {
            if (this.f16504i.getPlayState() == 2) {
                this.f16496b0 = false;
                return false;
            } else if (this.f16504i.getPlayState() == 1 && this.f16502g.mo15021d() != 0) {
                return false;
            }
        }
        boolean z = this.f16496b0;
        boolean zzfr = zzfr();
        this.f16496b0 = zzfr;
        if (z && !zzfr && this.f16504i.getPlayState() != 1) {
            this.f16499d.zzc(this.f16511p, zzhb.zzdm(this.f16512q), SystemClock.elapsedRealtime() - this.f16498c0);
        }
        if (this.f16485S == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.f16510o && this.f16477K == 0) {
                int i3 = this.f16508m;
                if (i3 == 7 || i3 == 8) {
                    i2 = zziz.zzo(byteBuffer);
                } else if (i3 == 5) {
                    i2 = zzid.zzfi();
                } else if (i3 == 6) {
                    i2 = zzid.zzm(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.f16477K = i2;
            }
            if (this.f16513r != null) {
                if (!m8974h()) {
                    return false;
                }
                LinkedList<ae0> linkedList = this.f16503h;
                ae0 ae0 = r11;
                ae0 ae02 = new ae0(this.f16513r, Math.max(0, j2), m8971e(m8976j()), (yd0) null);
                linkedList.add(ae0);
                this.f16513r = null;
                m8973g();
            }
            if (this.f16478L == 0) {
                this.f16479M = Math.max(0, j2);
                this.f16478L = 1;
            } else {
                long e = this.f16479M + m8971e(this.f16510o ? this.f16473G : this.f16472F / ((long) this.f16471E));
                if (this.f16478L != 1 || Math.abs(e - j2) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(e);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.f16478L = 2;
                }
                if (this.f16478L == i) {
                    this.f16479M += j2 - e;
                    this.f16478L = 1;
                    this.f16499d.zzen();
                }
            }
            if (this.f16510o) {
                this.f16473G += (long) this.f16477K;
            } else {
                this.f16472F += (long) byteBuffer.remaining();
            }
            this.f16485S = byteBuffer2;
        }
        if (this.f16510o) {
            m8969c(this.f16485S, j2);
        } else {
            m8970d(j2);
        }
        if (this.f16485S.hasRemaining()) {
            return false;
        }
        this.f16485S = null;
        return true;
    }

    public final boolean zzfe() {
        if (m8967a()) {
            return this.f16490X && !zzfr();
        }
        return true;
    }

    public final void zzfo() {
        if (this.f16478L == 1) {
            this.f16478L = 2;
        }
    }

    public final void zzfp() {
        if (!this.f16490X && m8967a() && m8974h()) {
            this.f16502g.mo15020c(m8976j());
            this.f16518w = 0;
            this.f16490X = true;
        }
    }

    public final boolean zzfr() {
        if (m8967a()) {
            if (m8976j() <= this.f16502g.mo15021d()) {
                if (m8978l() && this.f16504i.getPlayState() == 2 && this.f16504i.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzhv zzfs() {
        return this.f16514s;
    }

    public final void zzft() {
        if (this.f16494a0) {
            this.f16494a0 = false;
            this.f16492Z = 0;
            reset();
        }
    }

    public final long zzj(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (!(m8967a() && this.f16478L != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.f16504i.getPlayState() == 3) {
            long e = this.f16502g.mo15022e();
            if (e != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.f16467A >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    long[] jArr = this.f16501f;
                    int i = this.f16519x;
                    jArr[i] = e - nanoTime;
                    this.f16519x = (i + 1) % 10;
                    int i2 = this.f16520y;
                    if (i2 < 10) {
                        this.f16520y = i2 + 1;
                    }
                    this.f16467A = nanoTime;
                    this.f16521z = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.f16520y;
                        if (i3 >= i4) {
                            break;
                        }
                        this.f16521z += this.f16501f[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!m8978l() && nanoTime - this.f16469C >= 500000) {
                    boolean f = this.f16502g.mo15023f();
                    this.f16468B = f;
                    if (f) {
                        long g = this.f16502g.mo15024g() / 1000;
                        long h = this.f16502g.mo15025h();
                        if (g < this.f16480N) {
                            this.f16468B = false;
                        } else if (Math.abs(g - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(h);
                            sb.append(", ");
                            sb.append(g);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(e);
                            Log.w("AudioTrack", sb.toString());
                            this.f16468B = false;
                        } else if (Math.abs(m8971e(h) - e) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(h);
                            sb2.append(", ");
                            sb2.append(g);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(e);
                            Log.w("AudioTrack", sb2.toString());
                            this.f16468B = false;
                        }
                    }
                    Method method = this.f16470D;
                    if (method != null && !this.f16510o) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.f16504i, (Object[]) null)).intValue()) * 1000) - this.f16512q;
                            this.f16481O = intValue;
                            long max = Math.max(intValue, 0);
                            this.f16481O = max;
                            if (max > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(max);
                                Log.w("AudioTrack", sb3.toString());
                                this.f16481O = 0;
                            }
                        } catch (Exception unused) {
                            this.f16470D = null;
                        }
                    }
                    this.f16469C = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.f16468B) {
            j = m8971e(this.f16502g.mo15025h() + m8972f(nanoTime2 - (this.f16502g.mo15024g() / 1000)));
        } else {
            if (this.f16520y == 0) {
                j = this.f16502g.mo15022e();
            } else {
                j = nanoTime2 + this.f16521z;
            }
            if (!z) {
                j -= this.f16481O;
            }
        }
        long j5 = this.f16479M;
        while (!this.f16503h.isEmpty() && j >= this.f16503h.getFirst().f7809c) {
            ae0 remove = this.f16503h.remove();
            this.f16514s = remove.f7807a;
            this.f16516u = remove.f7809c;
            this.f16515t = remove.f7808b - this.f16479M;
        }
        if (this.f16514s.zzahy == 1.0f) {
            j2 = (j + this.f16515t) - this.f16516u;
        } else {
            if (!this.f16503h.isEmpty() || this.f16495b.zzgg() < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                j3 = this.f16515t;
                double d = (double) this.f16514s.zzahy;
                double d2 = (double) (j - this.f16516u);
                Double.isNaN(d);
                Double.isNaN(d2);
                j4 = (long) (d * d2);
            } else {
                j3 = this.f16515t;
                j4 = zzpt.zza(j - this.f16516u, this.f16495b.zzgf(), this.f16495b.zzgg());
            }
            j2 = j4 + j3;
        }
        return j5 + j2;
    }

    public final zzhv zzb(zzhv zzhv) {
        if (this.f16510o) {
            zzhv zzhv2 = zzhv.zzahx;
            this.f16514s = zzhv2;
            return zzhv2;
        }
        zzhv zzhv3 = new zzhv(this.f16495b.zza(zzhv.zzahy), this.f16495b.zzb(zzhv.zzahz));
        zzhv zzhv4 = this.f16513r;
        if (zzhv4 == null) {
            if (!this.f16503h.isEmpty()) {
                zzhv4 = this.f16503h.getLast().f7807a;
            } else {
                zzhv4 = this.f16514s;
            }
        }
        if (!zzhv3.equals(zzhv4)) {
            if (m8967a()) {
                this.f16513r = zzhv3;
            } else {
                this.f16514s = zzhv3;
            }
        }
        return this.f16514s;
    }
}
