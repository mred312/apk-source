package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
/* renamed from: androidx.documentfile.provider.a */
/* compiled from: DocumentsContractApi19 */
class C0597a {
    /* renamed from: a */
    public static boolean m2044a(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(m2050g(context, uri));
    }

    /* renamed from: b */
    public static boolean m2045b(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String g = m2050g(context, uri);
        int n = m2057n(context, uri, "flags", 0);
        if (TextUtils.isEmpty(g)) {
            return false;
        }
        if ((n & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(g) && (n & 8) != 0) {
            return true;
        }
        if (TextUtils.isEmpty(g) || (n & 2) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static void m2046c(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    public static boolean m2047d(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = true;
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            if (cursor.getCount() <= 0) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return false;
        } finally {
            m2046c(cursor);
        }
    }

    /* renamed from: e */
    public static long m2048e(Context context, Uri uri) {
        return m2058o(context, uri, "flags", 0);
    }

    @Nullable
    /* renamed from: f */
    public static String m2049f(Context context, Uri uri) {
        return m2059p(context, uri, "_display_name", (String) null);
    }

    @Nullable
    /* renamed from: g */
    private static String m2050g(Context context, Uri uri) {
        return m2059p(context, uri, "mime_type", (String) null);
    }

    @Nullable
    /* renamed from: h */
    public static String m2051h(Context context, Uri uri) {
        String g = m2050g(context, uri);
        if ("vnd.android.document/directory".equals(g)) {
            return null;
        }
        return g;
    }

    /* renamed from: i */
    public static boolean m2052i(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(m2050g(context, uri));
    }

    /* renamed from: j */
    public static boolean m2053j(Context context, Uri uri) {
        String g = m2050g(context, uri);
        return !"vnd.android.document/directory".equals(g) && !TextUtils.isEmpty(g);
    }

    /* renamed from: k */
    public static boolean m2054k(Context context, Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri) && (m2048e(context, uri) & 512) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    public static long m2055l(Context context, Uri uri) {
        return m2058o(context, uri, "last_modified", 0);
    }

    /* renamed from: m */
    public static long m2056m(Context context, Uri uri) {
        return m2058o(context, uri, "_size", 0);
    }

    /* renamed from: n */
    private static int m2057n(Context context, Uri uri, String str, int i) {
        return (int) m2058o(context, uri, str, (long) i);
    }

    /* renamed from: o */
    private static long m2058o(Context context, Uri uri, String str, long j) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getLong(0);
            }
            m2046c(cursor);
            return j;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return j;
        } finally {
            m2046c(cursor);
        }
    }

    @Nullable
    /* renamed from: p */
    private static String m2059p(Context context, Uri uri, String str, @Nullable String str2) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getString(0);
            }
            m2046c(cursor);
            return str2;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return str2;
        } finally {
            m2046c(cursor);
        }
    }
}
