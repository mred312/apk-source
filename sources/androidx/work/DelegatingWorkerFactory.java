package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

public class DelegatingWorkerFactory extends WorkerFactory {

    /* renamed from: c */
    private static final String f5047c = Logger.tagWithPrefix("DelegatingWkrFctry");

    /* renamed from: b */
    private final List<WorkerFactory> f5048b = new LinkedList();

    public final void addFactory(@NonNull WorkerFactory workerFactory) {
        this.f5048b.add(workerFactory);
    }

    @Nullable
    public final ListenableWorker createWorker(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        for (WorkerFactory createWorker : this.f5048b) {
            try {
                ListenableWorker createWorker2 = createWorker.createWorker(context, str, workerParameters);
                if (createWorker2 != null) {
                    return createWorker2;
                }
            } catch (Throwable th) {
                String format = String.format("Unable to instantiate a ListenableWorker (%s)", new Object[]{str});
                Logger.get().error(f5047c, format, th);
                throw th;
            }
        }
        return null;
    }
}
