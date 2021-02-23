package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.google.firebase.crashlytics.internal.common.p */
/* compiled from: NativeSessionFileGzipper */
class C3332p {
    /* renamed from: a */
    private static void m11463a(@Nullable InputStream inputStream, @NonNull File file) {
        if (inputStream != null) {
            byte[] bArr = new byte[8192];
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            gZIPOutputStream2.write(bArr, 0, read);
                        } else {
                            gZIPOutputStream2.finish();
                            CommonUtils.closeQuietly(gZIPOutputStream2);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        CommonUtils.closeQuietly(gZIPOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.closeQuietly(gZIPOutputStream);
                throw th;
            }
        }
    }

    /* renamed from: b */
    static void m11464b(File file, List<C3331o> list) {
        for (C3331o next : list) {
            InputStream inputStream = null;
            try {
                inputStream = next.mo20951b();
                if (inputStream != null) {
                    m11463a(inputStream, new File(file, next.mo20950a()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                CommonUtils.closeQuietly(inputStream);
                throw th;
            }
            CommonUtils.closeQuietly(inputStream);
        }
    }
}
