package com.google.firebase.crashlytics.internal.ndk;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.crashlytics.internal.ndk.c */
/* compiled from: ProcMapEntryParser */
final class C3437c {

    /* renamed from: a */
    private static final Pattern f19444a = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    @Nullable
    /* renamed from: a */
    static C3436b m11607a(String str) {
        Matcher matcher = f19444a.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        try {
            long longValue = Long.valueOf(matcher.group(1), 16).longValue();
            return new C3436b(longValue, Long.valueOf(matcher.group(2), 16).longValue() - longValue, matcher.group(3), matcher.group(4));
        } catch (Exception unused) {
            Logger logger = Logger.getLogger();
            logger.mo20859d("Could not parse map entry: " + str);
            return null;
        }
    }
}
