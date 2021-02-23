package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {

    /* renamed from: b */
    private static volatile boolean f20477b = false;

    /* renamed from: c */
    private static boolean f20478c = true;

    /* renamed from: d */
    private static volatile ExtensionRegistryLite f20479d;

    /* renamed from: e */
    static final ExtensionRegistryLite f20480e = new ExtensionRegistryLite(true);

    /* renamed from: a */
    private final Map<C3630b, GeneratedMessageLite.GeneratedExtension<?, ?>> f20481a;

    /* renamed from: com.google.protobuf.ExtensionRegistryLite$a */
    private static class C3629a {

        /* renamed from: a */
        static final Class<?> f20482a = m12603a();

        /* renamed from: a */
        static Class<?> m12603a() {
            try {
                return Class.forName("com.google.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    /* renamed from: com.google.protobuf.ExtensionRegistryLite$b */
    private static final class C3630b {

        /* renamed from: a */
        private final Object f20483a;

        /* renamed from: b */
        private final int f20484b;

        C3630b(Object obj, int i) {
            this.f20483a = obj;
            this.f20484b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3630b)) {
                return false;
            }
            C3630b bVar = (C3630b) obj;
            if (this.f20483a == bVar.f20483a && this.f20484b == bVar.f20484b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f20483a) * SupportMenu.USER_MASK) + this.f20484b;
        }
    }

    ExtensionRegistryLite() {
        this.f20481a = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite = f20479d;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = f20479d;
                if (extensionRegistryLite == null) {
                    extensionRegistryLite = f20478c ? C3708i.m13395b() : f20480e;
                    f20479d = extensionRegistryLite;
                }
            }
        }
        return extensionRegistryLite;
    }

    public static boolean isEagerlyParseMessageSets() {
        return f20477b;
    }

    public static ExtensionRegistryLite newInstance() {
        return f20478c ? C3708i.m13394a() : new ExtensionRegistryLite();
    }

    public static void setEagerlyParseMessageSets(boolean z) {
        f20477b = z;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.f20481a.put(new C3630b(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return this.f20481a.get(new C3630b(containingtype, i));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == f20480e) {
            this.f20481a = Collections.emptyMap();
        } else {
            this.f20481a = Collections.unmodifiableMap(extensionRegistryLite.f20481a);
        }
    }

    public final void add(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension<?, ?>) (GeneratedMessageLite.GeneratedExtension) extensionLite);
        }
        if (f20478c && C3708i.m13397d(this)) {
            try {
                getClass().getMethod("add", new Class[]{C3629a.f20482a}).invoke(this, new Object[]{extensionLite});
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{extensionLite}), e);
            }
        }
    }

    ExtensionRegistryLite(boolean z) {
        this.f20481a = Collections.emptyMap();
    }
}
