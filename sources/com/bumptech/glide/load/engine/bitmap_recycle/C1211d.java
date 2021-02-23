package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.C1214f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.d */
/* compiled from: GroupedLinkedMap */
class C1211d<K extends C1214f, V> {

    /* renamed from: a */
    private final C1212a<K, V> f5749a = new C1212a<>();

    /* renamed from: b */
    private final Map<K, C1212a<K, V>> f5750b = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.d$a */
    /* compiled from: GroupedLinkedMap */
    private static class C1212a<K, V> {

        /* renamed from: a */
        final K f5751a;

        /* renamed from: b */
        private List<V> f5752b;

        /* renamed from: c */
        C1212a<K, V> f5753c;

        /* renamed from: d */
        C1212a<K, V> f5754d;

        C1212a() {
            this((Object) null);
        }

        /* renamed from: a */
        public void mo9554a(V v) {
            if (this.f5752b == null) {
                this.f5752b = new ArrayList();
            }
            this.f5752b.add(v);
        }

        @Nullable
        /* renamed from: b */
        public V mo9555b() {
            int c = mo9556c();
            if (c > 0) {
                return this.f5752b.remove(c - 1);
            }
            return null;
        }

        /* renamed from: c */
        public int mo9556c() {
            List<V> list = this.f5752b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        C1212a(K k) {
            this.f5754d = this;
            this.f5753c = this;
            this.f5751a = k;
        }
    }

    C1211d() {
    }

    /* renamed from: b */
    private void m4299b(C1212a<K, V> aVar) {
        m4301e(aVar);
        C1212a<K, V> aVar2 = this.f5749a;
        aVar.f5754d = aVar2;
        aVar.f5753c = aVar2.f5753c;
        m4302g(aVar);
    }

    /* renamed from: c */
    private void m4300c(C1212a<K, V> aVar) {
        m4301e(aVar);
        C1212a<K, V> aVar2 = this.f5749a;
        aVar.f5754d = aVar2.f5754d;
        aVar.f5753c = aVar2;
        m4302g(aVar);
    }

    /* renamed from: e */
    private static <K, V> void m4301e(C1212a<K, V> aVar) {
        C1212a<K, V> aVar2 = aVar.f5754d;
        aVar2.f5753c = aVar.f5753c;
        aVar.f5753c.f5754d = aVar2;
    }

    /* renamed from: g */
    private static <K, V> void m4302g(C1212a<K, V> aVar) {
        aVar.f5753c.f5754d = aVar;
        aVar.f5754d.f5753c = aVar;
    }

    @Nullable
    /* renamed from: a */
    public V mo9550a(K k) {
        C1212a aVar = this.f5750b.get(k);
        if (aVar == null) {
            aVar = new C1212a(k);
            this.f5750b.put(k, aVar);
        } else {
            k.mo9518a();
        }
        m4299b(aVar);
        return aVar.mo9555b();
    }

    /* renamed from: d */
    public void mo9551d(K k, V v) {
        C1212a aVar = this.f5750b.get(k);
        if (aVar == null) {
            aVar = new C1212a(k);
            m4300c(aVar);
            this.f5750b.put(k, aVar);
        } else {
            k.mo9518a();
        }
        aVar.mo9554a(v);
    }

    @Nullable
    /* renamed from: f */
    public V mo9552f() {
        for (C1212a<K, V> aVar = this.f5749a.f5754d; !aVar.equals(this.f5749a); aVar = aVar.f5754d) {
            V b = aVar.mo9555b();
            if (b != null) {
                return b;
            }
            m4301e(aVar);
            this.f5750b.remove(aVar.f5751a);
            ((C1214f) aVar.f5751a).mo9518a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (C1212a<K, V> aVar = this.f5749a.f5753c; !aVar.equals(this.f5749a); aVar = aVar.f5753c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f5751a);
            sb.append(':');
            sb.append(aVar.mo9556c());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
