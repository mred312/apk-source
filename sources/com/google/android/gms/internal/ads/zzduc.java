package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzduc {
    public static File zza(String str, String str2, @NonNull File file) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new File(zza(str, file), str2);
    }

    public static boolean zze(@NonNull File file) {
        boolean z;
        if (!file.exists()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            z = true;
            for (int i = 0; i < length; i++) {
                File file2 = listFiles[i];
                z = file2 != null && zze(file2) && z;
            }
        } else {
            z = true;
        }
        if (!file.delete() || !z) {
            return false;
        }
        return true;
    }

    public static byte[] zzf(@NonNull File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] byteArray = zzeiu.zzg(fileInputStream).toByteArray();
                IOUtils.closeQuietly((Closeable) fileInputStream);
                return byteArray;
            } catch (IOException unused) {
                IOUtils.closeQuietly((Closeable) fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                IOUtils.closeQuietly((Closeable) fileInputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
            IOUtils.closeQuietly((Closeable) fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((Closeable) fileInputStream2);
            throw th;
        }
    }

    public static boolean zza(@NonNull File file, @NonNull byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                IOUtils.closeQuietly((Closeable) fileOutputStream2);
                return true;
            } catch (IOException unused) {
                fileOutputStream = fileOutputStream2;
                IOUtils.closeQuietly((Closeable) fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                IOUtils.closeQuietly((Closeable) fileOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
            IOUtils.closeQuietly((Closeable) fileOutputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((Closeable) fileOutputStream);
            throw th;
        }
    }

    public static File zza(String str, @NonNull File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return zza(new File(file, str), false);
    }

    public static File zza(@NonNull File file, boolean z) {
        if (z && file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
