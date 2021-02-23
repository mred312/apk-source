package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaof implements MediationAdRequest {

    /* renamed from: a */
    private final Date f12563a;

    /* renamed from: b */
    private final int f12564b;

    /* renamed from: c */
    private final Set<String> f12565c;

    /* renamed from: d */
    private final boolean f12566d;

    /* renamed from: e */
    private final Location f12567e;

    /* renamed from: f */
    private final int f12568f;

    /* renamed from: g */
    private final boolean f12569g;

    public zzaof(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.f12563a = date;
        this.f12564b = i;
        this.f12565c = set;
        this.f12567e = location;
        this.f12566d = z;
        this.f12568f = i2;
        this.f12569g = z2;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f12563a;
    }

    @Deprecated
    public final int getGender() {
        return this.f12564b;
    }

    public final Set<String> getKeywords() {
        return this.f12565c;
    }

    public final Location getLocation() {
        return this.f12567e;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.f12569g;
    }

    public final boolean isTesting() {
        return this.f12566d;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f12568f;
    }
}
