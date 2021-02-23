package com.google.protobuf;

import com.bumptech.glide.load.Key;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public final class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;

    /* renamed from: a */
    static final Charset f20591a = Charset.forName(Key.STRING_CHARSET_NAME);

    /* renamed from: b */
    static final Charset f20592b = Charset.forName("ISO-8859-1");

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z);

        boolean getBoolean(int i);

        BooleanList mutableCopyWithCapacity(int i);

        boolean setBoolean(int i, boolean z);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d);

        double getDouble(int i);

        DoubleList mutableCopyWithCapacity(int i);

        double setDouble(int i, double d);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    public interface EnumVerifier {
        boolean isInRange(int i);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f);

        float getFloat(int i);

        FloatList mutableCopyWithCapacity(int i);

        float setFloat(int i, float f);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i);

        int getInt(int i);

        IntList mutableCopyWithCapacity(int i);

        int setInt(int i, int i2);
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* renamed from: a */
        private final List<F> f20593a;

        /* renamed from: b */
        private final Converter<F, T> f20594b;

        public interface Converter<F, T> {
            T convert(F f);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter) {
            this.f20593a = list;
            this.f20594b = converter;
        }

        public T get(int i) {
            return this.f20594b.convert(this.f20593a.get(i));
        }

        public int size() {
            return this.f20593a.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long j);

        long getLong(int i);

        LongList mutableCopyWithCapacity(int i);

        long setLong(int i, long j);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* renamed from: a */
        private final Map<K, RealValue> f20595a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Converter<RealValue, V> f20596b;

        public interface Converter<A, B> {
            A doBackward(B b);

            B doForward(A a);
        }

        /* renamed from: com.google.protobuf.Internal$MapAdapter$a */
        static class C3646a implements Converter<Integer, T> {

            /* renamed from: a */
            final /* synthetic */ EnumLiteMap f20597a;

            /* renamed from: b */
            final /* synthetic */ EnumLite f20598b;

            C3646a(EnumLiteMap enumLiteMap, EnumLite enumLite) {
                this.f20597a = enumLiteMap;
                this.f20598b = enumLite;
            }

            /* renamed from: a */
            public Integer doBackward(T t) {
                return Integer.valueOf(t.getNumber());
            }

            /* renamed from: b */
            public T doForward(Integer num) {
                T findValueByNumber = this.f20597a.findValueByNumber(num.intValue());
                return findValueByNumber == null ? this.f20598b : findValueByNumber;
            }
        }

        /* renamed from: com.google.protobuf.Internal$MapAdapter$b */
        private class C3647b implements Map.Entry<K, V> {

            /* renamed from: a */
            private final Map.Entry<K, RealValue> f20599a;

            public C3647b(Map.Entry<K, RealValue> entry) {
                this.f20599a = entry;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if ((obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue())) {
                    return true;
                }
                return false;
            }

            public K getKey() {
                return this.f20599a.getKey();
            }

            public V getValue() {
                return MapAdapter.this.f20596b.doForward(this.f20599a.getValue());
            }

            public int hashCode() {
                return this.f20599a.hashCode();
            }

            public V setValue(V v) {
                RealValue value = this.f20599a.setValue(MapAdapter.this.f20596b.doBackward(v));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.f20596b.doForward(value);
            }
        }

        /* renamed from: com.google.protobuf.Internal$MapAdapter$c */
        private class C3648c implements Iterator<Map.Entry<K, V>> {

            /* renamed from: a */
            private final Iterator<Map.Entry<K, RealValue>> f20601a;

            public C3648c(Iterator<Map.Entry<K, RealValue>> it) {
                this.f20601a = it;
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                return new C3647b(this.f20601a.next());
            }

            public boolean hasNext() {
                return this.f20601a.hasNext();
            }

            public void remove() {
                this.f20601a.remove();
            }
        }

        /* renamed from: com.google.protobuf.Internal$MapAdapter$d */
        private class C3649d extends AbstractSet<Map.Entry<K, V>> {

            /* renamed from: a */
            private final Set<Map.Entry<K, RealValue>> f20603a;

            public C3649d(Set<Map.Entry<K, RealValue>> set) {
                this.f20603a = set;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new C3648c(this.f20603a.iterator());
            }

            public int size() {
                return this.f20603a.size();
            }
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.f20595a = map;
            this.f20596b = converter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(EnumLiteMap<T> enumLiteMap, T t) {
            return new C3646a(enumLiteMap, t);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new C3649d(this.f20595a.entrySet());
        }

        public V get(Object obj) {
            RealValue realvalue = this.f20595a.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.f20596b.doForward(realvalue);
        }

        public V put(K k, V v) {
            RealValue put = this.f20595a.put(k, this.f20596b.doBackward(v));
            if (put == null) {
                return null;
            }
            return this.f20596b.doForward(put);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    private Internal() {
    }

    /* renamed from: a */
    static <T> T m12790a(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: b */
    static <T> T m12791b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(f20592b);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(f20592b));
    }

    /* renamed from: c */
    static int m12792c(byte[] bArr, int i, int i2) {
        int e = m12794e(i2, bArr, i, i2);
        if (e == 0) {
            return 1;
        }
        return e;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    /* renamed from: d */
    static Object m12793d(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    /* renamed from: e */
    static int m12794e(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            return (MessageLite) method.invoke(method, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get default instance for " + cls, e);
        }
    }

    public static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        int i = 1;
        for (byte[] hashCode : list) {
            i = (i * 31) + hashCode(hashCode);
        }
        return i;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i = 1;
        for (ByteBuffer hashCodeByteBuffer : list) {
            i = (i * 31) + hashCodeByteBuffer(hashCodeByteBuffer);
        }
        return i;
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i = 1;
        for (EnumLite hashEnum : list) {
            i = (i * 31) + hashEnum(hashEnum);
        }
        return i;
    }

    public static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(f20592b), f20591a);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(f20591a);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, f20591a);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return C3759u0.m13853t(bArr);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!equalsByteBuffer(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(byte[] bArr) {
        return m12792c(bArr, 0, bArr.length);
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int e = m12794e(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (e == 0) {
                return 1;
            }
            return e;
        }
        int i = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i];
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i ? duplicate.remaining() : i;
            duplicate.get(bArr, 0, remaining);
            capacity = m12794e(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }
}
