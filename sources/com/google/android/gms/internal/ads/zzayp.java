package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzayp {
    @GuardedBy("this")

    /* renamed from: a */
    private BigInteger f12956a = BigInteger.ONE;
    @GuardedBy("this")

    /* renamed from: b */
    private String f12957b = "0";

    public final synchronized String zzxj() {
        String bigInteger;
        bigInteger = this.f12956a.toString();
        this.f12956a = this.f12956a.add(BigInteger.ONE);
        this.f12957b = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzxk() {
        return this.f12957b;
    }
}
