package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.load.engine.cache.a */
/* compiled from: DiskCacheWriteLocker */
final class C1225a {

    /* renamed from: a */
    private final Map<String, C1226a> f5801a = new HashMap();

    /* renamed from: b */
    private final C1227b f5802b = new C1227b();

    /* renamed from: com.bumptech.glide.load.engine.cache.a$a */
    /* compiled from: DiskCacheWriteLocker */
    private static class C1226a {

        /* renamed from: a */
        final Lock f5803a = new ReentrantLock();

        /* renamed from: b */
        int f5804b;

        C1226a() {
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.a$b */
    /* compiled from: DiskCacheWriteLocker */
    private static class C1227b {

        /* renamed from: a */
        private final Queue<C1226a> f5805a = new ArrayDeque();

        C1227b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1226a mo9592a() {
            C1226a poll;
            synchronized (this.f5805a) {
                poll = this.f5805a.poll();
            }
            return poll == null ? new C1226a() : poll;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo9593b(C1226a aVar) {
            synchronized (this.f5805a) {
                if (this.f5805a.size() < 10) {
                    this.f5805a.offer(aVar);
                }
            }
        }
    }

    C1225a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9590a(String str) {
        C1226a aVar;
        synchronized (this) {
            aVar = this.f5801a.get(str);
            if (aVar == null) {
                aVar = this.f5802b.mo9592a();
                this.f5801a.put(str, aVar);
            }
            aVar.f5804b++;
        }
        aVar.f5803a.lock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9591b(String str) {
        C1226a aVar;
        synchronized (this) {
            aVar = (C1226a) Preconditions.checkNotNull(this.f5801a.get(str));
            int i = aVar.f5804b;
            if (i >= 1) {
                int i2 = i - 1;
                aVar.f5804b = i2;
                if (i2 == 0) {
                    C1226a remove = this.f5801a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f5802b.mo9593b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f5804b);
            }
        }
        aVar.f5803a.unlock();
    }
}
