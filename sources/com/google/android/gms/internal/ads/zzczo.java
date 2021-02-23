package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzue;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzczo {

    /* renamed from: a */
    private String f15096a;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f15097a;

        public final zza zzgp(String str) {
            this.f15097a = str;
            return this;
        }
    }

    private zzczo(zza zza2) {
        this.f15096a = zza2.f15097a;
    }

    public final Set<String> zzasj() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.f15096a.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzask() {
        return this.f15096a.toLowerCase(Locale.ROOT);
    }

    public final zzue.zza.C3992zza zzasl() {
        String str = this.f15096a;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c = 0;
                    break;
                }
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c = 1;
                    break;
                }
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c = 2;
                    break;
                }
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return zzue.zza.C3992zza.AD_LOADER;
            case 1:
                return zzue.zza.C3992zza.INTERSTITIAL;
            case 2:
                return zzue.zza.C3992zza.REWARD_BASED_VIDEO_AD;
            case 3:
                return zzue.zza.C3992zza.BANNER;
            default:
                return zzue.zza.C3992zza.AD_INITIATER_UNSPECIFIED;
        }
    }
}
