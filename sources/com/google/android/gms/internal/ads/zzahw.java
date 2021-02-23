package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzahw implements zzahv<zzbdv> {

    /* renamed from: d */
    private static final Map<String, Integer> f12463d = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});

    /* renamed from: a */
    private final zza f12464a;

    /* renamed from: b */
    private final zzaqk f12465b;

    /* renamed from: c */
    private final zzaqx f12466c;

    public zzahw(zza zza, zzaqk zzaqk, zzaqx zzaqx) {
        this.f12464a = zza;
        this.f12465b = zzaqk;
        this.f12466c = zzaqx;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zza zza;
        zzbdv zzbdv = (zzbdv) obj;
        int intValue = f12463d.get((String) map.get("a")).intValue();
        if (intValue != 5 && intValue != 7 && (zza = this.f12464a) != null && !zza.zzjy()) {
            this.f12464a.zzbk((String) null);
        } else if (intValue == 1) {
            this.f12465b.zzg(map);
        } else if (intValue == 3) {
            new zzaqp(zzbdv, map).execute();
        } else if (intValue == 4) {
            new zzaqj(zzbdv, map).execute();
        } else if (intValue == 5) {
            new zzaqm(zzbdv, map).execute();
        } else if (intValue == 6) {
            this.f12465b.zzac(true);
        } else if (intValue != 7) {
            zzaza.zzez("Unknown MRAID command called.");
        } else {
            this.f12466c.zzvb();
        }
    }
}
