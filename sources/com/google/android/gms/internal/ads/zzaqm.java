package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaqm {

    /* renamed from: a */
    private final zzbdv f12632a;

    /* renamed from: b */
    private final boolean f12633b;

    /* renamed from: c */
    private final String f12634c;

    public zzaqm(zzbdv zzbdv, Map<String, String> map) {
        this.f12632a = zzbdv;
        this.f12634c = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f12633b = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.f12633b = true;
        }
    }

    public final void execute() {
        int i;
        if (this.f12632a == null) {
            zzaza.zzfa("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.f12634c)) {
            zzp.zzks();
            i = 7;
        } else if ("landscape".equalsIgnoreCase(this.f12634c)) {
            zzp.zzks();
            i = 6;
        } else if (this.f12633b) {
            i = -1;
        } else {
            i = zzp.zzks().zzyj();
        }
        this.f12632a.setRequestedOrientation(i);
    }
}
