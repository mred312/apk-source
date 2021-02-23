package com.google.protobuf;

/* renamed from: com.google.protobuf.s0 */
/* compiled from: UnknownFieldSetLiteSchema */
class C3750s0 extends C3746r0<UnknownFieldSetLite, UnknownFieldSetLite> {
    C3750s0() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public UnknownFieldSetLite mo24001g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public int mo24002h(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public int mo24003i(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public UnknownFieldSetLite mo24005k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return unknownFieldSetLite2.equals(UnknownFieldSetLite.getDefaultInstance()) ? unknownFieldSetLite : UnknownFieldSetLite.m13041k(unknownFieldSetLite, unknownFieldSetLite2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public UnknownFieldSetLite mo24008n() {
        return UnknownFieldSetLite.m13042l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void mo24009o(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        mo24010p(obj, unknownFieldSetLite);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void mo24010p(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public UnknownFieldSetLite mo24022H(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void mo24013s(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.mo23699o(writer);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public void mo24014t(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.writeTo(writer);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo24004j(Object obj) {
        mo24001g(obj).makeImmutable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo24011q(C3714k0 k0Var) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public /* bridge */ /* synthetic */ Object mo24012r(Object obj) {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        mo24022H(unknownFieldSetLite);
        return unknownFieldSetLite;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo23995a(UnknownFieldSetLite unknownFieldSetLite, int i, int i2) {
        unknownFieldSetLite.mo23698n(WireFormat.m13092a(i, 5), Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo23996b(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.mo23698n(WireFormat.m13092a(i, 1), Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo23997c(UnknownFieldSetLite unknownFieldSetLite, int i, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.mo23698n(WireFormat.m13092a(i, 3), unknownFieldSetLite2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo23998d(UnknownFieldSetLite unknownFieldSetLite, int i, ByteString byteString) {
        unknownFieldSetLite.mo23698n(WireFormat.m13092a(i, 2), byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo23999e(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.mo23698n(WireFormat.m13092a(i, 0), Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public UnknownFieldSetLite mo24000f(Object obj) {
        UnknownFieldSetLite A = mo24001g(obj);
        if (A != UnknownFieldSetLite.getDefaultInstance()) {
            return A;
        }
        UnknownFieldSetLite l = UnknownFieldSetLite.m13042l();
        mo24010p(obj, l);
        return l;
    }
}
