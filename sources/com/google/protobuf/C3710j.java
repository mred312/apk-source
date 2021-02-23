package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Map;

/* renamed from: com.google.protobuf.j */
/* compiled from: ExtensionSchema */
abstract class C3710j<T extends FieldSet.FieldDescriptorLite<T>> {
    C3710j() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract int mo23891a(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract Object mo23892b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract FieldSet<T> mo23893c(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract FieldSet<T> mo23894d(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract boolean mo23895e(MessageLite messageLite);

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract void mo23896f(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract <UT, UB> UB mo23897g(C3714k0 k0Var, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub, C3746r0<UT, UB> r0Var);

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public abstract void mo23898h(C3714k0 k0Var, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet);

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract void mo23899i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet);

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public abstract void mo23900j(Writer writer, Map.Entry<?, ?> entry);
}
