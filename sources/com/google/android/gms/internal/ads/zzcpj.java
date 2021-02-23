package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpj implements zzdqv<zzcpm, zzcpl> {

    /* renamed from: a */
    private final Context f14662a;

    /* renamed from: b */
    private final String f14663b;

    /* renamed from: c */
    private final zzaty f14664c;

    /* renamed from: d */
    private final String f14665d;

    /* renamed from: e */
    private final int f14666e;

    public zzcpj(Context context, String str, zzaty zzaty, String str2, int i) {
        this.f14662a = context;
        this.f14663b = str;
        this.f14664c = zzaty;
        this.f14665d = str2;
        this.f14666e = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r2 = new java.io.InputStreamReader(r14.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        com.google.android.gms.ads.internal.zzp.zzkq();
        r0 = com.google.android.gms.ads.internal.util.zzm.zza(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r11.zzev(r0);
        r6.f14675c = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b2, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c4, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcvg)).booleanValue() == false) goto L_0x01c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ce, code lost:
        throw new com.google.android.gms.internal.ads.zzcme(com.google.android.gms.internal.ads.zzdok.NO_FILL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01cf, code lost:
        r6.f14676d = com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime() - r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r14.disconnect();
        r1.f14664c.zzwb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e3, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01e5, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x028a A[Catch:{ all -> 0x02a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x029f A[SYNTHETIC, Splitter:B:126:0x029f] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzcpl m8226a(java.lang.String r21, com.google.android.gms.internal.ads.zzatr r22, org.json.JSONObject r23, java.lang.String r24) {
        /*
            r20 = this;
            r1 = r20
            r0 = r23
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.String r3 = "doritos_v2"
            java.lang.String r4 = "doritos"
            java.lang.String r5 = "http_timeout_millis"
            r6 = 60000(0xea60, float:8.4078E-41)
            int r5 = r0.optInt(r5, r6)     // Catch:{ IOException -> 0x02aa }
            int r6 = r22.getErrorCode()     // Catch:{ IOException -> 0x02aa }
            r7 = -2
            r14 = 1
            if (r6 == r7) goto L_0x0046
            int r0 = r22.getErrorCode()     // Catch:{ IOException -> 0x02aa }
            if (r0 != r14) goto L_0x003e
            java.util.List r0 = r22.zzvt()     // Catch:{ IOException -> 0x02aa }
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = ", "
            java.util.List r2 = r22.zzvt()     // Catch:{ IOException -> 0x02aa }
            java.lang.String r0 = android.text.TextUtils.join(r0, r2)     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.internal.ads.zzaza.zzey(r0)     // Catch:{ IOException -> 0x02aa }
        L_0x0034:
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INVALID_REQUEST     // Catch:{ IOException -> 0x02aa }
            java.lang.String r3 = "Error building request URL."
            r0.<init>(r2, r3)     // Catch:{ IOException -> 0x02aa }
            throw r0     // Catch:{ IOException -> 0x02aa }
        L_0x003e:
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ IOException -> 0x02aa }
            r0.<init>(r2)     // Catch:{ IOException -> 0x02aa }
            throw r0     // Catch:{ IOException -> 0x02aa }
        L_0x0046:
            com.google.android.gms.internal.ads.zzcpl r6 = new com.google.android.gms.internal.ads.zzcpl     // Catch:{ IOException -> 0x02aa }
            r6.<init>()     // Catch:{ IOException -> 0x02aa }
            java.lang.String r7 = "SDK version: "
            java.lang.String r8 = r1.f14663b     // Catch:{ IOException -> 0x02aa }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x02aa }
            int r9 = r8.length()     // Catch:{ IOException -> 0x02aa }
            if (r9 == 0) goto L_0x005e
            java.lang.String r7 = r7.concat(r8)     // Catch:{ IOException -> 0x02aa }
            goto L_0x0064
        L_0x005e:
            java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x02aa }
            r8.<init>(r7)     // Catch:{ IOException -> 0x02aa }
            r7 = r8
        L_0x0064:
            com.google.android.gms.internal.ads.zzaza.zzez(r7)     // Catch:{ IOException -> 0x02aa }
            java.lang.String r7 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r8 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x02aa }
            int r9 = r8.length()     // Catch:{ IOException -> 0x02aa }
            if (r9 == 0) goto L_0x0078
            java.lang.String r7 = r7.concat(r8)     // Catch:{ IOException -> 0x02aa }
            goto L_0x007e
        L_0x0078:
            java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x02aa }
            r8.<init>(r7)     // Catch:{ IOException -> 0x02aa }
            r7 = r8
        L_0x007e:
            com.google.android.gms.internal.ads.zzaza.zzeb(r7)     // Catch:{ IOException -> 0x02aa }
            java.net.URL r7 = new java.net.URL     // Catch:{ IOException -> 0x02aa }
            r8 = r21
            r7.<init>(r8)     // Catch:{ IOException -> 0x02aa }
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ IOException -> 0x02aa }
            r15.<init>()     // Catch:{ IOException -> 0x02aa }
            r8 = 0
            com.google.android.gms.common.util.Clock r9 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ IOException -> 0x02aa }
            long r16 = r9.elapsedRealtime()     // Catch:{ IOException -> 0x02aa }
            r18 = 0
        L_0x0098:
            com.google.android.gms.internal.ads.zzaty r8 = r1.f14664c     // Catch:{ IOException -> 0x02aa }
            int r9 = r1.f14666e     // Catch:{ IOException -> 0x02aa }
            r8.zzdd(r9)     // Catch:{ IOException -> 0x02aa }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x02aa }
            r13 = r7
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.ads.internal.util.zzm r7 = com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ zzcme -> 0x0276, all -> 0x0273 }
            android.content.Context r8 = r1.f14662a     // Catch:{ zzcme -> 0x0276, all -> 0x0273 }
            java.lang.String r9 = r1.f14663b     // Catch:{ zzcme -> 0x0276, all -> 0x0273 }
            r10 = 0
            r12 = 0
            r11 = r13
            r14 = r13
            r13 = r5
            r7.zza(r8, r9, r10, r11, r12, r13)     // Catch:{ zzcme -> 0x0271 }
            boolean r7 = android.text.TextUtils.isEmpty(r24)     // Catch:{ zzcme -> 0x0271 }
            if (r7 != 0) goto L_0x00c4
            java.lang.String r7 = "Cookie"
            r8 = r24
            r14.addRequestProperty(r7, r8)     // Catch:{ zzcme -> 0x0271 }
            goto L_0x00c6
        L_0x00c4:
            r8 = r24
        L_0x00c6:
            boolean r7 = r22.zzvw()     // Catch:{ zzcme -> 0x0271 }
            java.lang.String r9 = ""
            if (r7 == 0) goto L_0x0102
            java.lang.String r7 = "pii"
            org.json.JSONObject r7 = r0.optJSONObject(r7)     // Catch:{ zzcme -> 0x0271 }
            if (r7 == 0) goto L_0x00fd
            java.lang.String r10 = r7.optString(r4, r9)     // Catch:{ zzcme -> 0x0271 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ zzcme -> 0x0271 }
            if (r10 != 0) goto L_0x00e9
            java.lang.String r10 = "x-afma-drt-cookie"
            java.lang.String r11 = r7.optString(r4, r9)     // Catch:{ zzcme -> 0x0271 }
            r14.addRequestProperty(r10, r11)     // Catch:{ zzcme -> 0x0271 }
        L_0x00e9:
            java.lang.String r10 = r7.optString(r3, r9)     // Catch:{ zzcme -> 0x0271 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ zzcme -> 0x0271 }
            if (r10 != 0) goto L_0x0102
            java.lang.String r10 = "x-afma-drt-v2-cookie"
            java.lang.String r7 = r7.optString(r3, r9)     // Catch:{ zzcme -> 0x0271 }
            r14.addRequestProperty(r10, r7)     // Catch:{ zzcme -> 0x0271 }
            goto L_0x0102
        L_0x00fd:
            java.lang.String r7 = "DSID signal does not exist."
            com.google.android.gms.ads.internal.util.zzd.zzee(r7)     // Catch:{ zzcme -> 0x0271 }
        L_0x0102:
            if (r22 == 0) goto L_0x0137
            java.lang.String r10 = r22.zzvv()     // Catch:{ zzcme -> 0x0271 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ zzcme -> 0x0271 }
            if (r10 != 0) goto L_0x0137
            r10 = 1
            r14.setDoOutput(r10)     // Catch:{ zzcme -> 0x0271 }
            java.lang.String r10 = r22.zzvv()     // Catch:{ zzcme -> 0x0271 }
            byte[] r10 = r10.getBytes()     // Catch:{ zzcme -> 0x0271 }
            int r11 = r10.length     // Catch:{ zzcme -> 0x0271 }
            r14.setFixedLengthStreamingMode(r11)     // Catch:{ zzcme -> 0x0271 }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0131 }
            java.io.OutputStream r12 = r14.getOutputStream()     // Catch:{ all -> 0x0131 }
            r11.<init>(r12)     // Catch:{ all -> 0x0131 }
            r11.write(r10)     // Catch:{ all -> 0x012e }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r11)     // Catch:{ zzcme -> 0x0271 }
            goto L_0x0138
        L_0x012e:
            r0 = move-exception
            r7 = r11
            goto L_0x0133
        L_0x0131:
            r0 = move-exception
            r7 = 0
        L_0x0133:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ zzcme -> 0x0271 }
            throw r0     // Catch:{ zzcme -> 0x0271 }
        L_0x0137:
            r10 = 0
        L_0x0138:
            com.google.android.gms.internal.ads.zzayu r11 = new com.google.android.gms.internal.ads.zzayu     // Catch:{ zzcme -> 0x0271 }
            r11.<init>()     // Catch:{ zzcme -> 0x0271 }
            r11.zza((java.net.HttpURLConnection) r14, (byte[]) r10)     // Catch:{ zzcme -> 0x0271 }
            int r10 = r14.getResponseCode()     // Catch:{ zzcme -> 0x0271 }
            java.util.Map r12 = r14.getHeaderFields()     // Catch:{ zzcme -> 0x0271 }
            java.util.Set r12 = r12.entrySet()     // Catch:{ zzcme -> 0x0271 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ zzcme -> 0x0271 }
        L_0x0150:
            boolean r13 = r12.hasNext()     // Catch:{ zzcme -> 0x0271 }
            if (r13 == 0) goto L_0x0185
            java.lang.Object r13 = r12.next()     // Catch:{ zzcme -> 0x0271 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ zzcme -> 0x0271 }
            java.lang.Object r19 = r13.getKey()     // Catch:{ zzcme -> 0x0271 }
            r7 = r19
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ zzcme -> 0x0271 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ zzcme -> 0x0271 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ zzcme -> 0x0271 }
            boolean r19 = r15.containsKey(r7)     // Catch:{ zzcme -> 0x0271 }
            if (r19 == 0) goto L_0x017a
            java.lang.Object r7 = r15.get(r7)     // Catch:{ zzcme -> 0x0271 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ zzcme -> 0x0271 }
            r7.addAll(r13)     // Catch:{ zzcme -> 0x0271 }
            goto L_0x0150
        L_0x017a:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ zzcme -> 0x0271 }
            r0.<init>(r13)     // Catch:{ zzcme -> 0x0271 }
            r15.put(r7, r0)     // Catch:{ zzcme -> 0x0271 }
            r0 = r23
            goto L_0x0150
        L_0x0185:
            r11.zza((java.net.HttpURLConnection) r14, (int) r10)     // Catch:{ zzcme -> 0x0271 }
            r6.f14673a = r10     // Catch:{ zzcme -> 0x0271 }
            r6.f14674b = r15     // Catch:{ zzcme -> 0x0271 }
            r6.f14675c = r9     // Catch:{ zzcme -> 0x0271 }
            r0 = 200(0xc8, float:2.8E-43)
            r7 = 300(0x12c, float:4.2E-43)
            if (r10 < r0) goto L_0x01ed
            if (r10 >= r7) goto L_0x01ed
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x01e7 }
            java.io.InputStream r0 = r14.getInputStream()     // Catch:{ all -> 0x01e7 }
            r2.<init>(r0)     // Catch:{ all -> 0x01e7 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x01e4 }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzm.zza((java.io.InputStreamReader) r2)     // Catch:{ all -> 0x01e4 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzcme -> 0x0271 }
            r11.zzev(r0)     // Catch:{ zzcme -> 0x0271 }
            r6.f14675c = r0     // Catch:{ zzcme -> 0x0271 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzcme -> 0x0271 }
            if (r0 == 0) goto L_0x01cf
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcvg     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzcme -> 0x0271 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ zzcme -> 0x0271 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzcme -> 0x0271 }
            boolean r0 = r0.booleanValue()     // Catch:{ zzcme -> 0x0271 }
            if (r0 == 0) goto L_0x01c7
            goto L_0x01cf
        L_0x01c7:
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.NO_FILL     // Catch:{ zzcme -> 0x0271 }
            r0.<init>(r2)     // Catch:{ zzcme -> 0x0271 }
            throw r0     // Catch:{ zzcme -> 0x0271 }
        L_0x01cf:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ zzcme -> 0x0271 }
            long r2 = r0.elapsedRealtime()     // Catch:{ zzcme -> 0x0271 }
            long r2 = r2 - r16
            r6.f14676d = r2     // Catch:{ zzcme -> 0x0271 }
            r14.disconnect()     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.internal.ads.zzaty r0 = r1.f14664c     // Catch:{ IOException -> 0x02aa }
            r0.zzwb()     // Catch:{ IOException -> 0x02aa }
            return r6
        L_0x01e4:
            r0 = move-exception
            r7 = r2
            goto L_0x01e9
        L_0x01e7:
            r0 = move-exception
            r7 = 0
        L_0x01e9:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ zzcme -> 0x0271 }
            throw r0     // Catch:{ zzcme -> 0x0271 }
        L_0x01ed:
            if (r10 < r7) goto L_0x0246
            r0 = 400(0x190, float:5.6E-43)
            if (r10 >= r0) goto L_0x0246
            java.lang.String r0 = "Location"
            java.lang.String r0 = r14.getHeaderField(r0)     // Catch:{ zzcme -> 0x0271 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzcme -> 0x0271 }
            if (r7 != 0) goto L_0x0237
            java.net.URL r7 = new java.net.URL     // Catch:{ zzcme -> 0x0271 }
            r7.<init>(r0)     // Catch:{ zzcme -> 0x0271 }
            r0 = 1
            int r9 = r18 + 1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r10 = com.google.android.gms.internal.ads.zzabf.zzcuh     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzabb r11 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzcme -> 0x0271 }
            java.lang.Object r10 = r11.zzd(r10)     // Catch:{ zzcme -> 0x0271 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ zzcme -> 0x0271 }
            int r10 = r10.intValue()     // Catch:{ zzcme -> 0x0271 }
            if (r9 > r10) goto L_0x0228
            r14.disconnect()     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.internal.ads.zzaty r10 = r1.f14664c     // Catch:{ IOException -> 0x02aa }
            r10.zzwb()     // Catch:{ IOException -> 0x02aa }
            r0 = r23
            r18 = r9
            r14 = 1
            goto L_0x0098
        L_0x0228:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ zzcme -> 0x0271 }
            java.lang.String r3 = "Too many redirects"
            r0.<init>(r2, r3)     // Catch:{ zzcme -> 0x0271 }
            throw r0     // Catch:{ zzcme -> 0x0271 }
        L_0x0237:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ zzcme -> 0x0271 }
            java.lang.String r3 = "No location header to follow redirect"
            r0.<init>(r2, r3)     // Catch:{ zzcme -> 0x0271 }
            throw r0     // Catch:{ zzcme -> 0x0271 }
        L_0x0246:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ zzcme -> 0x0271 }
            r3 = 46
            r0.<init>(r3)     // Catch:{ zzcme -> 0x0271 }
            r0.append(r2)     // Catch:{ zzcme -> 0x0271 }
            r0.append(r10)     // Catch:{ zzcme -> 0x0271 }
            java.lang.String r0 = r0.toString()     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0271 }
            com.google.android.gms.internal.ads.zzdok r4 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ zzcme -> 0x0271 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ zzcme -> 0x0271 }
            r5.<init>(r3)     // Catch:{ zzcme -> 0x0271 }
            r5.append(r2)     // Catch:{ zzcme -> 0x0271 }
            r5.append(r10)     // Catch:{ zzcme -> 0x0271 }
            java.lang.String r2 = r5.toString()     // Catch:{ zzcme -> 0x0271 }
            r0.<init>(r4, r2)     // Catch:{ zzcme -> 0x0271 }
            throw r0     // Catch:{ zzcme -> 0x0271 }
        L_0x0271:
            r0 = move-exception
            goto L_0x0278
        L_0x0273:
            r0 = move-exception
            r14 = r13
            goto L_0x02a1
        L_0x0276:
            r0 = move-exception
            r14 = r13
        L_0x0278:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzcza     // Catch:{ all -> 0x02a0 }
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x02a0 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ all -> 0x02a0 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x02a0 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x029f
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ all -> 0x02a0 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x02a0 }
            long r2 = r2 - r16
            r6.f14676d = r2     // Catch:{ all -> 0x02a0 }
            r14.disconnect()     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.internal.ads.zzaty r0 = r1.f14664c     // Catch:{ IOException -> 0x02aa }
            r0.zzwb()     // Catch:{ IOException -> 0x02aa }
            return r6
        L_0x029f:
            throw r0     // Catch:{ all -> 0x02a0 }
        L_0x02a0:
            r0 = move-exception
        L_0x02a1:
            r14.disconnect()     // Catch:{ IOException -> 0x02aa }
            com.google.android.gms.internal.ads.zzaty r2 = r1.f14664c     // Catch:{ IOException -> 0x02aa }
            r2.zzwb()     // Catch:{ IOException -> 0x02aa }
            throw r0     // Catch:{ IOException -> 0x02aa }
        L_0x02aa:
            r0 = move-exception
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r3 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x02c0
            java.lang.String r2 = r2.concat(r3)
            goto L_0x02c6
        L_0x02c0:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x02c6:
            com.google.android.gms.internal.ads.zzaza.zzfa(r2)
            com.google.android.gms.internal.ads.zzcme r3 = new com.google.android.gms.internal.ads.zzcme
            com.google.android.gms.internal.ads.zzdok r4 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR
            r3.<init>(r4, r2, r0)
            goto L_0x02d2
        L_0x02d1:
            throw r3
        L_0x02d2:
            goto L_0x02d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpj.m8226a(java.lang.String, com.google.android.gms.internal.ads.zzatr, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzcpl");
    }

    public final /* synthetic */ Object apply(Object obj) {
        zzcpm zzcpm = (zzcpm) obj;
        return m8226a(zzcpm.f14678b.getUrl(), zzcpm.f14678b, zzcpm.f14677a, this.f14665d);
    }
}
