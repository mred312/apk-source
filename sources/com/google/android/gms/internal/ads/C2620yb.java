package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.ads.yb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2620yb extends ThreadLocal<ByteBuffer> {
    C2620yb(zzbm zzbm) {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
