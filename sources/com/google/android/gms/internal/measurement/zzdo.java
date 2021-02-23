package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzdo implements C2713a1 {
    @GuardedBy("SharedPreferencesLoader.class")

    /* renamed from: f */
    private static final Map<String, zzdo> f17638f = new ArrayMap();

    /* renamed from: a */
    private final SharedPreferences f17639a;

    /* renamed from: b */
    private final SharedPreferences.OnSharedPreferenceChangeListener f17640b;

    /* renamed from: c */
    private final Object f17641c = new Object();

    /* renamed from: d */
    private volatile Map<String, ?> f17642d;
    @GuardedBy("this")

    /* renamed from: e */
    private final List<zzcu> f17643e = new ArrayList();

    private zzdo(SharedPreferences sharedPreferences) {
        C2805l1 l1Var = new C2805l1(this);
        this.f17640b = l1Var;
        this.f17639a = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(l1Var);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzdo, java.lang.Object, java.lang.String] */
    /* renamed from: a */
    static zzdo m10320a(Context context, String str) {
        zzdo zzdo;
        ? r0 = 0;
        if (!((!zzcr.zza() || r0.startsWith("direct_boot:")) ? true : zzcr.zza(context))) {
            return r0;
        }
        synchronized (zzdo.class) {
            Map<String, zzdo> map = f17638f;
            zzdo = map.get(r0);
            if (zzdo == null) {
                zzdo = new zzdo(m10322d(context, r0));
                map.put(r0, zzdo);
            }
        }
        return zzdo;
    }

    /* renamed from: b */
    static synchronized void m10321b() {
        synchronized (zzdo.class) {
            for (zzdo next : f17638f.values()) {
                next.f17639a.unregisterOnSharedPreferenceChangeListener(next.f17640b);
            }
            f17638f.clear();
        }
    }

    /* renamed from: d */
    private static SharedPreferences m10322d(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzcr.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo19409c(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f17641c) {
            this.f17642d = null;
            zzdh.m10312g();
        }
        synchronized (this) {
            for (zzcu zza : this.f17643e) {
                zza.zza();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final Object zza(String str) {
        Map<String, ?> map = this.f17642d;
        if (map == null) {
            synchronized (this.f17641c) {
                map = this.f17642d;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f17639a.getAll();
                        this.f17642d = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
