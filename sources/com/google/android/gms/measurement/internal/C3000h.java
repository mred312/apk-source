package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.measurement.internal.h */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3000h {

    /* renamed from: a */
    final String f18093a;

    /* renamed from: b */
    final String f18094b;

    /* renamed from: c */
    final long f18095c;

    /* renamed from: d */
    final long f18096d;

    /* renamed from: e */
    final long f18097e;

    /* renamed from: f */
    final long f18098f;

    /* renamed from: g */
    final long f18099g;

    /* renamed from: h */
    final Long f18100h;

    /* renamed from: i */
    final Long f18101i;

    /* renamed from: j */
    final Long f18102j;

    /* renamed from: k */
    final Boolean f18103k;

    C3000h(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        long j6 = j;
        long j7 = j2;
        long j8 = j3;
        long j9 = j5;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = true;
        Preconditions.checkArgument(j6 >= 0);
        Preconditions.checkArgument(j7 >= 0);
        Preconditions.checkArgument(j8 >= 0);
        Preconditions.checkArgument(j9 < 0 ? false : z);
        this.f18093a = str;
        this.f18094b = str2;
        this.f18095c = j6;
        this.f18096d = j7;
        this.f18097e = j8;
        this.f18098f = j4;
        this.f18099g = j9;
        this.f18100h = l;
        this.f18101i = l2;
        this.f18102j = l3;
        this.f18103k = bool;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C3000h mo19921a(long j) {
        return new C3000h(this.f18093a, this.f18094b, this.f18095c, this.f18096d, this.f18097e, j, this.f18099g, this.f18100h, this.f18101i, this.f18102j, this.f18103k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C3000h mo19922b(long j, long j2) {
        return new C3000h(this.f18093a, this.f18094b, this.f18095c, this.f18096d, this.f18097e, this.f18098f, j, Long.valueOf(j2), this.f18101i, this.f18102j, this.f18103k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final C3000h mo19923c(Long l, Long l2, Boolean bool) {
        return new C3000h(this.f18093a, this.f18094b, this.f18095c, this.f18096d, this.f18097e, this.f18098f, this.f18099g, this.f18100h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    C3000h(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, 0, 0, 0, j3, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
    }
}
