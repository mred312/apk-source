package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Pools {

    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t);
    }

    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a */
        private final Object[] f2573a;

        /* renamed from: b */
        private int f2574b;

        public SimplePool(int i) {
            if (i > 0) {
                this.f2573a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        /* renamed from: a */
        private boolean m1694a(@NonNull T t) {
            for (int i = 0; i < this.f2574b; i++) {
                if (this.f2573a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i = this.f2574b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f2573a;
            T t = tArr[i2];
            tArr[i2] = null;
            this.f2574b = i - 1;
            return t;
        }

        public boolean release(@NonNull T t) {
            if (!m1694a(t)) {
                int i = this.f2574b;
                Object[] objArr = this.f2573a;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.f2574b = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: c */
        private final Object f2575c = new Object();

        public SynchronizedPool(int i) {
            super(i);
        }

        public T acquire() {
            T acquire;
            synchronized (this.f2575c) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(@NonNull T t) {
            boolean release;
            synchronized (this.f2575c) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
