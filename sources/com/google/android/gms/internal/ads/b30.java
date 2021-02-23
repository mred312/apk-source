package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.x20;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class b30<V, C> extends x20<V, C> {

    /* renamed from: p */
    private List<c30<V>> f7870p;

    b30(zzdwl<? extends zzdyz<? extends V>> zzdwl, boolean z) {
        super(zzdwl, true, true);
        List<c30<V>> list;
        if (zzdwl.isEmpty()) {
            list = zzdwm.zzayv();
        } else {
            list = zzdwu.zzes(zzdwl.size());
        }
        for (int i = 0; i < zzdwl.size(); i++) {
            list.add((Object) null);
        }
        this.f7870p = list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public final void mo13625E(x20.C2573a aVar) {
        super.mo13625E(aVar);
        this.f7870p = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public final void mo13626I() {
        List<c30<V>> list = this.f7870p;
        if (list != null) {
            set(mo13628M(list));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public final void mo13627J(int i, @NullableDecl V v) {
        List<c30<V>> list = this.f7870p;
        if (list != null) {
            list.set(i, new c30(v));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public abstract C mo13628M(List<c30<V>> list);
}
