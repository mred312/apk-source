package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
abstract class z10 extends j10<String> {

    /* renamed from: c */
    final CharSequence f12247c;

    /* renamed from: d */
    private final zzdvd f12248d;

    /* renamed from: e */
    private int f12249e = 0;

    /* renamed from: f */
    private int f12250f;

    protected z10(zzdvx zzdvx, CharSequence charSequence) {
        this.f12248d = zzdvx.f15998a;
        this.f12250f = zzdvx.f16000c;
        this.f12247c = charSequence;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo14280a() {
        int i;
        int i2 = this.f12249e;
        while (true) {
            int i3 = this.f12249e;
            if (i3 != -1) {
                int c = mo14950c(i3);
                if (c == -1) {
                    c = this.f12247c.length();
                    this.f12249e = -1;
                } else {
                    this.f12249e = mo14951d(c);
                }
                int i4 = this.f12249e;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.f12249e = i5;
                    if (i5 > this.f12247c.length()) {
                        this.f12249e = -1;
                    }
                } else {
                    while (i2 < c && this.f12248d.zzc(this.f12247c.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.f12248d.zzc(this.f12247c.charAt(i - 1))) {
                        c = i - 1;
                    }
                    int i6 = this.f12250f;
                    if (i6 == 1) {
                        i = this.f12247c.length();
                        this.f12249e = -1;
                        while (i > i2 && this.f12248d.zzc(this.f12247c.charAt(i - 1))) {
                            i--;
                        }
                    } else {
                        this.f12250f = i6 - 1;
                    }
                    return this.f12247c.subSequence(i2, i).toString();
                }
            } else {
                mo14281b();
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract int mo14950c(int i);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract int mo14951d(int i);
}
