package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SetBuilder<T> {

    /* renamed from: a */
    private final List<T> f21065a;

    private SetBuilder(int i) {
        this.f21065a = new ArrayList(i);
    }

    public static <T> SetBuilder<T> newSetBuilder(int i) {
        return new SetBuilder<>(i);
    }

    public SetBuilder<T> add(T t) {
        this.f21065a.add(Preconditions.checkNotNull(t, "Set contributions cannot be null"));
        return this;
    }

    public SetBuilder<T> addAll(Collection<? extends T> collection) {
        for (Object checkNotNull : collection) {
            Preconditions.checkNotNull(checkNotNull, "Set contributions cannot be null");
        }
        this.f21065a.addAll(collection);
        return this;
    }

    public Set<T> build() {
        int size = this.f21065a.size();
        if (size == 0) {
            return Collections.emptySet();
        }
        if (size != 1) {
            return Collections.unmodifiableSet(new HashSet(this.f21065a));
        }
        return Collections.singleton(this.f21065a.get(0));
    }
}
