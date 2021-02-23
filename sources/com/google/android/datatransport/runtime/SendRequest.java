package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.C1581b;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class SendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract Builder mo11398a(Encoding encoding);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract Builder mo11399b(Event<?> event);

        public abstract SendRequest build();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract Builder mo11401c(Transformer<?, byte[]> transformer);

        public <T> Builder setEvent(Event<T> event, Encoding encoding, Transformer<T, byte[]> transformer) {
            mo11399b(event);
            mo11398a(encoding);
            mo11401c(transformer);
            return this;
        }

        public abstract Builder setTransportContext(TransportContext transportContext);

        public abstract Builder setTransportName(String str);
    }

    SendRequest() {
    }

    /* renamed from: a */
    public static Builder m5032a() {
        return new C1581b.C1583b();
    }

    /* renamed from: b */
    public abstract Encoding mo11392b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract Event<?> mo11393c();

    /* renamed from: d */
    public byte[] mo11394d() {
        return mo11395e().apply(mo11393c().getPayload());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract Transformer<?, byte[]> mo11395e();

    /* renamed from: f */
    public abstract TransportContext mo11396f();

    /* renamed from: g */
    public abstract String mo11397g();
}
