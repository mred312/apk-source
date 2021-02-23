package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbde extends zzbcx {

    /* renamed from: c */
    private static final Set<String> f13152c = Collections.synchronizedSet(new HashSet());

    /* renamed from: d */
    private static final DecimalFormat f13153d = new DecimalFormat("#,###");

    /* renamed from: a */
    private File f13154a;

    /* renamed from: b */
    private boolean f13155b;

    public zzbde(zzbbe zzbbe) {
        super(zzbbe);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzaza.zzfa("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.f13154a = file;
        if (!file.isDirectory() && !this.f13154a.mkdirs()) {
            String valueOf = String.valueOf(this.f13154a.getAbsolutePath());
            zzaza.zzfa(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.f13154a = null;
        } else if (!this.f13154a.setReadable(true, false) || !this.f13154a.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.f13154a.getAbsolutePath());
            zzaza.zzfa(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.f13154a = null;
        }
    }

    /* renamed from: e */
    private final File m7720e(File file) {
        return new File(this.f13154a, String.valueOf(file.getName()).concat(".done"));
    }

    public final void abort() {
        this.f13155b = true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v29, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01ea, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f2, code lost:
        if (r1 < 400) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f4, code lost:
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0204, code lost:
        if (r2.length() == 0) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0206, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x020c, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0239, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x023a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0242, code lost:
        if (r7 >= 0) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x024e, code lost:
        if (r1.length() == 0) goto L_0x0255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0250, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0255, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x025b, code lost:
        com.google.android.gms.internal.ads.zzaza.zzfa(r0);
        zza(r9, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        f13152c.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x026c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        r1 = f13153d.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmg)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0284, code lost:
        if (r7 <= r3) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r9);
        com.google.android.gms.internal.ads.zzaza.zzfa(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02bf, code lost:
        if (r1.length() == 0) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c1, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c6, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02cc, code lost:
        zza(r9, r12.getAbsolutePath(), "sizeExceeded", r0);
        f13152c.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02da, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzaza.zzeb(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzp.zzkx();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0334, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        r6 = new com.google.android.gms.ads.internal.util.zzbs(((java.lang.Long) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmj)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmi)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x034e, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0352, code lost:
        if (r20 < 0) goto L_0x046a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0354, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0356, code lost:
        if (r11 <= r3) goto L_0x038b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0358, code lost:
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0368, code lost:
        if (r1.length() == 0) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x036a, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0370, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x037c, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x037d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0380, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0383, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0386, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0388, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0392, code lost:
        if (r2.write(r1) > 0) goto L_0x038e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0394, code lost:
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03a3, code lost:
        if (r24 > 0) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03a5, code lost:
        r20 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03a9, code lost:
        if (r8.f13155b != false) goto L_0x040e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03af, code lost:
        if (r6.tryAcquire() == false) goto L_0x03e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03b1, code lost:
        r21 = r12.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03b7, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03b9, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03bb, code lost:
        r24 = r10;
        r10 = com.google.android.gms.internal.ads.zzayr.zzzz;
        r1 = r1;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r4 = r21;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03d9, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        r1 = new com.google.android.gms.internal.ads.C1944g8(r30, r31, r4, r11, r7, false);
        r10.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03e0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03e2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03e3, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03e8, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03fa, code lost:
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x040e, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x041d, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x041e, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0451, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0452, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0455, code lost:
        r2 = r2.toString();
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x045c, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0460, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0463, code lost:
        r27 = r4;
        r22 = r15;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x046a, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:?, code lost:
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0479, code lost:
        if (com.google.android.gms.internal.ads.zzaza.isLoggable(3) == false) goto L_0x04ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x047b, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:?, code lost:
        r1 = f13153d.format((long) r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r9);
        com.google.android.gms.internal.ads.zzaza.zzeb(r3.toString());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04b2, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04b4, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x04c3, code lost:
        if (r0.isFile() == false) goto L_0x04cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04c5, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04cd, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
        r0.createNewFile();
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        zza(r9, r12.getAbsolutePath(), r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04d9, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        f13152c.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x04de, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x04e0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04e4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x04e7, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04e9, code lost:
        r15 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x04ef, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04f3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04f6, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x04f9, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x04ff, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0509, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x050a, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0514, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0515, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0518, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x051b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x051e, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0521, code lost:
        r2 = null;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0527, code lost:
        com.google.android.gms.ads.internal.zzp.zzku().zza(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0539, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r9);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzaza.zzez(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x055d, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r9);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzaza.zzd(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x059c, code lost:
        r0 = "Could not delete partial cache file at ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x05a1, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x03fa, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012a, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.ads.internal.zzp.zzlc();
        r1 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmk)).intValue();
        r2 = new java.net.URL(r9);
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0145, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0148, code lost:
        if (r3 > 20) goto L_0x050a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014a, code lost:
        r5 = r2.openConnection();
        r5.setConnectTimeout(r1);
        r5.setReadTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0156, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x04ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0158, code lost:
        r5 = (java.net.HttpURLConnection) r5;
        r6 = new com.google.android.gms.internal.ads.zzayu();
        r6.zza(r5, (byte[]) null);
        r5.setInstanceFollowRedirects(false);
        r7 = r5.getResponseCode();
        r6.zza(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x016f, code lost:
        if ((r7 / 100) != 3) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4 = r5.getHeaderField("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0177, code lost:
        if (r4 == null) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0179, code lost:
        r6 = new java.net.URL(r2, r4);
        r2 = r6.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0182, code lost:
        if (r2 == null) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018a, code lost:
        if (r2.equals("http") != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0192, code lost:
        if (r2.equals("https") != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0194, code lost:
        r2 = java.lang.String.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a0, code lost:
        if (r2.length() == 0) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a2, code lost:
        r1 = "Unsupported scheme: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a7, code lost:
        r1 = new java.lang.String("Unsupported scheme: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b0, code lost:
        throw new java.io.IOException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b1, code lost:
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01bb, code lost:
        if (r4.length() == 0) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01bd, code lost:
        r2 = "Redirecting to ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c2, code lost:
        r2 = new java.lang.String("Redirecting to ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c8, code lost:
        com.google.android.gms.internal.ads.zzaza.zzeb(r2);
        r5.disconnect();
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d8, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e0, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e4, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e5, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:215:0x04d0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04b2 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r22 r24 r27 
      PHI: (r22v8 java.lang.String) = (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v16 java.lang.String), (r22v16 java.lang.String) binds: [B:213:0x04cd, B:214:?, B:211:0x04c5, B:212:?, B:201:0x047b, B:202:?, B:171:0x03b9, B:174:0x03d9] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 java.lang.String) = (r24v12 java.lang.String), (r24v13 java.lang.String), (r24v15 java.lang.String), (r24v17 java.lang.String), (r24v19 java.lang.String), (r24v21 java.lang.String), (r24v26 java.lang.String), (r24v29 java.lang.String) binds: [B:213:0x04cd, B:214:?, B:211:0x04c5, B:212:?, B:201:0x047b, B:202:?, B:171:0x03b9, B:174:0x03d9] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v10 java.io.FileOutputStream) = (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v15 java.io.FileOutputStream), (r27v18 java.io.FileOutputStream) binds: [B:213:0x04cd, B:214:?, B:211:0x04c5, B:212:?, B:201:0x047b, B:202:?, B:171:0x03b9, B:174:0x03d9] A[DONT_GENERATE, DONT_INLINE], Splitter:B:174:0x03d9] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0539  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x055d  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x059c  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x05a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfj(java.lang.String r31) {
        /*
            r30 = this;
            r8 = r30
            r9 = r31
            java.io.File r0 = r8.f13154a
            r10 = 0
            r11 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "noCacheDir"
            r8.zza(r9, r10, r0, r10)
            return r11
        L_0x0010:
            java.io.File r0 = r8.f13154a
            if (r0 != 0) goto L_0x0016
            r3 = 0
            goto L_0x0032
        L_0x0016:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x001d:
            if (r2 >= r1) goto L_0x0032
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x002f
            int r3 = r3 + 1
        L_0x002f:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x0032:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzabf.zzcmf
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0095
            java.io.File r0 = r8.f13154a
            if (r0 != 0) goto L_0x004a
        L_0x0048:
            r0 = 0
            goto L_0x0088
        L_0x004a:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r5 = r10
            r4 = 0
        L_0x0056:
            if (r4 >= r3) goto L_0x0073
            r6 = r0[r4]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0070
            long r12 = r6.lastModified()
            int r7 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x0070
            r5 = r6
            r1 = r12
        L_0x0070:
            int r4 = r4 + 1
            goto L_0x0056
        L_0x0073:
            if (r5 == 0) goto L_0x0048
            boolean r0 = r5.delete()
            java.io.File r1 = r8.m7720e(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0088
            boolean r1 = r1.delete()
            r0 = r0 & r1
        L_0x0088:
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)
            java.lang.String r0 = "expireFailed"
            r8.zza(r9, r10, r0, r10)
            return r11
        L_0x0095:
            java.lang.String r0 = r30.zzfk(r31)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.f13154a
            r12.<init>(r1, r0)
            java.io.File r0 = r8.m7720e(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00d8
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00d8
            long r0 = r12.length()
            int r1 = (int) r0
            java.lang.String r0 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00c7
            java.lang.String r0 = r0.concat(r2)
            goto L_0x00cd
        L_0x00c7:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x00cd:
            com.google.android.gms.internal.ads.zzaza.zzeb(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r1)
            return r13
        L_0x00d8:
            java.io.File r1 = r8.f13154a
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00f2
            java.lang.String r1 = r1.concat(r2)
            r14 = r1
            goto L_0x00f8
        L_0x00f2:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r14 = r2
        L_0x00f8:
            java.util.Set<java.lang.String> r1 = f13152c
            monitor-enter(r1)
            boolean r2 = r1.contains(r14)     // Catch:{ all -> 0x05b8 }
            if (r2 == 0) goto L_0x0126
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ all -> 0x05b8 }
            int r3 = r2.length()     // Catch:{ all -> 0x05b8 }
            if (r3 == 0) goto L_0x0112
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x05b8 }
            goto L_0x0118
        L_0x0112:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x05b8 }
            r2.<init>(r0)     // Catch:{ all -> 0x05b8 }
            r0 = r2
        L_0x0118:
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ all -> 0x05b8 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x05b8 }
            java.lang.String r2 = "inProgress"
            r8.zza(r9, r0, r2, r10)     // Catch:{ all -> 0x05b8 }
            monitor-exit(r1)     // Catch:{ all -> 0x05b8 }
            return r11
        L_0x0126:
            r1.add(r14)     // Catch:{ all -> 0x05b8 }
            monitor-exit(r1)     // Catch:{ all -> 0x05b8 }
            java.lang.String r15 = "error"
            com.google.android.gms.ads.internal.zzp.zzlc()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcmk     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r2.<init>(r9)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r3 = 0
        L_0x0145:
            int r3 = r3 + r13
            r4 = 20
            if (r3 > r4) goto L_0x050a
            java.net.URLConnection r5 = r2.openConnection()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r5.setConnectTimeout(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r5.setReadTimeout(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            boolean r6 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            if (r6 == 0) goto L_0x04ff
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            com.google.android.gms.internal.ads.zzayu r6 = new com.google.android.gms.internal.ads.zzayu     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r6.<init>()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r6.zza((java.net.HttpURLConnection) r5, (byte[]) r10)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r5.setInstanceFollowRedirects(r11)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r7 = r5.getResponseCode()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r6.zza((java.net.HttpURLConnection) r5, (int) r7)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r7 = r7 / 100
            r6 = 3
            if (r7 != r6) goto L_0x01e8
            java.lang.String r4 = "Location"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r4 == 0) goto L_0x01d9
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r6.<init>(r2, r4)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r2 = r6.getProtocol()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r2 == 0) goto L_0x01d1
            java.lang.String r7 = "http"
            boolean r7 = r2.equals(r7)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r7 != 0) goto L_0x01b1
            java.lang.String r7 = "https"
            boolean r7 = r2.equals(r7)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r7 != 0) goto L_0x01b1
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r1 = "Unsupported scheme: "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r3 == 0) goto L_0x01a7
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            goto L_0x01ad
        L_0x01a7:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r1 = r2
        L_0x01ad:
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            throw r0     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
        L_0x01b1:
            java.lang.String r2 = "Redirecting to "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r7 = r4.length()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r7 == 0) goto L_0x01c2
            java.lang.String r2 = r2.concat(r4)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            goto L_0x01c8
        L_0x01c2:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2 = r4
        L_0x01c8:
            com.google.android.gms.internal.ads.zzaza.zzeb(r2)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r5.disconnect()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2 = r6
            goto L_0x0145
        L_0x01d1:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r1 = "Protocol is null"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            throw r0     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
        L_0x01d9:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r1 = "Missing Location header in redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            throw r0     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
        L_0x01e1:
            r0 = move-exception
            goto L_0x01e4
        L_0x01e3:
            r0 = move-exception
        L_0x01e4:
            r2 = r10
        L_0x01e5:
            r1 = r14
            goto L_0x0523
        L_0x01e8:
            boolean r1 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            if (r1 == 0) goto L_0x023e
            int r1 = r5.getResponseCode()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 < r2) goto L_0x023e
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r2 = java.lang.Integer.toString(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r3 == 0) goto L_0x020c
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2 = r0
            goto L_0x0211
        L_0x020c:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
        L_0x0211:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            int r3 = r3.length()     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            int r3 = r3 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            r4.<init>(r3)     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            java.lang.String r3 = "HTTP status code "
            r4.append(r3)     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            r4.append(r1)     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            java.lang.String r1 = " at "
            r4.append(r1)     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            r4.append(r9)     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            r0.<init>(r1)     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
            throw r0     // Catch:{ IOException -> 0x023c, RuntimeException -> 0x023a }
        L_0x023a:
            r0 = move-exception
            goto L_0x01e5
        L_0x023c:
            r0 = move-exception
            goto L_0x01e5
        L_0x023e:
            int r7 = r5.getContentLength()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            if (r7 >= 0) goto L_0x026d
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r1 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r2 == 0) goto L_0x0255
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            goto L_0x025b
        L_0x0255:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r0 = r1
        L_0x025b:
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r1 = "contentLengthMissing"
            r8.zza(r9, r0, r1, r10)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.util.Set<java.lang.String> r0 = f13152c     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            return r11
        L_0x026d:
            java.text.DecimalFormat r1 = f13153d     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            long r2 = (long) r7     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zzabf.zzcmg     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r3 = r2.intValue()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            if (r7 <= r3) goto L_0x02db
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r0 = r0.length()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r0 = r0 + 33
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r0 = "Content length "
            r2.append(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2.append(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r0 = " exceeds limit at "
            r2.append(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r2.append(r9)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            if (r2 == 0) goto L_0x02c6
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            goto L_0x02cc
        L_0x02c6:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r0 = r1
        L_0x02cc:
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.lang.String r2 = "sizeExceeded"
            r8.zza(r9, r1, r2, r0)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            java.util.Set<java.lang.String> r0 = f13152c     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01e3, RuntimeException -> 0x01e1 }
            return r11
        L_0x02db:
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r2 = r2.length()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r2 = r2 + r4
            java.lang.String r4 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r4 = r4.length()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            int r2 = r2 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r4.<init>(r2)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.String r2 = "Caching "
            r4.append(r2)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r4.append(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r4.append(r9)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            com.google.android.gms.internal.ads.zzaza.zzeb(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            r4.<init>(r12)     // Catch:{ IOException -> 0x051d, RuntimeException -> 0x051b }
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzabf.zzcmj     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            com.google.android.gms.internal.ads.zzabb r10 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            java.lang.Object r6 = r10.zzd(r6)     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            r10 = r14
            long r13 = r6.longValue()     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            com.google.android.gms.ads.internal.util.zzbs r6 = new com.google.android.gms.ads.internal.util.zzbs     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            r6.<init>(r13)     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r13 = com.google.android.gms.internal.ads.zzabf.zzcmi     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            com.google.android.gms.internal.ads.zzabb r14 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            java.lang.Object r13 = r14.zzd(r13)     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            long r13 = r13.longValue()     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
        L_0x034e:
            int r20 = r5.read(r1)     // Catch:{ IOException -> 0x04ee, RuntimeException -> 0x04ec }
            if (r20 < 0) goto L_0x046a
            int r11 = r11 + r20
            if (r11 <= r3) goto L_0x038b
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r11)     // Catch:{ IOException -> 0x0385, RuntimeException -> 0x0383 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0385, RuntimeException -> 0x0383 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x0385, RuntimeException -> 0x0383 }
            if (r2 == 0) goto L_0x0370
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x0385, RuntimeException -> 0x0383 }
            r1 = r0
            goto L_0x0375
        L_0x0370:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0385, RuntimeException -> 0x0383 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0385, RuntimeException -> 0x0383 }
        L_0x0375:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x037f, RuntimeException -> 0x037d }
            java.lang.String r2 = "stream cache file size limit exceeded"
            r0.<init>(r2)     // Catch:{ IOException -> 0x037f, RuntimeException -> 0x037d }
            throw r0     // Catch:{ IOException -> 0x037f, RuntimeException -> 0x037d }
        L_0x037d:
            r0 = move-exception
            goto L_0x0380
        L_0x037f:
            r0 = move-exception
        L_0x0380:
            r2 = r1
            r1 = r10
            goto L_0x0388
        L_0x0383:
            r0 = move-exception
            goto L_0x0386
        L_0x0385:
            r0 = move-exception
        L_0x0386:
            r1 = r10
            r2 = 0
        L_0x0388:
            r10 = r4
            goto L_0x0523
        L_0x038b:
            r1.flip()     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
        L_0x038e:
            int r20 = r2.write(r1)     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
            if (r20 > 0) goto L_0x038e
            r1.clear()     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
            long r20 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
            long r20 = r20 - r17
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r13
            int r24 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r24 > 0) goto L_0x041e
            r20 = r1
            boolean r1 = r8.f13155b     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
            if (r1 != 0) goto L_0x040e
            boolean r1 = r6.tryAcquire()     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
            if (r1 == 0) goto L_0x03e8
            java.lang.String r21 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
            android.os.Handler r1 = com.google.android.gms.internal.ads.zzayr.zzzz     // Catch:{ IOException -> 0x0462, RuntimeException -> 0x0460 }
            r22 = r15
            com.google.android.gms.internal.ads.g8 r15 = new com.google.android.gms.internal.ads.g8     // Catch:{ IOException -> 0x03e2, RuntimeException -> 0x03e0 }
            r23 = 0
            r24 = r10
            r10 = r1
            r1 = r15
            r25 = r2
            r2 = r30
            r26 = r3
            r3 = r31
            r27 = r4
            r4 = r21
            r21 = r5
            r5 = r11
            r19 = r6
            r28 = 3
            r6 = r7
            r29 = r7
            r7 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            r10.post(r15)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            goto L_0x03fa
        L_0x03e0:
            r0 = move-exception
            goto L_0x03e3
        L_0x03e2:
            r0 = move-exception
        L_0x03e3:
            r27 = r4
            r1 = r10
            goto L_0x04e9
        L_0x03e8:
            r25 = r2
            r26 = r3
            r27 = r4
            r21 = r5
            r19 = r6
            r29 = r7
            r24 = r10
            r22 = r15
            r28 = 3
        L_0x03fa:
            r6 = r19
            r1 = r20
            r5 = r21
            r15 = r22
            r10 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r7 = r29
            goto L_0x034e
        L_0x040e:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            throw r0     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
        L_0x041e:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r13)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            int r1 = r1.length()     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            r2.<init>(r1)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            r2.append(r0)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            java.lang.String r10 = r2.toString()     // Catch:{ IOException -> 0x045e, RuntimeException -> 0x045c }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0454, RuntimeException -> 0x0452 }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0454, RuntimeException -> 0x0452 }
            throw r0     // Catch:{ IOException -> 0x0454, RuntimeException -> 0x0452 }
        L_0x0452:
            r0 = move-exception
            goto L_0x0455
        L_0x0454:
            r0 = move-exception
        L_0x0455:
            r2 = r10
            r1 = r24
            r10 = r27
            goto L_0x0523
        L_0x045c:
            r0 = move-exception
            goto L_0x04b7
        L_0x045e:
            r0 = move-exception
            goto L_0x04b7
        L_0x0460:
            r0 = move-exception
            goto L_0x0463
        L_0x0462:
            r0 = move-exception
        L_0x0463:
            r27 = r4
            r22 = r15
            r1 = r10
            goto L_0x04fb
        L_0x046a:
            r27 = r4
            r24 = r10
            r22 = r15
            r28 = 3
            r27.close()     // Catch:{ IOException -> 0x04e6, RuntimeException -> 0x04e4 }
            boolean r1 = com.google.android.gms.internal.ads.zzaza.isLoggable(r28)     // Catch:{ IOException -> 0x04e6, RuntimeException -> 0x04e4 }
            if (r1 == 0) goto L_0x04ba
            java.text.DecimalFormat r1 = f13153d     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            long r2 = (long) r11     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            java.lang.String r2 = "Preloaded "
            r3.append(r2)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            r3.append(r1)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            java.lang.String r1 = " bytes from "
            r3.append(r1)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            r3.append(r9)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            com.google.android.gms.internal.ads.zzaza.zzeb(r1)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            goto L_0x04ba
        L_0x04b2:
            r0 = move-exception
            goto L_0x04b5
        L_0x04b4:
            r0 = move-exception
        L_0x04b5:
            r15 = r22
        L_0x04b7:
            r1 = r24
            goto L_0x04fb
        L_0x04ba:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)     // Catch:{ IOException -> 0x04e6, RuntimeException -> 0x04e4 }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x04e6, RuntimeException -> 0x04e4 }
            if (r1 == 0) goto L_0x04cd
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x04b4, RuntimeException -> 0x04b2 }
            goto L_0x04d0
        L_0x04cd:
            r0.createNewFile()     // Catch:{ IOException -> 0x04d0, RuntimeException -> 0x04b2 }
        L_0x04d0:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x04e6, RuntimeException -> 0x04e4 }
            r8.zza(r9, r0, r11)     // Catch:{ IOException -> 0x04e6, RuntimeException -> 0x04e4 }
            java.util.Set<java.lang.String> r0 = f13152c     // Catch:{ IOException -> 0x04e6, RuntimeException -> 0x04e4 }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x04e2, RuntimeException -> 0x04e0 }
            r0 = 1
            return r0
        L_0x04e0:
            r0 = move-exception
            goto L_0x04e9
        L_0x04e2:
            r0 = move-exception
            goto L_0x04e9
        L_0x04e4:
            r0 = move-exception
            goto L_0x04e7
        L_0x04e6:
            r0 = move-exception
        L_0x04e7:
            r1 = r24
        L_0x04e9:
            r15 = r22
            goto L_0x04fb
        L_0x04ec:
            r0 = move-exception
            goto L_0x04ef
        L_0x04ee:
            r0 = move-exception
        L_0x04ef:
            r27 = r4
            r1 = r10
            goto L_0x04f9
        L_0x04f3:
            r0 = move-exception
            goto L_0x04f6
        L_0x04f5:
            r0 = move-exception
        L_0x04f6:
            r27 = r4
            r1 = r14
        L_0x04f9:
            r22 = r15
        L_0x04fb:
            r10 = r27
            r2 = 0
            goto L_0x0523
        L_0x04ff:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0517, RuntimeException -> 0x0515 }
            java.lang.String r2 = "Invalid protocol."
            r0.<init>(r2)     // Catch:{ IOException -> 0x0517, RuntimeException -> 0x0515 }
            throw r0     // Catch:{ IOException -> 0x0517, RuntimeException -> 0x0515 }
        L_0x050a:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0517, RuntimeException -> 0x0515 }
            java.lang.String r2 = "Too many redirects (20)"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0517, RuntimeException -> 0x0515 }
            throw r0     // Catch:{ IOException -> 0x0517, RuntimeException -> 0x0515 }
        L_0x0515:
            r0 = move-exception
            goto L_0x0518
        L_0x0517:
            r0 = move-exception
        L_0x0518:
            r15 = r22
            goto L_0x0521
        L_0x051b:
            r0 = move-exception
            goto L_0x051e
        L_0x051d:
            r0 = move-exception
        L_0x051e:
            r1 = r14
            r22 = r15
        L_0x0521:
            r2 = 0
            r10 = 0
        L_0x0523:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0530
            com.google.android.gms.internal.ads.zzayg r3 = com.google.android.gms.ads.internal.zzp.zzku()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zza(r0, r4)
        L_0x0530:
            r10.close()     // Catch:{ IOException | NullPointerException -> 0x0534 }
            goto L_0x0535
        L_0x0534:
        L_0x0535:
            boolean r3 = r8.f13155b
            if (r3 == 0) goto L_0x055d
            java.lang.String r0 = java.lang.String.valueOf(r31)
            int r0 = r0.length()
            int r0 = r0 + 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r3.append(r0)
            r3.append(r9)
            java.lang.String r0 = "\""
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzaza.zzez(r0)
            goto L_0x0580
        L_0x055d:
            java.lang.String r3 = java.lang.String.valueOf(r31)
            int r3 = r3.length()
            int r3 = r3 + 25
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Preload failed for URL \""
            r4.append(r3)
            r4.append(r9)
            java.lang.String r3 = "\""
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.google.android.gms.internal.ads.zzaza.zzd(r3, r0)
        L_0x0580:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x05aa
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x05aa
            java.lang.String r0 = "Could not delete partial cache file at "
            java.lang.String r3 = r12.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x05a1
            java.lang.String r0 = r0.concat(r3)
            goto L_0x05a7
        L_0x05a1:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0)
            r0 = r3
        L_0x05a7:
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)
        L_0x05aa:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r15, r2)
            java.util.Set<java.lang.String> r0 = f13152c
            r0.remove(r1)
            r1 = 0
            return r1
        L_0x05b8:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x05b8 }
            goto L_0x05bc
        L_0x05bb:
            throw r0
        L_0x05bc:
            goto L_0x05bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbde.zzfj(java.lang.String):boolean");
    }
}
