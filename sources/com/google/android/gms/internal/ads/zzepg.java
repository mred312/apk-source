package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepg<T> implements zzeoz<T>, zzeps<T> {

    /* renamed from: c */
    private static final Object f16355c = new Object();

    /* renamed from: a */
    private volatile zzeps<T> f16356a;

    /* renamed from: b */
    private volatile Object f16357b = f16355c;

    private zzepg(zzeps<T> zzeps) {
        this.f16356a = zzeps;
    }

    public static <P extends zzeps<T>, T> zzeps<T> zzas(P p) {
        zzepl.checkNotNull(p);
        if (p instanceof zzepg) {
            return p;
        }
        return new zzepg(p);
    }

    public static <P extends zzeps<T>, T> zzeoz<T> zzat(P p) {
        if (p instanceof zzeoz) {
            return (zzeoz) p;
        }
        return new zzepg((zzeps) zzepl.checkNotNull(p));
    }

    public final T get() {
        T t = this.f16357b;
        T t2 = f16355c;
        if (t == t2) {
            synchronized (this) {
                t = this.f16357b;
                if (t == t2) {
                    t = this.f16356a.get();
                    T t3 = this.f16357b;
                    if (t3 != t2 && !(t3 instanceof zzepm)) {
                        if (t3 != t) {
                            String valueOf = String.valueOf(t3);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f16357b = t;
                    this.f16356a = null;
                }
            }
        }
        return t;
    }
}
