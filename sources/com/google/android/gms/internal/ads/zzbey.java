package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbey extends zzbdu {
    public zzbey(zzbdv zzbdv, zzts zzts, boolean z) {
        super(zzbdv, zzts, z);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbdv)) {
            zzaza.zzfa("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbdv zzbdv = (zzbdv) webView;
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            zzawq.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbdv.zzacs() != null) {
            zzbdv.zzacs().zzvf();
        }
        if (zzbdv.zzacq().zzady()) {
            str2 = (String) zzwq.zzqe().zzd(zzabf.zzcmz);
        } else if (zzbdv.zzacx()) {
            str2 = (String) zzwq.zzqe().zzd(zzabf.zzcmy);
        } else {
            str2 = (String) zzwq.zzqe().zzd(zzabf.zzcmx);
        }
        zzp.zzkq();
        return zzm.zzd(zzbdv.getContext(), zzbdv.zzaao().zzbrf, str2);
    }
}
