package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ce0 implements zzif {

    /* renamed from: a */
    private int f7991a = -1;

    /* renamed from: b */
    private int f7992b = -1;

    /* renamed from: c */
    private int[] f7993c;

    /* renamed from: d */
    private boolean f7994d;

    /* renamed from: e */
    private int[] f7995e;

    /* renamed from: f */
    private ByteBuffer f7996f;

    /* renamed from: g */
    private ByteBuffer f7997g;

    /* renamed from: h */
    private boolean f7998h;

    public ce0() {
        ByteBuffer byteBuffer = zzif.zzaiw;
        this.f7996f = byteBuffer;
        this.f7997g = byteBuffer;
    }

    /* renamed from: a */
    public final void mo13768a(int[] iArr) {
        this.f7993c = iArr;
    }

    public final void flush() {
        this.f7997g = zzif.zzaiw;
        this.f7998h = false;
    }

    public final boolean isActive() {
        return this.f7994d;
    }

    public final void reset() {
        flush();
        this.f7996f = zzif.zzaiw;
        this.f7991a = -1;
        this.f7992b = -1;
        this.f7995e = null;
        this.f7994d = false;
    }

    public final boolean zzb(int i, int i2, int i3) {
        boolean z = !Arrays.equals(this.f7993c, this.f7995e);
        int[] iArr = this.f7993c;
        this.f7995e = iArr;
        if (iArr == null) {
            this.f7994d = false;
            return z;
        } else if (i3 != 2) {
            throw new zzii(i, i2, i3);
        } else if (!z && this.f7992b == i && this.f7991a == i2) {
            return false;
        } else {
            this.f7992b = i;
            this.f7991a = i2;
            this.f7994d = i2 != iArr.length;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.f7995e;
                if (i4 >= iArr2.length) {
                    return true;
                }
                int i5 = iArr2[i4];
                if (i5 < i2) {
                    this.f7994d = (i5 != i4) | this.f7994d;
                    i4++;
                } else {
                    throw new zzii(i, i2, i3);
                }
            }
        }
    }

    public final boolean zzfe() {
        return this.f7998h && this.f7997g == zzif.zzaiw;
    }

    public final int zzfj() {
        int[] iArr = this.f7995e;
        return iArr == null ? this.f7991a : iArr.length;
    }

    public final int zzfk() {
        return 2;
    }

    public final void zzfl() {
        this.f7998h = true;
    }

    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.f7997g;
        this.f7997g = zzif.zzaiw;
        return byteBuffer;
    }

    public final void zzn(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.f7991a * 2)) * this.f7995e.length) << 1;
        if (this.f7996f.capacity() < length) {
            this.f7996f = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f7996f.clear();
        }
        while (position < limit) {
            for (int i : this.f7995e) {
                this.f7996f.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.f7991a << 1;
        }
        byteBuffer.position(limit);
        this.f7996f.flip();
        this.f7997g = this.f7996f;
    }
}
