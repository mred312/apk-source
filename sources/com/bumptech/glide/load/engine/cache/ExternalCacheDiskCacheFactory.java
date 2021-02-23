package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory$a */
    class C1218a implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a */
        final /* synthetic */ Context f5775a;

        /* renamed from: b */
        final /* synthetic */ String f5776b;

        C1218a(Context context, String str) {
            this.f5775a = context;
            this.f5776b = str;
        }

        public File getCacheDirectory() {
            File externalCacheDir = this.f5775a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f5776b != null ? new File(externalCacheDir, this.f5776b) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new C1218a(context, str), (long) i);
    }
}
