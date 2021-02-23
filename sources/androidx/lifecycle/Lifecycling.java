package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class Lifecycling {

    /* renamed from: a */
    private static Map<Class<?>, Integer> f3487a = new HashMap();

    /* renamed from: b */
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> f3488b = new HashMap();

    /* renamed from: androidx.lifecycle.Lifecycling$1 */
    class C07451 implements GenericLifecycleObserver {

        /* renamed from: a */
        final /* synthetic */ LifecycleEventObserver f3489a;

        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            this.f3489a.onStateChanged(lifecycleOwner, event);
        }
    }

    private Lifecycling() {
    }

    /* renamed from: a */
    private static GeneratedAdapter m2554a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Nullable
    /* renamed from: b */
    private static Constructor<? extends GeneratedAdapter> m2555b(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String adapterName = getAdapterName(canonicalName);
            if (!name.isEmpty()) {
                adapterName = name + "." + adapterName;
            }
            Constructor<?> declaredConstructor = Class.forName(adapterName).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private static int m2556c(Class<?> cls) {
        Integer num = f3487a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int f = m2559f(cls);
        f3487a.put(cls, Integer.valueOf(f));
        return f;
    }

    /* renamed from: d */
    private static boolean m2557d(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    @NonNull
    /* renamed from: e */
    static LifecycleEventObserver m2558e(Object obj) {
        boolean z = obj instanceof LifecycleEventObserver;
        boolean z2 = obj instanceof C0765b;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((C0765b) obj, (LifecycleEventObserver) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((C0765b) obj, (LifecycleEventObserver) null);
        }
        if (z) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m2556c(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f3488b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m2554a((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        for (int i = 0; i < list.size(); i++) {
            generatedAdapterArr[i] = m2554a((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    /* renamed from: f */
    private static int m2559f(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> b = m2555b(cls);
        if (b != null) {
            f3488b.put(cls, Collections.singletonList(b));
            return 2;
        } else if (C0762a.f3557c.mo6283d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (m2557d(superclass)) {
                if (m2556c(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f3488b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (m2557d(cls2)) {
                    if (m2556c(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f3488b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f3488b.put(cls, arrayList);
            return 2;
        }
    }

    public static String getAdapterName(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
