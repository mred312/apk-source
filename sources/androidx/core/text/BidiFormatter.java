package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {

    /* renamed from: d */
    static final TextDirectionHeuristicCompat f2504d;

    /* renamed from: e */
    private static final String f2505e = Character.toString(8206);

    /* renamed from: f */
    private static final String f2506f = Character.toString(8207);

    /* renamed from: g */
    static final BidiFormatter f2507g;

    /* renamed from: h */
    static final BidiFormatter f2508h;

    /* renamed from: a */
    private final boolean f2509a;

    /* renamed from: b */
    private final int f2510b;

    /* renamed from: c */
    private final TextDirectionHeuristicCompat f2511c;

    /* renamed from: androidx.core.text.BidiFormatter$a */
    private static class C0510a {

        /* renamed from: f */
        private static final byte[] f2515f = new byte[1792];

        /* renamed from: a */
        private final CharSequence f2516a;

        /* renamed from: b */
        private final boolean f2517b;

        /* renamed from: c */
        private final int f2518c;

        /* renamed from: d */
        private int f2519d;

        /* renamed from: e */
        private char f2520e;

        static {
            for (int i = 0; i < 1792; i++) {
                f2515f[i] = Character.getDirectionality(i);
            }
        }

        C0510a(CharSequence charSequence, boolean z) {
            this.f2516a = charSequence;
            this.f2517b = z;
            this.f2518c = charSequence.length();
        }

        /* renamed from: c */
        private static byte m1652c(char c) {
            return c < 1792 ? f2515f[c] : Character.getDirectionality(c);
        }

        /* renamed from: f */
        private byte m1653f() {
            char charAt;
            int i = this.f2519d;
            do {
                int i2 = this.f2519d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2516a;
                int i3 = i2 - 1;
                this.f2519d = i3;
                charAt = charSequence.charAt(i3);
                this.f2520e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f2519d = i;
            this.f2520e = ';';
            return 13;
        }

        /* renamed from: g */
        private byte m1654g() {
            char charAt;
            do {
                int i = this.f2519d;
                if (i >= this.f2518c) {
                    return 12;
                }
                CharSequence charSequence = this.f2516a;
                this.f2519d = i + 1;
                charAt = charSequence.charAt(i);
                this.f2520e = charAt;
            } while (charAt != ';');
            return 12;
        }

        /* renamed from: h */
        private byte m1655h() {
            char charAt;
            int i = this.f2519d;
            while (true) {
                int i2 = this.f2519d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2516a;
                int i3 = i2 - 1;
                this.f2519d = i3;
                char charAt2 = charSequence.charAt(i3);
                this.f2520e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i4 = this.f2519d;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f2516a;
                        int i5 = i4 - 1;
                        this.f2519d = i5;
                        charAt = charSequence2.charAt(i5);
                        this.f2520e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f2519d = i;
            this.f2520e = '>';
            return 13;
        }

        /* renamed from: i */
        private byte m1656i() {
            char charAt;
            int i = this.f2519d;
            while (true) {
                int i2 = this.f2519d;
                if (i2 < this.f2518c) {
                    CharSequence charSequence = this.f2516a;
                    this.f2519d = i2 + 1;
                    char charAt2 = charSequence.charAt(i2);
                    this.f2520e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i3 = this.f2519d;
                            if (i3 >= this.f2518c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f2516a;
                            this.f2519d = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.f2520e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f2519d = i;
                    this.f2520e = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public byte mo4449a() {
            char charAt = this.f2516a.charAt(this.f2519d - 1);
            this.f2520e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f2516a, this.f2519d);
                this.f2519d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f2519d--;
            byte c = m1652c(this.f2520e);
            if (!this.f2517b) {
                return c;
            }
            char c2 = this.f2520e;
            if (c2 == '>') {
                return m1655h();
            }
            return c2 == ';' ? m1653f() : c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public byte mo4450b() {
            char charAt = this.f2516a.charAt(this.f2519d);
            this.f2520e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f2516a, this.f2519d);
                this.f2519d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f2519d++;
            byte c = m1652c(this.f2520e);
            if (!this.f2517b) {
                return c;
            }
            char c2 = this.f2520e;
            if (c2 == '<') {
                return m1656i();
            }
            return c2 == '&' ? m1654g() : c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo4451d() {
            this.f2519d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f2519d < this.f2518c && i == 0) {
                byte b = mo4450b();
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f2519d > 0) {
                switch (mo4449a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r1 = r1 - 1;
         */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo4452e() {
            /*
                r7 = this;
                int r0 = r7.f2518c
                r7.f2519d = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r7.f2519d
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.mo4449a()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x0028;
                    case 15: goto L_0x0028;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0025:
                if (r2 != r1) goto L_0x002b
                return r5
            L_0x0028:
                if (r2 != r1) goto L_0x002b
                return r4
            L_0x002b:
                int r1 = r1 + -1
                goto L_0x0007
            L_0x002e:
                if (r1 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r1 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r2 != 0) goto L_0x0007
            L_0x0039:
                r2 = r1
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.C0510a.mo4452e():int");
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        f2504d = textDirectionHeuristicCompat;
        f2507g = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        f2508h = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f2509a = z;
        this.f2510b = i;
        this.f2511c = textDirectionHeuristicCompat;
    }

    /* renamed from: a */
    private static int m1645a(CharSequence charSequence) {
        return new C0510a(charSequence, false).mo4451d();
    }

    /* renamed from: b */
    private static int m1646b(CharSequence charSequence) {
        return new C0510a(charSequence, false).mo4452e();
    }

    /* renamed from: c */
    static boolean m1647c(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    /* renamed from: d */
    private String m1648d(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.f2509a && (isRtl || m1646b(charSequence) == 1)) {
            return f2505e;
        }
        if (this.f2509a) {
            return (!isRtl || m1646b(charSequence) == -1) ? f2506f : "";
        }
        return "";
    }

    /* renamed from: e */
    private String m1649e(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.f2509a && (isRtl || m1645a(charSequence) == 1)) {
            return f2505e;
        }
        if (this.f2509a) {
            return (!isRtl || m1645a(charSequence) == -1) ? f2506f : "";
        }
        return "";
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public boolean getStereoReset() {
        return (this.f2510b & 2) != 0;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.f2509a;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public static final class Builder {

        /* renamed from: a */
        private boolean f2512a;

        /* renamed from: b */
        private int f2513b;

        /* renamed from: c */
        private TextDirectionHeuristicCompat f2514c;

        public Builder() {
            m1651b(BidiFormatter.m1647c(Locale.getDefault()));
        }

        /* renamed from: a */
        private static BidiFormatter m1650a(boolean z) {
            return z ? BidiFormatter.f2508h : BidiFormatter.f2507g;
        }

        /* renamed from: b */
        private void m1651b(boolean z) {
            this.f2512a = z;
            this.f2514c = BidiFormatter.f2504d;
            this.f2513b = 2;
        }

        public BidiFormatter build() {
            if (this.f2513b == 2 && this.f2514c == BidiFormatter.f2504d) {
                return m1650a(this.f2512a);
            }
            return new BidiFormatter(this.f2512a, this.f2513b, this.f2514c);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f2514c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.f2513b |= 2;
            } else {
                this.f2513b &= -3;
            }
            return this;
        }

        public Builder(boolean z) {
            m1651b(z);
        }

        public Builder(Locale locale) {
            m1651b(BidiFormatter.m1647c(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.f2511c.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append(m1649e(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.f2509a) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(m1648d(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.f2511c, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.f2511c, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.f2511c, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.f2511c, true);
    }
}
