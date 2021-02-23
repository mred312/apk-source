package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public abstract class zzhd {

    /* renamed from: a */
    int f17661a;

    /* renamed from: b */
    int f17662b;

    /* renamed from: c */
    C2847q3 f17663c;

    private zzhd() {
        this.f17662b = 100;
    }

    /* renamed from: a */
    static zzhd m10358a(byte[] bArr, int i, int i2, boolean z) {
        C2855r3 r3Var = new C2855r3(bArr, i2);
        try {
            r3Var.zzc(i2);
            return r3Var;
        } catch (zzih e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract long mo18819b();

    public abstract int zza();

    public abstract void zza(int i);

    public abstract double zzb();

    public abstract boolean zzb(int i);

    public abstract float zzc();

    public abstract int zzc(int i);

    public abstract long zzd();

    public abstract void zzd(int i);

    public abstract long zze();

    public abstract int zzf();

    public abstract long zzg();

    public abstract int zzh();

    public abstract boolean zzi();

    public abstract String zzj();

    public abstract String zzk();

    public abstract zzgr zzl();

    public abstract int zzm();

    public abstract int zzn();

    public abstract int zzo();

    public abstract long zzp();

    public abstract int zzq();

    public abstract long zzr();

    public abstract boolean zzt();

    public abstract int zzu();
}
