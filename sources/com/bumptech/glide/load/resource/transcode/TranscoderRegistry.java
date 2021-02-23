package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class TranscoderRegistry {

    /* renamed from: a */
    private final List<C1327a<?, ?>> f6249a = new ArrayList();

    /* renamed from: com.bumptech.glide.load.resource.transcode.TranscoderRegistry$a */
    private static final class C1327a<Z, R> {

        /* renamed from: a */
        private final Class<Z> f6250a;

        /* renamed from: b */
        private final Class<R> f6251b;

        /* renamed from: c */
        final ResourceTranscoder<Z, R> f6252c;

        C1327a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
            this.f6250a = cls;
            this.f6251b = cls2;
            this.f6252c = resourceTranscoder;
        }

        /* renamed from: a */
        public boolean mo9957a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f6250a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6251b);
        }
    }

    @NonNull
    public synchronized <Z, R> ResourceTranscoder<Z, R> get(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.get();
        }
        for (C1327a next : this.f6249a) {
            if (next.mo9957a(cls, cls2)) {
                return next.f6252c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> getTranscodeClasses(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (C1327a<?, ?> a : this.f6249a) {
            if (a.mo9957a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void register(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f6249a.add(new C1327a(cls, cls2, resourceTranscoder));
    }
}
