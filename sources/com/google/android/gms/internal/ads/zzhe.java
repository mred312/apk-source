package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzhe extends Exception {
    private zzhe(int i, String str, Throwable th, int i2) {
        super((String) null, th);
    }

    /* renamed from: a */
    static zzhe m8960a(RuntimeException runtimeException) {
        return new zzhe(2, (String) null, runtimeException, -1);
    }

    public static zzhe zza(Exception exc, int i) {
        return new zzhe(1, (String) null, exc, i);
    }

    public static zzhe zza(IOException iOException) {
        return new zzhe(0, (String) null, iOException, -1);
    }
}
