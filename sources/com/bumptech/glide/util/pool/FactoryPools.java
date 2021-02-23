package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {

    /* renamed from: a */
    private static final Resetter<Object> f6517a = new C1360a();

    public interface Factory<T> {
        T create();
    }

    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@NonNull T t);
    }

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$a */
    class C1360a implements Resetter<Object> {
        C1360a() {
        }

        public void reset(@NonNull Object obj) {
        }
    }

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$b */
    class C1361b implements Factory<List<T>> {
        C1361b() {
        }

        @NonNull
        /* renamed from: a */
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$c */
    class C1362c implements Resetter<List<T>> {
        C1362c() {
        }

        /* renamed from: a */
        public void reset(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* renamed from: com.bumptech.glide.util.pool.FactoryPools$d */
    private static final class C1363d<T> implements Pools.Pool<T> {

        /* renamed from: a */
        private final Factory<T> f6518a;

        /* renamed from: b */
        private final Resetter<T> f6519b;

        /* renamed from: c */
        private final Pools.Pool<T> f6520c;

        C1363d(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.f6520c = pool;
            this.f6518a = factory;
            this.f6519b = resetter;
        }

        public T acquire() {
            T acquire = this.f6520c.acquire();
            if (acquire == null) {
                acquire = this.f6518a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).getVerifier().mo10279a(false);
            }
            return acquire;
        }

        public boolean release(@NonNull T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).getVerifier().mo10279a(true);
            }
            this.f6519b.reset(t);
            return this.f6520c.release(t);
        }
    }

    private FactoryPools() {
    }

    @NonNull
    /* renamed from: a */
    private static <T extends Poolable> Pools.Pool<T> m4768a(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory) {
        return m4769b(pool, factory, m4770c());
    }

    @NonNull
    /* renamed from: b */
    private static <T> Pools.Pool<T> m4769b(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new C1363d(pool, factory, resetter);
    }

    @NonNull
    /* renamed from: c */
    private static <T> Resetter<T> m4770c() {
        return f6517a;
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> simple(int i, @NonNull Factory<T> factory) {
        return m4768a(new Pools.SimplePool(i), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i, @NonNull Factory<T> factory) {
        return m4768a(new Pools.SynchronizedPool(i), factory);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i) {
        return m4769b(new Pools.SynchronizedPool(i), new C1361b(), new C1362c());
    }
}
