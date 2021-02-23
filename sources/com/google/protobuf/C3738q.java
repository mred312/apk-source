package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.q */
/* compiled from: ListFieldSchema */
abstract class C3738q {

    /* renamed from: a */
    private static final C3738q f20855a = new C3740b();

    /* renamed from: b */
    private static final C3738q f20856b = new C3741c();

    /* renamed from: com.google.protobuf.q$b */
    /* compiled from: ListFieldSchema */
    private static final class C3740b extends C3738q {

        /* renamed from: c */
        private static final Class<?> f20857c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private C3740b() {
            super();
        }

        /* renamed from: f */
        static <E> List<E> m13618f(Object obj, long j) {
            return (List) C3752t0.m13717F(obj, j);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.protobuf.LazyStringArrayList} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: g */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <L> java.util.List<L> m13619g(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = m13618f(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof com.google.protobuf.LazyStringList
                if (r1 == 0) goto L_0x0014
                com.google.protobuf.LazyStringArrayList r0 = new com.google.protobuf.LazyStringArrayList
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof com.google.protobuf.C3705g0
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof com.google.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x0024
                com.google.protobuf.Internal$ProtobufList r0 = (com.google.protobuf.Internal.ProtobufList) r0
                com.google.protobuf.Internal$ProtobufList r6 = r0.mutableCopyWithCapacity(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                com.google.protobuf.C3752t0.m13733V(r3, r4, r0)
                goto L_0x007f
            L_0x002d:
                java.lang.Class<?> r1 = f20857c
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                com.google.protobuf.C3752t0.m13733V(r3, r4, r1)
            L_0x0049:
                r0 = r1
                goto L_0x007f
            L_0x004b:
                boolean r1 = r0 instanceof com.google.protobuf.UnmodifiableLazyStringList
                if (r1 == 0) goto L_0x0062
                com.google.protobuf.LazyStringArrayList r1 = new com.google.protobuf.LazyStringArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                com.google.protobuf.UnmodifiableLazyStringList r0 = (com.google.protobuf.UnmodifiableLazyStringList) r0
                r1.addAll(r0)
                com.google.protobuf.C3752t0.m13733V(r3, r4, r1)
                goto L_0x0049
            L_0x0062:
                boolean r1 = r0 instanceof com.google.protobuf.C3705g0
                if (r1 == 0) goto L_0x007f
                boolean r1 = r0 instanceof com.google.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x007f
                r1 = r0
                com.google.protobuf.Internal$ProtobufList r1 = (com.google.protobuf.Internal.ProtobufList) r1
                boolean r2 = r1.isModifiable()
                if (r2 != 0) goto L_0x007f
                int r0 = r0.size()
                int r0 = r0 + r6
                com.google.protobuf.Internal$ProtobufList r0 = r1.mutableCopyWithCapacity(r0)
                com.google.protobuf.C3752t0.m13733V(r3, r4, r0)
            L_0x007f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3738q.C3740b.m13619g(java.lang.Object, long, int):java.util.List");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo23982c(Object obj, long j) {
            Object obj2;
            List list = (List) C3752t0.m13717F(obj, j);
            if (list instanceof LazyStringList) {
                obj2 = ((LazyStringList) list).getUnmodifiableView();
            } else if (!f20857c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof C3705g0) || !(list instanceof Internal.ProtobufList)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            C3752t0.m13733V(obj, j, obj2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public <E> void mo23983d(Object obj, Object obj2, long j) {
            List f = m13618f(obj2, j);
            List g = m13619g(obj, j, f.size());
            int size = g.size();
            int size2 = f.size();
            if (size > 0 && size2 > 0) {
                g.addAll(f);
            }
            if (size > 0) {
                f = g;
            }
            C3752t0.m13733V(obj, j, f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public <L> List<L> mo23984e(Object obj, long j) {
            return m13619g(obj, j, 10);
        }
    }

    /* renamed from: com.google.protobuf.q$c */
    /* compiled from: ListFieldSchema */
    private static final class C3741c extends C3738q {
        private C3741c() {
            super();
        }

        /* renamed from: f */
        static <E> Internal.ProtobufList<E> m13623f(Object obj, long j) {
            return (Internal.ProtobufList) C3752t0.m13717F(obj, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo23982c(Object obj, long j) {
            m13623f(obj, j).makeImmutable();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public <E> void mo23983d(Object obj, Object obj2, long j) {
            Internal.ProtobufList f = m13623f(obj, j);
            Internal.ProtobufList f2 = m13623f(obj2, j);
            int size = f.size();
            int size2 = f2.size();
            if (size > 0 && size2 > 0) {
                if (!f.isModifiable()) {
                    f = f.mutableCopyWithCapacity(size2 + size);
                }
                f.addAll(f2);
            }
            if (size > 0) {
                f2 = f;
            }
            C3752t0.m13733V(obj, j, f2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public <L> List<L> mo23984e(Object obj, long j) {
            Internal.ProtobufList f = m13623f(obj, j);
            if (f.isModifiable()) {
                return f;
            }
            int size = f.size();
            Internal.ProtobufList mutableCopyWithCapacity = f.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            C3752t0.m13733V(obj, j, mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    /* renamed from: a */
    static C3738q m13613a() {
        return f20855a;
    }

    /* renamed from: b */
    static C3738q m13614b() {
        return f20856b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo23982c(Object obj, long j);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract <L> void mo23983d(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract <L> List<L> mo23984e(Object obj, long j);

    private C3738q() {
    }
}
