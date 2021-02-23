package com.bumptech.glide.manager;

import androidx.annotation.NonNull;

/* renamed from: com.bumptech.glide.manager.b */
/* compiled from: ApplicationLifecycle */
class C1332b implements Lifecycle {
    C1332b() {
    }

    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
    }
}
