package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MultiClassKey {

    /* renamed from: a */
    private Class<?> f6509a;

    /* renamed from: b */
    private Class<?> f6510b;

    /* renamed from: c */
    private Class<?> f6511c;

    public MultiClassKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f6509a.equals(multiClassKey.f6509a) && this.f6510b.equals(multiClassKey.f6510b) && Util.bothNullOrEqual(this.f6511c, multiClassKey.f6511c);
    }

    public int hashCode() {
        int hashCode = ((this.f6509a.hashCode() * 31) + this.f6510b.hashCode()) * 31;
        Class<?> cls = this.f6511c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2, (Class<?>) null);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f6509a + ", second=" + this.f6510b + '}';
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2);
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f6509a = cls;
        this.f6510b = cls2;
        this.f6511c = cls3;
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        set(cls, cls2, cls3);
    }
}
