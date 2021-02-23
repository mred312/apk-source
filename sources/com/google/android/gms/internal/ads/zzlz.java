package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzlz {

    /* renamed from: a */
    private static final zzls f16709a = zzls.zzay("OMX.google.raw.decoder");

    /* renamed from: b */
    private static final Pattern f16710b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c */
    private static final HashMap<C2705a, List<zzls>> f16711c = new HashMap<>();

    /* renamed from: d */
    private static final SparseIntArray f16712d;

    /* renamed from: e */
    private static final SparseIntArray f16713e;

    /* renamed from: f */
    private static final Map<String, Integer> f16714f;

    /* renamed from: g */
    private static int f16715g = -1;

    /* renamed from: com.google.android.gms.internal.ads.zzlz$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2705a {

        /* renamed from: a */
        public final String f16716a;

        /* renamed from: b */
        public final boolean f16717b;

        public C2705a(String str, boolean z) {
            this.f16716a = str;
            this.f16717b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == C2705a.class) {
                C2705a aVar = (C2705a) obj;
                return TextUtils.equals(this.f16716a, aVar.f16716a) && this.f16717b == aVar.f16717b;
            }
        }

        public final int hashCode() {
            String str = this.f16716a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f16717b ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16712d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f16713e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        f16714f = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    /* renamed from: a */
    private static Pair<Integer, Integer> m9019a(String str, String[] strArr) {
        Integer num;
        Integer num2;
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
                num2 = valueOf2;
            } else {
                String valueOf3 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf4 = Integer.valueOf(f16712d.get(num2.intValue()));
            if (valueOf4 == null) {
                String valueOf5 = String.valueOf(num2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf5);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf6 = Integer.valueOf(f16713e.get(num.intValue()));
            if (valueOf6 != null) {
                return new Pair<>(valueOf4, valueOf6);
            }
            String valueOf7 = String.valueOf(num);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf7).length() + 19);
            sb2.append("Unknown AVC level: ");
            sb2.append(valueOf7);
            Log.w("MediaCodecUtil", sb2.toString());
            return null;
        } catch (NumberFormatException unused) {
            String valueOf8 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf8.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf8) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0126, code lost:
        if ("C1605".equals(r14) == false) goto L_0x0129;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0182 A[Catch:{ Exception -> 0x027c }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01cb A[Catch:{ Exception -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01d8 A[Catch:{ Exception -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e2 A[Catch:{ Exception -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0208 A[SYNTHETIC, Splitter:B:154:0x0208] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0232 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0271 A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.internal.ads.zzls> m9020b(com.google.android.gms.internal.ads.zzlz.C2705a r17, com.google.android.gms.internal.ads.rf0 r18) {
        /*
            r1 = r17
            r2 = r18
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x027c }
            r3.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.String r4 = r1.f16716a     // Catch:{ Exception -> 0x027c }
            int r5 = r18.mo14696c()     // Catch:{ Exception -> 0x027c }
            boolean r6 = r18.mo14695b()     // Catch:{ Exception -> 0x027c }
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x027b
            android.media.MediaCodecInfo r9 = r2.mo14694a(r8)     // Catch:{ Exception -> 0x027c }
            java.lang.String r10 = r9.getName()     // Catch:{ Exception -> 0x027c }
            boolean r0 = r9.isEncoder()     // Catch:{ Exception -> 0x027c }
            java.lang.String r11 = ".secure"
            if (r0 != 0) goto L_0x017f
            if (r6 != 0) goto L_0x0030
            boolean r0 = r10.endsWith(r11)     // Catch:{ Exception -> 0x027c }
            if (r0 == 0) goto L_0x0030
            goto L_0x017f
        L_0x0030:
            int r0 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ Exception -> 0x027c }
            r13 = 21
            if (r0 >= r13) goto L_0x0068
            java.lang.String r13 = "CIPAACDecoder"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "CIPMP3Decoder"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "CIPVorbisDecoder"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "CIPAMRNBDecoder"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "AACDecoder"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "MP3Decoder"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 == 0) goto L_0x0068
            goto L_0x017f
        L_0x0068:
            r13 = 18
            if (r0 >= r13) goto L_0x0076
            java.lang.String r14 = "OMX.SEC.MP3.Decoder"
            boolean r14 = r14.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r14 == 0) goto L_0x0076
            goto L_0x017f
        L_0x0076:
            if (r0 >= r13) goto L_0x008c
            java.lang.String r13 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 == 0) goto L_0x008c
            java.lang.String r13 = "a70"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpt.DEVICE     // Catch:{ Exception -> 0x027c }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x027c }
            if (r13 == 0) goto L_0x008c
            goto L_0x017f
        L_0x008c:
            r13 = 16
            if (r0 != r13) goto L_0x00fc
            java.lang.String r14 = "OMX.qcom.audio.decoder.mp3"
            boolean r14 = r14.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r14 == 0) goto L_0x00fc
            java.lang.String r14 = "dlxu"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzpt.DEVICE     // Catch:{ Exception -> 0x027c }
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "protou"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "ville"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "villeplus"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "villec2"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "gee"
            boolean r14 = r15.startsWith(r14)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "C6602"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "C6603"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "C6606"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "C6616"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "L36h"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 != 0) goto L_0x017f
            java.lang.String r14 = "SO-02E"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c }
            if (r14 == 0) goto L_0x00fc
            goto L_0x017f
        L_0x00fc:
            if (r0 != r13) goto L_0x0129
            java.lang.String r13 = "OMX.qcom.audio.decoder.aac"
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r13 == 0) goto L_0x0129
            java.lang.String r13 = "C1504"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpt.DEVICE     // Catch:{ Exception -> 0x027c }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "C1505"
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "C1604"
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x027c }
            if (r13 != 0) goto L_0x017f
            java.lang.String r13 = "C1605"
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x027c }
            if (r13 == 0) goto L_0x0129
            goto L_0x017f
        L_0x0129:
            java.lang.String r13 = "jflte"
            r14 = 19
            if (r0 > r14) goto L_0x016a
            java.lang.String r15 = "OMX.SEC.vp8.dec"
            boolean r15 = r15.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r15 == 0) goto L_0x016a
            java.lang.String r15 = "samsung"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzpt.MANUFACTURER     // Catch:{ Exception -> 0x027c }
            boolean r12 = r15.equals(r12)     // Catch:{ Exception -> 0x027c }
            if (r12 == 0) goto L_0x016a
            java.lang.String r12 = com.google.android.gms.internal.ads.zzpt.DEVICE     // Catch:{ Exception -> 0x027c }
            java.lang.String r15 = "d2"
            boolean r15 = r12.startsWith(r15)     // Catch:{ Exception -> 0x027c }
            if (r15 != 0) goto L_0x017f
            java.lang.String r15 = "serrano"
            boolean r15 = r12.startsWith(r15)     // Catch:{ Exception -> 0x027c }
            if (r15 != 0) goto L_0x017f
            boolean r15 = r12.startsWith(r13)     // Catch:{ Exception -> 0x027c }
            if (r15 != 0) goto L_0x017f
            java.lang.String r15 = "santos"
            boolean r15 = r12.startsWith(r15)     // Catch:{ Exception -> 0x027c }
            if (r15 != 0) goto L_0x017f
            java.lang.String r15 = "t0"
            boolean r12 = r12.startsWith(r15)     // Catch:{ Exception -> 0x027c }
            if (r12 == 0) goto L_0x016a
            goto L_0x017f
        L_0x016a:
            if (r0 > r14) goto L_0x017d
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpt.DEVICE     // Catch:{ Exception -> 0x027c }
            boolean r0 = r0.startsWith(r13)     // Catch:{ Exception -> 0x027c }
            if (r0 == 0) goto L_0x017d
            java.lang.String r0 = "OMX.qcom.video.decoder.vp8"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x027c }
            if (r0 == 0) goto L_0x017d
            goto L_0x017f
        L_0x017d:
            r0 = 1
            goto L_0x0180
        L_0x017f:
            r0 = 0
        L_0x0180:
            if (r0 == 0) goto L_0x0271
            java.lang.String[] r12 = r9.getSupportedTypes()     // Catch:{ Exception -> 0x027c }
            int r13 = r12.length     // Catch:{ Exception -> 0x027c }
            r14 = 0
        L_0x0188:
            if (r14 >= r13) goto L_0x0271
            r15 = r12[r14]     // Catch:{ Exception -> 0x027c }
            boolean r0 = r15.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x027c }
            if (r0 == 0) goto L_0x0267
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r15)     // Catch:{ Exception -> 0x01fc }
            boolean r7 = r2.mo14697d(r4, r0)     // Catch:{ Exception -> 0x01fc }
            int r2 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ Exception -> 0x01fc }
            r16 = r5
            r5 = 22
            if (r2 > r5) goto L_0x01c8
            java.lang.String r2 = com.google.android.gms.internal.ads.zzpt.MODEL     // Catch:{ Exception -> 0x01c6 }
            java.lang.String r5 = "ODROID-XU3"
            boolean r5 = r2.equals(r5)     // Catch:{ Exception -> 0x01c6 }
            if (r5 != 0) goto L_0x01b4
            java.lang.String r5 = "Nexus 10"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01c6 }
            if (r2 == 0) goto L_0x01c8
        L_0x01b4:
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01c6 }
            if (r2 != 0) goto L_0x01c4
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01c6 }
            if (r2 == 0) goto L_0x01c8
        L_0x01c4:
            r2 = 1
            goto L_0x01c9
        L_0x01c6:
            r0 = move-exception
            goto L_0x01ff
        L_0x01c8:
            r2 = 0
        L_0x01c9:
            if (r6 == 0) goto L_0x01d2
            boolean r5 = r1.f16717b     // Catch:{ Exception -> 0x01c6 }
            if (r5 == r7) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r5 = 0
            goto L_0x01d9
        L_0x01d2:
            if (r6 != 0) goto L_0x01e2
            boolean r5 = r1.f16717b     // Catch:{ Exception -> 0x01c6 }
            if (r5 != 0) goto L_0x01e2
            goto L_0x01d0
        L_0x01d9:
            com.google.android.gms.internal.ads.zzls r0 = com.google.android.gms.internal.ads.zzls.zza(r10, r4, r0, r2, r5)     // Catch:{ Exception -> 0x01c6 }
            r3.add(r0)     // Catch:{ Exception -> 0x01c6 }
            goto L_0x0269
        L_0x01e2:
            r5 = 0
            if (r6 != 0) goto L_0x01fa
            if (r7 == 0) goto L_0x01fa
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x01c6 }
            java.lang.String r7 = r7.concat(r11)     // Catch:{ Exception -> 0x01c6 }
            r5 = 1
            com.google.android.gms.internal.ads.zzls r0 = com.google.android.gms.internal.ads.zzls.zza(r7, r4, r0, r2, r5)     // Catch:{ Exception -> 0x01f8 }
            r3.add(r0)     // Catch:{ Exception -> 0x01f8 }
            return r3
        L_0x01f8:
            r0 = move-exception
            goto L_0x0200
        L_0x01fa:
            r5 = 1
            goto L_0x0269
        L_0x01fc:
            r0 = move-exception
            r16 = r5
        L_0x01ff:
            r5 = 1
        L_0x0200:
            int r2 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ Exception -> 0x027c }
            r7 = 23
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 > r7) goto L_0x0232
            boolean r2 = r3.isEmpty()     // Catch:{ Exception -> 0x027c }
            if (r2 != 0) goto L_0x0232
            java.lang.String r0 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x027c }
            int r0 = r0.length()     // Catch:{ Exception -> 0x027c }
            int r0 = r0 + 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r2.<init>(r0)     // Catch:{ Exception -> 0x027c }
            java.lang.String r0 = "Skipping codec "
            r2.append(r0)     // Catch:{ Exception -> 0x027c }
            r2.append(r10)     // Catch:{ Exception -> 0x027c }
            java.lang.String r0 = " (failed to query capabilities)"
            r2.append(r0)     // Catch:{ Exception -> 0x027c }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x027c }
            android.util.Log.e(r5, r0)     // Catch:{ Exception -> 0x027c }
            goto L_0x0269
        L_0x0232:
            java.lang.String r1 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x027c }
            int r1 = r1.length()     // Catch:{ Exception -> 0x027c }
            int r1 = r1 + 25
            java.lang.String r2 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x027c }
            int r2 = r2.length()     // Catch:{ Exception -> 0x027c }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r2.<init>(r1)     // Catch:{ Exception -> 0x027c }
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)     // Catch:{ Exception -> 0x027c }
            r2.append(r10)     // Catch:{ Exception -> 0x027c }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x027c }
            r2.append(r15)     // Catch:{ Exception -> 0x027c }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x027c }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x027c }
            android.util.Log.e(r5, r1)     // Catch:{ Exception -> 0x027c }
            throw r0     // Catch:{ Exception -> 0x027c }
        L_0x0267:
            r16 = r5
        L_0x0269:
            int r14 = r14 + 1
            r2 = r18
            r5 = r16
            goto L_0x0188
        L_0x0271:
            r16 = r5
            int r8 = r8 + 1
            r2 = r18
            r5 = r16
            goto L_0x0014
        L_0x027b:
            return r3
        L_0x027c:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzma r1 = new com.google.android.gms.internal.ads.zzma
            r2 = 0
            r1.<init>(r0)
            goto L_0x0285
        L_0x0284:
            throw r1
        L_0x0285:
            goto L_0x0284
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlz.m9020b(com.google.android.gms.internal.ads.zzlz$a, com.google.android.gms.internal.ads.rf0):java.util.List");
    }

    /* renamed from: c */
    private static synchronized List<zzls> m9021c(String str, boolean z) {
        synchronized (zzlz.class) {
            C2705a aVar = new C2705a(str, z);
            HashMap<C2705a, List<zzls>> hashMap = f16711c;
            List<zzls> list = hashMap.get(aVar);
            if (list != null) {
                return list;
            }
            int i = zzpt.SDK_INT;
            List<zzls> b = m9020b(aVar, i >= 21 ? new sf0(z) : new qf0());
            if (z && b.isEmpty() && 21 <= i && i <= 23) {
                b = m9020b(aVar, new qf0());
                if (!b.isEmpty()) {
                    String str2 = b.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzls> unmodifiableList = Collections.unmodifiableList(b);
            hashMap.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r3.equals("avc1") == false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbb(java.lang.String r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r9.split(r1)
            r2 = 0
            r3 = r1[r2]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r5) {
                case 3006243: goto L_0x003e;
                case 3006244: goto L_0x0033;
                case 3199032: goto L_0x0028;
                case 3214780: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            r2 = -1
            goto L_0x0047
        L_0x001d:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            r2 = 3
            goto L_0x0047
        L_0x0028:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            r2 = 2
            goto L_0x0047
        L_0x0033:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x003c
            goto L_0x001b
        L_0x003c:
            r2 = 1
            goto L_0x0047
        L_0x003e:
            java.lang.String r5 = "avc1"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0047
            goto L_0x001b
        L_0x0047:
            switch(r2) {
                case 0: goto L_0x00f6;
                case 1: goto L_0x00f6;
                case 2: goto L_0x004b;
                case 3: goto L_0x004b;
                default: goto L_0x004a;
            }
        L_0x004a:
            return r0
        L_0x004b:
            int r2 = r1.length
            r3 = 4
            java.lang.String r4 = "Ignoring malformed HEVC codec string: "
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 >= r3) goto L_0x006b
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x0062
            java.lang.String r9 = r4.concat(r9)
            goto L_0x0067
        L_0x0062:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x0067:
            android.util.Log.w(r5, r9)
            return r0
        L_0x006b:
            java.util.regex.Pattern r2 = f16710b
            r3 = r1[r8]
            java.util.regex.Matcher r2 = r2.matcher(r3)
            boolean r3 = r2.matches()
            if (r3 != 0) goto L_0x0091
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x0088
            java.lang.String r9 = r4.concat(r9)
            goto L_0x008d
        L_0x0088:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x008d:
            android.util.Log.w(r5, r9)
            return r0
        L_0x0091:
            java.lang.String r9 = r2.group(r8)
            java.lang.String r3 = "1"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x009f
            r7 = 1
            goto L_0x00a7
        L_0x009f:
            java.lang.String r3 = "2"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x00dc
        L_0x00a7:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = f16714f
            r1 = r1[r6]
            java.lang.Object r9 = r9.get(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x00d2
            java.lang.String r9 = "Unknown HEVC level string: "
            java.lang.String r1 = r2.group(r8)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x00c8
            java.lang.String r9 = r9.concat(r1)
            goto L_0x00ce
        L_0x00c8:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r9)
            r9 = r1
        L_0x00ce:
            android.util.Log.w(r5, r9)
            return r0
        L_0x00d2:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0.<init>(r1, r9)
            return r0
        L_0x00dc:
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r2 = r9.length()
            if (r2 == 0) goto L_0x00ed
            java.lang.String r9 = r1.concat(r9)
            goto L_0x00f2
        L_0x00ed:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r1)
        L_0x00f2:
            android.util.Log.w(r5, r9)
            return r0
        L_0x00f6:
            android.util.Pair r9 = m9019a(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlz.zzbb(java.lang.String):android.util.Pair");
    }

    public static zzls zzc(String str, boolean z) {
        List<zzls> c = m9021c(str, z);
        if (c.isEmpty()) {
            return null;
        }
        return c.get(0);
    }

    public static zzls zzhj() {
        return f16709a;
    }

    public static int zzhk() {
        if (f16715g == -1) {
            int i = 0;
            zzls zzc = zzc("video/avc", false);
            if (zzc != null) {
                MediaCodecInfo.CodecProfileLevel[] zzhc = zzc.zzhc();
                int length = zzhc.length;
                int i2 = 0;
                while (i < length) {
                    int i3 = zzhc[i].level;
                    int i4 = 9437184;
                    if (i3 != 1 && i3 != 2) {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i4 = 101376;
                                break;
                            case 64:
                                i4 = 202752;
                                break;
                            case 128:
                            case 256:
                                i4 = 414720;
                                break;
                            case 512:
                                i4 = 921600;
                                break;
                            case 1024:
                                i4 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i4 = 2097152;
                                break;
                            case 8192:
                                i4 = 2228224;
                                break;
                            case 16384:
                                i4 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i4 = -1;
                                break;
                        }
                    } else {
                        i4 = 25344;
                    }
                    i2 = Math.max(i4, i2);
                    i++;
                }
                i = Math.max(i2, zzpt.SDK_INT >= 21 ? 345600 : 172800);
            }
            f16715g = i;
        }
        return f16715g;
    }
}
