package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class n00 extends zzdsj {

    /* renamed from: a */
    private final String f10025a;

    /* renamed from: b */
    private final boolean f10026b;

    /* renamed from: c */
    private final boolean f10027c;

    private n00(String str, boolean z, boolean z2) {
        this.f10025a = str;
        this.f10026b = z;
        this.f10027c = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdsj) {
            zzdsj zzdsj = (zzdsj) obj;
            return this.f10025a.equals(zzdsj.zzawx()) && this.f10026b == zzdsj.zzawy() && this.f10027c == zzdsj.zzcm();
        }
    }

    public final int hashCode() {
        int i = 1231;
        int hashCode = (((this.f10025a.hashCode() ^ 1000003) * 1000003) ^ (this.f10026b ? 1231 : 1237)) * 1000003;
        if (!this.f10027c) {
            i = 1237;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String str = this.f10025a;
        boolean z = this.f10026b;
        boolean z2 = this.f10027c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final String zzawx() {
        return this.f10025a;
    }

    public final boolean zzawy() {
        return this.f10026b;
    }

    public final boolean zzcm() {
        return this.f10027c;
    }
}
