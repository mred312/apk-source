package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class DependencyCycleException extends DependencyException {

    /* renamed from: a */
    private final List<Component<?>> f18920a;

    public DependencyCycleException(List<Component<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f18920a = list;
    }

    public List<Component<?>> getComponentsInCycle() {
        return this.f18920a;
    }
}
