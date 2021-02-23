package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class ComponentDiscovery<T> {

    /* renamed from: a */
    private final T f18909a;

    /* renamed from: b */
    private final C3235c<T> f18910b;

    /* renamed from: com.google.firebase.components.ComponentDiscovery$b */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3234b implements C3235c<Context> {

        /* renamed from: a */
        private final Class<? extends Service> f18911a;

        /* renamed from: b */
        private Bundle m11165b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f18911a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f18911a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        /* renamed from: c */
        public List<String> mo20805a(Context context) {
            Bundle b = m11165b(context);
            if (b == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private C3234b(Class<? extends Service> cls) {
            this.f18911a = cls;
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.firebase.components.ComponentDiscovery$c */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    interface C3235c<T> {
        /* renamed from: a */
        List<String> mo20805a(T t);
    }

    @VisibleForTesting
    ComponentDiscovery(T t, C3235c<T> cVar) {
        this.f18909a = t;
        this.f18910b = cVar;
    }

    /* renamed from: a */
    private static List<ComponentRegistrar> m11164a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                Class<?> cls = Class.forName(next);
                if (!ComponentRegistrar.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{next, "com.google.firebase.components.ComponentRegistrar"}));
                } else {
                    arrayList.add((ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{next}), e);
            } catch (IllegalAccessException e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e2);
            } catch (InstantiationException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e3);
            } catch (NoSuchMethodException e4) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{next}), e4);
            } catch (InvocationTargetException e5) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{next}), e5);
            }
        }
        return arrayList;
    }

    public static ComponentDiscovery<Context> forContext(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new C3234b(cls));
    }

    public List<ComponentRegistrar> discover() {
        return m11164a(this.f18910b.mo20805a(this.f18909a));
    }
}
