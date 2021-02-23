package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* renamed from: com.google.android.gms.common.a */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1660a {

    /* renamed from: a */
    private static volatile zzq f7457a;

    /* renamed from: b */
    private static final Object f7458b = new Object();

    /* renamed from: c */
    private static Context f7459c;

    /* renamed from: a */
    static C1676i m5247a(String str, C1663b bVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return m5250d(str, bVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: b */
    static final /* synthetic */ String m5248b(boolean z, String str, C1663b bVar) {
        boolean z2 = true;
        if (z || !m5250d(str, bVar, true, false).f7507a) {
            z2 = false;
        }
        return C1676i.m5274e(str, bVar, z, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m5249c(android.content.Context r2) {
        /*
            java.lang.Class<com.google.android.gms.common.a> r0 = com.google.android.gms.common.C1660a.class
            monitor-enter(r0)
            android.content.Context r1 = f7459c     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0011
            if (r2 == 0) goto L_0x0018
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001a }
            f7459c = r2     // Catch:{ all -> 0x001a }
            monitor-exit(r0)
            return
        L_0x0011:
            java.lang.String r2 = "GoogleCertificates"
            java.lang.String r1 = "GoogleCertificates has been initialized already"
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r0)
            return
        L_0x001a:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.C1660a.m5249c(android.content.Context):void");
    }

    /* renamed from: d */
    private static C1676i m5250d(String str, C1663b bVar, boolean z, boolean z2) {
        try {
            if (f7457a == null) {
                Preconditions.checkNotNull(f7459c);
                synchronized (f7458b) {
                    if (f7457a == null) {
                        f7457a = zzp.zza(DynamiteModule.load(f7459c, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            Preconditions.checkNotNull(f7459c);
            try {
                if (f7457a.zza(new zzj(str, bVar, z, z2), ObjectWrapper.wrap(f7459c.getPackageManager()))) {
                    return C1676i.m5270a();
                }
                return C1676i.m5273d(new C1664c(z, str, bVar));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return C1676i.m5272c("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            return C1676i.m5272c(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
        }
    }
}
