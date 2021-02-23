package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabt {

    /* renamed from: a */
    private final Map<String, zzabq> f12370a = new HashMap();
    @Nullable

    /* renamed from: b */
    private final zzabs f12371b;

    public zzabt(@Nullable zzabs zzabs) {
        this.f12371b = zzabs;
    }

    public final void zza(String str, zzabq zzabq) {
        this.f12370a.put(str, zzabq);
    }

    public final void zzb(String str, String str2, long j) {
        zzabq zzabq;
        zzabs zzabs = this.f12371b;
        zzabq zzabq2 = this.f12370a.get(str2);
        String[] strArr = {str};
        if (!(zzabs == null || zzabq2 == null)) {
            zzabs.zza(zzabq2, j, strArr);
        }
        Map<String, zzabq> map = this.f12370a;
        zzabs zzabs2 = this.f12371b;
        if (zzabs2 == null) {
            zzabq = null;
        } else {
            zzabq = zzabs2.zzex(j);
        }
        map.put(str, zzabq);
    }

    @Nullable
    public final zzabs zzry() {
        return this.f12371b;
    }
}
