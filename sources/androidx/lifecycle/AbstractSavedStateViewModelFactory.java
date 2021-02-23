package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.C0760a {

    /* renamed from: a */
    private final SavedStateRegistry f3456a;

    /* renamed from: b */
    private final Lifecycle f3457b;

    /* renamed from: c */
    private final Bundle f3458c;

    public AbstractSavedStateViewModelFactory(@NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        this.f3456a = savedStateRegistryOwner.getSavedStateRegistry();
        this.f3457b = savedStateRegistryOwner.getLifecycle();
        this.f3458c = bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6180a(@NonNull ViewModel viewModel) {
        SavedStateHandleController.m2586g(viewModel, this.f3456a, this.f3457b);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        SavedStateHandleController i = SavedStateHandleController.m2587i(this.f3456a, this.f3457b, str, this.f3458c);
        T create = create(str, cls, i.mo6264j());
        create.mo6275d("androidx.lifecycle.savedstate.vm.tag", i);
        return create;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls, @NonNull SavedStateHandle savedStateHandle);

    @NonNull
    public final <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
