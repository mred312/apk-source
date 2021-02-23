package androidx.multidex;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* renamed from: androidx.multidex.b */
/* compiled from: ZipUtil */
final class C0860b {

    /* renamed from: androidx.multidex.b$a */
    /* compiled from: ZipUtil */
    static class C0861a {

        /* renamed from: a */
        long f3801a;

        /* renamed from: b */
        long f3802b;

        C0861a() {
        }
    }

    /* renamed from: a */
    static long m2831a(RandomAccessFile randomAccessFile, C0861a aVar) {
        CRC32 crc32 = new CRC32();
        long j = aVar.f3802b;
        randomAccessFile.seek(aVar.f3801a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        }
        return crc32.getValue();
    }

    /* renamed from: b */
    static C0861a m2832b(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length >= 0) {
            long j2 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            if (j2 >= 0) {
                j = j2;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    C0861a aVar = new C0861a();
                    aVar.f3802b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    aVar.f3801a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return aVar;
                }
                length--;
            } while (length >= j);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    /* renamed from: c */
    static long m2833c(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return m2831a(randomAccessFile, m2832b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
