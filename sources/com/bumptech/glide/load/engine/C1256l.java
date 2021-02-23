package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.engine.l */
/* compiled from: EngineResource */
class C1256l<Z> implements Resource<Z> {

    /* renamed from: a */
    private final boolean f5932a;

    /* renamed from: b */
    private final boolean f5933b;

    /* renamed from: c */
    private final Resource<Z> f5934c;

    /* renamed from: d */
    private final C1257a f5935d;

    /* renamed from: e */
    private final Key f5936e;

    /* renamed from: f */
    private int f5937f;

    /* renamed from: g */
    private boolean f5938g;

    /* renamed from: com.bumptech.glide.load.engine.l$a */
    /* compiled from: EngineResource */
    interface C1257a {
        void onResourceReleased(Key key, C1256l<?> lVar);
    }

    C1256l(Resource<Z> resource, boolean z, boolean z2, Key key, C1257a aVar) {
        this.f5934c = (Resource) Preconditions.checkNotNull(resource);
        this.f5932a = z;
        this.f5933b = z2;
        this.f5936e = key;
        this.f5935d = (C1257a) Preconditions.checkNotNull(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo9683a() {
        if (!this.f5938g) {
            this.f5937f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Resource<Z> mo9684b() {
        return this.f5934c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo9685c() {
        return this.f5932a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9686d() {
        boolean z;
        synchronized (this) {
            int i = this.f5937f;
            if (i > 0) {
                z = true;
                int i2 = i - 1;
                this.f5937f = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.f5935d.onResourceReleased(this.f5936e, this);
        }
    }

    @NonNull
    public Z get() {
        return this.f5934c.get();
    }

    @NonNull
    public Class<Z> getResourceClass() {
        return this.f5934c.getResourceClass();
    }

    public int getSize() {
        return this.f5934c.getSize();
    }

    public synchronized void recycle() {
        if (this.f5937f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f5938g) {
            this.f5938g = true;
            if (this.f5933b) {
                this.f5934c.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f5932a + ", listener=" + this.f5935d + ", key=" + this.f5936e + ", acquired=" + this.f5937f + ", isRecycled=" + this.f5938g + ", resource=" + this.f5934c + '}';
    }
}
