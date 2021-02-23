package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.p0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2270p0 implements zzahv<zzbdv> {
    C2270p0() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        zzp.zzkq();
        DisplayMetrics zza = zzm.zza((WindowManager) zzbdv.getContext().getSystemService("window"));
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzbdv).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbdv.zza("locationReady", hashMap);
        zzaza.zzfa("GET LOCATION COMPILED");
    }
}
