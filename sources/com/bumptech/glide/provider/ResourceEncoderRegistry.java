package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {

    /* renamed from: a */
    private final List<C1339a<?>> f6305a = new ArrayList();

    /* renamed from: com.bumptech.glide.provider.ResourceEncoderRegistry$a */
    private static final class C1339a<T> {

        /* renamed from: a */
        private final Class<T> f6306a;

        /* renamed from: b */
        final ResourceEncoder<T> f6307b;

        C1339a(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.f6306a = cls;
            this.f6307b = resourceEncoder;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo10037a(@NonNull Class<?> cls) {
            return this.f6306a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void append(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f6305a.add(new C1339a(cls, resourceEncoder));
    }

    @Nullable
    public synchronized <Z> ResourceEncoder<Z> get(@NonNull Class<Z> cls) {
        int size = this.f6305a.size();
        for (int i = 0; i < size; i++) {
            C1339a aVar = this.f6305a.get(i);
            if (aVar.mo10037a(cls)) {
                return aVar.f6307b;
            }
        }
        return null;
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f6305a.add(0, new C1339a(cls, resourceEncoder));
    }
}
