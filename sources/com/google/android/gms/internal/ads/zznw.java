package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zznw extends zzob {

    /* renamed from: d */
    private final AtomicReference<zznz> f16779d;

    public zznw() {
        this((zzof) null);
    }

    /* renamed from: a */
    private static int m9034a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* renamed from: b */
    private static boolean m9035b(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0178, code lost:
        if (r10 <= r15) goto L_0x017d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzoc[] zza(com.google.android.gms.internal.ads.zzhx[] r33, com.google.android.gms.internal.ads.zznq[] r34, int[][][] r35) {
        /*
            r32 = this;
            r0 = r33
            int r1 = r0.length
            com.google.android.gms.internal.ads.zzoc[] r2 = new com.google.android.gms.internal.ads.zzoc[r1]
            r3 = r32
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zznz> r4 = r3.f16779d
            java.lang.Object r4 = r4.get()
            com.google.android.gms.internal.ads.zznz r4 = (com.google.android.gms.internal.ads.zznz) r4
            r6 = 0
            r7 = 0
        L_0x0011:
            r8 = 2
            if (r6 >= r1) goto L_0x0250
            r12 = r0[r6]
            int r12 = r12.getTrackType()
            if (r8 != r12) goto L_0x023a
            if (r7 != 0) goto L_0x022d
            r7 = r34[r6]
            r12 = r35[r6]
            int r13 = r4.zzbhe
            int r14 = r4.zzbhf
            int r15 = r4.zzbhg
            int r9 = r4.viewportWidth
            int r8 = r4.viewportHeight
            boolean r5 = r4.zzbhj
            boolean r10 = r4.zzbhh
            boolean r11 = r4.zzbhi
            r21 = r1
            r17 = r4
            r0 = 0
            r3 = 0
            r4 = 0
            r18 = 0
            r19 = -1
            r20 = -1
        L_0x003f:
            int r1 = r7.length
            if (r3 >= r1) goto L_0x020d
            com.google.android.gms.internal.ads.zznr r1 = r7.zzbb(r3)
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r23 = r2
            int r2 = r1.length
            r7.<init>(r2)
            r24 = r6
            r2 = 0
        L_0x0055:
            int r6 = r1.length
            if (r2 >= r6) goto L_0x0063
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r7.add(r6)
            int r2 = r2 + 1
            goto L_0x0055
        L_0x0063:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r2) goto L_0x0132
            if (r8 != r2) goto L_0x006c
            goto L_0x0132
        L_0x006c:
            r25 = r4
            r6 = 0
        L_0x006f:
            int r4 = r1.length
            if (r6 >= r4) goto L_0x00fc
            com.google.android.gms.internal.ads.zzhp r4 = r1.zzbc(r6)
            r26 = r0
            int r0 = r4.width
            if (r0 <= 0) goto L_0x00e2
            r27 = r10
            int r10 = r4.height
            if (r10 <= 0) goto L_0x00db
            r28 = r5
            if (r5 == 0) goto L_0x009b
            if (r0 <= r10) goto L_0x008b
            r5 = 1
            goto L_0x008c
        L_0x008b:
            r5 = 0
        L_0x008c:
            r29 = r8
            if (r9 <= r8) goto L_0x0092
            r8 = 1
            goto L_0x0093
        L_0x0092:
            r8 = 0
        L_0x0093:
            if (r5 == r8) goto L_0x009d
            r5 = r9
            r30 = r5
            r8 = r29
            goto L_0x00a2
        L_0x009b:
            r29 = r8
        L_0x009d:
            r8 = r9
            r30 = r8
            r5 = r29
        L_0x00a2:
            int r9 = r0 * r5
            r31 = r15
            int r15 = r10 * r8
            if (r9 < r15) goto L_0x00b4
            android.graphics.Point r5 = new android.graphics.Point
            int r0 = com.google.android.gms.internal.ads.zzpt.zzf(r15, r0)
            r5.<init>(r8, r0)
            goto L_0x00be
        L_0x00b4:
            android.graphics.Point r0 = new android.graphics.Point
            int r8 = com.google.android.gms.internal.ads.zzpt.zzf(r9, r10)
            r0.<init>(r8, r5)
            r5 = r0
        L_0x00be:
            int r0 = r4.width
            int r4 = r4.height
            int r8 = r0 * r4
            int r9 = r5.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r0 < r9) goto L_0x00ec
            int r0 = r5.y
            float r0 = (float) r0
            float r0 = r0 * r10
            int r0 = (int) r0
            if (r4 < r0) goto L_0x00ec
            if (r8 >= r2) goto L_0x00ec
            r2 = r8
            goto L_0x00ec
        L_0x00db:
            r28 = r5
            r29 = r8
            r30 = r9
            goto L_0x00ea
        L_0x00e2:
            r28 = r5
            r29 = r8
            r30 = r9
            r27 = r10
        L_0x00ea:
            r31 = r15
        L_0x00ec:
            int r6 = r6 + 1
            r0 = r26
            r10 = r27
            r5 = r28
            r8 = r29
            r9 = r30
            r15 = r31
            goto L_0x006f
        L_0x00fc:
            r26 = r0
            r28 = r5
            r29 = r8
            r30 = r9
            r27 = r10
            r31 = r15
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r0) goto L_0x0140
            int r0 = r7.size()
            r4 = 1
            int r0 = r0 - r4
        L_0x0113:
            if (r0 < 0) goto L_0x0140
            java.lang.Object r4 = r7.get(r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzhp r4 = r1.zzbc(r4)
            int r4 = r4.zzez()
            r5 = -1
            if (r4 == r5) goto L_0x012c
            if (r4 <= r2) goto L_0x012f
        L_0x012c:
            r7.remove(r0)
        L_0x012f:
            int r0 = r0 + -1
            goto L_0x0113
        L_0x0132:
            r26 = r0
            r25 = r4
            r28 = r5
            r29 = r8
            r30 = r9
            r27 = r10
            r31 = r15
        L_0x0140:
            r0 = r12[r3]
            r5 = r18
            r6 = r19
            r8 = r20
            r4 = r25
            r2 = 0
        L_0x014b:
            int r9 = r1.length
            if (r2 >= r9) goto L_0x01ef
            r9 = r0[r2]
            boolean r9 = m9035b(r9, r11)
            if (r9 == 0) goto L_0x01db
            com.google.android.gms.internal.ads.zzhp r9 = r1.zzbc(r2)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            boolean r10 = r7.contains(r10)
            if (r10 == 0) goto L_0x017f
            int r10 = r9.width
            r15 = -1
            if (r10 == r15) goto L_0x016c
            if (r10 > r13) goto L_0x017f
        L_0x016c:
            int r10 = r9.height
            if (r10 == r15) goto L_0x0172
            if (r10 > r14) goto L_0x017f
        L_0x0172:
            int r10 = r9.zzagw
            if (r10 == r15) goto L_0x017b
            r15 = r31
            if (r10 > r15) goto L_0x0181
            goto L_0x017d
        L_0x017b:
            r15 = r31
        L_0x017d:
            r10 = 1
            goto L_0x0182
        L_0x017f:
            r15 = r31
        L_0x0181:
            r10 = 0
        L_0x0182:
            if (r10 != 0) goto L_0x018e
            if (r27 == 0) goto L_0x0187
            goto L_0x018e
        L_0x0187:
            r20 = r0
            r18 = r1
            r19 = r4
            goto L_0x01e3
        L_0x018e:
            r18 = r1
            r19 = r4
            if (r10 == 0) goto L_0x0196
            r1 = 2
            goto L_0x0197
        L_0x0196:
            r1 = 1
        L_0x0197:
            r4 = r0[r2]
            r20 = r0
            r0 = 0
            boolean r4 = m9035b(r4, r0)
            if (r4 == 0) goto L_0x01a4
            int r1 = r1 + 1000
        L_0x01a4:
            if (r1 <= r5) goto L_0x01a8
            r0 = 1
            goto L_0x01a9
        L_0x01a8:
            r0 = 0
        L_0x01a9:
            if (r1 != r5) goto L_0x01cc
            int r0 = r9.zzez()
            if (r0 == r6) goto L_0x01ba
            int r0 = r9.zzez()
            int r0 = m9034a(r0, r6)
            goto L_0x01c0
        L_0x01ba:
            int r0 = r9.zzagw
            int r0 = m9034a(r0, r8)
        L_0x01c0:
            if (r4 == 0) goto L_0x01c7
            if (r10 == 0) goto L_0x01c7
            if (r0 <= 0) goto L_0x01cb
            goto L_0x01c9
        L_0x01c7:
            if (r0 >= 0) goto L_0x01cb
        L_0x01c9:
            r0 = 1
            goto L_0x01cc
        L_0x01cb:
            r0 = 0
        L_0x01cc:
            if (r0 == 0) goto L_0x01e3
            int r0 = r9.zzagw
            int r4 = r9.zzez()
            r8 = r0
            r5 = r1
            r6 = r4
            r26 = r18
            r4 = r2
            goto L_0x01e5
        L_0x01db:
            r20 = r0
            r18 = r1
            r19 = r4
            r15 = r31
        L_0x01e3:
            r4 = r19
        L_0x01e5:
            int r2 = r2 + 1
            r31 = r15
            r1 = r18
            r0 = r20
            goto L_0x014b
        L_0x01ef:
            r19 = r4
            r15 = r31
            int r3 = r3 + 1
            r18 = r5
            r20 = r8
            r7 = r22
            r2 = r23
            r0 = r26
            r10 = r27
            r5 = r28
            r8 = r29
            r9 = r30
            r19 = r6
            r6 = r24
            goto L_0x003f
        L_0x020d:
            r26 = r0
            r23 = r2
            r25 = r4
            r24 = r6
            if (r26 != 0) goto L_0x0219
            r9 = 0
            goto L_0x0222
        L_0x0219:
            com.google.android.gms.internal.ads.zzny r9 = new com.google.android.gms.internal.ads.zzny
            r1 = r25
            r0 = r26
            r9.<init>(r0, r1)
        L_0x0222:
            r23[r24] = r9
            r0 = r23[r24]
            if (r0 == 0) goto L_0x022a
            r11 = 1
            goto L_0x022b
        L_0x022a:
            r11 = 0
        L_0x022b:
            r7 = r11
            goto L_0x0235
        L_0x022d:
            r21 = r1
            r23 = r2
            r17 = r4
            r24 = r6
        L_0x0235:
            r0 = r34[r24]
            int r0 = r0.length
            goto L_0x0242
        L_0x023a:
            r21 = r1
            r23 = r2
            r17 = r4
            r24 = r6
        L_0x0242:
            int r6 = r24 + 1
            r3 = r32
            r0 = r33
            r4 = r17
            r1 = r21
            r2 = r23
            goto L_0x0011
        L_0x0250:
            r23 = r2
            r17 = r4
            r3 = r1
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x0258:
            if (r0 >= r3) goto L_0x03d1
            r4 = r33[r0]
            int r4 = r4.getTrackType()
            r5 = 1
            if (r4 == r5) goto L_0x0358
            r5 = 2
            if (r4 == r5) goto L_0x0353
            r6 = 3
            if (r4 == r6) goto L_0x02dc
            r4 = r33[r0]
            r4.getTrackType()
            r4 = r34[r0]
            r6 = r35[r0]
            r7 = r17
            boolean r8 = r7.zzbhi
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x027a:
            int r13 = r4.length
            if (r9 >= r13) goto L_0x02cd
            com.google.android.gms.internal.ads.zznr r13 = r4.zzbb(r9)
            r14 = r6[r9]
            r15 = 0
        L_0x0285:
            int r5 = r13.length
            if (r15 >= r5) goto L_0x02c5
            r5 = r14[r15]
            boolean r5 = m9035b(r5, r8)
            if (r5 == 0) goto L_0x02ba
            com.google.android.gms.internal.ads.zzhp r5 = r13.zzbc(r15)
            int r5 = r5.zzahq
            r16 = 1
            r5 = r5 & 1
            if (r5 == 0) goto L_0x029f
            r5 = 1
            goto L_0x02a0
        L_0x029f:
            r5 = 0
        L_0x02a0:
            r21 = r3
            if (r5 == 0) goto L_0x02a6
            r5 = 2
            goto L_0x02a7
        L_0x02a6:
            r5 = 1
        L_0x02a7:
            r3 = r14[r15]
            r17 = r4
            r4 = 0
            boolean r3 = m9035b(r3, r4)
            if (r3 == 0) goto L_0x02b4
            int r5 = r5 + 1000
        L_0x02b4:
            if (r5 <= r11) goto L_0x02be
            r11 = r5
            r12 = r13
            r10 = r15
            goto L_0x02be
        L_0x02ba:
            r21 = r3
            r17 = r4
        L_0x02be:
            int r15 = r15 + 1
            r4 = r17
            r3 = r21
            goto L_0x0285
        L_0x02c5:
            r21 = r3
            r17 = r4
            int r9 = r9 + 1
            r5 = 2
            goto L_0x027a
        L_0x02cd:
            r21 = r3
            if (r12 != 0) goto L_0x02d3
            r3 = 0
            goto L_0x02d8
        L_0x02d3:
            com.google.android.gms.internal.ads.zzny r3 = new com.google.android.gms.internal.ads.zzny
            r3.<init>(r12, r10)
        L_0x02d8:
            r23[r0] = r3
            goto L_0x034f
        L_0x02dc:
            r21 = r3
            r7 = r17
            if (r2 != 0) goto L_0x034f
            r2 = r34[r0]
            r3 = r35[r0]
            boolean r4 = r7.zzbhi
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x02ec:
            int r11 = r2.length
            if (r5 >= r11) goto L_0x033c
            com.google.android.gms.internal.ads.zznr r11 = r2.zzbb(r5)
            r12 = r3[r5]
            r13 = r10
            r10 = r9
            r9 = r8
            r8 = 0
        L_0x02fa:
            int r14 = r11.length
            if (r8 >= r14) goto L_0x0335
            r14 = r12[r8]
            boolean r14 = m9035b(r14, r4)
            if (r14 == 0) goto L_0x0331
            com.google.android.gms.internal.ads.zzhp r14 = r11.zzbc(r8)
            int r14 = r14.zzahq
            r15 = r14 & 1
            if (r15 == 0) goto L_0x0312
            r15 = 1
            goto L_0x0313
        L_0x0312:
            r15 = 0
        L_0x0313:
            r14 = r14 & 2
            if (r14 == 0) goto L_0x0319
            r14 = 1
            goto L_0x031a
        L_0x0319:
            r14 = 0
        L_0x031a:
            if (r15 == 0) goto L_0x031e
            r14 = 3
            goto L_0x0321
        L_0x031e:
            if (r14 == 0) goto L_0x0331
            r14 = 1
        L_0x0321:
            r15 = r12[r8]
            r6 = 0
            boolean r15 = m9035b(r15, r6)
            if (r15 == 0) goto L_0x032c
            int r14 = r14 + 1000
        L_0x032c:
            if (r14 <= r10) goto L_0x0331
            r9 = r8
            r13 = r11
            r10 = r14
        L_0x0331:
            int r8 = r8 + 1
            r6 = 3
            goto L_0x02fa
        L_0x0335:
            int r5 = r5 + 1
            r8 = r9
            r9 = r10
            r10 = r13
            r6 = 3
            goto L_0x02ec
        L_0x033c:
            if (r10 != 0) goto L_0x0340
            r2 = 0
            goto L_0x0345
        L_0x0340:
            com.google.android.gms.internal.ads.zzny r2 = new com.google.android.gms.internal.ads.zzny
            r2.<init>(r10, r8)
        L_0x0345:
            r23[r0] = r2
            r2 = r23[r0]
            if (r2 == 0) goto L_0x034d
            r4 = 1
            goto L_0x034e
        L_0x034d:
            r4 = 0
        L_0x034e:
            r2 = r4
        L_0x034f:
            r5 = -1
            r15 = 0
            goto L_0x03c9
        L_0x0353:
            r21 = r3
            r7 = r17
            goto L_0x034f
        L_0x0358:
            r21 = r3
            r7 = r17
            if (r1 != 0) goto L_0x034f
            r1 = r34[r0]
            r3 = r35[r0]
            boolean r4 = r7.zzbhi
            r5 = 0
            r6 = 0
            r8 = -1
            r9 = -1
        L_0x0368:
            int r10 = r1.length
            if (r5 >= r10) goto L_0x03b0
            com.google.android.gms.internal.ads.zznr r10 = r1.zzbb(r5)
            r11 = r3[r5]
            r12 = r9
            r9 = r8
            r8 = r6
            r6 = 0
        L_0x0376:
            int r13 = r10.length
            if (r6 >= r13) goto L_0x03a9
            r13 = r11[r6]
            boolean r13 = m9035b(r13, r4)
            if (r13 == 0) goto L_0x03a5
            com.google.android.gms.internal.ads.zzhp r13 = r10.zzbc(r6)
            r14 = r11[r6]
            int r13 = r13.zzahq
            r15 = 1
            r13 = r13 & r15
            if (r13 == 0) goto L_0x0390
            r13 = 1
            goto L_0x0391
        L_0x0390:
            r13 = 0
        L_0x0391:
            if (r13 == 0) goto L_0x0395
            r13 = 2
            goto L_0x0396
        L_0x0395:
            r13 = 1
        L_0x0396:
            r15 = 0
            boolean r14 = m9035b(r14, r15)
            if (r14 == 0) goto L_0x039f
            int r13 = r13 + 1000
        L_0x039f:
            if (r13 <= r8) goto L_0x03a6
            r9 = r5
            r12 = r6
            r8 = r13
            goto L_0x03a6
        L_0x03a5:
            r15 = 0
        L_0x03a6:
            int r6 = r6 + 1
            goto L_0x0376
        L_0x03a9:
            r15 = 0
            int r5 = r5 + 1
            r6 = r8
            r8 = r9
            r9 = r12
            goto L_0x0368
        L_0x03b0:
            r5 = -1
            r15 = 0
            if (r8 != r5) goto L_0x03b6
            r3 = 0
            goto L_0x03bf
        L_0x03b6:
            com.google.android.gms.internal.ads.zznr r1 = r1.zzbb(r8)
            com.google.android.gms.internal.ads.zzny r3 = new com.google.android.gms.internal.ads.zzny
            r3.<init>(r1, r9)
        L_0x03bf:
            r23[r0] = r3
            r1 = r23[r0]
            if (r1 == 0) goto L_0x03c7
            r4 = 1
            goto L_0x03c8
        L_0x03c7:
            r4 = 0
        L_0x03c8:
            r1 = r4
        L_0x03c9:
            int r0 = r0 + 1
            r17 = r7
            r3 = r21
            goto L_0x0258
        L_0x03d1:
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznw.zza(com.google.android.gms.internal.ads.zzhx[], com.google.android.gms.internal.ads.zznq[], int[][][]):com.google.android.gms.internal.ads.zzoc[]");
    }

    private zznw(zzof zzof) {
        this.f16779d = new AtomicReference<>(new zznz());
    }
}
