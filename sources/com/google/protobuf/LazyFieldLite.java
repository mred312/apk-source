package com.google.protobuf;

public class LazyFieldLite {

    /* renamed from: a */
    private ByteString f20613a;

    /* renamed from: b */
    private ExtensionRegistryLite f20614b;

    /* renamed from: c */
    private volatile ByteString f20615c;
    protected volatile MessageLite value;

    static {
        ExtensionRegistryLite.getEmptyRegistry();
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        m12811a(extensionRegistryLite, byteString);
        this.f20614b = extensionRegistryLite;
        this.f20613a = byteString;
    }

    /* renamed from: a */
    private static void m12811a(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
    }

    /* renamed from: b */
    private static MessageLite m12812b(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    public void clear() {
        this.f20613a = null;
        this.value = null;
        this.f20615c = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r2.f20613a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsDefaultInstance() {
        /*
            r2 = this;
            com.google.protobuf.ByteString r0 = r2.f20615c
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.EMPTY
            if (r0 == r1) goto L_0x0013
            com.google.protobuf.MessageLite r0 = r2.value
            if (r0 != 0) goto L_0x0011
            com.google.protobuf.ByteString r0 = r2.f20613a
            if (r0 == 0) goto L_0x0013
            if (r0 != r1) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyFieldLite.containsDefaultInstance():boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.value = r4;
        r3.f20615c = com.google.protobuf.ByteString.EMPTY;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ensureInitialized(com.google.protobuf.MessageLite r4) {
        /*
            r3 = this;
            com.google.protobuf.MessageLite r0 = r3.value
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.protobuf.MessageLite r0 = r3.value     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            com.google.protobuf.ByteString r0 = r3.f20613a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            com.google.protobuf.Parser r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r1 = r3.f20613a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ExtensionRegistryLite r2 = r3.f20614b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.parseFrom((com.google.protobuf.ByteString) r1, (com.google.protobuf.ExtensionRegistryLite) r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.MessageLite r0 = (com.google.protobuf.MessageLite) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.value = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r0 = r3.f20613a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f20615c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.value = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f20615c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.value = r4     // Catch:{ all -> 0x0034 }
            com.google.protobuf.ByteString r4 = com.google.protobuf.ByteString.EMPTY     // Catch:{ all -> 0x0034 }
            r3.f20615c = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyFieldLite.ensureInitialized(com.google.protobuf.MessageLite):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.value;
        MessageLite messageLite2 = lazyFieldLite.value;
        if (messageLite == null && messageLite2 == null) {
            return toByteString().equals(lazyFieldLite.toByteString());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType()));
        }
        return getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
    }

    public int getSerializedSize() {
        if (this.f20615c != null) {
            return this.f20615c.size();
        }
        ByteString byteString = this.f20613a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.value != null) {
            return this.value.getSerializedSize();
        }
        return 0;
    }

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.value;
    }

    public int hashCode() {
        return 1;
    }

    public void merge(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (!lazyFieldLite.containsDefaultInstance()) {
            if (containsDefaultInstance()) {
                set(lazyFieldLite);
                return;
            }
            if (this.f20614b == null) {
                this.f20614b = lazyFieldLite.f20614b;
            }
            ByteString byteString2 = this.f20613a;
            if (byteString2 != null && (byteString = lazyFieldLite.f20613a) != null) {
                this.f20613a = byteString2.concat(byteString);
            } else if (this.value == null && lazyFieldLite.value != null) {
                setValue(m12812b(lazyFieldLite.value, this.f20613a, this.f20614b));
            } else if (this.value == null || lazyFieldLite.value != null) {
                setValue(this.value.toBuilder().mergeFrom(lazyFieldLite.value).build());
            } else {
                setValue(m12812b(this.value, lazyFieldLite.f20613a, lazyFieldLite.f20614b));
            }
        }
    }

    public void mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        if (containsDefaultInstance()) {
            setByteString(codedInputStream.readBytes(), extensionRegistryLite);
            return;
        }
        if (this.f20614b == null) {
            this.f20614b = extensionRegistryLite;
        }
        ByteString byteString = this.f20613a;
        if (byteString != null) {
            setByteString(byteString.concat(codedInputStream.readBytes()), this.f20614b);
            return;
        }
        try {
            setValue(this.value.toBuilder().mergeFrom(codedInputStream, extensionRegistryLite).build());
        } catch (InvalidProtocolBufferException unused) {
        }
    }

    public void set(LazyFieldLite lazyFieldLite) {
        this.f20613a = lazyFieldLite.f20613a;
        this.value = lazyFieldLite.value;
        this.f20615c = lazyFieldLite.f20615c;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.f20614b;
        if (extensionRegistryLite != null) {
            this.f20614b = extensionRegistryLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        m12811a(extensionRegistryLite, byteString);
        this.f20613a = byteString;
        this.f20614b = extensionRegistryLite;
        this.value = null;
        this.f20615c = null;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.f20613a = null;
        this.f20615c = null;
        this.value = messageLite;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (this.f20615c != null) {
            return this.f20615c;
        }
        ByteString byteString = this.f20613a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f20615c != null) {
                ByteString byteString2 = this.f20615c;
                return byteString2;
            }
            if (this.value == null) {
                this.f20615c = ByteString.EMPTY;
            } else {
                this.f20615c = this.value.toByteString();
            }
            ByteString byteString3 = this.f20615c;
            return byteString3;
        }
    }

    public LazyFieldLite() {
    }
}
