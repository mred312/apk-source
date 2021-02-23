package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.b9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1760b9 implements zzdyb {

    /* renamed from: a */
    private final Context f7880a;

    /* renamed from: b */
    private final zzef f7881b;

    /* renamed from: c */
    private final zzazh f7882c;

    /* renamed from: d */
    private final zzb f7883d;

    /* renamed from: e */
    private final String f7884e;

    C1760b9(Context context, zzef zzef, zzazh zzazh, zzb zzb, String str) {
        this.f7880a = context;
        this.f7881b = zzef;
        this.f7882c = zzazh;
        this.f7883d = zzb;
        this.f7884e = str;
    }

    public final zzdyz zzf(Object obj) {
        Context context = this.f7880a;
        zzef zzef = this.f7881b;
        zzazh zzazh = this.f7882c;
        zzb zzb = this.f7883d;
        String str = this.f7884e;
        zzp.zzkr();
        zzbdv zza = zzbed.zza(context, zzbfn.zzadv(), "", false, false, zzef, (zzacg) null, zzazh, (zzabs) null, (zzk) null, zzb, zzts.zzne(), (zzsu) null, false, (zzdmu) null, (zzdmz) null);
        zzazr zzl = zzazr.zzl(zza);
        zza.zzacs().zza((zzbfj) new C1797c9(zzl));
        zza.loadUrl(str);
        return zzl;
    }
}
