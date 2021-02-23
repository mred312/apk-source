package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zztt {

    /* renamed from: a */
    private final InputStream f17009a;

    /* renamed from: b */
    private final boolean f17010b;

    /* renamed from: c */
    private final boolean f17011c;

    /* renamed from: d */
    private final long f17012d;

    /* renamed from: e */
    private final boolean f17013e;

    private zztt(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        this.f17009a = inputStream;
        this.f17010b = z;
        this.f17011c = z2;
        this.f17012d = j;
        this.f17013e = z3;
    }

    public static zztt zza(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        return new zztt(inputStream, z, z2, j, z3);
    }

    public final InputStream getInputStream() {
        return this.f17009a;
    }

    public final boolean zzmy() {
        return this.f17010b;
    }

    public final boolean zzmz() {
        return this.f17013e;
    }

    public final long zzna() {
        return this.f17012d;
    }

    public final boolean zznb() {
        return this.f17011c;
    }
}
