package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider {

    /* renamed from: a */
    private final Factory f3551a;

    /* renamed from: b */
    private final ViewModelStore f3552b;

    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* renamed from: c */
        private static AndroidViewModelFactory f3553c;

        /* renamed from: b */
        private Application f3554b;

        public AndroidViewModelFactory(@NonNull Application application) {
            this.f3554b = application;
        }

        @NonNull
        public static AndroidViewModelFactory getInstance(@NonNull Application application) {
            if (f3553c == null) {
                f3553c = new AndroidViewModelFactory(application);
            }
            return f3553c;
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f3554b});
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    public static class NewInstanceFactory implements Factory {

        /* renamed from: a */
        private static NewInstanceFactory f3555a;

        @NonNull
        /* renamed from: a */
        static NewInstanceFactory m2599a() {
            if (f3555a == null) {
                f3555a = new NewInstanceFactory();
            }
            return f3555a;
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            try {
                return (ViewModel) cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    /* renamed from: androidx.lifecycle.ViewModelProvider$a */
    static abstract class C0760a extends C0761b implements Factory {
        C0760a() {
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @NonNull
        public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls);
    }

    /* renamed from: androidx.lifecycle.ViewModelProvider$b */
    static class C0761b {
        C0761b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6180a(@NonNull ViewModel viewModel) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewModelProvider(@androidx.annotation.NonNull androidx.lifecycle.ViewModelStoreOwner r3) {
        /*
            r2 = this;
            androidx.lifecycle.ViewModelStore r0 = r3.getViewModelStore()
            boolean r1 = r3 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r1 == 0) goto L_0x000f
            androidx.lifecycle.HasDefaultViewModelProviderFactory r3 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r3
            androidx.lifecycle.ViewModelProvider$Factory r3 = r3.getDefaultViewModelProviderFactory()
            goto L_0x0013
        L_0x000f:
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = androidx.lifecycle.ViewModelProvider.NewInstanceFactory.m2599a()
        L_0x0013:
            r2.<init>((androidx.lifecycle.ViewModelStore) r0, (androidx.lifecycle.ViewModelProvider.Factory) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    @MainThread
    @NonNull
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @MainThread
    @NonNull
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t;
        T a = this.f3552b.mo6278a(str);
        if (cls.isInstance(a)) {
            Factory factory = this.f3551a;
            if (factory instanceof C0761b) {
                ((C0761b) factory).mo6180a(a);
            }
            return a;
        }
        Factory factory2 = this.f3551a;
        if (factory2 instanceof C0760a) {
            t = ((C0760a) factory2).create(str, cls);
        } else {
            t = factory2.create(cls);
        }
        this.f3552b.mo6280c(str, t);
        return t;
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.f3551a = factory;
        this.f3552b = viewModelStore;
    }
}
