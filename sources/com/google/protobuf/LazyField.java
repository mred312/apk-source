package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

public class LazyField extends LazyFieldLite {

    /* renamed from: d */
    private final MessageLite f20610d;

    /* renamed from: com.google.protobuf.LazyField$b */
    static class C3651b<K> implements Map.Entry<K, Object> {

        /* renamed from: a */
        private Map.Entry<K, LazyField> f20611a;

        /* renamed from: a */
        public LazyField mo23429a() {
            return this.f20611a.getValue();
        }

        public K getKey() {
            return this.f20611a.getKey();
        }

        public Object getValue() {
            LazyField value = this.f20611a.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.f20611a.getValue().setValue((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private C3651b(Map.Entry<K, LazyField> entry) {
            this.f20611a = entry;
        }
    }

    /* renamed from: com.google.protobuf.LazyField$c */
    static class C3652c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a */
        private Iterator<Map.Entry<K, Object>> f20612a;

        public C3652c(Iterator<Map.Entry<K, Object>> it) {
            this.f20612a = it;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f20612a.next();
            return next.getValue() instanceof LazyField ? new C3651b(next) : next;
        }

        public boolean hasNext() {
            return this.f20612a.hasNext();
        }

        public void remove() {
            this.f20612a.remove();
        }
    }

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.f20610d = messageLite;
    }

    public boolean containsDefaultInstance() {
        return super.containsDefaultInstance() || this.value == this.f20610d;
    }

    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public MessageLite getValue() {
        return getValue(this.f20610d);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
