package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* renamed from: a */
    private SafeIterableMap<String, SavedStateProvider> f4612a = new SafeIterableMap<>();
    @Nullable

    /* renamed from: b */
    private Bundle f4613b;

    /* renamed from: c */
    private boolean f4614c;

    /* renamed from: d */
    private Recreator.C0992a f4615d;

    /* renamed from: e */
    boolean f4616e = true;

    public interface AutoRecreated {
        void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        @NonNull
        Bundle saveState();
    }

    SavedStateRegistry() {
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: a */
    public void mo7935a(@NonNull Lifecycle lifecycle, @Nullable Bundle bundle) {
        if (!this.f4614c) {
            if (bundle != null) {
                this.f4613b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            lifecycle.addObserver(new GenericLifecycleObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        SavedStateRegistry.this.f4616e = true;
                    } else if (event == Lifecycle.Event.ON_STOP) {
                        SavedStateRegistry.this.f4616e = false;
                    }
                }
            });
            this.f4614c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: b */
    public void mo7936b(@NonNull Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4613b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<K, V>.d iteratorWithAdditions = this.f4612a.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).saveState());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    @MainThread
    @Nullable
    public Bundle consumeRestoredStateForKey(@NonNull String str) {
        if (this.f4614c) {
            Bundle bundle = this.f4613b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f4613b.remove(str);
            if (this.f4613b.isEmpty()) {
                this.f4613b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    @MainThread
    public boolean isRestored() {
        return this.f4614c;
    }

    @MainThread
    public void registerSavedStateProvider(@NonNull String str, @NonNull SavedStateProvider savedStateProvider) {
        if (this.f4612a.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public void runOnNextRecreation(@NonNull Class<? extends AutoRecreated> cls) {
        if (this.f4616e) {
            if (this.f4615d == null) {
                this.f4615d = new Recreator.C0992a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f4615d.mo7934a(cls.getName());
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    @MainThread
    public void unregisterSavedStateProvider(@NonNull String str) {
        this.f4612a.remove(str);
    }
}
