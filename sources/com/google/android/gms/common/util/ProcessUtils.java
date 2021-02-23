package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class ProcessUtils {

    /* renamed from: a */
    private static String f7628a;

    /* renamed from: b */
    private static int f7629b;

    private ProcessUtils() {
    }

    /* renamed from: a */
    private static BufferedReader m5346a(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @Nullable
    /* renamed from: b */
    private static String m5347b(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = m5346a(sb.toString());
            try {
                str = bufferedReader.readLine().trim();
                IOUtils.closeQuietly((Closeable) bufferedReader);
            } catch (IOException unused) {
                IOUtils.closeQuietly((Closeable) bufferedReader);
                return str;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Closeable) bufferedReader);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
            IOUtils.closeQuietly((Closeable) bufferedReader);
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            IOUtils.closeQuietly((Closeable) bufferedReader);
            throw th;
        }
        return str;
    }

    @KeepForSdk
    @Nullable
    public static String getMyProcessName() {
        if (f7628a == null) {
            if (f7629b == 0) {
                f7629b = Process.myPid();
            }
            f7628a = m5347b(f7629b);
        }
        return f7628a;
    }
}
