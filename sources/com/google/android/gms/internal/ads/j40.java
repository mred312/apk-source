package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class j40 implements zzeap.C2697a {

    /* renamed from: a */
    private final /* synthetic */ zzeae f9372a;

    j40(zzeae zzeae) {
        this.f9372a = zzeae;
    }

    /* renamed from: b */
    public final <Q> zzdzz<Q> mo14292b(Class<Q> cls) {
        try {
            return new zzeac(this.f9372a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    /* renamed from: c */
    public final Class<?> mo14293c() {
        return this.f9372a.getClass();
    }

    /* renamed from: d */
    public final zzdzz<?> mo14294d() {
        zzeae zzeae = this.f9372a;
        return new zzeac(zzeae, zzeae.mo17422a());
    }

    /* renamed from: e */
    public final Class<?> mo14295e() {
        return null;
    }

    /* renamed from: f */
    public final Set<Class<?>> mo14296f() {
        return this.f9372a.zzazw();
    }
}
