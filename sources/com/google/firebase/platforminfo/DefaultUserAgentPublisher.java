package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

public class DefaultUserAgentPublisher implements UserAgentPublisher {

    /* renamed from: a */
    private final String f19663a;

    /* renamed from: b */
    private final GlobalLibraryVersionRegistrar f19664b;

    DefaultUserAgentPublisher(Set<C3504c> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.f19663a = m11838b(set);
        this.f19664b = globalLibraryVersionRegistrar;
    }

    /* renamed from: a */
    static /* synthetic */ UserAgentPublisher m11837a(ComponentContainer componentContainer) {
        return new DefaultUserAgentPublisher(componentContainer.setOf(C3504c.class), GlobalLibraryVersionRegistrar.getInstance());
    }

    /* renamed from: b */
    private static String m11838b(Set<C3504c> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<C3504c> it = set.iterator();
        while (it.hasNext()) {
            C3504c next = it.next();
            sb.append(next.mo21673b());
            sb.append('/');
            sb.append(next.mo21674c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static Component<UserAgentPublisher> component() {
        return Component.builder(UserAgentPublisher.class).add(Dependency.setOf(C3504c.class)).factory(C3503b.m11842a()).build();
    }

    public String getUserAgent() {
        if (this.f19664b.mo21671a().isEmpty()) {
            return this.f19663a;
        }
        return this.f19663a + ' ' + m11838b(this.f19664b.mo21671a());
    }
}
