package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.p003os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: j */
    private final Executor f3579j;

    /* renamed from: k */
    volatile AsyncTaskLoader<D>.a f3580k;

    /* renamed from: l */
    volatile AsyncTaskLoader<D>.a f3581l;

    /* renamed from: m */
    long f3582m;

    /* renamed from: n */
    long f3583n;

    /* renamed from: o */
    Handler f3584o;

    /* renamed from: androidx.loader.content.AsyncTaskLoader$a */
    final class C0781a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: j */
        private final CountDownLatch f3585j = new CountDownLatch(1);

        /* renamed from: k */
        boolean f3586k;

        C0781a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo6340h(D d) {
            try {
                AsyncTaskLoader.this.mo6326a(this, d);
            } finally {
                this.f3585j.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public void mo6341i(D d) {
            try {
                AsyncTaskLoader.this.mo6327b(this, d);
            } finally {
                this.f3585j.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public D mo6339b(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e) {
                if (mo6390f()) {
                    return null;
                }
                throw e;
            }
        }

        /* renamed from: o */
        public void mo6343o() {
            try {
                this.f3585j.await();
            } catch (InterruptedException unused) {
            }
        }

        public void run() {
            this.f3586k = false;
            AsyncTaskLoader.this.mo6328c();
        }
    }

    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.f3608h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6326a(AsyncTaskLoader<D>.a aVar, D d) {
        onCanceled(d);
        if (this.f3581l == aVar) {
            rollbackContentChanged();
            this.f3583n = SystemClock.uptimeMillis();
            this.f3581l = null;
            deliverCancellation();
            mo6328c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6327b(AsyncTaskLoader<D>.a aVar, D d) {
        if (this.f3580k != aVar) {
            mo6326a(aVar, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.f3583n = SystemClock.uptimeMillis();
            this.f3580k = null;
            deliverResult(d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6328c() {
        if (this.f3581l == null && this.f3580k != null) {
            if (this.f3580k.f3586k) {
                this.f3580k.f3586k = false;
                this.f3584o.removeCallbacks(this.f3580k);
            }
            if (this.f3582m <= 0 || SystemClock.uptimeMillis() >= this.f3583n + this.f3582m) {
                this.f3580k.mo6388c(this.f3579j, (Params[]) null);
                return;
            }
            this.f3580k.f3586k = true;
            this.f3584o.postAtTime(this.f3580k, this.f3583n + this.f3582m);
        }
    }

    public void cancelLoadInBackground() {
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.f3580k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f3580k);
            printWriter.print(" waiting=");
            printWriter.println(this.f3580k.f3586k);
        }
        if (this.f3581l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f3581l);
            printWriter.print(" waiting=");
            printWriter.println(this.f3581l.f3586k);
        }
        if (this.f3582m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.f3582m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.f3583n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.f3581l != null;
    }

    @Nullable
    public abstract D loadInBackground();

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.f3580k == null) {
            return false;
        }
        if (!this.f3600e) {
            this.f3603h = true;
        }
        if (this.f3581l != null) {
            if (this.f3580k.f3586k) {
                this.f3580k.f3586k = false;
                this.f3584o.removeCallbacks(this.f3580k);
            }
            this.f3580k = null;
            return false;
        } else if (this.f3580k.f3586k) {
            this.f3580k.f3586k = false;
            this.f3584o.removeCallbacks(this.f3580k);
            this.f3580k = null;
            return false;
        } else {
            boolean a = this.f3580k.mo6387a(false);
            if (a) {
                this.f3581l = this.f3580k;
                cancelLoadInBackground();
            }
            this.f3580k = null;
            return a;
        }
    }

    public void onCanceled(@Nullable D d) {
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.f3580k = new C0781a();
        mo6328c();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.f3582m = j;
        if (j != 0) {
            this.f3584o = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.a aVar = this.f3580k;
        if (aVar != null) {
            aVar.mo6343o();
        }
    }

    private AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.f3583n = -10000;
        this.f3579j = executor;
    }
}
