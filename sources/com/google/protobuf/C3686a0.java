package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.WireFormat;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.protobuf.a0 */
/* compiled from: MessageSetSchema */
final class C3686a0<T> implements C3722m0<T> {

    /* renamed from: a */
    private final MessageLite f20745a;

    /* renamed from: b */
    private final C3746r0<?, ?> f20746b;

    /* renamed from: c */
    private final boolean f20747c;

    /* renamed from: d */
    private final C3710j<?> f20748d;

    private C3686a0(C3746r0<?, ?> r0Var, C3710j<?> jVar, MessageLite messageLite) {
        this.f20746b = r0Var;
        this.f20747c = jVar.mo23895e(messageLite);
        this.f20748d = jVar;
        this.f20745a = messageLite;
    }

    /* renamed from: k */
    private <UT, UB> int m13139k(C3746r0<UT, UB> r0Var, T t) {
        return r0Var.mo24003i(r0Var.mo24001g(t));
    }

    /* renamed from: l */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void m13140l(C3746r0<UT, UB> r0Var, C3710j<ET> jVar, T t, C3714k0 k0Var, ExtensionRegistryLite extensionRegistryLite) {
        UB f = r0Var.mo24000f(t);
        FieldSet<ET> d = jVar.mo23894d(t);
        do {
            try {
                if (k0Var.mo23814B() == Integer.MAX_VALUE) {
                    r0Var.mo24009o(t, f);
                    return;
                }
            } finally {
                r0Var.mo24009o(t, f);
            }
        } while (m13142n(k0Var, extensionRegistryLite, jVar, d, r0Var, f));
    }

    /* renamed from: m */
    static <T> C3686a0<T> m13141m(C3746r0<?, ?> r0Var, C3710j<?> jVar, MessageLite messageLite) {
        return new C3686a0<>(r0Var, jVar, messageLite);
    }

    /* renamed from: n */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean m13142n(C3714k0 k0Var, ExtensionRegistryLite extensionRegistryLite, C3710j<ET> jVar, FieldSet<ET> fieldSet, C3746r0<UT, UB> r0Var, UB ub) {
        int tag = k0Var.getTag();
        if (tag == WireFormat.f20729a) {
            int i = 0;
            Object obj = null;
            ByteString byteString = null;
            while (k0Var.mo23814B() != Integer.MAX_VALUE) {
                int tag2 = k0Var.getTag();
                if (tag2 == WireFormat.f20731c) {
                    i = k0Var.mo23848q();
                    obj = jVar.mo23892b(extensionRegistryLite, this.f20745a, i);
                } else if (tag2 == WireFormat.f20732d) {
                    if (obj != null) {
                        jVar.mo23898h(k0Var, obj, extensionRegistryLite, fieldSet);
                    } else {
                        byteString = k0Var.mo23818F();
                    }
                } else if (!k0Var.mo23821I()) {
                    break;
                }
            }
            if (k0Var.getTag() == WireFormat.f20730b) {
                if (byteString != null) {
                    if (obj != null) {
                        jVar.mo23899i(byteString, obj, extensionRegistryLite, fieldSet);
                    } else {
                        r0Var.mo23998d(ub, i, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.m12799a();
        } else if (WireFormat.getTagWireType(tag) != 2) {
            return k0Var.mo23821I();
        } else {
            Object b = jVar.mo23892b(extensionRegistryLite, this.f20745a, WireFormat.getTagFieldNumber(tag));
            if (b == null) {
                return r0Var.mo24007m(ub, k0Var);
            }
            jVar.mo23898h(k0Var, b, extensionRegistryLite, fieldSet);
            return true;
        }
    }

    /* renamed from: o */
    private <UT, UB> void m13143o(C3746r0<UT, UB> r0Var, T t, Writer writer) {
        r0Var.mo24013s(r0Var.mo24001g(t), writer);
    }

    /* renamed from: a */
    public void mo23802a(T t, T t2) {
        C3726o0.m13530G(this.f20746b, t, t2);
        if (this.f20747c) {
            C3726o0.m13528E(this.f20748d, t, t2);
        }
    }

    /* renamed from: b */
    public boolean mo23803b(T t, T t2) {
        if (!this.f20746b.mo24001g(t).equals(this.f20746b.mo24001g(t2))) {
            return false;
        }
        if (this.f20747c) {
            return this.f20748d.mo23893c(t).equals(this.f20748d.mo23893c(t2));
        }
        return true;
    }

    /* renamed from: c */
    public T mo23804c() {
        return this.f20745a.newBuilderForType().buildPartial();
    }

    /* renamed from: d */
    public int mo23805d(T t) {
        int hashCode = this.f20746b.mo24001g(t).hashCode();
        return this.f20747c ? (hashCode * 53) + this.f20748d.mo23893c(t).hashCode() : hashCode;
    }

    /* renamed from: e */
    public void mo23806e(T t, Writer writer) {
        Iterator<Map.Entry<?, Object>> w = this.f20748d.mo23893c(t).mo23296w();
        while (w.hasNext()) {
            Map.Entry next = w.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof LazyField.C3651b) {
                writer.mo23778e(fieldDescriptorLite.getNumber(), ((LazyField.C3651b) next).mo23429a().toByteString());
            } else {
                writer.mo23778e(fieldDescriptorLite.getNumber(), next.getValue());
            }
        }
        m13143o(this.f20746b, t, writer);
    }

    /* renamed from: f */
    public void mo23807f(T t) {
        this.f20746b.mo24004j(t);
        this.f20748d.mo23896f(t);
    }

    /* renamed from: g */
    public final boolean mo23808g(T t) {
        return this.f20748d.mo23893c(t).mo23295t();
    }

    /* renamed from: h */
    public void mo23809h(T t, C3714k0 k0Var, ExtensionRegistryLite extensionRegistryLite) {
        m13140l(this.f20746b, this.f20748d, t, k0Var, extensionRegistryLite);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo23810i(T r11, byte[] r12, int r13, int r14, com.google.protobuf.C3689c.C3691b r15) {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            com.google.protobuf.UnknownFieldSetLite r2 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L_0x0011
            com.google.protobuf.UnknownFieldSetLite r1 = com.google.protobuf.UnknownFieldSetLite.m13042l()
            r0.unknownFields = r1
        L_0x0011:
            com.google.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.google.protobuf.FieldSet r11 = r11.mo23362r()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = com.google.protobuf.C3689c.m13166I(r12, r13, r15)
            int r13 = r15.f20752a
            int r3 = com.google.protobuf.WireFormat.f20729a
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = com.google.protobuf.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L_0x0066
            com.google.protobuf.j<?> r2 = r10.f20748d
            com.google.protobuf.ExtensionRegistryLite r3 = r15.f20755d
            com.google.protobuf.MessageLite r5 = r10.f20745a
            int r6 = com.google.protobuf.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.mo23892b(r3, r5, r6)
            r8 = r2
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L_0x005b
            com.google.protobuf.h0 r13 = com.google.protobuf.C3707h0.m13389a()
            com.google.protobuf.MessageLite r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.m0 r13 = r13.mo23886d(r2)
            int r13 = com.google.protobuf.C3689c.m13187p(r13, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$b r2 = r8.f20572d
            java.lang.Object r3 = r15.f20754c
            r11.mo23278C(r2, r3)
            goto L_0x0064
        L_0x005b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.C3689c.m13164G(r2, r3, r4, r5, r6, r7)
        L_0x0064:
            r2 = r8
            goto L_0x0019
        L_0x0066:
            int r13 = com.google.protobuf.C3689c.m13171N(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = com.google.protobuf.C3689c.m13166I(r12, r4, r15)
            int r6 = r15.f20752a
            int r7 = com.google.protobuf.WireFormat.getTagFieldNumber(r6)
            int r8 = com.google.protobuf.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            com.google.protobuf.h0 r6 = com.google.protobuf.C3707h0.m13389a()
            com.google.protobuf.MessageLite r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.m0 r6 = r6.mo23886d(r7)
            int r4 = com.google.protobuf.C3689c.m13187p(r6, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$b r6 = r2.f20572d
            java.lang.Object r7 = r15.f20754c
            r11.mo23278C(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = com.google.protobuf.C3689c.m13173b(r12, r4, r15)
            java.lang.Object r3 = r15.f20754c
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = com.google.protobuf.C3689c.m13166I(r12, r4, r15)
            int r13 = r15.f20752a
            com.google.protobuf.j<?> r2 = r10.f20748d
            com.google.protobuf.ExtensionRegistryLite r6 = r15.f20755d
            com.google.protobuf.MessageLite r7 = r10.f20745a
            java.lang.Object r2 = r2.mo23892b(r6, r7, r13)
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = com.google.protobuf.WireFormat.f20730b
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = com.google.protobuf.C3689c.m13171N(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = com.google.protobuf.WireFormat.m13092a(r13, r5)
            r1.mo23698n(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            com.google.protobuf.InvalidProtocolBufferException r11 = com.google.protobuf.InvalidProtocolBufferException.m12805g()
            goto L_0x00e0
        L_0x00df:
            throw r11
        L_0x00e0:
            goto L_0x00df
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3686a0.mo23810i(java.lang.Object, byte[], int, int, com.google.protobuf.c$b):void");
    }

    /* renamed from: j */
    public int mo23811j(T t) {
        int k = m13139k(this.f20746b, t) + 0;
        return this.f20747c ? k + this.f20748d.mo23893c(t).mo23288k() : k;
    }
}
