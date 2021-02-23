package com.google.android.gms.internal.measurement;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.measurement.zzhz;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public class zzhm {

    /* renamed from: b */
    private static volatile zzhm f17670b;

    /* renamed from: c */
    private static volatile zzhm f17671c;

    /* renamed from: d */
    private static final zzhm f17672d = new zzhm(true);

    /* renamed from: a */
    private final Map<C2925a, zzhz.zzd<?, ?>> f17673a;

    /* renamed from: com.google.android.gms.internal.measurement.zzhm$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    private static final class C2925a {

        /* renamed from: a */
        private final Object f17674a;

        /* renamed from: b */
        private final int f17675b;

        C2925a(Object obj, int i) {
            this.f17674a = obj;
            this.f17675b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C2925a)) {
                return false;
            }
            C2925a aVar = (C2925a) obj;
            if (this.f17674a == aVar.f17674a && this.f17675b == aVar.f17675b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f17674a) * SupportMenu.USER_MASK) + this.f17675b;
        }
    }

    zzhm() {
        this.f17673a = new HashMap();
    }

    public static zzhm zza() {
        zzhm zzhm = f17670b;
        if (zzhm == null) {
            synchronized (zzhm.class) {
                zzhm = f17670b;
                if (zzhm == null) {
                    zzhm = f17672d;
                    f17670b = zzhm;
                }
            }
        }
        return zzhm;
    }

    public static zzhm zzb() {
        Class<zzhm> cls = zzhm.class;
        zzhm zzhm = f17671c;
        if (zzhm != null) {
            return zzhm;
        }
        synchronized (cls) {
            zzhm zzhm2 = f17671c;
            if (zzhm2 != null) {
                return zzhm2;
            }
            zzhm b = C2756f4.m9406b(cls);
            f17671c = b;
            return b;
        }
    }

    private zzhm(boolean z) {
        this.f17673a = Collections.emptyMap();
    }

    public final <ContainingType extends zzjh> zzhz.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.f17673a.get(new C2925a(containingtype, i));
    }
}
