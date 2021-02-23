package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Challenge {

    /* renamed from: a */
    private final String f19795a;

    /* renamed from: b */
    private final Map<String, String> f19796b;

    public Challenge(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (map != null) {
            this.f19795a = str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(next.getKey() == null ? null : ((String) next.getKey()).toLowerCase(Locale.US), next.getValue());
            }
            this.f19796b = Collections.unmodifiableMap(linkedHashMap);
        } else {
            throw new NullPointerException("authParams == null");
        }
    }

    public Map<String, String> authParams() {
        return this.f19796b;
    }

    public Charset charset() {
        String str = this.f19796b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return Util.ISO_8859_1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return challenge.f19795a.equals(this.f19795a) && challenge.f19796b.equals(this.f19796b);
        }
    }

    public int hashCode() {
        return ((899 + this.f19795a.hashCode()) * 31) + this.f19796b.hashCode();
    }

    public String realm() {
        return this.f19796b.get("realm");
    }

    public String scheme() {
        return this.f19795a;
    }

    public String toString() {
        return this.f19795a + " authParams=" + this.f19796b;
    }

    public Challenge withCharset(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.f19796b);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.f19795a, (Map<String, String>) linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }

    public Challenge(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (str2 != null) {
            this.f19795a = str;
            this.f19796b = Collections.singletonMap("realm", str2);
        } else {
            throw new NullPointerException("realm == null");
        }
    }
}
