package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.measurement.o3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
class C2831o3 extends C2807l3 {

    /* renamed from: c */
    protected final byte[] f17400c;

    C2831o3(byte[] bArr) {
        bArr.getClass();
        this.f17400c = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo18780b(zzgo zzgo) {
        zzgo.zza(this.f17400c, mo18675g(), zza());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte mo18674c(int i) {
        return this.f17400c[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgr) || zza() != ((zzgr) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof C2831o3)) {
            return obj.equals(this);
        }
        C2831o3 o3Var = (C2831o3) obj;
        int zzd = zzd();
        int zzd2 = o3Var.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return mo18710f(o3Var, 0, zza());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo18710f(zzgr zzgr, int i, int i2) {
        if (i2 > zzgr.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzgr.zza()) {
            int zza2 = zzgr.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzgr instanceof C2831o3)) {
            return zzgr.zza(0, i2).equals(zza(0, i2));
        } else {
            C2831o3 o3Var = (C2831o3) zzgr;
            byte[] bArr = this.f17400c;
            byte[] bArr2 = o3Var.f17400c;
            int g = mo18675g() + i2;
            int g2 = mo18675g();
            int g3 = o3Var.mo18675g();
            while (g2 < g) {
                if (bArr[g2] != bArr2[g3]) {
                    return false;
                }
                g2++;
                g3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public int mo18675g() {
        return 0;
    }

    public byte zza(int i) {
        return this.f17400c[i];
    }

    public final boolean zzc() {
        int g = mo18675g();
        return C2794j6.m9536g(this.f17400c, g, zza() + g);
    }

    public int zza() {
        return this.f17400c.length;
    }

    public final zzgr zza(int i, int i2) {
        int d = zzgr.m10350d(0, i2, zza());
        if (d == 0) {
            return zzgr.zza;
        }
        return new C2783i3(this.f17400c, mo18675g(), d);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.f17400c, mo18675g(), zza(), charset);
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzic.m10382a(i, this.f17400c, mo18675g(), i3);
    }
}
