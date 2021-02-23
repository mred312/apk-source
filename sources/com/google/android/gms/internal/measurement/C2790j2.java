package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.j2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2790j2 {
    /* renamed from: a */
    static int m9519a(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }

    /* renamed from: b */
    static int m9520b(@NullableDecl Object obj) {
        return m9519a(obj == null ? 0 : obj.hashCode());
    }
}
