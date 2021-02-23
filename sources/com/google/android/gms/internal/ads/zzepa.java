package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepa {

    /* renamed from: j */
    private static final zzepa f16341j = new zzepa(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, -1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);

    /* renamed from: k */
    private static final zzepa f16342k = new zzepa(-1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, -1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);

    /* renamed from: l */
    private static final zzepa f16343l = new zzepa(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, -1.0d, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    public static final zzepa zziyq = new zzepa(1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);

    /* renamed from: a */
    private final double f16344a;

    /* renamed from: b */
    private final double f16345b;

    /* renamed from: c */
    private final double f16346c;

    /* renamed from: d */
    private final double f16347d;

    /* renamed from: e */
    private final double f16348e;

    /* renamed from: f */
    private final double f16349f;

    /* renamed from: g */
    private final double f16350g;

    /* renamed from: h */
    private final double f16351h;

    /* renamed from: i */
    private final double f16352i;

    private zzepa(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f16344a = d5;
        this.f16345b = d6;
        this.f16346c = d7;
        this.f16347d = d;
        this.f16348e = d2;
        this.f16349f = d3;
        this.f16350g = d4;
        this.f16351h = d8;
        this.f16352i = d9;
    }

    public static zzepa zzs(ByteBuffer byteBuffer) {
        double zzi = zzbq.zzi(byteBuffer);
        double zzi2 = zzbq.zzi(byteBuffer);
        double zzj = zzbq.zzj(byteBuffer);
        return new zzepa(zzi, zzi2, zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer), zzj, zzbq.zzj(byteBuffer), zzbq.zzj(byteBuffer), zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzepa.class != obj.getClass()) {
            return false;
        }
        zzepa zzepa = (zzepa) obj;
        return Double.compare(zzepa.f16347d, this.f16347d) == 0 && Double.compare(zzepa.f16348e, this.f16348e) == 0 && Double.compare(zzepa.f16349f, this.f16349f) == 0 && Double.compare(zzepa.f16350g, this.f16350g) == 0 && Double.compare(zzepa.f16351h, this.f16351h) == 0 && Double.compare(zzepa.f16352i, this.f16352i) == 0 && Double.compare(zzepa.f16344a, this.f16344a) == 0 && Double.compare(zzepa.f16345b, this.f16345b) == 0 && Double.compare(zzepa.f16346c, this.f16346c) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f16344a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f16345b);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f16346c);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f16347d);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f16348e);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f16349f);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f16350g);
        long doubleToLongBits8 = Double.doubleToLongBits(this.f16351h);
        long doubleToLongBits9 = Double.doubleToLongBits(this.f16352i);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zziyq)) {
            return "Rotate 0°";
        }
        if (equals(f16341j)) {
            return "Rotate 90°";
        }
        if (equals(f16342k)) {
            return "Rotate 180°";
        }
        if (equals(f16343l)) {
            return "Rotate 270°";
        }
        double d = this.f16344a;
        double d2 = this.f16345b;
        double d3 = this.f16346c;
        double d4 = this.f16347d;
        double d5 = this.f16348e;
        double d6 = this.f16349f;
        double d7 = this.f16350g;
        double d8 = this.f16351h;
        double d9 = this.f16352i;
        double d10 = d7;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d10);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }
}
