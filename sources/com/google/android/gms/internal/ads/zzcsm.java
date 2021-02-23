package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsm implements zzcqz<zzbyx> {

    /* renamed from: a */
    private final Context f14788a;

    /* renamed from: b */
    private final zzbzx f14789b;

    /* renamed from: c */
    private final Executor f14790c;

    /* renamed from: d */
    private final zzdms f14791d;

    public zzcsm(Context context, Executor executor, zzbzx zzbzx, zzdms zzdms) {
        this.f14788a = context;
        this.f14789b = zzbzx;
        this.f14790c = executor;
        this.f14791d = zzdms;
    }

    /* renamed from: b */
    private static String m8258b(zzdmu zzdmu) {
        try {
            return zzdmu.zzhha.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16990a(Uri uri, zzdnj zzdnj, zzdmu zzdmu, Object obj) {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzb zzb = new zzb(build.intent);
            zzazq zzazq = new zzazq();
            zzbyz zza = this.f14789b.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbzc(new C2446to(zzazq)));
            zzazq.set(new AdOverlayInfoParcel(zzb, (zzva) null, zza.zzahi(), (zzu) null, new zzazh(0, 0, false)));
            this.f14791d.zzwv();
            return zzdyr.zzag(zza.zzahh());
        } catch (Throwable th) {
            zzaza.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (this.f14788a instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacf.zzj(this.f14788a) && !TextUtils.isEmpty(m8258b(zzdmu));
    }

    public final zzdyz<zzbyx> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        String b = m8258b(zzdmu);
        return zzdyr.zzb(zzdyr.zzag(null), new C2409so(this, b != null ? Uri.parse(b) : null, zzdnj, zzdmu), this.f14790c);
    }
}
