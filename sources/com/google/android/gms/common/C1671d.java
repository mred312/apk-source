package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.d */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
abstract class C1671d extends C1663b {

    /* renamed from: c */
    private static final WeakReference<byte[]> f7502c = new WeakReference<>((Object) null);

    /* renamed from: b */
    private WeakReference<byte[]> f7503b = f7502c;

    C1671d(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final byte[] mo12860a() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f7503b.get();
            if (bArr == null) {
                bArr = mo12876c();
                this.f7503b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract byte[] mo12876c();
}
