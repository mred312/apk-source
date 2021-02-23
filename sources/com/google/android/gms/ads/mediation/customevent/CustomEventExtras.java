package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> zzeuy = new HashMap<>();

    public final Object getExtra(String str) {
        return this.zzeuy.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.zzeuy.put(str, obj);
    }
}
