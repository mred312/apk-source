package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class m10 extends n10 {

    /* renamed from: a */
    private final char f9901a = ';';

    m10(char c) {
    }

    public final String toString() {
        String b = zzdvd.m8525a(this.f9901a);
        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(b);
        sb.append("')");
        return sb.toString();
    }

    public final boolean zzc(char c) {
        return c == this.f9901a;
    }
}
