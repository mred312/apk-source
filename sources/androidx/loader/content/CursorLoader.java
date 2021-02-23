package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContentResolverCompat;
import androidx.core.p003os.CancellationSignal;
import androidx.core.p003os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: p */
    final Loader<Cursor>.ForceLoadContentObserver f3588p = new Loader.ForceLoadContentObserver();

    /* renamed from: q */
    Uri f3589q;

    /* renamed from: r */
    String[] f3590r;

    /* renamed from: s */
    String f3591s;

    /* renamed from: t */
    String[] f3592t;

    /* renamed from: u */
    String f3593u;

    /* renamed from: v */
    Cursor f3594v;

    /* renamed from: w */
    CancellationSignal f3595w;

    public CursorLoader(@NonNull Context context) {
        super(context);
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            CancellationSignal cancellationSignal = this.f3595w;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f3589q);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f3590r));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f3591s);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f3592t));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f3593u);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f3594v);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f3603h);
    }

    @Nullable
    public String[] getProjection() {
        return this.f3590r;
    }

    @Nullable
    public String getSelection() {
        return this.f3591s;
    }

    @Nullable
    public String[] getSelectionArgs() {
        return this.f3592t;
    }

    @Nullable
    public String getSortOrder() {
        return this.f3593u;
    }

    @NonNull
    public Uri getUri() {
        return this.f3589q;
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.f3594v;
        if (cursor != null && !cursor.isClosed()) {
            this.f3594v.close();
        }
        this.f3594v = null;
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        Cursor cursor = this.f3594v;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.f3594v == null) {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(@Nullable String[] strArr) {
        this.f3590r = strArr;
    }

    public void setSelection(@Nullable String str) {
        this.f3591s = str;
    }

    public void setSelectionArgs(@Nullable String[] strArr) {
        this.f3592t = strArr;
    }

    public void setSortOrder(@Nullable String str) {
        this.f3593u = str;
    }

    public void setUri(@NonNull Uri uri) {
        this.f3589q = uri;
    }

    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.f3594v;
            this.f3594v = cursor;
            if (isStarted()) {
                super.deliverResult(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public Cursor loadInBackground() {
        Cursor query;
        synchronized (this) {
            if (!isLoadInBackgroundCanceled()) {
                this.f3595w = new CancellationSignal();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            query = ContentResolverCompat.query(getContext().getContentResolver(), this.f3589q, this.f3590r, this.f3591s, this.f3592t, this.f3593u, this.f3595w);
            if (query != null) {
                query.getCount();
                query.registerContentObserver(this.f3588p);
            }
            synchronized (this) {
                this.f3595w = null;
            }
            return query;
        } catch (RuntimeException e) {
            query.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
                this.f3595w = null;
                throw th;
            }
        }
    }

    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public CursorLoader(@NonNull Context context, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        super(context);
        this.f3589q = uri;
        this.f3590r = strArr;
        this.f3591s = str;
        this.f3592t = strArr2;
        this.f3593u = str2;
    }
}
