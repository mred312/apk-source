package com.google.android.datatransport.cct.p006a;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* renamed from: com.google.android.datatransport.cct.a.b */
final class C1553b extends zzo {

    /* renamed from: a */
    private final List<zzr> f7102a;

    C1553b(List<zzr> list) {
        if (list != null) {
            this.f7102a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzo) {
            return this.f7102a.equals(((zzo) obj).zza());
        }
        return false;
    }

    public int hashCode() {
        return this.f7102a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f7102a + "}";
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public List<zzr> zza() {
        return this.f7102a;
    }
}
