package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum JavaType {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(ByteString.class, ByteString.class, ByteString.EMPTY),
    ENUM(r1, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    

    /* renamed from: a */
    private final Class<?> f20607a;

    /* renamed from: b */
    private final Class<?> f20608b;

    /* renamed from: c */
    private final Object f20609c;

    private JavaType(Class<?> cls, Class<?> cls2, Object obj) {
        this.f20607a = cls;
        this.f20608b = cls2;
        this.f20609c = obj;
    }

    public Class<?> getBoxedType() {
        return this.f20608b;
    }

    public Object getDefaultDefault() {
        return this.f20609c;
    }

    public Class<?> getType() {
        return this.f20607a;
    }

    public boolean isValidType(Class<?> cls) {
        return this.f20607a.isAssignableFrom(cls);
    }
}
