package androidx.core.p003os;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

@RequiresApi(24)
/* renamed from: androidx.core.os.c */
/* compiled from: LocaleListPlatformWrapper */
final class C0490c implements C0489b {

    /* renamed from: a */
    private final LocaleList f2442a;

    C0490c(LocaleList localeList) {
        this.f2442a = localeList;
    }

    /* renamed from: a */
    public int mo4378a(Locale locale) {
        return this.f2442a.indexOf(locale);
    }

    /* renamed from: b */
    public String mo4379b() {
        return this.f2442a.toLanguageTags();
    }

    /* renamed from: c */
    public Object mo4380c() {
        return this.f2442a;
    }

    @Nullable
    /* renamed from: d */
    public Locale mo4381d(@NonNull String[] strArr) {
        return this.f2442a.getFirstMatch(strArr);
    }

    public boolean equals(Object obj) {
        return this.f2442a.equals(((C0489b) obj).mo4380c());
    }

    public Locale get(int i) {
        return this.f2442a.get(i);
    }

    public int hashCode() {
        return this.f2442a.hashCode();
    }

    public boolean isEmpty() {
        return this.f2442a.isEmpty();
    }

    public int size() {
        return this.f2442a.size();
    }

    public String toString() {
        return this.f2442a.toString();
    }
}
