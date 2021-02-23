package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.C0762a;
import androidx.lifecycle.Lifecycle;

class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: a */
    private final Object f3513a;

    /* renamed from: b */
    private final C0762a.C0763a f3514b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3513a = obj;
        this.f3514b = C0762a.f3557c.mo6282c(obj.getClass());
    }

    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.f3514b.mo6284a(lifecycleOwner, event, this.f3513a);
    }
}
