package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: k */
    static final Object f3490k = new Object();

    /* renamed from: a */
    final Object f3491a;

    /* renamed from: b */
    private SafeIterableMap<Observer<? super T>, LiveData<T>.c> f3492b;

    /* renamed from: c */
    int f3493c;

    /* renamed from: d */
    private boolean f3494d;

    /* renamed from: e */
    private volatile Object f3495e;

    /* renamed from: f */
    volatile Object f3496f;

    /* renamed from: g */
    private int f3497g;

    /* renamed from: h */
    private boolean f3498h;

    /* renamed from: i */
    private boolean f3499i;

    /* renamed from: j */
    private final Runnable f3500j;

    class LifecycleBoundObserver extends LiveData<T>.c implements LifecycleEventObserver {
        @NonNull

        /* renamed from: e */
        final LifecycleOwner f3501e;

        LifecycleBoundObserver(@NonNull LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.f3501e = lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6219h() {
            this.f3501e.getLifecycle().removeObserver(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public boolean mo6220i(LifecycleOwner lifecycleOwner) {
            return this.f3501e == lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean mo6221j() {
            return this.f3501e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            Lifecycle.State currentState = this.f3501e.getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f3504a);
                return;
            }
            Lifecycle.State state = null;
            while (state != currentState) {
                mo6223g(mo6221j());
                state = currentState;
                currentState = this.f3501e.getLifecycle().getCurrentState();
            }
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$a */
    class C0746a implements Runnable {
        C0746a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.f3491a) {
                obj = LiveData.this.f3496f;
                LiveData.this.f3496f = LiveData.f3490k;
            }
            LiveData.this.setValue(obj);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$b */
    private class C0747b extends LiveData<T>.c {
        C0747b(LiveData liveData, Observer<? super T> observer) {
            super(observer);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean mo6221j() {
            return true;
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$c */
    private abstract class C0748c {

        /* renamed from: a */
        final Observer<? super T> f3504a;

        /* renamed from: b */
        boolean f3505b;

        /* renamed from: c */
        int f3506c = -1;

        C0748c(Observer<? super T> observer) {
            this.f3504a = observer;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo6223g(boolean z) {
            if (z != this.f3505b) {
                this.f3505b = z;
                LiveData.this.mo6206b(z ? 1 : -1);
                if (this.f3505b) {
                    LiveData.this.mo6207d(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6219h() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public boolean mo6220i(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public abstract boolean mo6221j();
    }

    public LiveData(T t) {
        this.f3491a = new Object();
        this.f3492b = new SafeIterableMap<>();
        this.f3493c = 0;
        this.f3496f = f3490k;
        this.f3500j = new C0746a();
        this.f3495e = t;
        this.f3497g = 0;
    }

    /* renamed from: a */
    static void m2560a(String str) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    /* renamed from: c */
    private void m2561c(LiveData<T>.c cVar) {
        if (cVar.f3505b) {
            if (!cVar.mo6221j()) {
                cVar.mo6223g(false);
                return;
            }
            int i = cVar.f3506c;
            int i2 = this.f3497g;
            if (i < i2) {
                cVar.f3506c = i2;
                cVar.f3504a.onChanged(this.f3495e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: b */
    public void mo6206b(int i) {
        int i2 = this.f3493c;
        this.f3493c = i + i2;
        if (!this.f3494d) {
            this.f3494d = true;
            while (true) {
                try {
                    int i3 = this.f3493c;
                    if (i2 != i3) {
                        boolean z = i2 == 0 && i3 > 0;
                        boolean z2 = i2 > 0 && i3 == 0;
                        if (z) {
                            onActive();
                        } else if (z2) {
                            onInactive();
                        }
                        i2 = i3;
                    } else {
                        return;
                    }
                } finally {
                    this.f3494d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6207d(@Nullable LiveData<T>.c cVar) {
        if (this.f3498h) {
            this.f3499i = true;
            return;
        }
        this.f3498h = true;
        do {
            this.f3499i = false;
            if (cVar == null) {
                SafeIterableMap<K, V>.d iteratorWithAdditions = this.f3492b.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    m2561c((C0748c) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.f3499i) {
                        break;
                    }
                }
            } else {
                m2561c(cVar);
                cVar = null;
            }
        } while (this.f3499i);
        this.f3498h = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo6208e() {
        return this.f3497g;
    }

    @Nullable
    public T getValue() {
        T t = this.f3495e;
        if (t != f3490k) {
            return t;
        }
        return null;
    }

    public boolean hasActiveObservers() {
        return this.f3493c > 0;
    }

    public boolean hasObservers() {
        return this.f3492b.size() > 0;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        m2560a("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            C0748c putIfAbsent = this.f3492b.putIfAbsent(observer, lifecycleBoundObserver);
            if (putIfAbsent != null && !putIfAbsent.mo6220i(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (putIfAbsent == null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
            }
        }
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        m2560a("observeForever");
        C0747b bVar = new C0747b(this, observer);
        C0748c putIfAbsent = this.f3492b.putIfAbsent(observer, bVar);
        if (putIfAbsent instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (putIfAbsent == null) {
            bVar.mo6223g(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onActive() {
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
    }

    /* access modifiers changed from: protected */
    public void postValue(T t) {
        boolean z;
        synchronized (this.f3491a) {
            z = this.f3496f == f3490k;
            this.f3496f = t;
        }
        if (z) {
            ArchTaskExecutor.getInstance().postToMainThread(this.f3500j);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        m2560a("removeObserver");
        C0748c remove = this.f3492b.remove(observer);
        if (remove != null) {
            remove.mo6219h();
            remove.mo6223g(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        m2560a("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.c>> it = this.f3492b.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (((C0748c) next.getValue()).mo6220i(lifecycleOwner)) {
                removeObserver((Observer) next.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void setValue(T t) {
        m2560a("setValue");
        this.f3497g++;
        this.f3495e = t;
        mo6207d((LiveData<T>.c) null);
    }

    public LiveData() {
        this.f3491a = new Object();
        this.f3492b = new SafeIterableMap<>();
        this.f3493c = 0;
        Object obj = f3490k;
        this.f3496f = obj;
        this.f3500j = new C0746a();
        this.f3495e = obj;
        this.f3497g = -1;
    }
}
