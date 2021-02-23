package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzav implements zzk {

    /* renamed from: a */
    private final Map<String, C2612y4> f12863a;

    /* renamed from: b */
    private long f12864b;

    /* renamed from: c */
    private final zzaz f12865c;

    /* renamed from: d */
    private final int f12866d;

    public zzav(File file, int i) {
        this.f12863a = new LinkedHashMap(16, 0.75f, true);
        this.f12864b = 0;
        this.f12865c = new C2163m5(this, file);
        this.f12866d = 20971520;
    }

    /* renamed from: a */
    private final synchronized void m7563a(String str) {
        boolean delete = m7577o(str).delete();
        m7564b(str);
        if (!delete) {
            zzaq.m7524d("Could not delete cache entry for key=%s, filename=%s", str, m7576n(str));
        }
    }

    /* renamed from: b */
    private final void m7564b(String str) {
        C2612y4 remove = this.f12863a.remove(str);
        if (remove != null) {
            this.f12864b -= remove.f11978a;
        }
    }

    /* renamed from: c */
    private static int m7565c(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    @VisibleForTesting
    /* renamed from: d */
    private static InputStream m7566d(File file) {
        return new FileInputStream(file);
    }

    /* renamed from: e */
    static String m7567e(C2016i6 i6Var) {
        return new String(m7572j(i6Var, m7575m(i6Var)), Key.STRING_CHARSET_NAME);
    }

    /* renamed from: f */
    static void m7568f(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    /* renamed from: g */
    static void m7569g(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    /* renamed from: h */
    static void m7570h(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
        m7569g(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: i */
    private final void m7571i(String str, C2612y4 y4Var) {
        if (!this.f12863a.containsKey(str)) {
            this.f12864b += y4Var.f11978a;
        } else {
            this.f12864b += y4Var.f11978a - this.f12863a.get(str).f11978a;
        }
        this.f12863a.put(str, y4Var);
    }

    @VisibleForTesting
    /* renamed from: j */
    private static byte[] m7572j(C2016i6 i6Var, long j) {
        long a = i6Var.mo14249a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(i6Var).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(a);
        throw new IOException(sb.toString());
    }

    /* renamed from: k */
    static int m7573k(InputStream inputStream) {
        return (m7565c(inputStream) << 24) | m7565c(inputStream) | 0 | (m7565c(inputStream) << 8) | (m7565c(inputStream) << 16);
    }

    /* renamed from: l */
    static List<zzu> m7574l(C2016i6 i6Var) {
        int k = m7573k(i6Var);
        if (k >= 0) {
            List<zzu> emptyList = k == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < k; i++) {
                emptyList.add(new zzu(m7567e(i6Var).intern(), m7567e(i6Var).intern()));
            }
            return emptyList;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("readHeaderList size=");
        sb.append(k);
        throw new IOException(sb.toString());
    }

    /* renamed from: m */
    static long m7575m(InputStream inputStream) {
        return (((long) m7565c(inputStream)) & 255) | 0 | ((((long) m7565c(inputStream)) & 255) << 8) | ((((long) m7565c(inputStream)) & 255) << 16) | ((((long) m7565c(inputStream)) & 255) << 24) | ((((long) m7565c(inputStream)) & 255) << 32) | ((((long) m7565c(inputStream)) & 255) << 40) | ((((long) m7565c(inputStream)) & 255) << 48) | ((255 & ((long) m7565c(inputStream))) << 56);
    }

    /* renamed from: n */
    private static String m7576n(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: o */
    private final File m7577o(String str) {
        return new File(this.f12865c.zzo(), m7576n(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0057 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize() {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzaz r0 = r9.f12865c     // Catch:{ all -> 0x005f }
            java.io.File r0 = r0.zzo()     // Catch:{ all -> 0x005f }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x005f }
            r2 = 0
            if (r1 != 0) goto L_0x0024
            boolean r1 = r0.mkdirs()     // Catch:{ all -> 0x005f }
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = "Unable to create cache dir %s"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x005f }
            r3[r2] = r0     // Catch:{ all -> 0x005f }
            com.google.android.gms.internal.ads.zzaq.m7525e(r1, r3)     // Catch:{ all -> 0x005f }
        L_0x0022:
            monitor-exit(r9)
            return
        L_0x0024:
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x002c
            monitor-exit(r9)
            return
        L_0x002c:
            int r1 = r0.length     // Catch:{ all -> 0x005f }
        L_0x002d:
            if (r2 >= r1) goto L_0x005d
            r3 = r0[r2]     // Catch:{ all -> 0x005f }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.ads.i6 r6 = new com.google.android.gms.internal.ads.i6     // Catch:{ IOException -> 0x0057 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0057 }
            java.io.InputStream r8 = m7566d(r3)     // Catch:{ IOException -> 0x0057 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0057 }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.ads.y4 r7 = com.google.android.gms.internal.ads.C2612y4.m7271b(r6)     // Catch:{ all -> 0x0052 }
            r7.f11978a = r4     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r7.f11979b     // Catch:{ all -> 0x0052 }
            r9.m7571i(r4, r7)     // Catch:{ all -> 0x0052 }
            r6.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005a
        L_0x0052:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x0057 }
            throw r4     // Catch:{ IOException -> 0x0057 }
        L_0x0057:
            r3.delete()     // Catch:{ all -> 0x005f }
        L_0x005a:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x005d:
            monitor-exit(r9)
            return
        L_0x005f:
            r0 = move-exception
            monitor-exit(r9)
            goto L_0x0063
        L_0x0062:
            throw r0
        L_0x0063:
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzav.initialize():void");
    }

    public final synchronized void zza(String str, boolean z) {
        zzn zzb = zzb(str);
        if (zzb != null) {
            zzb.zzv = 0;
            zzb.zzu = 0;
            zza(str, zzb);
        }
    }

    public final synchronized zzn zzb(String str) {
        C2016i6 i6Var;
        C2612y4 y4Var = this.f12863a.get(str);
        if (y4Var == null) {
            return null;
        }
        File o = m7577o(str);
        try {
            i6Var = new C2016i6(new BufferedInputStream(m7566d(o)), o.length());
            C2612y4 b = C2612y4.m7271b(i6Var);
            if (!TextUtils.equals(str, b.f11979b)) {
                zzaq.m7524d("%s: key=%s, found=%s", o.getAbsolutePath(), str, b.f11979b);
                m7564b(str);
                i6Var.close();
                return null;
            }
            byte[] j = m7572j(i6Var, i6Var.mo14249a());
            zzn zzn = new zzn();
            zzn.data = j;
            zzn.zzr = y4Var.f11980c;
            zzn.zzs = y4Var.f11981d;
            zzn.zzt = y4Var.f11982e;
            zzn.zzu = y4Var.f11983f;
            zzn.zzv = y4Var.f11984g;
            List<zzu> list = y4Var.f11985h;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzu next : list) {
                treeMap.put(next.getName(), next.getValue());
            }
            zzn.zzw = treeMap;
            zzn.zzx = Collections.unmodifiableList(y4Var.f11985h);
            i6Var.close();
            return zzn;
        } catch (IOException e) {
            zzaq.m7524d("%s: %s", o.getAbsolutePath(), e.toString());
            m7563a(str);
            return null;
        } catch (Throwable th) {
            i6Var.close();
            throw th;
        }
    }

    private zzav(zzaz zzaz, int i) {
        this.f12863a = new LinkedHashMap(16, 0.75f, true);
        this.f12864b = 0;
        this.f12865c = zzaz;
        this.f12866d = 5242880;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0110, code lost:
        if (r3.delete() == false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0112, code lost:
        com.google.android.gms.internal.ads.zzaq.m7524d("Could not clean up file %s", r3.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0129, code lost:
        if (r1.f12865c.zzo().exists() == false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012b, code lost:
        com.google.android.gms.internal.ads.zzaq.m7524d("Re-initializing cache after external clearing.", new java.lang.Object[0]);
        r1.f12863a.clear();
        r1.f12864b = 0;
        initialize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013f, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x010c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r16, com.google.android.gms.internal.ads.zzn r17) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            monitor-enter(r15)
            long r3 = r1.f12864b     // Catch:{ all -> 0x0140 }
            byte[] r5 = r2.data     // Catch:{ all -> 0x0140 }
            int r6 = r5.length     // Catch:{ all -> 0x0140 }
            long r6 = (long) r6     // Catch:{ all -> 0x0140 }
            long r3 = r3 + r6
            int r6 = r1.f12866d     // Catch:{ all -> 0x0140 }
            long r7 = (long) r6     // Catch:{ all -> 0x0140 }
            r9 = 1063675494(0x3f666666, float:0.9)
            int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0022
            int r3 = r5.length     // Catch:{ all -> 0x0140 }
            float r3 = (float) r3
            float r4 = (float) r6
            float r4 = r4 * r9
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0022
            monitor-exit(r15)
            return
        L_0x0022:
            java.io.File r3 = r15.m7577o(r16)     // Catch:{ all -> 0x0140 }
            r4 = 1
            r5 = 0
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x010c }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x010c }
            r7.<init>(r3)     // Catch:{ IOException -> 0x010c }
            r6.<init>(r7)     // Catch:{ IOException -> 0x010c }
            com.google.android.gms.internal.ads.y4 r7 = new com.google.android.gms.internal.ads.y4     // Catch:{ IOException -> 0x010c }
            r7.<init>(r0, r2)     // Catch:{ IOException -> 0x010c }
            boolean r8 = r7.mo15053a(r6)     // Catch:{ IOException -> 0x010c }
            if (r8 == 0) goto L_0x00f6
            byte[] r2 = r2.data     // Catch:{ IOException -> 0x010c }
            r6.write(r2)     // Catch:{ IOException -> 0x010c }
            r6.close()     // Catch:{ IOException -> 0x010c }
            long r10 = r3.length()     // Catch:{ IOException -> 0x010c }
            r7.f11978a = r10     // Catch:{ IOException -> 0x010c }
            r15.m7571i(r0, r7)     // Catch:{ IOException -> 0x010c }
            long r6 = r1.f12864b     // Catch:{ IOException -> 0x010c }
            int r0 = r1.f12866d     // Catch:{ IOException -> 0x010c }
            long r10 = (long) r0     // Catch:{ IOException -> 0x010c }
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x00f4
            boolean r0 = com.google.android.gms.internal.ads.zzaq.DEBUG     // Catch:{ IOException -> 0x010c }
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = "Pruning old cache entries."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x010c }
            com.google.android.gms.internal.ads.zzaq.m7526v(r0, r2)     // Catch:{ IOException -> 0x010c }
        L_0x0062:
            long r6 = r1.f12864b     // Catch:{ IOException -> 0x010c }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x010c }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.y4> r0 = r1.f12863a     // Catch:{ IOException -> 0x010c }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x010c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x010c }
            r2 = 0
        L_0x0073:
            boolean r8 = r0.hasNext()     // Catch:{ IOException -> 0x010c }
            r12 = 2
            if (r8 == 0) goto L_0x00ca
            java.lang.Object r8 = r0.next()     // Catch:{ IOException -> 0x010c }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ IOException -> 0x010c }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x010c }
            com.google.android.gms.internal.ads.y4 r8 = (com.google.android.gms.internal.ads.C2612y4) r8     // Catch:{ IOException -> 0x010c }
            java.lang.String r13 = r8.f11979b     // Catch:{ IOException -> 0x010c }
            java.io.File r13 = r15.m7577o(r13)     // Catch:{ IOException -> 0x010c }
            boolean r13 = r13.delete()     // Catch:{ IOException -> 0x010c }
            if (r13 == 0) goto L_0x009c
            long r13 = r1.f12864b     // Catch:{ IOException -> 0x010c }
            r16 = r10
            long r9 = r8.f11978a     // Catch:{ IOException -> 0x010c }
            long r13 = r13 - r9
            r1.f12864b = r13     // Catch:{ IOException -> 0x010c }
            goto L_0x00af
        L_0x009c:
            r16 = r10
            java.lang.String r9 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r10 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x010c }
            java.lang.String r8 = r8.f11979b     // Catch:{ IOException -> 0x010c }
            r10[r5] = r8     // Catch:{ IOException -> 0x010c }
            java.lang.String r8 = m7576n(r8)     // Catch:{ IOException -> 0x010c }
            r10[r4] = r8     // Catch:{ IOException -> 0x010c }
            com.google.android.gms.internal.ads.zzaq.m7524d(r9, r10)     // Catch:{ IOException -> 0x010c }
        L_0x00af:
            r0.remove()     // Catch:{ IOException -> 0x010c }
            int r2 = r2 + 1
            long r8 = r1.f12864b     // Catch:{ IOException -> 0x010c }
            float r8 = (float) r8     // Catch:{ IOException -> 0x010c }
            int r9 = r1.f12866d     // Catch:{ IOException -> 0x010c }
            float r9 = (float) r9     // Catch:{ IOException -> 0x010c }
            r10 = 1063675494(0x3f666666, float:0.9)
            float r9 = r9 * r10
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x00c4
            goto L_0x00cc
        L_0x00c4:
            r10 = r16
            r9 = 1063675494(0x3f666666, float:0.9)
            goto L_0x0073
        L_0x00ca:
            r16 = r10
        L_0x00cc:
            boolean r0 = com.google.android.gms.internal.ads.zzaq.DEBUG     // Catch:{ IOException -> 0x010c }
            if (r0 == 0) goto L_0x00f4
            java.lang.String r0 = "pruned %d files, %d bytes, %d ms"
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x010c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x010c }
            r8[r5] = r2     // Catch:{ IOException -> 0x010c }
            long r9 = r1.f12864b     // Catch:{ IOException -> 0x010c }
            long r9 = r9 - r6
            java.lang.Long r2 = java.lang.Long.valueOf(r9)     // Catch:{ IOException -> 0x010c }
            r8[r4] = r2     // Catch:{ IOException -> 0x010c }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x010c }
            r9 = r16
            long r6 = r6 - r9
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x010c }
            r8[r12] = r2     // Catch:{ IOException -> 0x010c }
            com.google.android.gms.internal.ads.zzaq.m7526v(r0, r8)     // Catch:{ IOException -> 0x010c }
        L_0x00f4:
            monitor-exit(r15)
            return
        L_0x00f6:
            r6.close()     // Catch:{ IOException -> 0x010c }
            java.lang.String r0 = "Failed to write header for %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x010c }
            java.lang.String r6 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x010c }
            r2[r5] = r6     // Catch:{ IOException -> 0x010c }
            com.google.android.gms.internal.ads.zzaq.m7524d(r0, r2)     // Catch:{ IOException -> 0x010c }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x010c }
            r0.<init>()     // Catch:{ IOException -> 0x010c }
            throw r0     // Catch:{ IOException -> 0x010c }
        L_0x010c:
            boolean r0 = r3.delete()     // Catch:{ all -> 0x0140 }
            if (r0 != 0) goto L_0x011f
            java.lang.String r0 = "Could not clean up file %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x0140 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0140 }
            r2[r5] = r3     // Catch:{ all -> 0x0140 }
            com.google.android.gms.internal.ads.zzaq.m7524d(r0, r2)     // Catch:{ all -> 0x0140 }
        L_0x011f:
            com.google.android.gms.internal.ads.zzaz r0 = r1.f12865c     // Catch:{ all -> 0x0140 }
            java.io.File r0 = r0.zzo()     // Catch:{ all -> 0x0140 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0140 }
            if (r0 != 0) goto L_0x013e
            java.lang.String r0 = "Re-initializing cache after external clearing."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0140 }
            com.google.android.gms.internal.ads.zzaq.m7524d(r0, r2)     // Catch:{ all -> 0x0140 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.y4> r0 = r1.f12863a     // Catch:{ all -> 0x0140 }
            r0.clear()     // Catch:{ all -> 0x0140 }
            r2 = 0
            r1.f12864b = r2     // Catch:{ all -> 0x0140 }
            r15.initialize()     // Catch:{ all -> 0x0140 }
        L_0x013e:
            monitor-exit(r15)
            return
        L_0x0140:
            r0 = move-exception
            monitor-exit(r15)
            goto L_0x0144
        L_0x0143:
            throw r0
        L_0x0144:
            goto L_0x0143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzav.zza(java.lang.String, com.google.android.gms.internal.ads.zzn):void");
    }

    public zzav(zzaz zzaz) {
        this(zzaz, 5242880);
    }
}
