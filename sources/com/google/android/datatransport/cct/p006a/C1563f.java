package com.google.android.datatransport.cct.p006a;

/* renamed from: com.google.android.datatransport.cct.a.f */
final class C1563f extends zzs {

    /* renamed from: a */
    private final long f7135a;

    C1563f(long j) {
        this.f7135a = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzs) || this.f7135a != ((zzs) obj).zza()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f7135a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f7135a + "}";
    }

    public long zza() {
        return this.f7135a;
    }
}
