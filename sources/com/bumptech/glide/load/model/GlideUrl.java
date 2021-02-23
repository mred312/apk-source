package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl implements Key {

    /* renamed from: a */
    private final Headers f6020a;
    @Nullable

    /* renamed from: b */
    private final URL f6021b;
    @Nullable

    /* renamed from: c */
    private final String f6022c;
    @Nullable

    /* renamed from: d */
    private String f6023d;
    @Nullable

    /* renamed from: e */
    private URL f6024e;
    @Nullable

    /* renamed from: f */
    private volatile byte[] f6025f;

    /* renamed from: g */
    private int f6026g;

    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
    }

    /* renamed from: a */
    private byte[] m4458a() {
        if (this.f6025f == null) {
            this.f6025f = getCacheKey().getBytes(Key.CHARSET);
        }
        return this.f6025f;
    }

    /* renamed from: b */
    private String m4459b() {
        if (TextUtils.isEmpty(this.f6023d)) {
            String str = this.f6022c;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.checkNotNull(this.f6021b)).toString();
            }
            this.f6023d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f6023d;
    }

    /* renamed from: c */
    private URL m4460c() {
        if (this.f6024e == null) {
            this.f6024e = new URL(m4459b());
        }
        return this.f6024e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!getCacheKey().equals(glideUrl.getCacheKey()) || !this.f6020a.equals(glideUrl.f6020a)) {
            return false;
        }
        return true;
    }

    public String getCacheKey() {
        String str = this.f6022c;
        return str != null ? str : ((URL) Preconditions.checkNotNull(this.f6021b)).toString();
    }

    public Map<String, String> getHeaders() {
        return this.f6020a.getHeaders();
    }

    public int hashCode() {
        if (this.f6026g == 0) {
            int hashCode = getCacheKey().hashCode();
            this.f6026g = hashCode;
            this.f6026g = (hashCode * 31) + this.f6020a.hashCode();
        }
        return this.f6026g;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return m4459b();
    }

    public URL toURL() {
        return m4460c();
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(m4458a());
    }

    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f6021b = (URL) Preconditions.checkNotNull(url);
        this.f6022c = null;
        this.f6020a = (Headers) Preconditions.checkNotNull(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f6021b = null;
        this.f6022c = Preconditions.checkNotEmpty(str);
        this.f6020a = (Headers) Preconditions.checkNotNull(headers);
    }
}
