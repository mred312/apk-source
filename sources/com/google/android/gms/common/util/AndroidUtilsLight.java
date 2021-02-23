package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class AndroidUtilsLight {
    @TargetApi(24)
    @KeepForSdk
    @Deprecated
    public static Context getDeviceProtectedStorageContext(Context context) {
        return zzm.zza() ? zzm.zza(context) : context;
    }

    @KeepForSdk
    public static byte[] getPackageCertificateHashBytes(Context context, String str) {
        MessageDigest zza;
        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (zza = zza("SHA1")) == null) {
            return null;
        }
        return zza.digest(packageInfo.signatures[0].toByteArray());
    }

    public static MessageDigest zza(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
