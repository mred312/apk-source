package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzad {
    public static final zzad zza = new zzad((Boolean) null, (Boolean) null);

    /* renamed from: a */
    private final Boolean f18491a;

    /* renamed from: b */
    private final Boolean f18492b;

    public zzad(Boolean bool, Boolean bool2) {
        this.f18491a = bool;
        this.f18492b = bool2;
    }

    /* renamed from: a */
    private static int m10648a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    /* renamed from: b */
    private static Boolean m10649b(char c) {
        if (c == '0') {
            return Boolean.FALSE;
        }
        if (c != '1') {
            return null;
        }
        return Boolean.TRUE;
    }

    /* renamed from: c */
    private static Boolean m10650c(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return bool2;
        }
        if (bool2 == null) {
            return bool;
        }
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    /* renamed from: d */
    private static char m10651d(Boolean bool) {
        if (bool == null) {
            return '-';
        }
        return bool.booleanValue() ? '1' : '0';
    }

    /* renamed from: e */
    private static Boolean m10652e(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static String zza(Bundle bundle) {
        String string = bundle.getString("ad_storage");
        if (string != null && m10652e(string) == null) {
            return string;
        }
        String string2 = bundle.getString("analytics_storage");
        if (string2 == null || m10652e(string2) != null) {
            return null;
        }
        return string2;
    }

    public static boolean zza(int i, int i2) {
        return i <= i2;
    }

    public static zzad zzb(Bundle bundle) {
        if (bundle == null) {
            return zza;
        }
        return new zzad(m10652e(bundle.getString("ad_storage")), m10652e(bundle.getString("analytics_storage")));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzad = (zzad) obj;
        if (m10648a(this.f18491a) == m10648a(zzad.f18491a) && m10648a(this.f18492b) == m10648a(zzad.f18492b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((m10648a(this.f18491a) + 527) * 31) + m10648a(this.f18492b);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.f18491a;
        String str2 = "granted";
        if (bool == null) {
            sb.append("uninitialized");
        } else {
            if (bool.booleanValue()) {
                str = str2;
            } else {
                str = "denied";
            }
            sb.append(str);
        }
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.f18492b;
        if (bool2 == null) {
            sb.append("uninitialized");
        } else {
            if (!bool2.booleanValue()) {
                str2 = "denied";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public final boolean zzc() {
        Boolean bool = this.f18491a;
        return bool == null || bool.booleanValue();
    }

    public final Boolean zzd() {
        return this.f18492b;
    }

    public final boolean zze() {
        Boolean bool = this.f18492b;
        return bool == null || bool.booleanValue();
    }

    public final zzad zzc(zzad zzad) {
        Boolean bool = this.f18491a;
        if (bool == null) {
            bool = zzad.f18491a;
        }
        Boolean bool2 = this.f18492b;
        if (bool2 == null) {
            bool2 = zzad.f18492b;
        }
        return new zzad(bool, bool2);
    }

    public static zzad zza(String str) {
        Boolean bool;
        Boolean bool2 = null;
        if (str != null) {
            Boolean b = str.length() >= 3 ? m10649b(str.charAt(2)) : null;
            if (str.length() >= 4) {
                bool2 = m10649b(str.charAt(3));
            }
            bool = bool2;
            bool2 = b;
        } else {
            bool = null;
        }
        return new zzad(bool2, bool);
    }

    public final Boolean zzb() {
        return this.f18491a;
    }

    public final zzad zzb(zzad zzad) {
        return new zzad(m10650c(this.f18491a, zzad.f18491a), m10650c(this.f18492b, zzad.f18492b));
    }

    public final String zza() {
        return "G1" + m10651d(this.f18491a) + m10651d(this.f18492b);
    }

    public final boolean zza(zzad zzad) {
        Boolean bool = this.f18491a;
        Boolean bool2 = Boolean.FALSE;
        if (bool != bool2 || zzad.f18491a == bool2) {
            return this.f18492b == bool2 && zzad.f18492b != bool2;
        }
        return true;
    }
}
