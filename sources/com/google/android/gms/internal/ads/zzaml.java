package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaml {
    @VisibleForTesting

    /* renamed from: b */
    private static final zzau<zzako> f12525b = new C2160m2();
    @VisibleForTesting

    /* renamed from: c */
    private static final zzau<zzako> f12526c = new C2197n2();

    /* renamed from: a */
    private final zzalb f12527a;

    public zzaml(Context context, zzazh zzazh, String str) {
        this.f12527a = new zzalb(context, zzazh, str, f12525b, f12526c);
    }

    public final <I, O> zzamd<I, O> zza(String str, zzame<I> zzame, zzamf<O> zzamf) {
        return new zzamm(this.f12527a, str, zzame, zzamf);
    }

    public final zzamq zzua() {
        return new zzamq(this.f12527a);
    }
}
