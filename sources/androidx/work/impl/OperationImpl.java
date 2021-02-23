package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class OperationImpl implements Operation {

    /* renamed from: a */
    private final MutableLiveData<Operation.State> f5082a = new MutableLiveData<>();

    /* renamed from: b */
    private final SettableFuture<Operation.State.SUCCESS> f5083b = SettableFuture.create();

    public OperationImpl() {
        setState(Operation.IN_PROGRESS);
    }

    @NonNull
    public ListenableFuture<Operation.State.SUCCESS> getResult() {
        return this.f5083b;
    }

    @NonNull
    public LiveData<Operation.State> getState() {
        return this.f5082a;
    }

    public void setState(@NonNull Operation.State state) {
        this.f5082a.postValue(state);
        if (state instanceof Operation.State.SUCCESS) {
            this.f5083b.set((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            this.f5083b.setException(((Operation.State.FAILURE) state).getThrowable());
        }
    }
}
