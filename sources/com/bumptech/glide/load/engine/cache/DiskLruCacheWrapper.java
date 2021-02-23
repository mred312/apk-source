package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: f */
    private static DiskLruCacheWrapper f5769f;

    /* renamed from: a */
    private final SafeKeyGenerator f5770a;

    /* renamed from: b */
    private final File f5771b;

    /* renamed from: c */
    private final long f5772c;

    /* renamed from: d */
    private final C1225a f5773d = new C1225a();

    /* renamed from: e */
    private DiskLruCache f5774e;

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.f5771b = file;
        this.f5772c = j;
        this.f5770a = new SafeKeyGenerator();
    }

    /* renamed from: a */
    private synchronized DiskLruCache m4312a() {
        if (this.f5774e == null) {
            this.f5774e = DiskLruCache.open(this.f5771b, 1, 1, this.f5772c);
        }
        return this.f5774e;
    }

    /* renamed from: b */
    private synchronized void m4313b() {
        this.f5774e = null;
    }

    public static DiskCache create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    public static synchronized DiskCache get(File file, long j) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (f5769f == null) {
                f5769f = new DiskLruCacheWrapper(file, j);
            }
            diskLruCacheWrapper = f5769f;
        }
        return diskLruCacheWrapper;
    }

    public synchronized void clear() {
        try {
            m4312a().delete();
        } catch (IOException e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e);
                }
            } catch (Throwable th) {
                m4313b();
                throw th;
            }
        }
        m4313b();
    }

    public void delete(Key key) {
        try {
            m4312a().remove(this.f5770a.getSafeKey(key));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }

    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache.Editor edit;
        String safeKey = this.f5770a.getSafeKey(key);
        this.f5773d.mo9590a(safeKey);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + safeKey + " for for Key: " + key);
            }
            try {
                DiskLruCache a = m4312a();
                if (a.get(safeKey) == null) {
                    edit = a.edit(safeKey);
                    if (edit != null) {
                        if (writer.write(edit.getFile(0))) {
                            edit.commit();
                        }
                        edit.abortUnlessCommitted();
                        this.f5773d.mo9591b(safeKey);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            } catch (Throwable th) {
                edit.abortUnlessCommitted();
                throw th;
            }
        } finally {
            this.f5773d.mo9591b(safeKey);
        }
    }

    public File get(Key key) {
        String safeKey = this.f5770a.getSafeKey(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + safeKey + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value value = m4312a().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }
}
