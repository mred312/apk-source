package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmn implements zzepf<zzdyz<String>> {

    /* renamed from: a */
    private final zzeps<zzdro> f14599a;

    /* renamed from: b */
    private final zzeps<Context> f14600b;

    private zzcmn(zzeps<zzdro> zzeps, zzeps<Context> zzeps2) {
        this.f14599a = zzeps;
        this.f14600b = zzeps2;
    }

    public static zzcmn zzaq(zzeps<zzdro> zzeps, zzeps<Context> zzeps2) {
        return new zzcmn(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzdyz) zzepl.zza(this.f14599a.get().zzu(zzdrl.WEBVIEW_COOKIE).zzc(new C2216nl(zzp.zzks().zzbh(this.f14600b.get()))).zza(1, TimeUnit.SECONDS).zza(Exception.class, C2291pl.f10640a).zzaww(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
