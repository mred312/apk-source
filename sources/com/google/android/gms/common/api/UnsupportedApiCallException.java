package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: a */
    private final Feature f7469a;

    @KeepForSdk
    public UnsupportedApiCallException(Feature feature) {
        this.f7469a = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.f7469a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
