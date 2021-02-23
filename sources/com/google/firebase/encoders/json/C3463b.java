package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* renamed from: com.google.firebase.encoders.json.b */
/* compiled from: JsonDataEncoderBuilder */
final /* synthetic */ class C3463b implements ValueEncoder {

    /* renamed from: a */
    private static final C3463b f19557a = new C3463b();

    private C3463b() {
    }

    /* renamed from: a */
    public static ValueEncoder m11741a() {
        return f19557a;
    }

    public void encode(Object obj, Object obj2) {
        ((ValueEncoderContext) obj2).add((String) obj);
    }
}
