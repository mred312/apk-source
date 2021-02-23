package dagger.internal;

import dagger.MembersInjector;

public final class MembersInjectors {

    /* renamed from: dagger.internal.MembersInjectors$a */
    private enum C3917a implements MembersInjector<Object> {
        INSTANCE;

        public void injectMembers(Object obj) {
            Preconditions.checkNotNull(obj, "Cannot inject members into a null reference");
        }
    }

    private MembersInjectors() {
    }

    public static <T> MembersInjector<T> noOp() {
        return C3917a.INSTANCE;
    }
}
