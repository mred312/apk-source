package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.installations.k */
/* compiled from: Utils */
class C3490k {

    /* renamed from: a */
    public static final long f19612a = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: b */
    private static final Pattern f19613b = Pattern.compile("\\AA[\\w-]{38}\\z");

    C3490k() {
    }

    /* renamed from: c */
    static boolean m11805c(@Nullable String str) {
        return f19613b.matcher(str).matches();
    }

    /* renamed from: d */
    static boolean m11806d(@Nullable String str) {
        return str.contains(":");
    }

    /* renamed from: a */
    public long mo21602a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    /* renamed from: b */
    public boolean mo21603b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!TextUtils.isEmpty(persistedInstallationEntry.getAuthToken()) && persistedInstallationEntry.getTokenCreationEpochInSecs() + persistedInstallationEntry.getExpiresInSecs() >= mo21602a() + f19612a) {
            return false;
        }
        return true;
    }
}
