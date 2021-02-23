package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.util.zzm;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdnn {
    public final zzvn zzbpe;
    public final zzadz zzdnh;
    @Nullable
    public final zzajl zzdui;
    public final int zzgwz;
    public final boolean zzgyj;
    @Nullable
    public final zzxu zzhim;
    @Nullable
    public final zzaak zzhin;
    public final zzvk zzhio;
    public final String zzhip;
    public final ArrayList<String> zzhiq;
    public final ArrayList<String> zzhir;
    public final zzvw zzhis;
    public final PublisherAdViewOptions zzhit;
    public final zzxo zzhiu;
    public final zzdna zzhiv;

    private zzdnn(zzdnp zzdnp) {
        zzaak zzaak;
        zzadz zzadz;
        this.zzbpe = zzdnp.f15793b;
        this.zzhip = zzdnp.f15795d;
        this.zzhim = zzdnp.f15794c;
        this.zzhio = new zzvk(zzdnp.f15792a.versionCode, zzdnp.f15792a.zzcgy, zzdnp.f15792a.extras, zzdnp.f15792a.zzcgz, zzdnp.f15792a.zzcha, zzdnp.f15792a.zzchb, zzdnp.f15792a.zzadl, zzdnp.f15792a.zzbnx || zzdnp.f15797f, zzdnp.f15792a.zzchc, zzdnp.f15792a.zzchd, zzdnp.f15792a.zzmy, zzdnp.f15792a.zzche, zzdnp.f15792a.zzchf, zzdnp.f15792a.zzchg, zzdnp.f15792a.zzchh, zzdnp.f15792a.zzchi, zzdnp.f15792a.zzchj, zzdnp.f15792a.zzchk, zzdnp.f15792a.zzchn, zzdnp.f15792a.zzadm, zzdnp.f15792a.zzadn, zzdnp.f15792a.zzchl, zzm.zzdg(zzdnp.f15792a.zzchm));
        if (zzdnp.f15796e != null) {
            zzaak = zzdnp.f15796e;
        } else {
            zzaak = zzdnp.f15800i != null ? zzdnp.f15800i.zzdep : null;
        }
        this.zzhin = zzaak;
        this.zzhiq = zzdnp.f15798g;
        this.zzhir = zzdnp.f15799h;
        if (zzdnp.f15798g == null) {
            zzadz = null;
        } else if (zzdnp.f15800i == null) {
            zzadz = new zzadz(new NativeAdOptions.Builder().build());
        } else {
            zzadz = zzdnp.f15800i;
        }
        this.zzdnh = zzadz;
        this.zzhis = zzdnp.f15801j;
        this.zzgwz = zzdnp.f15804m;
        this.zzhit = zzdnp.f15802k;
        this.zzhiu = zzdnp.f15803l;
        this.zzdui = zzdnp.f15805n;
        this.zzhiv = new zzdna(zzdnp.f15806o);
        this.zzgyj = zzdnp.f15807p;
    }

    public final zzagd zzaun() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzhit;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzjv();
    }
}
