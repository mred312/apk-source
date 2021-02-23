package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory$a */
    class C1220a implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a */
        final /* synthetic */ Context f5779a;

        /* renamed from: b */
        final /* synthetic */ String f5780b;

        C1220a(Context context, String str) {
            this.f5779a = context;
            this.f5780b = str;
        }

        public File getCacheDirectory() {
            File cacheDir = this.f5779a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f5780b != null ? new File(cacheDir, this.f5780b) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public InternalCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public InternalCacheDiskCacheFactory(Context context, String str, long j) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new C1220a(context, str), j);
    }
}
