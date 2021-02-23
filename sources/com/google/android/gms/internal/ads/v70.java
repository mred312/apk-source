package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class v70 implements zzdzt {

    /* renamed from: a */
    private final t70 f11475a;

    /* renamed from: b */
    private final t70 f11476b;

    public v70(byte[] bArr) {
        this.f11475a = mo14897a(bArr, 1);
        this.f11476b = mo14897a(bArr, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract t70 mo14897a(byte[] bArr, int i);

    public byte[] zzc(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= (Integer.MAX_VALUE - this.f11475a.mo13540f()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.f11475a.mo13540f() + 16);
            if (allocate.remaining() >= bArr.length + this.f11475a.mo13540f() + 16) {
                int position = allocate.position();
                this.f11475a.mo14828b(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.f11475a.mo13540f()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.f11476b.mo14829h(bArr3, 0).get(bArr4);
                int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
                int remaining = allocate.remaining();
                int i = remaining % 16;
                int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
                ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(length);
                order.put(allocate);
                order.position(i2);
                order.putLong((long) bArr2.length);
                order.putLong((long) remaining);
                byte[] b = x70.m7158b(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(b);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
