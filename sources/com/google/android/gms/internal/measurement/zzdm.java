package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzdm {

    /* renamed from: a */
    final Uri f17635a;

    /* renamed from: b */
    final String f17636b;

    /* renamed from: c */
    final String f17637c;

    public zzdm(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzdw<Context, Boolean>) null);
    }

    public final zzdh<Long> zza(String str, long j) {
        return zzdh.m10314i(this, str, j, true);
    }

    private zzdm(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzdw<Context, Boolean> zzdw) {
        this.f17635a = uri;
        this.f17636b = str2;
        this.f17637c = str3;
    }

    public final zzdh<Boolean> zza(String str, boolean z) {
        return zzdh.m10316k(this, str, z, true);
    }

    public final zzdh<Double> zza(String str, double d) {
        return zzdh.m10313h(this, str, -3.0d, true);
    }

    public final zzdh<String> zza(String str, String str2) {
        return zzdh.m10315j(this, str, str2, true);
    }
}
