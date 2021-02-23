package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

public class ServiceLifecycleDispatcher {

    /* renamed from: a */
    private final LifecycleRegistry f3536a;

    /* renamed from: b */
    private final Handler f3537b = new Handler();

    /* renamed from: c */
    private C0756a f3538c;

    /* renamed from: androidx.lifecycle.ServiceLifecycleDispatcher$a */
    static class C0756a implements Runnable {

        /* renamed from: a */
        private final LifecycleRegistry f3539a;

        /* renamed from: b */
        final Lifecycle.Event f3540b;

        /* renamed from: c */
        private boolean f3541c = false;

        C0756a(@NonNull LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.f3539a = lifecycleRegistry;
            this.f3540b = event;
        }

        public void run() {
            if (!this.f3541c) {
                this.f3539a.handleLifecycleEvent(this.f3540b);
                this.f3541c = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@NonNull LifecycleOwner lifecycleOwner) {
        this.f3536a = new LifecycleRegistry(lifecycleOwner);
    }

    /* renamed from: a */
    private void m2594a(Lifecycle.Event event) {
        C0756a aVar = this.f3538c;
        if (aVar != null) {
            aVar.run();
        }
        C0756a aVar2 = new C0756a(this.f3536a, event);
        this.f3538c = aVar2;
        this.f3537b.postAtFrontOfQueue(aVar2);
    }

    public Lifecycle getLifecycle() {
        return this.f3536a;
    }

    public void onServicePreSuperOnBind() {
        m2594a(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        m2594a(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        m2594a(Lifecycle.Event.ON_STOP);
        m2594a(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        m2594a(Lifecycle.Event.ON_START);
    }
}
