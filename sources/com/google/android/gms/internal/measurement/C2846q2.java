package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.q2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2846q2<K> extends zzfg<K> {

    /* renamed from: c */
    private final transient zzfc<K, ?> f17422c;

    /* renamed from: d */
    private final transient zzfb<K> f17423d;

    C2846q2(zzfc<K, ?> zzfc, zzfb<K> zzfb) {
        this.f17422c = zzfc;
        this.f17423d = zzfb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo18762a(Object[] objArr, int i) {
        return zze().mo18762a(objArr, i);
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.f17422c.get(obj) != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo18705e() {
        return true;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.f17422c.size();
    }

    public final zzfx<K> zza() {
        return (zzfx) zze().iterator();
    }

    public final zzfb<K> zze() {
        return this.f17423d;
    }
}
