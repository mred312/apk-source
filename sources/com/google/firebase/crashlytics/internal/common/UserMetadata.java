package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMetadata {

    /* renamed from: a */
    private String f19058a = null;

    /* renamed from: b */
    private final ConcurrentHashMap<String, String> f19059b = new ConcurrentHashMap<>();

    /* renamed from: a */
    private static String m11278a(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    @NonNull
    public Map<String, String> getCustomKeys() {
        return Collections.unmodifiableMap(this.f19059b);
    }

    @Nullable
    public String getUserId() {
        return this.f19058a;
    }

    public void setCustomKey(String str, String str2) {
        String str3;
        if (str != null) {
            String a = m11278a(str);
            if (this.f19059b.size() < 64 || this.f19059b.containsKey(a)) {
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = m11278a(str2);
                }
                this.f19059b.put(a, str3);
                return;
            }
            Logger.getLogger().mo20859d("Exceeded maximum number of custom attributes (64)");
            return;
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public void setUserId(String str) {
        this.f19058a = m11278a(str);
    }
}
