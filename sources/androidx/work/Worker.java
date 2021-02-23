package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker extends ListenableWorker {
    SettableFuture<ListenableWorker.Result> mFuture;

    /* renamed from: androidx.work.Worker$a */
    class C1077a implements Runnable {
        C1077a() {
        }

        public void run() {
            try {
                Worker.this.mFuture.set(Worker.this.doWork());
            } catch (Throwable th) {
                Worker.this.mFuture.setException(th);
            }
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @WorkerThread
    @NonNull
    public abstract ListenableWorker.Result doWork();

    @NonNull
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = SettableFuture.create();
        getBackgroundExecutor().execute(new C1077a());
        return this.mFuture;
    }
}
