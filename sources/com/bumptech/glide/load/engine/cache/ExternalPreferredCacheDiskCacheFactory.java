package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$a */
    class C1219a implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a */
        final /* synthetic */ Context f5777a;

        /* renamed from: b */
        final /* synthetic */ String f5778b;

        C1219a(Context context, String str) {
            this.f5777a = context;
            this.f5778b = str;
        }

        @Nullable
        /* renamed from: a */
        private File m4314a() {
            File cacheDir = this.f5777a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f5778b != null ? new File(cacheDir, this.f5778b) : cacheDir;
        }

        public File getCacheDirectory() {
            File externalCacheDir;
            File a = m4314a();
            if ((a == null || !a.exists()) && (externalCacheDir = this.f5777a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) {
                return this.f5778b != null ? new File(externalCacheDir, this.f5778b) : externalCacheDir;
            }
            return a;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new C1219a(context, str), j);
    }
}
