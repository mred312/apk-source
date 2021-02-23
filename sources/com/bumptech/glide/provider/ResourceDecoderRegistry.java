package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {

    /* renamed from: a */
    private final List<String> f6300a = new ArrayList();

    /* renamed from: b */
    private final Map<String, List<C1338a<?, ?>>> f6301b = new HashMap();

    /* renamed from: com.bumptech.glide.provider.ResourceDecoderRegistry$a */
    private static class C1338a<T, R> {

        /* renamed from: a */
        private final Class<T> f6302a;

        /* renamed from: b */
        final Class<R> f6303b;

        /* renamed from: c */
        final ResourceDecoder<T, R> f6304c;

        public C1338a(@NonNull Class<T> cls, @NonNull Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f6302a = cls;
            this.f6303b = cls2;
            this.f6304c = resourceDecoder;
        }

        /* renamed from: a */
        public boolean mo10033a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f6302a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6303b);
        }
    }

    @NonNull
    /* renamed from: a */
    private synchronized List<C1338a<?, ?>> m4663a(@NonNull String str) {
        List<C1338a<?, ?>> list;
        if (!this.f6300a.contains(str)) {
            this.f6300a.add(str);
        }
        list = this.f6301b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f6301b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void append(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m4663a(str).add(new C1338a(cls, cls2, resourceDecoder));
    }

    @NonNull
    public synchronized <T, R> List<ResourceDecoder<T, R>> getDecoders(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6300a) {
            List<C1338a> list = this.f6301b.get(str);
            if (list != null) {
                for (C1338a aVar : list) {
                    if (aVar.mo10033a(cls, cls2)) {
                        arrayList.add(aVar.f6304c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> getResourceClasses(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6300a) {
            List<C1338a> list = this.f6301b.get(str);
            if (list != null) {
                for (C1338a aVar : list) {
                    if (aVar.mo10033a(cls, cls2) && !arrayList.contains(aVar.f6303b)) {
                        arrayList.add(aVar.f6303b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void prepend(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m4663a(str).add(0, new C1338a(cls, cls2, resourceDecoder));
    }

    public synchronized void setBucketPriorityList(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f6300a);
        this.f6300a.clear();
        this.f6300a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f6300a.add(str);
            }
        }
    }
}
