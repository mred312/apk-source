package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzdvx {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzdvd f15998a;

    /* renamed from: b */
    private final y10 f15999b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f16000c;

    private zzdvx(y10 y10) {
        this(y10, false, o10.f10243b, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final Iterator<String> m8533d(CharSequence charSequence) {
        return this.f15999b.mo14855a(this, charSequence);
    }

    public static zzdvx zza(zzdvd zzdvd) {
        zzdvv.checkNotNull(zzdvd);
        return new zzdvx(new u10(zzdvd));
    }

    private zzdvx(y10 y10, boolean z, zzdvd zzdvd, int i) {
        this.f15999b = y10;
        this.f15998a = zzdvd;
        this.f16000c = Integer.MAX_VALUE;
    }

    public final Iterable<String> zza(CharSequence charSequence) {
        zzdvv.checkNotNull(charSequence);
        return new v10(this, charSequence);
    }
}
