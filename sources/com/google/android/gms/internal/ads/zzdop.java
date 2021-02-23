package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzi;
import com.google.android.gms.ads.internal.util.zzj;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdop {

    /* renamed from: a */
    private final Map<String, zzdor> f15826a = new HashMap();

    /* renamed from: b */
    private final Context f15827b;

    /* renamed from: c */
    private final zzayg f15828c;

    public zzdop(Context context, zzazh zzazh, zzayg zzayg) {
        this.f15827b = context;
        this.f15828c = zzayg;
    }

    /* renamed from: a */
    private final zzdor m8443a() {
        return new zzdor(this.f15827b, this.f15828c.zzwz(), this.f15828c.zzxb());
    }

    /* renamed from: b */
    private final zzdor m8444b(String str) {
        zzauc zzx = zzauc.zzx(this.f15827b);
        try {
            zzx.setAppPackageName(str);
            zzi zzi = new zzi();
            zzi.zza(this.f15827b, str, false);
            zzj zzj = new zzj(this.f15828c.zzwz(), zzi);
            return new zzdor(zzx, zzj, new zzayq(zzayr.zzzf(), zzj));
        } catch (PackageManager.NameNotFoundException unused) {
            return m8443a();
        }
    }

    public final zzdor zzgs(@Nullable String str) {
        if (str == null) {
            return m8443a();
        }
        if (this.f15826a.containsKey(str)) {
            return this.f15826a.get(str);
        }
        zzdor b = m8444b(str);
        this.f15826a.put(str, b);
        return b;
    }
}
