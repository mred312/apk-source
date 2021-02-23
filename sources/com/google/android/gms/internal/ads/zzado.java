package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzado {

    /* renamed from: a */
    private static final AtomicReference<zzadp> f12388a = new AtomicReference<>();

    /* renamed from: b */
    static final AtomicBoolean f12389b = new AtomicBoolean();

    /* renamed from: a */
    static zzadp m7436a() {
        return f12388a.get();
    }

    public static void zza(zzadp zzadp) {
        f12388a.set(zzadp);
    }
}
