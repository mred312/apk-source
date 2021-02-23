package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;

public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {

    /* renamed from: a */
    private final String f20274a;

    /* renamed from: b */
    private final int f20275b;

    FirebaseRemoteConfigValueImpl(String str, int i) {
        this.f20274a = str;
        this.f20275b = i;
    }

    /* renamed from: a */
    private String m12157a() {
        return asString().trim();
    }

    /* renamed from: b */
    private void m12158b() {
        if (this.f20274a == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    public boolean asBoolean() {
        if (this.f20275b == 0) {
            return false;
        }
        String a = m12157a();
        if (ConfigGetParameterHandler.f20257c.matcher(a).matches()) {
            return true;
        }
        if (ConfigGetParameterHandler.f20258d.matcher(a).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{a, "boolean"}));
    }

    public byte[] asByteArray() {
        if (this.f20275b == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        return this.f20274a.getBytes(ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
    }

    public double asDouble() {
        if (this.f20275b == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        String a = m12157a();
        try {
            return Double.valueOf(a).doubleValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{a, "double"}), e);
        }
    }

    public long asLong() {
        if (this.f20275b == 0) {
            return 0;
        }
        String a = m12157a();
        try {
            return Long.valueOf(a).longValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{a, "long"}), e);
        }
    }

    public String asString() {
        if (this.f20275b == 0) {
            return "";
        }
        m12158b();
        return this.f20274a;
    }

    public int getSource() {
        return this.f20275b;
    }
}
