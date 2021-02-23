package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class LifecycleRegistry extends Lifecycle {

    /* renamed from: a */
    private FastSafeIterableMap<LifecycleObserver, C0744a> f3476a;

    /* renamed from: b */
    private Lifecycle.State f3477b;

    /* renamed from: c */
    private final WeakReference<LifecycleOwner> f3478c;

    /* renamed from: d */
    private int f3479d;

    /* renamed from: e */
    private boolean f3480e;

    /* renamed from: f */
    private boolean f3481f;

    /* renamed from: g */
    private ArrayList<Lifecycle.State> f3482g;

    /* renamed from: h */
    private final boolean f3483h;

    /* renamed from: androidx.lifecycle.LifecycleRegistry$a */
    static class C0744a {

        /* renamed from: a */
        Lifecycle.State f3484a;

        /* renamed from: b */
        LifecycleEventObserver f3485b;

        C0744a(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.f3485b = Lifecycling.m2558e(lifecycleObserver);
            this.f3484a = state;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6200a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.f3484a = LifecycleRegistry.m2548f(this.f3484a, targetState);
            this.f3485b.onStateChanged(lifecycleOwner, event);
            this.f3484a = targetState;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    /* renamed from: a */
    private void m2543a(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, C0744a>> descendingIterator = this.f3476a.descendingIterator();
        while (descendingIterator.hasNext() && !this.f3481f) {
            Map.Entry next = descendingIterator.next();
            C0744a aVar = (C0744a) next.getValue();
            while (aVar.f3484a.compareTo(this.f3477b) > 0 && !this.f3481f && this.f3476a.contains(next.getKey())) {
                Lifecycle.Event downFrom = Lifecycle.Event.downFrom(aVar.f3484a);
                if (downFrom != null) {
                    m2551i(downFrom.getTargetState());
                    aVar.mo6200a(lifecycleOwner, downFrom);
                    m2550h();
                } else {
                    throw new IllegalStateException("no event down from " + aVar.f3484a);
                }
            }
        }
    }

    /* renamed from: b */
    private Lifecycle.State m2544b(LifecycleObserver lifecycleObserver) {
        Map.Entry<LifecycleObserver, C0744a> ceil = this.f3476a.ceil(lifecycleObserver);
        Lifecycle.State state = null;
        Lifecycle.State state2 = ceil != null ? ceil.getValue().f3484a : null;
        if (!this.f3482g.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.f3482g;
            state = arrayList.get(arrayList.size() - 1);
        }
        return m2548f(m2548f(this.f3477b, state2), state);
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: c */
    private void m2545c(String str) {
        if (this.f3483h && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    @VisibleForTesting
    @NonNull
    public static LifecycleRegistry createUnsafe(@NonNull LifecycleOwner lifecycleOwner) {
        return new LifecycleRegistry(lifecycleOwner, false);
    }

    /* renamed from: d */
    private void m2546d(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<K, V>.d iteratorWithAdditions = this.f3476a.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext() && !this.f3481f) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            C0744a aVar = (C0744a) entry.getValue();
            while (aVar.f3484a.compareTo(this.f3477b) < 0 && !this.f3481f && this.f3476a.contains(entry.getKey())) {
                m2551i(aVar.f3484a);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(aVar.f3484a);
                if (upFrom != null) {
                    aVar.mo6200a(lifecycleOwner, upFrom);
                    m2550h();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3484a);
                }
            }
        }
    }

    /* renamed from: e */
    private boolean m2547e() {
        if (this.f3476a.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f3476a.eldest().getValue().f3484a;
        Lifecycle.State state2 = this.f3476a.newest().getValue().f3484a;
        if (state == state2 && this.f3477b == state2) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    static Lifecycle.State m2548f(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* renamed from: g */
    private void m2549g(Lifecycle.State state) {
        if (this.f3477b != state) {
            this.f3477b = state;
            if (this.f3480e || this.f3479d != 0) {
                this.f3481f = true;
                return;
            }
            this.f3480e = true;
            m2552j();
            this.f3480e = false;
        }
    }

    /* renamed from: h */
    private void m2550h() {
        ArrayList<Lifecycle.State> arrayList = this.f3482g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: i */
    private void m2551i(Lifecycle.State state) {
        this.f3482g.add(state);
    }

    /* renamed from: j */
    private void m2552j() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f3478c.get();
        if (lifecycleOwner != null) {
            while (!m2547e()) {
                this.f3481f = false;
                if (this.f3477b.compareTo(this.f3476a.eldest().getValue().f3484a) < 0) {
                    m2543a(lifecycleOwner);
                }
                Map.Entry<LifecycleObserver, C0744a> newest = this.f3476a.newest();
                if (!this.f3481f && newest != null && this.f3477b.compareTo(newest.getValue().f3484a) > 0) {
                    m2546d(lifecycleOwner);
                }
            }
            this.f3481f = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    public void addObserver(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        m2545c("addObserver");
        Lifecycle.State state = this.f3477b;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        C0744a aVar = new C0744a(lifecycleObserver, state2);
        if (this.f3476a.putIfAbsent(lifecycleObserver, aVar) == null && (lifecycleOwner = (LifecycleOwner) this.f3478c.get()) != null) {
            boolean z = this.f3479d != 0 || this.f3480e;
            Lifecycle.State b = m2544b(lifecycleObserver);
            this.f3479d++;
            while (aVar.f3484a.compareTo(b) < 0 && this.f3476a.contains(lifecycleObserver)) {
                m2551i(aVar.f3484a);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(aVar.f3484a);
                if (upFrom != null) {
                    aVar.mo6200a(lifecycleOwner, upFrom);
                    m2550h();
                    b = m2544b(lifecycleObserver);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3484a);
                }
            }
            if (!z) {
                m2552j();
            }
            this.f3479d--;
        }
    }

    @NonNull
    public Lifecycle.State getCurrentState() {
        return this.f3477b;
    }

    public int getObserverCount() {
        m2545c("getObserverCount");
        return this.f3476a.size();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        m2545c("handleLifecycleEvent");
        m2549g(event.getTargetState());
    }

    @MainThread
    @Deprecated
    public void markState(@NonNull Lifecycle.State state) {
        m2545c("markState");
        setCurrentState(state);
    }

    public void removeObserver(@NonNull LifecycleObserver lifecycleObserver) {
        m2545c("removeObserver");
        this.f3476a.remove(lifecycleObserver);
    }

    @MainThread
    public void setCurrentState(@NonNull Lifecycle.State state) {
        m2545c("setCurrentState");
        m2549g(state);
    }

    private LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner, boolean z) {
        this.f3476a = new FastSafeIterableMap<>();
        this.f3479d = 0;
        this.f3480e = false;
        this.f3481f = false;
        this.f3482g = new ArrayList<>();
        this.f3478c = new WeakReference<>(lifecycleOwner);
        this.f3477b = Lifecycle.State.INITIALIZED;
        this.f3483h = z;
    }
}
