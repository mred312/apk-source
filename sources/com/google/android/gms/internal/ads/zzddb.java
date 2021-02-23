package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddb implements zzdfi<zzdcy> {

    /* renamed from: a */
    private final zzdzc f15438a;
    @Nullable

    /* renamed from: b */
    private final ViewGroup f15439b;

    /* renamed from: c */
    private final Context f15440c;

    /* renamed from: d */
    private final Set<String> f15441d;

    public zzddb(zzdzc zzdzc, @Nullable ViewGroup viewGroup, Context context, Set<String> set) {
        this.f15438a = zzdzc;
        this.f15441d = set;
        this.f15439b = viewGroup;
        this.f15440c = context;
    }

    /* renamed from: b */
    private static Boolean m8346b(Activity activity) {
        Window window = activity.getWindow();
        if (window != null && (window.getAttributes().flags & 16777216) != 0) {
            return Boolean.TRUE;
        }
        try {
            boolean z = false;
            if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdcy mo17081a() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwe)).booleanValue() && this.f15439b != null && this.f15441d.contains("banner")) {
            return new zzdcy(Boolean.valueOf(this.f15439b.isHardwareAccelerated()));
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwf)).booleanValue() && this.f15441d.contains("native")) {
            Context context = this.f15440c;
            if (context instanceof Activity) {
                return new zzdcy(m8346b((Activity) context));
            }
        }
        return new zzdcy((Boolean) null);
    }

    public final zzdyz<zzdcy> zzasm() {
        return this.f15438a.zze(new C2299pt(this));
    }
}
