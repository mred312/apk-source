package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

public class Transformations {

    /* renamed from: androidx.lifecycle.Transformations$a */
    static class C0757a implements Observer<X> {

        /* renamed from: a */
        final /* synthetic */ MediatorLiveData f3543a;

        /* renamed from: b */
        final /* synthetic */ Function f3544b;

        C0757a(MediatorLiveData mediatorLiveData, Function function) {
            this.f3543a = mediatorLiveData;
            this.f3544b = function;
        }

        public void onChanged(@Nullable X x) {
            this.f3543a.setValue(this.f3544b.apply(x));
        }
    }

    /* renamed from: androidx.lifecycle.Transformations$b */
    static class C0758b implements Observer<X> {

        /* renamed from: a */
        LiveData<Y> f3545a;

        /* renamed from: b */
        final /* synthetic */ Function f3546b;

        /* renamed from: c */
        final /* synthetic */ MediatorLiveData f3547c;

        /* renamed from: androidx.lifecycle.Transformations$b$a */
        class C0759a implements Observer<Y> {
            C0759a() {
            }

            public void onChanged(@Nullable Y y) {
                C0758b.this.f3547c.setValue(y);
            }
        }

        C0758b(Function function, MediatorLiveData mediatorLiveData) {
            this.f3546b = function;
            this.f3547c = mediatorLiveData;
        }

        public void onChanged(@Nullable X x) {
            LiveData<Y> liveData = (LiveData) this.f3546b.apply(x);
            LiveData<Y> liveData2 = this.f3545a;
            if (liveData2 != liveData) {
                if (liveData2 != null) {
                    this.f3547c.removeSource(liveData2);
                }
                this.f3545a = liveData;
                if (liveData != null) {
                    this.f3547c.addSource(liveData, new C0759a());
                }
            }
        }
    }

    private Transformations() {
    }

    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new C0757a(mediatorLiveData, function));
        return mediatorLiveData;
    }

    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull Function<X, LiveData<Y>> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new C0758b(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
