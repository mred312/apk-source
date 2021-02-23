package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public enum zzeku {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeiu.class, zzeiu.class, zzeiu.zziiy),
    ENUM(r1, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    

    /* renamed from: a */
    private final Class<?> f16272a;

    /* renamed from: b */
    private final Object f16273b;

    private zzeku(Class<?> cls, Class<?> cls2, Object obj) {
        this.f16272a = cls2;
        this.f16273b = obj;
    }

    public final Class<?> zzbis() {
        return this.f16272a;
    }
}
