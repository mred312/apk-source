package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ViewModel {
    @Nullable

    /* renamed from: a */
    private final Map<String, Object> f3549a = new HashMap();

    /* renamed from: b */
    private volatile boolean f3550b = false;

    /* renamed from: b */
    private static void m2595b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: a */
    public final void mo6273a() {
        this.f3550b = true;
        Map<String, Object> map = this.f3549a;
        if (map != null) {
            synchronized (map) {
                for (Object b : this.f3549a.values()) {
                    m2595b(b);
                }
            }
        }
        onCleared();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public <T> T mo6274c(String str) {
        T t;
        Map<String, Object> map = this.f3549a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = this.f3549a.get(str);
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public <T> T mo6275d(String str, T t) {
        T t2;
        synchronized (this.f3549a) {
            t2 = this.f3549a.get(str);
            if (t2 == null) {
                this.f3549a.put(str, t);
            }
        }
        if (t2 != null) {
            t = t2;
        }
        if (this.f3550b) {
            m2595b(t);
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
    }
}
