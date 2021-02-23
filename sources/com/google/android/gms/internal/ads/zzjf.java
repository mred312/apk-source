package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzjf implements zzif {

    /* renamed from: a */
    private int f16531a = -1;

    /* renamed from: b */
    private int f16532b = -1;

    /* renamed from: c */
    private ge0 f16533c;

    /* renamed from: d */
    private float f16534d = 1.0f;

    /* renamed from: e */
    private float f16535e = 1.0f;

    /* renamed from: f */
    private ByteBuffer f16536f;

    /* renamed from: g */
    private ShortBuffer f16537g;

    /* renamed from: h */
    private ByteBuffer f16538h;

    /* renamed from: i */
    private long f16539i;

    /* renamed from: j */
    private long f16540j;

    /* renamed from: k */
    private boolean f16541k;

    public zzjf() {
        ByteBuffer byteBuffer = zzif.zzaiw;
        this.f16536f = byteBuffer;
        this.f16537g = byteBuffer.asShortBuffer();
        this.f16538h = byteBuffer;
    }

    public final void flush() {
        ge0 ge0 = new ge0(this.f16532b, this.f16531a);
        this.f16533c = ge0;
        ge0.mo14042a(this.f16534d);
        this.f16533c.mo14045h(this.f16535e);
        this.f16538h = zzif.zzaiw;
        this.f16539i = 0;
        this.f16540j = 0;
        this.f16541k = false;
    }

    public final boolean isActive() {
        return Math.abs(this.f16534d - 1.0f) >= 0.01f || Math.abs(this.f16535e - 1.0f) >= 0.01f;
    }

    public final void reset() {
        this.f16533c = null;
        ByteBuffer byteBuffer = zzif.zzaiw;
        this.f16536f = byteBuffer;
        this.f16537g = byteBuffer.asShortBuffer();
        this.f16538h = byteBuffer;
        this.f16531a = -1;
        this.f16532b = -1;
        this.f16539i = 0;
        this.f16540j = 0;
        this.f16541k = false;
    }

    public final float zza(float f) {
        float zza = zzpt.zza(f, 0.1f, 8.0f);
        this.f16534d = zza;
        return zza;
    }

    public final float zzb(float f) {
        this.f16535e = zzpt.zza(f, 0.1f, 8.0f);
        return f;
    }

    public final boolean zzfe() {
        if (!this.f16541k) {
            return false;
        }
        ge0 ge0 = this.f16533c;
        return ge0 == null || ge0.mo14047j() == 0;
    }

    public final int zzfj() {
        return this.f16531a;
    }

    public final int zzfk() {
        return 2;
    }

    public final void zzfl() {
        this.f16533c.mo14046i();
        this.f16541k = true;
    }

    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.f16538h;
        this.f16538h = zzif.zzaiw;
        return byteBuffer;
    }

    public final long zzgf() {
        return this.f16539i;
    }

    public final long zzgg() {
        return this.f16540j;
    }

    public final void zzn(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f16539i += (long) remaining;
            this.f16533c.mo14043d(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int j = (this.f16533c.mo14047j() * this.f16531a) << 1;
        if (j > 0) {
            if (this.f16536f.capacity() < j) {
                ByteBuffer order = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
                this.f16536f = order;
                this.f16537g = order.asShortBuffer();
            } else {
                this.f16536f.clear();
                this.f16537g.clear();
            }
            this.f16533c.mo14044f(this.f16537g);
            this.f16540j += (long) j;
            this.f16536f.limit(j);
            this.f16538h = this.f16536f;
        }
    }

    public final boolean zzb(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new zzii(i, i2, i3);
        } else if (this.f16532b == i && this.f16531a == i2) {
            return false;
        } else {
            this.f16532b = i;
            this.f16531a = i2;
            return true;
        }
    }
}
