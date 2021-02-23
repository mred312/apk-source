package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.firebase.components.h */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
class C3244h {

    /* renamed from: com.google.firebase.components.h$b */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3246b {

        /* renamed from: a */
        private final Component<?> f18931a;

        /* renamed from: b */
        private final Set<C3246b> f18932b = new HashSet();

        /* renamed from: c */
        private final Set<C3246b> f18933c = new HashSet();

        C3246b(Component<?> component) {
            this.f18931a = component;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo20817a(C3246b bVar) {
            this.f18932b.add(bVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo20818b(C3246b bVar) {
            this.f18933c.add(bVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Component<?> mo20819c() {
            return this.f18931a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public Set<C3246b> mo20820d() {
            return this.f18932b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public boolean mo20821e() {
            return this.f18932b.isEmpty();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public boolean mo20822f() {
            return this.f18933c.isEmpty();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo20823g(C3246b bVar) {
            this.f18933c.remove(bVar);
        }
    }

    /* renamed from: com.google.firebase.components.h$c */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3247c {

        /* renamed from: a */
        private final Class<?> f18934a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final boolean f18935b;

        public boolean equals(Object obj) {
            if (!(obj instanceof C3247c)) {
                return false;
            }
            C3247c cVar = (C3247c) obj;
            if (!cVar.f18934a.equals(this.f18934a) || cVar.f18935b != this.f18935b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.f18934a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f18935b).hashCode();
        }

        private C3247c(Class<?> cls, boolean z) {
            this.f18934a = cls;
            this.f18935b = z;
        }
    }

    /* renamed from: a */
    static void m11180a(List<Component<?>> list) {
        Set<C3246b> c = m11182c(list);
        Set<C3246b> b = m11181b(c);
        int i = 0;
        while (!b.isEmpty()) {
            C3246b next = b.iterator().next();
            b.remove(next);
            i++;
            for (C3246b next2 : next.mo20820d()) {
                next2.mo20823g(next);
                if (next2.mo20822f()) {
                    b.add(next2);
                }
            }
        }
        if (i != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (C3246b next3 : c) {
                if (!next3.mo20822f() && !next3.mo20821e()) {
                    arrayList.add(next3.mo20819c());
                }
            }
            throw new DependencyCycleException(arrayList);
        }
    }

    /* renamed from: b */
    private static Set<C3246b> m11181b(Set<C3246b> set) {
        HashSet hashSet = new HashSet();
        for (C3246b next : set) {
            if (next.mo20822f()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* renamed from: c */
    private static Set<C3246b> m11182c(List<Component<?>> list) {
        Set<C3246b> set;
        HashMap hashMap = new HashMap(list.size());
        for (Component next : list) {
            C3246b bVar = new C3246b(next);
            Iterator it = next.getProvidedInterfaces().iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls = (Class) it.next();
                    C3247c cVar = new C3247c(cls, !next.isValue());
                    if (!hashMap.containsKey(cVar)) {
                        hashMap.put(cVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(cVar);
                    if (set2.isEmpty() || cVar.f18935b) {
                        set2.add(bVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{cls}));
                    }
                }
            }
        }
        for (Set<C3246b> it2 : hashMap.values()) {
            for (C3246b bVar2 : it2) {
                for (Dependency next2 : bVar2.mo20819c().getDependencies()) {
                    if (next2.isDirectInjection() && (set = (Set) hashMap.get(new C3247c(next2.getInterface(), next2.isSet()))) != null) {
                        for (C3246b bVar3 : set) {
                            bVar2.mo20817a(bVar3);
                            bVar3.mo20818b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }
}
