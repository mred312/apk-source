package androidx.core.p003os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.util.Locale;

/* renamed from: androidx.core.os.LocaleListCompat */
public final class LocaleListCompat {

    /* renamed from: b */
    private static final LocaleListCompat f2420b = create(new Locale[0]);

    /* renamed from: a */
    private C0489b f2421a;

    private LocaleListCompat(C0489b bVar) {
        this.f2421a = bVar;
    }

    /* renamed from: a */
    static Locale m1609a(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(new LocaleList(localeArr));
        }
        return new LocaleListCompat(new C0488a(localeArr));
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String str) {
        Locale locale;
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            if (Build.VERSION.SDK_INT >= 21) {
                locale = Locale.forLanguageTag(split[i]);
            } else {
                locale = m1609a(split[i]);
            }
            localeArr[i] = locale;
        }
        return create(localeArr);
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(LocaleList.getAdjustedDefault());
        }
        return create(Locale.getDefault());
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(LocaleList.getDefault());
        }
        return create(Locale.getDefault());
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return f2420b;
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        return wrap((LocaleList) obj);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.f2421a.equals(((LocaleListCompat) obj).f2421a);
    }

    public Locale get(int i) {
        return this.f2421a.get(i);
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return this.f2421a.mo4381d(strArr);
    }

    public int hashCode() {
        return this.f2421a.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(Locale locale) {
        return this.f2421a.mo4378a(locale);
    }

    public boolean isEmpty() {
        return this.f2421a.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return this.f2421a.size();
    }

    @NonNull
    public String toLanguageTags() {
        return this.f2421a.mo4379b();
    }

    public String toString() {
        return this.f2421a.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.f2421a.mo4380c();
    }

    @RequiresApi(24)
    @NonNull
    public static LocaleListCompat wrap(@NonNull LocaleList localeList) {
        return new LocaleListCompat(new C0490c(localeList));
    }
}
