package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.internal.ads.bz */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1786bz {

    /* renamed from: a */
    private final LinkedList<zzdpn<?>> f7946a = new LinkedList<>();

    /* renamed from: b */
    private final int f7947b;

    /* renamed from: c */
    private final int f7948c;

    /* renamed from: d */
    private final C2119kz f7949d;

    public C1786bz(int i, int i2) {
        this.f7947b = i;
        this.f7948c = i2;
        this.f7949d = new C2119kz();
    }

    /* renamed from: h */
    private final void m5869h() {
        while (!this.f7946a.isEmpty()) {
            if (zzp.zzkx().currentTimeMillis() - this.f7946a.getFirst().zzhmd >= ((long) this.f7948c)) {
                this.f7949d.mo14361g();
                this.f7946a.remove();
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final long mo13719a() {
        return this.f7949d.mo14355a();
    }

    /* renamed from: b */
    public final int mo13720b() {
        m5869h();
        return this.f7946a.size();
    }

    /* renamed from: c */
    public final zzdpn<?> mo13721c() {
        this.f7949d.mo14359e();
        m5869h();
        if (this.f7946a.isEmpty()) {
            return null;
        }
        zzdpn<?> remove = this.f7946a.remove();
        if (remove != null) {
            this.f7949d.mo14360f();
        }
        return remove;
    }

    /* renamed from: d */
    public final long mo13722d() {
        return this.f7949d.mo14356b();
    }

    /* renamed from: e */
    public final int mo13723e() {
        return this.f7949d.mo14357c();
    }

    /* renamed from: f */
    public final String mo13724f() {
        return this.f7949d.mo14358d();
    }

    /* renamed from: g */
    public final zzdqg mo13725g() {
        return this.f7949d.mo14362h();
    }

    /* renamed from: i */
    public final boolean mo13726i(zzdpn<?> zzdpn) {
        this.f7949d.mo14359e();
        m5869h();
        if (this.f7946a.size() == this.f7947b) {
            return false;
        }
        this.f7946a.add(zzdpn);
        return true;
    }
}
