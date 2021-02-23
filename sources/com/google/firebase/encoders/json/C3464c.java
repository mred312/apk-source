package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* renamed from: com.google.firebase.encoders.json.c */
/* compiled from: JsonDataEncoderBuilder */
final /* synthetic */ class C3464c implements ValueEncoder {

    /* renamed from: a */
    private static final C3464c f19558a = new C3464c();

    private C3464c() {
    }

    /* renamed from: a */
    public static ValueEncoder m11742a() {
        return f19558a;
    }

    public void encode(Object obj, Object obj2) {
        ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
    }
}
