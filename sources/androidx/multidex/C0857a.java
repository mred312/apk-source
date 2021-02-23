package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* renamed from: androidx.multidex.a */
/* compiled from: MultiDexExtractor */
final class C0857a implements Closeable {

    /* renamed from: a */
    private final File f3794a;

    /* renamed from: b */
    private final long f3795b;

    /* renamed from: c */
    private final File f3796c;

    /* renamed from: d */
    private final RandomAccessFile f3797d;

    /* renamed from: e */
    private final FileChannel f3798e;

    /* renamed from: f */
    private final FileLock f3799f;

    /* renamed from: androidx.multidex.a$a */
    /* compiled from: MultiDexExtractor */
    class C0858a implements FileFilter {
        C0858a(C0857a aVar) {
        }

        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* renamed from: androidx.multidex.a$b */
    /* compiled from: MultiDexExtractor */
    private static class C0859b extends File {

        /* renamed from: a */
        public long f3800a = -1;

        public C0859b(File file, String str) {
            super(file, str);
        }
    }

    C0857a(File file, File file2) {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f3794a = file;
        this.f3796c = file2;
        this.f3795b = m2825f(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f3797d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f3798e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f3799f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                m2821b(this.f3798e);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                m2821b(this.f3798e);
                throw e;
            } catch (Error e3) {
                e = e3;
                m2821b(this.f3798e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            m2821b(this.f3797d);
            throw e4;
        }
    }

    /* renamed from: a */
    private void m2820a() {
        File[] listFiles = this.f3796c.listFiles(new C0858a(this));
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f3796c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    /* renamed from: b */
    private static void m2821b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    /* renamed from: c */
    private static void m2822c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    m2821b(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            m2821b(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    /* renamed from: d */
    private static SharedPreferences m2823d(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* renamed from: e */
    private static long m2824e(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* renamed from: f */
    private static long m2825f(File file) {
        long c = C0860b.m2833c(file);
        return c == -1 ? c - 1 : c;
    }

    /* renamed from: g */
    private static boolean m2826g(Context context, File file, long j, String str) {
        SharedPreferences d = m2823d(context);
        if (d.getLong(str + "timestamp", -1) == m2824e(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("crc");
            return d.getLong(sb.toString(), -1) != j;
        }
    }

    /* renamed from: i */
    private List<C0859b> m2827i(Context context, String str) {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = this.f3794a.getName() + ".classes";
        SharedPreferences d = m2823d(context);
        int i = d.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            C0859b bVar = new C0859b(this.f3796c, str3 + i2 + ".zip");
            if (bVar.isFile()) {
                bVar.f3800a = m2825f(bVar);
                long j = d.getLong(str2 + "dex.crc." + i2, -1);
                long j2 = d.getLong(str2 + "dex.time." + i2, -1);
                long lastModified = bVar.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = d;
                    if (j == bVar.f3800a) {
                        arrayList.add(bVar);
                        i2++;
                        d = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + bVar.f3800a);
            }
            throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + "'");
        }
        return arrayList;
    }

    /* renamed from: j */
    private List<C0859b> m2828j() {
        C0859b bVar;
        boolean z;
        String str = this.f3794a.getName() + ".classes";
        m2820a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f3794a);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i = 2;
            while (entry != null) {
                bVar = new C0859b(this.f3796c, str + i + ".zip");
                arrayList.add(bVar);
                Log.i("MultiDex", "Extraction is needed for file " + bVar);
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    m2822c(zipFile, entry, bVar, str);
                    bVar.f3800a = m2825f(bVar);
                    z = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(bVar.getAbsolutePath());
                    sb.append("': length ");
                    int i4 = i3;
                    sb.append(bVar.length());
                    sb.append(" - crc: ");
                    sb.append(bVar.f3800a);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        bVar.delete();
                        if (bVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + bVar.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i2 = i4;
                }
                if (z2) {
                    i++;
                    entry = zipFile.getEntry("classes" + i + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + bVar.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
            return arrayList;
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to read crc from " + bVar.getAbsolutePath(), e2);
            z = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            throw th2;
        }
    }

    /* renamed from: k */
    private static void m2829k(Context context, String str, long j, long j2, List<C0859b> list) {
        SharedPreferences.Editor edit = m2823d(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (C0859b next : list) {
            edit.putLong(str + "dex.crc." + i, next.f3800a);
            edit.putLong(str + "dex.time." + i, next.lastModified());
            i++;
        }
        edit.commit();
    }

    public void close() {
        this.f3799f.release();
        this.f3798e.close();
        this.f3797d.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public List<? extends File> mo6585h(Context context, String str, boolean z) {
        List<C0859b> list;
        List<C0859b> list2;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f3794a.getPath() + ", " + z + ", " + str + ")");
        if (this.f3799f.isValid()) {
            if (z || m2826g(context, this.f3794a, this.f3795b, str)) {
                if (z) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                list2 = m2828j();
                m2829k(context, str, m2824e(this.f3794a), this.f3795b, list2);
            } else {
                try {
                    list = m2827i(context, str);
                } catch (IOException e) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                    list2 = m2828j();
                    m2829k(context, str, m2824e(this.f3794a), this.f3795b, list2);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            list = list2;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
