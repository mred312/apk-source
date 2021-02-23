package com.google.protobuf;

/* renamed from: com.google.protobuf.r0 */
/* compiled from: UnknownFieldSchema */
abstract class C3746r0<T, B> {
    C3746r0() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo23995a(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo23996b(B b, int i, long j);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo23997c(B b, int i, T t);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void mo23998d(B b, int i, ByteString byteString);

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract void mo23999e(B b, int i, long j);

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract B mo24000f(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract T mo24001g(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public abstract int mo24002h(T t);

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract int mo24003i(T t);

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public abstract void mo24004j(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public abstract T mo24005k(T t, T t2);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo24006l(B r3, com.google.protobuf.C3714k0 r4) {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.mo23814B()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.mo24007m(r3, r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3746r0.mo24006l(java.lang.Object, com.google.protobuf.k0):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final boolean mo24007m(B b, C3714k0 k0Var) {
        int tag = k0Var.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            mo23999e(b, tagFieldNumber, k0Var.mo23825M());
            return true;
        } else if (tagWireType == 1) {
            mo23996b(b, tagFieldNumber, k0Var.mo23832c());
            return true;
        } else if (tagWireType == 2) {
            mo23998d(b, tagFieldNumber, k0Var.mo23818F());
            return true;
        } else if (tagWireType == 3) {
            Object n = mo24008n();
            int a = WireFormat.m13092a(tagFieldNumber, 4);
            mo24006l(n, k0Var);
            if (a == k0Var.getTag()) {
                mo23997c(b, tagFieldNumber, mo24012r(n));
                return true;
            }
            throw InvalidProtocolBufferException.m12799a();
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                mo23995a(b, tagFieldNumber, k0Var.mo23842k());
                return true;
            }
            throw InvalidProtocolBufferException.m12802d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public abstract B mo24008n();

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public abstract void mo24009o(Object obj, B b);

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public abstract void mo24010p(Object obj, T t);

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public abstract boolean mo24011q(C3714k0 k0Var);

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public abstract T mo24012r(B b);

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public abstract void mo24013s(T t, Writer writer);

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public abstract void mo24014t(T t, Writer writer);
}
