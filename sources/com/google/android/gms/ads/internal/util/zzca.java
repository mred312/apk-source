package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.util.Range;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzca {
    private static Map<String, List<Map<String, Object>>> zzefu = new HashMap();
    private static List<MediaCodecInfo> zzefv;
    private static final Object zzefw = new Object();

    @TargetApi(21)
    private static Integer[] zza(Range<Integer> range) {
        return new Integer[]{range.getLower(), range.getUpper()};
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    @android.annotation.TargetApi(16)
    public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> zzes(java.lang.String r15) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Object r1 = zzefw
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r2 = zzefu     // Catch:{ all -> 0x014f }
            boolean r2 = r2.containsKey(r15)     // Catch:{ all -> 0x014f }
            if (r2 == 0) goto L_0x0017
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r0 = zzefu     // Catch:{ all -> 0x014f }
            java.lang.Object r15 = r0.get(r15)     // Catch:{ all -> 0x014f }
            java.util.List r15 = (java.util.List) r15     // Catch:{ all -> 0x014f }
            monitor-exit(r1)     // Catch:{ all -> 0x014f }
            return r15
        L_0x0017:
            monitor-enter(r1)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.util.List<android.media.MediaCodecInfo> r2 = zzefv     // Catch:{ all -> 0x0128 }
            r3 = 21
            r4 = 0
            if (r2 == 0) goto L_0x0021
            monitor-exit(r1)     // Catch:{ all -> 0x0128 }
            goto L_0x004e
        L_0x0021:
            if (r0 < r3) goto L_0x0033
            android.media.MediaCodecList r2 = new android.media.MediaCodecList     // Catch:{ all -> 0x0128 }
            r2.<init>(r4)     // Catch:{ all -> 0x0128 }
            android.media.MediaCodecInfo[] r2 = r2.getCodecInfos()     // Catch:{ all -> 0x0128 }
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ all -> 0x0128 }
            zzefv = r2     // Catch:{ all -> 0x0128 }
            goto L_0x004d
        L_0x0033:
            int r2 = android.media.MediaCodecList.getCodecCount()     // Catch:{ all -> 0x0128 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0128 }
            r5.<init>(r2)     // Catch:{ all -> 0x0128 }
            zzefv = r5     // Catch:{ all -> 0x0128 }
            r5 = 0
        L_0x003f:
            if (r5 >= r2) goto L_0x004d
            android.media.MediaCodecInfo r6 = android.media.MediaCodecList.getCodecInfoAt(r5)     // Catch:{ all -> 0x0128 }
            java.util.List<android.media.MediaCodecInfo> r7 = zzefv     // Catch:{ all -> 0x0128 }
            r7.add(r6)     // Catch:{ all -> 0x0128 }
            int r5 = r5 + 1
            goto L_0x003f
        L_0x004d:
            monitor-exit(r1)     // Catch:{ all -> 0x0128 }
        L_0x004e:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r2.<init>()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.util.List<android.media.MediaCodecInfo> r5 = zzefv     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
        L_0x0059:
            boolean r6 = r5.hasNext()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            if (r6 == 0) goto L_0x0121
            java.lang.Object r6 = r5.next()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            android.media.MediaCodecInfo r6 = (android.media.MediaCodecInfo) r6     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            boolean r7 = r6.isEncoder()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            if (r7 != 0) goto L_0x0059
            java.lang.String[] r7 = r6.getSupportedTypes()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            boolean r7 = r7.contains(r15)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            if (r7 == 0) goto L_0x0059
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.<init>()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.String r8 = "codecName"
            java.lang.String r9 = r6.getName()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            android.media.MediaCodecInfo$CodecCapabilities r6 = r6.getCapabilitiesForType(r15)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r8.<init>()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            android.media.MediaCodecInfo$CodecProfileLevel[] r9 = r6.profileLevels     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            int r10 = r9.length     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r11 = 0
        L_0x0094:
            if (r11 >= r10) goto L_0x00b2
            r12 = r9[r11]     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r13 = 2
            java.lang.Integer[] r13 = new java.lang.Integer[r13]     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            int r14 = r12.profile     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r13[r4] = r14     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            int r12 = r12.level     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r14 = 1
            r13[r14] = r12     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r8.add(r13)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            int r11 = r11 + 1
            goto L_0x0094
        L_0x00b2:
            java.lang.String r9 = "profileLevels"
            r7.put(r9, r8)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            if (r0 < r3) goto L_0x010b
            android.media.MediaCodecInfo$VideoCapabilities r8 = r6.getVideoCapabilities()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.String r9 = "bitRatesBps"
            android.util.Range r10 = r8.getBitrateRange()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer[] r10 = zza(r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r9, r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.String r9 = "widthAlignment"
            int r10 = r8.getWidthAlignment()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r9, r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.String r9 = "heightAlignment"
            int r10 = r8.getHeightAlignment()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r9, r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.String r9 = "frameRates"
            android.util.Range r10 = r8.getSupportedFrameRates()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer[] r10 = zza(r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r9, r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.String r9 = "widths"
            android.util.Range r10 = r8.getSupportedWidths()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer[] r10 = zza(r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r9, r10)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.String r9 = "heights"
            android.util.Range r8 = r8.getSupportedHeights()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer[] r8 = zza(r8)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r9, r8)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
        L_0x010b:
            r8 = 23
            if (r0 < r8) goto L_0x011c
            java.lang.String r8 = "instancesLimit"
            int r6 = r6.getMaxSupportedInstances()     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r7.put(r8, r6)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
        L_0x011c:
            r2.add(r7)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            goto L_0x0059
        L_0x0121:
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r0 = zzefu     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            r0.put(r15, r2)     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
            monitor-exit(r1)     // Catch:{ all -> 0x014f }
            return r2
        L_0x0128:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0128 }
            throw r0     // Catch:{ RuntimeException -> 0x012d, LinkageError -> 0x012b }
        L_0x012b:
            r0 = move-exception
            goto L_0x012e
        L_0x012d:
            r0 = move-exception
        L_0x012e:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x014f }
            r2.<init>()     // Catch:{ all -> 0x014f }
            java.lang.String r3 = "error"
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x014f }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x014f }
            r2.put(r3, r0)     // Catch:{ all -> 0x014f }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x014f }
            r0.<init>()     // Catch:{ all -> 0x014f }
            r0.add(r2)     // Catch:{ all -> 0x014f }
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r2 = zzefu     // Catch:{ all -> 0x014f }
            r2.put(r15, r0)     // Catch:{ all -> 0x014f }
            monitor-exit(r1)     // Catch:{ all -> 0x014f }
            return r0
        L_0x014f:
            r15 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x014f }
            goto L_0x0153
        L_0x0152:
            throw r15
        L_0x0153:
            goto L_0x0152
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzca.zzes(java.lang.String):java.util.List");
    }
}
