package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

@RequiresApi(21)
/* renamed from: androidx.documentfile.provider.d */
/* compiled from: TreeDocumentFile */
class C0600d extends DocumentFile {

    /* renamed from: b */
    private Context f2888b;

    /* renamed from: c */
    private Uri f2889c;

    C0600d(@Nullable DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f2888b = context;
        this.f2889c = uri;
    }

    /* renamed from: a */
    private static void m2062a(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    /* renamed from: b */
    private static Uri m2063b(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean canRead() {
        return C0597a.m2044a(this.f2888b, this.f2889c);
    }

    public boolean canWrite() {
        return C0597a.m2045b(this.f2888b, this.f2889c);
    }

    @Nullable
    public DocumentFile createDirectory(String str) {
        Uri b = m2063b(this.f2888b, this.f2889c, "vnd.android.document/directory", str);
        if (b != null) {
            return new C0600d(this, this.f2888b, b);
        }
        return null;
    }

    @Nullable
    public DocumentFile createFile(String str, String str2) {
        Uri b = m2063b(this.f2888b, this.f2889c, str, str2);
        if (b != null) {
            return new C0600d(this, this.f2888b, b);
        }
        return null;
    }

    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.f2888b.getContentResolver(), this.f2889c);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean exists() {
        return C0597a.m2047d(this.f2888b, this.f2889c);
    }

    @Nullable
    public String getName() {
        return C0597a.m2049f(this.f2888b, this.f2889c);
    }

    @Nullable
    public String getType() {
        return C0597a.m2051h(this.f2888b, this.f2889c);
    }

    public Uri getUri() {
        return this.f2889c;
    }

    public boolean isDirectory() {
        return C0597a.m2052i(this.f2888b, this.f2889c);
    }

    public boolean isFile() {
        return C0597a.m2053j(this.f2888b, this.f2889c);
    }

    public boolean isVirtual() {
        return C0597a.m2054k(this.f2888b, this.f2889c);
    }

    public long lastModified() {
        return C0597a.m2055l(this.f2888b, this.f2889c);
    }

    public long length() {
        return C0597a.m2056m(this.f2888b, this.f2889c);
    }

    public DocumentFile[] listFiles() {
        ContentResolver contentResolver = this.f2888b.getContentResolver();
        Uri uri = this.f2889c;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            while (cursor.moveToNext()) {
                arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f2889c, cursor.getString(0)));
            }
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
        } catch (Throwable th) {
            m2062a((AutoCloseable) null);
            throw th;
        }
        m2062a(cursor);
        Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
        DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
        for (int i = 0; i < uriArr.length; i++) {
            documentFileArr[i] = new C0600d(this, this.f2888b, uriArr[i]);
        }
        return documentFileArr;
    }

    public boolean renameTo(String str) {
        try {
            Uri renameDocument = DocumentsContract.renameDocument(this.f2888b.getContentResolver(), this.f2889c, str);
            if (renameDocument != null) {
                this.f2889c = renameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
