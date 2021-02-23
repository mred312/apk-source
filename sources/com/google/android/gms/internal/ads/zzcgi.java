package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgi implements zzahv<Object> {
    @Nullable

    /* renamed from: a */
    private final zzafp f14321a;

    /* renamed from: b */
    private final zzcgh f14322b;

    /* renamed from: c */
    private final zzeoz<zzcgb> f14323c;

    public zzcgi(zzccl zzccl, zzcce zzcce, zzcgh zzcgh, zzeoz<zzcgb> zzeoz) {
        this.f14321a = zzccl.zzgb(zzcce.getCustomTemplateId());
        this.f14322b = zzcgh;
        this.f14323c = zzeoz;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.f14321a.zza(this.f14323c.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzaza.zzd(sb.toString(), e);
        }
    }

    public final void zzaov() {
        if (this.f14321a != null) {
            this.f14322b.zza("/nativeAdCustomClick", (zzahv<Object>) this);
        }
    }
}
