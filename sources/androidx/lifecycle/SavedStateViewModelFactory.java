package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class SavedStateViewModelFactory extends ViewModelProvider.C0760a {

    /* renamed from: f */
    private static final Class<?>[] f3529f;

    /* renamed from: g */
    private static final Class<?>[] f3530g;

    /* renamed from: a */
    private final Application f3531a;

    /* renamed from: b */
    private final ViewModelProvider.Factory f3532b;

    /* renamed from: c */
    private final Bundle f3533c;

    /* renamed from: d */
    private final Lifecycle f3534d;

    /* renamed from: e */
    private final SavedStateRegistry f3535e;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Class<?>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.lifecycle.SavedStateHandle> r0 = androidx.lifecycle.SavedStateHandle.class
            r1 = 2
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.app.Application> r2 = android.app.Application.class
            r3 = 0
            r1[r3] = r2
            r2 = 1
            r1[r2] = r0
            f3529f = r1
            java.lang.Class[] r1 = new java.lang.Class[r2]
            r1[r3] = r0
            f3530g = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.SavedStateViewModelFactory.<clinit>():void");
    }

    public SavedStateViewModelFactory(@Nullable Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, (Bundle) null);
    }

    /* renamed from: b */
    private static <T> Constructor<T> m2592b(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<T> constructor : cls.getConstructors()) {
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6180a(@NonNull ViewModel viewModel) {
        SavedStateHandleController.m2586g(viewModel, this.f3535e, this.f3534d);
    }

    @NonNull
    public <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        Constructor<T> constructor;
        T t;
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        if (!isAssignableFrom || this.f3531a == null) {
            constructor = m2592b(cls, f3530g);
        } else {
            constructor = m2592b(cls, f3529f);
        }
        if (constructor == null) {
            return this.f3532b.create(cls);
        }
        SavedStateHandleController i = SavedStateHandleController.m2587i(this.f3535e, this.f3534d, str, this.f3533c);
        if (isAssignableFrom) {
            try {
                Application application = this.f3531a;
                if (application != null) {
                    t = (ViewModel) constructor.newInstance(new Object[]{application, i.mo6264j()});
                    t.mo6275d("androidx.lifecycle.savedstate.vm.tag", i);
                    return t;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to access " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
            }
        }
        t = (ViewModel) constructor.newInstance(new Object[]{i.mo6264j()});
        t.mo6275d("androidx.lifecycle.savedstate.vm.tag", i);
        return t;
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@Nullable Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        ViewModelProvider.Factory factory;
        this.f3535e = savedStateRegistryOwner.getSavedStateRegistry();
        this.f3534d = savedStateRegistryOwner.getLifecycle();
        this.f3533c = bundle;
        this.f3531a = application;
        if (application != null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        } else {
            factory = ViewModelProvider.NewInstanceFactory.m2599a();
        }
        this.f3532b = factory;
    }

    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
