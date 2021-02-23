package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdek implements zzdfi<zzdel> {

    /* renamed from: a */
    private final zzdzc f15488a;

    /* renamed from: b */
    private final ScheduledExecutorService f15489b;

    /* renamed from: c */
    private final zzcwz f15490c;

    /* renamed from: d */
    private final Context f15491d;

    /* renamed from: e */
    private final zzdnn f15492e;

    /* renamed from: f */
    private final zzcwx f15493f;

    /* renamed from: g */
    private String f15494g;

    public zzdek(zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, String str, zzcwz zzcwz, Context context, zzdnn zzdnn, zzcwx zzcwx) {
        this.f15488a = zzdzc;
        this.f15489b = scheduledExecutorService;
        this.f15494g = str;
        this.f15490c = zzcwz;
        this.f15491d = context;
        this.f15492e = zzdnn;
        this.f15493f = zzcwx;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo17088a(String str, List list, Bundle bundle) {
        zzazq zzazq = new zzazq();
        this.f15493f.zzgl(str);
        zzapo zzgm = this.f15493f.zzgm(str);
        zzgm.getClass();
        Bundle bundle2 = bundle;
        zzgm.zza(ObjectWrapper.wrap(this.f15491d), this.f15494g, bundle2, (Bundle) list.get(0), this.f15492e.zzbpe, (zzapt) new zzcxf(str, zzgm, zzazq));
        return zzazq;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo17089b() {
        Map<String, List<Bundle>> zzt = this.f15490c.zzt(this.f15494g, this.f15492e.zzhip);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : zzt.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            Bundle bundle = this.f15492e.zzhio.zzchf;
            arrayList.add(zzdyi.zzg(zzdyr.zza(new C1781bu(this, str, list, bundle != null ? bundle.getBundle(str) : null), this.f15488a)).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcqb)).longValue(), TimeUnit.MILLISECONDS, this.f15489b).zza(Throwable.class, new C1892eu(str), (Executor) this.f15488a));
        }
        return zzdyr.zzk(arrayList).zza(new C1855du(arrayList), this.f15488a);
    }

    public final zzdyz<zzdel> zzasm() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqc)).booleanValue()) {
            return zzdyr.zza(new C1818cu(this), this.f15488a);
        }
        return zzdyr.zzag(null);
    }
}
