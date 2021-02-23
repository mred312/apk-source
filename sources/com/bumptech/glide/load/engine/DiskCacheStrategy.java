package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = new C1181a();
    public static final DiskCacheStrategy AUTOMATIC = new C1185e();
    public static final DiskCacheStrategy DATA = new C1183c();
    public static final DiskCacheStrategy NONE = new C1182b();
    public static final DiskCacheStrategy RESOURCE = new C1184d();

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$a */
    class C1181a extends DiskCacheStrategy {
        C1181a() {
        }

        public boolean decodeCachedData() {
            return true;
        }

        public boolean decodeCachedResource() {
            return true;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$b */
    class C1182b extends DiskCacheStrategy {
        C1182b() {
        }

        public boolean decodeCachedData() {
            return false;
        }

        public boolean decodeCachedResource() {
            return false;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$c */
    class C1183c extends DiskCacheStrategy {
        C1183c() {
        }

        public boolean decodeCachedData() {
            return true;
        }

        public boolean decodeCachedResource() {
            return false;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$d */
    class C1184d extends DiskCacheStrategy {
        C1184d() {
        }

        public boolean decodeCachedData() {
            return false;
        }

        public boolean decodeCachedResource() {
            return true;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$e */
    class C1185e extends DiskCacheStrategy {
        C1185e() {
        }

        public boolean decodeCachedData() {
            return true;
        }

        public boolean decodeCachedResource() {
            return true;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource dataSource);

    public abstract boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
