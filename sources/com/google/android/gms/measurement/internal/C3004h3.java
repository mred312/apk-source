package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

@WorkerThread
/* renamed from: com.google.android.gms.measurement.internal.h3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3004h3 implements Runnable {

    /* renamed from: a */
    private final C2974e3 f18107a;

    /* renamed from: b */
    private final int f18108b;

    /* renamed from: c */
    private final Throwable f18109c;

    /* renamed from: d */
    private final byte[] f18110d;

    /* renamed from: e */
    private final String f18111e;

    /* renamed from: f */
    private final Map<String, List<String>> f18112f;

    private C3004h3(String str, C2974e3 e3Var, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(e3Var);
        this.f18107a = e3Var;
        this.f18108b = i;
        this.f18109c = th;
        this.f18110d = bArr;
        this.f18111e = str;
        this.f18112f = map;
    }

    public final void run() {
        this.f18107a.mo19900a(this.f18111e, this.f18108b, this.f18109c, this.f18110d, this.f18112f);
    }
}
