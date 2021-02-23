package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzcuz extends zzcwb {

    /* renamed from: j */
    private zzbyi f14920j;

    public zzcuz(zzbrt zzbrt, zzbsl zzbsl, zzbsu zzbsu, zzbte zzbte, zzbsb zzbsb, zzbvy zzbvy, zzbyn zzbyn, zzbtr zzbtr, zzbyi zzbyi, zzbvv zzbvv) {
        super(zzbrt, zzbsl, zzbsu, zzbte, zzbvy, zzbtr, zzbyn, zzbvv, zzbsb);
        this.f14920j = zzbyi;
    }

    public final void onVideoEnd() {
        this.f14920j.zztm();
    }

    public final void zza(zzavc zzavc) {
        super.zza(zzavc);
        this.f14920j.zza(new zzava(zzavc.getType(), zzavc.getAmount()));
    }

    public final void zzb(zzava zzava) {
        super.zzb(zzava);
        this.f14920j.zza(zzava);
    }

    public final void zzun() {
        this.f14920j.zztl();
    }

    public final void zzuo() {
        this.f14920j.zztm();
    }
}
