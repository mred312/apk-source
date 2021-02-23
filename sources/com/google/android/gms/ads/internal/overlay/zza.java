package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zza {
    public static boolean zza(Context context, zzb zzb, zzu zzu) {
        int i = 0;
        if (zzb == null) {
            zzaza.zzfa("No intent data for launcher overlay.");
            return false;
        }
        zzabf.initialize(context);
        Intent intent = zzb.intent;
        if (intent != null) {
            return zza(context, intent, zzu);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzb.url)) {
            zzaza.zzfa("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzb.mimeType)) {
            intent2.setDataAndType(Uri.parse(zzb.url), zzb.mimeType);
        } else {
            intent2.setData(Uri.parse(zzb.url));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzb.packageName)) {
            intent2.setPackage(zzb.packageName);
        }
        if (!TextUtils.isEmpty(zzb.zzdqd)) {
            String[] split = zzb.zzdqd.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzb.zzdqd);
                zzaza.zzfa(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzb.zzdqe;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzaza.zzfa("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcto)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctn)).booleanValue()) {
                zzp.zzkq();
                zzm.zzb(context, intent2);
            }
        }
        return zza(context, intent2, zzu);
    }

    private static boolean zza(Context context, Intent intent, zzu zzu) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzd.zzee(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzp.zzkq();
            zzm.zza(context, intent);
            if (zzu == null) {
                return true;
            }
            zzu.zzvo();
            return true;
        } catch (ActivityNotFoundException e) {
            zzaza.zzfa(e.getMessage());
            return false;
        }
    }
}
