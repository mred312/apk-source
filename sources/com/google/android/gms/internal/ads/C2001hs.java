package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.google.android.gms.internal.ads.hs */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2001hs implements zzdyb {

    /* renamed from: a */
    private final zzatl f9235a;

    C2001hs(zzatl zzatl) {
        this.f9235a = zzatl;
    }

    public final zzdyz zzf(Object obj) {
        zzatl zzatl = this.f9235a;
        zzczx zzczx = new zzczx(new JsonReader(new InputStreamReader((InputStream) obj)));
        zzczx.mo17070a(zzatl.zzdvx);
        return zzdyr.zzag(zzczx);
    }
}
