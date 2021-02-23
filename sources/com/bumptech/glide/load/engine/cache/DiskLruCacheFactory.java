package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a */
    private final long f5764a;

    /* renamed from: b */
    private final CacheDirectoryGetter f5765b;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$a */
    class C1216a implements CacheDirectoryGetter {

        /* renamed from: a */
        final /* synthetic */ String f5766a;

        C1216a(String str) {
            this.f5766a = str;
        }

        public File getCacheDirectory() {
            return new File(this.f5766a);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$b */
    class C1217b implements CacheDirectoryGetter {

        /* renamed from: a */
        final /* synthetic */ String f5767a;

        /* renamed from: b */
        final /* synthetic */ String f5768b;

        C1217b(String str, String str2) {
            this.f5767a = str;
            this.f5768b = str2;
        }

        public File getCacheDirectory() {
            return new File(this.f5767a, this.f5768b);
        }
    }

    public DiskLruCacheFactory(String str, long j) {
        this((CacheDirectoryGetter) new C1216a(str), j);
    }

    public DiskCache build() {
        File cacheDirectory = this.f5765b.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return DiskLruCacheWrapper.create(cacheDirectory, this.f5764a);
        }
        return null;
    }

    public DiskLruCacheFactory(String str, String str2, long j) {
        this((CacheDirectoryGetter) new C1217b(str, str2), j);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.f5764a = j;
        this.f5765b = cacheDirectoryGetter;
    }
}
