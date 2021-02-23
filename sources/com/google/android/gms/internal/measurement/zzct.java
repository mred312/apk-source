package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzct implements C2713a1 {
    @GuardedBy("ConfigurationContentLoader.class")

    /* renamed from: g */
    private static final Map<Uri, zzct> f17613g = new ArrayMap();

    /* renamed from: h */
    private static final String[] f17614h = {"key", "value"};

    /* renamed from: a */
    private final ContentResolver f17615a;

    /* renamed from: b */
    private final Uri f17616b;

    /* renamed from: c */
    private final ContentObserver f17617c;

    /* renamed from: d */
    private final Object f17618d = new Object();

    /* renamed from: e */
    private volatile Map<String, String> f17619e;
    @GuardedBy("this")

    /* renamed from: f */
    private final List<zzcu> f17620f = new ArrayList();

    private zzct(ContentResolver contentResolver, Uri uri) {
        C2913z0 z0Var = new C2913z0(this, (Handler) null);
        this.f17617c = z0Var;
        zzeb.zza(contentResolver);
        zzeb.zza(uri);
        this.f17615a = contentResolver;
        this.f17616b = uri;
        contentResolver.registerContentObserver(uri, false, z0Var);
    }

    /* renamed from: a */
    static synchronized void m10301a() {
        synchronized (zzct.class) {
            for (zzct next : f17613g.values()) {
                next.f17615a.unregisterContentObserver(next.f17617c);
            }
            f17613g.clear();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    private final Map<String, String> m10302c() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) zzcw.zza(new C2906y0(this));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzct zza(android.content.ContentResolver r4, android.net.Uri r5) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzct> r0 = com.google.android.gms.internal.measurement.zzct.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, com.google.android.gms.internal.measurement.zzct> r1 = f17613g     // Catch:{ all -> 0x0018 }
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.measurement.zzct r2 = (com.google.android.gms.internal.measurement.zzct) r2     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x0016
            com.google.android.gms.internal.measurement.zzct r3 = new com.google.android.gms.internal.measurement.zzct     // Catch:{ SecurityException -> 0x0016 }
            r3.<init>(r4, r5)     // Catch:{ SecurityException -> 0x0016 }
            r1.put(r5, r3)     // Catch:{ SecurityException -> 0x0015 }
        L_0x0015:
            r2 = r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return r2
        L_0x0018:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzct.zza(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.measurement.zzct");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ Map mo19397b() {
        Map map;
        Cursor query = this.f17615a.query(this.f17616b, f17614h, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }

    public final void zzb() {
        synchronized (this.f17618d) {
            this.f17619e = null;
            zzdh.m10312g();
        }
        synchronized (this) {
            for (zzcu zza : this.f17620f) {
                zza.zza();
            }
        }
    }

    public final Map<String, String> zza() {
        Map<String, String> map = this.f17619e;
        if (map == null) {
            synchronized (this.f17618d) {
                map = this.f17619e;
                if (map == null) {
                    map = m10302c();
                    this.f17619e = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }
}
