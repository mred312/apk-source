package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdpp implements zzdpq {

    /* renamed from: a */
    private final Object[] f15865a;

    public zzdpp(zzvk zzvk, String str, int i, String str2, zzvw zzvw) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzvk.zzcgy));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(m8457a(zzvk.extras));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzvk.extras.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzvk.zzcgz));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzvk.zzcha;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzvk.zzchb));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzvk.zzadl));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzvk.zzbnx));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzvk.zzchc);
        }
        if (hashSet.contains(FirebaseAnalytics.Param.LOCATION)) {
            Location location = zzvk.zzmy;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzvk.zzche);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(m8457a(zzvk.zzchf));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(m8457a(zzvk.zzchg));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzvk.zzchh;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzvk.zzchi);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzvk.zzchj);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzvk.zzchk));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzvk.zzadm));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzvk.zzadn);
        }
        if (hashSet.contains(AdUnitActivity.EXTRA_ORIENTATION)) {
            if (zzvw != null) {
                arrayList.add(Integer.valueOf(zzvw.orientation));
            } else {
                arrayList.add((Object) null);
            }
        }
        this.f15865a = arrayList.toArray();
    }

    /* renamed from: a */
    private static String m8457a(@Nullable Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Bundle) {
                str = m8457a((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdpp)) {
            return false;
        }
        return Arrays.equals(this.f15865a, ((zzdpp) obj).f15865a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f15865a);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.f15865a);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
