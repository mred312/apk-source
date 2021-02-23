package com.google.firebase.crashlytics.internal.common;

public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: a */
    private final int f19043a;

    private DeliveryMechanism(int i) {
        this.f19043a = i;
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int getId() {
        return this.f19043a;
    }

    public String toString() {
        return Integer.toString(this.f19043a);
    }
}
