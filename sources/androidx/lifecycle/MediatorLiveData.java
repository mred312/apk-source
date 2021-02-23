package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* renamed from: l */
    private SafeIterableMap<LiveData<?>, C0749a<?>> f3508l = new SafeIterableMap<>();

    /* renamed from: androidx.lifecycle.MediatorLiveData$a */
    private static class C0749a<V> implements Observer<V> {

        /* renamed from: a */
        final LiveData<V> f3509a;

        /* renamed from: b */
        final Observer<? super V> f3510b;

        /* renamed from: c */
        int f3511c = -1;

        C0749a(LiveData<V> liveData, Observer<? super V> observer) {
            this.f3509a = liveData;
            this.f3510b = observer;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6226a() {
            this.f3509a.observeForever(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6227b() {
            this.f3509a.removeObserver(this);
        }

        public void onChanged(@Nullable V v) {
            if (this.f3511c != this.f3509a.mo6208e()) {
                this.f3511c = this.f3509a.mo6208e();
                this.f3510b.onChanged(v);
            }
        }
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        C0749a aVar = new C0749a(liveData, observer);
        C0749a putIfAbsent = this.f3508l.putIfAbsent(liveData, aVar);
        if (putIfAbsent != null && putIfAbsent.f3510b != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (putIfAbsent == null && hasActiveObservers()) {
            aVar.mo6226a();
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, C0749a<?>>> it = this.f3508l.iterator();
        while (it.hasNext()) {
            ((C0749a) it.next().getValue()).mo6226a();
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, C0749a<?>>> it = this.f3508l.iterator();
        while (it.hasNext()) {
            ((C0749a) it.next().getValue()).mo6227b();
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        C0749a remove = this.f3508l.remove(liveData);
        if (remove != null) {
            remove.mo6227b();
        }
    }
}
