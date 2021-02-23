package com.google.firebase.crashlytics.internal.network;

import androidx.work.WorkRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpRequest {

    /* renamed from: f */
    private static final OkHttpClient f19446f = new OkHttpClient().newBuilder().callTimeout(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).build();

    /* renamed from: a */
    private final HttpMethod f19447a;

    /* renamed from: b */
    private final String f19448b;

    /* renamed from: c */
    private final Map<String, String> f19449c;

    /* renamed from: d */
    private final Map<String, String> f19450d;

    /* renamed from: e */
    private MultipartBody.Builder f19451e = null;

    public HttpRequest(HttpMethod httpMethod, String str, Map<String, String> map) {
        this.f19447a = httpMethod;
        this.f19448b = str;
        this.f19449c = map;
        this.f19450d = new HashMap();
    }

    /* renamed from: a */
    private Request m11610a() {
        Request.Builder cacheControl = new Request.Builder().cacheControl(new CacheControl.Builder().noCache().build());
        HttpUrl.Builder newBuilder = HttpUrl.parse(this.f19448b).newBuilder();
        for (Map.Entry next : this.f19449c.entrySet()) {
            newBuilder = newBuilder.addEncodedQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        Request.Builder url = cacheControl.url(newBuilder.build());
        for (Map.Entry next2 : this.f19450d.entrySet()) {
            url = url.header((String) next2.getKey(), (String) next2.getValue());
        }
        MultipartBody.Builder builder = this.f19451e;
        return url.method(this.f19447a.name(), builder == null ? null : builder.build()).build();
    }

    /* renamed from: b */
    private MultipartBody.Builder m11611b() {
        if (this.f19451e == null) {
            this.f19451e = new MultipartBody.Builder().setType(MultipartBody.FORM);
        }
        return this.f19451e;
    }

    public HttpResponse execute() {
        return HttpResponse.m11612a(f19446f.newCall(m11610a()).execute());
    }

    public HttpRequest header(String str, String str2) {
        this.f19450d.put(str, str2);
        return this;
    }

    public String method() {
        return this.f19447a.name();
    }

    public HttpRequest part(String str, String str2) {
        this.f19451e = m11611b().addFormDataPart(str, str2);
        return this;
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public HttpRequest part(String str, String str2, String str3, File file) {
        this.f19451e = m11611b().addFormDataPart(str, str2, RequestBody.create(MediaType.parse(str3), file));
        return this;
    }
}
