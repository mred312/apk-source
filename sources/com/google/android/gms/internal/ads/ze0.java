package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzmd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ze0 {

    /* renamed from: a */
    private static final int f12286a = zzpt.zzbh("vide");

    /* renamed from: b */
    private static final int f12287b = zzpt.zzbh("soun");

    /* renamed from: c */
    private static final int f12288c = zzpt.zzbh("text");

    /* renamed from: d */
    private static final int f12289d = zzpt.zzbh("sbtl");

    /* renamed from: e */
    private static final int f12290e = zzpt.zzbh("subt");

    /* renamed from: f */
    private static final int f12291f = zzpt.zzbh("clcp");

    /* renamed from: g */
    private static final int f12292g = zzpt.zzbh("cenc");

    /* renamed from: h */
    private static final int f12293h = zzpt.zzbh("meta");

    /* renamed from: a */
    private static int m7406a(zzpn zzpn, int i, int i2, af0 af0, int i3) {
        zzpn zzpn2 = zzpn;
        int position = zzpn.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzpn.zzbl(position);
            int readInt = zzpn.readInt();
            zzpc.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpn.readInt() == ue0.f11363W) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzlr zzlr = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzpn.zzbl(i4);
                    int readInt2 = zzpn.readInt();
                    int readInt3 = zzpn.readInt();
                    if (readInt3 == ue0.f11371c0) {
                        num = Integer.valueOf(zzpn.readInt());
                    } else if (readInt3 == ue0.f11364X) {
                        zzpn.zzbm(4);
                        z2 = zzpn.readInt() == f12292g;
                    } else if (readInt3 == ue0.f11365Y) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzlr = null;
                                break;
                            }
                            zzpn.zzbl(i5);
                            int readInt4 = zzpn.readInt();
                            if (zzpn.readInt() == ue0.f11366Z) {
                                zzpn.zzbm(6);
                                boolean z3 = zzpn.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpn.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpn.zze(bArr, 0, 16);
                                zzlr = new zzlr(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zzpc.checkArgument(num != null, "frma atom is mandatory");
                    if (zzlr != null) {
                        z = true;
                    }
                    zzpc.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzlr);
                }
                if (pair != null) {
                    af0.f7811a[i3] = (zzlr) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            af0 af02 = af0;
            position += readInt;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v11, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0554: MOVE  (r7v16 java.lang.String) = (r44v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0558  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x058d  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x07ca  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x081c  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0825 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0826  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b6  */
    /* renamed from: b */
    public static com.google.android.gms.internal.ads.zzlo m7407b(com.google.android.gms.internal.ads.xe0 r49, com.google.android.gms.internal.ads.we0 r50, long r51, com.google.android.gms.internal.ads.zzjo r53, boolean r54) {
        /*
            r0 = r49
            r15 = r53
            int r1 = com.google.android.gms.internal.ads.ue0.f11336F
            com.google.android.gms.internal.ads.xe0 r1 = r0.mo15029g(r1)
            int r2 = com.google.android.gms.internal.ads.ue0.f11360T
            com.google.android.gms.internal.ads.we0 r2 = r1.mo15028f(r2)
            com.google.android.gms.internal.ads.zzpn r2 = r2.f11705P0
            r14 = 16
            r2.zzbl(r14)
            int r2 = r2.readInt()
            int r3 = f12287b
            r4 = 4
            r11 = -1
            if (r2 != r3) goto L_0x0023
            r10 = 1
            goto L_0x0043
        L_0x0023:
            int r3 = f12286a
            if (r2 != r3) goto L_0x0029
            r10 = 2
            goto L_0x0043
        L_0x0029:
            int r3 = f12288c
            if (r2 == r3) goto L_0x0042
            int r3 = f12289d
            if (r2 == r3) goto L_0x0042
            int r3 = f12290e
            if (r2 == r3) goto L_0x0042
            int r3 = f12291f
            if (r2 != r3) goto L_0x003a
            goto L_0x0042
        L_0x003a:
            int r3 = f12293h
            if (r2 != r3) goto L_0x0040
            r10 = 4
            goto L_0x0043
        L_0x0040:
            r10 = -1
            goto L_0x0043
        L_0x0042:
            r10 = 3
        L_0x0043:
            r8 = 0
            if (r10 != r11) goto L_0x0047
            return r8
        L_0x0047:
            int r2 = com.google.android.gms.internal.ads.ue0.f11356P
            com.google.android.gms.internal.ads.we0 r2 = r0.mo15028f(r2)
            com.google.android.gms.internal.ads.zzpn r2 = r2.f11705P0
            r7 = 8
            r2.zzbl(r7)
            int r3 = r2.readInt()
            int r3 = com.google.android.gms.internal.ads.ue0.m7041a(r3)
            if (r3 != 0) goto L_0x0061
            r5 = 8
            goto L_0x0063
        L_0x0061:
            r5 = 16
        L_0x0063:
            r2.zzbm(r5)
            int r5 = r2.readInt()
            r2.zzbm(r4)
            int r6 = r2.getPosition()
            if (r3 != 0) goto L_0x0075
            r12 = 4
            goto L_0x0077
        L_0x0075:
            r12 = 8
        L_0x0077:
            r9 = 0
        L_0x0078:
            if (r9 >= r12) goto L_0x0088
            byte[] r8 = r2.data
            int r20 = r6 + r9
            byte r8 = r8[r20]
            if (r8 == r11) goto L_0x0084
            r6 = 0
            goto L_0x0089
        L_0x0084:
            int r9 = r9 + 1
            r8 = 0
            goto L_0x0078
        L_0x0088:
            r6 = 1
        L_0x0089:
            r20 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 == 0) goto L_0x0097
            r2.zzbm(r12)
        L_0x0095:
            r11 = r8
            goto L_0x00a9
        L_0x0097:
            if (r3 != 0) goto L_0x009e
            long r22 = r2.zzjc()
            goto L_0x00a2
        L_0x009e:
            long r22 = r2.zzjg()
        L_0x00a2:
            int r3 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            if (r3 != 0) goto L_0x00a7
            goto L_0x0095
        L_0x00a7:
            r11 = r22
        L_0x00a9:
            r2.zzbm(r14)
            int r3 = r2.readInt()
            int r6 = r2.readInt()
            r2.zzbm(r4)
            int r4 = r2.readInt()
            int r2 = r2.readInt()
            r14 = 65536(0x10000, float:9.18355E-41)
            r13 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00ce
            if (r6 != r14) goto L_0x00ce
            if (r4 != r13) goto L_0x00ce
            if (r2 != 0) goto L_0x00ce
            r2 = 90
            goto L_0x00e5
        L_0x00ce:
            if (r3 != 0) goto L_0x00d9
            if (r6 != r13) goto L_0x00d9
            if (r4 != r14) goto L_0x00d9
            if (r2 != 0) goto L_0x00d9
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x00e5
        L_0x00d9:
            if (r3 != r13) goto L_0x00e4
            if (r6 != 0) goto L_0x00e4
            if (r4 != 0) goto L_0x00e4
            if (r2 != r13) goto L_0x00e4
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x00e5
        L_0x00e4:
            r2 = 0
        L_0x00e5:
            com.google.android.gms.internal.ads.ff0 r14 = new com.google.android.gms.internal.ads.ff0
            r14.<init>(r5, r11, r2)
            int r2 = (r51 > r8 ? 1 : (r51 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x00f7
            long r2 = r14.f8456b
            r26 = r2
            r2 = r50
            goto L_0x00fb
        L_0x00f7:
            r2 = r50
            r26 = r51
        L_0x00fb:
            com.google.android.gms.internal.ads.zzpn r2 = r2.f11705P0
            r2.zzbl(r7)
            int r3 = r2.readInt()
            int r3 = com.google.android.gms.internal.ads.ue0.m7041a(r3)
            if (r3 != 0) goto L_0x010d
            r3 = 8
            goto L_0x010f
        L_0x010d:
            r3 = 16
        L_0x010f:
            r2.zzbm(r3)
            long r32 = r2.zzjc()
            int r2 = (r26 > r8 ? 1 : (r26 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x011d
            r26 = r8
            goto L_0x0128
        L_0x011d:
            r28 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r32
            long r2 = com.google.android.gms.internal.ads.zzpt.zza((long) r26, (long) r28, (long) r30)
            r26 = r2
        L_0x0128:
            int r2 = com.google.android.gms.internal.ads.ue0.f11338G
            com.google.android.gms.internal.ads.xe0 r2 = r1.mo15029g(r2)
            int r3 = com.google.android.gms.internal.ads.ue0.f11340H
            com.google.android.gms.internal.ads.xe0 r2 = r2.mo15029g(r3)
            int r3 = com.google.android.gms.internal.ads.ue0.f11359S
            com.google.android.gms.internal.ads.we0 r1 = r1.mo15028f(r3)
            com.google.android.gms.internal.ads.zzpn r1 = r1.f11705P0
            r1.zzbl(r7)
            int r3 = r1.readInt()
            int r3 = com.google.android.gms.internal.ads.ue0.m7041a(r3)
            if (r3 != 0) goto L_0x014c
            r4 = 8
            goto L_0x014e
        L_0x014c:
            r4 = 16
        L_0x014e:
            r1.zzbm(r4)
            long r4 = r1.zzjc()
            if (r3 != 0) goto L_0x0159
            r3 = 4
            goto L_0x015b
        L_0x0159:
            r3 = 8
        L_0x015b:
            r1.zzbm(r3)
            int r1 = r1.readUnsignedShort()
            int r3 = r1 >> 10
            r3 = r3 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r9 = 3
            r8.<init>(r9)
            r8.append(r3)
            r8.append(r6)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            android.util.Pair r13 = android.util.Pair.create(r3, r1)
            int r1 = com.google.android.gms.internal.ads.ue0.f11361U
            com.google.android.gms.internal.ads.we0 r1 = r2.mo15028f(r1)
            com.google.android.gms.internal.ads.zzpn r12 = r1.f11705P0
            int r22 = r14.f8455a
            int r28 = r14.f8457c
            java.lang.Object r1 = r13.second
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11
            r1 = 12
            r12.zzbl(r1)
            int r9 = r12.readInt()
            com.google.android.gms.internal.ads.af0 r8 = new com.google.android.gms.internal.ads.af0
            r8.<init>(r9)
            r6 = 0
        L_0x01b4:
            if (r6 >= r9) goto L_0x07ae
            int r5 = r12.getPosition()
            int r4 = r12.readInt()
            if (r4 <= 0) goto L_0x01c2
            r1 = 1
            goto L_0x01c3
        L_0x01c2:
            r1 = 0
        L_0x01c3:
            java.lang.String r3 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzpc.checkArgument(r1, r3)
            int r1 = r12.readInt()
            int r2 = com.google.android.gms.internal.ads.ue0.f11370c
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11372d
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11367a0
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11389l0
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11374e
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11376f
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11378g
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11347K0
            if (r1 == r2) goto L_0x05a5
            int r2 = com.google.android.gms.internal.ads.ue0.f11349L0
            if (r1 != r2) goto L_0x01f2
            goto L_0x05a5
        L_0x01f2:
            int r2 = com.google.android.gms.internal.ads.ue0.f11384j
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11369b0
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11394o
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11398q
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11402s
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11408v
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11404t
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11406u
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11415y0
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11417z0
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11390m
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11392n
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11386k
            if (r1 == r2) goto L_0x0310
            int r2 = com.google.android.gms.internal.ads.ue0.f11355O0
            if (r1 != r2) goto L_0x022c
            goto L_0x0310
        L_0x022c:
            int r2 = com.google.android.gms.internal.ads.ue0.f11387k0
            if (r1 == r2) goto L_0x0272
            int r3 = com.google.android.gms.internal.ads.ue0.f11407u0
            if (r1 == r3) goto L_0x0272
            int r3 = com.google.android.gms.internal.ads.ue0.f11409v0
            if (r1 == r3) goto L_0x0272
            int r3 = com.google.android.gms.internal.ads.ue0.f11411w0
            if (r1 == r3) goto L_0x0272
            int r3 = com.google.android.gms.internal.ads.ue0.f11413x0
            if (r1 != r3) goto L_0x0241
            goto L_0x0272
        L_0x0241:
            int r2 = com.google.android.gms.internal.ads.ue0.f11353N0
            if (r1 != r2) goto L_0x0254
            java.lang.String r1 = java.lang.Integer.toString(r22)
            java.lang.String r2 = "application/x-camera-motion"
            r3 = -1
            r7 = 0
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r7, r3, r15)
            r8.f7812b = r1
            goto L_0x0255
        L_0x0254:
            r7 = 0
        L_0x0255:
            r24 = r4
            r29 = r5
            r37 = r6
            r0 = r8
            r19 = r9
            r18 = r10
            r36 = r11
            r16 = r12
            r48 = r13
            r23 = r14
            r17 = -1
            r25 = 3
            r30 = 0
            r31 = 16
            goto L_0x0791
        L_0x0272:
            r3 = -1
            r7 = 0
            int r24 = r5 + 8
            r19 = 8
            int r3 = r24 + 8
            r12.zzbl(r3)
            r30 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.String r3 = "application/ttml+xml"
            if (r1 != r2) goto L_0x028d
            r2 = r3
            r17 = r7
        L_0x0289:
            r3 = 1
            r18 = 0
            goto L_0x02c7
        L_0x028d:
            int r2 = com.google.android.gms.internal.ads.ue0.f11407u0
            if (r1 != r2) goto L_0x02a4
            int r1 = r4 + -8
            int r1 = r1 + -8
            byte[] r2 = new byte[r1]
            r3 = 0
            r12.zze(r2, r3, r1)
            java.util.List r1 = java.util.Collections.singletonList(r2)
            java.lang.String r2 = "application/x-quicktime-tx3g"
            r17 = r1
            goto L_0x0289
        L_0x02a4:
            r18 = 0
            int r2 = com.google.android.gms.internal.ads.ue0.f11409v0
            if (r1 != r2) goto L_0x02b1
            java.lang.String r1 = "application/x-mp4-vtt"
            r2 = r1
            r17 = r7
        L_0x02af:
            r3 = 1
            goto L_0x02c7
        L_0x02b1:
            int r2 = com.google.android.gms.internal.ads.ue0.f11411w0
            if (r1 != r2) goto L_0x02bb
            r2 = r3
            r17 = r7
            r30 = r20
            goto L_0x02af
        L_0x02bb:
            int r2 = com.google.android.gms.internal.ads.ue0.f11413x0
            if (r1 != r2) goto L_0x030a
            r3 = 1
            r8.f7814d = r3
            java.lang.String r1 = "application/x-mp4-cea-608"
            r2 = r1
            r17 = r7
        L_0x02c7:
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r24 = 0
            r34 = -1
            r35 = 0
            r36 = -1
            r29 = -1
            r37 = 1
            r3 = r24
            r24 = r14
            r14 = r4
            r4 = r34
            r38 = r5
            r5 = r35
            r39 = r6
            r6 = r11
            r19 = r7
            r7 = r36
            r40 = r8
            r8 = r53
            r19 = r9
            r18 = r10
            r9 = r30
            r0 = r11
            r11 = r17
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11)
            r11 = r40
            r11.f7812b = r1
            r36 = r0
            r0 = r11
            r16 = r12
            r48 = r13
            r23 = r24
            r29 = r38
            goto L_0x0367
        L_0x030a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0310:
            r38 = r5
            r39 = r6
            r19 = r9
            r18 = r10
            r0 = r11
            r24 = r14
            r14 = r4
            r11 = r8
            r10 = r38
            int r5 = r10 + 8
            r9 = 8
            int r5 = r5 + r9
            r12.zzbl(r5)
            r2 = 6
            if (r54 == 0) goto L_0x0332
            int r4 = r12.readUnsignedShort()
            r12.zzbm(r2)
            goto L_0x0336
        L_0x0332:
            r12.zzbm(r9)
            r4 = 0
        L_0x0336:
            if (r4 == 0) goto L_0x0375
            r8 = 1
            if (r4 != r8) goto L_0x033d
            r7 = 2
            goto L_0x0377
        L_0x033d:
            r7 = 2
            if (r4 != r7) goto L_0x035c
            r2 = 16
            r12.zzbm(r2)
            long r4 = r12.readLong()
            double r4 = java.lang.Double.longBitsToDouble(r4)
            long r4 = java.lang.Math.round(r4)
            int r2 = (int) r4
            int r4 = r12.zzjf()
            r5 = 20
            r12.zzbm(r5)
            goto L_0x038a
        L_0x035c:
            r36 = r0
            r29 = r10
            r0 = r11
            r16 = r12
            r48 = r13
            r23 = r24
        L_0x0367:
            r37 = r39
            r17 = -1
            r25 = 3
            r30 = 0
        L_0x036f:
            r31 = 16
            r24 = r14
            goto L_0x0791
        L_0x0375:
            r7 = 2
            r8 = 1
        L_0x0377:
            int r5 = r12.readUnsignedShort()
            r12.zzbm(r2)
            int r2 = r12.zzje()
            if (r4 != r8) goto L_0x0389
            r4 = 16
            r12.zzbm(r4)
        L_0x0389:
            r4 = r5
        L_0x038a:
            int r5 = r12.getPosition()
            int r6 = com.google.android.gms.internal.ads.ue0.f11369b0
            if (r1 != r6) goto L_0x039c
            r6 = r39
            int r1 = m7406a(r12, r10, r14, r11, r6)
            r12.zzbl(r5)
            goto L_0x039e
        L_0x039c:
            r6 = r39
        L_0x039e:
            int r7 = com.google.android.gms.internal.ads.ue0.f11394o
            java.lang.String r8 = "audio/raw"
            if (r1 != r7) goto L_0x03a7
            java.lang.String r1 = "audio/ac3"
            goto L_0x03f0
        L_0x03a7:
            int r7 = com.google.android.gms.internal.ads.ue0.f11398q
            if (r1 != r7) goto L_0x03ae
            java.lang.String r1 = "audio/eac3"
            goto L_0x03f0
        L_0x03ae:
            int r7 = com.google.android.gms.internal.ads.ue0.f11402s
            if (r1 != r7) goto L_0x03b5
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x03f0
        L_0x03b5:
            int r7 = com.google.android.gms.internal.ads.ue0.f11404t
            if (r1 == r7) goto L_0x03ee
            int r7 = com.google.android.gms.internal.ads.ue0.f11406u
            if (r1 != r7) goto L_0x03be
            goto L_0x03ee
        L_0x03be:
            int r7 = com.google.android.gms.internal.ads.ue0.f11408v
            if (r1 != r7) goto L_0x03c5
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03f0
        L_0x03c5:
            int r7 = com.google.android.gms.internal.ads.ue0.f11415y0
            if (r1 != r7) goto L_0x03cc
            java.lang.String r1 = "audio/3gpp"
            goto L_0x03f0
        L_0x03cc:
            int r7 = com.google.android.gms.internal.ads.ue0.f11417z0
            if (r1 != r7) goto L_0x03d3
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x03f0
        L_0x03d3:
            int r7 = com.google.android.gms.internal.ads.ue0.f11390m
            if (r1 == r7) goto L_0x03ec
            int r7 = com.google.android.gms.internal.ads.ue0.f11392n
            if (r1 != r7) goto L_0x03dc
            goto L_0x03ec
        L_0x03dc:
            int r7 = com.google.android.gms.internal.ads.ue0.f11386k
            if (r1 != r7) goto L_0x03e3
            java.lang.String r1 = "audio/mpeg"
            goto L_0x03f0
        L_0x03e3:
            int r7 = com.google.android.gms.internal.ads.ue0.f11355O0
            if (r1 != r7) goto L_0x03ea
            java.lang.String r1 = "audio/alac"
            goto L_0x03f0
        L_0x03ea:
            r1 = 0
            goto L_0x03f0
        L_0x03ec:
            r1 = r8
            goto L_0x03f0
        L_0x03ee:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x03f0:
            r7 = r1
            r30 = r2
            r17 = r4
            r31 = 0
        L_0x03f7:
            int r1 = r5 - r10
            if (r1 >= r14) goto L_0x0543
            r12.zzbl(r5)
            int r4 = r12.readInt()
            if (r4 <= 0) goto L_0x0406
            r1 = 1
            goto L_0x0407
        L_0x0406:
            r1 = 0
        L_0x0407:
            com.google.android.gms.internal.ads.zzpc.checkArgument(r1, r3)
            int r1 = r12.readInt()
            int r2 = com.google.android.gms.internal.ads.ue0.f11346K
            if (r1 == r2) goto L_0x04be
            if (r54 == 0) goto L_0x041a
            int r9 = com.google.android.gms.internal.ads.ue0.f11388l
            if (r1 != r9) goto L_0x041a
            goto L_0x04be
        L_0x041a:
            int r2 = com.google.android.gms.internal.ads.ue0.f11396p
            if (r1 != r2) goto L_0x043e
            int r1 = r5 + 8
            r12.zzbl(r1)
            java.lang.String r1 = java.lang.Integer.toString(r22)
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzid.zza(r12, r1, r0, r15)
            r11.f7812b = r1
        L_0x042d:
            r41 = r3
            r3 = r4
            r43 = r6
            r44 = r7
            r45 = r8
            r47 = r10
            r15 = r11
            r11 = 0
            r16 = 2
            goto L_0x04b7
        L_0x043e:
            int r2 = com.google.android.gms.internal.ads.ue0.f11400r
            if (r1 != r2) goto L_0x0452
            int r1 = r5 + 8
            r12.zzbl(r1)
            java.lang.String r1 = java.lang.Integer.toString(r22)
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzid.zzb(r12, r1, r0, r15)
            r11.f7812b = r1
            goto L_0x042d
        L_0x0452:
            int r2 = com.google.android.gms.internal.ads.ue0.f11410w
            if (r1 != r2) goto L_0x048d
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r9 = 0
            r34 = -1
            r35 = -1
            r36 = 0
            r37 = 0
            r2 = r7
            r41 = r3
            r3 = r9
            r9 = r4
            r4 = r34
            r42 = r5
            r5 = r35
            r43 = r6
            r6 = r17
            r44 = r7
            r16 = 2
            r7 = r30
            r45 = r8
            r8 = r36
            r46 = r9
            r9 = r53
            r47 = r10
            r10 = r37
            r15 = r11
            r11 = r0
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.f7812b = r1
            goto L_0x04b2
        L_0x048d:
            r41 = r3
            r46 = r4
            r42 = r5
            r43 = r6
            r44 = r7
            r45 = r8
            r47 = r10
            r15 = r11
            r16 = 2
            int r2 = com.google.android.gms.internal.ads.ue0.f11355O0
            if (r1 != r2) goto L_0x04b2
            r3 = r46
            byte[] r1 = new byte[r3]
            r5 = r42
            r12.zzbl(r5)
            r11 = 0
            r12.zze(r1, r11, r3)
            r31 = r1
            goto L_0x04b7
        L_0x04b2:
            r5 = r42
            r3 = r46
            r11 = 0
        L_0x04b7:
            r4 = r41
            r7 = r44
            r10 = -1
            goto L_0x0534
        L_0x04be:
            r41 = r3
            r3 = r4
            r43 = r6
            r44 = r7
            r45 = r8
            r47 = r10
            r15 = r11
            r11 = 0
            r16 = 2
            if (r1 != r2) goto L_0x04d4
            r1 = r5
            r4 = r41
        L_0x04d2:
            r10 = -1
            goto L_0x04fe
        L_0x04d4:
            int r1 = r12.getPosition()
        L_0x04d8:
            int r2 = r1 - r5
            if (r2 >= r3) goto L_0x04fa
            r12.zzbl(r1)
            int r2 = r12.readInt()
            r4 = r41
            if (r2 <= 0) goto L_0x04e9
            r9 = 1
            goto L_0x04ea
        L_0x04e9:
            r9 = 0
        L_0x04ea:
            com.google.android.gms.internal.ads.zzpc.checkArgument(r9, r4)
            int r6 = r12.readInt()
            int r7 = com.google.android.gms.internal.ads.ue0.f11346K
            if (r6 != r7) goto L_0x04f6
            goto L_0x04d2
        L_0x04f6:
            int r1 = r1 + r2
            r41 = r4
            goto L_0x04d8
        L_0x04fa:
            r4 = r41
            r1 = -1
            goto L_0x04d2
        L_0x04fe:
            if (r1 == r10) goto L_0x0532
            android.util.Pair r1 = m7410e(r12, r1)
            java.lang.Object r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.second
            r31 = r1
            byte[] r31 = (byte[]) r31
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0530
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzpf.zze(r31)
            java.lang.Object r6 = r1.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r17 = r1
            r7 = r2
            r30 = r6
            goto L_0x0534
        L_0x0530:
            r7 = r2
            goto L_0x0534
        L_0x0532:
            r7 = r44
        L_0x0534:
            int r5 = r5 + r3
            r3 = r4
            r11 = r15
            r6 = r43
            r8 = r45
            r10 = r47
            r9 = 8
            r15 = r53
            goto L_0x03f7
        L_0x0543:
            r43 = r6
            r44 = r7
            r45 = r8
            r47 = r10
            r15 = r11
            r10 = -1
            r11 = 0
            r16 = 2
            com.google.android.gms.internal.ads.zzhp r1 = r15.f7812b
            if (r1 != 0) goto L_0x058d
            r7 = r44
            if (r7 == 0) goto L_0x058d
            r1 = r45
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x0562
            r8 = 2
            goto L_0x0563
        L_0x0562:
            r8 = -1
        L_0x0563:
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r3 = 0
            r4 = -1
            r5 = -1
            if (r31 != 0) goto L_0x056e
            r9 = 0
            goto L_0x0573
        L_0x056e:
            java.util.List r2 = java.util.Collections.singletonList(r31)
            r9 = r2
        L_0x0573:
            r29 = 0
            r2 = r7
            r6 = r17
            r7 = r30
            r17 = -1
            r10 = r53
            r30 = 0
            r11 = r29
            r50 = r13
            r13 = r12
            r12 = r0
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r15.f7812b = r1
            goto L_0x0594
        L_0x058d:
            r50 = r13
            r17 = -1
            r30 = 0
            r13 = r12
        L_0x0594:
            r48 = r50
            r36 = r0
            r16 = r13
            r0 = r15
            r23 = r24
            r37 = r43
            r29 = r47
        L_0x05a1:
            r25 = 3
            goto L_0x036f
        L_0x05a5:
            r47 = r5
            r43 = r6
            r15 = r8
            r19 = r9
            r18 = r10
            r0 = r11
            r50 = r13
            r24 = r14
            r17 = -1
            r30 = 0
            r14 = r4
            r13 = r12
            r4 = r3
            r12 = r47
            int r5 = r12 + 8
            r11 = 8
            int r5 = r5 + r11
            r13.zzbl(r5)
            r10 = 16
            r13.zzbm(r10)
            int r6 = r13.readUnsignedShort()
            int r7 = r13.readUnsignedShort()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 50
            r13.zzbm(r3)
            int r3 = r13.getPosition()
            int r5 = com.google.android.gms.internal.ads.ue0.f11367a0
            r9 = r43
            if (r1 != r5) goto L_0x05e9
            int r1 = m7406a(r13, r12, r14, r15, r9)
            r13.zzbl(r3)
        L_0x05e9:
            r2 = 0
            r5 = 0
            r23 = 0
            r29 = 1065353216(0x3f800000, float:1.0)
            r31 = 0
            r34 = -1
        L_0x05f3:
            int r8 = r3 - r12
            if (r8 >= r14) goto L_0x0740
            r13.zzbl(r3)
            int r8 = r13.getPosition()
            int r10 = r13.readInt()
            if (r10 != 0) goto L_0x060c
            int r36 = r13.getPosition()
            int r11 = r36 - r12
            if (r11 == r14) goto L_0x0740
        L_0x060c:
            if (r10 <= 0) goto L_0x0610
            r11 = 1
            goto L_0x0611
        L_0x0610:
            r11 = 0
        L_0x0611:
            com.google.android.gms.internal.ads.zzpc.checkArgument(r11, r4)
            int r11 = r13.readInt()
            r36 = r0
            int r0 = com.google.android.gms.internal.ads.ue0.f11342I
            if (r11 != r0) goto L_0x063e
            if (r2 != 0) goto L_0x0622
            r0 = 1
            goto L_0x0623
        L_0x0622:
            r0 = 0
        L_0x0623:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            int r8 = r8 + 8
            r13.zzbl(r8)
            com.google.android.gms.internal.ads.zzpv r0 = com.google.android.gms.internal.ads.zzpv.zzg(r13)
            java.util.List<byte[]> r2 = r0.zzahc
            int r8 = r0.zzasp
            r15.f7813c = r8
            if (r5 != 0) goto L_0x063b
            float r0 = r0.zzbkb
            r29 = r0
        L_0x063b:
            java.lang.String r0 = "video/avc"
            goto L_0x065b
        L_0x063e:
            int r0 = com.google.android.gms.internal.ads.ue0.f11344J
            if (r11 != r0) goto L_0x0667
            if (r2 != 0) goto L_0x0646
            r0 = 1
            goto L_0x0647
        L_0x0646:
            r0 = 0
        L_0x0647:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            int r8 = r8 + 8
            r13.zzbl(r8)
            com.google.android.gms.internal.ads.zzqb r0 = com.google.android.gms.internal.ads.zzqb.zzi(r13)
            java.util.List<byte[]> r2 = r0.zzahc
            int r0 = r0.zzasp
            r15.f7813c = r0
            java.lang.String r0 = "video/hevc"
        L_0x065b:
            r37 = r1
            r23 = r2
            r41 = r4
            r4 = 2
            r8 = 1
            r11 = 3
            r2 = r0
            goto L_0x0733
        L_0x0667:
            int r0 = com.google.android.gms.internal.ads.ue0.f11351M0
            if (r11 != r0) goto L_0x067e
            if (r2 != 0) goto L_0x066f
            r0 = 1
            goto L_0x0670
        L_0x066f:
            r0 = 0
        L_0x0670:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            int r0 = com.google.android.gms.internal.ads.ue0.f11347K0
            if (r1 != r0) goto L_0x067a
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x067c
        L_0x067a:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
        L_0x067c:
            r2 = r0
            goto L_0x068c
        L_0x067e:
            int r0 = com.google.android.gms.internal.ads.ue0.f11380h
            if (r11 != r0) goto L_0x0692
            if (r2 != 0) goto L_0x0686
            r0 = 1
            goto L_0x0687
        L_0x0686:
            r0 = 0
        L_0x0687:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            java.lang.String r2 = "video/3gpp"
        L_0x068c:
            r37 = r1
            r41 = r4
        L_0x0690:
            r4 = 2
            goto L_0x06ca
        L_0x0692:
            int r0 = com.google.android.gms.internal.ads.ue0.f11346K
            if (r11 != r0) goto L_0x06af
            if (r2 != 0) goto L_0x069a
            r0 = 1
            goto L_0x069b
        L_0x069a:
            r0 = 0
        L_0x069b:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            android.util.Pair r0 = m7410e(r13, r8)
            java.lang.Object r2 = r0.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            java.util.List r23 = java.util.Collections.singletonList(r0)
            goto L_0x068c
        L_0x06af:
            int r0 = com.google.android.gms.internal.ads.ue0.f11385j0
            if (r11 != r0) goto L_0x06ce
            int r8 = r8 + 8
            r13.zzbl(r8)
            int r0 = r13.zzjf()
            int r5 = r13.zzjf()
            float r0 = (float) r0
            float r5 = (float) r5
            float r29 = r0 / r5
            r37 = r1
            r41 = r4
            r4 = 2
            r5 = 1
        L_0x06ca:
            r8 = 1
            r11 = 3
            goto L_0x0733
        L_0x06ce:
            int r0 = com.google.android.gms.internal.ads.ue0.f11343I0
            if (r11 != r0) goto L_0x0701
            int r0 = r8 + 8
        L_0x06d4:
            int r11 = r0 - r8
            if (r11 >= r10) goto L_0x06f9
            r13.zzbl(r0)
            int r11 = r13.readInt()
            r37 = r1
            int r1 = r13.readInt()
            r41 = r4
            int r4 = com.google.android.gms.internal.ads.ue0.f11345J0
            if (r1 != r4) goto L_0x06f3
            byte[] r1 = r13.data
            int r11 = r11 + r0
            byte[] r8 = java.util.Arrays.copyOfRange(r1, r0, r11)
            goto L_0x06fe
        L_0x06f3:
            int r0 = r0 + r11
            r1 = r37
            r4 = r41
            goto L_0x06d4
        L_0x06f9:
            r37 = r1
            r41 = r4
            r8 = 0
        L_0x06fe:
            r31 = r8
            goto L_0x0690
        L_0x0701:
            r37 = r1
            r41 = r4
            int r0 = com.google.android.gms.internal.ads.ue0.f11341H0
            if (r11 != r0) goto L_0x0690
            int r0 = r13.readUnsignedByte()
            r11 = 3
            r13.zzbm(r11)
            if (r0 != 0) goto L_0x0731
            int r0 = r13.readUnsignedByte()
            if (r0 == 0) goto L_0x072c
            r8 = 1
            if (r0 == r8) goto L_0x0728
            r4 = 2
            if (r0 == r4) goto L_0x0725
            if (r0 == r11) goto L_0x0722
            goto L_0x0733
        L_0x0722:
            r34 = 3
            goto L_0x0733
        L_0x0725:
            r34 = 2
            goto L_0x0733
        L_0x0728:
            r4 = 2
            r34 = 1
            goto L_0x0733
        L_0x072c:
            r4 = 2
            r8 = 1
            r34 = 0
            goto L_0x0733
        L_0x0731:
            r4 = 2
            r8 = 1
        L_0x0733:
            int r3 = r3 + r10
            r0 = r36
            r1 = r37
            r4 = r41
            r10 = 16
            r11 = 8
            goto L_0x05f3
        L_0x0740:
            r36 = r0
            r4 = 2
            r8 = 1
            r11 = 3
            if (r2 == 0) goto L_0x0784
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r3 = 0
            r0 = -1
            r5 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = 0
            r25 = 2
            r4 = r0
            r0 = 1
            r8 = r10
            r37 = r9
            r9 = r23
            r23 = 16
            r10 = r28
            r0 = 8
            r35 = 3
            r11 = r29
            r29 = r12
            r12 = r31
            r48 = r50
            r0 = r13
            r25 = 3
            r13 = r34
            r23 = r24
            r31 = 16
            r24 = r14
            r14 = r16
            r16 = r0
            r0 = r15
            r15 = r53
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.f7812b = r1
            goto L_0x0791
        L_0x0784:
            r48 = r50
            r37 = r9
            r29 = r12
            r16 = r13
            r0 = r15
            r23 = r24
            goto L_0x05a1
        L_0x0791:
            int r5 = r29 + r24
            r1 = r16
            r1.zzbl(r5)
            int r6 = r37 + 1
            r15 = r53
            r8 = r0
            r12 = r1
            r10 = r18
            r9 = r19
            r14 = r23
            r11 = r36
            r13 = r48
            r7 = 8
            r0 = r49
            goto L_0x01b4
        L_0x07ae:
            r0 = r8
            r18 = r10
            r48 = r13
            r23 = r14
            r30 = 0
            int r1 = com.google.android.gms.internal.ads.ue0.f11357Q
            r2 = r49
            com.google.android.gms.internal.ads.xe0 r1 = r2.mo15029g(r1)
            if (r1 == 0) goto L_0x081c
            int r2 = com.google.android.gms.internal.ads.ue0.f11358R
            com.google.android.gms.internal.ads.we0 r1 = r1.mo15028f(r2)
            if (r1 != 0) goto L_0x07ca
            goto L_0x081c
        L_0x07ca:
            com.google.android.gms.internal.ads.zzpn r1 = r1.f11705P0
            r2 = 8
            r1.zzbl(r2)
            int r2 = r1.readInt()
            int r2 = com.google.android.gms.internal.ads.ue0.m7041a(r2)
            int r3 = r1.zzjf()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r9 = 0
        L_0x07e2:
            if (r9 >= r3) goto L_0x0815
            r6 = 1
            if (r2 != r6) goto L_0x07ec
            long r7 = r1.zzjg()
            goto L_0x07f0
        L_0x07ec:
            long r7 = r1.zzjc()
        L_0x07f0:
            r4[r9] = r7
            if (r2 != r6) goto L_0x07f9
            long r7 = r1.readLong()
            goto L_0x07fe
        L_0x07f9:
            int r7 = r1.readInt()
            long r7 = (long) r7
        L_0x07fe:
            r5[r9] = r7
            short r7 = r1.readShort()
            if (r7 != r6) goto L_0x080d
            r7 = 2
            r1.zzbm(r7)
            int r9 = r9 + 1
            goto L_0x07e2
        L_0x080d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0815:
            android.util.Pair r1 = android.util.Pair.create(r4, r5)
            r2 = r1
            r1 = 0
            goto L_0x0821
        L_0x081c:
            r1 = 0
            android.util.Pair r2 = android.util.Pair.create(r1, r1)
        L_0x0821:
            com.google.android.gms.internal.ads.zzhp r3 = r0.f7812b
            if (r3 != 0) goto L_0x0826
            return r1
        L_0x0826:
            com.google.android.gms.internal.ads.zzlo r1 = new com.google.android.gms.internal.ads.zzlo
            int r16 = r23.f8455a
            r3 = r48
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            com.google.android.gms.internal.ads.zzhp r5 = r0.f7812b
            int r6 = r0.f7814d
            com.google.android.gms.internal.ads.zzlr[] r7 = r0.f7811a
            int r0 = r0.f7813c
            java.lang.Object r8 = r2.first
            r28 = r8
            long[] r28 = (long[]) r28
            java.lang.Object r2 = r2.second
            r29 = r2
            long[] r29 = (long[]) r29
            r15 = r1
            r17 = r18
            r18 = r3
            r20 = r32
            r22 = r26
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r0
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ze0.m7407b(com.google.android.gms.internal.ads.xe0, com.google.android.gms.internal.ads.we0, long, com.google.android.gms.internal.ads.zzjo, boolean):com.google.android.gms.internal.ads.zzlo");
    }

    /* renamed from: c */
    public static nf0 m7408c(zzlo zzlo, xe0 xe0, zzka zzka) {
        bf0 bf0;
        boolean z;
        int i;
        int i2;
        long j;
        int i3;
        int[] iArr;
        int i4;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        zzlo zzlo2;
        long j2;
        long[] jArr3;
        boolean z2;
        long[] jArr4;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int i5;
        int i6;
        int i7;
        int i8;
        zzlo zzlo3 = zzlo;
        xe0 xe02 = xe0;
        zzka zzka2 = zzka;
        we0 f = xe02.mo15028f(ue0.f11399q0);
        if (f != null) {
            bf0 = new df0(f);
        } else {
            we0 f2 = xe02.mo15028f(ue0.f11401r0);
            if (f2 != null) {
                bf0 = new cf0(f2);
            } else {
                throw new zzhw("Track has no sample table size information");
            }
        }
        int c = bf0.mo13705c();
        if (c == 0) {
            return new nf0(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        we0 f3 = xe02.mo15028f(ue0.f11403s0);
        if (f3 == null) {
            f3 = xe02.mo15028f(ue0.f11405t0);
            z = true;
        } else {
            z = false;
        }
        zzpn zzpn = f3.f11705P0;
        zzpn zzpn2 = xe02.mo15028f(ue0.f11397p0).f11705P0;
        zzpn zzpn3 = xe02.mo15028f(ue0.f11391m0).f11705P0;
        we0 f4 = xe02.mo15028f(ue0.f11393n0);
        zzpn zzpn4 = null;
        zzpn zzpn5 = f4 != null ? f4.f11705P0 : null;
        we0 f5 = xe02.mo15028f(ue0.f11395o0);
        zzpn zzpn6 = f5 != null ? f5.f11705P0 : null;
        ye0 ye0 = new ye0(zzpn2, zzpn, z);
        zzpn3.zzbl(12);
        int zzjf = zzpn3.zzjf() - 1;
        int zzjf2 = zzpn3.zzjf();
        int zzjf3 = zzpn3.zzjf();
        if (zzpn6 != null) {
            zzpn6.zzbl(12);
            i = zzpn6.zzjf();
        } else {
            i = 0;
        }
        int i9 = -1;
        if (zzpn5 != null) {
            zzpn5.zzbl(12);
            i2 = zzpn5.zzjf();
            if (i2 > 0) {
                i9 = zzpn5.zzjf() - 1;
                zzpn4 = zzpn5;
            }
        } else {
            zzpn4 = zzpn5;
            i2 = 0;
        }
        long j3 = 0;
        if (!(bf0.mo13704b() && "audio/raw".equals(zzlo3.zzahv.zzaha) && zzjf == 0 && i == 0 && i2 == 0)) {
            long[] jArr5 = new long[c];
            iArr = new int[c];
            jArr = new long[c];
            int i10 = i2;
            iArr2 = new int[c];
            zzpn zzpn7 = zzpn3;
            int i11 = i9;
            long j4 = 0;
            j = 0;
            int i12 = 0;
            i4 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = i;
            int i17 = zzjf3;
            int i18 = zzjf2;
            int i19 = zzjf;
            int i20 = i10;
            while (i12 < c) {
                while (i14 == 0) {
                    zzpc.checkState(ye0.mo15064a());
                    j4 = ye0.f12188d;
                    i14 = ye0.f12187c;
                    i17 = i17;
                    i18 = i18;
                }
                int i21 = i18;
                int i22 = i17;
                if (zzpn6 != null) {
                    while (i13 == 0 && i16 > 0) {
                        i13 = zzpn6.zzjf();
                        i15 = zzpn6.readInt();
                        i16--;
                    }
                    i13--;
                }
                int i23 = i15;
                jArr5[i12] = j4;
                iArr[i12] = bf0.mo13703a();
                if (iArr[i12] > i4) {
                    i4 = iArr[i12];
                }
                int i24 = c;
                bf0 bf02 = bf0;
                jArr[i12] = j + ((long) i23);
                iArr2[i12] = zzpn4 == null ? 1 : 0;
                if (i12 == i11) {
                    iArr2[i12] = 1;
                    i20--;
                    if (i20 > 0) {
                        i11 = zzpn4.zzjf() - 1;
                    }
                }
                int i25 = i22;
                long[] jArr6 = jArr5;
                j += (long) i25;
                int i26 = i21 - 1;
                if (i26 != 0 || i19 <= 0) {
                    int i27 = i26;
                    i7 = i25;
                    i8 = i27;
                } else {
                    i8 = zzpn7.zzjf();
                    i7 = zzpn7.zzjf();
                    i19--;
                }
                int i28 = i8;
                j4 += (long) iArr[i12];
                i14--;
                i12++;
                c = i24;
                jArr5 = jArr6;
                i11 = i11;
                i15 = i23;
                i18 = i28;
                bf0 bf03 = bf02;
                i17 = i7;
                bf0 = bf03;
            }
            i3 = c;
            long[] jArr7 = jArr5;
            int i29 = i18;
            zzpc.checkArgument(i13 == 0);
            while (i16 > 0) {
                zzpc.checkArgument(zzpn6.zzjf() == 0);
                zzpn6.readInt();
                i16--;
            }
            if (i20 == 0 && i29 == 0) {
                i6 = i14;
                if (i6 == 0 && i19 == 0) {
                    zzlo2 = zzlo;
                    jArr2 = jArr7;
                }
            } else {
                i6 = i14;
            }
            zzlo2 = zzlo;
            int i30 = zzlo2.f16668id;
            StringBuilder sb = new StringBuilder(215);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i30);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i20);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i29);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i6);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i19);
            Log.w("AtomParsers", sb.toString());
            jArr2 = jArr7;
        } else {
            zzlo2 = zzlo3;
            i3 = c;
            bf0 bf04 = bf0;
            int i31 = ye0.f12185a;
            long[] jArr8 = new long[i31];
            int[] iArr6 = new int[i31];
            while (ye0.mo15064a()) {
                int i32 = ye0.f12186b;
                jArr8[i32] = ye0.f12188d;
                iArr6[i32] = ye0.f12187c;
            }
            int a = bf04.mo13703a();
            long j5 = (long) zzjf3;
            int i33 = 8192 / a;
            int i34 = 0;
            for (int i35 = 0; i35 < i31; i35++) {
                i34 += zzpt.zzf(iArr6[i35], i33);
            }
            long[] jArr9 = new long[i34];
            int[] iArr7 = new int[i34];
            long[] jArr10 = new long[i34];
            int[] iArr8 = new int[i34];
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            while (i36 < i31) {
                int i40 = iArr6[i36];
                long j6 = jArr8[i36];
                int i41 = i40;
                int i42 = i31;
                int i43 = i41;
                while (i43 > 0) {
                    int min = Math.min(i33, i43);
                    jArr9[i38] = j6;
                    iArr7[i38] = a * min;
                    i39 = Math.max(i39, iArr7[i38]);
                    jArr10[i38] = ((long) i37) * j5;
                    iArr8[i38] = 1;
                    j6 += (long) iArr7[i38];
                    i37 += min;
                    i43 -= min;
                    i38++;
                    jArr8 = jArr8;
                    iArr6 = iArr6;
                }
                long[] jArr11 = jArr8;
                int[] iArr9 = iArr6;
                i36++;
                i31 = i42;
            }
            zzle zzle = new zzle(jArr9, iArr7, i39, jArr10, iArr8);
            jArr2 = zzle.zzaom;
            iArr = zzle.zzaol;
            i4 = zzle.zzaxg;
            jArr = zzle.zzaxh;
            iArr2 = zzle.zzaxi;
            j = 0;
        }
        if (zzlo2.zzbae == null || zzka.zzgs()) {
            zzpt.zza(jArr, 1000000, zzlo2.zzdd);
            return new nf0(jArr2, iArr, i4, jArr, iArr2);
        }
        long[] jArr12 = zzlo2.zzbae;
        if (jArr12.length == 1 && zzlo2.type == 1 && jArr.length >= 2) {
            long j7 = zzlo2.zzbaf[0];
            long zza = zzpt.zza(jArr12[0], zzlo2.zzdd, zzlo2.zzbab) + j7;
            if (jArr[0] <= j7 && j7 < jArr[1] && jArr[jArr.length - 1] < zza && zza <= j) {
                long j8 = j - zza;
                long zza2 = zzpt.zza(j7 - jArr[0], (long) zzlo2.zzahv.zzahl, zzlo2.zzdd);
                long zza3 = zzpt.zza(j8, (long) zzlo2.zzahv.zzahl, zzlo2.zzdd);
                if (!(zza2 == 0 && zza3 == 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    int i44 = (int) zza2;
                    zzka zzka3 = zzka;
                    zzka3.zzahn = i44;
                    zzka3.zzaho = (int) zza3;
                    zzpt.zza(jArr, 1000000, zzlo2.zzdd);
                    return new nf0(jArr2, iArr, i4, jArr, iArr2);
                }
            }
        }
        long[] jArr13 = zzlo2.zzbae;
        if (jArr13.length == 1) {
            char c2 = 0;
            if (jArr13[0] == 0) {
                int i45 = 0;
                while (i45 < jArr.length) {
                    jArr[i45] = zzpt.zza(jArr[i45] - zzlo2.zzbaf[c2], 1000000, zzlo2.zzdd);
                    i45++;
                    c2 = 0;
                }
                return new nf0(jArr2, iArr, i4, jArr, iArr2);
            }
        }
        boolean z3 = zzlo2.type == 1;
        boolean z4 = false;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        while (true) {
            long[] jArr14 = zzlo2.zzbae;
            j2 = -1;
            if (i48 >= jArr14.length) {
                break;
            }
            int i49 = i4;
            int[] iArr10 = iArr;
            long j9 = zzlo2.zzbaf[i48];
            if (j9 != -1) {
                i5 = i49;
                long zza4 = zzpt.zza(jArr14[i48], zzlo2.zzdd, zzlo2.zzbab);
                int zzb = zzpt.zzb(jArr, j9, true, true);
                int zzb2 = zzpt.zzb(jArr, j9 + zza4, z3, false);
                i46 += zzb2 - zzb;
                z4 |= i47 != zzb;
                i47 = zzb2;
            } else {
                i5 = i49;
            }
            i48++;
            iArr = iArr10;
            i4 = i5;
        }
        int i50 = i4;
        int[] iArr11 = iArr;
        boolean z5 = z4 | (i46 != i3);
        long[] jArr15 = z5 ? new long[i46] : jArr2;
        int[] iArr12 = z5 ? new int[i46] : iArr11;
        int i51 = z5 ? 0 : i50;
        int[] iArr13 = z5 ? new int[i46] : iArr2;
        long[] jArr16 = new long[i46];
        int i52 = i51;
        int i53 = 0;
        int i54 = 0;
        while (true) {
            long[] jArr17 = zzlo2.zzbae;
            if (i53 >= jArr17.length) {
                break;
            }
            int[] iArr14 = iArr12;
            int[] iArr15 = iArr13;
            long j10 = zzlo2.zzbaf[i53];
            long j11 = jArr17[i53];
            if (j10 != j2) {
                long j12 = zzlo2.zzdd;
                jArr4 = jArr15;
                long[] jArr18 = jArr2;
                int zzb3 = zzpt.zzb(jArr, j10, true, true);
                int zzb4 = zzpt.zzb(jArr, zzpt.zza(j11, j12, zzlo2.zzbab) + j10, z3, false);
                if (z5) {
                    int i55 = zzb4 - zzb3;
                    System.arraycopy(jArr18, zzb3, jArr4, i54, i55);
                    iArr4 = iArr11;
                    int[] iArr16 = iArr14;
                    z2 = z3;
                    iArr3 = iArr16;
                    System.arraycopy(iArr4, zzb3, iArr3, i54, i55);
                    jArr3 = jArr18;
                    iArr5 = iArr15;
                    System.arraycopy(iArr2, zzb3, iArr5, i54, i55);
                } else {
                    iArr4 = iArr11;
                    jArr3 = jArr18;
                    iArr5 = iArr15;
                    int[] iArr17 = iArr14;
                    z2 = z3;
                    iArr3 = iArr17;
                }
                int i56 = i52;
                while (zzb3 < zzb4) {
                    int[] iArr18 = iArr5;
                    int[] iArr19 = iArr4;
                    long j13 = j10;
                    jArr16[i54] = zzpt.zza(j3, 1000000, zzlo2.zzbab) + zzpt.zza(jArr[zzb3] - j10, 1000000, zzlo2.zzdd);
                    if (z5 && iArr3[i54] > i56) {
                        i56 = iArr19[zzb3];
                    }
                    i54++;
                    zzb3++;
                    iArr4 = iArr19;
                    j10 = j13;
                    iArr5 = iArr18;
                }
                iArr15 = iArr5;
                iArr11 = iArr4;
                i52 = i56;
            } else {
                jArr4 = jArr15;
                jArr3 = jArr2;
                int[] iArr20 = iArr14;
                z2 = z3;
                iArr3 = iArr20;
            }
            j3 += j11;
            i53++;
            iArr12 = iArr3;
            jArr15 = jArr4;
            z3 = z2;
            iArr13 = iArr15;
            jArr2 = jArr3;
            j2 = -1;
        }
        long[] jArr19 = jArr15;
        int[] iArr21 = iArr12;
        int[] iArr22 = iArr13;
        boolean z6 = false;
        for (int i57 = 0; i57 < iArr22.length && !z6; i57++) {
            z6 |= (iArr22[i57] & 1) != 0;
        }
        if (z6) {
            return new nf0(jArr19, iArr21, i52, jArr16, iArr22);
        }
        throw new zzhw("The edited sample sequence does not contain a sync sample.");
    }

    /* renamed from: d */
    public static zzmd m7409d(we0 we0, boolean z) {
        if (z) {
            return null;
        }
        zzpn zzpn = we0.f11705P0;
        zzpn.zzbl(8);
        while (zzpn.zzja() >= 8) {
            int position = zzpn.getPosition();
            int readInt = zzpn.readInt();
            if (zzpn.readInt() == ue0.f11329B0) {
                zzpn.zzbl(position);
                int i = position + readInt;
                zzpn.zzbm(12);
                while (true) {
                    if (zzpn.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzpn.getPosition();
                    int readInt2 = zzpn.readInt();
                    if (zzpn.readInt() == ue0.f11331C0) {
                        zzpn.zzbl(position2);
                        int i2 = position2 + readInt2;
                        zzpn.zzbm(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpn.getPosition() < i2) {
                            zzmd.zza d = jf0.m6362d(zzpn);
                            if (d != null) {
                                arrayList.add(d);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzmd((List<? extends zzmd.zza>) arrayList);
                        }
                    } else {
                        zzpn.zzbm(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpn.zzbm(readInt - 8);
        }
        return null;
    }

    /* renamed from: e */
    private static Pair<String, byte[]> m7410e(zzpn zzpn, int i) {
        zzpn.zzbl(i + 8 + 4);
        zzpn.zzbm(1);
        m7411f(zzpn);
        zzpn.zzbm(2);
        int readUnsignedByte = zzpn.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpn.zzbm(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpn.zzbm(zzpn.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpn.zzbm(2);
        }
        zzpn.zzbm(1);
        m7411f(zzpn);
        int readUnsignedByte2 = zzpn.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", (Object) null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", (Object) null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", (Object) null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzpn.zzbm(12);
        zzpn.zzbm(1);
        int f = m7411f(zzpn);
        byte[] bArr = new byte[f];
        zzpn.zze(bArr, 0, f);
        return Pair.create(str, bArr);
    }

    /* renamed from: f */
    private static int m7411f(zzpn zzpn) {
        int readUnsignedByte = zzpn.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpn.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
