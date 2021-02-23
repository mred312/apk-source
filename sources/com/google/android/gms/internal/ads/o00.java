package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class o00 extends zzdsm {

    /* renamed from: a */
    private String f10238a;

    /* renamed from: b */
    private Boolean f10239b;

    /* renamed from: c */
    private Boolean f10240c;

    o00() {
    }

    public final zzdsj zzaxa() {
        String str = "";
        if (this.f10238a == null) {
            str = str.concat(" clientVersion");
        }
        if (this.f10239b == null) {
            str = String.valueOf(str).concat(" shouldGetAdvertisingId");
        }
        if (this.f10240c == null) {
            str = String.valueOf(str).concat(" isGooglePlayServicesAvailable");
        }
        if (str.isEmpty()) {
            return new n00(this.f10238a, this.f10239b.booleanValue(), this.f10240c.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }

    public final zzdsm zzbp(boolean z) {
        this.f10239b = Boolean.valueOf(z);
        return this;
    }

    public final zzdsm zzbq(boolean z) {
        this.f10240c = Boolean.TRUE;
        return this;
    }

    public final zzdsm zzgy(String str) {
        if (str != null) {
            this.f10238a = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }
}
