package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {
        @SuppressLint({"UnknownNullness"})

        /* renamed from: a */
        private final T f335a;

        public SynchronousResult(@SuppressLint({"UnknownNullness"}) T t) {
            this.f335a = t;
        }

        @SuppressLint({"UnknownNullness"})
        public T getValue() {
            return this.f335a;
        }
    }

    @NonNull
    public abstract Intent createIntent(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i);

    @Nullable
    public SynchronousResult<O> getSynchronousResult(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O parseResult(int i, @Nullable Intent intent);
}
