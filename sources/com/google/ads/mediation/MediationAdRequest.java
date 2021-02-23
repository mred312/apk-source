package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class MediationAdRequest {

    /* renamed from: a */
    private final Date f6954a;

    /* renamed from: b */
    private final AdRequest.Gender f6955b;

    /* renamed from: c */
    private final Set<String> f6956c;

    /* renamed from: d */
    private final boolean f6957d;

    /* renamed from: e */
    private final Location f6958e;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.f6954a = date;
        this.f6955b = gender;
        this.f6956c = set;
        this.f6957d = z;
        this.f6958e = location;
    }

    public Integer getAgeInYears() {
        if (this.f6954a == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f6954a);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.f6954a;
    }

    public AdRequest.Gender getGender() {
        return this.f6955b;
    }

    public Set<String> getKeywords() {
        return this.f6956c;
    }

    public Location getLocation() {
        return this.f6958e;
    }

    public boolean isTesting() {
        return this.f6957d;
    }
}
