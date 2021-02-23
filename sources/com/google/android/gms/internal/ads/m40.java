package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class m40 implements zzeap.C2697a {

    /* renamed from: a */
    private final /* synthetic */ zzeaq f9911a;

    /* renamed from: b */
    private final /* synthetic */ zzeae f9912b;

    m40(zzeaq zzeaq, zzeae zzeae) {
        this.f9911a = zzeaq;
        this.f9912b = zzeae;
    }

    /* renamed from: b */
    public final <Q> zzdzz<Q> mo14292b(Class<Q> cls) {
        try {
            return new zzean(this.f9911a, this.f9912b, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    /* renamed from: c */
    public final Class<?> mo14293c() {
        return this.f9911a.getClass();
    }

    /* renamed from: d */
    public final zzdzz<?> mo14294d() {
        zzeaq zzeaq = this.f9911a;
        return new zzean(zzeaq, this.f9912b, zzeaq.mo17422a());
    }

    /* renamed from: e */
    public final Class<?> mo14295e() {
        return this.f9912b.getClass();
    }

    /* renamed from: f */
    public final Set<Class<?>> mo14296f() {
        return this.f9911a.zzazw();
    }
}
