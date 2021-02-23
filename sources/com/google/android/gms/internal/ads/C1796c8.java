package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.ads.c8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1796c8 implements zzeor {

    /* renamed from: a */
    private final ByteBuffer f7979a;

    C1796c8(ByteBuffer byteBuffer) {
        this.f7979a = byteBuffer.duplicate();
    }

    public final void close() {
    }

    public final long position() {
        return (long) this.f7979a.position();
    }

    public final int read(ByteBuffer byteBuffer) {
        if (this.f7979a.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.f7979a.remaining());
        byte[] bArr = new byte[min];
        this.f7979a.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long size() {
        return (long) this.f7979a.limit();
    }

    public final void zzfc(long j) {
        this.f7979a.position((int) j);
    }

    public final ByteBuffer zzh(long j, long j2) {
        int position = this.f7979a.position();
        this.f7979a.position((int) j);
        ByteBuffer slice = this.f7979a.slice();
        slice.limit((int) j2);
        this.f7979a.position(position);
        return slice;
    }
}
