package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public abstract class zzgr implements Serializable, Iterable<Byte> {

    /* renamed from: b */
    private static final C2799k3 f17656b = (C2723b3.m9321b() ? new C2823n3((C2767g3) null) : new C2791j3((C2767g3) null));
    public static final zzgr zza = new C2831o3(zzic.zzb);

    /* renamed from: a */
    private int f17657a = 0;

    zzgr() {
    }

    /* renamed from: a */
    static zzgr m10349a(byte[] bArr) {
        return new C2831o3(bArr);
    }

    /* renamed from: d */
    static int m10350d(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    /* renamed from: e */
    static C2815m3 m10351e(int i) {
        return new C2815m3(i, (C2767g3) null);
    }

    public static zzgr zza(byte[] bArr, int i, int i2) {
        m10350d(i, i + i2, bArr.length);
        return new C2831o3(f17656b.zza(bArr, i, i2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo18780b(zzgo zzgo);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract byte mo18674c(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f17657a;
        if (i == 0) {
            int zza2 = zza();
            i = zza(zza2, 0, zza2);
            if (i == 0) {
                i = 1;
            }
            this.f17657a = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new C2767g3(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? C2911y5.m10004a(this) : String.valueOf(C2911y5.m10004a(zza(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    public abstract int zza();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzgr zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzic.f17731a);
    }

    public abstract boolean zzc();

    /* access modifiers changed from: protected */
    public final int zzd() {
        return this.f17657a;
    }

    public static zzgr zza(String str) {
        return new C2831o3(str.getBytes(zzic.f17731a));
    }
}
