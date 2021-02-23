package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {

    /* renamed from: a */
    private final C1211d<C1199a, Object> f5710a;

    /* renamed from: b */
    private final C1200b f5711b;

    /* renamed from: c */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f5712c;

    /* renamed from: d */
    private final Map<Class<?>, C1206a<?>> f5713d;

    /* renamed from: e */
    private final int f5714e;

    /* renamed from: f */
    private int f5715f;

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$a */
    private static final class C1199a implements C1214f {

        /* renamed from: a */
        private final C1200b f5716a;

        /* renamed from: b */
        int f5717b;

        /* renamed from: c */
        private Class<?> f5718c;

        C1199a(C1200b bVar) {
            this.f5716a = bVar;
        }

        /* renamed from: a */
        public void mo9518a() {
            this.f5716a.mo9549c(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo9519b(int i, Class<?> cls) {
            this.f5717b = i;
            this.f5718c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1199a)) {
                return false;
            }
            C1199a aVar = (C1199a) obj;
            if (this.f5717b == aVar.f5717b && this.f5718c == aVar.f5718c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = this.f5717b * 31;
            Class<?> cls = this.f5718c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f5717b + "array=" + this.f5718c + '}';
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$b */
    private static final class C1200b extends C1210c<C1199a> {
        C1200b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public C1199a mo9523a() {
            return new C1199a(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public C1199a mo9525e(int i, Class<?> cls) {
            C1199a aVar = (C1199a) mo9548b();
            aVar.mo9519b(i, cls);
            return aVar;
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.f5710a = new C1211d<>();
        this.f5711b = new C1200b();
        this.f5712c = new HashMap();
        this.f5713d = new HashMap();
        this.f5714e = 4194304;
    }

    /* renamed from: a */
    private void m4248a(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> h = m4255h(cls);
        Integer num = (Integer) h.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            h.remove(Integer.valueOf(i));
        } else {
            h.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    /* renamed from: b */
    private void m4249b() {
        m4250c(this.f5714e);
    }

    /* renamed from: c */
    private void m4250c(int i) {
        while (this.f5715f > i) {
            Object f = this.f5710a.mo9552f();
            Preconditions.checkNotNull(f);
            C1206a d = m4251d(f);
            this.f5715f -= d.getArrayLength(f) * d.getElementSizeInBytes();
            m4248a(d.getArrayLength(f), f.getClass());
            if (Log.isLoggable(d.getTag(), 2)) {
                Log.v(d.getTag(), "evicted: " + d.getArrayLength(f));
            }
        }
    }

    /* renamed from: d */
    private <T> C1206a<T> m4251d(T t) {
        return m4252e(t.getClass());
    }

    /* renamed from: e */
    private <T> C1206a<T> m4252e(Class<T> cls) {
        C1206a<T> aVar = this.f5713d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                aVar = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f5713d.put(cls, aVar);
        }
        return aVar;
    }

    @Nullable
    /* renamed from: f */
    private <T> T m4253f(C1199a aVar) {
        return this.f5710a.mo9550a(aVar);
    }

    /* renamed from: g */
    private <T> T m4254g(C1199a aVar, Class<T> cls) {
        C1206a<T> e = m4252e(cls);
        T f = m4253f(aVar);
        if (f != null) {
            this.f5715f -= e.getArrayLength(f) * e.getElementSizeInBytes();
            m4248a(e.getArrayLength(f), cls);
        }
        if (f != null) {
            return f;
        }
        if (Log.isLoggable(e.getTag(), 2)) {
            Log.v(e.getTag(), "Allocated " + aVar.f5717b + " bytes");
        }
        return e.newArray(aVar.f5717b);
    }

    /* renamed from: h */
    private NavigableMap<Integer, Integer> m4255h(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f5712c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5712c.put(cls, treeMap);
        return treeMap;
    }

    /* renamed from: i */
    private boolean m4256i() {
        int i = this.f5715f;
        return i == 0 || this.f5714e / i >= 2;
    }

    /* renamed from: j */
    private boolean m4257j(int i) {
        return i <= this.f5714e / 2;
    }

    /* renamed from: k */
    private boolean m4258k(int i, Integer num) {
        return num != null && (m4256i() || num.intValue() <= i * 8);
    }

    public synchronized void clearMemory() {
        m4250c(0);
    }

    public synchronized <T> T get(int i, Class<T> cls) {
        C1199a aVar;
        Integer ceilingKey = m4255h(cls).ceilingKey(Integer.valueOf(i));
        if (m4258k(i, ceilingKey)) {
            aVar = this.f5711b.mo9525e(ceilingKey.intValue(), cls);
        } else {
            aVar = this.f5711b.mo9525e(i, cls);
        }
        return m4254g(aVar, cls);
    }

    public synchronized <T> T getExact(int i, Class<T> cls) {
        return m4254g(this.f5711b.mo9525e(i, cls), cls);
    }

    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }

    public synchronized void trimMemory(int i) {
        if (i >= 40) {
            try {
                clearMemory();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20 || i == 15) {
            m4250c(this.f5714e / 2);
        }
    }

    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        C1206a<?> e = m4252e(cls);
        int arrayLength = e.getArrayLength(t);
        int elementSizeInBytes = e.getElementSizeInBytes() * arrayLength;
        if (m4257j(elementSizeInBytes)) {
            C1199a e2 = this.f5711b.mo9525e(arrayLength, cls);
            this.f5710a.mo9551d(e2, t);
            NavigableMap<Integer, Integer> h = m4255h(cls);
            Integer num = (Integer) h.get(Integer.valueOf(e2.f5717b));
            Integer valueOf = Integer.valueOf(e2.f5717b);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            h.put(valueOf, Integer.valueOf(i));
            this.f5715f += elementSizeInBytes;
            m4249b();
        }
    }

    public LruArrayPool(int i) {
        this.f5710a = new C1211d<>();
        this.f5711b = new C1200b();
        this.f5712c = new HashMap();
        this.f5713d = new HashMap();
        this.f5714e = i;
    }
}
