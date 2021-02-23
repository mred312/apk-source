package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzahx implements zzahv<Object> {

    /* renamed from: a */
    private final Context f12467a;

    public zzahx(Context context) {
        this.f12467a = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzp.zzlo().zzz(this.f12467a)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 94399:
                    if (str.equals("_aa")) {
                        c = 0;
                        break;
                    }
                    break;
                case 94401:
                    if (str.equals("_ac")) {
                        c = 1;
                        break;
                    }
                    break;
                case 94407:
                    if (str.equals("_ai")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    zzp.zzlo().zzj(this.f12467a, str2);
                    return;
                case 1:
                    zzp.zzlo().zzg(this.f12467a, str2);
                    return;
                case 2:
                    zzp.zzlo().zzh(this.f12467a, str2);
                    return;
                default:
                    zzaza.zzey("logScionEvent gmsg contained unsupported eventName");
                    return;
            }
        }
    }
}
