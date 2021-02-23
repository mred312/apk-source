package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

public abstract class StateVerifier {

    /* renamed from: com.bumptech.glide.util.pool.StateVerifier$b */
    private static class C1365b extends StateVerifier {

        /* renamed from: a */
        private volatile boolean f6521a;

        C1365b() {
            super();
        }

        /* renamed from: a */
        public void mo10279a(boolean z) {
            this.f6521a = z;
        }

        public void throwIfRecycled() {
            if (this.f6521a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new C1365b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo10279a(boolean z);

    public abstract void throwIfRecycled();

    private StateVerifier() {
    }
}
