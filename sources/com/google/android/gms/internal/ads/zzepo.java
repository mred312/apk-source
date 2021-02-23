package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepo<T> implements zzepf<Set<T>> {

    /* renamed from: c */
    private static final zzepf<Set<Object>> f16361c = zzepi.zzbb(Collections.emptySet());

    /* renamed from: a */
    private final List<zzeps<T>> f16362a;

    /* renamed from: b */
    private final List<zzeps<Collection<T>>> f16363b;

    private zzepo(List<zzeps<T>> list, List<zzeps<Collection<T>>> list2) {
        this.f16362a = list;
        this.f16363b = list2;
    }

    public static <T> zzepq<T> zzas(int i, int i2) {
        return new zzepq<>(i, i2);
    }

    public final /* synthetic */ Object get() {
        int size = this.f16362a.size();
        ArrayList arrayList = new ArrayList(this.f16363b.size());
        int size2 = this.f16363b.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) this.f16363b.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet a = zzepe.m8916a(size);
        int size3 = this.f16362a.size();
        for (int i2 = 0; i2 < size3; i2++) {
            a.add(zzepl.checkNotNull(this.f16362a.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object checkNotNull : (Collection) arrayList.get(i3)) {
                a.add(zzepl.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(a);
    }
}
