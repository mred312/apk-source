package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class Response<T extends Result> {

    /* renamed from: a */
    private T f7462a;

    public Response() {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T getResult() {
        return this.f7462a;
    }

    public void setResult(@NonNull T t) {
        this.f7462a = t;
    }

    protected Response(@NonNull T t) {
        this.f7462a = t;
    }
}
