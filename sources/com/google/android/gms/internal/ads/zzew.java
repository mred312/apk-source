package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzew extends zzcu<Integer, Object> {
    public Long zzyn;
    public Boolean zzyo;
    public Boolean zzyp;

    public zzew() {
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzcu.zzan(str);
        if (zzan != null) {
            this.zzyn = (Long) zzan.get(0);
            this.zzyo = (Boolean) zzan.get(1);
            this.zzyp = (Boolean) zzan.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbn() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyn);
        hashMap.put(1, this.zzyo);
        hashMap.put(2, this.zzyp);
        return hashMap;
    }

    public zzew(String str) {
        zzam(str);
    }
}
