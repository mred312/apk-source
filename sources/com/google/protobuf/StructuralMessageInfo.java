package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class StructuralMessageInfo implements C3766w {

    /* renamed from: a */
    private final ProtoSyntax f20672a;

    /* renamed from: b */
    private final boolean f20673b;

    /* renamed from: c */
    private final int[] f20674c;

    /* renamed from: d */
    private final FieldInfo[] f20675d;

    /* renamed from: e */
    private final MessageLite f20676e;

    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.f20672a = protoSyntax;
        this.f20673b = z;
        this.f20674c = iArr;
        this.f20675d = fieldInfoArr;
        Internal.m12791b(obj, "defaultInstance");
        this.f20676e = (MessageLite) obj;
    }

    /* renamed from: a */
    public boolean mo23609a() {
        return this.f20673b;
    }

    /* renamed from: b */
    public MessageLite mo23610b() {
        return this.f20676e;
    }

    /* renamed from: c */
    public int[] mo23611c() {
        return this.f20674c;
    }

    /* renamed from: d */
    public FieldInfo[] mo23612d() {
        return this.f20675d;
    }

    public ProtoSyntax getSyntax() {
        return this.f20672a;
    }

    public static final class Builder {

        /* renamed from: a */
        private final List<FieldInfo> f20677a;

        /* renamed from: b */
        private ProtoSyntax f20678b;

        /* renamed from: c */
        private boolean f20679c;

        /* renamed from: d */
        private boolean f20680d;

        /* renamed from: e */
        private int[] f20681e;

        /* renamed from: f */
        private Object f20682f;

        public Builder() {
            this.f20681e = null;
            this.f20677a = new ArrayList();
        }

        public StructuralMessageInfo build() {
            if (this.f20679c) {
                throw new IllegalStateException("Builder can only build once");
            } else if (this.f20678b != null) {
                this.f20679c = true;
                Collections.sort(this.f20677a);
                return new StructuralMessageInfo(this.f20678b, this.f20680d, this.f20681e, (FieldInfo[]) this.f20677a.toArray(new FieldInfo[0]), this.f20682f);
            } else {
                throw new IllegalStateException("Must specify a proto syntax");
            }
        }

        public void withCheckInitialized(int[] iArr) {
            this.f20681e = iArr;
        }

        public void withDefaultInstance(Object obj) {
            this.f20682f = obj;
        }

        public void withField(FieldInfo fieldInfo) {
            if (!this.f20679c) {
                this.f20677a.add(fieldInfo);
                return;
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void withMessageSetWireFormat(boolean z) {
            this.f20680d = z;
        }

        public void withSyntax(ProtoSyntax protoSyntax) {
            Internal.m12791b(protoSyntax, "syntax");
            this.f20678b = protoSyntax;
        }

        public Builder(int i) {
            this.f20681e = null;
            this.f20677a = new ArrayList(i);
        }
    }
}
