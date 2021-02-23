package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* renamed from: com.google.firebase.components.a */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
abstract class C3237a implements ComponentContainer {
    C3237a() {
    }

    public <T> T get(Class<T> cls) {
        Provider<T> provider = getProvider(cls);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public <T> Set<T> setOf(Class<T> cls) {
        return setOfProvider(cls).get();
    }
}
