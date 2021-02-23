package okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource extends ForwardingSource {

    /* renamed from: b */
    private final MessageDigest f21363b;

    /* renamed from: c */
    private final Mac f21364c;

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.f21363b = MessageDigest.getInstance(str);
            this.f21364c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, "MD5");
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, "SHA-1");
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.f21363b;
        return ByteString.m12083of(messageDigest != null ? messageDigest.digest() : this.f21364c.doFinal());
    }

    public long read(Buffer buffer, long j) {
        long read = super.read(buffer, j);
        if (read != -1) {
            long j2 = buffer.f20194b;
            long j3 = j2 - read;
            C3578d dVar = buffer.f20193a;
            while (j2 > j3) {
                dVar = dVar.f20219g;
                j2 -= (long) (dVar.f20215c - dVar.f20214b);
            }
            while (j2 < buffer.f20194b) {
                int i = (int) ((((long) dVar.f20214b) + j3) - j2);
                MessageDigest messageDigest = this.f21363b;
                if (messageDigest != null) {
                    messageDigest.update(dVar.f20213a, i, dVar.f20215c - i);
                } else {
                    this.f21364c.update(dVar.f20213a, i, dVar.f20215c - i);
                }
                j3 = ((long) (dVar.f20215c - dVar.f20214b)) + j2;
                dVar = dVar.f20218f;
                j2 = j3;
            }
        }
        return read;
    }

    private HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        try {
            Mac instance = Mac.getInstance(str);
            this.f21364c = instance;
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.f21363b = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
