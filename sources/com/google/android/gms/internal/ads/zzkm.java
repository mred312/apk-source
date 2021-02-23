package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjo;
import com.google.firebase.FirebaseError;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzkm implements zzjw {

    /* renamed from: Z */
    private static final byte[] f16568Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: a0 */
    private static final byte[] f16569a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */

    /* renamed from: b0 */
    public static final UUID f16570b0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: A */
    private long f16571A;

    /* renamed from: B */
    private zzph f16572B;

    /* renamed from: C */
    private zzph f16573C;

    /* renamed from: D */
    private boolean f16574D;

    /* renamed from: E */
    private int f16575E;

    /* renamed from: F */
    private long f16576F;

    /* renamed from: G */
    private long f16577G;

    /* renamed from: H */
    private int f16578H;

    /* renamed from: I */
    private int f16579I;

    /* renamed from: J */
    private int[] f16580J;

    /* renamed from: K */
    private int f16581K;

    /* renamed from: L */
    private int f16582L;

    /* renamed from: M */
    private int f16583M;

    /* renamed from: N */
    private int f16584N;

    /* renamed from: O */
    private boolean f16585O;

    /* renamed from: P */
    private boolean f16586P;

    /* renamed from: Q */
    private boolean f16587Q;

    /* renamed from: R */
    private boolean f16588R;

    /* renamed from: S */
    private byte f16589S;

    /* renamed from: T */
    private int f16590T;

    /* renamed from: U */
    private int f16591U;

    /* renamed from: V */
    private int f16592V;

    /* renamed from: W */
    private boolean f16593W;

    /* renamed from: X */
    private boolean f16594X;

    /* renamed from: Y */
    private zzjy f16595Y;

    /* renamed from: a */
    private final ne0 f16596a;

    /* renamed from: b */
    private final ve0 f16597b;

    /* renamed from: c */
    private final SparseArray<te0> f16598c;

    /* renamed from: d */
    private final boolean f16599d;

    /* renamed from: e */
    private final zzpn f16600e;

    /* renamed from: f */
    private final zzpn f16601f;

    /* renamed from: g */
    private final zzpn f16602g;

    /* renamed from: h */
    private final zzpn f16603h;

    /* renamed from: i */
    private final zzpn f16604i;

    /* renamed from: j */
    private final zzpn f16605j;

    /* renamed from: k */
    private final zzpn f16606k;

    /* renamed from: l */
    private final zzpn f16607l;

    /* renamed from: m */
    private final zzpn f16608m;

    /* renamed from: n */
    private ByteBuffer f16609n;

    /* renamed from: o */
    private long f16610o;

    /* renamed from: p */
    private long f16611p;

    /* renamed from: q */
    private long f16612q;

    /* renamed from: r */
    private long f16613r;

    /* renamed from: s */
    private long f16614s;

    /* renamed from: t */
    private te0 f16615t;

    /* renamed from: u */
    private boolean f16616u;

    /* renamed from: v */
    private int f16617v;

    /* renamed from: w */
    private long f16618w;

    /* renamed from: x */
    private boolean f16619x;

    /* renamed from: y */
    private long f16620y;

    /* renamed from: z */
    private long f16621z;

    public zzkm() {
        this(0);
    }

    /* renamed from: a */
    private final int m8991a(zzjz zzjz, zzkh zzkh, int i) {
        int i2;
        int zzja = this.f16605j.zzja();
        if (zzja > 0) {
            i2 = Math.min(i, zzja);
            zzkh.zza(this.f16605j, i2);
        } else {
            i2 = zzkh.zza(zzjz, i, false);
        }
        this.f16584N += i2;
        this.f16592V += i2;
        return i2;
    }

    /* renamed from: e */
    private final void m8992e(zzjz zzjz, te0 te0, int i) {
        int i2;
        if ("S_TEXT/UTF8".equals(te0.f11189a)) {
            byte[] bArr = f16568Z;
            int length = bArr.length + i;
            if (this.f16606k.capacity() < length) {
                this.f16606k.data = Arrays.copyOf(bArr, length + i);
            }
            zzjz.readFully(this.f16606k.data, bArr.length, i);
            this.f16606k.zzbl(0);
            this.f16606k.zzbk(length);
            return;
        }
        zzkh zzkh = te0.f11187O;
        if (!this.f16585O) {
            if (te0.f11193e) {
                this.f16583M &= -1073741825;
                int i3 = 128;
                if (!this.f16586P) {
                    zzjz.readFully(this.f16602g.data, 0, 1);
                    this.f16584N++;
                    byte[] bArr2 = this.f16602g.data;
                    if ((bArr2[0] & 128) != 128) {
                        this.f16589S = bArr2[0];
                        this.f16586P = true;
                    } else {
                        throw new zzhw("Extension bit is set in signal byte");
                    }
                }
                byte b = this.f16589S;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.f16583M |= 1073741824;
                    if (!this.f16587Q) {
                        zzjz.readFully(this.f16607l.data, 0, 8);
                        this.f16584N += 8;
                        this.f16587Q = true;
                        zzpn zzpn = this.f16602g;
                        byte[] bArr3 = zzpn.data;
                        if (!z) {
                            i3 = 0;
                        }
                        bArr3[0] = (byte) (i3 | 8);
                        zzpn.zzbl(0);
                        zzkh.zza(this.f16602g, 1);
                        this.f16592V++;
                        this.f16607l.zzbl(0);
                        zzkh.zza(this.f16607l, 8);
                        this.f16592V += 8;
                    }
                    if (z) {
                        if (!this.f16588R) {
                            zzjz.readFully(this.f16602g.data, 0, 1);
                            this.f16584N++;
                            this.f16602g.zzbl(0);
                            this.f16590T = this.f16602g.readUnsignedByte();
                            this.f16588R = true;
                        }
                        int i4 = this.f16590T << 2;
                        this.f16602g.reset(i4);
                        zzjz.readFully(this.f16602g.data, 0, i4);
                        this.f16584N += i4;
                        short s = (short) ((this.f16590T / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.f16609n;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.f16609n = ByteBuffer.allocate(i5);
                        }
                        this.f16609n.position(0);
                        this.f16609n.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.f16590T;
                            if (i6 >= i2) {
                                break;
                            }
                            int zzjf = this.f16602g.zzjf();
                            if (i6 % 2 == 0) {
                                this.f16609n.putShort((short) (zzjf - i7));
                            } else {
                                this.f16609n.putInt(zzjf - i7);
                            }
                            i6++;
                            i7 = zzjf;
                        }
                        int i8 = (i - this.f16584N) - i7;
                        if (i2 % 2 == 1) {
                            this.f16609n.putInt(i8);
                        } else {
                            this.f16609n.putShort((short) i8);
                            this.f16609n.putInt(0);
                        }
                        this.f16608m.zzc(this.f16609n.array(), i5);
                        zzkh.zza(this.f16608m, i5);
                        this.f16592V += i5;
                    }
                }
            } else {
                byte[] bArr4 = te0.f11194f;
                if (bArr4 != null) {
                    this.f16605j.zzc(bArr4, bArr4.length);
                }
            }
            this.f16585O = true;
        }
        int limit = i + this.f16605j.limit();
        if (!"V_MPEG4/ISO/AVC".equals(te0.f11189a) && !"V_MPEGH/ISO/HEVC".equals(te0.f11189a)) {
            while (true) {
                int i9 = this.f16584N;
                if (i9 >= limit) {
                    break;
                }
                m8991a(zzjz, zzkh, limit - i9);
            }
        } else {
            byte[] bArr5 = this.f16601f.data;
            bArr5[0] = 0;
            bArr5[1] = 0;
            bArr5[2] = 0;
            int i10 = te0.f11188P;
            int i11 = 4 - i10;
            while (this.f16584N < limit) {
                int i12 = this.f16591U;
                if (i12 == 0) {
                    int min = Math.min(i10, this.f16605j.zzja());
                    zzjz.readFully(bArr5, i11 + min, i10 - min);
                    if (min > 0) {
                        this.f16605j.zze(bArr5, i11, min);
                    }
                    this.f16584N += i10;
                    this.f16601f.zzbl(0);
                    this.f16591U = this.f16601f.zzjf();
                    this.f16600e.zzbl(0);
                    zzkh.zza(this.f16600e, 4);
                    this.f16592V += 4;
                } else {
                    this.f16591U = i12 - m8991a(zzjz, zzkh, i12);
                }
            }
        }
        if ("A_VORBIS".equals(te0.f11189a)) {
            this.f16603h.zzbl(0);
            zzkh.zza(this.f16603h, 4);
            this.f16592V += 4;
        }
    }

    /* renamed from: f */
    private final void m8993f(te0 te0, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(te0.f11189a)) {
            byte[] bArr2 = this.f16606k.data;
            long j2 = this.f16577G;
            if (j2 == -9223372036854775807L) {
                bArr = f16569a0;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzpt.zzbg(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzkh zzkh = te0.f11187O;
            zzpn zzpn = this.f16606k;
            zzkh.zza(zzpn, zzpn.limit());
            this.f16592V += this.f16606k.limit();
        }
        te0.f11187O.zza(j, this.f16583M, this.f16592V, 0, te0.f11195g);
        this.f16593W = true;
        m8999o();
    }

    /* renamed from: g */
    private static int[] m8994g(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }

    /* renamed from: h */
    static int m8995h(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* renamed from: i */
    static boolean m8996i(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    /* renamed from: k */
    private final void m8997k(zzjz zzjz, int i) {
        if (this.f16602g.limit() < i) {
            if (this.f16602g.capacity() < i) {
                zzpn zzpn = this.f16602g;
                byte[] bArr = zzpn.data;
                zzpn.zzc(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i)), this.f16602g.limit());
            }
            zzpn zzpn2 = this.f16602g;
            zzjz.readFully(zzpn2.data, zzpn2.limit(), i - this.f16602g.limit());
            this.f16602g.zzbk(i);
        }
    }

    /* renamed from: n */
    private final long m8998n(long j) {
        long j2 = this.f16612q;
        if (j2 != -9223372036854775807L) {
            return zzpt.zza(j, j2, 1000);
        }
        throw new zzhw("Can't scale timecode prior to timecodeScale being set.");
    }

    /* renamed from: o */
    private final void m8999o() {
        this.f16584N = 0;
        this.f16592V = 0;
        this.f16591U = 0;
        this.f16585O = false;
        this.f16586P = false;
        this.f16588R = false;
        this.f16590T = 0;
        this.f16589S = 0;
        this.f16587Q = false;
        this.f16605j.reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo17991b(int i, double d) {
        if (i == 181) {
            this.f16615t.f11181I = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.f16615t.f11211w = (float) d;
                    return;
                case 21970:
                    this.f16615t.f11212x = (float) d;
                    return;
                case 21971:
                    this.f16615t.f11213y = (float) d;
                    return;
                case 21972:
                    this.f16615t.f11214z = (float) d;
                    return;
                case 21973:
                    this.f16615t.f11173A = (float) d;
                    return;
                case 21974:
                    this.f16615t.f11174B = (float) d;
                    return;
                case 21975:
                    this.f16615t.f11175C = (float) d;
                    return;
                case 21976:
                    this.f16615t.f11176D = (float) d;
                    return;
                case 21977:
                    this.f16615t.f11177E = (float) d;
                    return;
                case 21978:
                    this.f16615t.f11178F = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.f16613r = (long) d;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01ee, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("EBML lacing sample size out of range.");
     */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0240  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo17992c(int r20, int r21, com.google.android.gms.internal.ads.zzjz r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            if (r1 == r4) goto L_0x008b
            if (r1 == r5) goto L_0x008b
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0081
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0072
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0053
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x0049
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0030
            com.google.android.gms.internal.ads.te0 r1 = r0.f16615t
            byte[] r4 = new byte[r2]
            r1.f11203o = r4
            r3.readFully(r4, r6, r2)
            return
        L_0x0030:
            com.google.android.gms.internal.ads.zzhw r2 = new com.google.android.gms.internal.ads.zzhw
            r3 = 26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected id: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x0049:
            com.google.android.gms.internal.ads.te0 r1 = r0.f16615t
            byte[] r4 = new byte[r2]
            r1.f11196h = r4
            r3.readFully(r4, r6, r2)
            return
        L_0x0053:
            com.google.android.gms.internal.ads.zzpn r1 = r0.f16604i
            byte[] r1 = r1.data
            java.util.Arrays.fill(r1, r6)
            com.google.android.gms.internal.ads.zzpn r1 = r0.f16604i
            byte[] r1 = r1.data
            int r4 = 4 - r2
            r3.readFully(r1, r4, r2)
            com.google.android.gms.internal.ads.zzpn r1 = r0.f16604i
            r1.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r1 = r0.f16604i
            long r1 = r1.zzjc()
            int r2 = (int) r1
            r0.f16617v = r2
            return
        L_0x0072:
            byte[] r1 = new byte[r2]
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.te0 r2 = r0.f16615t
            com.google.android.gms.internal.ads.zzkg r3 = new com.google.android.gms.internal.ads.zzkg
            r3.<init>(r7, r1)
            r2.f11195g = r3
            return
        L_0x0081:
            com.google.android.gms.internal.ads.te0 r1 = r0.f16615t
            byte[] r4 = new byte[r2]
            r1.f11194f = r4
            r3.readFully(r4, r6, r2)
            return
        L_0x008b:
            int r4 = r0.f16575E
            r8 = 8
            if (r4 != 0) goto L_0x00b0
            com.google.android.gms.internal.ads.ve0 r4 = r0.f16597b
            long r9 = r4.mo14934b(r3, r6, r7, r8)
            int r4 = (int) r9
            r0.f16581K = r4
            com.google.android.gms.internal.ads.ve0 r4 = r0.f16597b
            int r4 = r4.mo14935e()
            r0.f16582L = r4
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f16577G = r9
            r0.f16575E = r7
            com.google.android.gms.internal.ads.zzpn r4 = r0.f16602g
            r4.reset()
        L_0x00b0:
            android.util.SparseArray<com.google.android.gms.internal.ads.te0> r4 = r0.f16598c
            int r9 = r0.f16581K
            java.lang.Object r4 = r4.get(r9)
            com.google.android.gms.internal.ads.te0 r4 = (com.google.android.gms.internal.ads.te0) r4
            if (r4 != 0) goto L_0x00c6
            int r1 = r0.f16582L
            int r1 = r2 - r1
            r3.zzag(r1)
            r0.f16575E = r6
            return
        L_0x00c6:
            int r9 = r0.f16575E
            if (r9 != r7) goto L_0x026c
            r9 = 3
            r0.m8997k(r3, r9)
            com.google.android.gms.internal.ads.zzpn r10 = r0.f16602g
            byte[] r10 = r10.data
            r11 = 2
            byte r10 = r10[r11]
            r10 = r10 & 6
            int r10 = r10 >> r7
            r12 = 255(0xff, float:3.57E-43)
            if (r10 != 0) goto L_0x00ef
            r0.f16579I = r7
            int[] r10 = r0.f16580J
            int[] r10 = m8994g(r10, r7)
            r0.f16580J = r10
            int r13 = r0.f16582L
            int r2 = r2 - r13
            int r2 = r2 - r9
            r10[r6] = r2
        L_0x00ec:
            r6 = 1
            goto L_0x0202
        L_0x00ef:
            if (r1 != r5) goto L_0x0264
            r13 = 4
            r0.m8997k(r3, r13)
            com.google.android.gms.internal.ads.zzpn r14 = r0.f16602g
            byte[] r14 = r14.data
            byte r14 = r14[r9]
            r14 = r14 & r12
            int r14 = r14 + r7
            r0.f16579I = r14
            int[] r15 = r0.f16580J
            int[] r14 = m8994g(r15, r14)
            r0.f16580J = r14
            if (r10 != r11) goto L_0x0114
            int r9 = r0.f16582L
            int r2 = r2 - r9
            int r2 = r2 - r13
            int r9 = r0.f16579I
            int r2 = r2 / r9
            java.util.Arrays.fill(r14, r6, r9, r2)
            goto L_0x00ec
        L_0x0114:
            if (r10 != r7) goto L_0x014a
            r9 = 0
            r10 = 0
        L_0x0118:
            int r14 = r0.f16579I
            int r15 = r14 + -1
            if (r9 >= r15) goto L_0x013f
            int[] r14 = r0.f16580J
            r14[r9] = r6
        L_0x0122:
            int r13 = r13 + r7
            r0.m8997k(r3, r13)
            com.google.android.gms.internal.ads.zzpn r14 = r0.f16602g
            byte[] r14 = r14.data
            int r15 = r13 + -1
            byte r14 = r14[r15]
            r14 = r14 & r12
            int[] r15 = r0.f16580J
            r16 = r15[r9]
            int r16 = r16 + r14
            r15[r9] = r16
            if (r14 == r12) goto L_0x0122
            r14 = r15[r9]
            int r10 = r10 + r14
            int r9 = r9 + 1
            goto L_0x0118
        L_0x013f:
            int[] r9 = r0.f16580J
            int r14 = r14 - r7
            int r15 = r0.f16582L
            int r2 = r2 - r15
            int r2 = r2 - r13
            int r2 = r2 - r10
            r9[r14] = r2
            goto L_0x00ec
        L_0x014a:
            if (r10 != r9) goto L_0x024b
            r9 = 0
            r10 = 0
        L_0x014e:
            int r14 = r0.f16579I
            int r15 = r14 + -1
            if (r9 >= r15) goto L_0x01f7
            int[] r14 = r0.f16580J
            r14[r9] = r6
            int r13 = r13 + 1
            r0.m8997k(r3, r13)
            com.google.android.gms.internal.ads.zzpn r14 = r0.f16602g
            byte[] r14 = r14.data
            int r15 = r13 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x01ef
            r16 = 0
            r14 = 0
        L_0x016a:
            if (r14 >= r8) goto L_0x01bc
            int r18 = 7 - r14
            int r18 = r7 << r18
            com.google.android.gms.internal.ads.zzpn r5 = r0.f16602g
            byte[] r5 = r5.data
            byte r5 = r5[r15]
            r5 = r5 & r18
            if (r5 == 0) goto L_0x01b2
            int r13 = r13 + r14
            r0.m8997k(r3, r13)
            com.google.android.gms.internal.ads.zzpn r5 = r0.f16602g
            byte[] r5 = r5.data
            int r16 = r15 + 1
            byte r5 = r5[r15]
            r5 = r5 & r12
            r15 = r18 ^ -1
            r5 = r5 & r15
            long r6 = (long) r5
            r5 = r16
        L_0x018d:
            r16 = r6
            if (r5 >= r13) goto L_0x01a4
            long r6 = r16 << r8
            com.google.android.gms.internal.ads.zzpn r15 = r0.f16602g
            byte[] r15 = r15.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r5 = r5 & r12
            long r11 = (long) r5
            long r6 = r6 | r11
            r5 = r16
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x018d
        L_0x01a4:
            if (r9 <= 0) goto L_0x01bc
            int r14 = r14 * 7
            int r14 = r14 + 6
            r5 = 1
            long r11 = r5 << r14
            long r11 = r11 - r5
            long r16 = r16 - r11
            goto L_0x01bc
        L_0x01b2:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x016a
        L_0x01bc:
            r5 = r16
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01e7
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01e7
            int r6 = (int) r5
            int[] r5 = r0.f16580J
            if (r9 != 0) goto L_0x01d2
            goto L_0x01d7
        L_0x01d2:
            int r7 = r9 + -1
            r7 = r5[r7]
            int r6 = r6 + r7
        L_0x01d7:
            r5[r9] = r6
            r5 = r5[r9]
            int r10 = r10 + r5
            int r9 = r9 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x014e
        L_0x01e7:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x01ef:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x01f7:
            int[] r5 = r0.f16580J
            r6 = 1
            int r14 = r14 - r6
            int r7 = r0.f16582L
            int r2 = r2 - r7
            int r2 = r2 - r13
            int r2 = r2 - r10
            r5[r14] = r2
        L_0x0202:
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16602g
            byte[] r2 = r2.data
            r5 = 0
            byte r7 = r2[r5]
            int r5 = r7 << 8
            byte r2 = r2[r6]
            r6 = 255(0xff, float:3.57E-43)
            r2 = r2 & r6
            r2 = r2 | r5
            long r5 = r0.f16571A
            long r9 = (long) r2
            long r9 = r0.m8998n(r9)
            long r5 = r5 + r9
            r0.f16576F = r5
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16602g
            byte[] r2 = r2.data
            r5 = 2
            byte r6 = r2[r5]
            r6 = r6 & r8
            if (r6 != r8) goto L_0x0227
            r6 = 1
            goto L_0x0228
        L_0x0227:
            r6 = 0
        L_0x0228:
            int r7 = r4.f11191c
            if (r7 == r5) goto L_0x023a
            r7 = 163(0xa3, float:2.28E-43)
            if (r1 != r7) goto L_0x0238
            byte r2 = r2[r5]
            r5 = 128(0x80, float:1.794E-43)
            r2 = r2 & r5
            if (r2 != r5) goto L_0x0238
            goto L_0x023a
        L_0x0238:
            r2 = 0
            goto L_0x023b
        L_0x023a:
            r2 = 1
        L_0x023b:
            if (r6 == 0) goto L_0x0240
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0241
        L_0x0240:
            r5 = 0
        L_0x0241:
            r2 = r2 | r5
            r0.f16583M = r2
            r2 = 2
            r0.f16575E = r2
            r2 = 0
            r0.f16578H = r2
            goto L_0x026c
        L_0x024b:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            r2 = 36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected lacing value: "
            r3.append(r2)
            r3.append(r10)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0264:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x026c:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x0297
        L_0x0270:
            int r1 = r0.f16578H
            int r2 = r0.f16579I
            if (r1 >= r2) goto L_0x0293
            int[] r2 = r0.f16580J
            r1 = r2[r1]
            r0.m8992e(r3, r4, r1)
            long r1 = r0.f16576F
            int r5 = r0.f16578H
            int r6 = r4.f11192d
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.m8993f(r4, r1)
            int r1 = r0.f16578H
            r2 = 1
            int r1 = r1 + r2
            r0.f16578H = r1
            goto L_0x0270
        L_0x0293:
            r1 = 0
            r0.f16575E = r1
            return
        L_0x0297:
            r1 = 0
            int[] r2 = r0.f16580J
            r1 = r2[r1]
            r0.m8992e(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkm.mo17992c(int, int, com.google.android.gms.internal.ads.zzjz):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo17993d(int i, String str) {
        if (i == 134) {
            this.f16615t.f11189a = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                String unused = this.f16615t.f11186N = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final void mo17994j(int i) {
        zzkf zzkf;
        zzph zzph;
        zzph zzph2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.f16615t.f11189a;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    te0 te0 = this.f16615t;
                    te0.mo14844c(this.f16595Y, te0.f11190b);
                    SparseArray<te0> sparseArray = this.f16598c;
                    te0 te02 = this.f16615t;
                    sparseArray.put(te02.f11190b, te02);
                }
                this.f16615t = null;
            } else if (i == 19899) {
                int i4 = this.f16617v;
                if (i4 != -1) {
                    long j = this.f16618w;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.f16620y = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zzhw("Mandatory element SeekID or SeekPosition not found");
            } else if (i == 25152) {
                te0 te03 = this.f16615t;
                if (!te03.f11193e) {
                    return;
                }
                if (te03.f11195g != null) {
                    te03.f11197i = new zzjo(new zzjo.zza(zzhb.UUID_NIL, "video/webm", this.f16615t.f11195g.zzaoy));
                    return;
                }
                throw new zzhw("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i == 28032) {
                te0 te04 = this.f16615t;
                if (te04.f11193e && te04.f11194f != null) {
                    throw new zzhw("Combining encryption and compression is not supported");
                }
            } else if (i == 357149030) {
                if (this.f16612q == -9223372036854775807L) {
                    this.f16612q = 1000000;
                }
                long j2 = this.f16613r;
                if (j2 != -9223372036854775807L) {
                    this.f16614s = m8998n(j2);
                }
            } else if (i != 374648427) {
                if (i == 475249515 && !this.f16616u) {
                    zzjy zzjy = this.f16595Y;
                    if (this.f16611p == -1 || this.f16614s == -9223372036854775807L || (zzph = this.f16572B) == null || zzph.size() == 0 || (zzph2 = this.f16573C) == null || zzph2.size() != this.f16572B.size()) {
                        this.f16572B = null;
                        this.f16573C = null;
                        zzkf = new zzke(this.f16614s);
                    } else {
                        int size = this.f16572B.size();
                        int[] iArr = new int[size];
                        long[] jArr = new long[size];
                        long[] jArr2 = new long[size];
                        long[] jArr3 = new long[size];
                        for (int i5 = 0; i5 < size; i5++) {
                            jArr3[i5] = this.f16572B.get(i5);
                            jArr[i5] = this.f16611p + this.f16573C.get(i5);
                        }
                        while (true) {
                            i2 = size - 1;
                            if (i3 >= i2) {
                                break;
                            }
                            int i6 = i3 + 1;
                            iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                            jArr2[i3] = jArr3[i6] - jArr3[i3];
                            i3 = i6;
                        }
                        iArr[i2] = (int) ((this.f16611p + this.f16610o) - jArr[i2]);
                        jArr2[i2] = this.f16614s - jArr3[i2];
                        this.f16572B = null;
                        this.f16573C = null;
                        zzkf = new zzju(iArr, jArr, jArr2, jArr3);
                    }
                    zzjy.zza(zzkf);
                    this.f16616u = true;
                }
            } else if (this.f16598c.size() != 0) {
                this.f16595Y.zzgr();
            } else {
                throw new zzhw("No valid tracks were found");
            }
        } else if (this.f16575E == 2) {
            if (!this.f16594X) {
                this.f16583M |= 1;
            }
            m8993f(this.f16598c.get(this.f16581K), this.f16576F);
            this.f16575E = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final void mo17995l(int i, long j) {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.f16615t.f11191c = (int) j;
                        return;
                    case 136:
                        te0 te0 = this.f16615t;
                        if (j == 1) {
                            z = true;
                        }
                        te0.f11184L = z;
                        return;
                    case 155:
                        this.f16577G = m8998n(j);
                        return;
                    case 159:
                        this.f16615t.f11179G = (int) j;
                        return;
                    case 176:
                        this.f16615t.f11198j = (int) j;
                        return;
                    case 179:
                        this.f16572B.add(m8998n(j));
                        return;
                    case 186:
                        this.f16615t.f11199k = (int) j;
                        return;
                    case 215:
                        this.f16615t.f11190b = (int) j;
                        return;
                    case 231:
                        this.f16571A = m8998n(j);
                        return;
                    case 241:
                        if (!this.f16574D) {
                            this.f16573C.add(j);
                            this.f16574D = true;
                            return;
                        }
                        return;
                    case 251:
                        this.f16594X = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(" not supported");
                            throw new zzhw(sb.toString());
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(" not supported");
                            throw new zzhw(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new zzhw(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new zzhw(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new zzhw(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.f16618w = j + this.f16611p;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.f16615t.f11204p = 0;
                            return;
                        } else if (i2 == 1) {
                            this.f16615t.f11204p = 2;
                            return;
                        } else if (i2 == 3) {
                            this.f16615t.f11204p = 1;
                            return;
                        } else if (i2 == 15) {
                            this.f16615t.f11204p = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.f16615t.f11200l = (int) j;
                        return;
                    case 21682:
                        this.f16615t.f11202n = (int) j;
                        return;
                    case 21690:
                        this.f16615t.f11201m = (int) j;
                        return;
                    case 21930:
                        te0 te02 = this.f16615t;
                        if (j == 1) {
                            z = true;
                        }
                        te02.f11185M = z;
                        return;
                    case 22186:
                        this.f16615t.f11182J = j;
                        return;
                    case 22203:
                        this.f16615t.f11183K = j;
                        return;
                    case 25188:
                        this.f16615t.f11180H = (int) j;
                        return;
                    case 2352003:
                        this.f16615t.f11192d = (int) j;
                        return;
                    case 2807729:
                        this.f16612q = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.f16615t.f11208t = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.f16615t.f11208t = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.f16615t.f11207s = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.f16615t.f11207s = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.f16615t.f11207s = 3;
                                return;
                            case 21947:
                                te0 te03 = this.f16615t;
                                te03.f11205q = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    te03.f11206r = 1;
                                    return;
                                } else if (i5 == 9) {
                                    te03.f11206r = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    te03.f11206r = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.f16615t.f11209u = (int) j;
                                return;
                            case 21949:
                                this.f16615t.f11210v = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzhw(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(" not supported");
            throw new zzhw(sb7.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final void mo17996m(int i, long j, long j2) {
        if (i == 160) {
            this.f16594X = false;
        } else if (i == 174) {
            this.f16615t = new te0((re0) null);
        } else if (i == 187) {
            this.f16574D = false;
        } else if (i == 19899) {
            this.f16617v = -1;
            this.f16618w = -1;
        } else if (i == 20533) {
            this.f16615t.f11193e = true;
        } else if (i == 21968) {
            this.f16615t.f11205q = true;
        } else if (i == 408125543) {
            long j3 = this.f16611p;
            if (j3 == -1 || j3 == j) {
                this.f16611p = j;
                this.f16610o = j2;
                return;
            }
            throw new zzhw("Multiple Segment elements not supported");
        } else if (i == 475249515) {
            this.f16572B = new zzph();
            this.f16573C = new zzph();
        } else if (i != 524531317 || this.f16616u) {
        } else {
            if (!this.f16599d || this.f16620y == -1) {
                this.f16595Y.zza(new zzke(this.f16614s));
                this.f16616u = true;
                return;
            }
            this.f16619x = true;
        }
    }

    public final void release() {
    }

    public final boolean zza(zzjz zzjz) {
        return new se0().mo14795a(zzjz);
    }

    public final void zzc(long j, long j2) {
        this.f16571A = -9223372036854775807L;
        this.f16575E = 0;
        this.f16596a.reset();
        this.f16597b.mo14933a();
        m8999o();
    }

    private zzkm(int i) {
        this(new me0(), 0);
    }

    public final void zza(zzjy zzjy) {
        this.f16595Y = zzjy;
    }

    private zzkm(ne0 ne0, int i) {
        this.f16611p = -1;
        this.f16612q = -9223372036854775807L;
        this.f16613r = -9223372036854775807L;
        this.f16614s = -9223372036854775807L;
        this.f16620y = -1;
        this.f16621z = -1;
        this.f16571A = -9223372036854775807L;
        this.f16596a = ne0;
        ne0.mo14439b(new qe0(this, (re0) null));
        this.f16599d = true;
        this.f16597b = new ve0();
        this.f16598c = new SparseArray<>();
        this.f16602g = new zzpn(4);
        this.f16603h = new zzpn(ByteBuffer.allocate(4).putInt(-1).array());
        this.f16604i = new zzpn(4);
        this.f16600e = new zzpn(zzpi.zzbjq);
        this.f16601f = new zzpn(4);
        this.f16605j = new zzpn();
        this.f16606k = new zzpn();
        this.f16607l = new zzpn(8);
        this.f16608m = new zzpn();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r9, com.google.android.gms.internal.ads.zzkc r10) {
        /*
            r8 = this;
            r0 = 0
            r8.f16593W = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003a
            boolean r3 = r8.f16593W
            if (r3 != 0) goto L_0x003a
            com.google.android.gms.internal.ads.ne0 r2 = r8.f16596a
            boolean r2 = r2.mo14438a(r9)
            if (r2 == 0) goto L_0x0005
            long r3 = r9.getPosition()
            boolean r5 = r8.f16619x
            if (r5 == 0) goto L_0x0025
            r8.f16621z = r3
            long r3 = r8.f16620y
            r10.position = r3
            r8.f16619x = r0
        L_0x0023:
            r3 = 1
            goto L_0x0037
        L_0x0025:
            boolean r3 = r8.f16616u
            if (r3 == 0) goto L_0x0036
            long r3 = r8.f16621z
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            r10.position = r3
            r8.f16621z = r5
            goto L_0x0023
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003a:
            if (r2 == 0) goto L_0x003d
            return r0
        L_0x003d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkm.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }
}
