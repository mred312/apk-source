package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WorkerThread
/* renamed from: com.google.android.gms.measurement.internal.q5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3087q5 implements Runnable {

    /* renamed from: a */
    private final URL f18320a;

    /* renamed from: b */
    private final C3096r5 f18321b;

    /* renamed from: c */
    private final String f18322c;

    /* renamed from: d */
    private final /* synthetic */ zzia f18323d;

    public C3087q5(zzia zzia, String str, URL url, byte[] bArr, Map<String, String> map, C3096r5 r5Var) {
        this.f18323d = zzia;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(r5Var);
        this.f18320a = url;
        this.f18321b = r5Var;
        this.f18322c = str;
    }

    /* renamed from: b */
    private final void m10632b(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.f18323d.zzp().zza((Runnable) new C3114t5(this, i, exc, bArr, map));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo20093a(int i, Exception exc, byte[] bArr, Map map) {
        this.f18321b.mo20098a(this.f18322c, i, exc, bArr, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.zzia r0 = r5.f18323d
            r0.zzb()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzia r2 = r5.f18323d     // Catch:{ IOException -> 0x003c, all -> 0x0030 }
            java.net.URL r3 = r5.f18320a     // Catch:{ IOException -> 0x003c, all -> 0x0030 }
            java.net.HttpURLConnection r2 = r2.zza(r3)     // Catch:{ IOException -> 0x003c, all -> 0x0030 }
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x002d, all -> 0x002a }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x002d, all -> 0x002a }
            com.google.android.gms.measurement.internal.zzia r4 = r5.f18323d     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            byte[] r4 = com.google.android.gms.measurement.internal.zzia.m10852c(r2)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            if (r2 == 0) goto L_0x0022
            r2.disconnect()
        L_0x0022:
            r5.m10632b(r1, r0, r4, r3)
            return
        L_0x0026:
            r4 = move-exception
            goto L_0x0033
        L_0x0028:
            r4 = move-exception
            goto L_0x003f
        L_0x002a:
            r4 = move-exception
            r3 = r0
            goto L_0x0033
        L_0x002d:
            r4 = move-exception
            r3 = r0
            goto L_0x003f
        L_0x0030:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x0033:
            if (r2 == 0) goto L_0x0038
            r2.disconnect()
        L_0x0038:
            r5.m10632b(r1, r0, r0, r3)
            throw r4
        L_0x003c:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r2.disconnect()
        L_0x0044:
            r5.m10632b(r1, r4, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C3087q5.run():void");
    }
}
