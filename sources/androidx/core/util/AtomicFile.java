package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {

    /* renamed from: a */
    private final File f2564a;

    /* renamed from: b */
    private final File f2565b;

    /* renamed from: c */
    private final File f2566c;

    public AtomicFile(@NonNull File file) {
        this.f2564a = file;
        this.f2565b = new File(file.getPath() + ".new");
        this.f2566c = new File(file.getPath() + ".bak");
    }

    /* renamed from: a */
    private static void m1691a(@NonNull File file, @NonNull File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
        }
        if (!file.renameTo(file2)) {
            Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
        }
    }

    /* renamed from: b */
    private static boolean m1692b(@NonNull FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void delete() {
        this.f2564a.delete();
        this.f2565b.delete();
        this.f2566c.delete();
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            if (!m1692b(fileOutputStream)) {
                Log.e("AtomicFile", "Failed to sync file output stream");
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                Log.e("AtomicFile", "Failed to close file output stream", e);
            }
            if (!this.f2565b.delete()) {
                Log.e("AtomicFile", "Failed to delete new file " + this.f2565b);
            }
        }
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            if (!m1692b(fileOutputStream)) {
                Log.e("AtomicFile", "Failed to sync file output stream");
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                Log.e("AtomicFile", "Failed to close file output stream", e);
            }
            m1691a(this.f2565b, this.f2564a);
        }
    }

    @NonNull
    public File getBaseFile() {
        return this.f2564a;
    }

    @NonNull
    public FileInputStream openRead() {
        if (this.f2566c.exists()) {
            m1691a(this.f2566c, this.f2564a);
        }
        if (this.f2565b.exists() && this.f2564a.exists() && !this.f2565b.delete()) {
            Log.e("AtomicFile", "Failed to delete outdated new file " + this.f2565b);
        }
        return new FileInputStream(this.f2564a);
    }

    @NonNull
    public byte[] readFully() {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[(available + i)];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    @NonNull
    public FileOutputStream startWrite() {
        if (this.f2566c.exists()) {
            m1691a(this.f2566c, this.f2564a);
        }
        try {
            return new FileOutputStream(this.f2565b);
        } catch (FileNotFoundException unused) {
            if (this.f2565b.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.f2565b);
                } catch (FileNotFoundException e) {
                    throw new IOException("Failed to create new file " + this.f2565b, e);
                }
            } else {
                throw new IOException("Failed to create directory for " + this.f2565b);
            }
        }
    }
}
