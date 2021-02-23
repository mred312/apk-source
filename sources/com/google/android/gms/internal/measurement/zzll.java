package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public enum zzll {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzgr.zza),
    ENUM((String) null),
    MESSAGE((String) null);
    

    /* renamed from: a */
    private final Object f17752a;

    private zzll(Object obj) {
        this.f17752a = obj;
    }
}
