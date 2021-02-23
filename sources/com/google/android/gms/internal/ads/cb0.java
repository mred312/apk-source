package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class cb0 extends ib0 {

    /* renamed from: b */
    private final /* synthetic */ bb0 f7985b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private cb0(bb0 bb0) {
        super(bb0, (ab0) null);
        this.f7985b = bb0;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new db0(this.f7985b, (ab0) null);
    }

    /* synthetic */ cb0(bb0 bb0, ab0 ab0) {
        this(bb0);
    }
}
