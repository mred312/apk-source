package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {

    /* renamed from: a */
    private final Map<T, Y> f6504a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    private final long f6505b;

    /* renamed from: c */
    private long f6506c;

    /* renamed from: d */
    private long f6507d;

    public LruCache(long j) {
        this.f6505b = j;
        this.f6506c = j;
    }

    /* renamed from: a */
    private void m4762a() {
        trimToSize(this.f6506c);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public synchronized boolean contains(@NonNull T t) {
        return this.f6504a.containsKey(t);
    }

    @Nullable
    public synchronized Y get(@NonNull T t) {
        return this.f6504a.get(t);
    }

    /* access modifiers changed from: protected */
    public synchronized int getCount() {
        return this.f6504a.size();
    }

    public synchronized long getCurrentSize() {
        return this.f6507d;
    }

    public synchronized long getMaxSize() {
        return this.f6506c;
    }

    /* access modifiers changed from: protected */
    public int getSize(@Nullable Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onItemEvicted(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        long size = (long) getSize(y);
        if (size >= this.f6506c) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.f6507d += size;
        }
        Y put = this.f6504a.put(t, y);
        if (put != null) {
            this.f6507d -= (long) getSize(put);
            if (!put.equals(y)) {
                onItemEvicted(t, put);
            }
        }
        m4762a();
        return put;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        Y remove;
        remove = this.f6504a.remove(t);
        if (remove != null) {
            this.f6507d -= (long) getSize(remove);
        }
        return remove;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f >= 0.0f) {
            this.f6506c = (long) Math.round(((float) this.f6505b) * f);
            m4762a();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void trimToSize(long j) {
        while (this.f6507d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f6504a.entrySet().iterator();
            Map.Entry next = it.next();
            Object value = next.getValue();
            this.f6507d -= (long) getSize(value);
            Object key = next.getKey();
            it.remove();
            onItemEvicted(key, value);
        }
    }
}
