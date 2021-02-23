package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* renamed from: com.google.android.datatransport.runtime.b */
/* compiled from: AutoValue_SendRequest */
final class C1581b extends SendRequest {

    /* renamed from: a */
    private final TransportContext f7189a;

    /* renamed from: b */
    private final String f7190b;

    /* renamed from: c */
    private final Event<?> f7191c;

    /* renamed from: d */
    private final Transformer<?, byte[]> f7192d;

    /* renamed from: e */
    private final Encoding f7193e;

    /* renamed from: com.google.android.datatransport.runtime.b$b */
    /* compiled from: AutoValue_SendRequest */
    static final class C1583b extends SendRequest.Builder {

        /* renamed from: a */
        private TransportContext f7194a;

        /* renamed from: b */
        private String f7195b;

        /* renamed from: c */
        private Event<?> f7196c;

        /* renamed from: d */
        private Transformer<?, byte[]> f7197d;

        /* renamed from: e */
        private Encoding f7198e;

        C1583b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public SendRequest.Builder mo11398a(Encoding encoding) {
            if (encoding != null) {
                this.f7198e = encoding;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public SendRequest.Builder mo11399b(Event<?> event) {
            if (event != null) {
                this.f7196c = event;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        public SendRequest build() {
            String str = "";
            if (this.f7194a == null) {
                str = str + " transportContext";
            }
            if (this.f7195b == null) {
                str = str + " transportName";
            }
            if (this.f7196c == null) {
                str = str + " event";
            }
            if (this.f7197d == null) {
                str = str + " transformer";
            }
            if (this.f7198e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C1581b(this.f7194a, this.f7195b, this.f7196c, this.f7197d, this.f7198e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public SendRequest.Builder mo11401c(Transformer<?, byte[]> transformer) {
            if (transformer != null) {
                this.f7197d = transformer;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        public SendRequest.Builder setTransportContext(TransportContext transportContext) {
            if (transportContext != null) {
                this.f7194a = transportContext;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public SendRequest.Builder setTransportName(String str) {
            if (str != null) {
                this.f7195b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    /* renamed from: b */
    public Encoding mo11392b() {
        return this.f7193e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Event<?> mo11393c() {
        return this.f7191c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Transformer<?, byte[]> mo11395e() {
        return this.f7192d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        if (!this.f7189a.equals(sendRequest.mo11396f()) || !this.f7190b.equals(sendRequest.mo11397g()) || !this.f7191c.equals(sendRequest.mo11393c()) || !this.f7192d.equals(sendRequest.mo11395e()) || !this.f7193e.equals(sendRequest.mo11392b())) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public TransportContext mo11396f() {
        return this.f7189a;
    }

    /* renamed from: g */
    public String mo11397g() {
        return this.f7190b;
    }

    public int hashCode() {
        return ((((((((this.f7189a.hashCode() ^ 1000003) * 1000003) ^ this.f7190b.hashCode()) * 1000003) ^ this.f7191c.hashCode()) * 1000003) ^ this.f7192d.hashCode()) * 1000003) ^ this.f7193e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f7189a + ", transportName=" + this.f7190b + ", event=" + this.f7191c + ", transformer=" + this.f7192d + ", encoding=" + this.f7193e + "}";
    }

    private C1581b(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, Encoding encoding) {
        this.f7189a = transportContext;
        this.f7190b = str;
        this.f7191c = event;
        this.f7192d = transformer;
        this.f7193e = encoding;
    }
}
