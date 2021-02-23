package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: b */
    private final int f7448b;

    public GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.f7448b = i;
    }

    public int getConnectionStatusCode() {
        return this.f7448b;
    }
}
