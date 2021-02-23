package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public class MemoryCacheAdapter implements MemoryCache {

    /* renamed from: a */
    private MemoryCache.ResourceRemovedListener f5782a;

    public void clearMemory() {
    }

    public long getCurrentSize() {
        return 0;
    }

    public long getMaxSize() {
        return 0;
    }

    @Nullable
    public Resource<?> put(@NonNull Key key, @Nullable Resource<?> resource) {
        if (resource == null) {
            return null;
        }
        this.f5782a.onResourceRemoved(resource);
        return null;
    }

    @Nullable
    public Resource<?> remove(@NonNull Key key) {
        return null;
    }

    public void setResourceRemovedListener(@NonNull MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f5782a = resourceRemovedListener;
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int i) {
    }
}
