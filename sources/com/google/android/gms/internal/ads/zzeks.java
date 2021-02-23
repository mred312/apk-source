package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public class zzeks extends IOException {

    /* renamed from: a */
    private zzels f16270a;

    public zzeks(String str) {
        super(str);
    }

    /* renamed from: a */
    static zzeks m8828a() {
        return new zzeks("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static zzeks m8829b() {
        return new zzeks("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static zzeks m8830c() {
        return new zzeks("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static zzeks m8831d() {
        return new zzeks("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static zzeks m8832e() {
        return new zzeks("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static zzekr m8833f() {
        return new zzekr("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static zzeks m8834g() {
        return new zzeks("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* renamed from: h */
    static zzeks m8835h() {
        return new zzeks("Failed to parse the message.");
    }

    /* renamed from: i */
    static zzeks m8836i() {
        return new zzeks("Protocol message had invalid UTF-8.");
    }

    public final zzeks zzl(zzels zzels) {
        this.f16270a = zzels;
        return this;
    }
}
