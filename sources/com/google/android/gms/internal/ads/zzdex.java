package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdex implements zzdfi<zzdeu> {

    /* renamed from: a */
    private final zzdzc f15521a;

    /* renamed from: b */
    private final Context f15522b;

    /* renamed from: c */
    private final zzazh f15523c;

    public zzdex(zzdzc zzdzc, Context context, zzazh zzazh) {
        this.f15521a = zzdzc;
        this.f15522b = context;
        this.f15523c = zzazh;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdeu mo17091a() {
        boolean isCallerInstantApp = Wrappers.packageManager(this.f15522b).isCallerInstantApp();
        zzp.zzkq();
        boolean zzaw = zzm.zzaw(this.f15522b);
        String str = this.f15523c.zzbrf;
        zzp.zzks();
        boolean zzyl = zzu.zzyl();
        zzp.zzkq();
        return new zzdeu(isCallerInstantApp, zzaw, str, zzyl, zzm.zzat(this.f15522b), DynamiteModule.getRemoteVersion(this.f15522b, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.f15522b, ModuleDescriptor.MODULE_ID));
    }

    public final zzdyz<zzdeu> zzasm() {
        return this.f15521a.zze(new C1966gu(this));
    }
}
