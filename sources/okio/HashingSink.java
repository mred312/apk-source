package okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSink extends ForwardingSink {
    @Nullable

    /* renamed from: b */
    private final MessageDigest f20203b;
    @Nullable

    /* renamed from: c */
    private final Mac f20204c;

    private HashingSink(Sink sink, String str) {
        super(sink);
        try {
            this.f20203b = MessageDigest.getInstance(str);
            this.f20204c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA1");
    }

    public static HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA256");
    }

    public static HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA512");
    }

    public static HashingSink md5(Sink sink) {
        return new HashingSink(sink, "MD5");
    }

    public static HashingSink sha1(Sink sink) {
        return new HashingSink(sink, "SHA-1");
    }

    public static HashingSink sha256(Sink sink) {
        return new HashingSink(sink, "SHA-256");
    }

    public static HashingSink sha512(Sink sink) {
        return new HashingSink(sink, "SHA-512");
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.f20203b;
        return ByteString.m12083of(messageDigest != null ? messageDigest.digest() : this.f20204c.doFinal());
    }

    public void write(Buffer buffer, long j) {
        C3972g.m14445b(buffer.f20194b, 0, j);
        C3578d dVar = buffer.f20193a;
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, (long) (dVar.f20215c - dVar.f20214b));
            MessageDigest messageDigest = this.f20203b;
            if (messageDigest != null) {
                messageDigest.update(dVar.f20213a, dVar.f20214b, min);
            } else {
                this.f20204c.update(dVar.f20213a, dVar.f20214b, min);
            }
            j2 += (long) min;
            dVar = dVar.f20218f;
        }
        super.write(buffer, j);
    }

    private HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
        try {
            Mac instance = Mac.getInstance(str);
            this.f20204c = instance;
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.f20203b = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
