package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* renamed from: com.bumptech.glide.load.engine.n */
/* compiled from: LockedResource */
final class C1259n<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: e */
    private static final Pools.Pool<C1259n<?>> f5941e = FactoryPools.threadSafe(20, new C1260a());

    /* renamed from: a */
    private final StateVerifier f5942a = StateVerifier.newInstance();

    /* renamed from: b */
    private Resource<Z> f5943b;

    /* renamed from: c */
    private boolean f5944c;

    /* renamed from: d */
    private boolean f5945d;

    /* renamed from: com.bumptech.glide.load.engine.n$a */
    /* compiled from: LockedResource */
    class C1260a implements FactoryPools.Factory<C1259n<?>> {
        C1260a() {
        }

        /* renamed from: a */
        public C1259n<?> create() {
            return new C1259n<>();
        }
    }

    C1259n() {
    }

    /* renamed from: a */
    private void m4422a(Resource<Z> resource) {
        this.f5945d = false;
        this.f5944c = true;
        this.f5943b = resource;
    }

    @NonNull
    /* renamed from: b */
    static <Z> C1259n<Z> m4423b(Resource<Z> resource) {
        C1259n<Z> nVar = (C1259n) Preconditions.checkNotNull(f5941e.acquire());
        nVar.m4422a(resource);
        return nVar;
    }

    /* renamed from: c */
    private void m4424c() {
        this.f5943b = null;
        f5941e.release(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo9691d() {
        this.f5942a.throwIfRecycled();
        if (this.f5944c) {
            this.f5944c = false;
            if (this.f5945d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @NonNull
    public Z get() {
        return this.f5943b.get();
    }

    @NonNull
    public Class<Z> getResourceClass() {
        return this.f5943b.getResourceClass();
    }

    public int getSize() {
        return this.f5943b.getSize();
    }

    @NonNull
    public StateVerifier getVerifier() {
        return this.f5942a;
    }

    public synchronized void recycle() {
        this.f5942a.throwIfRecycled();
        this.f5945d = true;
        if (!this.f5944c) {
            this.f5943b.recycle();
            m4424c();
        }
    }
}
