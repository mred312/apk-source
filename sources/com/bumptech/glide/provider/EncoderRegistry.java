package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {

    /* renamed from: a */
    private final List<C1337a<?>> f6291a = new ArrayList();

    /* renamed from: com.bumptech.glide.provider.EncoderRegistry$a */
    private static final class C1337a<T> {

        /* renamed from: a */
        private final Class<T> f6292a;

        /* renamed from: b */
        final Encoder<T> f6293b;

        C1337a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.f6292a = cls;
            this.f6293b = encoder;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo10019a(@NonNull Class<?> cls) {
            return this.f6292a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f6291a.add(new C1337a(cls, encoder));
    }

    @Nullable
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> cls) {
        for (C1337a next : this.f6291a) {
            if (next.mo10019a(cls)) {
                return next.f6293b;
            }
        }
        return null;
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f6291a.add(0, new C1337a(cls, encoder));
    }
}
