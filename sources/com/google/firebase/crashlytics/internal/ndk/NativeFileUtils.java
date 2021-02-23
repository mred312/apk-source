package com.google.firebase.crashlytics.internal.ndk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public final class NativeFileUtils {
    private NativeFileUtils() {
    }

    @NonNull
    public static byte[] binaryImagesJsonFromMapsFile(@Nullable File file, @NonNull Context context) {
        if (file == null || !file.exists()) {
            return new byte[0];
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            try {
                byte[] a = new C3434a(context, new C3438d()).mo21393a(bufferedReader2);
                CommonUtils.closeQuietly(bufferedReader2);
                return a;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                CommonUtils.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }
}
