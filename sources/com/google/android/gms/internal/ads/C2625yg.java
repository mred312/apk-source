package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.yg */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2625yg implements zzbod<zzboi> {

    /* renamed from: a */
    private final Map<String, zzcqz<zzboi>> f12197a;

    /* renamed from: b */
    private final Map<String, zzcqz<zzcbt>> f12198b;

    /* renamed from: c */
    private final Map<String, zzcto<zzcbt>> f12199c;

    /* renamed from: d */
    private final zzeps<zzbod<zzbme>> f12200d;

    /* renamed from: e */
    private final zzccl f12201e;

    C2625yg(Map<String, zzcqz<zzboi>> map, Map<String, zzcqz<zzcbt>> map2, Map<String, zzcto<zzcbt>> map3, zzeps<zzbod<zzbme>> zzeps, zzccl zzccl) {
        this.f12197a = map;
        this.f12198b = map2;
        this.f12199c = map3;
        this.f12200d = zzeps;
        this.f12201e = zzccl;
    }

    @Nullable
    public final zzcqz<zzboi> zze(int i, String str) {
        zzcqz zze;
        zzcqz<zzboi> zzcqz = this.f12197a.get(str);
        if (zzcqz != null) {
            return zzcqz;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzcto zzcto = this.f12199c.get(str);
            if (zzcto != null) {
                return zzboi.zza((zzcto<? extends zzboc>) zzcto);
            }
            zzcqz zzcqz2 = this.f12198b.get(str);
            if (zzcqz2 != null) {
                return zzboi.zza((zzcqz<? extends zzboc>) zzcqz2);
            }
            return null;
        } else if (this.f12201e.zzanu() == null || (zze = this.f12200d.get().zze(i, str)) == null) {
            return null;
        } else {
            return zzboi.zza((zzcqz<? extends zzboc>) zze);
        }
    }
}
