package com.google.protobuf;

/* renamed from: com.google.protobuf.s */
/* compiled from: ManifestSchemaFactory */
final class C3747s implements C3724n0 {

    /* renamed from: b */
    private static final C3767x f20862b = new C3748a();

    /* renamed from: a */
    private final C3767x f20863a;

    /* renamed from: com.google.protobuf.s$a */
    /* compiled from: ManifestSchemaFactory */
    static class C3748a implements C3767x {
        C3748a() {
        }

        /* renamed from: a */
        public C3766w mo23924a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        /* renamed from: b */
        public boolean mo23925b(Class<?> cls) {
            return false;
        }
    }

    /* renamed from: com.google.protobuf.s$b */
    /* compiled from: ManifestSchemaFactory */
    private static class C3749b implements C3767x {

        /* renamed from: a */
        private C3767x[] f20864a;

        C3749b(C3767x... xVarArr) {
            this.f20864a = xVarArr;
        }

        /* renamed from: a */
        public C3766w mo23924a(Class<?> cls) {
            for (C3767x xVar : this.f20864a) {
                if (xVar.mo23925b(cls)) {
                    return xVar.mo23924a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        /* renamed from: b */
        public boolean mo23925b(Class<?> cls) {
            for (C3767x b : this.f20864a) {
                if (b.mo23925b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public C3747s() {
        this(m13661b());
    }

    /* renamed from: b */
    private static C3767x m13661b() {
        return new C3749b(C3723n.m13511c(), m13662c());
    }

    /* renamed from: c */
    private static C3767x m13662c() {
        try {
            return (C3767x) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f20862b;
        }
    }

    /* renamed from: d */
    private static boolean m13663d(C3766w wVar) {
        return wVar.getSyntax() == ProtoSyntax.PROTO2;
    }

    /* renamed from: e */
    private static <T> C3722m0<T> m13664e(Class<T> cls, C3766w wVar) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (m13663d(wVar)) {
                return C3769z.m13940R(cls, wVar, C3696d0.m13265b(), C3738q.m13614b(), C3726o0.m13536M(), C3715l.m13470b(), C3765v.m13912b());
            }
            return C3769z.m13940R(cls, wVar, C3696d0.m13265b(), C3738q.m13614b(), C3726o0.m13536M(), (C3710j<?>) null, C3765v.m13912b());
        } else if (m13663d(wVar)) {
            return C3769z.m13940R(cls, wVar, C3696d0.m13264a(), C3738q.m13613a(), C3726o0.m13531H(), C3715l.m13469a(), C3765v.m13911a());
        } else {
            return C3769z.m13940R(cls, wVar, C3696d0.m13264a(), C3738q.m13613a(), C3726o0.m13532I(), (C3710j<?>) null, C3765v.m13911a());
        }
    }

    /* renamed from: a */
    public <T> C3722m0<T> mo23926a(Class<T> cls) {
        C3726o0.m13533J(cls);
        C3766w a = this.f20863a.mo23924a(cls);
        if (!a.mo23609a()) {
            return m13664e(cls, a);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            return C3686a0.m13141m(C3726o0.m13536M(), C3715l.m13470b(), a.mo23610b());
        }
        return C3686a0.m13141m(C3726o0.m13531H(), C3715l.m13469a(), a.mo23610b());
    }

    private C3747s(C3767x xVar) {
        Internal.m12791b(xVar, "messageInfoFactory");
        this.f20863a = xVar;
    }
}
