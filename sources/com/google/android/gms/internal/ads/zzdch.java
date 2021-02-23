package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdch implements zzdfj<Bundle> {
    @Nullable

    /* renamed from: a */
    private final Location f15419a;

    public zzdch(@Nullable Location location) {
        this.f15419a = location;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.f15419a != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", this.f15419a.getAccuracy() * 1000.0f);
            bundle2.putLong("lat", (long) (this.f15419a.getLatitude() * 1.0E7d));
            bundle2.putLong("long", (long) (this.f15419a.getLongitude() * 1.0E7d));
            bundle2.putLong("time", this.f15419a.getTime() * 1000);
            bundle.putBundle("uule", bundle2);
        }
    }
}
