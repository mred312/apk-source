package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class sj0 extends zzwx {

    /* renamed from: a */
    final /* synthetic */ zzzo f11092a;

    private sj0(zzzo zzzo) {
        this.f11092a = zzzo;
    }

    public final String getMediationAdapterClassName() {
        return null;
    }

    public final boolean isLoading() {
        return false;
    }

    public final void zza(zzvk zzvk, int i) {
        zzaza.zzey("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzayr.zzzz.post(new uj0(this));
    }

    public final void zzb(zzvk zzvk) {
        zza(zzvk, 1);
    }

    public final String zzkg() {
        return null;
    }
}
