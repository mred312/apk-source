package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqz {

    /* renamed from: a */
    private final zzdro f13699a;

    /* renamed from: b */
    private final zzazh f13700b;

    /* renamed from: c */
    private final ApplicationInfo f13701c;

    /* renamed from: d */
    private final String f13702d;

    /* renamed from: e */
    private final List<String> f13703e;

    /* renamed from: f */
    private final PackageInfo f13704f;

    /* renamed from: g */
    private final zzeoz<zzdyz<String>> f13705g;

    /* renamed from: h */
    private final zzf f13706h;

    /* renamed from: i */
    private final String f13707i;

    /* renamed from: j */
    private final zzdfl<Bundle> f13708j;

    public zzbqz(zzdro zzdro, zzazh zzazh, ApplicationInfo applicationInfo, String str, List<String> list, @Nullable PackageInfo packageInfo, zzeoz<zzdyz<String>> zzeoz, zzf zzf, String str2, zzdfl<Bundle> zzdfl) {
        this.f13699a = zzdro;
        this.f13700b = zzazh;
        this.f13701c = applicationInfo;
        this.f13702d = str;
        this.f13703e = list;
        this.f13704f = packageInfo;
        this.f13705g = zzeoz;
        this.f13706h = zzf;
        this.f13707i = str2;
        this.f13708j = zzdfl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzatl mo16415a(zzdyz zzdyz) {
        return new zzatl((Bundle) zzdyz.get(), this.f13700b, this.f13701c, this.f13702d, this.f13703e, this.f13704f, (String) this.f13705g.get().get(), this.f13706h.zzxt(), this.f13707i, (zzdpk) null, (String) null);
    }

    public final zzdyz<Bundle> zzakq() {
        return this.f13699a.zzu(zzdrl.SIGNALS).zze(this.f13708j.zzt(new Bundle())).zzaww();
    }

    public final zzdyz<zzatl> zzakr() {
        zzdyz<Bundle> zzakq = zzakq();
        return this.f13699a.zza(zzdrl.REQUEST_PARCEL, (zzdyz<?>[]) new zzdyz[]{zzakq, this.f13705g.get()}).zzb(new C1801cd(this, zzakq)).zzaww();
    }
}
