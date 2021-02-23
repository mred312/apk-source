package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaxm {
    @VisibleForTesting
    /* renamed from: a */
    private static Uri m7605a(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    /* renamed from: b */
    private static String m7606b(String str, Context context) {
        String zzac = zzp.zzlo().zzac(context);
        String zzad = zzp.zzlo().zzad(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzac)) {
            str = m7605a(str, "gmp_app_id", zzac).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzad)) ? str : m7605a(str, "fbs_aiid", zzad).toString();
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzp.zzlo().zzz(context)) {
            return uri.toString();
        }
        String zzae = zzp.zzlo().zzae(context);
        if (zzae == null) {
            return uri.toString();
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcno)).booleanValue()) {
            String str = (String) zzwq.zzqe().zzd(zzabf.zzcnp);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzp.zzlo().zzg(context, zzae);
                return m7606b(uri2, context).replace(str, zzae);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String uri3 = m7605a(m7606b(uri.toString(), context), "fbs_aeid", zzae).toString();
            zzp.zzlo().zzg(context, zzae);
            return uri3;
        }
        return uri.toString();
    }

    public static String zzc(String str, Context context, boolean z) {
        String zzae;
        if ((((Boolean) zzwq.zzqe().zzd(zzabf.zzcnw)).booleanValue() && !z) || !zzp.zzlo().zzz(context) || TextUtils.isEmpty(str) || (zzae = zzp.zzlo().zzae(context)) == null) {
            return str;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcno)).booleanValue()) {
            String str2 = (String) zzwq.zzqe().zzd(zzabf.zzcnp);
            if (!str.contains(str2)) {
                return str;
            }
            if (zzp.zzkq().zzel(str)) {
                zzp.zzlo().zzg(context, zzae);
                return m7606b(str, context).replace(str2, zzae);
            } else if (!zzp.zzkq().zzem(str)) {
                return str;
            } else {
                zzp.zzlo().zzh(context, zzae);
                return m7606b(str, context).replace(str2, zzae);
            }
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (zzp.zzkq().zzel(str)) {
                zzp.zzlo().zzg(context, zzae);
                return m7605a(m7606b(str, context), "fbs_aeid", zzae).toString();
            } else if (!zzp.zzkq().zzem(str)) {
                return str;
            } else {
                zzp.zzlo().zzh(context, zzae);
                return m7605a(m7606b(str, context), "fbs_aeid", zzae).toString();
            }
        }
    }
}
