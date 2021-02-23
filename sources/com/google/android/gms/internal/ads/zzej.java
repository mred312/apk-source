package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzej extends zzcu<Integer, Long> {
    public long zzye;
    public long zzyf;

    public zzej() {
        this.zzye = -1;
        this.zzyf = -1;
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzcu.zzan(str);
        if (zzan != null) {
            this.zzye = ((Long) zzan.get(0)).longValue();
            this.zzyf = ((Long) zzan.get(1)).longValue();
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzye));
        hashMap.put(1, Long.valueOf(this.zzyf));
        return hashMap;
    }

    public zzej(String str) {
        this();
        zzam(str);
    }
}
