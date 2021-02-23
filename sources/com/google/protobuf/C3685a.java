package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.a */
/* compiled from: AbstractProtobufList */
abstract class C3685a<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
    protected static final int DEFAULT_CAPACITY = 10;

    /* renamed from: a */
    private boolean f20744a = true;

    C3685a() {
    }

    public abstract void add(int i, E e);

    public boolean add(E e) {
        ensureIsMutable();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        ensureIsMutable();
        return super.addAll(collection);
    }

    public void clear() {
        ensureIsMutable();
        super.clear();
    }

    /* access modifiers changed from: protected */
    public void ensureIsMutable() {
        if (!this.f20744a) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean isModifiable() {
        return this.f20744a;
    }

    public final void makeImmutable() {
        this.f20744a = false;
    }

    public abstract E remove(int i);

    public boolean remove(Object obj) {
        ensureIsMutable();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        ensureIsMutable();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        ensureIsMutable();
        return super.retainAll(collection);
    }

    public abstract E set(int i, E e);

    public boolean addAll(int i, Collection<? extends E> collection) {
        ensureIsMutable();
        return super.addAll(i, collection);
    }
}
