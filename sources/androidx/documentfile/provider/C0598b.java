package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: androidx.documentfile.provider.b */
/* compiled from: RawDocumentFile */
class C0598b extends DocumentFile {

    /* renamed from: b */
    private File f2885b;

    C0598b(@Nullable DocumentFile documentFile, File file) {
        super(documentFile);
        this.f2885b = file;
    }

    /* renamed from: a */
    private static boolean m2060a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= m2060a(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r1.substring(r0 + 1).toLowerCase());
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m2061b(java.lang.String r1) {
        /*
            r0 = 46
            int r0 = r1.lastIndexOf(r0)
            if (r0 < 0) goto L_0x001d
            int r0 = r0 + 1
            java.lang.String r1 = r1.substring(r0)
            java.lang.String r1 = r1.toLowerCase()
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r1 = r0.getMimeTypeFromExtension(r1)
            if (r1 == 0) goto L_0x001d
            return r1
        L_0x001d:
            java.lang.String r1 = "application/octet-stream"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.documentfile.provider.C0598b.m2061b(java.lang.String):java.lang.String");
    }

    public boolean canRead() {
        return this.f2885b.canRead();
    }

    public boolean canWrite() {
        return this.f2885b.canWrite();
    }

    @Nullable
    public DocumentFile createDirectory(String str) {
        File file = new File(this.f2885b, str);
        if (file.isDirectory() || file.mkdir()) {
            return new C0598b(this, file);
        }
        return null;
    }

    @Nullable
    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.f2885b, str2);
        try {
            file.createNewFile();
            return new C0598b(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    public boolean delete() {
        m2060a(this.f2885b);
        return this.f2885b.delete();
    }

    public boolean exists() {
        return this.f2885b.exists();
    }

    public String getName() {
        return this.f2885b.getName();
    }

    @Nullable
    public String getType() {
        if (this.f2885b.isDirectory()) {
            return null;
        }
        return m2061b(this.f2885b.getName());
    }

    public Uri getUri() {
        return Uri.fromFile(this.f2885b);
    }

    public boolean isDirectory() {
        return this.f2885b.isDirectory();
    }

    public boolean isFile() {
        return this.f2885b.isFile();
    }

    public boolean isVirtual() {
        return false;
    }

    public long lastModified() {
        return this.f2885b.lastModified();
    }

    public long length() {
        return this.f2885b.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f2885b.listFiles();
        if (listFiles != null) {
            for (File bVar : listFiles) {
                arrayList.add(new C0598b(this, bVar));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean renameTo(String str) {
        File file = new File(this.f2885b.getParentFile(), str);
        if (!this.f2885b.renameTo(file)) {
            return false;
        }
        this.f2885b = file;
        return true;
    }
}
