package androidx.core.p003os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* renamed from: androidx.core.os.b */
/* compiled from: LocaleListInterface */
interface C0489b {
    @IntRange(from = -1)
    /* renamed from: a */
    int mo4378a(Locale locale);

    /* renamed from: b */
    String mo4379b();

    /* renamed from: c */
    Object mo4380c();

    @Nullable
    /* renamed from: d */
    Locale mo4381d(@NonNull String[] strArr);

    Locale get(int i);

    boolean isEmpty();

    @IntRange(from = 0)
    int size();
}
