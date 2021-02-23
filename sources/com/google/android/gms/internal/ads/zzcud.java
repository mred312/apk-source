package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzcud<AdT> implements zzcqz<AdT> {
    /* renamed from: a */
    private static Bundle m8272a(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    /* access modifiers changed from: protected */
    public abstract zzdyz<AdT> zza(zzdnn zzdnn, Bundle bundle);

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return !TextUtils.isEmpty(zzdmu.zzhha.optString("pubid", ""));
    }

    public final zzdyz<AdT> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzdmu zzdmu2 = zzdmu;
        String optString = zzdmu2.zzhha.optString("pubid", "");
        zzdnn zzdnn = zzdnj.zzhij.zzfvl;
        zzdnp zzgq = new zzdnp().zzc(zzdnn).zzgq(optString);
        Bundle a = m8272a(zzdnn.zzhio.zzchf);
        Bundle a2 = m8272a(a.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        a2.putInt("gw", 1);
        String optString2 = zzdmu2.zzhha.optString("mad_hac", (String) null);
        if (optString2 != null) {
            a2.putString("mad_hac", optString2);
        }
        String optString3 = zzdmu2.zzhha.optString("adJson", (String) null);
        if (optString3 != null) {
            a2.putString("_ad", optString3);
        }
        a2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdmu2.zzhhd.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdmu2.zzhhd.optString(next, (String) null);
            if (next != null) {
                a2.putString(next, optString4);
            }
        }
        a.putBundle("com.google.ads.mediation.admob.AdMobAdapter", a2);
        zzvk zzvk = zzdnn.zzhio;
        zzvk zzvk2 = r5;
        zzvk zzvk3 = new zzvk(zzvk.versionCode, zzvk.zzcgy, a2, zzvk.zzcgz, zzvk.zzcha, zzvk.zzchb, zzvk.zzadl, zzvk.zzbnx, zzvk.zzchc, zzvk.zzchd, zzvk.zzmy, zzvk.zzche, a, zzvk.zzchg, zzvk.zzchh, zzvk.zzchi, zzvk.zzchj, zzvk.zzchk, zzvk.zzchn, zzvk.zzadm, zzvk.zzadn, zzvk.zzchl, zzvk.zzchm);
        zzdnn zzaus = zzgq.zzh(zzvk2).zzaus();
        Bundle bundle = new Bundle();
        zzdnj zzdnj2 = zzdnj;
        zzdmz zzdmz = zzdnj2.zzhik.zzerj;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzdmz.zzdlv));
        bundle2.putInt("refresh_interval", zzdmz.zzhhx);
        bundle2.putString("gws_query_id", zzdmz.zzbvf);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdnj2.zzhij.zzfvl.zzhip;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzdmu zzdmu3 = zzdmu;
        bundle3.putString("allocation_id", zzdmu3.zzdkx);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzdmu3.zzdls));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzdmu3.zzdlt));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzdmu3.zzdup));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzdmu3.zzhgt));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzdmu3.zzdvc));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzdmu3.zzdvd));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzdmu3.zzhgs));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzdmu3.zzdli);
        bundle3.putString("valid_from_timestamp", zzdmu3.zzdlj);
        bundle3.putBoolean("is_closable_area_disabled", zzdmu3.zzbpc);
        if (zzdmu3.zzdvb != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdmu3.zzdvb.zzdxu);
            bundle4.putString("rb_type", zzdmu3.zzdvb.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzaus, bundle);
    }
}
