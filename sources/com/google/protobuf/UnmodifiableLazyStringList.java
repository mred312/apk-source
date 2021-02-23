package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LazyStringList f20716a;

    /* renamed from: com.google.protobuf.UnmodifiableLazyStringList$a */
    class C3673a implements ListIterator<String> {

        /* renamed from: a */
        ListIterator<String> f20717a;

        /* renamed from: b */
        final /* synthetic */ int f20718b;

        C3673a(int i) {
            this.f20718b = i;
            this.f20717a = UnmodifiableLazyStringList.this.f20716a.listIterator(i);
        }

        /* renamed from: a */
        public void mo23707a(String str) {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ void add(Object obj) {
            mo23707a((String) obj);
            throw null;
        }

        /* renamed from: b */
        public String next() {
            return this.f20717a.next();
        }

        /* renamed from: c */
        public String previous() {
            return this.f20717a.previous();
        }

        /* renamed from: d */
        public void mo23711d(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f20717a.hasNext();
        }

        public boolean hasPrevious() {
            return this.f20717a.hasPrevious();
        }

        public int nextIndex() {
            return this.f20717a.nextIndex();
        }

        public int previousIndex() {
            return this.f20717a.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ void set(Object obj) {
            mo23711d((String) obj);
            throw null;
        }
    }

    /* renamed from: com.google.protobuf.UnmodifiableLazyStringList$b */
    class C3674b implements Iterator<String> {

        /* renamed from: a */
        Iterator<String> f20720a;

        C3674b() {
            this.f20720a = UnmodifiableLazyStringList.this.f20716a.iterator();
        }

        /* renamed from: a */
        public String next() {
            return this.f20720a.next();
        }

        public boolean hasNext() {
            return this.f20720a.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f20716a = lazyStringList;
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.f20716a.asByteArrayList());
    }

    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.f20716a.asByteStringList());
    }

    public byte[] getByteArray(int i) {
        return this.f20716a.getByteArray(i);
    }

    public ByteString getByteString(int i) {
        return this.f20716a.getByteString(i);
    }

    public Object getRaw(int i) {
        return this.f20716a.getRaw(i);
    }

    public List<?> getUnderlyingElements() {
        return this.f20716a.getUnderlyingElements();
    }

    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public Iterator<String> iterator() {
        return new C3674b();
    }

    public ListIterator<String> listIterator(int i) {
        return new C3673a(i);
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    public void set(int i, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f20716a.size();
    }

    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public String get(int i) {
        return (String) this.f20716a.get(i);
    }

    public void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
