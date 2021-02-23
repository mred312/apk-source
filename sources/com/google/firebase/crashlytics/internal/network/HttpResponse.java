package com.google.firebase.crashlytics.internal.network;

import okhttp3.Headers;
import okhttp3.Response;

public class HttpResponse {

    /* renamed from: a */
    private int f19452a;

    /* renamed from: b */
    private String f19453b;

    /* renamed from: c */
    private Headers f19454c;

    HttpResponse(int i, String str, Headers headers) {
        this.f19452a = i;
        this.f19453b = str;
        this.f19454c = headers;
    }

    /* renamed from: a */
    static HttpResponse m11612a(Response response) {
        return new HttpResponse(response.code(), response.body() == null ? null : response.body().string(), response.headers());
    }

    public String body() {
        return this.f19453b;
    }

    public int code() {
        return this.f19452a;
    }

    public String header(String str) {
        return this.f19454c.get(str);
    }
}
