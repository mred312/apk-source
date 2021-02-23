package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbc implements zzdfi<Object> {

    /* renamed from: f */
    private static final Object f15161f = new Object();

    /* renamed from: a */
    private final String f15162a;

    /* renamed from: b */
    private final String f15163b;

    /* renamed from: c */
    private final zzbpo f15164c;

    /* renamed from: d */
    private final zzdon f15165d;

    /* renamed from: e */
    private final zzdnn f15166e;

    public zzdbc(String str, String str2, zzbpo zzbpo, zzdon zzdon, zzdnn zzdnn) {
        this.f15162a = str;
        this.f15163b = str2;
        this.f15164c = zzbpo;
        this.f15165d = zzdon;
        this.f15166e = zzdnn;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo17075a(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvm)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvl)).booleanValue()) {
                synchronized (f15161f) {
                    this.f15164c.zzf(this.f15166e.zzhio);
                    bundle2.putBundle("quality_signals", this.f15165d.zzauy());
                }
            } else {
                this.f15164c.zzf(this.f15166e.zzhio);
                bundle2.putBundle("quality_signals", this.f15165d.zzauy());
            }
        }
        bundle2.putString("seq_num", this.f15162a);
        bundle2.putString("session_id", this.f15163b);
    }

    public final zzdyz<Object> zzasm() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvm)).booleanValue()) {
            this.f15164c.zzf(this.f15166e.zzhio);
            bundle.putAll(this.f15165d.zzauy());
        }
        return zzdyr.zzag(new C2599xs(this, bundle));
    }
}
