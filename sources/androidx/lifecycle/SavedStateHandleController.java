package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

final class SavedStateHandleController implements LifecycleEventObserver {

    /* renamed from: a */
    private final String f3524a;

    /* renamed from: b */
    private boolean f3525b = false;

    /* renamed from: c */
    private final SavedStateHandle f3526c;

    /* renamed from: androidx.lifecycle.SavedStateHandleController$a */
    static final class C0755a implements SavedStateRegistry.AutoRecreated {
        C0755a() {
        }

        public void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                for (String a : viewModelStore.mo6279b()) {
                    SavedStateHandleController.m2586g(viewModelStore.mo6278a(a), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                }
                if (!viewModelStore.mo6279b().isEmpty()) {
                    savedStateRegistry.runOnNextRecreation(C0755a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.f3524a = str;
        this.f3526c = savedStateHandle;
    }

    /* renamed from: g */
    static void m2586g(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.mo6274c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.mo6265k()) {
            savedStateHandleController.mo6263h(savedStateRegistry, lifecycle);
            m2588l(savedStateRegistry, lifecycle);
        }
    }

    /* renamed from: i */
    static SavedStateHandleController m2587i(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.m2581a(savedStateRegistry.consumeRestoredStateForKey(str), bundle));
        savedStateHandleController.mo6263h(savedStateRegistry, lifecycle);
        m2588l(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    /* renamed from: l */
    private static void m2588l(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.runOnNextRecreation(C0755a.class);
        } else {
            lifecycle.addObserver(new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.removeObserver(this);
                        savedStateRegistry.runOnNextRecreation(C0755a.class);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6263h(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (!this.f3525b) {
            this.f3525b = true;
            lifecycle.addObserver(this);
            savedStateRegistry.registerSavedStateProvider(this.f3524a, this.f3526c.mo6252c());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public SavedStateHandle mo6264j() {
        return this.f3526c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public boolean mo6265k() {
        return this.f3525b;
    }

    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f3525b = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
