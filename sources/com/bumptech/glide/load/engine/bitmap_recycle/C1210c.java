package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.C1214f;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.c */
/* compiled from: BaseKeyPool */
abstract class C1210c<T extends C1214f> {

    /* renamed from: a */
    private final Queue<T> f5748a = Util.createQueue(20);

    C1210c() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract T mo9523a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public T mo9548b() {
        T t = (C1214f) this.f5748a.poll();
        return t == null ? mo9523a() : t;
    }

    /* renamed from: c */
    public void mo9549c(T t) {
        if (this.f5748a.size() < 20) {
            this.f5748a.offer(t);
        }
    }
}
