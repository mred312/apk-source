package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class va0 {

    /* renamed from: a */
    private final ArrayDeque<zzeiu> f11592a;

    private va0() {
        this.f11592a = new ArrayDeque<>();
    }

    /* renamed from: b */
    private final void m7073b(zzeiu zzeiu) {
        while (!zzeiu.zzbfv()) {
            if (zzeiu instanceof ta0) {
                ta0 ta0 = (ta0) zzeiu;
                m7073b(ta0.f11157d);
                zzeiu = ta0.f11158e;
            } else {
                String valueOf = String.valueOf(zzeiu.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int d = m7075d(zzeiu.size());
        int l = ta0.m7005l(d + 1);
        if (this.f11592a.isEmpty() || this.f11592a.peek().size() >= l) {
            this.f11592a.push(zzeiu);
            return;
        }
        int l2 = ta0.m7005l(d);
        zzeiu pop = this.f11592a.pop();
        while (!this.f11592a.isEmpty() && this.f11592a.peek().size() < l2) {
            pop = new ta0(this.f11592a.pop(), pop, (sa0) null);
        }
        ta0 ta02 = new ta0(pop, zzeiu, (sa0) null);
        while (!this.f11592a.isEmpty() && this.f11592a.peek().size() < ta0.m7005l(m7075d(ta02.size()) + 1)) {
            ta02 = new ta0(this.f11592a.pop(), ta02, (sa0) null);
        }
        this.f11592a.push(ta02);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final zzeiu m7074c(zzeiu zzeiu, zzeiu zzeiu2) {
        m7073b(zzeiu);
        m7073b(zzeiu2);
        zzeiu pop = this.f11592a.pop();
        while (!this.f11592a.isEmpty()) {
            pop = new ta0(this.f11592a.pop(), pop, (sa0) null);
        }
        return pop;
    }

    /* renamed from: d */
    private static int m7075d(int i) {
        int binarySearch = Arrays.binarySearch(ta0.f11155h, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ va0(sa0 sa0) {
        this();
    }
}
