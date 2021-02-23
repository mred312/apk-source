package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {

    /* renamed from: a */
    int f3596a;

    /* renamed from: b */
    OnLoadCompleteListener<D> f3597b;

    /* renamed from: c */
    OnLoadCanceledListener<D> f3598c;

    /* renamed from: d */
    Context f3599d;

    /* renamed from: e */
    boolean f3600e = false;

    /* renamed from: f */
    boolean f3601f = false;

    /* renamed from: g */
    boolean f3602g = true;

    /* renamed from: h */
    boolean f3603h = false;

    /* renamed from: i */
    boolean f3604i = false;

    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d);
    }

    public Loader(@NonNull Context context) {
        this.f3599d = context.getApplicationContext();
    }

    @MainThread
    public void abandon() {
        this.f3601f = true;
        onAbandon();
    }

    @MainThread
    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.f3604i = false;
    }

    @NonNull
    public String dataToString(@Nullable D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d, sb);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.f3598c;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    @MainThread
    public void deliverResult(@Nullable D d) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.f3597b;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f3596a);
        printWriter.print(" mListener=");
        printWriter.println(this.f3597b);
        if (this.f3600e || this.f3603h || this.f3604i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3600e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f3603h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f3604i);
        }
        if (this.f3601f || this.f3602g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f3601f);
            printWriter.print(" mReset=");
            printWriter.println(this.f3602g);
        }
    }

    @MainThread
    public void forceLoad() {
        onForceLoad();
    }

    @NonNull
    public Context getContext() {
        return this.f3599d;
    }

    public int getId() {
        return this.f3596a;
    }

    public boolean isAbandoned() {
        return this.f3601f;
    }

    public boolean isReset() {
        return this.f3602g;
    }

    public boolean isStarted() {
        return this.f3600e;
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void onAbandon() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public boolean onCancelLoad() {
        return false;
    }

    @MainThread
    public void onContentChanged() {
        if (this.f3600e) {
            forceLoad();
        } else {
            this.f3603h = true;
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void onForceLoad() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void onStartLoading() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void onStopLoading() {
    }

    @MainThread
    public void registerListener(int i, @NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f3597b == null) {
            this.f3597b = onLoadCompleteListener;
            this.f3596a = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void registerOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f3598c == null) {
            this.f3598c = onLoadCanceledListener;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void reset() {
        onReset();
        this.f3602g = true;
        this.f3600e = false;
        this.f3601f = false;
        this.f3603h = false;
        this.f3604i = false;
    }

    public void rollbackContentChanged() {
        if (this.f3604i) {
            onContentChanged();
        }
    }

    @MainThread
    public final void startLoading() {
        this.f3600e = true;
        this.f3602g = false;
        this.f3601f = false;
        onStartLoading();
    }

    @MainThread
    public void stopLoading() {
        this.f3600e = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.f3603h;
        this.f3603h = false;
        this.f3604i |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.f3596a);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void unregisterListener(@NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.f3597b;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (onLoadCompleteListener2 == onLoadCompleteListener) {
            this.f3597b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    @MainThread
    public void unregisterOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.f3598c;
        if (onLoadCanceledListener2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (onLoadCanceledListener2 == onLoadCanceledListener) {
            this.f3598c = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }
}
