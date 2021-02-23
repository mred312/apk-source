package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.C3689c;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {

    /* renamed from: a */
    private static Map<Object, GeneratedMessageLite<?, ?>> f20562a = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: a */
        private final MessageType f20563a;
        protected MessageType instance;
        protected boolean isBuilt = false;

        protected Builder(MessageType messagetype) {
            this.f20563a = messagetype;
            this.instance = (GeneratedMessageLite) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* renamed from: c */
        private void m12761c(MessageType messagetype, MessageType messagetype2) {
            C3707h0.m13389a().mo23887e(messagetype).mo23802a(messagetype, messagetype2);
        }

        /* access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        /* access modifiers changed from: protected */
        public void copyOnWriteInternal() {
            MessageType messagetype = (GeneratedMessageLite) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            m12761c(messagetype, this.instance);
            this.instance = messagetype;
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        public final BuilderType clear() {
            this.instance = (GeneratedMessageLite) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        public MessageType getDefaultInstanceForType() {
            return this.f20563a;
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        public BuilderType clone() {
            BuilderType newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.mergeFrom(buildPartial());
            return newBuilderForType;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            m12761c(this.instance, messagetype);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
            copyOnWrite();
            try {
                C3707h0.m13389a().mo23887e(this.instance).mo23810i(this.instance, bArr, i, i + i2, new C3689c.C3691b(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.m12808j();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2) {
            return mergeFrom(bArr, i, i2, ExtensionRegistryLite.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            copyOnWrite();
            try {
                C3707h0.m13389a().mo23887e(this.instance).mo23809h(this.instance, C3700f.m13281P(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
        }

        /* renamed from: d */
        private FieldSet<C3643b> m12762d() {
            FieldSet<C3643b> fieldSet = ((ExtendableMessage) this.instance).extensions;
            if (!fieldSet.mo23294s()) {
                return fieldSet;
            }
            FieldSet<C3643b> c = fieldSet.clone();
            ((ExtendableMessage) this.instance).extensions = c;
            return c;
        }

        /* renamed from: e */
        private void m12763e(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12763e(f);
            copyOnWrite();
            m12762d().mo23280a(f.f20572d, f.mo23366d(type));
            return this;
        }

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12763e(f);
            copyOnWrite();
            m12762d().mo23281b(f.f20572d);
            return this;
        }

        /* access modifiers changed from: protected */
        public void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            MessageType messagetype = this.instance;
            ((ExtendableMessage) messagetype).extensions = ((ExtendableMessage) messagetype).extensions.clone();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtension(extensionLite);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extensionLite);
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).hasExtension(extensionLite);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12763e(f);
            copyOnWrite();
            m12762d().mo23278C(f.f20572d, f.mo23367e(type));
            return this;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [com.google.protobuf.ExtensionLite, com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> r2, int r3) {
            /*
                r1 = this;
                MessageType r0 = r1.instance
                com.google.protobuf.GeneratedMessageLite$ExtendableMessage r0 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r0
                java.lang.Object r2 = r0.getExtension(r2, r3)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableBuilder.getExtension(com.google.protobuf.ExtensionLite, int):java.lang.Object");
        }

        public final MessageType buildPartial() {
            if (this.isBuilt) {
                return (ExtendableMessage) this.instance;
            }
            ((ExtendableMessage) this.instance).extensions.mo23297x();
            return (ExtendableMessage) super.buildPartial();
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i, Type type) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12763e(f);
            copyOnWrite();
            m12762d().mo23279D(f.f20572d, i, f.mo23366d(type));
            return this;
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a */
        final ContainingType f20569a;

        /* renamed from: b */
        final Type f20570b;

        /* renamed from: c */
        final MessageLite f20571c;

        /* renamed from: d */
        final C3643b f20572d;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, C3643b bVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (bVar.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f20569a = containingtype;
                this.f20570b = type;
                this.f20571c = messageLite;
                this.f20572d = bVar;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Object mo23364b(Object obj) {
            if (!this.f20572d.isRepeated()) {
                return mo23365c(obj);
            }
            if (this.f20572d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object c : (List) obj) {
                arrayList.add(mo23365c(c));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Object mo23365c(Object obj) {
            return this.f20572d.getLiteJavaType() == WireFormat.JavaType.ENUM ? this.f20572d.f20578a.findValueByNumber(((Integer) obj).intValue()) : obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public Object mo23366d(Object obj) {
            return this.f20572d.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public Object mo23367e(Object obj) {
            if (!this.f20572d.isRepeated()) {
                return mo23366d(obj);
            }
            if (this.f20572d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object d : (List) obj) {
                arrayList.add(mo23366d(d));
            }
            return arrayList;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.f20569a;
        }

        public Type getDefaultValue() {
            return this.f20570b;
        }

        public WireFormat.FieldType getLiteType() {
            return this.f20572d.getLiteType();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.f20571c;
        }

        public int getNumber() {
            return this.f20572d.getNumber();
        }

        public boolean isRepeated() {
            return this.f20572d.f20581d;
        }
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        private final Class<?> f20574a;

        /* renamed from: b */
        private final String f20575b;

        /* renamed from: c */
        private final byte[] f20576c;

        SerializedForm(MessageLite messageLite) {
            Class<?> cls = messageLite.getClass();
            this.f20574a = cls;
            this.f20575b = cls.getName();
            this.f20576c = messageLite.toByteArray();
        }

        @Deprecated
        /* renamed from: a */
        private Object m12774a() {
            try {
                Field declaredField = m12775b().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.f20576c).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f20575b, e);
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.f20575b, e2);
            } catch (SecurityException e3) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.f20575b, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (InvalidProtocolBufferException e5) {
                throw new RuntimeException("Unable to understand proto buffer", e5);
            }
        }

        /* renamed from: b */
        private Class<?> m12775b() {
            Class<?> cls = this.f20574a;
            return cls != null ? cls : Class.forName(this.f20575b);
        }

        /* renamed from: of */
        public static SerializedForm m12776of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() {
            try {
                Field declaredField = m12775b().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.f20576c).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f20575b, e);
            } catch (NoSuchFieldException unused) {
                return m12774a();
            } catch (SecurityException e2) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.f20575b, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call parsePartialFrom", e3);
            } catch (InvalidProtocolBufferException e4) {
                throw new RuntimeException("Unable to understand proto buffer", e4);
            }
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessageLite$a */
    static /* synthetic */ class C3642a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20577a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.protobuf.WireFormat$JavaType[] r0 = com.google.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20577a = r0
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20577a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.C3642a.<clinit>():void");
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessageLite$b */
    static final class C3643b implements FieldSet.FieldDescriptorLite<C3643b> {

        /* renamed from: a */
        final Internal.EnumLiteMap<?> f20578a;

        /* renamed from: b */
        final int f20579b;

        /* renamed from: c */
        final WireFormat.FieldType f20580c;

        /* renamed from: d */
        final boolean f20581d;

        /* renamed from: e */
        final boolean f20582e;

        C3643b(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.f20578a = enumLiteMap;
            this.f20579b = i;
            this.f20580c = fieldType;
            this.f20581d = z;
            this.f20582e = z2;
        }

        /* renamed from: a */
        public int compareTo(C3643b bVar) {
            return this.f20579b - bVar.f20579b;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.f20578a;
        }

        public WireFormat.JavaType getLiteJavaType() {
            return this.f20580c.getJavaType();
        }

        public WireFormat.FieldType getLiteType() {
            return this.f20580c;
        }

        public int getNumber() {
            return this.f20579b;
        }

        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public boolean isPacked() {
            return this.f20582e;
        }

        public boolean isRepeated() {
            return this.f20581d;
        }
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return C3697e.m13268d();
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return C3706h.m13381d();
    }

    protected static Internal.FloatList emptyFloatList() {
        return C3721m.m13493d();
    }

    protected static Internal.IntList emptyIntList() {
        return C3725o.m13516d();
    }

    protected static Internal.LongList emptyLongList() {
        return C3745r.m13633d();
    }

    protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return C3709i0.m13400b();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> m12749h(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.mo23177a()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    /* renamed from: i */
    private static <T extends GeneratedMessageLite<T, ?>> T m12750i(T t) {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.mo22789d().asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    /* renamed from: j */
    private final void m12751j() {
        if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            this.unknownFields = UnknownFieldSetLite.m13042l();
        }
    }

    /* renamed from: k */
    static <T extends GeneratedMessageLite<?, ?>> T m12752k(Class<T> cls) {
        T t = (GeneratedMessageLite) f20562a.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (GeneratedMessageLite) f20562a.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = ((GeneratedMessageLite) C3752t0.m13745j(cls)).getDefaultInstanceForType();
            if (t != null) {
                f20562a.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    /* renamed from: l */
    static Object m12753l(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    /* renamed from: m */
    private static <T extends GeneratedMessageLite<T, ?>> T m12754m(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance((InputStream) new AbstractMessageLite.Builder.C3596a(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T o = m12756o(t, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return o;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(o);
            }
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }

    protected static Internal.IntList mutableCopy(Internal.IntList intList) {
        int size = intList.size();
        return intList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    /* renamed from: n */
    private static <T extends GeneratedMessageLite<T, ?>> T m12755n(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        T o;
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            o = m12756o(t, newCodedInput, extensionRegistryLite);
            newCodedInput.checkLastTagWas(0);
            return o;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(o);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    protected static Object newMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        return new C3711j0(messageLite, str, objArr);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension(containingtype, Collections.emptyList(), messageLite, new C3643b(enumLiteMap, i, fieldType, true, z), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingtype, type, messageLite, new C3643b(enumLiteMap, i, fieldType, false, false), cls);
    }

    /* renamed from: o */
    static <T extends GeneratedMessageLite<T, ?>> T m12756o(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        T t2 = (GeneratedMessageLite) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            C3722m0 e = C3707h0.m13389a().mo23887e(t2);
            e.mo23809h(t2, C3700f.m13281P(codedInputStream), extensionRegistryLite);
            e.mo23807f(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw e3;
        }
    }

    /* renamed from: p */
    static <T extends GeneratedMessageLite<T, ?>> T m12757p(T t, byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
        T t2 = (GeneratedMessageLite) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            C3722m0 e = C3707h0.m13389a().mo23887e(t2);
            e.mo23810i(t2, bArr, i, i + i2, new C3689c.C3691b(extensionRegistryLite));
            e.mo23807f(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.m12808j().setUnfinishedMessage(t2);
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) {
        T m = m12754m(t, inputStream, ExtensionRegistryLite.getEmptyRegistry());
        m12750i(m);
        return m;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        T parseFrom = parseFrom(t, CodedInputStream.newInstance(byteBuffer), extensionRegistryLite);
        m12750i(parseFrom);
        return parseFrom;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream) {
        return m12756o(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t) {
        f20562a.put(cls, t);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo22787a() {
        return this.memoizedSerializedSize;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo22790e(int i) {
        this.memoizedSerializedSize = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return C3707h0.m13389a().mo23887e(this).mo23803b(this, (GeneratedMessageLite) obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Object mo23323g() {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = C3707h0.m13389a().mo23887e(this).mo23811j(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int d = C3707h0.m13389a().mo23887e(this).mo23805d(this);
        this.memoizedHashCode = d;
        return d;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    /* access modifiers changed from: protected */
    public void makeImmutable() {
        C3707h0.m13389a().mo23887e(this).mo23807f(this);
    }

    /* access modifiers changed from: protected */
    public void mergeLengthDelimitedField(int i, ByteString byteString) {
        m12751j();
        this.unknownFields.mo23694i(i, byteString);
    }

    /* access modifiers changed from: protected */
    public final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.m13041k(this.unknownFields, unknownFieldSetLite);
    }

    /* access modifiers changed from: protected */
    public void mergeVarintField(int i, int i2) {
        m12751j();
        this.unknownFields.mo23695j(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(int i, CodedInputStream codedInputStream) {
        if (WireFormat.getTagWireType(i) == 4) {
            return false;
        }
        m12751j();
        return this.unknownFields.mo23690g(i, codedInputStream);
    }

    public String toString() {
        return C3768y.m13922e(this, super.toString());
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        C3707h0.m13389a().mo23887e(this).mo23806e(this, C3703g.m13332P(codedOutputStream));
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean g = C3707h0.m13389a().mo23887e(t).mo23808g(t);
        if (z) {
            t.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, g ? t : null);
        }
        return g;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return createBuilder().mergeFrom(messagetype);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, (Object) null, (Object) null);
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public final BuilderType toBuilder() {
        BuilderType buildertype = (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: b */
        private final T f20564b;

        public DefaultInstanceBasedParser(T t) {
            this.f20564b = t;
        }

        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return GeneratedMessageLite.m12756o(this.f20564b, codedInputStream, extensionRegistryLite);
        }

        public T parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
            return GeneratedMessageLite.m12757p(this.f20564b, bArr, i, i2, extensionRegistryLite);
        }
    }

    protected static Internal.LongList mutableCopy(Internal.LongList longList) {
        int size = longList.size();
        return longList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer) {
        return parseFrom(t, byteBuffer, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        T m = m12754m(t, inputStream, extensionRegistryLite);
        m12750i(m);
        return m;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString) {
        T parseFrom = parseFrom(t, byteString, ExtensionRegistryLite.getEmptyRegistry());
        m12750i(parseFrom);
        return parseFrom;
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<C3643b> extensions = FieldSet.m12713i();

        protected class ExtensionWriter {

            /* renamed from: a */
            private final Iterator<Map.Entry<C3643b, Object>> f20565a;

            /* renamed from: b */
            private Map.Entry<C3643b, Object> f20566b;

            /* renamed from: c */
            private final boolean f20567c;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, C3642a aVar) {
                this(z);
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) {
                while (true) {
                    Map.Entry<C3643b, Object> entry = this.f20566b;
                    if (entry != null && entry.getKey().getNumber() < i) {
                        C3643b key = this.f20566b.getKey();
                        if (!this.f20567c || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                            FieldSet.m12708H(key, this.f20566b.getValue(), codedOutputStream);
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.f20566b.getValue());
                        }
                        if (this.f20565a.hasNext()) {
                            this.f20566b = this.f20565a.next();
                        } else {
                            this.f20566b = null;
                        }
                    } else {
                        return;
                    }
                }
            }

            private ExtensionWriter(boolean z) {
                Iterator<Map.Entry<C3643b, Object>> w = ExtendableMessage.this.extensions.mo23296w();
                this.f20565a = w;
                if (w.hasNext()) {
                    this.f20566b = w.next();
                }
                this.f20567c = z;
            }
        }

        /* renamed from: q */
        private void m12764q(CodedInputStream codedInputStream, GeneratedExtension<?, ?> generatedExtension, ExtensionRegistryLite extensionRegistryLite, int i) {
            m12767u(codedInputStream, extensionRegistryLite, generatedExtension, WireFormat.m13092a(i, 2), i);
        }

        /* renamed from: s */
        private void m12765s(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<?, ?> generatedExtension) {
            MessageLite messageLite = (MessageLite) this.extensions.mo23287j(generatedExtension.f20572d);
            MessageLite.Builder builder = messageLite != null ? messageLite.toBuilder() : null;
            if (builder == null) {
                builder = generatedExtension.getMessageDefaultInstance().newBuilderForType();
            }
            builder.mergeFrom(byteString, extensionRegistryLite);
            mo23362r().mo23278C(generatedExtension.f20572d, generatedExtension.mo23366d(builder.build()));
        }

        /* renamed from: t */
        private <MessageType extends MessageLite> void m12766t(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            int i = 0;
            ByteString byteString = null;
            GeneratedExtension generatedExtension = null;
            while (true) {
                int readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                } else if (readTag == WireFormat.f20731c) {
                    i = codedInputStream.readUInt32();
                    if (i != 0) {
                        generatedExtension = extensionRegistryLite.findLiteExtensionByNumber(messagetype, i);
                    }
                } else if (readTag == WireFormat.f20732d) {
                    if (i == 0 || generatedExtension == null) {
                        byteString = codedInputStream.readBytes();
                    } else {
                        m12764q(codedInputStream, generatedExtension, extensionRegistryLite, i);
                        byteString = null;
                    }
                } else if (!codedInputStream.skipField(readTag)) {
                    break;
                }
            }
            codedInputStream.checkLastTagWas(WireFormat.f20730b);
            if (byteString != null && i != 0) {
                if (generatedExtension != null) {
                    m12765s(byteString, extensionRegistryLite, generatedExtension);
                } else if (byteString != null) {
                    mergeLengthDelimitedField(i, byteString);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
        /* renamed from: u */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean m12767u(com.google.protobuf.CodedInputStream r6, com.google.protobuf.ExtensionRegistryLite r7, com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r8, int r9, int r10) {
            /*
                r5 = this;
                int r0 = com.google.protobuf.WireFormat.getTagWireType(r9)
                r1 = 0
                r2 = 1
                if (r8 != 0) goto L_0x000b
            L_0x0008:
                r0 = 1
            L_0x0009:
                r3 = 0
                goto L_0x0035
            L_0x000b:
                com.google.protobuf.GeneratedMessageLite$b r3 = r8.f20572d
                com.google.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
                int r3 = com.google.protobuf.FieldSet.m12715p(r3, r1)
                if (r0 != r3) goto L_0x0019
                r0 = 0
                goto L_0x0009
            L_0x0019:
                com.google.protobuf.GeneratedMessageLite$b r3 = r8.f20572d
                boolean r4 = r3.f20581d
                if (r4 == 0) goto L_0x0008
                com.google.protobuf.WireFormat$FieldType r3 = r3.f20580c
                boolean r3 = r3.isPackable()
                if (r3 == 0) goto L_0x0008
                com.google.protobuf.GeneratedMessageLite$b r3 = r8.f20572d
                com.google.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
                int r3 = com.google.protobuf.FieldSet.m12715p(r3, r2)
                if (r0 != r3) goto L_0x0008
                r0 = 0
                r3 = 1
            L_0x0035:
                if (r0 == 0) goto L_0x003c
                boolean r6 = r5.parseUnknownField(r9, r6)
                return r6
            L_0x003c:
                r5.mo23362r()
                if (r3 == 0) goto L_0x0093
                int r7 = r6.readRawVarint32()
                int r7 = r6.pushLimit(r7)
                com.google.protobuf.GeneratedMessageLite$b r9 = r8.f20572d
                com.google.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.ENUM
                if (r9 != r10) goto L_0x0076
            L_0x0053:
                int r9 = r6.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x008e
                int r9 = r6.readEnum()
                com.google.protobuf.GeneratedMessageLite$b r10 = r8.f20572d
                com.google.protobuf.Internal$EnumLiteMap r10 = r10.getEnumType()
                com.google.protobuf.Internal$EnumLite r9 = r10.findValueByNumber(r9)
                if (r9 != 0) goto L_0x006a
                return r2
            L_0x006a:
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$b> r10 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$b r0 = r8.f20572d
                java.lang.Object r9 = r8.mo23366d(r9)
                r10.mo23280a(r0, r9)
                goto L_0x0053
            L_0x0076:
                int r9 = r6.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x008e
                com.google.protobuf.GeneratedMessageLite$b r9 = r8.f20572d
                com.google.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                java.lang.Object r9 = com.google.protobuf.FieldSet.m12704B(r6, r9, r1)
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$b> r10 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$b r0 = r8.f20572d
                r10.mo23280a(r0, r9)
                goto L_0x0076
            L_0x008e:
                r6.popLimit(r7)
                goto L_0x0122
            L_0x0093:
                int[] r9 = com.google.protobuf.GeneratedMessageLite.C3642a.f20577a
                com.google.protobuf.GeneratedMessageLite$b r0 = r8.f20572d
                com.google.protobuf.WireFormat$JavaType r0 = r0.getLiteJavaType()
                int r0 = r0.ordinal()
                r9 = r9[r0]
                if (r9 == r2) goto L_0x00c7
                r7 = 2
                if (r9 == r7) goto L_0x00b1
                com.google.protobuf.GeneratedMessageLite$b r7 = r8.f20572d
                com.google.protobuf.WireFormat$FieldType r7 = r7.getLiteType()
                java.lang.Object r6 = com.google.protobuf.FieldSet.m12704B(r6, r7, r1)
                goto L_0x0103
            L_0x00b1:
                int r6 = r6.readEnum()
                com.google.protobuf.GeneratedMessageLite$b r7 = r8.f20572d
                com.google.protobuf.Internal$EnumLiteMap r7 = r7.getEnumType()
                com.google.protobuf.Internal$EnumLite r7 = r7.findValueByNumber(r6)
                if (r7 != 0) goto L_0x00c5
                r5.mergeVarintField(r10, r6)
                return r2
            L_0x00c5:
                r6 = r7
                goto L_0x0103
            L_0x00c7:
                r9 = 0
                com.google.protobuf.GeneratedMessageLite$b r10 = r8.f20572d
                boolean r10 = r10.isRepeated()
                if (r10 != 0) goto L_0x00e0
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$b> r10 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$b r0 = r8.f20572d
                java.lang.Object r10 = r10.mo23287j(r0)
                com.google.protobuf.MessageLite r10 = (com.google.protobuf.MessageLite) r10
                if (r10 == 0) goto L_0x00e0
                com.google.protobuf.MessageLite$Builder r9 = r10.toBuilder()
            L_0x00e0:
                if (r9 != 0) goto L_0x00ea
                com.google.protobuf.MessageLite r9 = r8.getMessageDefaultInstance()
                com.google.protobuf.MessageLite$Builder r9 = r9.newBuilderForType()
            L_0x00ea:
                com.google.protobuf.GeneratedMessageLite$b r10 = r8.f20572d
                com.google.protobuf.WireFormat$FieldType r10 = r10.getLiteType()
                com.google.protobuf.WireFormat$FieldType r0 = com.google.protobuf.WireFormat.FieldType.GROUP
                if (r10 != r0) goto L_0x00fc
                int r10 = r8.getNumber()
                r6.readGroup((int) r10, (com.google.protobuf.MessageLite.Builder) r9, (com.google.protobuf.ExtensionRegistryLite) r7)
                goto L_0x00ff
            L_0x00fc:
                r6.readMessage((com.google.protobuf.MessageLite.Builder) r9, (com.google.protobuf.ExtensionRegistryLite) r7)
            L_0x00ff:
                com.google.protobuf.MessageLite r6 = r9.build()
            L_0x0103:
                com.google.protobuf.GeneratedMessageLite$b r7 = r8.f20572d
                boolean r7 = r7.isRepeated()
                if (r7 == 0) goto L_0x0117
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$b> r7 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$b r9 = r8.f20572d
                java.lang.Object r6 = r8.mo23366d(r6)
                r7.mo23280a(r9, r6)
                goto L_0x0122
            L_0x0117:
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$b> r7 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$b r9 = r8.f20572d
                java.lang.Object r6 = r8.mo23366d(r6)
                r7.mo23278C(r9, r6)
            L_0x0122:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableMessage.m12767u(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite, com.google.protobuf.GeneratedMessageLite$GeneratedExtension, int, int):boolean");
        }

        /* renamed from: v */
        private void m12768v(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.mo23295t();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.mo23291o();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.mo23288k();
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12768v(f);
            Object j = this.extensions.mo23287j(f.f20572d);
            if (j == null) {
                return f.f20570b;
            }
            return f.mo23364b(j);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12768v(f);
            return this.extensions.mo23290n(f.f20572d);
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12768v(f);
            return this.extensions.mo23292q(f.f20572d);
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(MessageType messagetype) {
            if (this.extensions.mo23294s()) {
                this.extensions = this.extensions.clone();
            }
            this.extensions.mo23298y(messagetype.extensions);
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, (C3642a) null);
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, (C3642a) null);
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean parseUnknownField(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            int tagFieldNumber = WireFormat.getTagFieldNumber(i);
            return m12767u(codedInputStream, extensionRegistryLite, extensionRegistryLite.findLiteExtensionByNumber(messagetype, tagFieldNumber), i, tagFieldNumber);
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            if (i == WireFormat.f20729a) {
                m12766t(messagetype, codedInputStream, extensionRegistryLite);
                return true;
            } else if (WireFormat.getTagWireType(i) == 2) {
                return parseUnknownField(messagetype, codedInputStream, extensionRegistryLite, i);
            } else {
                return codedInputStream.skipField(i);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public FieldSet<C3643b> mo23362r() {
            if (this.extensions.mo23294s()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            GeneratedExtension f = GeneratedMessageLite.m12749h(extensionLite);
            m12768v(f);
            return f.mo23365c(this.extensions.mo23289m(f.f20572d, i));
        }
    }

    protected static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        T n = m12755n(t, byteString, extensionRegistryLite);
        m12750i(n);
        return n;
    }

    protected static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) {
        T p = m12757p(t, bArr, 0, bArr.length, ExtensionRegistryLite.getEmptyRegistry());
        m12750i(p);
        return p;
    }

    protected static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        T p = m12757p(t, bArr, 0, bArr.length, extensionRegistryLite);
        m12750i(p);
        return p;
    }

    protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) {
        T o = m12756o(t, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry());
        m12750i(o);
        return o;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        T o = m12756o(t, CodedInputStream.newInstance(inputStream), extensionRegistryLite);
        m12750i(o);
        return o;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream) {
        return parseFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        T o = m12756o(t, codedInputStream, extensionRegistryLite);
        m12750i(o);
        return o;
    }
}
