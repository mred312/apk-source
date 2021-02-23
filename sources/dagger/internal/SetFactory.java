package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public final class SetFactory<T> implements Factory<Set<T>> {

    /* renamed from: c */
    private static final Factory<Set<Object>> f21066c = InstanceFactory.create(Collections.emptySet());

    /* renamed from: a */
    private final List<Provider<T>> f21067a;

    /* renamed from: b */
    private final List<Provider<Collection<T>>> f21068b;

    public static final class Builder<T> {

        /* renamed from: a */
        private final List<Provider<T>> f21069a;

        /* renamed from: b */
        private final List<Provider<Collection<T>>> f21070b;

        public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> provider) {
            this.f21070b.add(provider);
            return this;
        }

        public Builder<T> addProvider(Provider<? extends T> provider) {
            this.f21069a.add(provider);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.f21069a, this.f21070b);
        }

        private Builder(int i, int i2) {
            this.f21069a = DaggerCollections.presizedList(i);
            this.f21070b = DaggerCollections.presizedList(i2);
        }
    }

    public static <T> Builder<T> builder(int i, int i2) {
        return new Builder<>(i, i2);
    }

    public static <T> Factory<Set<T>> empty() {
        return f21066c;
    }

    private SetFactory(List<Provider<T>> list, List<Provider<Collection<T>>> list2) {
        this.f21067a = list;
        this.f21068b = list2;
    }

    public Set<T> get() {
        int size = this.f21067a.size();
        ArrayList arrayList = new ArrayList(this.f21068b.size());
        int size2 = this.f21068b.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) this.f21068b.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet b = DaggerCollections.m14129b(size);
        int size3 = this.f21067a.size();
        for (int i2 = 0; i2 < size3; i2++) {
            b.add(Preconditions.checkNotNull(this.f21067a.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object checkNotNull : (Collection) arrayList.get(i3)) {
                b.add(Preconditions.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(b);
    }
}
