package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    /* renamed from: a */
    private final GeneratedAdapter f3542a;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.f3542a = generatedAdapter;
    }

    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.f3542a.callMethods(lifecycleOwner, event, false, (MethodCallsLogger) null);
        this.f3542a.callMethods(lifecycleOwner, event, true, (MethodCallsLogger) null);
    }
}
