package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzdf {

    /* renamed from: a */
    private static volatile zzdy<Boolean> f17623a = zzdy.zzc();

    /* renamed from: b */
    private static final Object f17624b = new Object();

    /* renamed from: a */
    private static boolean m10306a(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zza(Context context, Uri uri) {
        boolean z;
        String authority = uri.getAuthority();
        boolean z2 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        } else if (f17623a.zza()) {
            return f17623a.zzb().booleanValue();
        } else {
            synchronized (f17624b) {
                if (f17623a.zza()) {
                    boolean booleanValue = f17623a.zzb().booleanValue();
                    return booleanValue;
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                    if (resolveContentProvider == null || !"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        z = false;
                        if (z && m10306a(context)) {
                            z2 = true;
                        }
                        f17623a = zzdy.zza(Boolean.valueOf(z2));
                        return f17623a.zzb().booleanValue();
                    }
                }
                z = true;
                z2 = true;
                f17623a = zzdy.zza(Boolean.valueOf(z2));
                return f17623a.zzb().booleanValue();
            }
        }
    }
}
