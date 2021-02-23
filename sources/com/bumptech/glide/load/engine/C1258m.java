package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.m */
/* compiled from: Jobs */
final class C1258m {

    /* renamed from: a */
    private final Map<Key, C1247h<?>> f5939a = new HashMap();

    /* renamed from: b */
    private final Map<Key, C1247h<?>> f5940b = new HashMap();

    C1258m() {
    }

    /* renamed from: b */
    private Map<Key, C1247h<?>> m4418b(boolean z) {
        return z ? this.f5940b : this.f5939a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1247h<?> mo9688a(Key key, boolean z) {
        return m4418b(z).get(key);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9689c(Key key, C1247h<?> hVar) {
        m4418b(hVar.mo9665m()).put(key, hVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9690d(Key key, C1247h<?> hVar) {
        Map<Key, C1247h<?>> b = m4418b(hVar.mo9665m());
        if (hVar.equals(b.get(key))) {
            b.remove(key);
        }
    }
}
