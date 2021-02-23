package com.google.protobuf;

/* renamed from: com.google.protobuf.j0 */
/* compiled from: RawMessageInfo */
final class C3711j0 implements C3766w {

    /* renamed from: a */
    private final MessageLite f20788a;

    /* renamed from: b */
    private final String f20789b;

    /* renamed from: c */
    private final Object[] f20790c;

    /* renamed from: d */
    private final int f20791d;

    C3711j0(MessageLite messageLite, String str, Object[] objArr) {
        this.f20788a = messageLite;
        this.f20789b = str;
        this.f20790c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f20791d = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f20791d = c | (charAt2 << i);
                return;
            }
        }
    }

    /* renamed from: a */
    public boolean mo23609a() {
        return (this.f20791d & 2) == 2;
    }

    /* renamed from: b */
    public MessageLite mo23610b() {
        return this.f20788a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Object[] mo23901c() {
        return this.f20790c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo23902d() {
        return this.f20789b;
    }

    public ProtoSyntax getSyntax() {
        return (this.f20791d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }
}
