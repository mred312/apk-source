package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GlobalLibraryVersionRegistrar {

    /* renamed from: b */
    private static volatile GlobalLibraryVersionRegistrar f19665b;

    /* renamed from: a */
    private final Set<C3504c> f19666a = new HashSet();

    GlobalLibraryVersionRegistrar() {
    }

    public static GlobalLibraryVersionRegistrar getInstance() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = f19665b;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = f19665b;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    f19665b = globalLibraryVersionRegistrar;
                }
            }
        }
        return globalLibraryVersionRegistrar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Set<C3504c> mo21671a() {
        Set<C3504c> unmodifiableSet;
        synchronized (this.f19666a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f19666a);
        }
        return unmodifiableSet;
    }

    public void registerVersion(String str, String str2) {
        synchronized (this.f19666a) {
            this.f19666a.add(C3504c.m11843a(str, str2));
        }
    }
}
