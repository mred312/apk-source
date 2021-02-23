package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzno extends zzhz {

    /* renamed from: d */
    private static final Object f16766d = new Object();

    /* renamed from: a */
    private final long f16767a;

    /* renamed from: b */
    private final long f16768b;

    /* renamed from: c */
    private final boolean f16769c;

    public zzno(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public final zzie zza(int i, zzie zzie, boolean z, long j) {
        zzpc.zzc(i, 0, 1);
        boolean z2 = this.f16769c;
        long j2 = this.f16768b;
        zzie.zzaie = null;
        zzie.zzaio = -9223372036854775807L;
        zzie.zzaip = -9223372036854775807L;
        zzie.zzaiq = z2;
        zzie.zzair = false;
        zzie.zzaiu = 0;
        zzie.zzaif = j2;
        zzie.zzais = 0;
        zzie.zzait = 0;
        zzie.zzaiv = 0;
        return zzie;
    }

    public final int zzc(Object obj) {
        return f16766d.equals(obj) ? 0 : -1;
    }

    public final int zzff() {
        return 1;
    }

    public final int zzfg() {
        return 1;
    }

    private zzno(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f16767a = j;
        this.f16768b = j2;
        this.f16769c = z;
    }

    public final zzib zza(int i, zzib zzib, boolean z) {
        zzpc.zzc(i, 0, 1);
        Object obj = z ? f16766d : null;
        return zzib.zza(obj, obj, 0, this.f16767a, 0, false);
    }
}
