package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzu {

    /* renamed from: a */
    private final String f17021a;

    /* renamed from: b */
    private final String f17022b;

    public zzu(String str, String str2) {
        this.f17021a = str;
        this.f17022b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzu.class == obj.getClass()) {
            zzu zzu = (zzu) obj;
            return TextUtils.equals(this.f17021a, zzu.f17021a) && TextUtils.equals(this.f17022b, zzu.f17022b);
        }
    }

    public final String getName() {
        return this.f17021a;
    }

    public final String getValue() {
        return this.f17022b;
    }

    public final int hashCode() {
        return (this.f17021a.hashCode() * 31) + this.f17022b.hashCode();
    }

    public final String toString() {
        String str = this.f17021a;
        String str2 = this.f17022b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
