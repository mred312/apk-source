package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig<T> {
    @NonNull

    /* renamed from: a */
    private final Executor f3840a;
    @NonNull

    /* renamed from: b */
    private final Executor f3841b;
    @NonNull

    /* renamed from: c */
    private final DiffUtil.ItemCallback<T> f3842c;

    public static final class Builder<T> {

        /* renamed from: d */
        private static final Object f3843d = new Object();

        /* renamed from: e */
        private static Executor f3844e;

        /* renamed from: a */
        private Executor f3845a;

        /* renamed from: b */
        private Executor f3846b;

        /* renamed from: c */
        private final DiffUtil.ItemCallback<T> f3847c;

        public Builder(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
            this.f3847c = itemCallback;
        }

        @NonNull
        public AsyncDifferConfig<T> build() {
            if (this.f3846b == null) {
                synchronized (f3843d) {
                    if (f3844e == null) {
                        f3844e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f3846b = f3844e;
            }
            return new AsyncDifferConfig<>(this.f3845a, this.f3846b, this.f3847c);
        }

        @NonNull
        public Builder<T> setBackgroundThreadExecutor(Executor executor) {
            this.f3846b = executor;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setMainThreadExecutor(Executor executor) {
            this.f3845a = executor;
            return this;
        }
    }

    AsyncDifferConfig(@NonNull Executor executor, @NonNull Executor executor2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.f3840a = executor;
        this.f3841b = executor2;
        this.f3842c = itemCallback;
    }

    @NonNull
    public Executor getBackgroundThreadExecutor() {
        return this.f3841b;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.f3842c;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getMainThreadExecutor() {
        return this.f3840a;
    }
}
