package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbnh implements zzepf<Boolean> {

    /* renamed from: a */
    private final zzeps<zzdnn> f13532a;

    public zzbnh(zzeps<zzdnn> zzeps) {
        this.f13532a = zzeps;
    }

    public final /* synthetic */ Object get() {
        boolean z;
        if (this.f13532a.get().zzaun() != null) {
            z = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcpc)).booleanValue();
        } else {
            z = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcvk)).booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
