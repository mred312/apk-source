package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzca;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.lv */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2152lv implements Callable {

    /* renamed from: a */
    static final Callable f9889a = new C2152lv();

    private C2152lv() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzwq.zzqe().zzd(zzabf.zzcmu);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcmv)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzca.zzes(str2));
                }
            }
        }
        return new zzdhx(hashMap);
    }
}
