package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ra0 implements ea0 {

    /* renamed from: a */
    private final zzels f10777a;

    /* renamed from: b */
    private final String f10778b;

    /* renamed from: c */
    private final Object[] f10779c;

    /* renamed from: d */
    private final int f10780d;

    ra0(zzels zzels, String str, Object[] objArr) {
        this.f10777a = zzels;
        this.f10778b = str;
        this.f10779c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f10780d = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f10780d = c | (charAt2 << i);
                return;
            }
        }
    }

    /* renamed from: a */
    public final int mo13895a() {
        return (this.f10780d & 1) == 1 ? zzemd.zziqj : zzemd.zziqk;
    }

    /* renamed from: b */
    public final boolean mo13896b() {
        return (this.f10780d & 2) == 2;
    }

    /* renamed from: c */
    public final zzels mo13897c() {
        return this.f10777a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo14733d() {
        return this.f10778b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final Object[] mo14734e() {
        return this.f10779c;
    }
}
