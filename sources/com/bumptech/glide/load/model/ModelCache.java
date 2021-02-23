package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {

    /* renamed from: a */
    private final LruCache<C1283b<A>, B> f6040a;

    /* renamed from: com.bumptech.glide.load.model.ModelCache$a */
    class C1282a extends LruCache<C1283b<A>, B> {
        C1282a(ModelCache modelCache, long j) {
            super(j);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onItemEvicted(@NonNull C1283b<A> bVar, @Nullable B b) {
            bVar.mo9770c();
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.model.ModelCache$b */
    static final class C1283b<A> {

        /* renamed from: d */
        private static final Queue<C1283b<?>> f6041d = Util.createQueue(0);

        /* renamed from: a */
        private int f6042a;

        /* renamed from: b */
        private int f6043b;

        /* renamed from: c */
        private A f6044c;

        private C1283b() {
        }

        /* renamed from: a */
        static <A> C1283b<A> m4468a(A a, int i, int i2) {
            C1283b<A> poll;
            Queue<C1283b<?>> queue = f6041d;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new C1283b<>();
            }
            poll.m4469b(a, i, i2);
            return poll;
        }

        /* renamed from: b */
        private void m4469b(A a, int i, int i2) {
            this.f6044c = a;
            this.f6043b = i;
            this.f6042a = i2;
        }

        /* renamed from: c */
        public void mo9770c() {
            Queue<C1283b<?>> queue = f6041d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1283b)) {
                return false;
            }
            C1283b bVar = (C1283b) obj;
            if (this.f6043b == bVar.f6043b && this.f6042a == bVar.f6042a && this.f6044c.equals(bVar.f6044c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f6042a * 31) + this.f6043b) * 31) + this.f6044c.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public void clear() {
        this.f6040a.clearMemory();
    }

    @Nullable
    public B get(A a, int i, int i2) {
        C1283b a2 = C1283b.m4468a(a, i, i2);
        B b = this.f6040a.get(a2);
        a2.mo9770c();
        return b;
    }

    public void put(A a, int i, int i2, B b) {
        this.f6040a.put(C1283b.m4468a(a, i, i2), b);
    }

    public ModelCache(long j) {
        this.f6040a = new C1282a(this, j);
    }
}
