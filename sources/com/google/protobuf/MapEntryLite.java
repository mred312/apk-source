package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.util.AbstractMap;
import java.util.Map;

public class MapEntryLite<K, V> {

    /* renamed from: a */
    private final C3657b<K, V> f20624a;

    /* renamed from: b */
    private final K f20625b;

    /* renamed from: c */
    private final V f20626c;

    /* renamed from: com.google.protobuf.MapEntryLite$a */
    static /* synthetic */ class C3656a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20627a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20627a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20627a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20627a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MapEntryLite.C3656a.<clinit>():void");
        }
    }

    /* renamed from: com.google.protobuf.MapEntryLite$b */
    static class C3657b<K, V> {

        /* renamed from: a */
        public final WireFormat.FieldType f20628a;

        /* renamed from: b */
        public final K f20629b;

        /* renamed from: c */
        public final WireFormat.FieldType f20630c;

        /* renamed from: d */
        public final V f20631d;

        public C3657b(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
            this.f20628a = fieldType;
            this.f20629b = k;
            this.f20630c = fieldType2;
            this.f20631d = v;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        this.f20624a = new C3657b<>(fieldType, k, fieldType2, v);
        this.f20625b = k;
        this.f20626c = v;
    }

    /* renamed from: a */
    static <K, V> int m12848a(C3657b<K, V> bVar, K k, V v) {
        return FieldSet.m12710e(bVar.f20628a, 1, k) + FieldSet.m12710e(bVar.f20630c, 2, v);
    }

    /* renamed from: c */
    static <K, V> Map.Entry<K, V> m12849c(CodedInputStream codedInputStream, C3657b<K, V> bVar, ExtensionRegistryLite extensionRegistryLite) {
        K k = bVar.f20629b;
        V v = bVar.f20631d;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.m13092a(1, bVar.f20628a.getWireType())) {
                k = m12850d(codedInputStream, extensionRegistryLite, bVar.f20628a, k);
            } else if (readTag == WireFormat.m13092a(2, bVar.f20630c.getWireType())) {
                v = m12850d(codedInputStream, extensionRegistryLite, bVar.f20630c, v);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    /* renamed from: d */
    static <T> T m12850d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t) {
        int i = C3656a.f20627a[fieldType.ordinal()];
        if (i == 1) {
            MessageLite.Builder builder = ((MessageLite) t).toBuilder();
            codedInputStream.readMessage(builder, extensionRegistryLite);
            return builder.buildPartial();
        } else if (i == 2) {
            return Integer.valueOf(codedInputStream.readEnum());
        } else {
            if (i != 3) {
                return FieldSet.m12704B(codedInputStream, fieldType, true);
            }
            throw new RuntimeException("Groups are not allowed in maps.");
        }
    }

    /* renamed from: e */
    static <K, V> void m12851e(CodedOutputStream codedOutputStream, C3657b<K, V> bVar, K k, V v) {
        FieldSet.m12706F(codedOutputStream, bVar.f20628a, 1, k);
        FieldSet.m12706F(codedOutputStream, bVar.f20630c, 2, v);
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new MapEntryLite<>(fieldType, k, fieldType2, v);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3657b<K, V> mo23508b() {
        return this.f20624a;
    }

    public int computeMessageSize(int i, K k, V v) {
        return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(m12848a(this.f20624a, k, v));
    }

    public K getKey() {
        return this.f20625b;
    }

    public V getValue() {
        return this.f20626c;
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return m12849c(byteString.newCodedInput(), this.f20624a, extensionRegistryLite);
    }

    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        C3657b<K, V> bVar = this.f20624a;
        K k = bVar.f20629b;
        V v = bVar.f20631d;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.m13092a(1, this.f20624a.f20628a.getWireType())) {
                k = m12850d(codedInputStream, extensionRegistryLite, this.f20624a.f20628a, k);
            } else if (readTag == WireFormat.m13092a(2, this.f20624a.f20630c.getWireType())) {
                v = m12850d(codedInputStream, extensionRegistryLite, this.f20624a.f20630c, v);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(pushLimit);
        mapFieldLite.put(k, v);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i, K k, V v) {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeUInt32NoTag(m12848a(this.f20624a, k, v));
        m12851e(codedOutputStream, this.f20624a, k, v);
    }
}
