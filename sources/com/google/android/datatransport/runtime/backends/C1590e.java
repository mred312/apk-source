package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* renamed from: com.google.android.datatransport.runtime.backends.e */
/* compiled from: MetadataBackendRegistry */
class C1590e implements BackendRegistry {

    /* renamed from: a */
    private final C1591a f7219a;

    /* renamed from: b */
    private final C1589d f7220b;

    /* renamed from: c */
    private final Map<String, TransportBackend> f7221c;

    /* renamed from: com.google.android.datatransport.runtime.backends.e$a */
    /* compiled from: MetadataBackendRegistry */
    static class C1591a {

        /* renamed from: a */
        private final Context f7222a;

        /* renamed from: b */
        private Map<String, String> f7223b = null;

        C1591a(Context context) {
            this.f7222a = context;
        }

        /* renamed from: a */
        private Map<String, String> m5054a(Context context) {
            Bundle d = m5056d(context);
            if (d == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : d.keySet()) {
                Object obj = d.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        /* renamed from: c */
        private Map<String, String> m5055c() {
            if (this.f7223b == null) {
                this.f7223b = m5054a(this.f7222a);
            }
            return this.f7223b;
        }

        /* renamed from: d */
        private static Bundle m5056d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: b */
        public BackendFactory mo11447b(String str) {
            String str2 = m5055c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[]{str2}), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e5);
                return null;
            }
        }
    }

    @Inject
    C1590e(Context context, C1589d dVar) {
        this(new C1591a(context), dVar);
    }

    @Nullable
    public synchronized TransportBackend get(String str) {
        if (this.f7221c.containsKey(str)) {
            return this.f7221c.get(str);
        }
        BackendFactory b = this.f7219a.mo11447b(str);
        if (b == null) {
            return null;
        }
        TransportBackend create = b.create(this.f7220b.mo11446a(str));
        this.f7221c.put(str, create);
        return create;
    }

    C1590e(C1591a aVar, C1589d dVar) {
        this.f7221c = new HashMap();
        this.f7219a = aVar;
        this.f7220b = dVar;
    }
}
