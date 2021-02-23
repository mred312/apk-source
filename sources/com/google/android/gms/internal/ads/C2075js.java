package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.google.android.gms.internal.ads.js */
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class C2075js implements C2475ug {

    /* renamed from: a */
    private final ByteBuffer f9542a;

    public C2075js(ByteBuffer byteBuffer) {
        this.f9542a = byteBuffer.slice();
    }

    /* renamed from: a */
    public final void mo14316a(MessageDigest[] messageDigestArr, long j, int i) {
        ByteBuffer slice;
        synchronized (this.f9542a) {
            int i2 = (int) j;
            this.f9542a.position(i2);
            this.f9542a.limit(i2 + i);
            slice = this.f9542a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }

    public final long size() {
        return (long) this.f9542a.capacity();
    }
}
