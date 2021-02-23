package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@ShowFirstParty
@CheckReturnValue
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class GoogleSignatureVerifier {
    @Nullable

    /* renamed from: c */
    private static GoogleSignatureVerifier f7453c;

    /* renamed from: a */
    private final Context f7454a;

    /* renamed from: b */
    private volatile String f7455b;

    private GoogleSignatureVerifier(Context context) {
        this.f7454a = context.getApplicationContext();
    }

    @Nullable
    /* renamed from: a */
    private static C1663b m5244a(PackageInfo packageInfo, C1663b... bVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C1672e eVar = new C1672e(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].equals(eVar)) {
                return bVarArr[i];
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1 = r1.applicationInfo;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.C1676i m5245b(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "null pkg"
            if (r8 != 0) goto L_0x0009
            com.google.android.gms.common.i r8 = com.google.android.gms.common.C1676i.m5271b(r0)
            return r8
        L_0x0009:
            java.lang.String r1 = r7.f7455b
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0016
            com.google.android.gms.common.i r8 = com.google.android.gms.common.C1676i.m5270a()
            return r8
        L_0x0016:
            android.content.Context r1 = r7.f7454a     // Catch:{ NameNotFoundException -> 0x0078 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)     // Catch:{ NameNotFoundException -> 0x0078 }
            r2 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r8, r2)     // Catch:{ NameNotFoundException -> 0x0078 }
            android.content.Context r2 = r7.f7454a
            boolean r2 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r2)
            if (r1 != 0) goto L_0x002f
            com.google.android.gms.common.i r0 = com.google.android.gms.common.C1676i.m5271b(r0)
            goto L_0x0071
        L_0x002f:
            android.content.pm.Signature[] r0 = r1.signatures
            if (r0 == 0) goto L_0x006b
            int r0 = r0.length
            r3 = 1
            if (r0 == r3) goto L_0x0038
            goto L_0x006b
        L_0x0038:
            com.google.android.gms.common.e r0 = new com.google.android.gms.common.e
            android.content.pm.Signature[] r4 = r1.signatures
            r5 = 0
            r4 = r4[r5]
            byte[] r4 = r4.toByteArray()
            r0.<init>(r4)
            java.lang.String r4 = r1.packageName
            com.google.android.gms.common.i r2 = com.google.android.gms.common.C1660a.m5247a(r4, r0, r2, r5)
            boolean r6 = r2.f7507a
            if (r6 == 0) goto L_0x0069
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo
            if (r1 == 0) goto L_0x0069
            int r1 = r1.flags
            r1 = r1 & 2
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.common.i r0 = com.google.android.gms.common.C1660a.m5247a(r4, r0, r5, r3)
            boolean r0 = r0.f7507a
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = "debuggable release cert app rejected"
            com.google.android.gms.common.i r0 = com.google.android.gms.common.C1676i.m5271b(r0)
            goto L_0x0071
        L_0x0069:
            r0 = r2
            goto L_0x0071
        L_0x006b:
            java.lang.String r0 = "single cert required"
            com.google.android.gms.common.i r0 = com.google.android.gms.common.C1676i.m5271b(r0)
        L_0x0071:
            boolean r1 = r0.f7507a
            if (r1 == 0) goto L_0x0077
            r7.f7455b = r8
        L_0x0077:
            return r0
        L_0x0078:
            java.lang.String r0 = "no pkg "
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x008a
            java.lang.String r8 = r0.concat(r8)
            goto L_0x008f
        L_0x008a:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r0)
        L_0x008f:
            com.google.android.gms.common.i r8 = com.google.android.gms.common.C1676i.m5271b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.m5245b(java.lang.String):com.google.android.gms.common.i");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r8 = r8.applicationInfo;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.C1676i m5246c(java.lang.String r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f7454a     // Catch:{ NameNotFoundException -> 0x005d }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x005d }
            r1 = 64
            android.content.pm.PackageInfo r8 = r0.zza(r7, r1, r8)     // Catch:{ NameNotFoundException -> 0x005d }
            android.content.Context r0 = r6.f7454a     // Catch:{ NameNotFoundException -> 0x005d }
            boolean r0 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r0)     // Catch:{ NameNotFoundException -> 0x005d }
            if (r8 != 0) goto L_0x001b
            java.lang.String r8 = "null pkg"
            com.google.android.gms.common.i r7 = com.google.android.gms.common.C1676i.m5271b(r8)     // Catch:{ NameNotFoundException -> 0x005d }
            return r7
        L_0x001b:
            android.content.pm.Signature[] r1 = r8.signatures     // Catch:{ NameNotFoundException -> 0x005d }
            if (r1 == 0) goto L_0x0056
            int r1 = r1.length     // Catch:{ NameNotFoundException -> 0x005d }
            r2 = 1
            if (r1 == r2) goto L_0x0024
            goto L_0x0056
        L_0x0024:
            com.google.android.gms.common.e r1 = new com.google.android.gms.common.e     // Catch:{ NameNotFoundException -> 0x005d }
            android.content.pm.Signature[] r3 = r8.signatures     // Catch:{ NameNotFoundException -> 0x005d }
            r4 = 0
            r3 = r3[r4]     // Catch:{ NameNotFoundException -> 0x005d }
            byte[] r3 = r3.toByteArray()     // Catch:{ NameNotFoundException -> 0x005d }
            r1.<init>(r3)     // Catch:{ NameNotFoundException -> 0x005d }
            java.lang.String r3 = r8.packageName     // Catch:{ NameNotFoundException -> 0x005d }
            com.google.android.gms.common.i r0 = com.google.android.gms.common.C1660a.m5247a(r3, r1, r0, r4)     // Catch:{ NameNotFoundException -> 0x005d }
            boolean r5 = r0.f7507a     // Catch:{ NameNotFoundException -> 0x005d }
            if (r5 == 0) goto L_0x0055
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo     // Catch:{ NameNotFoundException -> 0x005d }
            if (r8 == 0) goto L_0x0055
            int r8 = r8.flags     // Catch:{ NameNotFoundException -> 0x005d }
            r8 = r8 & 2
            if (r8 == 0) goto L_0x0055
            com.google.android.gms.common.i r8 = com.google.android.gms.common.C1660a.m5247a(r3, r1, r4, r2)     // Catch:{ NameNotFoundException -> 0x005d }
            boolean r8 = r8.f7507a     // Catch:{ NameNotFoundException -> 0x005d }
            if (r8 == 0) goto L_0x0055
            java.lang.String r8 = "debuggable release cert app rejected"
            com.google.android.gms.common.i r7 = com.google.android.gms.common.C1676i.m5271b(r8)     // Catch:{ NameNotFoundException -> 0x005d }
            return r7
        L_0x0055:
            return r0
        L_0x0056:
            java.lang.String r8 = "single cert required"
            com.google.android.gms.common.i r7 = com.google.android.gms.common.C1676i.m5271b(r8)     // Catch:{ NameNotFoundException -> 0x005d }
            return r7
        L_0x005d:
            java.lang.String r8 = "no pkg "
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r0 = r7.length()
            if (r0 == 0) goto L_0x006f
            java.lang.String r7 = r8.concat(r7)
            goto L_0x0074
        L_0x006f:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r8)
        L_0x0074:
            com.google.android.gms.common.i r7 = com.google.android.gms.common.C1676i.m5271b(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.m5246c(java.lang.String, int):com.google.android.gms.common.i");
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (f7453c == null) {
                C1660a.m5249c(context);
                f7453c = new GoogleSignatureVerifier(context);
            }
        }
        return f7453c;
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        C1663b bVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                bVar = m5244a(packageInfo, C1674g.f7505a);
            } else {
                bVar = m5244a(packageInfo, C1674g.f7505a[0]);
            }
            if (bVar != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f7454a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        C1676i b = m5245b(str);
        b.mo12878g();
        return b.f7507a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.google.android.gms.common.i} */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isUidGoogleSigned(int r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.f7454a
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)
            java.lang.String[] r0 = r0.zza(r6)
            if (r0 == 0) goto L_0x002b
            int r1 = r0.length
            if (r1 != 0) goto L_0x0010
            goto L_0x002b
        L_0x0010:
            r1 = 0
            int r2 = r0.length
            r3 = 0
        L_0x0013:
            if (r3 >= r2) goto L_0x0023
            r1 = r0[r3]
            com.google.android.gms.common.i r1 = r5.m5246c(r1, r6)
            boolean r4 = r1.f7507a
            if (r4 == 0) goto L_0x0020
            goto L_0x0031
        L_0x0020:
            int r3 = r3 + 1
            goto L_0x0013
        L_0x0023:
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            r1 = r6
            com.google.android.gms.common.i r1 = (com.google.android.gms.common.C1676i) r1
            goto L_0x0031
        L_0x002b:
            java.lang.String r6 = "no pkgs"
            com.google.android.gms.common.i r1 = com.google.android.gms.common.C1676i.m5271b(r6)
        L_0x0031:
            r1.mo12878g()
            boolean r6 = r1.f7507a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.isUidGoogleSigned(int):boolean");
    }
}
