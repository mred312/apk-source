package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbft {
    public static zzbdv zza(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, @Nullable zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        try {
            return (zzbdv) zzbu.zza(new C2390s9(context, zzbfn, str, z, z2, zzef, zzacg, zzazh, (zzabs) null, zzk, zzb, zzts, zzsu, z3, zzdmu, zzdmz));
        } catch (Throwable th) {
            zzp.zzku().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbeh("Webview initialization failed.", th);
        }
    }
}
