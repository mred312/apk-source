package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {

    /* renamed from: a */
    private final Set<Target<?>> f6280a = Collections.newSetFromMap(new WeakHashMap());

    public void clear() {
        this.f6280a.clear();
    }

    @NonNull
    public List<Target<?>> getAll() {
        return Util.getSnapshot(this.f6280a);
    }

    public void onDestroy() {
        for (T onDestroy : Util.getSnapshot(this.f6280a)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (T onStart : Util.getSnapshot(this.f6280a)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : Util.getSnapshot(this.f6280a)) {
            onStop.onStop();
        }
    }

    public void track(@NonNull Target<?> target) {
        this.f6280a.add(target);
    }

    public void untrack(@NonNull Target<?> target) {
        this.f6280a.remove(target);
    }
}
