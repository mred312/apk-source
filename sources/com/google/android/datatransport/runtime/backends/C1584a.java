package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

/* renamed from: com.google.android.datatransport.runtime.backends.a */
/* compiled from: AutoValue_BackendRequest */
final class C1584a extends BackendRequest {

    /* renamed from: a */
    private final Iterable<EventInternal> f7206a;

    /* renamed from: b */
    private final byte[] f7207b;

    /* renamed from: com.google.android.datatransport.runtime.backends.a$b */
    /* compiled from: AutoValue_BackendRequest */
    static final class C1586b extends BackendRequest.Builder {

        /* renamed from: a */
        private Iterable<EventInternal> f7208a;

        /* renamed from: b */
        private byte[] f7209b;

        C1586b() {
        }

        public BackendRequest build() {
            String str = "";
            if (this.f7208a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new C1584a(this.f7208a, this.f7209b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public BackendRequest.Builder setEvents(Iterable<EventInternal> iterable) {
            if (iterable != null) {
                this.f7208a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public BackendRequest.Builder setExtras(@Nullable byte[] bArr) {
            this.f7209b = bArr;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f7206a.equals(backendRequest.getEvents())) {
            if (Arrays.equals(this.f7207b, backendRequest instanceof C1584a ? ((C1584a) backendRequest).f7207b : backendRequest.getExtras())) {
                return true;
            }
        }
        return false;
    }

    public Iterable<EventInternal> getEvents() {
        return this.f7206a;
    }

    @Nullable
    public byte[] getExtras() {
        return this.f7207b;
    }

    public int hashCode() {
        return ((this.f7206a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f7207b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f7206a + ", extras=" + Arrays.toString(this.f7207b) + "}";
    }

    private C1584a(Iterable<EventInternal> iterable, @Nullable byte[] bArr) {
        this.f7206a = iterable;
        this.f7207b = bArr;
    }
}
