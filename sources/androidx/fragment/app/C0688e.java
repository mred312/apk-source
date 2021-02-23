package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.fragment.app.e */
/* compiled from: FragmentLifecycleCallbacksDispatcher */
class C0688e {
    @NonNull

    /* renamed from: a */
    private final CopyOnWriteArrayList<C0689a> f3315a = new CopyOnWriteArrayList<>();
    @NonNull

    /* renamed from: b */
    private final FragmentManager f3316b;

    /* renamed from: androidx.fragment.app.e$a */
    /* compiled from: FragmentLifecycleCallbacksDispatcher */
    private static final class C0689a {
        @NonNull

        /* renamed from: a */
        final FragmentManager.FragmentLifecycleCallbacks f3317a;

        /* renamed from: b */
        final boolean f3318b;

        C0689a(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.f3317a = fragmentLifecycleCallbacks;
            this.f3318b = z;
        }
    }

    C0688e(@NonNull FragmentManager fragmentManager) {
        this.f3316b = fragmentManager;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6030a(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6030a(fragment, bundle, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentActivityCreated(this.f3316b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6031b(@NonNull Fragment fragment, boolean z) {
        Context b = this.f3316b.mo5777n0().mo5697b();
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6031b(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentAttached(this.f3316b, fragment, b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6032c(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6032c(fragment, bundle, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentCreated(this.f3316b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6033d(@NonNull Fragment fragment, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6033d(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentDestroyed(this.f3316b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6034e(@NonNull Fragment fragment, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6034e(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentDetached(this.f3316b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6035f(@NonNull Fragment fragment, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6035f(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentPaused(this.f3316b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6036g(@NonNull Fragment fragment, boolean z) {
        Context b = this.f3316b.mo5777n0().mo5697b();
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6036g(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentPreAttached(this.f3316b, fragment, b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6037h(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6037h(fragment, bundle, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentPreCreated(this.f3316b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo6038i(@NonNull Fragment fragment, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6038i(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentResumed(this.f3316b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo6039j(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6039j(fragment, bundle, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentSaveInstanceState(this.f3316b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo6040k(@NonNull Fragment fragment, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6040k(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentStarted(this.f3316b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo6041l(@NonNull Fragment fragment, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6041l(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentStopped(this.f3316b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo6042m(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6042m(fragment, view, bundle, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentViewCreated(this.f3316b, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo6043n(@NonNull Fragment fragment, boolean z) {
        Fragment q0 = this.f3316b.mo5788q0();
        if (q0 != null) {
            q0.getParentFragmentManager().mo5780p0().mo6043n(fragment, true);
        }
        Iterator<C0689a> it = this.f3315a.iterator();
        while (it.hasNext()) {
            C0689a next = it.next();
            if (!z || next.f3318b) {
                next.f3317a.onFragmentViewDestroyed(this.f3316b, fragment);
            }
        }
    }

    /* renamed from: o */
    public void mo6044o(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.f3315a.add(new C0689a(fragmentLifecycleCallbacks, z));
    }

    /* renamed from: p */
    public void mo6045p(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.f3315a) {
            int i = 0;
            int size = this.f3315a.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.f3315a.get(i).f3317a == fragmentLifecycleCallbacks) {
                    this.f3315a.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }
}
