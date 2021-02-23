package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzhv {
    public static final zzhv zzahx = new zzhv(1.0f, 1.0f);

    /* renamed from: a */
    private final int f16457a;
    public final float zzahy;
    public final float zzahz;

    public zzhv(float f, float f2) {
        this.zzahy = f;
        this.zzahz = f2;
        this.f16457a = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhv.class == obj.getClass()) {
            zzhv zzhv = (zzhv) obj;
            return this.zzahy == zzhv.zzahy && this.zzahz == zzhv.zzahz;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzahy) + 527) * 31) + Float.floatToRawIntBits(this.zzahz);
    }

    public final long zzdu(long j) {
        return j * ((long) this.f16457a);
    }
}
