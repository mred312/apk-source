package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* renamed from: androidx.fragment.app.l */
/* compiled from: FragmentViewLifecycleOwner */
class C0712l implements SavedStateRegistryOwner {

    /* renamed from: a */
    private LifecycleRegistry f3395a = null;

    /* renamed from: b */
    private SavedStateRegistryController f3396b = null;

    C0712l() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6133a(@NonNull Lifecycle.Event event) {
        this.f3395a.handleLifecycleEvent(event);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6134b() {
        if (this.f3395a == null) {
            this.f3395a = new LifecycleRegistry(this);
            this.f3396b = SavedStateRegistryController.create(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6135c() {
        return this.f3395a != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6136d(@Nullable Bundle bundle) {
        this.f3396b.performRestore(bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6137e(@NonNull Bundle bundle) {
        this.f3396b.performSave(bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6138f(@NonNull Lifecycle.State state) {
        this.f3395a.setCurrentState(state);
    }

    @NonNull
    public Lifecycle getLifecycle() {
        mo6134b();
        return this.f3395a;
    }

    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f3396b.getSavedStateRegistry();
    }
}
