package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzau implements zzx {
    private static final boolean DEBUG = zzaq.DEBUG;
    @Deprecated
    private final zzbe zzcc;
    private final zzar zzcd;
    private final zzat zzce;

    public zzau(zzar zzar) {
        this(zzar, new zzat(4096));
    }

    private static void zza(String str, zzaa<?> zzaa, zzao zzao) {
        zzan zzj = zzaa.zzj();
        int zzi = zzaa.zzi();
        try {
            zzj.zza(zzao);
            zzaa.zzc(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
        } catch (zzao e) {
            zzaa.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
            throw e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0203, code lost:
        throw new com.google.android.gms.internal.ads.zzab(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0204, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0205, code lost:
        r2 = java.lang.String.valueOf(r22.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0215, code lost:
        if (r2.length() != 0) goto L_0x0217;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0217, code lost:
        r2 = "Bad URL ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x021c, code lost:
        r2 = new java.lang.String("Bad URL ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0224, code lost:
        throw new java.lang.RuntimeException(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0225, code lost:
        zza("socket", r2, new com.google.android.gms.internal.ads.zzap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0181, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0182, code lost:
        r17 = r5;
        r13 = r8;
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018d, code lost:
        r17 = r5;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0193, code lost:
        r0 = r8.getStatusCode();
        com.google.android.gms.internal.ads.zzaq.m7525e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r22.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01aa, code lost:
        if (r13 != null) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ac, code lost:
        r11 = new com.google.android.gms.internal.ads.zzy(r0, r13, false, android.os.SystemClock.elapsedRealtime() - r3, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01bc, code lost:
        if (r0 == 401) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c5, code lost:
        if (r0 < 400) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d1, code lost:
        throw new com.google.android.gms.internal.ads.zzr(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d4, code lost:
        if (r0 < 500) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01df, code lost:
        throw new com.google.android.gms.internal.ads.zzam(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e5, code lost:
        throw new com.google.android.gms.internal.ads.zzam(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e6, code lost:
        zza("auth", r2, new com.google.android.gms.internal.ads.zzl(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f2, code lost:
        zza("network", r2, new com.google.android.gms.internal.ads.zzz());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0204 A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzy zzc(com.google.android.gms.internal.ads.zzaa<?> r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.List r5 = java.util.Collections.emptyList()
            r6 = 1
            r7 = 2
            r9 = 0
            com.google.android.gms.internal.ads.zzn r0 = r22.zzf()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            if (r0 != 0) goto L_0x001a
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            goto L_0x003a
        L_0x001a:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            r10.<init>()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            java.lang.String r11 = r0.zzr     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            if (r11 == 0) goto L_0x0028
            java.lang.String r12 = "If-None-Match"
            r10.put(r12, r11)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
        L_0x0028:
            long r11 = r0.zzt     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            r13 = 0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzbc.m7693a(r11)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            r10.put(r0, r11)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
        L_0x0039:
            r0 = r10
        L_0x003a:
            com.google.android.gms.internal.ads.zzar r10 = r1.zzcd     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            com.google.android.gms.internal.ads.zzbb r10 = r10.zza(r2, r0)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x018c }
            int r12 = r10.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.util.List r5 = r10.zzq()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r0 = 304(0x130, float:4.26E-43)
            if (r12 != r0) goto L_0x0110
            com.google.android.gms.internal.ads.zzn r0 = r22.zzf()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r0 != 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzy r0 = new com.google.android.gms.internal.ads.zzy     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r14 = 304(0x130, float:4.26E-43)
            r15 = 0
            r16 = 1
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            long r17 = r11 - r3
            r13 = r0
            r19 = r5
            r13.<init>((int) r14, (byte[]) r15, (boolean) r16, (long) r17, (java.util.List<com.google.android.gms.internal.ads.zzu>) r19)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            return r0
        L_0x0066:
            java.util.TreeSet r11 = new java.util.TreeSet     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.util.Comparator r12 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r11.<init>(r12)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            boolean r12 = r5.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r12 != 0) goto L_0x008b
            java.util.Iterator r12 = r5.iterator()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
        L_0x0077:
            boolean r13 = r12.hasNext()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r13 == 0) goto L_0x008b
            java.lang.Object r13 = r12.next()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            com.google.android.gms.internal.ads.zzu r13 = (com.google.android.gms.internal.ads.zzu) r13     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.lang.String r13 = r13.getName()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r11.add(r13)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            goto L_0x0077
        L_0x008b:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r12.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.util.List<com.google.android.gms.internal.ads.zzu> r13 = r0.zzx     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r13 == 0) goto L_0x00ba
            boolean r13 = r13.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r13 != 0) goto L_0x00f9
            java.util.List<com.google.android.gms.internal.ads.zzu> r13 = r0.zzx     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
        L_0x00a0:
            boolean r14 = r13.hasNext()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r14 == 0) goto L_0x00f9
            java.lang.Object r14 = r13.next()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            com.google.android.gms.internal.ads.zzu r14 = (com.google.android.gms.internal.ads.zzu) r14     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.lang.String r15 = r14.getName()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            boolean r15 = r11.contains(r15)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r15 != 0) goto L_0x00a0
            r12.add(r14)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            goto L_0x00a0
        L_0x00ba:
            java.util.Map<java.lang.String, java.lang.String> r13 = r0.zzw     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            boolean r13 = r13.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r13 != 0) goto L_0x00f9
            java.util.Map<java.lang.String, java.lang.String> r13 = r0.zzw     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.util.Set r13 = r13.entrySet()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
        L_0x00cc:
            boolean r14 = r13.hasNext()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r14 == 0) goto L_0x00f9
            java.lang.Object r14 = r13.next()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.lang.Object r15 = r14.getKey()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            boolean r15 = r11.contains(r15)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r15 != 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzu r15 = new com.google.android.gms.internal.ads.zzu     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.lang.Object r16 = r14.getKey()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r8 = r16
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.lang.Object r14 = r14.getValue()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r15.<init>(r8, r14)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r12.add(r15)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            goto L_0x00cc
        L_0x00f9:
            com.google.android.gms.internal.ads.zzy r8 = new com.google.android.gms.internal.ads.zzy     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r15 = 304(0x130, float:4.26E-43)
            byte[] r0 = r0.data     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            r17 = 1
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            long r18 = r13 - r3
            r14 = r8
            r16 = r0
            r20 = r12
            r14.<init>((int) r15, (byte[]) r16, (boolean) r17, (long) r18, (java.util.List<com.google.android.gms.internal.ads.zzu>) r20)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            return r8
        L_0x0110:
            java.io.InputStream r0 = r10.getContent()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            if (r0 == 0) goto L_0x011f
            int r8 = r10.getContentLength()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            byte[] r0 = r1.zza(r0, r8)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
            goto L_0x0121
        L_0x011f:
            byte[] r0 = new byte[r9]     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0187 }
        L_0x0121:
            r8 = r0
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            long r13 = r13 - r3
            boolean r0 = DEBUG     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            if (r0 != 0) goto L_0x0131
            r15 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x0163
        L_0x0131:
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r11 = 5
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r11[r9] = r2     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r11[r6] = r13     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            if (r8 == 0) goto L_0x0146
            int r13 = r8.length     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            goto L_0x0148
        L_0x0146:
            java.lang.String r13 = "null"
        L_0x0148:
            r11[r7] = r13     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r13 = 3
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r11[r13] = r14     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r13 = 4
            com.google.android.gms.internal.ads.zzan r14 = r22.zzj()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            int r14 = r14.zzc()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r11[r13] = r14     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            com.google.android.gms.internal.ads.zzaq.m7524d(r0, r11)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
        L_0x0163:
            r0 = 200(0xc8, float:2.8E-43)
            if (r12 < r0) goto L_0x017b
            r0 = 299(0x12b, float:4.19E-43)
            if (r12 > r0) goto L_0x017b
            com.google.android.gms.internal.ads.zzy r0 = new com.google.android.gms.internal.ads.zzy     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r14 = 0
            long r15 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            long r15 = r15 - r3
            r11 = r0
            r13 = r8
            r17 = r5
            r11.<init>((int) r12, (byte[]) r13, (boolean) r14, (long) r15, (java.util.List<com.google.android.gms.internal.ads.zzu>) r17)     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            return r0
        L_0x017b:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
            throw r0     // Catch:{ SocketTimeoutException -> 0x0225, MalformedURLException -> 0x0204, IOException -> 0x0181 }
        L_0x0181:
            r0 = move-exception
            r17 = r5
            r13 = r8
            r8 = r10
            goto L_0x0191
        L_0x0187:
            r0 = move-exception
            r17 = r5
            r8 = r10
            goto L_0x0190
        L_0x018c:
            r0 = move-exception
            r17 = r5
            r8 = 0
        L_0x0190:
            r13 = 0
        L_0x0191:
            if (r8 == 0) goto L_0x01fe
            int r0 = r8.getStatusCode()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r5[r9] = r7
            java.lang.String r7 = r22.getUrl()
            r5[r6] = r7
            java.lang.String r6 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzaq.m7525e(r6, r5)
            if (r13 == 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzy r5 = new com.google.android.gms.internal.ads.zzy
            r14 = 0
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r15 = r6 - r3
            r11 = r5
            r12 = r0
            r11.<init>((int) r12, (byte[]) r13, (boolean) r14, (long) r15, (java.util.List<com.google.android.gms.internal.ads.zzu>) r17)
            r6 = 401(0x191, float:5.62E-43)
            if (r0 == r6) goto L_0x01e6
            r6 = 403(0x193, float:5.65E-43)
            if (r0 != r6) goto L_0x01c3
            goto L_0x01e6
        L_0x01c3:
            r2 = 400(0x190, float:5.6E-43)
            if (r0 < r2) goto L_0x01d2
            r2 = 499(0x1f3, float:6.99E-43)
            if (r0 <= r2) goto L_0x01cc
            goto L_0x01d2
        L_0x01cc:
            com.google.android.gms.internal.ads.zzr r0 = new com.google.android.gms.internal.ads.zzr
            r0.<init>(r5)
            throw r0
        L_0x01d2:
            r2 = 500(0x1f4, float:7.0E-43)
            if (r0 < r2) goto L_0x01e0
            r2 = 599(0x257, float:8.4E-43)
            if (r0 > r2) goto L_0x01e0
            com.google.android.gms.internal.ads.zzam r0 = new com.google.android.gms.internal.ads.zzam
            r0.<init>(r5)
            throw r0
        L_0x01e0:
            com.google.android.gms.internal.ads.zzam r0 = new com.google.android.gms.internal.ads.zzam
            r0.<init>(r5)
            throw r0
        L_0x01e6:
            com.google.android.gms.internal.ads.zzl r0 = new com.google.android.gms.internal.ads.zzl
            r0.<init>(r5)
            java.lang.String r5 = "auth"
            zza(r5, r2, r0)
            goto L_0x0008
        L_0x01f2:
            com.google.android.gms.internal.ads.zzz r0 = new com.google.android.gms.internal.ads.zzz
            r0.<init>()
            java.lang.String r5 = "network"
            zza(r5, r2, r0)
            goto L_0x0008
        L_0x01fe:
            com.google.android.gms.internal.ads.zzab r2 = new com.google.android.gms.internal.ads.zzab
            r2.<init>(r0)
            throw r2
        L_0x0204:
            r0 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r4 = "Bad URL "
            java.lang.String r2 = r22.getUrl()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r5 = r2.length()
            if (r5 == 0) goto L_0x021c
            java.lang.String r2 = r4.concat(r2)
            goto L_0x0221
        L_0x021c:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r4)
        L_0x0221:
            r3.<init>(r2, r0)
            throw r3
        L_0x0225:
            com.google.android.gms.internal.ads.zzap r0 = new com.google.android.gms.internal.ads.zzap
            r0.<init>()
            java.lang.String r5 = "socket"
            zza(r5, r2, r0)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzau.zzc(com.google.android.gms.internal.ads.zzaa):com.google.android.gms.internal.ads.zzy");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzbe, com.google.android.gms.internal.ads.zzar] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzau(com.google.android.gms.internal.ads.zzar r1, com.google.android.gms.internal.ads.zzat r2) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzcd = r1
            r0.zzcc = r1
            r0.zzce = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzau.<init>(com.google.android.gms.internal.ads.zzar, com.google.android.gms.internal.ads.zzat):void");
    }

    private final byte[] zza(InputStream inputStream, int i) {
        zzbi zzbi = new zzbi(this.zzce, i);
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                bArr = this.zzce.zzf(1024);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zzbi.write(bArr, 0, read);
                }
                return zzbi.toByteArray();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        zzaq.m7526v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.zzce.zza(bArr);
                zzbi.close();
            }
        } else {
            throw new zzam();
        }
    }
}
