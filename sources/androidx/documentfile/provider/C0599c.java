package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
/* renamed from: androidx.documentfile.provider.c */
/* compiled from: SingleDocumentFile */
class C0599c extends DocumentFile {

    /* renamed from: b */
    private Context f2886b;

    /* renamed from: c */
    private Uri f2887c;

    C0599c(@Nullable DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f2886b = context;
        this.f2887c = uri;
    }

    public boolean canRead() {
        return C0597a.m2044a(this.f2886b, this.f2887c);
    }

    public boolean canWrite() {
        return C0597a.m2045b(this.f2886b, this.f2887c);
    }

    public DocumentFile createDirectory(String str) {
        throw new UnsupportedOperationException();
    }

    public DocumentFile createFile(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.f2886b.getContentResolver(), this.f2887c);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean exists() {
        return C0597a.m2047d(this.f2886b, this.f2887c);
    }

    @Nullable
    public String getName() {
        return C0597a.m2049f(this.f2886b, this.f2887c);
    }

    @Nullable
    public String getType() {
        return C0597a.m2051h(this.f2886b, this.f2887c);
    }

    public Uri getUri() {
        return this.f2887c;
    }

    public boolean isDirectory() {
        return C0597a.m2052i(this.f2886b, this.f2887c);
    }

    public boolean isFile() {
        return C0597a.m2053j(this.f2886b, this.f2887c);
    }

    public boolean isVirtual() {
        return C0597a.m2054k(this.f2886b, this.f2887c);
    }

    public long lastModified() {
        return C0597a.m2055l(this.f2886b, this.f2887c);
    }

    public long length() {
        return C0597a.m2056m(this.f2886b, this.f2887c);
    }

    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }

    public boolean renameTo(String str) {
        throw new UnsupportedOperationException();
    }
}
