package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {

    /* renamed from: a */
    private final LruCache<Key, String> f5797a = new LruCache<>(1000);

    /* renamed from: b */
    private final Pools.Pool<C1224b> f5798b = FactoryPools.threadSafe(10, new C1223a(this));

    /* renamed from: com.bumptech.glide.load.engine.cache.SafeKeyGenerator$a */
    class C1223a implements FactoryPools.Factory<C1224b> {
        C1223a(SafeKeyGenerator safeKeyGenerator) {
        }

        /* renamed from: a */
        public C1224b create() {
            try {
                return new C1224b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.SafeKeyGenerator$b */
    private static final class C1224b implements FactoryPools.Poolable {

        /* renamed from: a */
        final MessageDigest f5799a;

        /* renamed from: b */
        private final StateVerifier f5800b = StateVerifier.newInstance();

        C1224b(MessageDigest messageDigest) {
            this.f5799a = messageDigest;
        }

        @NonNull
        public StateVerifier getVerifier() {
            return this.f5800b;
        }
    }

    /* renamed from: a */
    private String m4322a(Key key) {
        C1224b bVar = (C1224b) Preconditions.checkNotNull(this.f5798b.acquire());
        try {
            key.updateDiskCacheKey(bVar.f5799a);
            return Util.sha256BytesToHex(bVar.f5799a.digest());
        } finally {
            this.f5798b.release(bVar);
        }
    }

    public String getSafeKey(Key key) {
        String str;
        synchronized (this.f5797a) {
            str = this.f5797a.get(key);
        }
        if (str == null) {
            str = m4322a(key);
        }
        synchronized (this.f5797a) {
            this.f5797a.put(key, str);
        }
        return str;
    }
}
