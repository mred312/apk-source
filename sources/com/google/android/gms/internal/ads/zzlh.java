package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzlh implements zzjw {

    /* renamed from: C */
    private static final int f16622C = zzpt.zzbh("seig");

    /* renamed from: D */
    private static final byte[] f16623D = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: A */
    private zzkh[] f16624A;

    /* renamed from: B */
    private boolean f16625B;

    /* renamed from: a */
    private final int f16626a;

    /* renamed from: b */
    private final SparseArray<hf0> f16627b;

    /* renamed from: c */
    private final zzpn f16628c;

    /* renamed from: d */
    private final zzpn f16629d;

    /* renamed from: e */
    private final zzpn f16630e;

    /* renamed from: f */
    private final zzpn f16631f;

    /* renamed from: g */
    private final zzpn f16632g;

    /* renamed from: h */
    private final byte[] f16633h;

    /* renamed from: i */
    private final Stack<xe0> f16634i;

    /* renamed from: j */
    private final LinkedList<if0> f16635j;

    /* renamed from: k */
    private int f16636k;

    /* renamed from: l */
    private int f16637l;

    /* renamed from: m */
    private long f16638m;

    /* renamed from: n */
    private int f16639n;

    /* renamed from: o */
    private zzpn f16640o;

    /* renamed from: p */
    private long f16641p;

    /* renamed from: q */
    private int f16642q;

    /* renamed from: r */
    private long f16643r;

    /* renamed from: s */
    private long f16644s;

    /* renamed from: t */
    private hf0 f16645t;

    /* renamed from: u */
    private int f16646u;

    /* renamed from: v */
    private int f16647v;

    /* renamed from: w */
    private int f16648w;

    /* renamed from: x */
    private boolean f16649x;

    /* renamed from: y */
    private zzjy f16650y;

    /* renamed from: z */
    private zzkh f16651z;

    public zzlh() {
        this(0);
    }

    /* renamed from: a */
    private static void m9007a(zzpn zzpn, int i, mf0 mf0) {
        zzpn.zzbl(i + 8);
        int b = ue0.m7042b(zzpn.readInt());
        if ((b & 1) == 0) {
            boolean z = (b & 2) != 0;
            int zzjf = zzpn.zzjf();
            if (zzjf == mf0.f9969f) {
                Arrays.fill(mf0.f9977n, 0, zzjf, z);
                mf0.mo14441a(zzpn.zzja());
                zzpn.zze(mf0.f9980q.data, 0, mf0.f9979p);
                mf0.f9980q.zzbl(0);
                mf0.f9981r = false;
                return;
            }
            int i2 = mf0.f9969f;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzjf);
            sb.append(", ");
            sb.append(i2);
            throw new zzhw(sb.toString());
        }
        throw new zzhw("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzjo m9008b(java.util.List<com.google.android.gms.internal.ads.we0> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0008:
            if (r3 >= r0) goto L_0x00b7
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.we0 r5 = (com.google.android.gms.internal.ads.we0) r5
            int r6 = r5.f11418a
            int r7 = com.google.android.gms.internal.ads.ue0.f11362V
            if (r6 != r7) goto L_0x00b3
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzpn r5 = r5.f11705P0
            byte[] r5 = r5.data
            com.google.android.gms.internal.ads.zzpn r6 = new com.google.android.gms.internal.ads.zzpn
            r6.<init>((byte[]) r5)
            int r8 = r6.limit()
            r9 = 32
            if (r8 >= r9) goto L_0x0030
        L_0x002e:
            r6 = r2
            goto L_0x0097
        L_0x0030:
            r6.zzbl(r1)
            int r8 = r6.readInt()
            int r9 = r6.zzja()
            int r9 = r9 + 4
            if (r8 == r9) goto L_0x0040
            goto L_0x002e
        L_0x0040:
            int r8 = r6.readInt()
            if (r8 == r7) goto L_0x0047
            goto L_0x002e
        L_0x0047:
            int r7 = r6.readInt()
            int r7 = com.google.android.gms.internal.ads.ue0.m7041a(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x006b
            r6 = 37
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r6)
            java.lang.String r6 = "Unsupported pssh version: "
            r8.append(r6)
            r8.append(r7)
            java.lang.String r6 = r8.toString()
            java.lang.String r7 = "PsshAtomUtil"
            android.util.Log.w(r7, r6)
            goto L_0x002e
        L_0x006b:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.readLong()
            long r12 = r6.readLong()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x0083
            int r7 = r6.zzjf()
            int r7 = r7 << 4
            r6.zzbm(r7)
        L_0x0083:
            int r7 = r6.zzjf()
            int r8 = r6.zzja()
            if (r7 == r8) goto L_0x008e
            goto L_0x002e
        L_0x008e:
            byte[] r8 = new byte[r7]
            r6.zze(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x0097:
            if (r6 != 0) goto L_0x009b
            r6 = r2
            goto L_0x009f
        L_0x009b:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x009f:
            if (r6 != 0) goto L_0x00a9
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00b3
        L_0x00a9:
            com.google.android.gms.internal.ads.zzjo$zza r7 = new com.google.android.gms.internal.ads.zzjo$zza
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5)
            r4.add(r7)
        L_0x00b3:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00b7:
            if (r4 != 0) goto L_0x00ba
            return r2
        L_0x00ba:
            com.google.android.gms.internal.ads.zzjo r14 = new com.google.android.gms.internal.ads.zzjo
            r14.<init>((java.util.List<com.google.android.gms.internal.ads.zzjo.zza>) r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.m9008b(java.util.List):com.google.android.gms.internal.ads.zzjo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:157:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0647  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m9009c(long r54) {
        /*
            r53 = this;
            r0 = r53
        L_0x0002:
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r1 = r0.f16634i
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x06e6
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r1 = r0.f16634i
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.xe0 r1 = (com.google.android.gms.internal.ads.xe0) r1
            long r1 = r1.f11896P0
            int r3 = (r1 > r54 ? 1 : (r1 == r54 ? 0 : -1))
            if (r3 != 0) goto L_0x06e6
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r1 = r0.f16634i
            java.lang.Object r1 = r1.pop()
            com.google.android.gms.internal.ads.xe0 r1 = (com.google.android.gms.internal.ads.xe0) r1
            int r2 = r1.f11418a
            int r3 = com.google.android.gms.internal.ads.ue0.f11330C
            r4 = 0
            r5 = 12
            r6 = 4
            r7 = 8
            r9 = 1
            if (r2 != r3) goto L_0x01c6
            java.lang.String r2 = "Unexpected moov box."
            com.google.android.gms.internal.ads.zzpc.checkState(r9, r2)
            java.util.List<com.google.android.gms.internal.ads.we0> r2 = r1.f11897Q0
            com.google.android.gms.internal.ads.zzjo r2 = m9008b(r2)
            int r3 = com.google.android.gms.internal.ads.ue0.f11352N
            com.google.android.gms.internal.ads.xe0 r3 = r1.mo15029g(r3)
            android.util.SparseArray r15 = new android.util.SparseArray
            r15.<init>()
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.gms.internal.ads.we0> r12 = r3.f11897Q0
            int r12 = r12.size()
            r16 = r10
            r10 = 0
        L_0x0051:
            if (r10 >= r12) goto L_0x00bc
            java.util.List<com.google.android.gms.internal.ads.we0> r11 = r3.f11897Q0
            java.lang.Object r11 = r11.get(r10)
            com.google.android.gms.internal.ads.we0 r11 = (com.google.android.gms.internal.ads.we0) r11
            int r13 = r11.f11418a
            int r14 = com.google.android.gms.internal.ads.ue0.f11416z
            if (r13 != r14) goto L_0x0098
            com.google.android.gms.internal.ads.zzpn r11 = r11.f11705P0
            r11.zzbl(r5)
            int r13 = r11.readInt()
            int r14 = r11.zzjf()
            int r14 = r14 - r9
            int r5 = r11.zzjf()
            int r8 = r11.zzjf()
            int r11 = r11.readInt()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            com.google.android.gms.internal.ads.ef0 r9 = new com.google.android.gms.internal.ads.ef0
            r9.<init>(r14, r5, r8, r11)
            android.util.Pair r5 = android.util.Pair.create(r13, r9)
            java.lang.Object r8 = r5.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r5 = r5.second
            com.google.android.gms.internal.ads.ef0 r5 = (com.google.android.gms.internal.ads.ef0) r5
            r15.put(r8, r5)
            goto L_0x00b6
        L_0x0098:
            int r5 = com.google.android.gms.internal.ads.ue0.f11354O
            if (r13 != r5) goto L_0x00b6
            com.google.android.gms.internal.ads.zzpn r5 = r11.f11705P0
            r5.zzbl(r7)
            int r8 = r5.readInt()
            int r8 = com.google.android.gms.internal.ads.ue0.m7041a(r8)
            if (r8 != 0) goto L_0x00b0
            long r8 = r5.zzjc()
            goto L_0x00b4
        L_0x00b0:
            long r8 = r5.zzjg()
        L_0x00b4:
            r16 = r8
        L_0x00b6:
            int r10 = r10 + 1
            r5 = 12
            r9 = 1
            goto L_0x0051
        L_0x00bc:
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.List<com.google.android.gms.internal.ads.xe0> r5 = r1.f11898R0
            int r5 = r5.size()
            r8 = 0
        L_0x00c8:
            if (r8 >= r5) goto L_0x00f8
            java.util.List<com.google.android.gms.internal.ads.xe0> r9 = r1.f11898R0
            java.lang.Object r9 = r9.get(r8)
            r10 = r9
            com.google.android.gms.internal.ads.xe0 r10 = (com.google.android.gms.internal.ads.xe0) r10
            int r9 = r10.f11418a
            int r11 = com.google.android.gms.internal.ads.ue0.f11334E
            if (r9 != r11) goto L_0x00f1
            int r9 = com.google.android.gms.internal.ads.ue0.f11332D
            com.google.android.gms.internal.ads.we0 r11 = r1.mo15028f(r9)
            r9 = 0
            r12 = r16
            r14 = r2
            r7 = r15
            r15 = r9
            com.google.android.gms.internal.ads.zzlo r9 = com.google.android.gms.internal.ads.ze0.m7407b(r10, r11, r12, r14, r15)
            if (r9 == 0) goto L_0x00f2
            int r10 = r9.f16668id
            r3.put(r10, r9)
            goto L_0x00f2
        L_0x00f1:
            r7 = r15
        L_0x00f2:
            int r8 = r8 + 1
            r15 = r7
            r7 = 8
            goto L_0x00c8
        L_0x00f8:
            r7 = r15
            int r1 = r3.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0197
            r2 = 0
        L_0x0106:
            if (r2 >= r1) goto L_0x013a
            java.lang.Object r5 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzlo r5 = (com.google.android.gms.internal.ads.zzlo) r5
            com.google.android.gms.internal.ads.hf0 r8 = new com.google.android.gms.internal.ads.hf0
            com.google.android.gms.internal.ads.zzjy r9 = r0.f16650y
            int r10 = r5.type
            com.google.android.gms.internal.ads.zzkh r9 = r9.zzc(r2, r10)
            r8.<init>(r9)
            int r9 = r5.f16668id
            java.lang.Object r9 = r7.get(r9)
            com.google.android.gms.internal.ads.ef0 r9 = (com.google.android.gms.internal.ads.ef0) r9
            r8.mo14205b(r5, r9)
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r9 = r0.f16627b
            int r10 = r5.f16668id
            r9.put(r10, r8)
            long r8 = r0.f16643r
            long r10 = r5.zzaif
            long r8 = java.lang.Math.max(r8, r10)
            r0.f16643r = r8
            int r2 = r2 + 1
            goto L_0x0106
        L_0x013a:
            int r1 = r0.f16626a
            r1 = r1 & r6
            if (r1 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzkh r1 = r0.f16651z
            if (r1 != 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzjy r1 = r0.f16650y
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r2 = r2.size()
            com.google.android.gms.internal.ads.zzkh r1 = r1.zzc(r2, r6)
            r0.f16651z = r1
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.String r5 = "application/x-emsg"
            com.google.android.gms.internal.ads.zzhp r2 = com.google.android.gms.internal.ads.zzhp.zza(r4, r5, r2)
            r1.zze(r2)
        L_0x015f:
            int r1 = r0.f16626a
            r2 = 8
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0190
            com.google.android.gms.internal.ads.zzkh[] r1 = r0.f16624A
            if (r1 != 0) goto L_0x0190
            com.google.android.gms.internal.ads.zzjy r1 = r0.f16650y
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 + r3
            r3 = 3
            com.google.android.gms.internal.ads.zzkh r1 = r1.zzc(r2, r3)
            r2 = 0
            r4 = 0
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r3 = "application/cea-608"
            com.google.android.gms.internal.ads.zzhp r2 = com.google.android.gms.internal.ads.zzhp.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (int) r6, (java.lang.String) r7, (com.google.android.gms.internal.ads.zzjo) r8)
            r1.zze(r2)
            r2 = 1
            com.google.android.gms.internal.ads.zzkh[] r2 = new com.google.android.gms.internal.ads.zzkh[r2]
            r3 = 0
            r2[r3] = r1
            r0.f16624A = r2
        L_0x0190:
            com.google.android.gms.internal.ads.zzjy r1 = r0.f16650y
            r1.zzgr()
            goto L_0x0002
        L_0x0197:
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r2 = r2.size()
            if (r2 != r1) goto L_0x01a1
            r9 = 1
            goto L_0x01a2
        L_0x01a1:
            r9 = 0
        L_0x01a2:
            com.google.android.gms.internal.ads.zzpc.checkState(r9)
            r8 = 0
        L_0x01a6:
            if (r8 >= r1) goto L_0x0002
            java.lang.Object r2 = r3.valueAt(r8)
            com.google.android.gms.internal.ads.zzlo r2 = (com.google.android.gms.internal.ads.zzlo) r2
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r4 = r0.f16627b
            int r5 = r2.f16668id
            java.lang.Object r4 = r4.get(r5)
            com.google.android.gms.internal.ads.hf0 r4 = (com.google.android.gms.internal.ads.hf0) r4
            int r5 = r2.f16668id
            java.lang.Object r5 = r7.get(r5)
            com.google.android.gms.internal.ads.ef0 r5 = (com.google.android.gms.internal.ads.ef0) r5
            r4.mo14205b(r2, r5)
            int r8 = r8 + 1
            goto L_0x01a6
        L_0x01c6:
            int r3 = com.google.android.gms.internal.ads.ue0.f11348L
            if (r2 != r3) goto L_0x06cf
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r3 = r0.f16626a
            byte[] r5 = r0.f16633h
            java.util.List<com.google.android.gms.internal.ads.xe0> r7 = r1.f11898R0
            int r7 = r7.size()
            r8 = 0
        L_0x01d7:
            if (r8 >= r7) goto L_0x06a3
            java.util.List<com.google.android.gms.internal.ads.xe0> r9 = r1.f11898R0
            java.lang.Object r9 = r9.get(r8)
            com.google.android.gms.internal.ads.xe0 r9 = (com.google.android.gms.internal.ads.xe0) r9
            int r10 = r9.f11418a
            int r11 = com.google.android.gms.internal.ads.ue0.f11350M
            if (r10 != r11) goto L_0x0682
            int r10 = com.google.android.gms.internal.ads.ue0.f11414y
            com.google.android.gms.internal.ads.we0 r10 = r9.mo15028f(r10)
            com.google.android.gms.internal.ads.zzpn r10 = r10.f11705P0
            r11 = 8
            r10.zzbl(r11)
            int r11 = r10.readInt()
            int r11 = com.google.android.gms.internal.ads.ue0.m7042b(r11)
            int r12 = r10.readInt()
            r13 = r3 & 16
            if (r13 != 0) goto L_0x0205
            goto L_0x0206
        L_0x0205:
            r12 = 0
        L_0x0206:
            java.lang.Object r12 = r2.get(r12)
            com.google.android.gms.internal.ads.hf0 r12 = (com.google.android.gms.internal.ads.hf0) r12
            if (r12 != 0) goto L_0x0210
            r12 = r4
            goto L_0x0259
        L_0x0210:
            r13 = r11 & 1
            if (r13 == 0) goto L_0x021e
            long r13 = r10.zzjg()
            com.google.android.gms.internal.ads.mf0 r15 = r12.f9190a
            r15.f9966c = r13
            r15.f9967d = r13
        L_0x021e:
            com.google.android.gms.internal.ads.ef0 r13 = r12.f9193d
            r14 = r11 & 2
            if (r14 == 0) goto L_0x022b
            int r14 = r10.zzjf()
            r15 = 1
            int r14 = r14 - r15
            goto L_0x022d
        L_0x022b:
            int r14 = r13.f8355a
        L_0x022d:
            r15 = r11 & 8
            if (r15 == 0) goto L_0x0236
            int r15 = r10.zzjf()
            goto L_0x0238
        L_0x0236:
            int r15 = r13.f8356b
        L_0x0238:
            r16 = r11 & 16
            if (r16 == 0) goto L_0x0243
            int r16 = r10.zzjf()
            r4 = r16
            goto L_0x0245
        L_0x0243:
            int r4 = r13.f8357c
        L_0x0245:
            r11 = r11 & 32
            if (r11 == 0) goto L_0x024e
            int r10 = r10.zzjf()
            goto L_0x0250
        L_0x024e:
            int r10 = r13.f8358d
        L_0x0250:
            com.google.android.gms.internal.ads.mf0 r11 = r12.f9190a
            com.google.android.gms.internal.ads.ef0 r13 = new com.google.android.gms.internal.ads.ef0
            r13.<init>(r14, r15, r4, r10)
            r11.f9964a = r13
        L_0x0259:
            if (r12 == 0) goto L_0x0682
            com.google.android.gms.internal.ads.mf0 r4 = r12.f9190a
            long r10 = r4.f9982s
            r12.mo14204a()
            int r13 = com.google.android.gms.internal.ads.ue0.f11412x
            com.google.android.gms.internal.ads.we0 r14 = r9.mo15028f(r13)
            if (r14 == 0) goto L_0x028d
            r14 = r3 & 2
            if (r14 != 0) goto L_0x028d
            com.google.android.gms.internal.ads.we0 r10 = r9.mo15028f(r13)
            com.google.android.gms.internal.ads.zzpn r10 = r10.f11705P0
            r11 = 8
            r10.zzbl(r11)
            int r11 = r10.readInt()
            int r11 = com.google.android.gms.internal.ads.ue0.m7041a(r11)
            r13 = 1
            if (r11 != r13) goto L_0x0289
            long r10 = r10.zzjg()
            goto L_0x028d
        L_0x0289:
            long r10 = r10.zzjc()
        L_0x028d:
            java.util.List<com.google.android.gms.internal.ads.we0> r13 = r9.f11897Q0
            int r14 = r13.size()
            r19 = r2
            r2 = 0
            r6 = 0
            r15 = 0
        L_0x0298:
            if (r15 >= r14) goto L_0x02c6
            java.lang.Object r20 = r13.get(r15)
            r21 = r7
            r7 = r20
            com.google.android.gms.internal.ads.we0 r7 = (com.google.android.gms.internal.ads.we0) r7
            r22 = r10
            int r10 = r7.f11418a
            int r11 = com.google.android.gms.internal.ads.ue0.f11326A
            if (r10 != r11) goto L_0x02bd
            com.google.android.gms.internal.ads.zzpn r7 = r7.f11705P0
            r10 = 12
            r7.zzbl(r10)
            int r7 = r7.zzjf()
            if (r7 <= 0) goto L_0x02bf
            int r2 = r2 + r7
            int r6 = r6 + 1
            goto L_0x02bf
        L_0x02bd:
            r10 = 12
        L_0x02bf:
            int r15 = r15 + 1
            r7 = r21
            r10 = r22
            goto L_0x0298
        L_0x02c6:
            r21 = r7
            r22 = r10
            r7 = 0
            r10 = 12
            r12.f9196g = r7
            r12.f9195f = r7
            r12.f9194e = r7
            com.google.android.gms.internal.ads.mf0 r7 = r12.f9190a
            r7.f9968e = r6
            r7.f9969f = r2
            int[] r11 = r7.f9971h
            if (r11 == 0) goto L_0x02e0
            int r11 = r11.length
            if (r11 >= r6) goto L_0x02e8
        L_0x02e0:
            long[] r11 = new long[r6]
            r7.f9970g = r11
            int[] r6 = new int[r6]
            r7.f9971h = r6
        L_0x02e8:
            int[] r6 = r7.f9972i
            if (r6 == 0) goto L_0x02ef
            int r6 = r6.length
            if (r6 >= r2) goto L_0x0307
        L_0x02ef:
            int r2 = r2 * 125
            int r2 = r2 / 100
            int[] r6 = new int[r2]
            r7.f9972i = r6
            int[] r6 = new int[r2]
            r7.f9973j = r6
            long[] r6 = new long[r2]
            r7.f9974k = r6
            boolean[] r6 = new boolean[r2]
            r7.f9975l = r6
            boolean[] r2 = new boolean[r2]
            r7.f9977n = r2
        L_0x0307:
            r2 = 0
            r6 = 0
            r7 = 0
        L_0x030a:
            r24 = 0
            if (r2 >= r14) goto L_0x04a2
            java.lang.Object r18 = r13.get(r2)
            r10 = r18
            com.google.android.gms.internal.ads.we0 r10 = (com.google.android.gms.internal.ads.we0) r10
            int r15 = r10.f11418a
            int r11 = com.google.android.gms.internal.ads.ue0.f11326A
            if (r15 != r11) goto L_0x0473
            int r11 = r6 + 1
            com.google.android.gms.internal.ads.zzpn r10 = r10.f11705P0
            r15 = 8
            r10.zzbl(r15)
            int r15 = r10.readInt()
            int r15 = com.google.android.gms.internal.ads.ue0.m7042b(r15)
            r27 = r11
            com.google.android.gms.internal.ads.zzlo r11 = r12.f9192c
            r28 = r13
            com.google.android.gms.internal.ads.mf0 r13 = r12.f9190a
            r29 = r14
            com.google.android.gms.internal.ads.ef0 r14 = r13.f9964a
            int[] r0 = r13.f9971h
            int r30 = r10.zzjf()
            r0[r6] = r30
            long[] r0 = r13.f9970g
            r31 = r4
            r30 = r5
            long r4 = r13.f9966c
            r0[r6] = r4
            r4 = r15 & 1
            if (r4 == 0) goto L_0x0360
            r4 = r0[r6]
            r32 = r1
            int r1 = r10.readInt()
            r33 = r8
            r34 = r9
            long r8 = (long) r1
            long r4 = r4 + r8
            r0[r6] = r4
            goto L_0x0366
        L_0x0360:
            r32 = r1
            r33 = r8
            r34 = r9
        L_0x0366:
            r0 = r15 & 4
            if (r0 == 0) goto L_0x036c
            r0 = 1
            goto L_0x036d
        L_0x036c:
            r0 = 0
        L_0x036d:
            int r1 = r14.f8358d
            if (r0 == 0) goto L_0x0375
            int r1 = r10.zzjf()
        L_0x0375:
            r4 = r15 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x037b
            r4 = 1
            goto L_0x037c
        L_0x037b:
            r4 = 0
        L_0x037c:
            r5 = r15 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0382
            r5 = 1
            goto L_0x0383
        L_0x0382:
            r5 = 0
        L_0x0383:
            r8 = r15 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x0389
            r8 = 1
            goto L_0x038a
        L_0x0389:
            r8 = 0
        L_0x038a:
            r9 = r15 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x0390
            r9 = 1
            goto L_0x0391
        L_0x0390:
            r9 = 0
        L_0x0391:
            long[] r15 = r11.zzbae
            r35 = r1
            if (r15 == 0) goto L_0x03b4
            int r1 = r15.length
            r36 = r12
            r12 = 1
            if (r1 != r12) goto L_0x03b6
            r1 = 0
            r37 = r15[r1]
            int r12 = (r37 > r24 ? 1 : (r37 == r24 ? 0 : -1))
            if (r12 != 0) goto L_0x03b6
            long[] r12 = r11.zzbaf
            r37 = r12[r1]
            r39 = 1000(0x3e8, double:4.94E-321)
            r12 = r2
            long r1 = r11.zzdd
            r41 = r1
            long r24 = com.google.android.gms.internal.ads.zzpt.zza((long) r37, (long) r39, (long) r41)
            goto L_0x03b7
        L_0x03b4:
            r36 = r12
        L_0x03b6:
            r12 = r2
        L_0x03b7:
            int[] r1 = r13.f9972i
            int[] r2 = r13.f9973j
            long[] r15 = r13.f9974k
            r37 = r12
            boolean[] r12 = r13.f9975l
            r38 = r12
            int r12 = r11.type
            r39 = r1
            r1 = 2
            if (r12 != r1) goto L_0x03d0
            r1 = r3 & 1
            if (r1 == 0) goto L_0x03d0
            r1 = 1
            goto L_0x03d1
        L_0x03d0:
            r1 = 0
        L_0x03d1:
            int[] r12 = r13.f9971h
            r12 = r12[r6]
            int r12 = r12 + r7
            r46 = r1
            r26 = r2
            long r1 = r11.zzdd
            r11 = r7
            if (r6 <= 0) goto L_0x03e2
            long r6 = r13.f9982s
            goto L_0x03e4
        L_0x03e2:
            r6 = r22
        L_0x03e4:
            if (r11 >= r12) goto L_0x046b
            if (r4 == 0) goto L_0x03f1
            int r40 = r10.zzjf()
            r47 = r3
            r3 = r40
            goto L_0x03f5
        L_0x03f1:
            r47 = r3
            int r3 = r14.f8356b
        L_0x03f5:
            if (r5 == 0) goto L_0x0400
            int r40 = r10.zzjf()
            r48 = r4
            r4 = r40
            goto L_0x0404
        L_0x0400:
            r48 = r4
            int r4 = r14.f8357c
        L_0x0404:
            if (r11 != 0) goto L_0x040d
            if (r0 == 0) goto L_0x040d
            r49 = r0
            r0 = r35
            goto L_0x041c
        L_0x040d:
            if (r8 == 0) goto L_0x0418
            int r40 = r10.readInt()
            r49 = r0
            r0 = r40
            goto L_0x041c
        L_0x0418:
            r49 = r0
            int r0 = r14.f8358d
        L_0x041c:
            if (r9 == 0) goto L_0x0430
            r50 = r5
            int r5 = r10.readInt()
            int r5 = r5 * 1000
            r51 = r8
            r52 = r9
            long r8 = (long) r5
            long r8 = r8 / r1
            int r5 = (int) r8
            r26[r11] = r5
            goto L_0x0439
        L_0x0430:
            r50 = r5
            r51 = r8
            r52 = r9
            r5 = 0
            r26[r11] = r5
        L_0x0439:
            r42 = 1000(0x3e8, double:4.94E-321)
            r40 = r6
            r44 = r1
            long r8 = com.google.android.gms.internal.ads.zzpt.zza((long) r40, (long) r42, (long) r44)
            long r8 = r8 - r24
            r15[r11] = r8
            r39[r11] = r4
            r4 = 16
            int r0 = r0 >> r4
            r4 = 1
            r0 = r0 & r4
            if (r0 != 0) goto L_0x0456
            if (r46 == 0) goto L_0x0454
            if (r11 != 0) goto L_0x0456
        L_0x0454:
            r0 = 1
            goto L_0x0457
        L_0x0456:
            r0 = 0
        L_0x0457:
            r38[r11] = r0
            long r3 = (long) r3
            long r6 = r6 + r3
            int r11 = r11 + 1
            r3 = r47
            r4 = r48
            r0 = r49
            r5 = r50
            r8 = r51
            r9 = r52
            goto L_0x03e4
        L_0x046b:
            r47 = r3
            r13.f9982s = r6
            r7 = r12
            r6 = r27
            goto L_0x0488
        L_0x0473:
            r32 = r1
            r37 = r2
            r47 = r3
            r31 = r4
            r30 = r5
            r11 = r7
            r33 = r8
            r34 = r9
            r36 = r12
            r28 = r13
            r29 = r14
        L_0x0488:
            int r2 = r37 + 1
            r0 = r53
            r13 = r28
            r14 = r29
            r5 = r30
            r4 = r31
            r1 = r32
            r8 = r33
            r9 = r34
            r12 = r36
            r3 = r47
            r10 = 12
            goto L_0x030a
        L_0x04a2:
            r32 = r1
            r47 = r3
            r31 = r4
            r30 = r5
            r33 = r8
            r34 = r9
            r36 = r12
            int r0 = com.google.android.gms.internal.ads.ue0.f11373d0
            com.google.android.gms.internal.ads.we0 r0 = r9.mo15028f(r0)
            if (r0 == 0) goto L_0x0537
            r4 = r36
            com.google.android.gms.internal.ads.zzlo r1 = r4.f9192c
            com.google.android.gms.internal.ads.zzlr[] r1 = r1.zzbad
            r2 = r31
            com.google.android.gms.internal.ads.ef0 r3 = r2.f9964a
            int r3 = r3.f8355a
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzpn r0 = r0.f11705P0
            int r1 = r1.zzbba
            r3 = 8
            r0.zzbl(r3)
            int r4 = r0.readInt()
            int r4 = com.google.android.gms.internal.ads.ue0.m7042b(r4)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x04de
            r0.zzbm(r3)
        L_0x04de:
            int r3 = r0.readUnsignedByte()
            int r4 = r0.zzjf()
            int r5 = r2.f9969f
            if (r4 != r5) goto L_0x0514
            if (r3 != 0) goto L_0x0501
            boolean[] r3 = r2.f9977n
            r5 = 0
            r6 = 0
        L_0x04f0:
            if (r5 >= r4) goto L_0x0510
            int r7 = r0.readUnsignedByte()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x04fb
            r7 = 1
            goto L_0x04fc
        L_0x04fb:
            r7 = 0
        L_0x04fc:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x04f0
        L_0x0501:
            if (r3 <= r1) goto L_0x0505
            r0 = 1
            goto L_0x0506
        L_0x0505:
            r0 = 0
        L_0x0506:
            int r3 = r3 * r4
            r1 = 0
            int r6 = r3 + 0
            boolean[] r3 = r2.f9977n
            java.util.Arrays.fill(r3, r1, r4, r0)
        L_0x0510:
            r2.mo14441a(r6)
            goto L_0x0539
        L_0x0514:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            int r1 = r2.f9969f
            r2 = 41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Length mismatch: "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ", "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0537:
            r2 = r31
        L_0x0539:
            int r0 = com.google.android.gms.internal.ads.ue0.f11375e0
            com.google.android.gms.internal.ads.we0 r0 = r9.mo15028f(r0)
            if (r0 == 0) goto L_0x058b
            com.google.android.gms.internal.ads.zzpn r0 = r0.f11705P0
            r1 = 8
            r0.zzbl(r1)
            int r3 = r0.readInt()
            int r4 = com.google.android.gms.internal.ads.ue0.m7042b(r3)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0557
            r0.zzbm(r1)
        L_0x0557:
            int r1 = r0.zzjf()
            if (r1 != r5) goto L_0x0572
            int r1 = com.google.android.gms.internal.ads.ue0.m7041a(r3)
            long r3 = r2.f9967d
            if (r1 != 0) goto L_0x056a
            long r0 = r0.zzjc()
            goto L_0x056e
        L_0x056a:
            long r0 = r0.zzjg()
        L_0x056e:
            long r3 = r3 + r0
            r2.f9967d = r3
            goto L_0x058b
        L_0x0572:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            r2 = 40
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected saio entry count: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x058b:
            int r0 = com.google.android.gms.internal.ads.ue0.f11383i0
            com.google.android.gms.internal.ads.we0 r0 = r9.mo15028f(r0)
            if (r0 == 0) goto L_0x0599
            com.google.android.gms.internal.ads.zzpn r0 = r0.f11705P0
            r1 = 0
            m9007a(r0, r1, r2)
        L_0x0599:
            int r0 = com.google.android.gms.internal.ads.ue0.f11377f0
            com.google.android.gms.internal.ads.we0 r0 = r9.mo15028f(r0)
            int r1 = com.google.android.gms.internal.ads.ue0.f11379g0
            com.google.android.gms.internal.ads.we0 r1 = r9.mo15028f(r1)
            if (r0 == 0) goto L_0x063c
            if (r1 == 0) goto L_0x063c
            com.google.android.gms.internal.ads.zzpn r0 = r0.f11705P0
            com.google.android.gms.internal.ads.zzpn r1 = r1.f11705P0
            r3 = 8
            r0.zzbl(r3)
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            int r5 = f16622C
            if (r4 != r5) goto L_0x063c
            int r3 = com.google.android.gms.internal.ads.ue0.m7041a(r3)
            r4 = 1
            if (r3 != r4) goto L_0x05c9
            r3 = 4
            r0.zzbm(r3)
        L_0x05c9:
            int r0 = r0.readInt()
            if (r0 != r4) goto L_0x0634
            r0 = 8
            r1.zzbl(r0)
            int r0 = r1.readInt()
            int r3 = r1.readInt()
            if (r3 != r5) goto L_0x0632
            int r0 = com.google.android.gms.internal.ads.ue0.m7041a(r0)
            if (r0 != r4) goto L_0x05f7
            long r3 = r1.zzjc()
            int r0 = (r3 > r24 ? 1 : (r3 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x05ef
            r0 = 4
            r3 = 2
            goto L_0x0600
        L_0x05ef:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>(r1)
            throw r0
        L_0x05f7:
            r3 = 2
            if (r0 < r3) goto L_0x05ff
            r0 = 4
            r1.zzbm(r0)
            goto L_0x0600
        L_0x05ff:
            r0 = 4
        L_0x0600:
            long r4 = r1.zzjc()
            r6 = 1
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x062a
            r1.zzbm(r3)
            int r3 = r1.readUnsignedByte()
            r4 = 1
            if (r3 != r4) goto L_0x063e
            int r3 = r1.readUnsignedByte()
            r5 = 16
            byte[] r6 = new byte[r5]
            r7 = 0
            r1.zze(r6, r7, r5)
            r2.f9976m = r4
            com.google.android.gms.internal.ads.zzlr r1 = new com.google.android.gms.internal.ads.zzlr
            r1.<init>(r4, r3, r6)
            r2.f9978o = r1
            goto L_0x063e
        L_0x062a:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0632:
            r0 = 4
            goto L_0x063e
        L_0x0634:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x063c:
            r0 = 4
            r4 = 1
        L_0x063e:
            java.util.List<com.google.android.gms.internal.ads.we0> r1 = r9.f11897Q0
            int r1 = r1.size()
            r3 = 0
        L_0x0645:
            if (r3 >= r1) goto L_0x067c
            java.util.List<com.google.android.gms.internal.ads.we0> r5 = r9.f11897Q0
            java.lang.Object r5 = r5.get(r3)
            com.google.android.gms.internal.ads.we0 r5 = (com.google.android.gms.internal.ads.we0) r5
            int r6 = r5.f11418a
            int r7 = com.google.android.gms.internal.ads.ue0.f11381h0
            if (r6 != r7) goto L_0x0670
            com.google.android.gms.internal.ads.zzpn r5 = r5.f11705P0
            r6 = 8
            r5.zzbl(r6)
            r7 = r30
            r8 = 16
            r10 = 0
            r5.zze(r7, r10, r8)
            byte[] r11 = f16623D
            boolean r11 = java.util.Arrays.equals(r7, r11)
            if (r11 == 0) goto L_0x0677
            m9007a(r5, r8, r2)
            goto L_0x0677
        L_0x0670:
            r7 = r30
            r6 = 8
            r8 = 16
            r10 = 0
        L_0x0677:
            int r3 = r3 + 1
            r30 = r7
            goto L_0x0645
        L_0x067c:
            r7 = r30
            r6 = 8
            r10 = 0
            goto L_0x0692
        L_0x0682:
            r32 = r1
            r19 = r2
            r47 = r3
            r21 = r7
            r33 = r8
            r0 = 4
            r4 = 1
            r6 = 8
            r10 = 0
            r7 = r5
        L_0x0692:
            int r8 = r33 + 1
            r0 = r53
            r5 = r7
            r2 = r19
            r7 = r21
            r1 = r32
            r3 = r47
            r4 = 0
            r6 = 4
            goto L_0x01d7
        L_0x06a3:
            r10 = 0
            java.util.List<com.google.android.gms.internal.ads.we0> r0 = r1.f11897Q0
            com.google.android.gms.internal.ads.zzjo r0 = m9008b(r0)
            r2 = r53
            if (r0 == 0) goto L_0x06e3
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r1 = r2.f16627b
            int r1 = r1.size()
            r8 = 0
        L_0x06b5:
            if (r8 >= r1) goto L_0x06e3
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r3 = r2.f16627b
            java.lang.Object r3 = r3.valueAt(r8)
            com.google.android.gms.internal.ads.hf0 r3 = (com.google.android.gms.internal.ads.hf0) r3
            com.google.android.gms.internal.ads.zzkh r4 = r3.f9191b
            com.google.android.gms.internal.ads.zzlo r3 = r3.f9192c
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzahv
            com.google.android.gms.internal.ads.zzhp r3 = r3.zza((com.google.android.gms.internal.ads.zzjo) r0)
            r4.zze(r3)
            int r8 = r8 + 1
            goto L_0x06b5
        L_0x06cf:
            r2 = r0
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r0 = r2.f16634i
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06e3
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r0 = r2.f16634i
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.xe0 r0 = (com.google.android.gms.internal.ads.xe0) r0
            r0.mo15027e(r1)
        L_0x06e3:
            r0 = r2
            goto L_0x0002
        L_0x06e6:
            r2 = r0
            r53.m9010d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.m9009c(long):void");
    }

    /* renamed from: d */
    private final void m9010d() {
        this.f16636k = 0;
        this.f16639n = 0;
    }

    public final void release() {
    }

    public final boolean zza(zzjz zzjz) {
        return lf0.m6455b(zzjz);
    }

    public final void zzc(long j, long j2) {
        int size = this.f16627b.size();
        for (int i = 0; i < size; i++) {
            this.f16627b.valueAt(i).mo14204a();
        }
        this.f16635j.clear();
        this.f16642q = 0;
        this.f16634i.clear();
        m9010d();
    }

    private zzlh(int i) {
        this(0, (zzpr) null);
    }

    public final void zza(zzjy zzjy) {
        this.f16650y = zzjy;
    }

    private zzlh(int i, zzpr zzpr) {
        this(0, (zzpr) null, (zzlo) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:251:0x025e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x059c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0004 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r26, com.google.android.gms.internal.ads.zzkc r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
        L_0x0004:
            int r2 = r0.f16636k
            r3 = 2
            r5 = 8
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0415
            if (r2 == r6) goto L_0x02b8
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11 = 3
            if (r2 == r3) goto L_0x025f
            if (r2 != r11) goto L_0x00f6
            com.google.android.gms.internal.ads.hf0 r2 = r0.f16645t
            if (r2 != 0) goto L_0x007f
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r12 = r2.size()
            r13 = 0
            r14 = 0
        L_0x0025:
            if (r13 >= r12) goto L_0x0044
            java.lang.Object r15 = r2.valueAt(r13)
            com.google.android.gms.internal.ads.hf0 r15 = (com.google.android.gms.internal.ads.hf0) r15
            int r11 = r15.f9196g
            com.google.android.gms.internal.ads.mf0 r4 = r15.f9190a
            int r8 = r4.f9968e
            if (r11 == r8) goto L_0x0040
            long[] r4 = r4.f9970g
            r17 = r4[r11]
            int r4 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x0040
            r14 = r15
            r9 = r17
        L_0x0040:
            int r13 = r13 + 1
            r11 = 3
            goto L_0x0025
        L_0x0044:
            if (r14 != 0) goto L_0x0062
            long r2 = r0.f16641p
            long r4 = r26.getPosition()
            long r2 = r2 - r4
            int r3 = (int) r2
            if (r3 < 0) goto L_0x005a
            r1.zzag(r3)
            r25.m9010d()
            r3 = 0
            r6 = 0
            goto L_0x025c
        L_0x005a:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Offset to end of mdat was negative."
            r1.<init>(r2)
            throw r1
        L_0x0062:
            com.google.android.gms.internal.ads.mf0 r2 = r14.f9190a
            long[] r2 = r2.f9970g
            int r4 = r14.f9196g
            r8 = r2[r4]
            long r10 = r26.getPosition()
            long r8 = r8 - r10
            int r2 = (int) r8
            if (r2 >= 0) goto L_0x007a
            java.lang.String r2 = "FragmentedMp4Extractor"
            java.lang.String r4 = "Ignoring negative offset to sample data."
            android.util.Log.w(r2, r4)
            r2 = 0
        L_0x007a:
            r1.zzag(r2)
            r0.f16645t = r14
        L_0x007f:
            com.google.android.gms.internal.ads.hf0 r2 = r0.f16645t
            com.google.android.gms.internal.ads.mf0 r4 = r2.f9190a
            int[] r8 = r4.f9972i
            int r9 = r2.f9194e
            r8 = r8[r9]
            r0.f16646u = r8
            boolean r8 = r4.f9976m
            if (r8 == 0) goto L_0x00df
            com.google.android.gms.internal.ads.zzpn r8 = r4.f9980q
            com.google.android.gms.internal.ads.ef0 r10 = r4.f9964a
            int r10 = r10.f8355a
            com.google.android.gms.internal.ads.zzlr r11 = r4.f9978o
            if (r11 == 0) goto L_0x009a
            goto L_0x00a0
        L_0x009a:
            com.google.android.gms.internal.ads.zzlo r11 = r2.f9192c
            com.google.android.gms.internal.ads.zzlr[] r11 = r11.zzbad
            r11 = r11[r10]
        L_0x00a0:
            int r10 = r11.zzbba
            boolean[] r4 = r4.f9977n
            boolean r4 = r4[r9]
            com.google.android.gms.internal.ads.zzpn r9 = r0.f16631f
            byte[] r11 = r9.data
            if (r4 == 0) goto L_0x00af
            r12 = 128(0x80, float:1.794E-43)
            goto L_0x00b0
        L_0x00af:
            r12 = 0
        L_0x00b0:
            r12 = r12 | r10
            byte r12 = (byte) r12
            r11[r7] = r12
            r9.zzbl(r7)
            com.google.android.gms.internal.ads.zzkh r2 = r2.f9191b
            com.google.android.gms.internal.ads.zzpn r9 = r0.f16631f
            r2.zza(r9, r6)
            r2.zza(r8, r10)
            if (r4 != 0) goto L_0x00c6
            int r10 = r10 + 1
            goto L_0x00d7
        L_0x00c6:
            int r4 = r8.readUnsignedShort()
            r9 = -2
            r8.zzbm(r9)
            int r4 = r4 * 6
            int r4 = r4 + r3
            r2.zza(r8, r4)
            int r10 = r10 + 1
            int r10 = r10 + r4
        L_0x00d7:
            r0.f16647v = r10
            int r2 = r0.f16646u
            int r2 = r2 + r10
            r0.f16646u = r2
            goto L_0x00e1
        L_0x00df:
            r0.f16647v = r7
        L_0x00e1:
            com.google.android.gms.internal.ads.hf0 r2 = r0.f16645t
            com.google.android.gms.internal.ads.zzlo r2 = r2.f9192c
            int r2 = r2.zzbac
            if (r2 != r6) goto L_0x00f1
            int r2 = r0.f16646u
            int r2 = r2 - r5
            r0.f16646u = r2
            r1.zzag(r5)
        L_0x00f1:
            r2 = 4
            r0.f16636k = r2
            r0.f16648w = r7
        L_0x00f6:
            com.google.android.gms.internal.ads.hf0 r2 = r0.f16645t
            com.google.android.gms.internal.ads.mf0 r4 = r2.f9190a
            com.google.android.gms.internal.ads.zzlo r5 = r2.f9192c
            com.google.android.gms.internal.ads.zzkh r8 = r2.f9191b
            int r2 = r2.f9194e
            int r9 = r5.zzasp
            r10 = 1000(0x3e8, double:4.94E-321)
            if (r9 == 0) goto L_0x01bc
            com.google.android.gms.internal.ads.zzpn r12 = r0.f16629d
            byte[] r12 = r12.data
            r12[r7] = r7
            r12[r6] = r7
            r12[r3] = r7
            int r3 = r9 + 1
            int r9 = 4 - r9
        L_0x0114:
            int r13 = r0.f16647v
            int r14 = r0.f16646u
            if (r13 >= r14) goto L_0x01ce
            int r13 = r0.f16648w
            if (r13 != 0) goto L_0x0160
            r1.readFully(r12, r9, r3)
            com.google.android.gms.internal.ads.zzpn r13 = r0.f16629d
            r13.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r13 = r0.f16629d
            int r13 = r13.zzjf()
            int r13 = r13 - r6
            r0.f16648w = r13
            com.google.android.gms.internal.ads.zzpn r13 = r0.f16628c
            r13.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r13 = r0.f16628c
            r14 = 4
            r8.zza(r13, r14)
            com.google.android.gms.internal.ads.zzpn r13 = r0.f16629d
            r8.zza(r13, r6)
            com.google.android.gms.internal.ads.zzkh[] r13 = r0.f16624A
            if (r13 == 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzhp r13 = r5.zzahv
            java.lang.String r13 = r13.zzaha
            byte r15 = r12[r14]
            boolean r13 = com.google.android.gms.internal.ads.zzpi.zza(r13, r15)
            if (r13 == 0) goto L_0x0151
            r13 = 1
            goto L_0x0152
        L_0x0151:
            r13 = 0
        L_0x0152:
            r0.f16649x = r13
            int r13 = r0.f16647v
            int r13 = r13 + 5
            r0.f16647v = r13
            int r13 = r0.f16646u
            int r13 = r13 + r9
            r0.f16646u = r13
            goto L_0x0114
        L_0x0160:
            boolean r14 = r0.f16649x
            if (r14 == 0) goto L_0x01a9
            com.google.android.gms.internal.ads.zzpn r14 = r0.f16630e
            r14.reset(r13)
            com.google.android.gms.internal.ads.zzpn r13 = r0.f16630e
            byte[] r13 = r13.data
            int r14 = r0.f16648w
            r1.readFully(r13, r7, r14)
            com.google.android.gms.internal.ads.zzpn r13 = r0.f16630e
            int r14 = r0.f16648w
            r8.zza(r13, r14)
            int r13 = r0.f16648w
            com.google.android.gms.internal.ads.zzpn r14 = r0.f16630e
            byte[] r15 = r14.data
            int r14 = r14.limit()
            int r14 = com.google.android.gms.internal.ads.zzpi.zzb(r15, r14)
            com.google.android.gms.internal.ads.zzpn r15 = r0.f16630e
            com.google.android.gms.internal.ads.zzhp r6 = r5.zzahv
            java.lang.String r6 = r6.zzaha
            java.lang.String r7 = "video/hevc"
            boolean r6 = r7.equals(r6)
            r15.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r6 = r0.f16630e
            r6.zzbk(r14)
            long r6 = r4.mo14442b(r2)
            long r6 = r6 * r10
            com.google.android.gms.internal.ads.zzpn r14 = r0.f16630e
            com.google.android.gms.internal.ads.zzkh[] r15 = r0.f16624A
            com.google.android.gms.internal.ads.zzns.zza(r6, r14, r15)
            goto L_0x01ae
        L_0x01a9:
            r6 = 0
            int r13 = r8.zza(r1, r13, r6)
        L_0x01ae:
            int r6 = r0.f16647v
            int r6 = r6 + r13
            r0.f16647v = r6
            int r6 = r0.f16648w
            int r6 = r6 - r13
            r0.f16648w = r6
            r6 = 1
            r7 = 0
            goto L_0x0114
        L_0x01bc:
            int r3 = r0.f16647v
            int r6 = r0.f16646u
            if (r3 >= r6) goto L_0x01ce
            int r6 = r6 - r3
            r3 = 0
            int r6 = r8.zza(r1, r6, r3)
            int r3 = r0.f16647v
            int r3 = r3 + r6
            r0.f16647v = r3
            goto L_0x01bc
        L_0x01ce:
            long r6 = r4.mo14442b(r2)
            long r6 = r6 * r10
            boolean r3 = r4.f9976m
            if (r3 == 0) goto L_0x01db
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x01dc
        L_0x01db:
            r9 = 0
        L_0x01dc:
            boolean[] r10 = r4.f9975l
            boolean r2 = r10[r2]
            r11 = r9 | r2
            if (r3 == 0) goto L_0x0204
            com.google.android.gms.internal.ads.zzlr r2 = r4.f9978o
            if (r2 == 0) goto L_0x01e9
            goto L_0x01f1
        L_0x01e9:
            com.google.android.gms.internal.ads.zzlr[] r2 = r5.zzbad
            com.google.android.gms.internal.ads.ef0 r3 = r4.f9964a
            int r3 = r3.f8355a
            r2 = r2[r3]
        L_0x01f1:
            com.google.android.gms.internal.ads.hf0 r3 = r0.f16645t
            com.google.android.gms.internal.ads.zzlr r5 = r3.f9198i
            if (r2 == r5) goto L_0x0200
            com.google.android.gms.internal.ads.zzkg r3 = new com.google.android.gms.internal.ads.zzkg
            byte[] r5 = r2.zzbbb
            r9 = 1
            r3.<init>(r9, r5)
            goto L_0x0202
        L_0x0200:
            com.google.android.gms.internal.ads.zzkg r3 = r3.f9197h
        L_0x0202:
            r14 = r3
            goto L_0x0206
        L_0x0204:
            r2 = 0
            r14 = 0
        L_0x0206:
            com.google.android.gms.internal.ads.hf0 r3 = r0.f16645t
            r3.f9197h = r14
            r3.f9198i = r2
            int r12 = r0.f16646u
            r13 = 0
            r9 = r6
            r8.zza(r9, r11, r12, r13, r14)
        L_0x0213:
            java.util.LinkedList<com.google.android.gms.internal.ads.if0> r2 = r0.f16635j
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0237
            java.util.LinkedList<com.google.android.gms.internal.ads.if0> r2 = r0.f16635j
            java.lang.Object r2 = r2.removeFirst()
            com.google.android.gms.internal.ads.if0 r2 = (com.google.android.gms.internal.ads.if0) r2
            int r3 = r0.f16642q
            int r12 = r2.f9318b
            int r13 = r3 - r12
            r0.f16642q = r13
            com.google.android.gms.internal.ads.zzkh r8 = r0.f16651z
            long r2 = r2.f9317a
            long r9 = r6 + r2
            r11 = 1
            r14 = 0
            r8.zza(r9, r11, r12, r13, r14)
            goto L_0x0213
        L_0x0237:
            com.google.android.gms.internal.ads.hf0 r2 = r0.f16645t
            int r3 = r2.f9194e
            r5 = 1
            int r3 = r3 + r5
            r2.f9194e = r3
            int r3 = r2.f9195f
            int r3 = r3 + r5
            r2.f9195f = r3
            int[] r4 = r4.f9971h
            int r5 = r2.f9196g
            r4 = r4[r5]
            if (r3 != r4) goto L_0x0257
            int r5 = r5 + 1
            r2.f9196g = r5
            r3 = 0
            r2.f9195f = r3
            r2 = 0
            r0.f16645t = r2
            goto L_0x0258
        L_0x0257:
            r3 = 0
        L_0x0258:
            r2 = 3
            r0.f16636k = r2
            r6 = 1
        L_0x025c:
            if (r6 == 0) goto L_0x0004
            return r3
        L_0x025f:
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r2 = r2.size()
            r3 = 0
            r4 = 0
        L_0x0267:
            if (r3 >= r2) goto L_0x0289
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r5 = r0.f16627b
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.hf0 r5 = (com.google.android.gms.internal.ads.hf0) r5
            com.google.android.gms.internal.ads.mf0 r5 = r5.f9190a
            boolean r6 = r5.f9981r
            if (r6 == 0) goto L_0x0286
            long r5 = r5.f9967d
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x0286
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r4 = r0.f16627b
            java.lang.Object r4 = r4.valueAt(r3)
            com.google.android.gms.internal.ads.hf0 r4 = (com.google.android.gms.internal.ads.hf0) r4
            r9 = r5
        L_0x0286:
            int r3 = r3 + 1
            goto L_0x0267
        L_0x0289:
            if (r4 != 0) goto L_0x0290
            r2 = 3
            r0.f16636k = r2
            goto L_0x0004
        L_0x0290:
            long r2 = r26.getPosition()
            long r9 = r9 - r2
            int r2 = (int) r9
            if (r2 < 0) goto L_0x02b0
            r1.zzag(r2)
            com.google.android.gms.internal.ads.mf0 r2 = r4.f9190a
            com.google.android.gms.internal.ads.zzpn r3 = r2.f9980q
            byte[] r3 = r3.data
            int r4 = r2.f9979p
            r5 = 0
            r1.readFully(r3, r5, r4)
            com.google.android.gms.internal.ads.zzpn r3 = r2.f9980q
            r3.zzbl(r5)
            r2.f9981r = r5
            goto L_0x0004
        L_0x02b0:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Offset to encryption data was negative."
            r1.<init>(r2)
            throw r1
        L_0x02b8:
            long r6 = r0.f16638m
            int r2 = (int) r6
            int r4 = r0.f16639n
            int r2 = r2 - r4
            com.google.android.gms.internal.ads.zzpn r4 = r0.f16640o
            if (r4 == 0) goto L_0x0409
            byte[] r4 = r4.data
            r1.readFully(r4, r5, r2)
            com.google.android.gms.internal.ads.we0 r2 = new com.google.android.gms.internal.ads.we0
            int r4 = r0.f16637l
            com.google.android.gms.internal.ads.zzpn r6 = r0.f16640o
            r2.<init>(r4, r6)
            long r6 = r26.getPosition()
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r4 = r0.f16634i
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x02e9
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r3 = r0.f16634i
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.xe0 r3 = (com.google.android.gms.internal.ads.xe0) r3
            r3.mo15026d(r2)
            goto L_0x040c
        L_0x02e9:
            int r4 = r2.f11418a
            int r8 = com.google.android.gms.internal.ads.ue0.f11328B
            if (r4 != r8) goto L_0x03b1
            com.google.android.gms.internal.ads.zzpn r2 = r2.f11705P0
            r2.zzbl(r5)
            int r4 = r2.readInt()
            int r4 = com.google.android.gms.internal.ads.ue0.m7041a(r4)
            r5 = 4
            r2.zzbm(r5)
            long r14 = r2.zzjc()
            if (r4 != 0) goto L_0x030f
            long r4 = r2.zzjc()
            long r8 = r2.zzjc()
            goto L_0x0317
        L_0x030f:
            long r4 = r2.zzjg()
            long r8 = r2.zzjg()
        L_0x0317:
            long r6 = r6 + r8
            r10 = 1000000(0xf4240, double:4.940656E-318)
            r8 = r4
            r12 = r14
            long r19 = com.google.android.gms.internal.ads.zzpt.zza((long) r8, (long) r10, (long) r12)
            r2.zzbm(r3)
            int r3 = r2.readUnsignedShort()
            int[] r12 = new int[r3]
            long[] r13 = new long[r3]
            long[] r10 = new long[r3]
            long[] r11 = new long[r3]
            r21 = r19
            r8 = 0
        L_0x0333:
            if (r8 >= r3) goto L_0x0389
            int r9 = r2.readInt()
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x0381
            long r23 = r2.zzjc()
            r16 = 2147483647(0x7fffffff, float:NaN)
            r9 = r9 & r16
            r12[r8] = r9
            r13[r8] = r6
            r11[r8] = r21
            long r4 = r4 + r23
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r18 = r8
            r8 = r4
            r27 = r3
            r23 = r4
            r3 = r10
            r4 = r11
            r10 = r21
            r5 = r12
            r1 = r13
            r12 = r14
            long r21 = com.google.android.gms.internal.ads.zzpt.zza((long) r8, (long) r10, (long) r12)
            r8 = r4[r18]
            long r8 = r21 - r8
            r3[r18] = r8
            r8 = 4
            r2.zzbm(r8)
            r9 = r5[r18]
            long r9 = (long) r9
            long r6 = r6 + r9
            int r9 = r18 + 1
            r13 = r1
            r10 = r3
            r11 = r4
            r12 = r5
            r8 = r9
            r4 = r23
            r1 = r26
            r3 = r27
            goto L_0x0333
        L_0x0381:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unhandled indirect reference"
            r1.<init>(r2)
            throw r1
        L_0x0389:
            r3 = r10
            r4 = r11
            r5 = r12
            r1 = r13
            java.lang.Long r2 = java.lang.Long.valueOf(r19)
            com.google.android.gms.internal.ads.zzju r6 = new com.google.android.gms.internal.ads.zzju
            r6.<init>(r5, r1, r3, r4)
            android.util.Pair r1 = android.util.Pair.create(r2, r6)
            java.lang.Object r2 = r1.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r0.f16644s = r2
            com.google.android.gms.internal.ads.zzjy r2 = r0.f16650y
            java.lang.Object r1 = r1.second
            com.google.android.gms.internal.ads.zzkf r1 = (com.google.android.gms.internal.ads.zzkf) r1
            r2.zza(r1)
            r1 = 1
            r0.f16625B = r1
            goto L_0x0406
        L_0x03b1:
            int r1 = com.google.android.gms.internal.ads.ue0.f11339G0
            if (r4 != r1) goto L_0x0406
            com.google.android.gms.internal.ads.zzpn r1 = r2.f11705P0
            com.google.android.gms.internal.ads.zzkh r2 = r0.f16651z
            if (r2 == 0) goto L_0x0406
            r2 = 12
            r1.zzbl(r2)
            r1.zzjh()
            r1.zzjh()
            long r7 = r1.zzjc()
            long r3 = r1.zzjc()
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = com.google.android.gms.internal.ads.zzpt.zza((long) r3, (long) r5, (long) r7)
            r1.zzbl(r2)
            int r9 = r1.zzja()
            com.google.android.gms.internal.ads.zzkh r2 = r0.f16651z
            r2.zza(r1, r9)
            long r1 = r0.f16644s
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x03f7
            com.google.android.gms.internal.ads.zzkh r5 = r0.f16651z
            long r6 = r1 + r3
            r8 = 1
            r10 = 0
            r11 = 0
            r5.zza(r6, r8, r9, r10, r11)
            goto L_0x0406
        L_0x03f7:
            java.util.LinkedList<com.google.android.gms.internal.ads.if0> r1 = r0.f16635j
            com.google.android.gms.internal.ads.if0 r2 = new com.google.android.gms.internal.ads.if0
            r2.<init>(r3, r9)
            r1.addLast(r2)
            int r1 = r0.f16642q
            int r1 = r1 + r9
            r0.f16642q = r1
        L_0x0406:
            r1 = r26
            goto L_0x040c
        L_0x0409:
            r1.zzag(r2)
        L_0x040c:
            long r2 = r26.getPosition()
            r0.m9009c(r2)
            goto L_0x0004
        L_0x0415:
            int r2 = r0.f16639n
            if (r2 != 0) goto L_0x043e
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16632g
            byte[] r2 = r2.data
            r4 = 1
            r6 = 0
            boolean r2 = r1.zza(r2, r6, r5, r4)
            if (r2 != 0) goto L_0x0427
            goto L_0x059a
        L_0x0427:
            r0.f16639n = r5
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16632g
            r2.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16632g
            long r6 = r2.zzjc()
            r0.f16638m = r6
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16632g
            int r2 = r2.readInt()
            r0.f16637l = r2
        L_0x043e:
            long r6 = r0.f16638m
            r8 = 1
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x045a
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16632g
            byte[] r2 = r2.data
            r1.readFully(r2, r5, r5)
            int r2 = r0.f16639n
            int r2 = r2 + r5
            r0.f16639n = r2
            com.google.android.gms.internal.ads.zzpn r2 = r0.f16632g
            long r6 = r2.zzjg()
            r0.f16638m = r6
        L_0x045a:
            long r6 = r0.f16638m
            int r2 = r0.f16639n
            long r8 = (long) r2
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x05a6
            long r6 = r26.getPosition()
            int r2 = r0.f16639n
            long r8 = (long) r2
            long r6 = r6 - r8
            int r2 = r0.f16637l
            int r4 = com.google.android.gms.internal.ads.ue0.f11348L
            if (r2 != r4) goto L_0x048d
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r2 = r0.f16627b
            int r2 = r2.size()
            r4 = 0
        L_0x0478:
            if (r4 >= r2) goto L_0x048d
            android.util.SparseArray<com.google.android.gms.internal.ads.hf0> r8 = r0.f16627b
            java.lang.Object r8 = r8.valueAt(r4)
            com.google.android.gms.internal.ads.hf0 r8 = (com.google.android.gms.internal.ads.hf0) r8
            com.google.android.gms.internal.ads.mf0 r8 = r8.f9190a
            r8.f9965b = r6
            r8.f9967d = r6
            r8.f9966c = r6
            int r4 = r4 + 1
            goto L_0x0478
        L_0x048d:
            int r2 = r0.f16637l
            int r4 = com.google.android.gms.internal.ads.ue0.f11382i
            if (r2 != r4) goto L_0x04b3
            r4 = 0
            r0.f16645t = r4
            long r4 = r0.f16638m
            long r6 = r6 + r4
            r0.f16641p = r6
            boolean r2 = r0.f16625B
            if (r2 != 0) goto L_0x04ae
            com.google.android.gms.internal.ads.zzjy r2 = r0.f16650y
            com.google.android.gms.internal.ads.zzke r4 = new com.google.android.gms.internal.ads.zzke
            long r5 = r0.f16643r
            r4.<init>(r5)
            r2.zza(r4)
            r2 = 1
            r0.f16625B = r2
        L_0x04ae:
            r0.f16636k = r3
        L_0x04b0:
            r2 = 1
            goto L_0x0599
        L_0x04b3:
            int r3 = com.google.android.gms.internal.ads.ue0.f11330C
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11334E
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11336F
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11338G
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11340H
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11348L
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11350M
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11352N
            if (r2 == r3) goto L_0x04da
            int r3 = com.google.android.gms.internal.ads.ue0.f11357Q
            if (r2 != r3) goto L_0x04d8
            goto L_0x04da
        L_0x04d8:
            r3 = 0
            goto L_0x04db
        L_0x04da:
            r3 = 1
        L_0x04db:
            if (r3 == 0) goto L_0x0504
            long r2 = r26.getPosition()
            long r4 = r0.f16638m
            long r2 = r2 + r4
            r4 = 8
            long r2 = r2 - r4
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r4 = r0.f16634i
            com.google.android.gms.internal.ads.xe0 r5 = new com.google.android.gms.internal.ads.xe0
            int r6 = r0.f16637l
            r5.<init>(r6, r2)
            r4.add(r5)
            long r4 = r0.f16638m
            int r6 = r0.f16639n
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0500
            r0.m9009c(r2)
            goto L_0x04b0
        L_0x0500:
            r25.m9010d()
            goto L_0x04b0
        L_0x0504:
            int r3 = com.google.android.gms.internal.ads.ue0.f11360T
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11359S
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11332D
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11328B
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11361U
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11412x
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11414y
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11356P
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11416z
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11326A
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11362V
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11373d0
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11375e0
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11383i0
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11381h0
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11377f0
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11379g0
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11358R
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11354O
            if (r2 == r3) goto L_0x0557
            int r3 = com.google.android.gms.internal.ads.ue0.f11339G0
            if (r2 != r3) goto L_0x0555
            goto L_0x0557
        L_0x0555:
            r2 = 0
            goto L_0x0558
        L_0x0557:
            r2 = 1
        L_0x0558:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r2 == 0) goto L_0x058d
            int r2 = r0.f16639n
            if (r2 != r5) goto L_0x0585
            long r6 = r0.f16638m
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x057d
            com.google.android.gms.internal.ads.zzpn r2 = new com.google.android.gms.internal.ads.zzpn
            int r3 = (int) r6
            r2.<init>((int) r3)
            r0.f16640o = r2
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16632g
            byte[] r3 = r3.data
            byte[] r2 = r2.data
            r4 = 0
            java.lang.System.arraycopy(r3, r4, r2, r4, r5)
            r2 = 1
            r0.f16636k = r2
            goto L_0x0599
        L_0x057d:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Leaf atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x0585:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Leaf atom defines extended atom size (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x058d:
            long r5 = r0.f16638m
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x059e
            r2 = 0
            r0.f16640o = r2
            r2 = 1
            r0.f16636k = r2
        L_0x0599:
            r6 = 1
        L_0x059a:
            if (r6 != 0) goto L_0x0004
            r1 = -1
            return r1
        L_0x059e:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Skipping atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x05a6:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Atom size less than header length (unsupported)."
            r1.<init>(r2)
            goto L_0x05af
        L_0x05ae:
            throw r1
        L_0x05af:
            goto L_0x05ae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }

    private zzlh(int i, zzpr zzpr, zzlo zzlo) {
        this.f16626a = 0;
        this.f16632g = new zzpn(16);
        this.f16628c = new zzpn(zzpi.zzbjq);
        this.f16629d = new zzpn(5);
        this.f16630e = new zzpn();
        this.f16631f = new zzpn(1);
        this.f16633h = new byte[16];
        this.f16634i = new Stack<>();
        this.f16635j = new LinkedList<>();
        this.f16627b = new SparseArray<>();
        this.f16643r = -9223372036854775807L;
        this.f16644s = -9223372036854775807L;
        m9010d();
    }
}
