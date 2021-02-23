package com.google.firebase.crashlytics.internal.ndk;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.ndk.C3434a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* renamed from: com.google.firebase.crashlytics.internal.ndk.d */
/* compiled from: Sha1FileIdStrategy */
class C3438d implements C3434a.C3435a {
    C3438d() {
    }

    /* renamed from: b */
    private static String m11608b(String str) {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                String sha1 = CommonUtils.sha1((InputStream) bufferedInputStream2);
                CommonUtils.closeQuietly(bufferedInputStream2);
                return sha1;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                CommonUtils.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public String mo21394a(File file) {
        return m11608b(file.getPath());
    }
}
