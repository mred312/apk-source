package com.google.android.gms.internal.measurement;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.g2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2766g2 extends C2869t1<K, V> {
    @NullableDecl

    /* renamed from: a */
    private final K f17316a;

    /* renamed from: b */
    private int f17317b;

    /* renamed from: c */
    private final /* synthetic */ C2900x1 f17318c;

    C2766g2(C2900x1 x1Var, int i) {
        this.f17318c = x1Var;
        this.f17316a = x1Var.f17507c[i];
        this.f17317b = i;
    }

    /* renamed from: a */
    private final void m9487a() {
        int i = this.f17317b;
        if (i == -1 || i >= this.f17318c.size() || !zzdz.zza(this.f17316a, this.f17318c.f17507c[this.f17317b])) {
            this.f17317b = this.f17318c.m9900d(this.f17316a);
        }
    }

    @NullableDecl
    public final K getKey() {
        return this.f17316a;
    }

    @NullableDecl
    public final V getValue() {
        Map l = this.f17318c.mo18966l();
        if (l != null) {
            return l.get(this.f17316a);
        }
        m9487a();
        int i = this.f17317b;
        if (i == -1) {
            return null;
        }
        return this.f17318c.f17508d[i];
    }

    public final V setValue(V v) {
        Map l = this.f17318c.mo18966l();
        if (l != null) {
            return l.put(this.f17316a, v);
        }
        m9487a();
        int i = this.f17317b;
        if (i == -1) {
            this.f17318c.put(this.f17316a, v);
            return null;
        }
        V[] vArr = this.f17318c.f17508d;
        V v2 = vArr[i];
        vArr[i] = v;
        return v2;
    }
}
