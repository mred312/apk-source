package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.a */
/* compiled from: ActivityFragmentLifecycle */
class C1331a implements Lifecycle {

    /* renamed from: a */
    private final Set<LifecycleListener> f6281a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f6282b;

    /* renamed from: c */
    private boolean f6283c;

    C1331a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10005a() {
        this.f6283c = true;
        for (T onDestroy : Util.getSnapshot(this.f6281a)) {
            onDestroy.onDestroy();
        }
    }

    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        this.f6281a.add(lifecycleListener);
        if (this.f6283c) {
            lifecycleListener.onDestroy();
        } else if (this.f6282b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10006b() {
        this.f6282b = true;
        for (T onStart : Util.getSnapshot(this.f6281a)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10007c() {
        this.f6282b = false;
        for (T onStop : Util.getSnapshot(this.f6281a)) {
            onStop.onStop();
        }
    }

    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
        this.f6281a.remove(lifecycleListener);
    }
}
