package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ApplicationVersionSignature {

    /* renamed from: a */
    private static final ConcurrentMap<String, Key> f6481a = new ConcurrentHashMap();

    private ApplicationVersionSignature() {
    }

    @Nullable
    /* renamed from: a */
    private static PackageInfo m4755a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    @NonNull
    /* renamed from: b */
    private static String m4756b(@Nullable PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @NonNull
    /* renamed from: c */
    private static Key m4757c(@NonNull Context context) {
        return new ObjectKey(m4756b(m4755a(context)));
    }

    @NonNull
    public static Key obtain(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = f6481a;
        Key key = (Key) concurrentMap.get(packageName);
        if (key != null) {
            return key;
        }
        Key c = m4757c(context);
        Key putIfAbsent = concurrentMap.putIfAbsent(packageName, c);
        return putIfAbsent == null ? c : putIfAbsent;
    }
}
