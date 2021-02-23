package androidx.core.p003os;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: androidx.core.os.a */
/* compiled from: LocaleListCompatWrapper */
final class C0488a implements C0489b {

    /* renamed from: c */
    private static final Locale[] f2436c = new Locale[0];

    /* renamed from: d */
    private static final Locale f2437d = new Locale("en", "XA");

    /* renamed from: e */
    private static final Locale f2438e = new Locale("ar", "XB");

    /* renamed from: f */
    private static final Locale f2439f = LocaleListCompat.m1609a("en-Latn");

    /* renamed from: a */
    private final Locale[] f2440a;
    @NonNull

    /* renamed from: b */
    private final String f2441b;

    C0488a(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f2440a = f2436c;
            this.f2441b = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < localeArr.length) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException("list[" + i + "] is null");
            } else if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                localeArr2[i] = locale2;
                m1619k(sb, locale2);
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
                i++;
            } else {
                throw new IllegalArgumentException("list[" + i + "] is a repetition");
            }
        }
        this.f2440a = localeArr2;
        this.f2441b = sb.toString();
    }

    /* renamed from: e */
    private Locale m1613e(Collection<String> collection, boolean z) {
        int f = m1614f(collection, z);
        if (f == -1) {
            return null;
        }
        return this.f2440a[f];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r6 < Integer.MAX_VALUE) goto L_0x0021;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m1614f(java.util.Collection<java.lang.String> r5, boolean r6) {
        /*
            r4 = this;
            java.util.Locale[] r0 = r4.f2440a
            int r1 = r0.length
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0008
            return r2
        L_0x0008:
            int r0 = r0.length
            if (r0 != 0) goto L_0x000d
            r5 = -1
            return r5
        L_0x000d:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == 0) goto L_0x001e
            java.util.Locale r6 = f2439f
            int r6 = r4.m1615g(r6)
            if (r6 != 0) goto L_0x001b
            return r2
        L_0x001b:
            if (r6 >= r0) goto L_0x001e
            goto L_0x0021
        L_0x001e:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x0021:
            java.util.Iterator r5 = r5.iterator()
        L_0x0025:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r1 = androidx.core.p003os.LocaleListCompat.m1609a(r1)
            int r1 = r4.m1615g(r1)
            if (r1 != 0) goto L_0x003c
            return r2
        L_0x003c:
            if (r1 >= r6) goto L_0x0025
            r6 = r1
            goto L_0x0025
        L_0x0040:
            if (r6 != r0) goto L_0x0043
            return r2
        L_0x0043:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p003os.C0488a.m1614f(java.util.Collection, boolean):int");
    }

    /* renamed from: g */
    private int m1615g(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f2440a;
            if (i >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (m1618j(locale, localeArr[i]) > 0) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: h */
    private static String m1616h(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            String script = locale.getScript();
            if (!script.isEmpty()) {
                return script;
            }
        }
        return "";
    }

    /* renamed from: i */
    private static boolean m1617i(Locale locale) {
        return f2437d.equals(locale) || f2438e.equals(locale);
    }

    @IntRange(from = 0, mo779to = 1)
    /* renamed from: j */
    private static int m1618j(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || m1617i(locale) || m1617i(locale2)) {
            return 0;
        }
        String h = m1616h(locale);
        if (!h.isEmpty()) {
            return h.equals(m1616h(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        if (country.isEmpty() || country.equals(locale2.getCountry())) {
            return 1;
        }
        return 0;
    }

    @VisibleForTesting
    /* renamed from: k */
    static void m1619k(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    /* renamed from: a */
    public int mo4378a(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f2440a;
            if (i >= localeArr.length) {
                return -1;
            }
            if (localeArr[i].equals(locale)) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: b */
    public String mo4379b() {
        return this.f2441b;
    }

    @Nullable
    /* renamed from: c */
    public Object mo4380c() {
        return null;
    }

    /* renamed from: d */
    public Locale mo4381d(@NonNull String[] strArr) {
        return m1613e(Arrays.asList(strArr), false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0488a)) {
            return false;
        }
        Locale[] localeArr = ((C0488a) obj).f2440a;
        if (this.f2440a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.f2440a;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f2440a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f2440a;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    public boolean isEmpty() {
        return this.f2440a.length == 0;
    }

    public int size() {
        return this.f2440a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f2440a;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < this.f2440a.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
