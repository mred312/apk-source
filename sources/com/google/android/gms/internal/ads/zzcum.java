package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcum {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Clock f14892a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzcuo f14893b;

    /* renamed from: c */
    private final List<String> f14894c = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final boolean f14895d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzcrg f14896e;

    public zzcum(Clock clock, zzcuo zzcuo, zzcrg zzcrg) {
        this.f14892a = clock;
        this.f14893b = zzcuo;
        this.f14895d = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcxx)).booleanValue();
        this.f14896e = zzcrg;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m8275d(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.f14894c.add(sb2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final <T> zzdyz<T> mo17005b(zzdmz zzdmz, zzdmu zzdmu, zzdyz<T> zzdyz) {
        long elapsedRealtime = this.f14892a.elapsedRealtime();
        String str = zzdmu.zzdkx;
        if (str != null) {
            zzdyr.zza(zzdyz, new C2295pp(this, elapsedRealtime, str, zzdmu, zzdmz), zzazj.zzegu);
        }
        return zzdyz;
    }

    public final String zzarn() {
        return TextUtils.join("_", this.f14894c);
    }
}
