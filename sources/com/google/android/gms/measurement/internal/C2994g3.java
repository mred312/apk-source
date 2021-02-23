package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

@WorkerThread
/* renamed from: com.google.android.gms.measurement.internal.g3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2994g3 implements Runnable {

    /* renamed from: a */
    private final URL f18073a;

    /* renamed from: b */
    private final byte[] f18074b;

    /* renamed from: c */
    private final C2974e3 f18075c;

    /* renamed from: d */
    private final String f18076d;

    /* renamed from: e */
    private final Map<String, String> f18077e;

    /* renamed from: f */
    private final /* synthetic */ zzeu f18078f;

    public C2994g3(zzeu zzeu, String str, URL url, byte[] bArr, Map<String, String> map, C2974e3 e3Var) {
        this.f18078f = zzeu;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(e3Var);
        this.f18073a = url;
        this.f18074b = bArr;
        this.f18075c = e3Var;
        this.f18076d = str;
        this.f18077e = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf A[SYNTHETIC, Splitter:B:47:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010a A[SYNTHETIC, Splitter:B:60:0x010a] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzeu r1 = r13.f18078f
            r1.zzb()
            r1 = 0
            r2 = 0
            com.google.android.gms.measurement.internal.zzeu r3 = r13.f18078f     // Catch:{ IOException -> 0x0103, all -> 0x00c8 }
            java.net.URL r4 = r13.f18073a     // Catch:{ IOException -> 0x0103, all -> 0x00c8 }
            java.net.HttpURLConnection r3 = r3.zza(r4)     // Catch:{ IOException -> 0x0103, all -> 0x00c8 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.f18077e     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            if (r4 == 0) goto L_0x0039
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
        L_0x001d:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            if (r5 == 0) goto L_0x0039
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            r3.addRequestProperty(r6, r5)     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            goto L_0x001d
        L_0x0039:
            byte[] r4 = r13.f18074b     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            if (r4 == 0) goto L_0x0086
            com.google.android.gms.measurement.internal.zzeu r4 = r13.f18078f     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzks r4 = r4.mo20059f_()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            byte[] r5 = r13.f18074b     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            byte[] r4 = r4.mo20540D(r5)     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzeu r5 = r13.f18078f     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzq()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzw()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.lang.String r6 = "Uploading data. size"
            int r7 = r4.length     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            r5.zza(r6, r7)     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            r5 = 1
            r3.setDoOutput(r5)     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r3.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            int r5 = r4.length     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            r3.setFixedLengthStreamingMode(r5)     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            r3.connect()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            r5.write(r4)     // Catch:{ IOException -> 0x0080, all -> 0x007a }
            r5.close()     // Catch:{ IOException -> 0x0080, all -> 0x007a }
            goto L_0x0086
        L_0x007a:
            r4 = move-exception
            r10 = r1
            r2 = r4
            r1 = r5
            goto L_0x00cc
        L_0x0080:
            r4 = move-exception
            r10 = r1
            r8 = r4
            r1 = r5
            goto L_0x0107
        L_0x0086:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00c5, all -> 0x00c2 }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00bd, all -> 0x00b8 }
            com.google.android.gms.measurement.internal.zzeu r2 = r13.f18078f     // Catch:{ IOException -> 0x00b4, all -> 0x00af }
            byte[] r10 = com.google.android.gms.measurement.internal.zzeu.m10779c(r3)     // Catch:{ IOException -> 0x00b4, all -> 0x00af }
            if (r3 == 0) goto L_0x0099
            r3.disconnect()
        L_0x0099:
            com.google.android.gms.measurement.internal.zzeu r0 = r13.f18078f
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzp()
            com.google.android.gms.measurement.internal.h3 r1 = new com.google.android.gms.measurement.internal.h3
            java.lang.String r6 = r13.f18076d
            com.google.android.gms.measurement.internal.e3 r7 = r13.f18075c
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zza((java.lang.Runnable) r1)
            return
        L_0x00af:
            r4 = move-exception
            r2 = r4
            r7 = r8
            r10 = r11
            goto L_0x00cd
        L_0x00b4:
            r4 = move-exception
            r7 = r8
            r10 = r11
            goto L_0x00c0
        L_0x00b8:
            r4 = move-exception
            r10 = r1
            r2 = r4
            r7 = r8
            goto L_0x00cd
        L_0x00bd:
            r4 = move-exception
            r10 = r1
            r7 = r8
        L_0x00c0:
            r8 = r4
            goto L_0x0108
        L_0x00c2:
            r4 = move-exception
            r10 = r1
            goto L_0x00cb
        L_0x00c5:
            r4 = move-exception
            r10 = r1
            goto L_0x0106
        L_0x00c8:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x00cb:
            r2 = r4
        L_0x00cc:
            r7 = 0
        L_0x00cd:
            if (r1 == 0) goto L_0x00e7
            r1.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00e7
        L_0x00d3:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeu r4 = r13.f18078f
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzet r4 = r4.zze()
            java.lang.String r5 = r13.f18076d
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r5)
            r4.zza(r0, r5, r1)
        L_0x00e7:
            if (r3 == 0) goto L_0x00ec
            r3.disconnect()
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzeu r0 = r13.f18078f
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzp()
            com.google.android.gms.measurement.internal.h3 r1 = new com.google.android.gms.measurement.internal.h3
            java.lang.String r5 = r13.f18076d
            com.google.android.gms.measurement.internal.e3 r6 = r13.f18075c
            r8 = 0
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zza((java.lang.Runnable) r1)
            throw r2
        L_0x0103:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x0106:
            r8 = r4
        L_0x0107:
            r7 = 0
        L_0x0108:
            if (r1 == 0) goto L_0x0122
            r1.close()     // Catch:{ IOException -> 0x010e }
            goto L_0x0122
        L_0x010e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeu r2 = r13.f18078f
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zze()
            java.lang.String r4 = r13.f18076d
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r4)
            r2.zza(r0, r4, r1)
        L_0x0122:
            if (r3 == 0) goto L_0x0127
            r3.disconnect()
        L_0x0127:
            com.google.android.gms.measurement.internal.zzeu r0 = r13.f18078f
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzp()
            com.google.android.gms.measurement.internal.h3 r1 = new com.google.android.gms.measurement.internal.h3
            java.lang.String r5 = r13.f18076d
            com.google.android.gms.measurement.internal.e3 r6 = r13.f18075c
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zza((java.lang.Runnable) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2994g3.run():void");
    }
}
