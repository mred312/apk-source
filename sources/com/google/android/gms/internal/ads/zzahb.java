package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzahb implements zzahv<Object> {

    /* renamed from: a */
    private final zzaha f12462a;

    public zzahb(zzaha zzaha) {
        this.f12462a = zzaha;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzaza.zzfa("App event with no name parameter.");
        } else {
            this.f12462a.onAppEvent(str, map.get("info"));
        }
    }
}
