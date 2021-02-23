package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T> {

    /* renamed from: e */
    private static final CacheKeyUpdater<Object> f5606e = new C1170a();

    /* renamed from: a */
    private final T f5607a;

    /* renamed from: b */
    private final CacheKeyUpdater<T> f5608b;

    /* renamed from: c */
    private final String f5609c;

    /* renamed from: d */
    private volatile byte[] f5610d;

    public interface CacheKeyUpdater<T> {
        void update(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    /* renamed from: com.bumptech.glide.load.Option$a */
    class C1170a implements CacheKeyUpdater<Object> {
        C1170a() {
        }

        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    private Option(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        this.f5609c = Preconditions.checkNotEmpty(str);
        this.f5607a = t;
        this.f5608b = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater);
    }

    @NonNull
    /* renamed from: a */
    private static <T> CacheKeyUpdater<T> m4186a() {
        return f5606e;
    }

    @NonNull
    /* renamed from: b */
    private byte[] m4187b() {
        if (this.f5610d == null) {
            this.f5610d = this.f5609c.getBytes(Key.CHARSET);
        }
        return this.f5610d;
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, (Object) null, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str) {
        return new Option<>(str, (Object) null, m4186a());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f5609c.equals(((Option) obj).f5609c);
        }
        return false;
    }

    @Nullable
    public T getDefaultValue() {
        return this.f5607a;
    }

    public int hashCode() {
        return this.f5609c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f5609c + '\'' + '}';
    }

    public void update(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f5608b.update(m4187b(), t, messageDigest);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str, @NonNull T t) {
        return new Option<>(str, t, m4186a());
    }
}
