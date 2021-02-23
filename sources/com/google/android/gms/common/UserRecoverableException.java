package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class UserRecoverableException extends Exception {

    /* renamed from: a */
    private final Intent f7456a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f7456a = intent;
    }

    public Intent getIntent() {
        return new Intent(this.f7456a);
    }
}
