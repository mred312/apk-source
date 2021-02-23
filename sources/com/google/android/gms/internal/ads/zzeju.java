package com.google.android.gms.internal.ads;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.ads.zzekh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public class zzeju {

    /* renamed from: b */
    private static volatile zzeju f16209b;

    /* renamed from: c */
    private static volatile zzeju f16210c;

    /* renamed from: d */
    private static final zzeju f16211d = new zzeju(true);

    /* renamed from: a */
    private final Map<C2703a, zzekh.zzd<?, ?>> f16212a;

    /* renamed from: com.google.android.gms.internal.ads.zzeju$a */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    static final class C2703a {

        /* renamed from: a */
        private final Object f16213a;

        /* renamed from: b */
        private final int f16214b;

        C2703a(Object obj, int i) {
            this.f16213a = obj;
            this.f16214b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C2703a)) {
                return false;
            }
            C2703a aVar = (C2703a) obj;
            if (this.f16213a == aVar.f16213a && this.f16214b == aVar.f16214b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f16213a) * SupportMenu.USER_MASK) + this.f16214b;
        }
    }

    zzeju() {
        this.f16212a = new HashMap();
    }

    public static zzeju zzbhe() {
        zzeju zzeju = f16209b;
        if (zzeju == null) {
            synchronized (zzeju.class) {
                zzeju = f16209b;
                if (zzeju == null) {
                    zzeju = f16211d;
                    f16209b = zzeju;
                }
            }
        }
        return zzeju;
    }

    public static zzeju zzbhf() {
        Class<zzeju> cls = zzeju.class;
        zzeju zzeju = f16210c;
        if (zzeju != null) {
            return zzeju;
        }
        synchronized (cls) {
            zzeju zzeju2 = f16210c;
            if (zzeju2 != null) {
                return zzeju2;
            }
            zzeju b = l90.m6447b(cls);
            f16210c = b;
            return b;
        }
    }

    public final <ContainingType extends zzels> zzekh.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.f16212a.get(new C2703a(containingtype, i));
    }

    private zzeju(boolean z) {
        this.f16212a = Collections.emptyMap();
    }
}
