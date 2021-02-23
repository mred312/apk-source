package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import com.google.android.gms.internal.ads.zzels;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzeae<KeyProtoT extends zzels> {

    /* renamed from: a */
    private final Class<KeyProtoT> f16092a;

    /* renamed from: b */
    private final Map<Class<?>, zzeag<?, KeyProtoT>> f16093b;

    /* renamed from: c */
    private final Class<?> f16094c;

    @SafeVarargs
    protected zzeae(Class<KeyProtoT> cls, zzeag<?, KeyProtoT>... zzeagArr) {
        this.f16092a = cls;
        HashMap hashMap = new HashMap();
        int length = zzeagArr.length;
        int i = 0;
        while (i < length) {
            zzeag<?, KeyProtoT> zzeag = zzeagArr[i];
            if (hashMap.containsKey(zzeag.mo17429a())) {
                String valueOf = String.valueOf(zzeag.mo17429a().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzeag.mo17429a(), zzeag);
                i++;
            }
        }
        if (zzeagArr.length > 0) {
            this.f16094c = zzeagArr[0].mo17429a();
        } else {
            this.f16094c = Void.class;
        }
        this.f16093b = Collections.unmodifiableMap(hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Class<?> mo17422a() {
        return this.f16094c;
    }

    public abstract String getKeyType();

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) {
        zzeag zzeag = this.f16093b.get(cls);
        if (zzeag != null) {
            return zzeag.zzah(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Class<KeyProtoT> zzazu() {
        return this.f16092a;
    }

    public abstract zzefh.zzb zzazv();

    public final Set<Class<?>> zzazw() {
        return this.f16093b.keySet();
    }

    public zzead<?, KeyProtoT> zzazy() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract void zze(KeyProtoT keyprotot);

    public abstract KeyProtoT zzr(zzeiu zzeiu);
}
