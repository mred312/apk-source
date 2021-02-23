package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbrb implements zzepf<zzbqz> {

    /* renamed from: a */
    private final zzeps<zzdro> f13712a;

    /* renamed from: b */
    private final zzeps<zzazh> f13713b;

    /* renamed from: c */
    private final zzeps<ApplicationInfo> f13714c;

    /* renamed from: d */
    private final zzeps<String> f13715d;

    /* renamed from: e */
    private final zzeps<List<String>> f13716e;

    /* renamed from: f */
    private final zzeps<PackageInfo> f13717f;

    /* renamed from: g */
    private final zzeps<zzdyz<String>> f13718g;

    /* renamed from: h */
    private final zzeps<zzf> f13719h;

    /* renamed from: i */
    private final zzeps<String> f13720i;

    /* renamed from: j */
    private final zzeps<zzdfl<Bundle>> f13721j;

    private zzbrb(zzeps<zzdro> zzeps, zzeps<zzazh> zzeps2, zzeps<ApplicationInfo> zzeps3, zzeps<String> zzeps4, zzeps<List<String>> zzeps5, zzeps<PackageInfo> zzeps6, zzeps<zzdyz<String>> zzeps7, zzeps<zzf> zzeps8, zzeps<String> zzeps9, zzeps<zzdfl<Bundle>> zzeps10) {
        this.f13712a = zzeps;
        this.f13713b = zzeps2;
        this.f13714c = zzeps3;
        this.f13715d = zzeps4;
        this.f13716e = zzeps5;
        this.f13717f = zzeps6;
        this.f13718g = zzeps7;
        this.f13719h = zzeps8;
        this.f13720i = zzeps9;
        this.f13721j = zzeps10;
    }

    public static zzbrb zza(zzeps<zzdro> zzeps, zzeps<zzazh> zzeps2, zzeps<ApplicationInfo> zzeps3, zzeps<String> zzeps4, zzeps<List<String>> zzeps5, zzeps<PackageInfo> zzeps6, zzeps<zzdyz<String>> zzeps7, zzeps<zzf> zzeps8, zzeps<String> zzeps9, zzeps<zzdfl<Bundle>> zzeps10) {
        return new zzbrb(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8, zzeps9, zzeps10);
    }

    public final /* synthetic */ Object get() {
        return new zzbqz(this.f13712a.get(), this.f13713b.get(), this.f13714c.get(), this.f13715d.get(), this.f13716e.get(), this.f13717f.get(), zzepg.zzat(this.f13718g), this.f13719h.get(), this.f13720i.get(), this.f13721j.get());
    }
}
