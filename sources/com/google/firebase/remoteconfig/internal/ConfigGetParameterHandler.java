package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import org.json.JSONException;

public class ConfigGetParameterHandler {
    @VisibleForTesting(otherwise = 3)
    public static final Charset FRC_BYTE_ARRAY_ENCODING = Charset.forName(Key.STRING_CHARSET_NAME);

    /* renamed from: c */
    static final Pattern f20257c = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* renamed from: d */
    static final Pattern f20258d = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* renamed from: a */
    private final ConfigCacheClient f20259a;

    /* renamed from: b */
    private final ConfigCacheClient f20260b;

    public ConfigGetParameterHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.f20259a = configCacheClient;
        this.f20260b = configCacheClient2;
    }

    @Nullable
    /* renamed from: a */
    private static ConfigContainer m12136a(ConfigCacheClient configCacheClient) {
        return configCacheClient.getBlocking();
    }

    @Nullable
    /* renamed from: b */
    private static Double m12137b(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer a = m12136a(configCacheClient);
        if (a == null) {
            return null;
        }
        try {
            return Double.valueOf(a.getConfigs().getDouble(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static Set<String> m12138c(ConfigCacheClient configCacheClient) {
        HashSet hashSet = new HashSet();
        ConfigContainer a = m12136a(configCacheClient);
        if (a == null) {
            return hashSet;
        }
        Iterator<String> keys = a.getConfigs().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    /* renamed from: d */
    private static TreeSet<String> m12139d(String str, ConfigContainer configContainer) {
        TreeSet<String> treeSet = new TreeSet<>();
        Iterator<String> keys = configContainer.getConfigs().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith(str)) {
                treeSet.add(next);
            }
        }
        return treeSet;
    }

    @Nullable
    /* renamed from: e */
    private static Long m12140e(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer a = m12136a(configCacheClient);
        if (a == null) {
            return null;
        }
        try {
            return Long.valueOf(a.getConfigs().getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: f */
    private static String m12141f(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer a = m12136a(configCacheClient);
        if (a == null) {
            return null;
        }
        try {
            return a.getConfigs().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: g */
    private static void m12142g(String str, String str2) {
        Log.w(FirebaseRemoteConfig.TAG, String.format("No value of type '%s' exists for parameter key '%s'.", new Object[]{str2, str}));
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(m12138c(this.f20259a));
        hashSet.addAll(m12138c(this.f20260b));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, getValue(str));
        }
        return hashMap;
    }

    public boolean getBoolean(String str) {
        String f = m12141f(this.f20259a, str);
        if (f != null) {
            if (f20257c.matcher(f).matches()) {
                return true;
            }
            if (f20258d.matcher(f).matches()) {
                return false;
            }
        }
        String f2 = m12141f(this.f20260b, str);
        if (f2 != null) {
            if (f20257c.matcher(f2).matches()) {
                return true;
            }
            if (f20258d.matcher(f2).matches()) {
                return false;
            }
        }
        m12142g(str, "Boolean");
        return false;
    }

    public byte[] getByteArray(String str) {
        String f = m12141f(this.f20259a, str);
        if (f != null) {
            return f.getBytes(FRC_BYTE_ARRAY_ENCODING);
        }
        String f2 = m12141f(this.f20260b, str);
        if (f2 != null) {
            return f2.getBytes(FRC_BYTE_ARRAY_ENCODING);
        }
        m12142g(str, "ByteArray");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
    }

    public double getDouble(String str) {
        Double b = m12137b(this.f20259a, str);
        if (b != null) {
            return b.doubleValue();
        }
        Double b2 = m12137b(this.f20260b, str);
        if (b2 != null) {
            return b2.doubleValue();
        }
        m12142g(str, "Double");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public Set<String> getKeysByPrefix(String str) {
        if (str == null) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        ConfigContainer a = m12136a(this.f20259a);
        if (a != null) {
            treeSet.addAll(m12139d(str, a));
        }
        ConfigContainer a2 = m12136a(this.f20260b);
        if (a2 != null) {
            treeSet.addAll(m12139d(str, a2));
        }
        return treeSet;
    }

    public long getLong(String str) {
        Long e = m12140e(this.f20259a, str);
        if (e != null) {
            return e.longValue();
        }
        Long e2 = m12140e(this.f20260b, str);
        if (e2 != null) {
            return e2.longValue();
        }
        m12142g(str, "Long");
        return 0;
    }

    public String getString(String str) {
        String f = m12141f(this.f20259a, str);
        if (f != null) {
            return f;
        }
        String f2 = m12141f(this.f20260b, str);
        if (f2 != null) {
            return f2;
        }
        m12142g(str, "String");
        return "";
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        String f = m12141f(this.f20259a, str);
        if (f != null) {
            return new FirebaseRemoteConfigValueImpl(f, 2);
        }
        String f2 = m12141f(this.f20260b, str);
        if (f2 != null) {
            return new FirebaseRemoteConfigValueImpl(f2, 1);
        }
        m12142g(str, "FirebaseRemoteConfigValue");
        return new FirebaseRemoteConfigValueImpl("", 0);
    }
}
