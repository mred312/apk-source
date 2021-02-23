package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

/* renamed from: com.google.android.datatransport.runtime.c */
/* compiled from: AutoValue_TransportContext */
final class C1592c extends TransportContext {

    /* renamed from: a */
    private final String f7224a;

    /* renamed from: b */
    private final byte[] f7225b;

    /* renamed from: c */
    private final Priority f7226c;

    /* renamed from: com.google.android.datatransport.runtime.c$b */
    /* compiled from: AutoValue_TransportContext */
    static final class C1594b extends TransportContext.Builder {

        /* renamed from: a */
        private String f7227a;

        /* renamed from: b */
        private byte[] f7228b;

        /* renamed from: c */
        private Priority f7229c;

        C1594b() {
        }

        public TransportContext build() {
            String str = "";
            if (this.f7227a == null) {
                str = str + " backendName";
            }
            if (this.f7229c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new C1592c(this.f7227a, this.f7228b, this.f7229c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TransportContext.Builder setBackendName(String str) {
            if (str != null) {
                this.f7227a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public TransportContext.Builder setExtras(@Nullable byte[] bArr) {
            this.f7228b = bArr;
            return this;
        }

        public TransportContext.Builder setPriority(Priority priority) {
            if (priority != null) {
                this.f7229c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f7224a.equals(transportContext.getBackendName())) {
            if (!Arrays.equals(this.f7225b, transportContext instanceof C1592c ? ((C1592c) transportContext).f7225b : transportContext.getExtras()) || !this.f7226c.equals(transportContext.getPriority())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getBackendName() {
        return this.f7224a;
    }

    @Nullable
    public byte[] getExtras() {
        return this.f7225b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority getPriority() {
        return this.f7226c;
    }

    public int hashCode() {
        return ((((this.f7224a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f7225b)) * 1000003) ^ this.f7226c.hashCode();
    }

    private C1592c(String str, @Nullable byte[] bArr, Priority priority) {
        this.f7224a = str;
        this.f7225b = bArr;
        this.f7226c = priority;
    }
}
