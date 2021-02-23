package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* renamed from: com.google.firebase.platforminfo.a */
/* compiled from: AutoValue_LibraryVersion */
final class C3502a extends C3504c {

    /* renamed from: a */
    private final String f19667a;

    /* renamed from: b */
    private final String f19668b;

    C3502a(String str, String str2) {
        if (str != null) {
            this.f19667a = str;
            if (str2 != null) {
                this.f19668b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    @Nonnull
    /* renamed from: b */
    public String mo21673b() {
        return this.f19667a;
    }

    @Nonnull
    /* renamed from: c */
    public String mo21674c() {
        return this.f19668b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3504c)) {
            return false;
        }
        C3504c cVar = (C3504c) obj;
        if (!this.f19667a.equals(cVar.mo21673b()) || !this.f19668b.equals(cVar.mo21674c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f19667a.hashCode() ^ 1000003) * 1000003) ^ this.f19668b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f19667a + ", version=" + this.f19668b + "}";
    }
}
