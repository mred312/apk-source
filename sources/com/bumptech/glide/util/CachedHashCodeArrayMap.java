package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: i */
    private int f6493i;

    public void clear() {
        this.f6493i = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.f6493i == 0) {
            this.f6493i = super.hashCode();
        }
        return this.f6493i;
    }

    public V put(K k, V v) {
        this.f6493i = 0;
        return super.put(k, v);
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f6493i = 0;
        super.putAll(simpleArrayMap);
    }

    public V removeAt(int i) {
        this.f6493i = 0;
        return super.removeAt(i);
    }

    public V setValueAt(int i, V v) {
        this.f6493i = 0;
        return super.setValueAt(i, v);
    }
}
