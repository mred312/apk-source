package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdaa implements zzdfj<Bundle> {

    /* renamed from: a */
    private final zzdnn f15115a;

    public zzdaa(zzdnn zzdnn) {
        Preconditions.checkNotNull(zzdnn, "the targeting must not be null");
        this.f15115a = zzdnn;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzvk zzvk = this.f15115a.zzhio;
        bundle.putInt("http_timeout_millis", zzvk.zzchm);
        bundle.putString("slotname", this.f15115a.zzhip);
        boolean z = true;
        int i = C2149ls.f9887a[this.f15115a.zzhiv.zzhia - 1];
        if (i == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        zzdnx.zza(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzvk.zzcgy)), zzvk.zzcgy != -1);
        zzdnx.zza(bundle, "extras", zzvk.extras);
        zzdnx.zza(bundle, "cust_gender", Integer.valueOf(zzvk.zzcgz), zzvk.zzcgz != -1);
        zzdnx.zza(bundle, "kw", zzvk.zzcha);
        zzdnx.zza(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zzvk.zzadl), zzvk.zzadl != -1);
        boolean z2 = zzvk.zzchb;
        if (z2) {
            bundle.putBoolean("test_request", z2);
        }
        zzdnx.zza(bundle, "d_imp_hdr", (Integer) 1, zzvk.versionCode >= 2 && zzvk.zzbnx);
        String str = zzvk.zzchc;
        zzdnx.zza(bundle, "ppid", str, zzvk.versionCode >= 2 && !TextUtils.isEmpty(str));
        Location location = zzvk.zzmy;
        if (location != null) {
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", valueOf.floatValue());
            bundle2.putLong("lat", valueOf3.longValue());
            bundle2.putLong("long", valueOf4.longValue());
            bundle2.putLong("time", valueOf2.longValue());
            bundle.putBundle("uule", bundle2);
        }
        zzdnx.zza(bundle, ImagesContract.URL, zzvk.zzche);
        zzdnx.zza(bundle, "neighboring_content_urls", zzvk.zzchl);
        zzdnx.zza(bundle, "custom_targeting", zzvk.zzchg);
        zzdnx.zza(bundle, "category_exclusions", zzvk.zzchh);
        zzdnx.zza(bundle, "request_agent", zzvk.zzchi);
        zzdnx.zza(bundle, "request_pkg", zzvk.zzchj);
        zzdnx.zza(bundle, "is_designed_for_families", Boolean.valueOf(zzvk.zzchk), zzvk.versionCode >= 7);
        if (zzvk.versionCode >= 8) {
            Integer valueOf5 = Integer.valueOf(zzvk.zzadm);
            if (zzvk.zzadm == -1) {
                z = false;
            }
            zzdnx.zza(bundle, "tag_for_under_age_of_consent", valueOf5, z);
            zzdnx.zza(bundle, "max_ad_content_rating", zzvk.zzadn);
        }
    }
}
