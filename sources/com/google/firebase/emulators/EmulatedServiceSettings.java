package com.google.firebase.emulators;

import androidx.annotation.NonNull;

public final class EmulatedServiceSettings {

    /* renamed from: a */
    private final String f19540a;

    /* renamed from: b */
    private final int f19541b;

    public EmulatedServiceSettings(@NonNull String str, int i) {
        this.f19540a = str;
        this.f19541b = i;
    }

    public String getHost() {
        return this.f19540a;
    }

    public int getPort() {
        return this.f19541b;
    }
}
