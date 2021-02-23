package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public class zzih extends IOException {
    public zzih(String str) {
        super(str);
    }

    /* renamed from: a */
    static zzih m10387a() {
        return new zzih("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static zzih m10388b() {
        return new zzih("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static zzih m10389c() {
        return new zzih("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static zzih m10390d() {
        return new zzih("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static zzih m10391e() {
        return new zzih("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static zzik m10392f() {
        return new zzik("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static zzih m10393g() {
        return new zzih("Failed to parse the message.");
    }

    /* renamed from: h */
    static zzih m10394h() {
        return new zzih("Protocol message had invalid UTF-8.");
    }
}
