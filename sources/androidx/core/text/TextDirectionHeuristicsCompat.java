package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new C0517e(C0513a.f2540b, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE = C0518f.f2545b;
    public static final TextDirectionHeuristicCompat LTR = new C0517e((C0515c) null, false);
    public static final TextDirectionHeuristicCompat RTL = new C0517e((C0515c) null, true);

    /* renamed from: androidx.core.text.TextDirectionHeuristicsCompat$a */
    private static class C0513a implements C0515c {

        /* renamed from: b */
        static final C0513a f2540b = new C0513a(true);

        /* renamed from: a */
        private final boolean f2541a;

        private C0513a(boolean z) {
            this.f2541a = z;
        }

        /* renamed from: a */
        public int mo4485a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a = TextDirectionHeuristicsCompat.m1664a(Character.getDirectionality(charSequence.charAt(i)));
                if (a != 0) {
                    if (a != 1) {
                        continue;
                        i++;
                    } else if (!this.f2541a) {
                        return 1;
                    }
                } else if (this.f2541a) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f2541a ? 1 : 0;
            }
            return 2;
        }
    }

    /* renamed from: androidx.core.text.TextDirectionHeuristicsCompat$b */
    private static class C0514b implements C0515c {

        /* renamed from: a */
        static final C0514b f2542a = new C0514b();

        private C0514b() {
        }

        /* renamed from: a */
        public int mo4485a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.m1665b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* renamed from: androidx.core.text.TextDirectionHeuristicsCompat$c */
    private interface C0515c {
        /* renamed from: a */
        int mo4485a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: androidx.core.text.TextDirectionHeuristicsCompat$d */
    private static abstract class C0516d implements TextDirectionHeuristicCompat {

        /* renamed from: a */
        private final C0515c f2543a;

        C0516d(C0515c cVar) {
            this.f2543a = cVar;
        }

        /* renamed from: b */
        private boolean m1669b(CharSequence charSequence, int i, int i2) {
            int a = this.f2543a.mo4485a(charSequence, i, i2);
            if (a == 0) {
                return true;
            }
            if (a != 1) {
                return mo4486a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo4486a();

        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl((CharSequence) CharBuffer.wrap(cArr), i, i2);
        }

        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f2543a == null) {
                return mo4486a();
            } else {
                return m1669b(charSequence, i, i2);
            }
        }
    }

    /* renamed from: androidx.core.text.TextDirectionHeuristicsCompat$e */
    private static class C0517e extends C0516d {

        /* renamed from: b */
        private final boolean f2544b;

        C0517e(C0515c cVar, boolean z) {
            super(cVar);
            this.f2544b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4486a() {
            return this.f2544b;
        }
    }

    /* renamed from: androidx.core.text.TextDirectionHeuristicsCompat$f */
    private static class C0518f extends C0516d {

        /* renamed from: b */
        static final C0518f f2545b = new C0518f();

        C0518f() {
            super((C0515c) null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo4486a() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    static {
        C0514b bVar = C0514b.f2542a;
        FIRSTSTRONG_LTR = new C0517e(bVar, false);
        FIRSTSTRONG_RTL = new C0517e(bVar, true);
    }

    private TextDirectionHeuristicsCompat() {
    }

    /* renamed from: a */
    static int m1664a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    /* renamed from: b */
    static int m1665b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
