package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* renamed from: a */
    private static final ExtensionRegistryLite f20338a = ExtensionRegistryLite.getEmptyRegistry();

    /* renamed from: a */
    private MessageType m12320a(MessageType messagetype) {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw m12321b(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    /* renamed from: b */
    private UninitializedMessageException m12321b(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).mo22789d();
        }
        return new UninitializedMessageException((MessageLite) messagetype);
    }

    public MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        MessageType parsePartialDelimitedFrom = parsePartialDelimitedFrom(inputStream, extensionRegistryLite);
        m12320a(parsePartialDelimitedFrom);
        return parsePartialDelimitedFrom;
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return parsePartialFrom((InputStream) new AbstractMessageLite.Builder.C3596a(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e);
        }
    }

    public MessageType parseDelimitedFrom(InputStream inputStream) {
        return parseDelimitedFrom(inputStream, f20338a);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream) {
        return parsePartialDelimitedFrom(inputStream, f20338a);
    }

    public MessageType parsePartialFrom(CodedInputStream codedInputStream) {
        return (MessageLite) parsePartialFrom(codedInputStream, f20338a);
    }

    public MessageType parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        MessageType messagetype;
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            messagetype = (MessageLite) parsePartialFrom(newCodedInput, extensionRegistryLite);
            newCodedInput.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    public MessageType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        MessageType messagetype = (MessageLite) parsePartialFrom(codedInputStream, extensionRegistryLite);
        m12320a(messagetype);
        return messagetype;
    }

    public MessageType parseFrom(CodedInputStream codedInputStream) {
        return parseFrom(codedInputStream, f20338a);
    }

    public MessageType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        MessageType parsePartialFrom = parsePartialFrom(byteString, extensionRegistryLite);
        m12320a(parsePartialFrom);
        return parsePartialFrom;
    }

    public MessageType parseFrom(ByteString byteString) {
        return parseFrom(byteString, f20338a);
    }

    public MessageType parsePartialFrom(ByteString byteString) {
        return parsePartialFrom(byteString, f20338a);
    }

    public MessageType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        MessageType messagetype;
        try {
            CodedInputStream newInstance = CodedInputStream.newInstance(byteBuffer);
            messagetype = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
            newInstance.checkLastTagWas(0);
            m12320a(messagetype);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    public MessageType parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
        MessageType messagetype;
        try {
            CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i2);
            messagetype = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
            newInstance.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    public MessageType parsePartialFrom(byte[] bArr, int i, int i2) {
        return parsePartialFrom(bArr, i, i2, f20338a);
    }

    public MessageType parseFrom(ByteBuffer byteBuffer) {
        return parseFrom(byteBuffer, f20338a);
    }

    public MessageType parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return parsePartialFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    public MessageType parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
        MessageType parsePartialFrom = parsePartialFrom(bArr, i, i2, extensionRegistryLite);
        m12320a(parsePartialFrom);
        return parsePartialFrom;
    }

    public MessageType parsePartialFrom(byte[] bArr) {
        return parsePartialFrom(bArr, 0, bArr.length, f20338a);
    }

    public MessageType parseFrom(byte[] bArr, int i, int i2) {
        return parseFrom(bArr, i, i2, f20338a);
    }

    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
        MessageType messagetype = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
        try {
            newInstance.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return parseFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    public MessageType parseFrom(byte[] bArr) {
        return parseFrom(bArr, f20338a);
    }

    public MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        MessageType parsePartialFrom = parsePartialFrom(inputStream, extensionRegistryLite);
        m12320a(parsePartialFrom);
        return parsePartialFrom;
    }

    public MessageType parseFrom(InputStream inputStream) {
        return parseFrom(inputStream, f20338a);
    }

    public MessageType parsePartialFrom(InputStream inputStream) {
        return parsePartialFrom(inputStream, f20338a);
    }
}
