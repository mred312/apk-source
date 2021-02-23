package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public abstract class zzfg<E> extends zzey<E> implements Set<E> {
    @NullableDecl

    /* renamed from: b */
    private transient zzfb<E> f17653b;

    zzfg() {
    }

    /* renamed from: f */
    static int m10338f(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d = (double) highestOneBit;
                Double.isNaN(d);
                if (d * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            zzeb.zza(z, (Object) "collection too large");
            return 1073741824;
        }
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfg) || !mo18848g() || !((zzfg) obj).mo18848g() || hashCode() == obj.hashCode()) {
            return zzfv.m10343b(this, obj);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo18848g() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public zzfb<E> mo18776h() {
        return zzfb.m10332f(toArray());
    }

    public int hashCode() {
        return zzfv.m10342a(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzfb<E> zze() {
        zzfb<E> zzfb = this.f17653b;
        if (zzfb != null) {
            return zzfb;
        }
        zzfb<E> h = mo18776h();
        this.f17653b = h;
        return h;
    }
}
