package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaon implements NativeMediationAdRequest {

    /* renamed from: a */
    private final Date f12580a;

    /* renamed from: b */
    private final int f12581b;

    /* renamed from: c */
    private final Set<String> f12582c;

    /* renamed from: d */
    private final boolean f12583d;

    /* renamed from: e */
    private final Location f12584e;

    /* renamed from: f */
    private final int f12585f;

    /* renamed from: g */
    private final zzadz f12586g;

    /* renamed from: h */
    private final List<String> f12587h = new ArrayList();

    /* renamed from: i */
    private final boolean f12588i;

    /* renamed from: j */
    private final Map<String, Boolean> f12589j = new HashMap();

    public zzaon(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzadz zzadz, List<String> list, boolean z2, int i3, String str) {
        this.f12580a = date;
        this.f12581b = i;
        this.f12582c = set;
        this.f12584e = location;
        this.f12583d = z;
        this.f12585f = i2;
        this.f12586g = zzadz;
        this.f12588i = z2;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.f12589j.put(split[1], Boolean.TRUE);
                        } else if ("false".equals(split[2])) {
                            this.f12589j.put(split[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.f12587h.add(next);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzzd.zzrb().zzqk();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f12580a;
    }

    @Deprecated
    public final int getGender() {
        return this.f12581b;
    }

    public final Set<String> getKeywords() {
        return this.f12582c;
    }

    public final Location getLocation() {
        return this.f12584e;
    }

    public final NativeAdOptions getNativeAdOptions() {
        zzaak zzaak;
        if (this.f12586g == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.f12586g.zzdeo).setImageOrientation(this.f12586g.zzbnm).setRequestMultipleImages(this.f12586g.zzbno);
        zzadz zzadz = this.f12586g;
        if (zzadz.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(zzadz.zzbnp);
        }
        zzadz zzadz2 = this.f12586g;
        if (zzadz2.versionCode >= 3 && (zzaak = zzadz2.zzdep) != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(zzaak));
        }
        return requestMultipleImages.build();
    }

    public final boolean isAdMuted() {
        return zzzd.zzrb().zzql();
    }

    public final boolean isAppInstallAdRequested() {
        List<String> list = this.f12587h;
        if (list != null) {
            return list.contains("2") || this.f12587h.contains("6");
        }
        return false;
    }

    public final boolean isContentAdRequested() {
        List<String> list = this.f12587h;
        if (list != null) {
            return list.contains("1") || this.f12587h.contains("6");
        }
        return false;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.f12588i;
    }

    public final boolean isTesting() {
        return this.f12583d;
    }

    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.f12587h;
        return list != null && list.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f12585f;
    }

    public final boolean zzuu() {
        List<String> list = this.f12587h;
        return list != null && list.contains("3");
    }

    public final Map<String, Boolean> zzuv() {
        return this.f12589j;
    }
}
