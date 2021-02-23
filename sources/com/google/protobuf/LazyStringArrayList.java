package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends C3685a<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY;

    /* renamed from: c */
    private static final LazyStringArrayList f20616c;

    /* renamed from: b */
    private final List<Object> f20617b;

    /* renamed from: com.google.protobuf.LazyStringArrayList$a */
    private static class C3653a extends AbstractList<byte[]> implements RandomAccess {

        /* renamed from: a */
        private final LazyStringArrayList f20618a;

        C3653a(LazyStringArrayList lazyStringArrayList) {
            this.f20618a = lazyStringArrayList;
        }

        /* renamed from: a */
        public void add(int i, byte[] bArr) {
            this.f20618a.m12820h(i, bArr);
            this.modCount++;
        }

        /* renamed from: b */
        public byte[] get(int i) {
            return this.f20618a.getByteArray(i);
        }

        /* renamed from: c */
        public byte[] remove(int i) {
            String remove = this.f20618a.remove(i);
            this.modCount++;
            return LazyStringArrayList.m12821i(remove);
        }

        /* renamed from: d */
        public byte[] set(int i, byte[] bArr) {
            Object a = this.f20618a.m12825m(i, bArr);
            this.modCount++;
            return LazyStringArrayList.m12821i(a);
        }

        public int size() {
            return this.f20618a.size();
        }
    }

    /* renamed from: com.google.protobuf.LazyStringArrayList$b */
    private static class C3654b extends AbstractList<ByteString> implements RandomAccess {

        /* renamed from: a */
        private final LazyStringArrayList f20619a;

        C3654b(LazyStringArrayList lazyStringArrayList) {
            this.f20619a = lazyStringArrayList;
        }

        /* renamed from: a */
        public void add(int i, ByteString byteString) {
            this.f20619a.m12819g(i, byteString);
            this.modCount++;
        }

        /* renamed from: b */
        public ByteString get(int i) {
            return this.f20619a.getByteString(i);
        }

        /* renamed from: c */
        public ByteString remove(int i) {
            String remove = this.f20619a.remove(i);
            this.modCount++;
            return LazyStringArrayList.m12822j(remove);
        }

        /* renamed from: d */
        public ByteString set(int i, ByteString byteString) {
            Object d = this.f20619a.m12824l(i, byteString);
            this.modCount++;
            return LazyStringArrayList.m12822j(d);
        }

        public int size() {
            return this.f20619a.size();
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        f20616c = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
        EMPTY = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m12819g(int i, ByteString byteString) {
        ensureIsMutable();
        this.f20617b.add(i, byteString);
        this.modCount++;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m12820h(int i, byte[] bArr) {
        ensureIsMutable();
        this.f20617b.add(i, bArr);
        this.modCount++;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static byte[] m12821i(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.toByteArray((String) obj);
        }
        return ((ByteString) obj).toByteArray();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static ByteString m12822j(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    /* renamed from: k */
    private static String m12823k(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public Object m12824l(int i, ByteString byteString) {
        ensureIsMutable();
        return this.f20617b.set(i, byteString);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public Object m12825m(int i, byte[] bArr) {
        ensureIsMutable();
        return this.f20617b.set(i, bArr);
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        ensureIsMutable();
        boolean addAll = this.f20617b.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        ensureIsMutable();
        boolean addAll = this.f20617b.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public List<byte[]> asByteArrayList() {
        return new C3653a(this);
    }

    public List<ByteString> asByteStringList() {
        return new C3654b(this);
    }

    public void clear() {
        ensureIsMutable();
        this.f20617b.clear();
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.List<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getByteArray(int r3) {
        /*
            r2 = this;
            java.util.List<java.lang.Object> r0 = r2.f20617b
            java.lang.Object r0 = r0.get(r3)
            byte[] r1 = m12821i(r0)
            if (r1 == r0) goto L_0x0011
            java.util.List<java.lang.Object> r0 = r2.f20617b
            r0.set(r3, r1)
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyStringArrayList.getByteArray(int):byte[]");
    }

    public ByteString getByteString(int i) {
        Object obj = this.f20617b.get(i);
        ByteString j = m12822j(obj);
        if (j != obj) {
            this.f20617b.set(i, j);
        }
        return j;
    }

    public Object getRaw(int i) {
        return this.f20617b.get(i);
    }

    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f20617b);
    }

    public LazyStringList getUnmodifiableView() {
        return isModifiable() ? new UnmodifiableLazyStringList(this) : this;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        ensureIsMutable();
        for (Object next : lazyStringList.getUnderlyingElements()) {
            if (next instanceof byte[]) {
                byte[] bArr = (byte[]) next;
                this.f20617b.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.f20617b.add(next);
            }
        }
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.f20617b.size();
    }

    public LazyStringArrayList(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public void add(int i, String str) {
        ensureIsMutable();
        this.f20617b.add(i, str);
        this.modCount++;
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.f20617b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public String get(int i) {
        Object obj = this.f20617b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f20617b.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.f20617b.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    public LazyStringArrayList mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f20617b);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public String set(int i, String str) {
        ensureIsMutable();
        return m12823k(this.f20617b.set(i, str));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f20617b = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    public String remove(int i) {
        ensureIsMutable();
        Object remove = this.f20617b.remove(i);
        this.modCount++;
        return m12823k(remove);
    }

    public void add(ByteString byteString) {
        ensureIsMutable();
        this.f20617b.add(byteString);
        this.modCount++;
    }

    public void set(int i, ByteString byteString) {
        m12824l(i, byteString);
    }

    public LazyStringArrayList(List<String> list) {
        this((ArrayList<Object>) new ArrayList(list));
    }

    public void set(int i, byte[] bArr) {
        m12825m(i, bArr);
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.f20617b = arrayList;
    }

    public void add(byte[] bArr) {
        ensureIsMutable();
        this.f20617b.add(bArr);
        this.modCount++;
    }
}
