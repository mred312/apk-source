package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class te0 {

    /* renamed from: A */
    public float f11173A;

    /* renamed from: B */
    public float f11174B;

    /* renamed from: C */
    public float f11175C;

    /* renamed from: D */
    public float f11176D;

    /* renamed from: E */
    public float f11177E;

    /* renamed from: F */
    public float f11178F;

    /* renamed from: G */
    public int f11179G;

    /* renamed from: H */
    public int f11180H;

    /* renamed from: I */
    public int f11181I;

    /* renamed from: J */
    public long f11182J;

    /* renamed from: K */
    public long f11183K;

    /* renamed from: L */
    public boolean f11184L;

    /* renamed from: M */
    public boolean f11185M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public String f11186N;

    /* renamed from: O */
    public zzkh f11187O;

    /* renamed from: P */
    public int f11188P;

    /* renamed from: a */
    public String f11189a;

    /* renamed from: b */
    public int f11190b;

    /* renamed from: c */
    public int f11191c;

    /* renamed from: d */
    public int f11192d;

    /* renamed from: e */
    public boolean f11193e;

    /* renamed from: f */
    public byte[] f11194f;

    /* renamed from: g */
    public zzkg f11195g;

    /* renamed from: h */
    public byte[] f11196h;

    /* renamed from: i */
    public zzjo f11197i;

    /* renamed from: j */
    public int f11198j;

    /* renamed from: k */
    public int f11199k;

    /* renamed from: l */
    public int f11200l;

    /* renamed from: m */
    public int f11201m;

    /* renamed from: n */
    public int f11202n;

    /* renamed from: o */
    public byte[] f11203o;

    /* renamed from: p */
    public int f11204p;

    /* renamed from: q */
    public boolean f11205q;

    /* renamed from: r */
    public int f11206r;

    /* renamed from: s */
    public int f11207s;

    /* renamed from: t */
    public int f11208t;

    /* renamed from: u */
    public int f11209u;

    /* renamed from: v */
    public int f11210v;

    /* renamed from: w */
    public float f11211w;

    /* renamed from: x */
    public float f11212x;

    /* renamed from: y */
    public float f11213y;

    /* renamed from: z */
    public float f11214z;

    private te0() {
        this.f11198j = -1;
        this.f11199k = -1;
        this.f11200l = -1;
        this.f11201m = -1;
        this.f11202n = 0;
        this.f11203o = null;
        this.f11204p = -1;
        this.f11205q = false;
        this.f11206r = -1;
        this.f11207s = -1;
        this.f11208t = -1;
        this.f11209u = 1000;
        this.f11210v = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.f11211w = -1.0f;
        this.f11212x = -1.0f;
        this.f11213y = -1.0f;
        this.f11214z = -1.0f;
        this.f11173A = -1.0f;
        this.f11174B = -1.0f;
        this.f11175C = -1.0f;
        this.f11176D = -1.0f;
        this.f11177E = -1.0f;
        this.f11178F = -1.0f;
        this.f11179G = 1;
        this.f11180H = -1;
        this.f11181I = 8000;
        this.f11182J = 0;
        this.f11183K = 0;
        this.f11185M = true;
        this.f11186N = "eng";
    }

    /* renamed from: b */
    private static List<byte[]> m7009b(zzpn zzpn) {
        try {
            zzpn.zzbm(16);
            if (zzpn.zzjd() != 826496599) {
                return null;
            }
            byte[] bArr = zzpn.data;
            for (int position = zzpn.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhw("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing FourCC VC1 codec private");
        }
    }

    /* renamed from: d */
    private static boolean m7010d(zzpn zzpn) {
        try {
            int zzjb = zzpn.zzjb();
            if (zzjb == 1) {
                return true;
            }
            if (zzjb == 65534) {
                zzpn.zzbl(24);
                return zzpn.readLong() == zzkm.f16570b0.getMostSignificantBits() && zzpn.readLong() == zzkm.f16570b0.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing MS/ACM codec private");
        }
    }

    /* renamed from: e */
    private static List<byte[]> m7011e(byte[] bArr) {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhw("Error parsing vorbis codec private");
                    }
                    throw new zzhw("Error parsing vorbis codec private");
                }
                throw new zzhw("Error parsing vorbis codec private");
            }
            throw new zzhw("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing vorbis codec private");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x024c, code lost:
        r14 = "audio/x-unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x024e, code lost:
        r26 = r1;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0268, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x026a, code lost:
        r26 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x026c, code lost:
        r31 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02a9, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02ea, code lost:
        r1 = null;
        r26 = -1;
        r31 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0370, code lost:
        r3 = r0.f11185M | false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0375, code lost:
        if (r0.f11184L == false) goto L_0x0379;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0377, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0379, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x037a, code lost:
        r3 = r3 | r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x037f, code lost:
        if (com.google.android.gms.internal.ads.zzpj.zzbc(r14) == false) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0381, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r44), r14, (java.lang.String) null, -1, r31, r0.f11179G, r0.f11181I, r26, r1, r0.f11197i, r3 ? 1 : 0, r0.f11186N);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03ab, code lost:
        if (com.google.android.gms.internal.ads.zzpj.zzbd(r14) == false) goto L_0x04d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03af, code lost:
        if (r0.f11202n != 0) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03b1, code lost:
        r2 = r0.f11200l;
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03b4, code lost:
        if (r2 != -1) goto L_0x03b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03b6, code lost:
        r2 = r0.f11198j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03b8, code lost:
        r0.f11200l = r2;
        r2 = r0.f11201m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03bc, code lost:
        if (r2 != -1) goto L_0x03c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03be, code lost:
        r2 = r0.f11199k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03c0, code lost:
        r0.f11201m = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03c3, code lost:
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03c4, code lost:
        r2 = r0.f11200l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03c8, code lost:
        if (r2 == r3) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03ca, code lost:
        r5 = r0.f11201m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03cc, code lost:
        if (r5 == r3) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03ce, code lost:
        r37 = ((float) (r0.f11199k * r2)) / ((float) (r0.f11198j * r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03dc, code lost:
        r37 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03e0, code lost:
        if (r0.f11205q == false) goto L_0x04ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03e6, code lost:
        if (r0.f11211w == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03ec, code lost:
        if (r0.f11212x == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03f2, code lost:
        if (r0.f11213y == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03f8, code lost:
        if (r0.f11214z == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03fe, code lost:
        if (r0.f11173A == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0404, code lost:
        if (r0.f11174B == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x040a, code lost:
        if (r0.f11175C == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0410, code lost:
        if (r0.f11176D == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0416, code lost:
        if (r0.f11177E == -1.0f) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x041c, code lost:
        if (r0.f11178F != -1.0f) goto L_0x0420;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0420, code lost:
        r2 = new byte[25];
        r3 = java.nio.ByteBuffer.wrap(r2);
        r3.put((byte) 0);
        r3.putShort((short) ((int) ((r0.f11211w * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.f11212x * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.f11213y * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.f11214z * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.f11173A * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.f11174B * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.f11175C * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.f11176D * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) (r0.f11177E + 0.5f)));
        r3.putShort((short) ((int) (r0.f11178F + 0.5f)));
        r3.putShort((short) r0.f11209u);
        r3.putShort((short) r0.f11210v);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x049d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x049f, code lost:
        r40 = new com.google.android.gms.internal.ads.zzpu(r0.f11206r, r0.f11208t, r0.f11207s, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04ad, code lost:
        r40 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04af, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r44), r14, (java.lang.String) null, -1, r31, r0.f11198j, r0.f11199k, -1.0f, r1, -1, r37, r0.f11203o, r0.f11204p, r40, r0.f11197i);
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04dd, code lost:
        if ("application/x-subrip".equals(r14) == false) goto L_0x04f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04df, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r44), r14, (java.lang.String) null, -1, r3 ? 1 : 0, r0.f11186N, r0.f11197i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04f7, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04fd, code lost:
        if ("application/vobsub".equals(r14) != false) goto L_0x0516;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0505, code lost:
        if (r18.equals(r14) != false) goto L_0x0516;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x050b, code lost:
        if ("application/dvbsubs".equals(r14) == false) goto L_0x050e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0515, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0516, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r44), r14, (java.lang.String) null, -1, r1, r0.f11186N, r0.f11197i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x052f, code lost:
        r2 = r43.zzc(r0.f11190b, r6);
        r0.f11187O = r2;
        r2.zze(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x053c, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo14844c(com.google.android.gms.internal.ads.zzjy r43, int r44) {
        /*
            r42 = this;
            r0 = r42
            java.lang.String r1 = r0.f11189a
            r1.hashCode()
            int r2 = r1.hashCode()
            r4 = 4
            r5 = 8
            r6 = 1
            r7 = 2
            r8 = 3
            r9 = 0
            switch(r2) {
                case -2095576542: goto L_0x017b;
                case -2095575984: goto L_0x016f;
                case -1985379776: goto L_0x0163;
                case -1784763192: goto L_0x0157;
                case -1730367663: goto L_0x014b;
                case -1482641358: goto L_0x013f;
                case -1482641357: goto L_0x0133;
                case -1373388978: goto L_0x0127;
                case -933872740: goto L_0x0119;
                case -538363189: goto L_0x010b;
                case -538363109: goto L_0x00fd;
                case -425012669: goto L_0x00ef;
                case -356037306: goto L_0x00e1;
                case 62923557: goto L_0x00d3;
                case 62923603: goto L_0x00c5;
                case 62927045: goto L_0x00b7;
                case 82338133: goto L_0x00a9;
                case 82338134: goto L_0x009b;
                case 99146302: goto L_0x008d;
                case 444813526: goto L_0x0080;
                case 542569478: goto L_0x0073;
                case 725957860: goto L_0x0066;
                case 855502857: goto L_0x0059;
                case 1422270023: goto L_0x004c;
                case 1809237540: goto L_0x003f;
                case 1950749482: goto L_0x0032;
                case 1950789798: goto L_0x0025;
                case 1951062397: goto L_0x0018;
                default: goto L_0x0015;
            }
        L_0x0015:
            r1 = -1
            goto L_0x0186
        L_0x0018:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0021
            goto L_0x0015
        L_0x0021:
            r1 = 27
            goto L_0x0186
        L_0x0025:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x002e
            goto L_0x0015
        L_0x002e:
            r1 = 26
            goto L_0x0186
        L_0x0032:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003b
            goto L_0x0015
        L_0x003b:
            r1 = 25
            goto L_0x0186
        L_0x003f:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0048
            goto L_0x0015
        L_0x0048:
            r1 = 24
            goto L_0x0186
        L_0x004c:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0055
            goto L_0x0015
        L_0x0055:
            r1 = 23
            goto L_0x0186
        L_0x0059:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0062
            goto L_0x0015
        L_0x0062:
            r1 = 22
            goto L_0x0186
        L_0x0066:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x006f
            goto L_0x0015
        L_0x006f:
            r1 = 21
            goto L_0x0186
        L_0x0073:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x007c
            goto L_0x0015
        L_0x007c:
            r1 = 20
            goto L_0x0186
        L_0x0080:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0089
            goto L_0x0015
        L_0x0089:
            r1 = 19
            goto L_0x0186
        L_0x008d:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0097
            goto L_0x0015
        L_0x0097:
            r1 = 18
            goto L_0x0186
        L_0x009b:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a5
            goto L_0x0015
        L_0x00a5:
            r1 = 17
            goto L_0x0186
        L_0x00a9:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00b3
            goto L_0x0015
        L_0x00b3:
            r1 = 16
            goto L_0x0186
        L_0x00b7:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00c1
            goto L_0x0015
        L_0x00c1:
            r1 = 15
            goto L_0x0186
        L_0x00c5:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00cf
            goto L_0x0015
        L_0x00cf:
            r1 = 14
            goto L_0x0186
        L_0x00d3:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00dd
            goto L_0x0015
        L_0x00dd:
            r1 = 13
            goto L_0x0186
        L_0x00e1:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00eb
            goto L_0x0015
        L_0x00eb:
            r1 = 12
            goto L_0x0186
        L_0x00ef:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f9
            goto L_0x0015
        L_0x00f9:
            r1 = 11
            goto L_0x0186
        L_0x00fd:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0107
            goto L_0x0015
        L_0x0107:
            r1 = 10
            goto L_0x0186
        L_0x010b:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0115
            goto L_0x0015
        L_0x0115:
            r1 = 9
            goto L_0x0186
        L_0x0119:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0123
            goto L_0x0015
        L_0x0123:
            r1 = 8
            goto L_0x0186
        L_0x0127:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0131
            goto L_0x0015
        L_0x0131:
            r1 = 7
            goto L_0x0186
        L_0x0133:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x013d
            goto L_0x0015
        L_0x013d:
            r1 = 6
            goto L_0x0186
        L_0x013f:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0149
            goto L_0x0015
        L_0x0149:
            r1 = 5
            goto L_0x0186
        L_0x014b:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0155
            goto L_0x0015
        L_0x0155:
            r1 = 4
            goto L_0x0186
        L_0x0157:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0161
            goto L_0x0015
        L_0x0161:
            r1 = 3
            goto L_0x0186
        L_0x0163:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x016d
            goto L_0x0015
        L_0x016d:
            r1 = 2
            goto L_0x0186
        L_0x016f:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0179
            goto L_0x0015
        L_0x0179:
            r1 = 1
            goto L_0x0186
        L_0x017b:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0185
            goto L_0x0015
        L_0x0185:
            r1 = 0
        L_0x0186:
            java.lang.String r2 = "application/dvbsubs"
            java.lang.String r11 = "application/pgs"
            java.lang.String r12 = "application/vobsub"
            java.lang.String r13 = "application/x-subrip"
            java.lang.String r14 = "audio/raw"
            java.lang.String r16 = "video/x-unknown"
            java.lang.String r15 = "audio/x-unknown"
            java.lang.String r3 = "MatroskaExtractor"
            r17 = 0
            switch(r1) {
                case 0: goto L_0x035f;
                case 1: goto L_0x035f;
                case 2: goto L_0x030a;
                case 3: goto L_0x0304;
                case 4: goto L_0x02f2;
                case 5: goto L_0x02e6;
                case 6: goto L_0x02e1;
                case 7: goto L_0x02c7;
                case 8: goto L_0x02ab;
                case 9: goto L_0x035f;
                case 10: goto L_0x0294;
                case 11: goto L_0x028a;
                case 12: goto L_0x0285;
                case 13: goto L_0x027a;
                case 14: goto L_0x0275;
                case 15: goto L_0x0270;
                case 16: goto L_0x0264;
                case 17: goto L_0x025f;
                case 18: goto L_0x0258;
                case 19: goto L_0x0253;
                case 20: goto L_0x0270;
                case 21: goto L_0x021e;
                case 22: goto L_0x0207;
                case 23: goto L_0x0203;
                case 24: goto L_0x01fd;
                case 25: goto L_0x01f7;
                case 26: goto L_0x01eb;
                case 27: goto L_0x01a3;
                default: goto L_0x019b;
            }
        L_0x019b:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x01a3:
            r15 = 5760(0x1680, float:8.071E-42)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r8)
            byte[] r3 = r0.f11196h
            r1.add(r3)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r3 = r3.order(r4)
            r18 = r11
            long r10 = r0.f11182J
            java.nio.ByteBuffer r3 = r3.putLong(r10)
            byte[] r3 = r3.array()
            r1.add(r3)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r3 = r3.order(r4)
            long r4 = r0.f11183K
            java.nio.ByteBuffer r3 = r3.putLong(r4)
            byte[] r3 = r3.array()
            r1.add(r3)
            java.lang.String r14 = "audio/opus"
            r26 = -1
            r31 = 5760(0x1680, float:8.071E-42)
            goto L_0x0370
        L_0x01eb:
            r18 = r11
            byte[] r1 = r0.f11196h
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r14 = "audio/x-flac"
            goto L_0x026a
        L_0x01f7:
            r18 = r11
            java.lang.String r14 = "audio/eac3"
            goto L_0x0268
        L_0x01fd:
            r18 = r11
            java.lang.String r14 = "video/mpeg2"
            goto L_0x0268
        L_0x0203:
            r18 = r11
            r14 = r13
            goto L_0x0268
        L_0x0207:
            r18 = r11
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r3 = r0.f11196h
            r1.<init>((byte[]) r3)
            com.google.android.gms.internal.ads.zzqb r1 = com.google.android.gms.internal.ads.zzqb.zzi(r1)
            java.util.List<byte[]> r3 = r1.zzahc
            int r1 = r1.zzasp
            r0.f11188P = r1
            java.lang.String r14 = "video/hevc"
            goto L_0x02a9
        L_0x021e:
            r18 = r11
            int r1 = r0.f11180H
            int r1 = com.google.android.gms.internal.ads.zzpt.zzbo(r1)
            if (r1 != 0) goto L_0x024e
            int r1 = r0.f11180H
            int r4 = r15.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r5.append(r1)
            r5.append(r15)
            java.lang.String r1 = r5.toString()
            android.util.Log.w(r3, r1)
        L_0x024c:
            r14 = r15
            goto L_0x0268
        L_0x024e:
            r26 = r1
            r1 = r17
            goto L_0x026c
        L_0x0253:
            r18 = r11
            r14 = r16
            goto L_0x0268
        L_0x0258:
            r18 = r11
            r1 = r17
            r14 = r18
            goto L_0x026a
        L_0x025f:
            r18 = r11
            java.lang.String r14 = "video/x-vnd.on2.vp9"
            goto L_0x0268
        L_0x0264:
            r18 = r11
            java.lang.String r14 = "video/x-vnd.on2.vp8"
        L_0x0268:
            r1 = r17
        L_0x026a:
            r26 = -1
        L_0x026c:
            r31 = -1
            goto L_0x0370
        L_0x0270:
            r18 = r11
            java.lang.String r14 = "audio/vnd.dts"
            goto L_0x0268
        L_0x0275:
            r18 = r11
            java.lang.String r14 = "audio/ac3"
            goto L_0x0268
        L_0x027a:
            r18 = r11
            byte[] r1 = r0.f11196h
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r14 = "audio/mp4a-latm"
            goto L_0x026a
        L_0x0285:
            r18 = r11
            java.lang.String r14 = "audio/vnd.dts.hd"
            goto L_0x0268
        L_0x028a:
            r18 = r11
            byte[] r1 = r0.f11196h
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r14 = r12
            goto L_0x026a
        L_0x0294:
            r18 = r11
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r3 = r0.f11196h
            r1.<init>((byte[]) r3)
            com.google.android.gms.internal.ads.zzpv r1 = com.google.android.gms.internal.ads.zzpv.zzg(r1)
            java.util.List<byte[]> r3 = r1.zzahc
            int r1 = r1.zzasp
            r0.f11188P = r1
            java.lang.String r14 = "video/avc"
        L_0x02a9:
            r1 = r3
            goto L_0x026a
        L_0x02ab:
            r18 = r11
            byte[] r1 = new byte[r4]
            byte[] r3 = r0.f11196h
            byte r4 = r3[r9]
            r1[r9] = r4
            byte r4 = r3[r6]
            r1[r6] = r4
            byte r4 = r3[r7]
            r1[r7] = r4
            byte r3 = r3[r8]
            r1[r8] = r3
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r14 = r2
            goto L_0x026a
        L_0x02c7:
            r18 = r11
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r4 = r0.f11196h
            r1.<init>((byte[]) r4)
            java.util.List r1 = m7009b(r1)
            if (r1 == 0) goto L_0x02d9
            java.lang.String r14 = "video/wvc1"
            goto L_0x026a
        L_0x02d9:
            java.lang.String r4 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r3, r4)
            r14 = r16
            goto L_0x026a
        L_0x02e1:
            r18 = r11
            java.lang.String r14 = "audio/mpeg"
            goto L_0x02ea
        L_0x02e6:
            r18 = r11
            java.lang.String r14 = "audio/mpeg-L2"
        L_0x02ea:
            r1 = r17
            r26 = -1
            r31 = 4096(0x1000, float:5.74E-42)
            goto L_0x0370
        L_0x02f2:
            r18 = r11
            r15 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = r0.f11196h
            java.util.List r1 = m7011e(r1)
            java.lang.String r14 = "audio/vorbis"
            r26 = -1
            r31 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0370
        L_0x0304:
            r18 = r11
            java.lang.String r14 = "audio/true-hd"
            goto L_0x0268
        L_0x030a:
            r18 = r11
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r4 = r0.f11196h
            r1.<init>((byte[]) r4)
            boolean r1 = m7010d(r1)
            if (r1 == 0) goto L_0x0347
            int r1 = r0.f11180H
            int r1 = com.google.android.gms.internal.ads.zzpt.zzbo(r1)
            if (r1 != 0) goto L_0x024e
            int r1 = r0.f11180H
            int r4 = r15.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r5.append(r1)
            r5.append(r15)
            java.lang.String r1 = r5.toString()
            android.util.Log.w(r3, r1)
            goto L_0x024c
        L_0x0347:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
            int r4 = r15.length()
            if (r4 == 0) goto L_0x0354
            java.lang.String r1 = r1.concat(r15)
            goto L_0x035a
        L_0x0354:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1)
            r1 = r4
        L_0x035a:
            android.util.Log.w(r3, r1)
            goto L_0x024c
        L_0x035f:
            r18 = r11
            byte[] r1 = r0.f11196h
            if (r1 != 0) goto L_0x0368
            r1 = r17
            goto L_0x036c
        L_0x0368:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x036c:
            java.lang.String r14 = "video/mp4v-es"
            goto L_0x026a
        L_0x0370:
            boolean r3 = r0.f11185M
            r3 = r3 | r9
            boolean r4 = r0.f11184L
            if (r4 == 0) goto L_0x0379
            r4 = 2
            goto L_0x037a
        L_0x0379:
            r4 = 0
        L_0x037a:
            r3 = r3 | r4
            boolean r4 = com.google.android.gms.internal.ads.zzpj.zzbc(r14)
            if (r4 == 0) goto L_0x03a7
            java.lang.String r19 = java.lang.Integer.toString(r44)
            r21 = 0
            r22 = -1
            int r2 = r0.f11179G
            int r4 = r0.f11181I
            com.google.android.gms.internal.ads.zzjo r5 = r0.f11197i
            java.lang.String r7 = r0.f11186N
            r20 = r14
            r23 = r31
            r24 = r2
            r25 = r4
            r27 = r1
            r28 = r5
            r29 = r3
            r30 = r7
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            goto L_0x052f
        L_0x03a7:
            boolean r4 = com.google.android.gms.internal.ads.zzpj.zzbd(r14)
            if (r4 == 0) goto L_0x04d9
            int r2 = r0.f11202n
            if (r2 != 0) goto L_0x03c3
            int r2 = r0.f11200l
            r3 = -1
            if (r2 != r3) goto L_0x03b8
            int r2 = r0.f11198j
        L_0x03b8:
            r0.f11200l = r2
            int r2 = r0.f11201m
            if (r2 != r3) goto L_0x03c0
            int r2 = r0.f11199k
        L_0x03c0:
            r0.f11201m = r2
            goto L_0x03c4
        L_0x03c3:
            r3 = -1
        L_0x03c4:
            int r2 = r0.f11200l
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r3) goto L_0x03dc
            int r5 = r0.f11201m
            if (r5 == r3) goto L_0x03dc
            int r3 = r0.f11199k
            int r3 = r3 * r2
            float r2 = (float) r3
            int r3 = r0.f11198j
            int r3 = r3 * r5
            float r3 = (float) r3
            float r2 = r2 / r3
            r37 = r2
            goto L_0x03de
        L_0x03dc:
            r37 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x03de:
            boolean r2 = r0.f11205q
            if (r2 == 0) goto L_0x04ad
            float r2 = r0.f11211w
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11212x
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11213y
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11214z
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11173A
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11174B
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11175C
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11176D
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11177E
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x049d
            float r2 = r0.f11178F
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0420
            goto L_0x049d
        L_0x0420:
            r2 = 25
            byte[] r2 = new byte[r2]
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r2)
            r3.put(r9)
            float r4 = r0.f11211w
            r5 = 1195593728(0x47435000, float:50000.0)
            float r4 = r4 * r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11212x
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11213y
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11214z
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11173A
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11174B
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11175C
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11176D
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11177E
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.f11178F
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.f11209u
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.f11210v
            short r4 = (short) r4
            r3.putShort(r4)
            goto L_0x049f
        L_0x049d:
            r2 = r17
        L_0x049f:
            com.google.android.gms.internal.ads.zzpu r3 = new com.google.android.gms.internal.ads.zzpu
            int r4 = r0.f11206r
            int r5 = r0.f11208t
            int r6 = r0.f11207s
            r3.<init>(r4, r5, r6, r2)
            r40 = r3
            goto L_0x04af
        L_0x04ad:
            r40 = r17
        L_0x04af:
            java.lang.String r27 = java.lang.Integer.toString(r44)
            r29 = 0
            r30 = -1
            int r2 = r0.f11198j
            int r3 = r0.f11199k
            r34 = -1082130432(0xffffffffbf800000, float:-1.0)
            r36 = -1
            byte[] r4 = r0.f11203o
            int r5 = r0.f11204p
            com.google.android.gms.internal.ads.zzjo r6 = r0.f11197i
            r28 = r14
            r32 = r2
            r33 = r3
            r35 = r1
            r38 = r4
            r39 = r5
            r41 = r6
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            r6 = 2
            goto L_0x052f
        L_0x04d9:
            boolean r4 = r13.equals(r14)
            if (r4 == 0) goto L_0x04f9
            java.lang.String r19 = java.lang.Integer.toString(r44)
            r21 = 0
            r22 = -1
            java.lang.String r1 = r0.f11186N
            com.google.android.gms.internal.ads.zzjo r2 = r0.f11197i
            r20 = r14
            r23 = r3
            r24 = r1
            r25 = r2
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza((java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (int) r22, (int) r23, (java.lang.String) r24, (com.google.android.gms.internal.ads.zzjo) r25)
        L_0x04f7:
            r6 = 3
            goto L_0x052f
        L_0x04f9:
            boolean r3 = r12.equals(r14)
            if (r3 != 0) goto L_0x0516
            r3 = r18
            boolean r3 = r3.equals(r14)
            if (r3 != 0) goto L_0x0516
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x050e
            goto L_0x0516
        L_0x050e:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x0516:
            java.lang.String r19 = java.lang.Integer.toString(r44)
            r21 = 0
            r22 = -1
            java.lang.String r2 = r0.f11186N
            com.google.android.gms.internal.ads.zzjo r3 = r0.f11197i
            r20 = r14
            r23 = r1
            r24 = r2
            r25 = r3
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza((java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (int) r22, (java.util.List<byte[]>) r23, (java.lang.String) r24, (com.google.android.gms.internal.ads.zzjo) r25)
            goto L_0x04f7
        L_0x052f:
            int r2 = r0.f11190b
            r3 = r43
            com.google.android.gms.internal.ads.zzkh r2 = r3.zzc(r2, r6)
            r0.f11187O = r2
            r2.zze(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.te0.mo14844c(com.google.android.gms.internal.ads.zzjy, int):void");
    }

    /* synthetic */ te0(re0 re0) {
        this();
    }
}
