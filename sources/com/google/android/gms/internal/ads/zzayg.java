package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzi;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzayg {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f12926a = new Object();

    /* renamed from: b */
    private final zzi f12927b;

    /* renamed from: c */
    private final zzayq f12928c;

    /* renamed from: d */
    private boolean f12929d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f12930e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public zzazh f12931f;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: g */
    public zzabi f12932g;
    @Nullable

    /* renamed from: h */
    private Boolean f12933h;

    /* renamed from: i */
    private final AtomicInteger f12934i;

    /* renamed from: j */
    private final C2386s5 f12935j;

    /* renamed from: k */
    private final Object f12936k;
    @GuardedBy("grantedPermissionLock")

    /* renamed from: l */
    private zzdyz<ArrayList<String>> f12937l;

    public zzayg() {
        zzi zzi = new zzi();
        this.f12927b = zzi;
        this.f12928c = new zzayq(zzwq.zzqf(), zzi);
        this.f12929d = false;
        this.f12932g = null;
        this.f12933h = null;
        this.f12934i = new AtomicInteger(0);
        this.f12935j = new C2386s5((C2275p5) null);
        this.f12936k = new Object();
    }

    @TargetApi(16)
    /* renamed from: b */
    private static ArrayList<String> m7609b(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ ArrayList mo15864f() {
        return m7609b(zzauc.zzy(this.f12930e));
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.f12930e;
    }

    @Nullable
    public final Resources getResources() {
        if (this.f12931f.zzegn) {
            return this.f12930e.getResources();
        }
        try {
            zzazd.zzbv(this.f12930e).getResources();
            return null;
        } catch (zzazf e) {
            zzaza.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.f12926a) {
            this.f12933h = bool;
        }
    }

    public final void zzb(Throwable th, String str) {
        zzasn.zzc(this.f12930e, this.f12931f).zza(th, str, zzadg.zzddj.get().floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context, zzazh zzazh) {
        synchronized (this.f12926a) {
            if (!this.f12929d) {
                this.f12930e = context.getApplicationContext();
                this.f12931f = zzazh;
                zzp.zzkt().zza(this.f12928c);
                zzabi zzabi = null;
                this.f12927b.zza(this.f12930e, (String) null, true);
                zzasn.zzc(this.f12930e, this.f12931f);
                zzp.zzkz();
                if (!zzacu.zzdbr.get().booleanValue()) {
                    zzd.zzee("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzabi = new zzabi();
                }
                this.f12932g = zzabi;
                if (zzabi != null) {
                    zzazm.zza(new C2275p5(this).zzxl(), "AppState.registerCsiReporter");
                }
                this.f12929d = true;
                zzxa();
            }
        }
        zzp.zzkq().zzq(context, zzazh.zzbrf);
    }

    @Nullable
    public final zzabi zzwt() {
        zzabi zzabi;
        synchronized (this.f12926a) {
            zzabi = this.f12932g;
        }
        return zzabi;
    }

    public final Boolean zzwu() {
        Boolean bool;
        synchronized (this.f12926a) {
            bool = this.f12933h;
        }
        return bool;
    }

    public final void zzwv() {
        this.f12935j.mo14764a();
    }

    public final void zzww() {
        this.f12934i.incrementAndGet();
    }

    public final void zzwx() {
        this.f12934i.decrementAndGet();
    }

    public final int zzwy() {
        return this.f12934i.get();
    }

    public final zzf zzwz() {
        zzi zzi;
        synchronized (this.f12926a) {
            zzi = this.f12927b;
        }
        return zzi;
    }

    public final zzdyz<ArrayList<String>> zzxa() {
        if (PlatformVersion.isAtLeastJellyBean() && this.f12930e != null) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcrd)).booleanValue()) {
                synchronized (this.f12936k) {
                    zzdyz<ArrayList<String>> zzdyz = this.f12937l;
                    if (zzdyz != null) {
                        return zzdyz;
                    }
                    zzdyz<ArrayList<String>> zze = zzazj.zzegp.zze(new C2312q5(this));
                    this.f12937l = zze;
                    return zze;
                }
            }
        }
        return zzdyr.zzag(new ArrayList());
    }

    public final zzayq zzxb() {
        return this.f12928c;
    }

    public final void zza(Throwable th, String str) {
        zzasn.zzc(this.f12930e, this.f12931f).zza(th, str);
    }
}
