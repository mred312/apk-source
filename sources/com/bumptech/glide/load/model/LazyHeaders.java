package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LazyHeaders implements Headers {

    /* renamed from: a */
    private final Map<String, List<LazyHeaderFactory>> f6027a;

    /* renamed from: b */
    private volatile Map<String, String> f6028b;

    public static final class Builder {

        /* renamed from: d */
        private static final String f6029d;

        /* renamed from: e */
        private static final Map<String, List<LazyHeaderFactory>> f6030e;

        /* renamed from: a */
        private boolean f6031a = true;

        /* renamed from: b */
        private Map<String, List<LazyHeaderFactory>> f6032b = f6030e;

        /* renamed from: c */
        private boolean f6033c = true;

        static {
            String d = m4466d();
            f6029d = d;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(d)) {
                hashMap.put(AbstractSpiCall.HEADER_USER_AGENT, Collections.singletonList(new C1280a(d)));
            }
            f6030e = Collections.unmodifiableMap(hashMap);
        }

        /* renamed from: a */
        private Map<String, List<LazyHeaderFactory>> m4463a() {
            HashMap hashMap = new HashMap(this.f6032b.size());
            for (Map.Entry next : this.f6032b.entrySet()) {
                hashMap.put(next.getKey(), new ArrayList((Collection) next.getValue()));
            }
            return hashMap;
        }

        /* renamed from: b */
        private void m4464b() {
            if (this.f6031a) {
                this.f6031a = false;
                this.f6032b = m4463a();
            }
        }

        /* renamed from: c */
        private List<LazyHeaderFactory> m4465c(String str) {
            List<LazyHeaderFactory> list = this.f6032b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f6032b.put(str, arrayList);
            return arrayList;
        }

        @VisibleForTesting
        /* renamed from: d */
        static String m4466d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public Builder addHeader(@NonNull String str, @NonNull String str2) {
            return addHeader(str, (LazyHeaderFactory) new C1280a(str2));
        }

        public LazyHeaders build() {
            this.f6031a = true;
            return new LazyHeaders(this.f6032b);
        }

        public Builder setHeader(@NonNull String str, @Nullable String str2) {
            return setHeader(str, (LazyHeaderFactory) str2 == null ? null : new C1280a(str2));
        }

        public Builder addHeader(@NonNull String str, @NonNull LazyHeaderFactory lazyHeaderFactory) {
            if (this.f6033c && AbstractSpiCall.HEADER_USER_AGENT.equalsIgnoreCase(str)) {
                return setHeader(str, lazyHeaderFactory);
            }
            m4464b();
            m4465c(str).add(lazyHeaderFactory);
            return this;
        }

        public Builder setHeader(@NonNull String str, @Nullable LazyHeaderFactory lazyHeaderFactory) {
            m4464b();
            if (lazyHeaderFactory == null) {
                this.f6032b.remove(str);
            } else {
                List<LazyHeaderFactory> c = m4465c(str);
                c.clear();
                c.add(lazyHeaderFactory);
            }
            if (this.f6033c && AbstractSpiCall.HEADER_USER_AGENT.equalsIgnoreCase(str)) {
                this.f6033c = false;
            }
            return this;
        }
    }

    /* renamed from: com.bumptech.glide.load.model.LazyHeaders$a */
    static final class C1280a implements LazyHeaderFactory {
        @NonNull

        /* renamed from: a */
        private final String f6034a;

        C1280a(@NonNull String str) {
            this.f6034a = str;
        }

        public String buildHeader() {
            return this.f6034a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1280a) {
                return this.f6034a.equals(((C1280a) obj).f6034a);
            }
            return false;
        }

        public int hashCode() {
            return this.f6034a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f6034a + '\'' + '}';
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f6027a = Collections.unmodifiableMap(map);
    }

    @NonNull
    /* renamed from: a */
    private String m4461a(@NonNull List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String buildHeader = list.get(i).buildHeader();
            if (!TextUtils.isEmpty(buildHeader)) {
                sb.append(buildHeader);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private Map<String, String> m4462b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f6027a.entrySet()) {
            String a = m4461a((List) next.getValue());
            if (!TextUtils.isEmpty(a)) {
                hashMap.put(next.getKey(), a);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f6027a.equals(((LazyHeaders) obj).f6027a);
        }
        return false;
    }

    public Map<String, String> getHeaders() {
        if (this.f6028b == null) {
            synchronized (this) {
                if (this.f6028b == null) {
                    this.f6028b = Collections.unmodifiableMap(m4462b());
                }
            }
        }
        return this.f6028b;
    }

    public int hashCode() {
        return this.f6027a.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f6027a + '}';
    }
}
