package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class k40 implements zzeap.C2697a {

    /* renamed from: a */
    private final /* synthetic */ zzdzz f9565a;

    k40(zzdzz zzdzz) {
        this.f9565a = zzdzz;
    }

    /* renamed from: b */
    public final <Q> zzdzz<Q> mo14292b(Class<Q> cls) {
        if (this.f9565a.zzazr().equals(cls)) {
            return this.f9565a;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    /* renamed from: c */
    public final Class<?> mo14293c() {
        return this.f9565a.getClass();
    }

    /* renamed from: d */
    public final zzdzz<?> mo14294d() {
        return this.f9565a;
    }

    /* renamed from: e */
    public final Class<?> mo14295e() {
        return null;
    }

    /* renamed from: f */
    public final Set<Class<?>> mo14296f() {
        return Collections.singleton(this.f9565a.zzazr());
    }
}
