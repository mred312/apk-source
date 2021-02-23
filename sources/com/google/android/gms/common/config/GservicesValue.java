package com.google.android.gms.common.config;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public abstract class GservicesValue<T> {

    /* renamed from: b */
    private static final Object f7500b = new Object();

    /* renamed from: a */
    private T f7501a = null;
    protected final String zza;
    protected final T zzb;

    /* renamed from: com.google.android.gms.common.config.GservicesValue$a */
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    private interface C1665a {
        /* renamed from: a */
        Boolean mo12871a(String str, Boolean bool);

        /* renamed from: b */
        Integer mo12872b(String str, Integer num);

        /* renamed from: c */
        Float mo12873c(String str, Float f);

        /* renamed from: d */
        Long mo12874d(String str, Long l);

        String zza(String str, String str2);
    }

    protected GservicesValue(String str, T t) {
        this.zza = str;
        this.zzb = t;
    }

    /* renamed from: a */
    private static boolean m5260a() {
        synchronized (f7500b) {
        }
        return false;
    }

    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (f7500b) {
        }
        return false;
    }

    @KeepForSdk
    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new C1667b(str, Boolean.valueOf(z));
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 139 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = zza(r4.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0030, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0031, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0034, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001b */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
            r4 = this;
            T r0 = r4.f7501a
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()
            java.lang.Object r1 = f7500b
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r4.zza     // Catch:{ SecurityException -> 0x001b }
            java.lang.Object r1 = r4.zza(r1)     // Catch:{ SecurityException -> 0x001b }
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x0019:
            r1 = move-exception
            goto L_0x0031
        L_0x001b:
            long r1 = android.os.Binder.clearCallingIdentity()     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = r4.zza     // Catch:{ all -> 0x002c }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x002c }
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x0019 }
            android.os.StrictMode.setThreadPolicy(r0)
            return r3
        L_0x002c:
            r3 = move-exception
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x0019 }
            throw r3     // Catch:{ all -> 0x0019 }
        L_0x0031:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r1
        L_0x0035:
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            throw r0
        L_0x0037:
            r0 = move-exception
            goto L_0x0035
        L_0x0039:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x003c:
            throw r0
        L_0x003d:
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.get():java.lang.Object");
    }

    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @KeepForSdk
    @VisibleForTesting
    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.f7501a = t;
        synchronized (f7500b) {
            m5260a();
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public void resetOverride() {
        this.f7501a = null;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(String str);

    @KeepForSdk
    public static GservicesValue<Long> value(String str, Long l) {
        return new C1666a(str, l);
    }

    @KeepForSdk
    public static GservicesValue<Integer> value(String str, Integer num) {
        return new C1669d(str, num);
    }

    @KeepForSdk
    public static GservicesValue<Float> value(String str, Float f) {
        return new C1668c(str, f);
    }

    @KeepForSdk
    public static GservicesValue<String> value(String str, String str2) {
        return new C1670e(str, str2);
    }
}
