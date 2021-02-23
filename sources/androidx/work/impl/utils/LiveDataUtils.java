package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {

    /* renamed from: androidx.work.impl.utils.LiveDataUtils$a */
    static class C1129a implements Observer<In> {

        /* renamed from: a */
        Out f5325a = null;

        /* renamed from: b */
        final /* synthetic */ TaskExecutor f5326b;

        /* renamed from: c */
        final /* synthetic */ Object f5327c;

        /* renamed from: d */
        final /* synthetic */ Function f5328d;

        /* renamed from: e */
        final /* synthetic */ MediatorLiveData f5329e;

        /* renamed from: androidx.work.impl.utils.LiveDataUtils$a$a */
        class C1130a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Object f5330a;

            C1130a(Object obj) {
                this.f5330a = obj;
            }

            public void run() {
                synchronized (C1129a.this.f5327c) {
                    Out apply = C1129a.this.f5328d.apply(this.f5330a);
                    C1129a aVar = C1129a.this;
                    Out out = aVar.f5325a;
                    if (out == null && apply != null) {
                        aVar.f5325a = apply;
                        aVar.f5329e.postValue(apply);
                    } else if (out != null && !out.equals(apply)) {
                        C1129a aVar2 = C1129a.this;
                        aVar2.f5325a = apply;
                        aVar2.f5329e.postValue(apply);
                    }
                }
            }
        }

        C1129a(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.f5326b = taskExecutor;
            this.f5327c = obj;
            this.f5328d = function;
            this.f5329e = mediatorLiveData;
        }

        public void onChanged(@Nullable In in) {
            this.f5326b.executeOnBackgroundThread(new C1130a(in));
        }
    }

    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull Function<In, Out> function, @NonNull TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new C1129a(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }
}
